package design.pattern.singleton;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

import design.pattern.App;

public class NoSingletonResources {
  private Properties props;
  
  public NoSingletonResources() throws IOException {
    System.out.println("NoSingletonResources loading...");
    props = new Properties();
    ClassLoader classLoader = App.class.getClassLoader();
    InputStreamReader isr = new InputStreamReader(classLoader.getResourceAsStream("config.properties"), "utf-8");
    props.load(isr);
  }
  
  public String get(String key) {
    return props.getProperty(key);
  }

}
