package design.pattern;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.io.IOException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import design.pattern.singleton.NoSingletonResources;
import design.pattern.singleton.Resources;

public class SingletonTest {
    @Test
    @DisplayName("new 연산자를 사용하면 두개의 인스턴스가 다르다.")
    public void noSingletonTest() throws IOException {
        NoSingletonResources resources = new NoSingletonResources();
        NoSingletonResources resources2 = new NoSingletonResources();

        assertNotEquals(resources, resources2);
    }

    @Test
    @DisplayName("싱글톤 패턴을 사용하면 두개의 인스턴수가 같다.")
    public void singletonTest() throws IOException {
        Resources resources = Resources.getResources();
        Resources resources2 = Resources.getResources();

        assertEquals(resources, resources2);
    }
}
