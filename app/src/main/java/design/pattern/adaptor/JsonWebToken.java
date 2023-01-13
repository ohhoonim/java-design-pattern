package design.pattern.adaptor;

public class JsonWebToken {
    String token = "Bearer 12345";
    public boolean isValidToken(String token) {
        boolean isValid = false;
        if (token != null && token.equals("Bearer 12345")) {
            isValid = true;
        }
        return isValid; 
    }
}
