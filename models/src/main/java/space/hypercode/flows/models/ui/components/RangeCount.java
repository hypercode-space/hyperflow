package space.hypercode.flows.models.ui.components;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Builder
@Getter
public class RangeCount {
    private final int minInclusive;
    private final int maxInclusive;
}
