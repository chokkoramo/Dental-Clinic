package org.dentalclinic.persistence;

import jakarta.persistence.*;

import java.io.Serializable;

import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import java.util.List;
import org.dentalclinic.logic.Shift;
import org.dentalclinic.persistence.exceptions.NonexistentEntityException;
import org.dentalclinic.persistence.exceptions.RollbackFailureException;

public class ShiftJpaController implements Serializable {

    private EntityManagerFactory emf = null;

    public ShiftJpaController() {
        emf = Persistence.createEntityManagerFactory("DentalClinicPU");
    }

    public ShiftJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Shift shift) throws RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(shift);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (em != null && em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", ex);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Shift shift) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            shift = em.merge(shift);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (em != null && em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = shift.getShiftId();
                if (findShift(id) == null) {
                    throw new NonexistentEntityException("The shift with id " + id + " no longer exists.");
                }
            }
            throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", ex);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(int id) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Shift shift;
            try {
                shift = em.getReference(Shift.class, id);
                shift.getShiftId();  // para forzar la carga y verificar existencia
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The shift with id " + id + " no longer exists.", enfe);
            }
            em.remove(shift);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (em != null && em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", ex);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    // Los demás métodos pueden quedar igual:

    public List<Shift> findShiftEntities() {
        return findShiftEntities(true, -1, -1);
    }

    public List<Shift> findShiftEntities(int maxResults, int firstResult) {
        return findShiftEntities(false, maxResults, firstResult);
    }

    private List<Shift> findShiftEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Shift.class));
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

    public Shift findShift(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Shift.class, id);
        } finally {
            em.close();
        }
    }

    public int getShiftCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Shift> rt = cq.from(Shift.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
}
