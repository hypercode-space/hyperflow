package space.hypercode.flows.models.ui.components;

import lombok.Getter;
import space.hypercode.flows.models.components.ComponentType;
import space.hypercode.flows.models.ports.PortType;
import space.hypercode.flows.models.ui.element.UiElement;

import java.util.Map;

@Getter
public abstract class UiComponent {

    private ComponentType componentType;
    Map<PortType, RangeCount>  ports;
    Map<UiElement, RangeCount> elements;
    private String name;
}
