package design.pattern.observer;

public class User {
    private String userName;

    public User(String userName) {
        this.userName = userName;
    }

    public String notifiedNewVideo(String newVideoTitle) {
        String receivedMessage = userName + "님 " +newVideoTitle + "이 업로드 되었습니다."; 
        System.out.println(receivedMessage);
        return receivedMessage ;
    }

    public String getUserName() {
        return this.userName;
    }
}
