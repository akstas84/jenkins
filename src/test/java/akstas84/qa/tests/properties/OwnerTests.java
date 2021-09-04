package akstas84.qa.tests.properties;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static java.lang.String.format;
import static config.Credentials.credentials;


@Tag("properties")
public class OwnerTests {

  @Test
  void readCredentialsTest() {
    String login = credentials.login();
    String password = credentials.login();;

    System.out.println(login);
    System.out.println(password);

    String message = format("blabla  blabla", login, password);
    System.out.println(message);
  }
}
