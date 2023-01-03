package design.pattern.builder;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Car {
    private String name;
    private String type;
    private boolean hasTire;
}
