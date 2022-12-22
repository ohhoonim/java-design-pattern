package design.pattern.observer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class Broker {
    private static Broker broker = new Broker();
    private List<Channel> channels = new ArrayList<>();
    private Map<Channel, List<User>> subscribers = new HashMap<>();

    private Broker() {

    }
    public static Broker getBrokerInstance() {
        return broker;
    }
    public int publish(Channel channel) {
        channels.add(channel);
        subscribers.put(channel, new ArrayList<User>());
        return (int) channels.stream().filter(c -> c.getPublisherName().equals(channel.getPublisherName())).count();
    }
    
    public int getSubscribersCountOfChannel(Channel channel) {
        List<User> users = Optional.ofNullable(subscribers.get(channel))
                .orElse(new ArrayList<>());
        return users.size();
    }

    public void subscribe(Channel channel, User user) {
        List<User> users = Optional.ofNullable(subscribers.get(channel))
                .orElse(new ArrayList<>());
        users.add(user);
    }
    public int newVideoNotice(Channel channel) {
        List<User> users = subscribers.get(channel);
        users.forEach(user -> user.notifiedNewVideo(channel.getChannelName() + "의 신규동영상"));
        return users.size();
    }
    public int unSubscribe(Channel channel, User user) {
        List<User> users = subscribers.get(channel);
        users.remove(user);
        return users.size();
    }
    

}
