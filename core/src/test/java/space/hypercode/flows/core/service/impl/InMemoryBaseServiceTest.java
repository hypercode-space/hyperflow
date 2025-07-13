package space.hypercode.flows.core.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import space.hypercode.flows.models.BaseEntity;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class InMemoryBaseServiceTest {

    private InMemoryBaseService<TestEntity> service;

    @BeforeEach
    void setUp() {
        service = new InMemoryBaseService<>();
    }

    @Test
    void testCreateEntity() {
        TestEntity entity = new TestEntity("Test Name");
        
        TestEntity created = service.create(entity);
        
        assertNotNull(created.getId());
        assertEquals("Test Name", created.getName());
        assertEquals(1, service.size());
    }

    @Test
    void testFindById() {
        TestEntity entity = new TestEntity("Test Name");
        TestEntity created = service.create(entity);
        
        Optional<TestEntity> found = service.findById(created.getId());
        
        assertTrue(found.isPresent());
        assertEquals(created.getId(), found.get().getId());
        assertEquals("Test Name", found.get().getName());
    }

    @Test
    void testFindAll() {
        service.create(new TestEntity("Entity 1"));
        service.create(new TestEntity("Entity 2"));
        
        List<TestEntity> all = service.findAll();
        
        assertEquals(2, all.size());
    }

    @Test
    void testUpdate() {
        TestEntity entity = new TestEntity("Original Name");
        TestEntity created = service.create(entity);
        long originalUpdatedAt = created.getUpdatedAt();
        
        created.setName("Updated Name");
        TestEntity updated = service.update(created);
        
        assertEquals("Updated Name", updated.getName());
        assertTrue(updated.getUpdatedAt() > originalUpdatedAt);
    }

    @Test
    void testDeleteById() {
        TestEntity entity = new TestEntity("Test Name");
        TestEntity created = service.create(entity);
        
        boolean deleted = service.deleteById(created.getId());
        
        assertTrue(deleted);
        assertEquals(0, service.size());
        assertFalse(service.findById(created.getId()).isPresent());
    }

    @Test
    void testDeleteNonExistentEntity() {
        boolean deleted = service.deleteById("non-existent-id");
        
        assertFalse(deleted);
    }

    // Test entity for testing purposes
    private static class TestEntity extends BaseEntity {
        private String name;

        public TestEntity(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
