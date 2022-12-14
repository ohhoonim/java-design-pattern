package design.pattern;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import design.pattern.strategy.PayApple;
import design.pattern.strategy.PayCard;
import design.pattern.strategy.PayMoney;
import design.pattern.strategy.PurchaseService;

public class StrategyTest {
    @Test
    public void oldTest() {

        PurchaseService service = new PurchaseService();

        String cardResult = service.oldpay("card");
        assertEquals("pay card", cardResult);

        String moneyResult = service.oldpay("money");
        assertEquals("pay money", moneyResult);
    }

    @Test
    public void strategyTest() {
        PurchaseService service = new PurchaseService();

        String cardResult = service.pay(new PayCard());
        assertEquals("pay card", cardResult);

        String moneyResult = service.pay(new PayMoney());
        assertEquals("pay money", moneyResult);

        String appleResult = service.pay(new PayApple());
        assertEquals("pay apple", appleResult);
    }
}
