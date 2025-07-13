package space.hypercode.flows.models.ui.element;

import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonTypeName("DROPDOWN")
public class DropDownElement extends UiElement {
    private Set<String> options;
    private boolean multiSelect;
}
