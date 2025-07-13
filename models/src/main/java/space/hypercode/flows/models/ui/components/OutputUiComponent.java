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
@JsonTypeName("OUTPUT")
public class OutputUiComponent extends UiComponent {
    // Output specific UI component configuration
}
