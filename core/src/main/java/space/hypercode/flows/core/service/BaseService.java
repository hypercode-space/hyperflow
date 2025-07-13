package space.hypercode.flows.core.service;

import space.hypercode.flows.models.BaseEntity;
import java.util.List;
import java.util.Optional;

/**
 * Generic service interface for CRUD operations on entities.
 *
 * @param <T> the entity type extending BaseEntity
 */
public interface BaseService<T extends BaseEntity> {

    /**
     * Creates a new entity.
     *
     * @param entity the entity to create
     * @return the created entity
     */
    T create(T entity);

    /**
     * Finds an entity by its ID.
     *
     * @param id the entity ID
     * @return optional containing the entity if found
     */
    Optional<T> findById(String id);

    /**
     * Finds all entities.
     *
     * @return list of all entities
     */
    List<T> findAll();

    /**
     * Updates an existing entity.
     *
     * @param entity the entity to update
     * @return the updated entity
     */
    T update(T entity);

    /**
     * Deletes an entity by its ID.
     *
     * @param id the entity ID
     * @return true if deleted, false if not found
     */
    boolean deleteById(String id);
}
