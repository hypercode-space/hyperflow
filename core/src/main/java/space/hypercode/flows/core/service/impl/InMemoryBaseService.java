package space.hypercode.flows.core.service.impl;

import space.hypercode.flows.core.service.BaseService;
import space.hypercode.flows.models.BaseEntity;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * In-memory implementation of BaseService for testing and development.
 *
 * @param <T> the entity type extending BaseEntity
 */
public class InMemoryBaseService<T extends BaseEntity> implements BaseService<T> {

    private final Map<String, T> storage = new ConcurrentHashMap<>();

    @Override
    public T create(T entity) {
        if (entity.getId() == null) {
            entity.setId(UUID.randomUUID().toString());
        }
        storage.put(entity.getId(), entity);
        return entity;
    }

    @Override
    public Optional<T> findById(String id) {
        return Optional.ofNullable(storage.get(id));
    }

    @Override
    public List<T> findAll() {
        return new ArrayList<>(storage.values());
    }

    @Override
    public T update(T entity) {
        if (entity.getId() == null || !storage.containsKey(entity.getId())) {
            throw new IllegalArgumentException("Entity not found for update");
        }
        entity.touch();
        storage.put(entity.getId(), entity);
        return entity;
    }

    @Override
    public boolean deleteById(String id) {
        return storage.remove(id) != null;
    }

    /**
     * Clears all entities from storage.
     */
    public void clear() {
        storage.clear();
    }

    /**
     * Returns the current size of storage.
     *
     * @return number of entities in storage
     */
    public int size() {
        return storage.size();
    }
}
