package wiley.automation.core.driver;

import javax.sql.CommonDataSource;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import wiley.automation.core.util.CommonUtil;



public class WebBrowser{


		//Logger
		//Logger log = Logger.getLogger(WebBrowser.class);	
	
		WebBrowser() {};
		
		private static WebDriver driver = null;

		
		public void setBrowserType(String BrowserType)
		{
			//log.info("Browser Type=" + BrowserType);
			driver = DriverManager.startDriver(BrowserType);
			WebConfig.driver = driver;
		}
		
		public void NavigateTo(String BrowserType, String URL)
		{
			setBrowserType(BrowserType);
			
			if (BrowserType.equals("ie")){
				driver.get(URL);
				if(driver.findElements(By.linkText("Continue to this website (not recommended).")).size() > 0)
					driver.findElement(By.linkText("Continue to this website (not recommended).")).click();
			}
			else{			
			//log.info("Passed URL=" + URL);
			driver.get(URL);
			//driver.findElement(By.linkText("Continue to this website (not recommended).")).click();
			//Runtime.getRuntime().exec("C:\\Users\\tamondal\\Desktop\\AutoIT\\handlepopup.exe");
			//assertTrue(OBook_Content.BPALogin(BPAUserName,BPAPassword), "BPA Login is not Successful");
			}
		}
		
		
		public void NavigateTo(String URL)
		{
			//log.info("Passed URL=" + URL);
			driver.get(URL);
			
			
		}
		
		public void NavigateToIE(String URL)
		{
			//log.info("Passed URL=" + URL);
			driver.get(URL);
			//driver.findElement(By.linkText("Continue to this website (not recommended).")).click();
			
		}
		
		public WebDriver getDriver()
		{
			return driver;
		}
		
		public void Quit()
		{
			
			//log.info("Closing the Browser");
			DriverManager.stopDriver();
			//log.info("Browser & pages nullified");

		}
		
}