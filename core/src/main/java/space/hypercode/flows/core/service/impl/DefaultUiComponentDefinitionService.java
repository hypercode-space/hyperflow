package space.hypercode.flows.core.service.impl;

import space.hypercode.flows.core.service.UiComponentDefinitionService;
import space.hypercode.flows.models.components.ComponentType;
import space.hypercode.flows.models.ports.PortType;
import space.hypercode.flows.models.ui.components.*;
import space.hypercode.flows.models.ui.element.*;

import java.util.*;

/**
 * Default implementation of UiComponentDefinitionService.
 */
public class DefaultUiComponentDefinitionService implements UiComponentDefinitionService {

    @Override
    public UiComponent getUiComponentsForType(ComponentType componentType) {
        return switch (componentType) {
            case HTTP -> createHttpUiComponent();
            case IF_ELSE -> createIfElseUiComponent();
            case INPUT -> createInputUiComponent();
            case OUTPUT -> createOutputUiComponent();
        };
    }

    @Override
    public Set<UiComponent> getAllUiComponents() {
        Set<UiComponent> allComponents = new HashSet<>();
        for (ComponentType type : ComponentType.values()) {
            allComponents.add(getUiComponentsForType(type));
        }
        return allComponents;
    }

    private UiComponent createHttpUiComponent() {
        HttpUiComponent httpComponent = new HttpUiComponent();
        httpComponent.setComponentType(ComponentType.HTTP);
        httpComponent.setName("HTTP Request");
        
        // Define ports for HTTP component
        Map<PortType, RangeCount> ports = new HashMap<>();
        ports.put(PortType.IN, RangeCount.builder().minInclusive(1).maxInclusive(1).build());
        ports.put(PortType.OUT, RangeCount.builder().minInclusive(1).maxInclusive(2).build());
        httpComponent.setPorts(ports);
        
        // Define UI elements for HTTP component
        Set<UiComponent.UiElementWithAllowedCount> elements = new HashSet<>();
        
        // URL input
        TextBoxElement urlElement = TextBoxElement.builder()
                .regex("^https?://.*")
                .maxLength(500)
                .build();
        urlElement.setType(ElementType.TEXTBOX);
        urlElement.setId("URL");
        elements.add(UiComponent.UiElementWithAllowedCount.builder()
                .element(urlElement)
                .allowedCount(RangeCount.builder().minInclusive(1).maxInclusive(1).build())
                .build());
        
        // Method dropdown
        DropDownElement methodElement = DropDownElement.builder()
                .options(Set.of("GET", "POST", "PUT", "DELETE", "PATCH"))
                .multiSelect(false)
                .build();
        methodElement.setType(ElementType.DROPDOWN);
        methodElement.setId("HTTP Method");
        elements.add(UiComponent.UiElementWithAllowedCount.builder()
                .element(methodElement)
                .allowedCount(RangeCount.builder().minInclusive(1).maxInclusive(1).build())
                .build());
        
        httpComponent.setElements(elements);
        
        return httpComponent;
    }

    private UiComponent createIfElseUiComponent() {
        IfElseUiComponent ifElseComponent = new IfElseUiComponent();
        ifElseComponent.setComponentType(ComponentType.IF_ELSE);
        ifElseComponent.setName("Conditional Logic");
        
        // Define ports for If-Else component
        Map<PortType, RangeCount> ports = new HashMap<>();
        ports.put(PortType.IN, RangeCount.builder().minInclusive(1).maxInclusive(1).build());
        ports.put(PortType.OUT, RangeCount.builder().minInclusive(2).maxInclusive(2).build());
        ifElseComponent.setPorts(ports);
        
        // Define UI elements for If-Else component
        Set<UiComponent.UiElementWithAllowedCount> elements = new HashSet<>();
        
        // Condition evaluation
        EvaluationElement conditionElement = EvaluationElement.builder()
                .build();
        conditionElement.setType(ElementType.EVALUATION);
        conditionElement.setId("Condition");
        elements.add(UiComponent.UiElementWithAllowedCount.builder()
                .element(conditionElement)
                .allowedCount(RangeCount.builder().minInclusive(1).maxInclusive(1).build())
                .build());
        
        ifElseComponent.setElements(elements);
        
        return ifElseComponent;
    }

    private UiComponent createInputUiComponent() {
        InputUiComponent inputComponent = new InputUiComponent();
        inputComponent.setComponentType(ComponentType.INPUT);
        inputComponent.setName("Input Component");
        
        // Define ports for Input component
        Map<PortType, RangeCount> ports = new HashMap<>();
        ports.put(PortType.OUT, RangeCount.builder().minInclusive(1).maxInclusive(1).build());
        inputComponent.setPorts(ports);
        
        // Define UI elements for Input component
        Set<UiComponent.UiElementWithAllowedCount> elements = new HashSet<>();
        
        // Input type selection
        DropDownElement typeElement = DropDownElement.builder()
                .options(Set.of("TEXT", "NUMBER", "BOOLEAN", "JSON"))
                .multiSelect(false)
                .build();
        typeElement.setType(ElementType.DROPDOWN);
        typeElement.setId("Input Type");
        elements.add(UiComponent.UiElementWithAllowedCount.builder()
                .element(typeElement)
                .allowedCount(RangeCount.builder().minInclusive(1).maxInclusive(1).build())
                .build());
        
        // Default value input
        TextBoxElement defaultValueElement = TextBoxElement.builder()
                .maxLength(1000)
                .build();
        defaultValueElement.setType(ElementType.TEXTBOX);
        defaultValueElement.setId("Default Value");
        elements.add(UiComponent.UiElementWithAllowedCount.builder()
                .element(defaultValueElement)
                .allowedCount(RangeCount.builder().minInclusive(0).maxInclusive(1).build())
                .build());
        
        inputComponent.setElements(elements);
        
        return inputComponent;
    }

    private UiComponent createOutputUiComponent() {
        OutputUiComponent outputComponent = new OutputUiComponent();
        outputComponent.setComponentType(ComponentType.OUTPUT);
        outputComponent.setName("Output Component");
        
        // Define ports for Output component
        Map<PortType, RangeCount> ports = new HashMap<>();
        ports.put(PortType.IN, RangeCount.builder().minInclusive(1).maxInclusive(1).build());
        outputComponent.setPorts(ports);
        
        // Define UI elements for Output component
        Set<UiComponent.UiElementWithAllowedCount> elements = new HashSet<>();
        
        // Output format selection
        DropDownElement formatElement = DropDownElement.builder()
                .options(Set.of("JSON", "TEXT", "XML", "CSV"))
                .multiSelect(false)
                .build();
        formatElement.setType(ElementType.DROPDOWN);
        formatElement.setId("Output Format");
        elements.add(UiComponent.UiElementWithAllowedCount.builder()
                .element(formatElement)
                .allowedCount(RangeCount.builder().minInclusive(1).maxInclusive(1).build())
                .build());
        
        outputComponent.setElements(elements);
        
        return outputComponent;
    }
}
