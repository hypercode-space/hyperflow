package space.hypercode.flows.models.ui.element;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class UiElementJsonTest {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void testDropDownElementSerialization() throws Exception {
        DropDownElement element = DropDownElement.builder()
                .options(Set.of("Option1", "Option2", "Option3"))
                .multiSelect(true)
                .build();
        element.setType(ElementType.DROPDOWN);
        element.setName("Select Options");

        String json = objectMapper.writeValueAsString(element);
        
        assertTrue(json.contains("\"type\":\"DROPDOWN\""));
        assertTrue(json.contains("\"multiSelect\":true"));
        assertTrue(json.contains("\"options\":["));
    }

    @Test
    void testTextBoxElementSerialization() throws Exception {
        TextBoxElement element = TextBoxElement.builder()
                .regex("^[a-zA-Z]+$")
                .maxLength(50)
                .build();
        element.setType(ElementType.TEXTBOX);
        element.setName("Input Field");

        String json = objectMapper.writeValueAsString(element);
        
        assertTrue(json.contains("\"type\":\"TEXTBOX\""));
        assertTrue(json.contains("\"regex\":\"^[a-zA-Z]+$\""));
        assertTrue(json.contains("\"maxLength\":50"));
    }

    @Test
    void testTrueFalseElementSerialization() throws Exception {
        TrueFalseElement element = TrueFalseElement.builder()
                .build();
        element.setType(ElementType.TRUE_FALSE);
        element.setName("Yes/No Question");

        String json = objectMapper.writeValueAsString(element);
        
        assertTrue(json.contains("\"type\":\"TRUE_FALSE\""));
        assertTrue(json.contains("\"name\":\"Yes/No Question\"")); 
    }

    @Test
    void testEvaluationElementSerialization() throws Exception {
        EvaluationElement element = EvaluationElement.builder()
                .json("{\"expression\": \"x > 5\"}")
                .build();
        element.setType(ElementType.EVALUATION);
        element.setName("Expression Evaluator");

        String json = objectMapper.writeValueAsString(element);
        
        assertTrue(json.contains("\"type\":\"EVALUATION\""));
        assertTrue(json.contains("\"json\":\"{\\\"expression\\\": \\\"x > 5\\\"}\""));
    }

    @Test
    void testPolymorphicDeserialization() throws Exception {
        String dropdownJson = """
                {
                    "type": "DROPDOWN",
                    "name": "Select Country",
                    "options": ["USA", "Canada", "Mexico"],
                    "multiSelect": false
                }
                """;

        UiElement element = objectMapper.readValue(dropdownJson, UiElement.class);
        
        assertInstanceOf(DropDownElement.class, element);
        assertEquals(ElementType.DROPDOWN, element.getType());
        assertEquals("Select Country", element.getName());
        
        DropDownElement dropdown = (DropDownElement) element;
        assertEquals(3, dropdown.getOptions().size());
        assertFalse(dropdown.isMultiSelect());
    }

    @Test
    void testTextBoxDeserialization() throws Exception {
        String textboxJson = """
                {
                    "type": "TEXTBOX",
                    "name": "Email Input",
                    "regex": "^[\\\\w.-]+@[\\\\w.-]+\\\\.[a-zA-Z]{2,}$",
                    "maxLength": 100
                }
                """;

        UiElement element = objectMapper.readValue(textboxJson, UiElement.class);
        
        assertInstanceOf(TextBoxElement.class, element);
        assertEquals(ElementType.TEXTBOX, element.getType());
        
        TextBoxElement textbox = (TextBoxElement) element;
        assertEquals("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$", textbox.getRegex());
        assertEquals(100, textbox.getMaxLength());
    }

    @Test
    void testEvaluationDeserialization() throws Exception {
        String evaluationJson = """
                {
                    "type": "EVALUATION",
                    "name": "Math Expression",
                    "json": "{\\"formula\\": \\"a + b * c\\"}"
                }
                """;

        UiElement element = objectMapper.readValue(evaluationJson, UiElement.class);
        
        assertInstanceOf(EvaluationElement.class, element);
        assertEquals(ElementType.EVALUATION, element.getType());
        
        EvaluationElement evaluation = (EvaluationElement) element;
        assertEquals("{\"formula\": \"a + b * c\"}", evaluation.getJson());
    }
}
