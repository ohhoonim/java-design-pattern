package design.pattern.builder;

public class User {

    private String name;
    private int age;
    private String address;
    private String tel;
    private String gender;
    private String hobby;
    private String job;
    private String company;
    private String youtubeId;
    private String naverId;

    public User(String name, int age, String address, String tel, String gender, String hobby,
            String job, String company, String youtubeId, String naverId) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.tel = tel;
        this.gender = gender;
        this.hobby = hobby;
        this.job = job;
        this.company = company;
        this.youtubeId = youtubeId;
        this.naverId = naverId;
    }

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getYoutubeId() {
        return youtubeId;
    }

    public void setYoutubeId(String youtubeId) {
        this.youtubeId = youtubeId;
    }

    public String getNaverId() {
        return naverId;
    }

    public void setNaverId(String naverId) {
        this.naverId = naverId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


}
