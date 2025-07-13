package space.hypercode.flows.models.ui.element;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ElementType {
    TEXTBOX("textbox"), // to get some input
    DROPDOWN("dropdown"), // to select from list of options
    TRUE_FALSE("true_or_false"), // to select true or false
    EVALUATION("evaluate"); // to evaluate some expression or condition

    private final String name;
}
