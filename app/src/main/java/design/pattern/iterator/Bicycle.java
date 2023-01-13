package design.pattern.iterator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Bicycle {
    private String name;
    private double height;
    private double width;
    private double length;
}
