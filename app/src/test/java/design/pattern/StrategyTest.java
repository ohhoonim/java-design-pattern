package design.pattern;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import design.pattern.strategy.PayApple;
import design.pattern.strategy.PayCard;
import design.pattern.strategy.PayMethod;
import design.pattern.strategy.PayMoney;
import design.pattern.strategy.PurchaseService;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class StrategyTest {
    @Test
    public void 전략패턴을_사용하지_않으면() {

        PurchaseService service = new PurchaseService();

        String cardResult = service.oldpay("card");
        assertEquals("pay card", cardResult);

        String moneyResult = service.oldpay("money");
        assertEquals("pay money", moneyResult);
    }

    @Test
    public void 전략패턴을_사용하면() {
        PurchaseService service = new PurchaseService();

        String cardResult = service.pay(new PayCard());
        assertEquals("pay card", cardResult);

        String moneyResult = service.pay(new PayMoney());
        assertEquals("pay money", moneyResult);

        String appleResult = service.pay(new PayApple());
        assertEquals("pay apple", appleResult);
    }

    private static Stream<Arguments> payMethod() {
        return Stream.of(arguments(new PayCard(), "pay card"),
                arguments(new PayMoney(), "pay money"), arguments(new PayApple(), "pay apple"));
    }

    // {displayName}: 메서드 이름을 표시합니다.
    // {index}: 테스트 실행 횟수를 표시합니다. (1-based)
    // {arguments}: 파라미터를 콤마로 구분해서 보여줍니다.
    // {argumentsWithNames}: 콤마로 구분된 파라미터 이름과 파리머터 값을 보여줍니다.
    // {0}, {1} ...: 메서드에 인자로 넘어오는 각 파라미터를 표시합니다.
    @ParameterizedTest(name = "{argumentsWithNames} ")
    @MethodSource("payMethod")
    public void 파라미터를_이용한_테스트(PayMethod payMethod, String expectedString) {
        PurchaseService service = new PurchaseService();
        String cardResult = service.pay(payMethod);
        assertEquals(expectedString, cardResult);
    }
}
