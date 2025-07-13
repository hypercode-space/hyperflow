package space.hypercode.flows.models.ui.element;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    include = JsonTypeInfo.As.PROPERTY,
    property = "type",
    visible = true
)
@JsonSubTypes({
    @JsonSubTypes.Type(value = TextBoxElement.class, name = "TEXTBOX"),
    @JsonSubTypes.Type(value = DropDownElement.class, name = "DROPDOWN"),
    @JsonSubTypes.Type(value = TrueFalseElement.class, name = "TRUE_FALSE"),
    @JsonSubTypes.Type(value = EvaluationElement.class, name = "EVALUATION")
})
public abstract class UiElement {
    private ElementType type;
    private String name;
}
