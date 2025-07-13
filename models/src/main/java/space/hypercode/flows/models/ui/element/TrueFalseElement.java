package space.hypercode.flows.models.ui.element;

import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@JsonTypeName("TRUE_FALSE")
public class TrueFalseElement extends UiElement {
    // No additional fields needed for true/false element
}
