package space.hypercode.flows.models.ui.components;

import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@JsonTypeName("HTTP")
public class HttpUiComponent extends UiComponent {
    // HTTP-specific UI component configuration
}
