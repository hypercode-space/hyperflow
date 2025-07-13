package space.hypercode.flows.models.ui.element;

import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonTypeName("TEXTBOX")
public class TextBoxElement extends UiElement {
    private String regex;
    private int maxLength;
}
