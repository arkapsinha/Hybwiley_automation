//
// 
//import io.appium.java_client.AppiumDriver;
//import io.appium.java_client.MobileElement;
//import io.appium.java_client.android.AndroidDriver;
//import java.io.File;
//import java.net.MalformedURLException;
//import java.net.URL;
//import java.util.concurrent.TimeUnit;
//
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.remote.CapabilityType;
//import org.openqa.selenium.remote.DesiredCapabilities;
// 
//public class appiumTesting {
// 
//		//private static AndroidDriver driver;
//		@SuppressWarnings("rawtypes")
//		public static void main(String[] args) throws MalformedURLException, InterruptedException {
// 
//			File classpathRoot = new File(System.getProperty("user.dir"));
//			File appDir = new File(classpathRoot, "/Apps/Amazon/");
//			File app = new File(appDir, "in.amazon.mShop.android.shopping_2018-06-29.apk");
// 
//			DesiredCapabilities capabilities = new DesiredCapabilities();
//			//capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
//			capabilities.setCapability("deviceName", "Nexus S");
//			capabilities.setCapability("platformVersion", "7.1.1");
//			capabilities.setCapability("platformName", "Android");
//			/*capabilities.setCapability("app", app.getAbsolutePath());
//			capabilities.setCapability("appPackage", "in.amazon.mShop.android.shopping");
//			capabilities.setCapability("appActivity", "com.amazon.mShop.home.HomeActivity");
// 
//			driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
//			driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
//*/			
//			
//			capabilities.setCapability("browserName", "Chrome");
//			capabilities.setCapability("noReset", true);
//			
//			//Set ChromeDriver location
//			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//browserserver//Mobile//chromedriver.exe");
//			
//			//Instantiate Appium Driver
//			AppiumDriver<MobileElement> driver = null;
//			try {
//				driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
//				
//			} catch (MalformedURLException e) {
//				System.out.println(e.getMessage());
//			}
//					
//			//Open URL in Chrome Browser
//			driver.get("http://www.google.com");
//			
//			
//			
//			Thread.sleep(10000);
//			driver.quit();
// 
//	}
// 
//}