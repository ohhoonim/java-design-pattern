package design.pattern.strategy;

public class PayMoney implements PayMethod {
    public String pay() {
        return "pay money";
    }
    @Override
    public String toString() {
        return "MONEY";
    }
}
