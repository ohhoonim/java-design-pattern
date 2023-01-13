package design.pattern;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import design.pattern.iterator.Bicycle;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class IteratorTest {
    // 반복자 패턴은 for문, while문과 같이 데이터집합을 반복처리하기위한
    // 디자인 패턴이다. jdk8부터 람다식을 사용할 수 있으니 쓸일은 없을 것 같다. 
    @Test
    public void for_statement()  {
        String[] names = {"matthew", "alison", "jack", "dean", "sam"};
        for(String name : names) {
            System.out.println(name);
        }
    }

    // java의 List와 Set은 반복자 패턴을 사용한다. 
    @Test void 반복자_패턴() {
        List<Bicycle> bicycleList = List.of(
            Bicycle.builder().name("samchulli korea").height(100).width(200).length(140).build(),
            Bicycle.builder().name("samchulli world").height(100).width(200).length(140).build(),
            Bicycle.builder().name("samchulli japan").height(100).width(200).length(140).build()
        ) ;
       
        Iterator<Bicycle> iter = bicycleList.iterator();
        while(iter.hasNext()) {
            Bicycle cycle = iter.next();
            System.out.println(cycle.getName());
        }
    }
}
