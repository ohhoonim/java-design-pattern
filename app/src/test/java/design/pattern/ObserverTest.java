package design.pattern;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import design.pattern.observer.Broker;
import design.pattern.observer.Channel;
import design.pattern.observer.User;

public class ObserverTest {
    @Test
    public void observerTest() {
        // 채널 생성
        Channel channel = new Channel("하찮은오후");

        // dean 유저가 구독
        User userDean = new User("dean");
        channel.subscribe(userDean);
        // sam 유저가 구독
        User userSam = new User("sam");
        channel.subscribe(userSam);

        // 신규 동영상이 등록되어 구독자들에게 알림 발송
        int subscribersSize = channel.newVideoNotice("신규동영상-Observer Pattern");
        // 알람발송이 2건 이루어졌는지 체크
        assertEquals(2, subscribersSize);

        // sam이 구독을 취소
        subscribersSize = channel.unSubscribe(userSam);
        assertEquals(1, subscribersSize);
    }

    @Test
    public void publisherSubcriberTest() {
        User userMatthew = new User("matthew");

        Broker broker = Broker.getBrokerInstance();
        Channel ohhoonimChannel = new Channel("하찮은오후", userMatthew);
        int channelsCountOfMatthew = broker.publish(ohhoonimChannel);
        // matthew가 발행한 채널 수
        assertEquals(1, channelsCountOfMatthew);
        // 사용자
        User userDean = new User("dean");
        User userSam = new User("sam");
        User userKastiel = new User("Kastiel");
        User userJack = new User("Jack");
        // 채널 구독 등록
        broker.subscribe(ohhoonimChannel, userDean);
        broker.subscribe(ohhoonimChannel, userSam);
        broker.subscribe(ohhoonimChannel, userKastiel);
        broker.subscribe(ohhoonimChannel, userJack);

        int subscribersOfChannel = broker.getSubscribersCountOfChannel(ohhoonimChannel);
        assertEquals(4, subscribersOfChannel);
        // 채널 주인장이 broker에 notice를 요청
        subscribersOfChannel = broker.newVideoNotice(ohhoonimChannel);
        assertEquals(4, subscribersOfChannel);
        // Jack이 구독 취소
        broker.unSubscribe(ohhoonimChannel, userJack);
        subscribersOfChannel = broker.getSubscribersCountOfChannel(ohhoonimChannel);
        assertEquals(3, subscribersOfChannel);

        // 채널 추가 
        Channel cleanChannel = new Channel("가뿐한오전", userMatthew);
        channelsCountOfMatthew = broker.publish(cleanChannel);
        assertEquals(2, channelsCountOfMatthew);

        broker.subscribe(cleanChannel, userDean);
        broker.subscribe(cleanChannel, userSam);
        subscribersOfChannel = broker.getSubscribersCountOfChannel(cleanChannel);
        assertEquals(2, subscribersOfChannel);

        subscribersOfChannel = broker.newVideoNotice(ohhoonimChannel);
        assertEquals(3, subscribersOfChannel);
        subscribersOfChannel = broker.newVideoNotice(cleanChannel);
        assertEquals(2, subscribersOfChannel);
    }
}
