package design.pattern;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import design.pattern.singleton.NoSingletonResources;
import design.pattern.singleton.Resources;

public class SingletonTest {
    @Test
    public void noSingletonTest() throws IOException {
        NoSingletonResources resources = new NoSingletonResources();
        NoSingletonResources resources2 = new NoSingletonResources();

        assertNotEquals(resources, resources2);
    }

    @Test
    public void singletonTest() throws IOException {
        Resources resources = Resources.getResources();
        Resources resources2 = Resources.getResources();

        assertEquals(resources, resources2);
    }
}
