package design.pattern.builder;

public class SignUpService {
    private User user;
	public SignUpService(User user) {
        this.user = user;
    }

    public boolean approve() {
        return user.getAge() > 20 ? true: false;
    }


    
}
