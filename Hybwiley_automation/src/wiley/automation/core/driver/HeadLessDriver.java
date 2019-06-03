package wiley.automation.core.driver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriverService;

import wiley.automation.wol.util.wileyWolConstants;



class HeadLessDriver implements IDriver {

	//Logger
	//Logger log = Logger.getLogger(HeadLessDriver.class);
	
	private static long PageLoadTimeOut =0; 
	private static InternetExplorerDriverService ieService = null;
	private static WebDriver driver = null;
	
	HeadLessDriver()
	{
		PageLoadTimeOut = wileyWolConstants.PAGE_LOAD_TIME_OUT;
	}
	
	@Override
	public void startService() 
	{			
			
	}

	@Override
	public void stopService() 
	{
		
	}

	@Override
	public void startDriver() 
	{
		/*DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();
		ieCapabilities.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
		
		driver = new InternetExplorerDriver(ieService, ieCapabilities);*/
		
		driver = new HtmlUnitDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(PageLoadTimeOut, TimeUnit.MILLISECONDS);
	}

	@Override
	public void stopDriver() 
	{
		try
		{
			driver.close();
			driver.quit();
		}
		catch(Exception e)
		{
			//log.fatal("Exception while stopping the driver\n" + e.getMessage());
		}
		finally
		{
			driver = null;
		}
	}

	@Override
	public WebDriver get() 
	{
		if(null==driver)
			this.startDriver();
		
		return driver;
	}

	@Override
	public boolean isServiceRunning() {
		if(null!=ieService)
			return true;
		else
			return false;
	}

}