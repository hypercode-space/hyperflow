package space.hypercode.flows.models.ui.components;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import space.hypercode.flows.models.components.ComponentType;
import space.hypercode.flows.models.ports.PortType;
import space.hypercode.flows.models.ui.element.UiElement;

import java.util.Map;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    include = JsonTypeInfo.As.PROPERTY,
    property = "componentType",
    visible = true
)
@JsonSubTypes({
    @JsonSubTypes.Type(value = HttpUiComponent.class, name = "HTTP"),
    @JsonSubTypes.Type(value = IfElseUiComponent.class, name = "IF_ELSE"),
    @JsonSubTypes.Type(value = InputUiComponent.class, name = "INPUT"),
    @JsonSubTypes.Type(value = OutputUiComponent.class, name = "OUTPUT")
})
public abstract class UiComponent {

    private ComponentType componentType;
    private Map<PortType, RangeCount> ports;
    private Set<UiElementWithAllowedCount> elements;
    private String name;

    @AllArgsConstructor
    @Builder
    @Getter
    public static class UiElementWithAllowedCount {
        private UiElement element;
        private RangeCount allowedCount;
    }
}
