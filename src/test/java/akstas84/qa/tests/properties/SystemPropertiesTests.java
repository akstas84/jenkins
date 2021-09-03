package akstas84.qa.tests.properties;


import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("properties")
public class SystemPropertiesTests {
  @Test
  public void test1(){
    System.out.println("[test1] Browser: " + System.getProperty("browser"));
  }

}
