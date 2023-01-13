package design.pattern;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.junit.jupiter.api.Test;
import design.pattern.decorator.NoDecoTitle;
import design.pattern.decorator.Title;
import design.pattern.decorator.TitleAstarDeco;
import design.pattern.decorator.TitleDashDeco;

public class DecoratorTest {
    @Test
    public void decorator_pattern() {
        Title title = new NoDecoTitle();
        title.setTitle("Hi, there!");
        assertEquals("Hi, there!", title.display());
        
        Title decoTitleDash = new TitleDashDeco(title);
        assertEquals("--Hi, there!--", decoTitleDash.display());

        Title decoTitleAstar = new TitleAstarDeco(decoTitleDash);
        assertEquals("**--Hi, there!--**", decoTitleAstar.display());
    }

    

    @Test
    public void javaIoTest() throws IOException {
        Properties props = new Properties();
        InputStream configStream = ClassLoader.getSystemResourceAsStream("config.properties"); 
        // decorator
        BufferedInputStream buffered = new BufferedInputStream(configStream);
        // props.load(configStream); 
        props.load(buffered); 
        String helloEn = props.getProperty("hello.en");
        assertEquals("hello", helloEn);
    }

}
