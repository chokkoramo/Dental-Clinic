package org.dentalclinic.persistence;

import jakarta.persistence.*;
import java.io.Serializable;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import java.util.List;
import org.dentalclinic.logic.LegalGuardian;
import org.dentalclinic.persistence.exceptions.NonexistentEntityException;

public class LegalGuardianJpaController implements Serializable {

    private EntityManagerFactory emf = null;

    public LegalGuardianJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public LegalGuardianJpaController() {
        this.emf = Persistence.createEntityManagerFactory("DentalClinicPU");
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(LegalGuardian legalGuardian) throws Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(legalGuardian);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (em != null && em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw ex;
        } finally {
            if (em != null) em.close();
        }
    }

    public void edit(LegalGuardian legalGuardian) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            legalGuardian = em.merge(legalGuardian);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (em != null && em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            Integer id = legalGuardian.getId();
            if (findLegalGuardian(id) == null) {
                throw new NonexistentEntityException("El tutor legal con id " + id + " ya no existe.");
            }
            throw ex;
        } finally {
            if (em != null) em.close();
        }
    }

    public void destroy(int id) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            LegalGuardian legalGuardian;
            try {
                legalGuardian = em.getReference(LegalGuardian.class, id);
                legalGuardian.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("El tutor legal con id " + id + " ya no existe.", enfe);
            }
            em.remove(legalGuardian);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (em != null && em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw ex;
        } finally {
            if (em != null) em.close();
        }
    }

    public List<LegalGuardian> findLegalGuardianEntities() {
        return findLegalGuardianEntities(true, -1, -1);
    }

    public List<LegalGuardian> findLegalGuardianEntities(int maxResults, int firstResult) {
        return findLegalGuardianEntities(false, maxResults, firstResult);
    }

    private List<LegalGuardian> findLegalGuardianEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery<LegalGuardian> cq = em.getCriteriaBuilder().createQuery(LegalGuardian.class);
            Root<LegalGuardian> rt = cq.from(LegalGuardian.class);
            cq.select(rt);
            TypedQuery<LegalGuardian> q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public LegalGuardian findLegalGuardian(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(LegalGuardian.class, id);
        } finally {
            em.close();
        }
    }

    public int getLegalGuardianCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery<Long> cq = em.getCriteriaBuilder().createQuery(Long.class);
            Root<LegalGuardian> rt = cq.from(LegalGuardian.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            TypedQuery<Long> q = em.createQuery(cq);
            return q.getSingleResult().intValue();
        } finally {
            em.close();
        }
    }
}
