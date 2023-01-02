package design.pattern.strategy;

public class PayApple implements PayMethod{
    @Override
    public String pay() {
        return "pay apple";
    }
    @Override
    public String toString() {
        return "APPLE";
    }
}
