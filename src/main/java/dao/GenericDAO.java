package dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Root;
import jakarta.persistence.criteria.Predicate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.Connexion;

public class GenericDAO<T> {

    private final Class<T> entityClass;

    public GenericDAO(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    public void add(T entity) {
        Transaction transaction = null;
        try (Session session = Connexion.getSession()) {
            transaction = session.beginTransaction();
            session.persist(entity);
            transaction.commit();
        } catch (RuntimeException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw e; // Re-throw the exception to the caller
        }
    }

    public void update(T entity) {
        Transaction transaction = null;
        try (Session session = Connexion.getSession()) {
            transaction = session.beginTransaction();
            session.merge(entity);
            transaction.commit();
        } catch (RuntimeException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw e; // Re-throw the exception to the caller
        }
    }

    public void delete(T entity) {
        Transaction transaction = null;
        try (Session session = Connexion.getSession()) {
            transaction = session.beginTransaction();
            // Re-attach the entity if it's detached before removing
            session.remove(session.contains(entity) ? entity : session.merge(entity));
            transaction.commit();
        } catch (RuntimeException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw e; // Re-throw the exception to the caller
        }
    }

    public T getById(Serializable id) {
        try (Session session = Connexion.getSession()) {
            return session.get(entityClass, id);
        }
    }

    /**
     * Retrieves an entity by its ID, eagerly fetching specified associations.
     * This helps to avoid N+1 select problems for ManyToOne and OneToMany
     * relationships.
     *
     * @param id         The ID of the entity.
     * @param fetchPaths The paths to the associations to eagerly fetch (e.g.,
     *                   "propertyName", "collectionName").
     * @return The entity with specified associations eagerly loaded, or null if not
     *         found.
     */
    public T getByIdWithAssociations(Serializable id, String... fetchPaths) {
        try (Session session = Connexion.getSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<T> cq = cb.createQuery(entityClass);
            Root<T> root = cq.from(entityClass);

            for (String path : fetchPaths) {
                // Use JoinType.LEFT to ensure the parent entity is returned even if the
                // association is null
                root.fetch(path, JoinType.LEFT);
            }

            cq.select(root).where(cb.equal(root.get("id"), id)); // Assuming "id" is the primary key property name
            // For entities with composite keys, this would need to be adjusted.
            // For simplicity, assuming single 'id' field.

            TypedQuery<T> query = session.createQuery(cq);
            List<T> results = query.getResultList();
            if (results.isEmpty()) {
                return null;
            } else if (results.size() == 1) {
                return results.get(0);
            } else {
                throw new jakarta.persistence.NonUniqueResultException(
                        "Query for ID " + id + " returned non-unique results.");
            }
        }
    }

    public List<T> listAll() {
        try (Session session = Connexion.getSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<T> cq = cb.createQuery(entityClass);
            Root<T> root = cq.from(entityClass);
            cq.select(root);
            TypedQuery<T> query = session.createQuery(cq);
            return query.getResultList();
        }
    }

    /**
     * Retrieves all entities of type T, eagerly fetching specified associations.
     * This helps to avoid N+1 select problems for ManyToOne and OneToMany
     * relationships.
     *
     * @param fetchPaths The paths to the associations to eagerly fetch (e.g.,
     *                   "propertyName", "collectionName").
     * @return A list of entities with specified associations eagerly loaded.
     */
    public List<T> listAllWithAssociations(String... fetchPaths) {
        try (Session session = Connexion.getSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<T> cq = cb.createQuery(entityClass);
            Root<T> root = cq.from(entityClass);

            for (String path : fetchPaths) {
                // Use JoinType.LEFT to ensure all parent entities are returned
                root.fetch(path, JoinType.LEFT);
            }

            cq.select(root);
            cq.distinct(true); // Important to avoid duplicate parent entities when fetching collections

            TypedQuery<T> query = session.createQuery(cq);
            return query.getResultList();
        }
    }

    /**
     * Finds a single entity by a specific field, eagerly fetching specified
     * associations.
     *
     * @param fieldName  The name of the field to search by.
     * @param value      The value to match for the field.
     * @param fetchPaths The paths to the associations to eagerly fetch.
     * @return The unique entity matching the criteria, or null if not found.
     */
    public T findByFieldWithAssociations(String fieldName, Object value, String... fetchPaths) {
        try (Session session = Connexion.getSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<T> cq = cb.createQuery(entityClass);
            Root<T> root = cq.from(entityClass);

            for (String path : fetchPaths) {
                root.fetch(path, JoinType.LEFT);
            }

            cq.select(root).where(cb.equal(root.get(fieldName), value));
            cq.distinct(true);

            TypedQuery<T> query = session.createQuery(cq);
            List<T> results = query.getResultList();
            if (results.isEmpty()) {
                return null;
            } else if (results.size() == 1) {
                return results.get(0);
            } else {
                throw new jakarta.persistence.NonUniqueResultException(
                        "Query returned non-unique results for field " + fieldName + " with value " + value);
            }
        }
    }

    /**
     * Finds all entities by a specific field, eagerly fetching specified
     * associations.
     *
     * @param fieldName  The name of the field to search by.
     * @param value      The value to match for the field.
     * @param fetchPaths The paths to the associations to eagerly fetch.
     * @return A list of entities matching the criteria.
     */
    public List<T> findAllByFieldWithAssociations(String fieldName, Object value, String... fetchPaths) {
        try (Session session = Connexion.getSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<T> cq = cb.createQuery(entityClass);
            Root<T> root = cq.from(entityClass);

            for (String path : fetchPaths) {
                root.fetch(path, JoinType.LEFT);
            }

            cq.select(root).where(cb.equal(root.get(fieldName), value));
            cq.distinct(true);

            TypedQuery<T> query = session.createQuery(cq);
            return query.getResultList();
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
        }
    }

    public List<T> findByFields(Map<String, Object> criteria) {
        try (Session session = Connexion.getSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<T> cq = cb.createQuery(entityClass);
            Root<T> root = cq.from(entityClass);

            List<Predicate> predicates = new java.util.ArrayList<>();
            for (Map.Entry<String, Object> entry : criteria.entrySet()) {
                predicates.add(cb.equal(root.get(entry.getKey()), entry.getValue()));
            }

            cq.select(root).where(predicates.toArray(new Predicate[0]));

            return session.createQuery(cq).getResultList();
        }
    }

}
