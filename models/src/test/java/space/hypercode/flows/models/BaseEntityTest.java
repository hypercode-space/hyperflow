package space.hypercode.flows.models;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BaseEntityTest {

    @Test
    void testBaseEntityCreation() {
        BaseEntity entity = new TestEntity();
        
        assertNotNull(entity);
        assertTrue(entity.getCreatedAt() > 0);
        assertEquals(entity.getCreatedAt(), entity.getUpdatedAt());
    }

    @Test
    void testTouch() throws InterruptedException {
        BaseEntity entity = new TestEntity();
        long initialUpdatedAt = entity.getUpdatedAt();
        
        Thread.sleep(1); // Ensure time difference
        entity.touch();
        
        assertTrue(entity.getUpdatedAt() > initialUpdatedAt);
    }

    // Test implementation of BaseEntity
    private static class TestEntity extends BaseEntity {
        // Empty implementation for testing
    }
}
