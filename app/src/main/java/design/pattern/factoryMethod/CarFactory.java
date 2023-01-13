package design.pattern.factoryMethod;

public class CarFactory extends TestDataFactory<Car> {

    @Override
    public Car createData() {
        return Car.builder()
            .name("레이")
            .type("소형")
        .build();
    }

}
