package space.hypercode.flows.server.controller;

import org.springframework.web.bind.annotation.*;
import space.hypercode.flows.core.service.UiComponentDefinitionService;
import space.hypercode.flows.core.service.impl.DefaultUiComponentDefinitionService;
import space.hypercode.flows.models.components.ComponentType;
import space.hypercode.flows.models.ui.components.UiComponent;

import java.util.Set;

/**
 * REST controller for UI component definitions.
 */
@RestController
@RequestMapping("/api/ui-components")
public class UiComponentDefinitionController {

    private final UiComponentDefinitionService uiComponentDefinitionService;

    public UiComponentDefinitionController() {
        this.uiComponentDefinitionService = new DefaultUiComponentDefinitionService();
    }

    /**
     * Get UI component for a specific component type.
     * 
     * @param componentType the component type
     * @return UI component for the given type
     */
    @GetMapping("/{componentType}")
    public UiComponent getUiComponentsForType(@PathVariable ComponentType componentType) {
        return uiComponentDefinitionService.getUiComponentsForType(componentType);
    }

    /**
     * Get all UI components grouped by component type.
     * 
     * @return set of all UI components
     */
    @GetMapping
    public Set<UiComponent> getAllUiComponents() {
        return uiComponentDefinitionService.getAllUiComponents();
    }
}
