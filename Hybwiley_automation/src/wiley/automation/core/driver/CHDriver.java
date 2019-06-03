package wiley.automation.core.driver;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import wiley.automation.core.util.OS;
import wiley.automation.wol.util.wileyWolConstants;


class CHDriver implements IDriver {

	//Logger
	//Logger log = Logger.getLogger(CHDriver.class);
	
	private static long PageLoadTimeOut =0; 
	private static ChromeDriverService chService = null;
	private static WebDriver driver = null;

	CHDriver()
	{
		PageLoadTimeOut = wileyWolConstants.PAGE_LOAD_TIME_OUT;
	}
	
	@Override
	public void startService()
	{		
		//Kill existing running service
		//CommonUtil.killProcess(QiReEngGlobalConstants.CHROME_DRIVER_SERVER);
		
		//String ChromeDriverServer = wileyWolConstants.CHROME_DRIVER_SERVER;
		String ChromeDriverServer = System.getProperty("user.dir")+"/browserserver/chromedriver.exe";
				
		if(OS.get()==OS.MAC)
		{
			try 
			{
				//make it executable
				Runtime.getRuntime().exec("chmod 777 " + ChromeDriverServer);
			}
			catch (IOException e)
			{
				////log.fatal("UNABLE TO START CHROME DRIVER SERVER\n" + e.getMessage());
				//log.fatal("UNABLE TO START CHROME DRIVER SERVER\n" + e.getMessage());
			}
		}	
		
		System.setProperty(wileyWolConstants.CHROME_DRIVER, ChromeDriverServer);
	
		if(!wileyWolConstants.CHROME_USE_GIVEN_PORT)
			chService = new ChromeDriverService.Builder()
					 .usingDriverExecutable(new File(ChromeDriverServer))
					 .usingAnyFreePort()
					 .build();
		else
			chService = new ChromeDriverService.Builder()
					 .usingDriverExecutable(new File(ChromeDriverServer))
					 .usingPort(wileyWolConstants.CHROME_PORT)
					 .build();			
		try 
		{
			chService.start();
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
			if(null!=chService)
				chService.stop();
		}
		catch(Exception e)
		{
			//log.fatal("Error Occurred while stopping Chrome server\n" + e.getMessage());
		}
		chService = null;
	}

	@Override
	public void startDriver() 
	{	
		try{
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
	    ChromeOptions options = new ChromeOptions();
	    Map<String, Object> prefs = new HashMap<String, Object>();
	    prefs.put("profile.default_content_settings.popups", 0);
	    //prefs.put( "profile.content_settings.pattern_pairs.*.multiple-automatic-downloads", 1 );
	    //prefs.put("profile.default_content_setting_values.notifications", 1);
	    //prefs.put("download.default_directory", "D:\\downloads");
	    //prefs.put("savefile.default_directory", "D:\\downloads");
	    options.setExperimentalOption("prefs", prefs);
	    options.addArguments("test-type");
	    options.addArguments("disable-popup-blocking");
	    capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		driver = new ChromeDriver(chService, capabilities);
	    //driver = new RemoteWebDriver(new URL("http://192.168.56.47:4444/wd/hub"),capabilities);
	    //driver = new RemoteWebDriver(new URL("http://10.135.15.67:4444/wd/hub"),capabilities);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(PageLoadTimeOut, TimeUnit.MILLISECONDS);	
		System.out.println("********************************************************");
		System.out.println();
		}catch(Exception e){
			
		}
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
	public WebDriver get() {
		
		if(null==driver)
			this.startDriver();
		
		return driver;
	}
	
	@Override
	public boolean isServiceRunning() {
		if(null!=chService)
			return true;
		else
			return false;
	}

}