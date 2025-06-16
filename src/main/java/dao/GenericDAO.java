package dao;

import java.util.Collections;
import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;

import utils.Connexion;


public class GenericDAO<T> {
	
	private final Class<T> entityClass;

    public GenericDAO(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    public void insert(T entity) {
        try (Session session = Connexion.getSession()) {
            Transaction tx = session.beginTransaction();
            session.persist(entity);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void update(T entity) {
        try (Session session = Connexion.getSession()) {
            Transaction tx = session.beginTransaction();
            session.merge(entity);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(T entity) {
        try (Session session = Connexion.getSession()) {
            Transaction tx = session.beginTransaction();
            session.remove(session.contains(entity) ? entity : session.merge(entity));
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    public List<T> listAll() {
        try (Session session = Connexion.getSession()) {
            CriteriaBuilder cb = (CriteriaBuilder) session.getCriteriaBuilder();
            CriteriaQuery<T> cq = cb.createQuery(entityClass);
            Root<T> root = cq.from(entityClass);
            cq.select(root);

            TypedQuery<T> query = session.createQuery(cq);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }
    
    
    public T findByField(String fieldName, Object value) {
        try (Session session = Connexion.getSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<T> cq = cb.createQuery(entityClass);
            Root<T> root = cq.from(entityClass);
            cq.select(root).where(cb.equal(root.get(fieldName), value));

            TypedQuery<T> query = session.createQuery(cq);
            return query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    
    public List<T> findAllByField(String fieldName, Object value) {
        try (Session session = Connexion.getSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<T> cq = cb.createQuery(entityClass);
            Root<T> root = cq.from(entityClass);
            cq.select(root).where(cb.equal(root.get(fieldName), value));

            TypedQuery<T> query = session.createQuery(cq);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }


    
    
    //delete with REference clause
    public boolean deleteByField(String fieldName, Object value) {
        try (Session session = Connexion.getSession()) {
            Transaction tx = session.beginTransaction();
            T entity = findByField(fieldName, value);
            if (entity != null) {
                session.remove(entity);
                tx.commit();
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    
    //Update with REference clause
    public boolean updateByField(String fieldName, Object value, T updatedEntity) {
        try (Session session = Connexion.getSession()) {
            Transaction tx = session.beginTransaction();

            T entity = findByField(fieldName, value);
            if (entity != null) {
                session.merge(updatedEntity); // <- merge de l'entité modifiée
                tx.commit();
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
}
