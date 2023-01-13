package design.pattern.factoryMethod;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Car {
    private String name;
    private String type;
}
