package design.pattern;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import design.pattern.builder.Car;
import design.pattern.builder.User;
import design.pattern.builder.UserBuilder;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class BuilderTest {
    // 생성자(Constructor)만 사용할 때 발생할 수 있는 문제를 
    @Test
    public void 옵션이_많은_객체의_생성자() {
        // 이거 언제다 순서 맞춰줌?
        /*
        User user = new User(
            name,
            age, 
            address, 
            tel, 
            gender, 
            hobby, 
            job, 
            company, 
            youtubeId, 
            naverId);
            */
            
        }
    // Gof에서 설명하는 빌더 패턴을 이용하면 복잡한 객체들을 단계별로 
    // 생성할 수 있도록도 해줄수 있다. 하지만 여기서는 생성자를 사용했을때
    // 발생하는 문제에만 집중하자

    // 생성자만 사용했을때 단점을 settier로 개선
    @Test
    public void 세터를_사용하면_그나마_좋아져요 () {
        User matthew = new User("matthew");

        matthew.setAge(23);
        matthew.setAddress("인천 미추홀구");
        matthew.setTel("010-2222-3333");
        matthew.setGender("male");
        matthew.setHobby("종이모형");
        matthew.setJob("엔지니어");
        matthew.setCompany("UC편의점");
        matthew.setYoutubeId("하찮은오후");
        matthew.setNaverId("하찮은오후님");

        assertEquals("matthew", matthew.getName());

        User jack = new User("jack");

        jack.setAge(13);
        jack.setAddress("서울 미추홀구");
        jack.setTel("010-7777-3333");

        assertEquals("jack", jack.getName());
        // 이것도 나쁘진 않다만.... 
    }

    
    @Test
    public void 빌더를_사용하면 () {
        UserBuilder userBuilder = UserBuilder.builder();

        userBuilder.name("jack")
            .gender("female")
            .hobby("종이모형"); 

        User jack = userBuilder.build();
        assertEquals("female", jack.getGender());

        userBuilder.name("matthew")
            .gender("male")
            .job("엔지니어"); 
        User matthew = userBuilder.build();
        assertEquals("male", matthew.getGender());
    }

    @Test
    public void 빌더는_롬복쓰면됨_게터세터도_만들어줌() {
        Car car = Car.builder()
            .name("레이")
            .type("소형")
            .hasTire(false).build();
        
        assertEquals("레이", car.getName());

    }

    // Annotation Processor
}
