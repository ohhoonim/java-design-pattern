package design.pattern;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import design.pattern.factoryMethod.Car;
import design.pattern.factoryMethod.CarFactory;
import design.pattern.factoryMethod.TestDataFactory;
import design.pattern.factoryMethod.User;
import design.pattern.factoryMethod.UserFactory;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@DisplayName("팩토리 메서드 패턴")
public class FactoryMethodTest {
    // 팩토리 메서드 패턴은 부모 클래스에 알려지지 않은 구체 클래스를 생성하는 패턴이며,
    // 자식 클래스가 어떤 객체를 생성할지를 결정하도록 하는 패턴이기도 하다.
    @Test
    public void 팩토리메서드_패턴() {
        TestDataFactory<User> testData = new UserFactory();
        List<User> users = testData.withAll(); // User 클래스를 가져온다.
        assertEquals(3, users.size());

        User man = testData.withOne();
        assertEquals("matthew", man.getName());


        TestDataFactory<Car> carData = new CarFactory();
        List<Car> cars = carData.withAll();
        assertEquals(3, cars.size());

        Car car = carData.withOne();
        assertEquals("레이", car.getName());
    }

    private static Stream<Arguments> userDatas() {
        return Stream.of(Arguments.arguments(User.builder().name("matthew").age(4).build(), "matthew"),
                Arguments.arguments(User.builder().name("danial").age(8).build(), "danial")
        );
    }

    @ParameterizedTest(name = "예상결과데이터: {1}")
    @MethodSource("userDatas")
    public void JUnit_파라미터_테스트(User user, String expected) {
        assertEquals(expected, user.getName());
    }


}
