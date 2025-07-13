package space.hypercode.flows.core.service;

import space.hypercode.flows.models.components.ComponentType;
import space.hypercode.flows.models.ui.components.UiComponent;

import java.util.Set;

/**
 * Service interface for managing UI component definitions.
 */
public interface UiComponentDefinitionService {

    /**
     * Gets the UI component for a specific component type.
     *
     * @param componentType the component type
     * @return UI component for the given type
     */
    UiComponent getUiComponentsForType(ComponentType componentType);

    /**
     * Gets all available UI component definitions.
     *
     * @return set of all UI components
     */
    Set<UiComponent> getAllUiComponents();
}
