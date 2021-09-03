package akstas84.qa.tests.properties;


import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("properties")
public class SystemPropertiesTests {
  @Test
  public void test1(){
    System.out.println("[test1] Browser: " + System.getProperty("browser"));
  }
  @Test
  public void readNullFromPropertyTest(){
    String value = System.getProperty("our_property");
    System.out.println(value);
  }
  @Test
  public void readDefaultFromPropertyTest(){
    String value = System.getProperty("our_property", "default_value");
    System.out.println(value);
  }
  @Test
  public void readWithTerminalFromPropertyTest(){
    String browser = System.getProperty("browser", "chrome");
    String version = System.getProperty("version", "91");
    System.out.println(browser);
    System.out.println(version);
  }

}
