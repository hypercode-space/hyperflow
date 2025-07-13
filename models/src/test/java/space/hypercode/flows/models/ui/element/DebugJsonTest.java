package space.hypercode.flows.models.ui.element;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

class DebugJsonTest {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void debugDeserialization() throws Exception {
        // Create and serialize
        DropDownElement element = new DropDownElement();
        element.setType(ElementType.DROPDOWN);
        element.setId("Test Dropdown");
        
        String json = objectMapper.writeValueAsString(element);
        System.out.println("Serialized JSON: " + json);
        
        // Deserialize
        UiElement deserialized = objectMapper.readValue(json, UiElement.class);
        System.out.println("Deserialized type: " + deserialized.getType());
        System.out.println("Deserialized name: " + deserialized.getId());
        System.out.println("Class: " + deserialized.getClass().getSimpleName());
    }
}
