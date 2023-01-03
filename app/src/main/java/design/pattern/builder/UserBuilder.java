package design.pattern.builder;

public class UserBuilder {

    private User user = new User(null); 

    public static UserBuilder builder() {
        return new UserBuilder();
    }

    public UserBuilder name(String name) {
        this.user.setName(name);
        return this;
    }

    public UserBuilder age(int age) {
        this.user.setAge(age);
        return this;
    }

    public UserBuilder address(String address) {
        this.user.setAddress(address);
        return this;
    }

    public UserBuilder tel(String tel) {
        this.user.setTel(tel);
        return this;
    }

	public UserBuilder gender(String gender) {
        this.user.setGender(gender);
		return this;
	}

    public UserBuilder hobby(String hobby) {
        this.user.setHobby(hobby);
        return this;
    }

    public UserBuilder job(String job) {
        this.user.setJob(job);
        return this;
    }

    public UserBuilder company(String company) {
        this.user.setCompany(company);
        return this;
    }

    public UserBuilder youtubeId(String youtubeId) {
        this.user.setYoutubeId(youtubeId);
        return this;
    }

    public UserBuilder naverId(String naverId) {
        this.user.setNaverId(naverId);
        return this;
    }

	public User build() {
		return this.user;
	}
    
}
