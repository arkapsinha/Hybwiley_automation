package wiley.automation.core.driver;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

import wiley.automation.wol.util.wileyWolConstants;



class IEDriver implements IDriver {

	//Logger
	//Logger log = Logger.getLogger(IEDriver.class);
	
	private static long PageLoadTimeOut =0; 
	private static InternetExplorerDriverService ieService = null;
	private static WebDriver driver = null;
	
	IEDriver()
	{
		PageLoadTimeOut = wileyWolConstants.PAGE_LOAD_TIME_OUT;
	}
	
	@Override
	public void startService() 
	{			
			System.setProperty(wileyWolConstants.IE_DRIVER, wileyWolConstants.IE_DRIVER_SERVER);
			
			if(!wileyWolConstants.IE_USE_GIVEN_PORT)
				ieService = new InternetExplorerDriverService.Builder()
						 .usingDriverExecutable(new File(wileyWolConstants.IE_DRIVER_SERVER))
						 .usingAnyFreePort()
						 .build();
			else
				ieService = new InternetExplorerDriverService.Builder()
			 			.usingDriverExecutable(new File(wileyWolConstants.IE_DRIVER_SERVER))
			 			.usingPort(wileyWolConstants.IE_PORT)
			 			.build();
			
			try 
			{
				ieService.start();
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
	}

	@Override
	public void stopService() 
	{
		try
		{
			if(null!=ieService)
				ieService.stop();
		}
		catch(Exception e)
		{
			//log.fatal("Error Occurred while stopping IE server\n" + e.getMessage());
		}
		finally
		{
			ieService = null;
		}
	}

	@Override
	public void startDriver() 
	{
		DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();
		ieCapabilities.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
		
		driver = new InternetExplorerDriver(ieService, ieCapabilities);
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