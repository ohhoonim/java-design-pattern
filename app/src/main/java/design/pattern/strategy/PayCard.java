package design.pattern.strategy;

public class PayCard  implements PayMethod {
    public String pay() {
        return "pay card";
    }

    @Override
    public String toString() {
        return "CARD";
    }
}
