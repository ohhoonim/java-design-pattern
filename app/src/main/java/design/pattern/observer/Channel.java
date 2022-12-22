package design.pattern.observer;

import java.util.ArrayList;
import java.util.List;

public class Channel {
    private String channelName;
    private User publisher;
    List<User> users = new ArrayList<>();

    public Channel(String channelName) {
        this.channelName = channelName;

    }

    public Channel(String channelName, User publisher) {
        this.channelName = channelName;
        this.publisher = publisher;
    }

    public String getChannelName() {
        return this.channelName;
    }

    public String getPublisherName() {
        return this.publisher.getUserName();
    }

    public void subscribe(User user) {
        users.add(user);
    }

    public int newVideoNotice(String newVideoTitle) {
        this.users.forEach(user -> user.notifiedNewVideo(newVideoTitle));
        return this.users.size();
    }

    public int unSubscribe(User user) {
        users.remove(user);
        return this.users.size();
    }

}
