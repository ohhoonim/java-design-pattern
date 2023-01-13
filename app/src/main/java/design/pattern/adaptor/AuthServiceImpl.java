package design.pattern.adaptor;

public class AuthServiceImpl implements AuthService {
    String session = "matthew";

    @Override
    public boolean isValidAuth(Member member) {
        boolean result = false;
        // 여기서는 간단하게 session 정보를 클래스 내부에서 관리한다고 가정
        if (member != null && session.equals(member.getId())) {
            result = true;
        }
        return result;
    }
}
