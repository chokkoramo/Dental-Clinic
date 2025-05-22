package org.dentalclinic.persistence;

import jakarta.persistence.*;
import java.io.Serializable;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import java.util.List;
import org.dentalclinic.logic.Schedule;
import org.dentalclinic.persistence.exceptions.NonexistentEntityException;

public class ScheduleJpaController implements Serializable {

    private EntityManagerFactory emf = null;

    public ScheduleJpaController() {
        emf = Persistence.createEntityManagerFactory("DentalClinicPU");
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Schedule schedule) throws Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(schedule);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (em != null && em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Schedule schedule) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            schedule = em.merge(schedule);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (em != null && em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = schedule.getscheduleId();
                if (findSchedule(id) == null) {
                    throw new NonexistentEntityException("The schedule with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(int id) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Schedule schedule;
            try {
                schedule = em.getReference(Schedule.class, id);
                schedule.getscheduleId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The schedule with id " + id + " no longer exists.", enfe);
            }
            em.remove(schedule);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (em != null && em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Schedule> findScheduleEntities() {
        return findScheduleEntities(true, -1, -1);
    }

    public List<Schedule> findScheduleEntities(int maxResults, int firstResult) {
        return findScheduleEntities(false, maxResults, firstResult);
    }

    private List<Schedule> findScheduleEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery<Schedule> cq = em.getCriteriaBuilder().createQuery(Schedule.class);
            cq.select(cq.from(Schedule.class));
            TypedQuery<Schedule> q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Schedule findSchedule(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Schedule.class, id);
        } finally {
            em.close();
        }
    }

    public int getScheduleCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery<Long> cq = em.getCriteriaBuilder().createQuery(Long.class);
            Root<Schedule> rt = cq.from(Schedule.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            TypedQuery<Long> q = em.createQuery(cq);
            return q.getSingleResult().intValue();
        } finally {
            em.close();
        }
    }
}
