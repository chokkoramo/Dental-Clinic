package org.dentalclinic.persistence;

import jakarta.persistence.*;
import java.io.Serializable;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import java.util.List;
import org.dentalclinic.logic.Dentist;
import org.dentalclinic.logic.User;
import org.dentalclinic.persistence.exceptions.NonexistentEntityException;

public class DentistJpaController implements Serializable {

    private EntityManagerFactory emf = null;

    public DentistJpaController() {
        emf = Persistence.createEntityManagerFactory("DentalClinicPU");
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Dentist dentist) throws Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(dentist);
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

    public void edit(Dentist dentist) throws Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            dentist = em.merge(dentist);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (em != null && em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            if (findDentist(dentist.getId()) == null) {
                throw new NonexistentEntityException("The dentist with id " + dentist.getId() + " no longer exists.");
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(int id) throws Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Dentist dentist = em.getReference(Dentist.class, id);
            em.remove(dentist);
            em.getTransaction().commit();
        } catch (EntityNotFoundException enfe) {
            throw new NonexistentEntityException("The dentist with id " + id + " no longer exists.", enfe);
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

    public List<Dentist> findDentistEntities() {
        return findDentistEntities(true, -1, -1);
    }

    public List<Dentist> findDentistEntities(int maxResults, int firstResult) {
        return findDentistEntities(false, maxResults, firstResult);
    }

    private List<Dentist> findDentistEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery<Dentist> cq = em.getCriteriaBuilder().createQuery(Dentist.class);
            cq.select(cq.from(Dentist.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Dentist findDentist(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Dentist.class, id);
        } finally {
            em.close();
        }
    }

    public int getDentistCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery<Long> cq = em.getCriteriaBuilder().createQuery(Long.class);
            Root<Dentist> rt = cq.from(Dentist.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
}
