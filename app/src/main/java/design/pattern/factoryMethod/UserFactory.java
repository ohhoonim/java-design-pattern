package design.pattern.factoryMethod;

public class UserFactory extends TestDataFactory<User> {

    @Override
    public User createData() {
       return User.builder()
            .name("matthew")
            .age(32)
            .address("seoun")
        .build();
        
    }
    
}
