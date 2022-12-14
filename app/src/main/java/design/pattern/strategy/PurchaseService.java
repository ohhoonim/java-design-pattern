package design.pattern.strategy;

public class PurchaseService {

    public String pay(PayMethod method) {
        return method.pay();
    }

    public String oldpay(String method) {
        String payResult = "";
        switch (method) {
            case "card":
                // System.out.println("card로 지불");
                PayCard card = new PayCard();
                payResult = card.pay();
                break;
            case "money":
                // System.out.println("현금으로 지불");
                PayMoney money = new PayMoney();
                payResult = money.pay();
                break;
            default:
                break;
        }
        return payResult;
    }

}
