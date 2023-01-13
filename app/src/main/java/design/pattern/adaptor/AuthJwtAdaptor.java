package design.pattern.adaptor;

public class AuthJwtAdaptor extends JsonWebToken implements AuthService {
    String token = "Bearer 12345";

    @Override
    public boolean isValidAuth(Member member) {
        boolean isValid = false;
        if (member != null && token.equals(member.getToken())) {
            isValid = isValidToken(member.getToken());
        }
        return isValid;
    }
}
