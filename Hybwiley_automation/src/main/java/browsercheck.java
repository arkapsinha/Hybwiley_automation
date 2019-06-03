import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public class browsercheck {

  public static final String USERNAME = "arka9";
  public static final String AUTOMATE_KEY = "RGnz6K5nyCZa8Thrzycn";
  public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

  public static void main(String[] args) throws Exception {

    DesiredCapabilities caps = new DesiredCapabilities();
    caps.setCapability("browserstack.local", "true");
    caps.setCapability("browser", "IE");
    caps.setCapability("browser_version", "11.0");
    caps.setCapability("os", "Windows");
    caps.setCapability("os_version", "10");
    caps.setCapability("resolution", "1024x768");

    WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
    driver.get("http://almqa2.wiley.com/identity/");
    Thread.sleep(10000);
//    WebElement element = driver.findElement(By.name("q"));
//
//    element.sendKeys("BrowserStack");
//    element.submit();

    System.out.println(driver.getTitle());
    driver.quit();

  }
}
