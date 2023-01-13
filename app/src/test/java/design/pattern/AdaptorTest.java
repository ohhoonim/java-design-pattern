package design.pattern;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.UUID;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import design.pattern.adaptor.AuthService;
import design.pattern.adaptor.AuthServiceImpl;
import design.pattern.adaptor.JsonWebToken;
import design.pattern.adaptor.Member;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class AdaptorTest {
    // 두 클래스가 동일 또는 유사한 일을 하지만 인터페이스가 다르면서
    // 특히 한쪽이 외부 라이브러리 즉, 수정할 수 없는 코드인 경우
    // 버전 관리 등의 목적으로 adaptor 패턴을 사용한다.
    @Test
    public void 세션인증_테스트() {
        AuthService auth = new AuthServiceImpl();
        boolean isValid = auth.isValidAuth(Member.builder().id("matthew").level("lv2").build());
        assertEquals(true, isValid);
    }

    @Test
    public void JWT_인증방식으로_변경() {
        String uuid = UUID.randomUUID().toString();
        System.out.println(uuid);
        AuthService auth = new AuthService() {

            @Override
            public boolean isValidAuth(Member member) {
                JsonWebToken jwt = new JsonWebToken();
                return jwt.isValidToken(member.getToken());
            }
        };
        boolean isValid = auth.isValidAuth(
                Member.builder().id("matthew").level("lv2").token("Bearer 12345").build());
        assertEquals(true, isValid);
    }

}
