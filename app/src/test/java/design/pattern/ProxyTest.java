package design.pattern;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import design.pattern.proxy.Printable;
import design.pattern.proxy.Printer;
import design.pattern.proxy.PrinterProxy;
import design.pattern.proxy.PrinterProxyAspect;
import design.pattern.proxy.PrinterProxyAspectDi;
import design.pattern.proxy.aspect.Aspect;
import design.pattern.proxy.aspect.Logging;
import design.pattern.proxy.aspect.UserAuth;

public class ProxyTest {
    @Test
    @DisplayName("프린터 레거시 코드")
    public void printerTest() {
        // Printer printer = new Printer("samsung");
        Printable printer = new Printer("samsung");
        String message = "첫번째 출력입니다.";
        String renderedChars = printer.render(message);
        
        String expected = "<samsung>" + message + "</samsung>";
        assertEquals(expected, renderedChars);
    }

    @Test
    @DisplayName("로깅기능 추가 - proxy(대리) 클래스로 대체")
    public void printerProxyTest() {
        // Printer 클래스를 사용하던 것을 Printable 인터페이스로 교체
        // Printer 클래스에 맞춰 Printable 인터페이스 생성
        // PrinterProxy클래스를 Printable 인터페이스 구현으로 만들고
        // Printer클래스를 PrinterProxy클래스로 교체(대체) 
        Printable printer = new PrinterProxy("samsung");
        String message = "로깅처리 출력테스트입니다.";
        String renderedChars = printer.render(message);

        String expected = "<samsung>" + message + "</samsung>";
        assertEquals(expected, renderedChars);
        
    }

    @Test
    @DisplayName("전후처리 로직이 더 많아진다면? => aop의 시작")
    public void printerProxyAopTest() {
        Printable printer = new PrinterProxyAspect("xerox");
        String message = "로깅처리 출력테스트입니다.";
        String renderedChars = printer.render(message);

        String expected = "<xerox>" + message + "</xerox>";
        assertEquals(expected, renderedChars);
    }

    @Test
    @DisplayName("로깅 처리를 프록시에서 주입받아 처리. => 관심사분리")
    public void printerTestByMock() {
        Aspect logging = mock(Logging.class);
        Aspect userAuth = mock(UserAuth.class);
        Printable printer = new PrinterProxyAspectDi("xerox", logging, userAuth);

        String message = "로깅처리 출력테스트입니다.";
        String renderedChars = printer.render(message);

        String expected = "<xerox>" + message + "</xerox>";
        assertEquals(expected, renderedChars);
        verify(logging, times(1)).before();
        verify(logging, times(1)).after();
        verify(userAuth, times(1)).before();
        verify(userAuth, times(1)).after();
    }

    @Test
    @DisplayName("aspect 처리 순서는?")
    public void printerAspectTest() {
        Aspect logging = new Logging();
        Aspect userAuth = new UserAuth();
        Printable printer = new PrinterProxyAspectDi("xerox", logging, userAuth);

        String message = "로깅처리 출력테스트입니다.";
        String renderedChars = printer.render(message);

        String expected = "<xerox>" + message + "</xerox>";
        assertEquals(expected, renderedChars);
    }
    // AOP란
    // 원본 객체가 해야할 할 일을 프록시객체를 사용하여 할 일을 제어하는 것 
}
