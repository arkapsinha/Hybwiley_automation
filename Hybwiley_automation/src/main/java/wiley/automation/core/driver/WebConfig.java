package wiley.automation.core.driver;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import wiley.automation.core.util.EnvUtil;

public class WebConfig {

	public static long TIMEOUT = 0;
	public static WebDriver driver = null;
	
	public static void SetTimeOut(long TimeOutInMilliSeconds)
	{
		TIMEOUT = TimeOutInMilliSeconds;
		driver.manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.MILLISECONDS);
	}
	
	public static void ResetTimeOut()
	{
		WebConfig.TIMEOUT = Long.parseLong(EnvUtil.getProperty("DRIVER_WAIT"));
		driver.manage().timeouts().implicitlyWait(WebConfig.TIMEOUT, TimeUnit.MILLISECONDS);
	}
}