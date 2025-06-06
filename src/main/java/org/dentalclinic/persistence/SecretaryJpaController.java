package org.dentalclinic.persistence;

import jakarta.persistence.*;
import java.io.Serializable;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import java.util.List;
import org.dentalclinic.logic.Secretary;
import org.dentalclinic.persistence.exceptions.NonexistentEntityException;
import org.dentalclinic.persistence.exceptions.RollbackFailureException;

public class SecretaryJpaController implements Serializable {

    private EntityManagerFactory emf = null;

    public SecretaryJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public SecretaryJpaController() {
        emf = Persistence.createEntityManagerFactory("DentalClinicPU");
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Secretary secretary) throws RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(secretary);
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

    public void edit(Secretary secretary) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            secretary = em.merge(secretary);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (em != null && em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = secretary.getId();
                if (findSecretary(id) == null) {
                    throw new NonexistentEntityException("The secretary with id " + id + " no longer exists.");
                }
            }
            throw ex;
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
            Secretary secretary;
            try {
                secretary = em.getReference(Secretary.class, id);
                secretary.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The secretary with id " + id + " no longer exists.", enfe);
            }
            em.remove(secretary);
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

    public List<Secretary> findSecretaryEntities() {
        return findSecretaryEntities(true, -1, -1);
    }

    public List<Secretary> findSecretaryEntities(int maxResults, int firstResult) {
        return findSecretaryEntities(false, maxResults, firstResult);
    }

    private List<Secretary> findSecretaryEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Secretary.class));
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

    public Secretary findSecretary(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Secretary.class, id);
        } finally {
            em.close();
        }
    }

    public int getSecretaryCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Secretary> rt = cq.from(Secretary.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
}
