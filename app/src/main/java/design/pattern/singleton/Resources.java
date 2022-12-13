package design.pattern.singleton;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

import design.pattern.App;

public class Resources {
  private static Resources resources = null;
  private static Properties props;
  
  private Resources() throws IOException {
  }
  
  synchronized public static Resources getResources() throws IOException {
    if (resources == null) {
      props = new Properties();
      ClassLoader classLoader = App.class.getClassLoader();
      InputStreamReader isr = new InputStreamReader(classLoader.getResourceAsStream("config.properties"), "utf-8");
      props.load(isr);
      resources = new Resources();
    }
    return resources;
  }

  public String get(String key) {
    return props.getProperty(key);
  }

}
