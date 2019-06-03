package wiley.automation.core.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

import wiley.automation.wol.util.wileyWolConstants;



class SFDriver implements IDriver {

	//Logger
	//Logger log = Logger.getLogger(SFDriver.class);
	
 
	private static SafariOptions so = null;
	private static WebDriver driver = null;
	
	
	
	public void startService()
	{
		so = new SafariOptions();
		if(wileyWolConstants.SAFARI_USE_GIVEN_PORT)
		{
			so.setPort(wileyWolConstants.SAFARI_PORT);
		}
		so.setUseCleanSession(true);
	}

	
	public void stopService() {
		// TODO Auto-generated method stub
	}

	
	public void startDriver() 
	{
		driver = new SafariDriver(so);
		driver.manage().window().maximize();
	}

	
	public void stopDriver() 
	{
		try
		{
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

	
	public WebDriver get()
	{
		if(null==driver)
			this.startDriver();
		return driver;
	}
	
	
	public boolean isServiceRunning()
	{
		if(null!=so)
			return true;
		else
			return false;
	}
	
}