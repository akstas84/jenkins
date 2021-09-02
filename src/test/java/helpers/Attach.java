package helpers;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.nio.charset.StandardCharsets;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.openqa.selenium.logging.LogType.BROWSER;

public class Attach {

  @Attachment(value = "{attachName}", type = "text/plain")
  public static String attachAsText(String attachName, String message){
    return message;
  }
  @Attachment(value = "Page Source", type = "text/plain")
  public static byte[] pageSource(){
    return getWebDriver().getPageSource().getBytes(StandardCharsets.UTF_8);
  }
  @Attachment(value = "{attachName}", type = "image/png")
  public static byte[] screenShotAs(String attachName){
    return ((TakesScreenshot) getWebDriver()).getScreenshotAs(OutputType.BYTES);
  }

  public static void browserConsoleLogs(String attachName, String message){
    attachAsText(
            "Browser console logs",
            String.join("\n", Selenide.getWebDriverLogs(BROWSER))
    );
  }

}
