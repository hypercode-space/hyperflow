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
@JsonTypeName("IF_ELSE")
public class IfElseUiComponent extends UiComponent {
    // If-Else specific UI component configuration
}
