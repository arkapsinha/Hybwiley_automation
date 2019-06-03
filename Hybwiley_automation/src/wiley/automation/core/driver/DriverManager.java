package wiley.automation.core.driver;

import org.openqa.selenium.WebDriver;

import wiley.automation.core.util.CommonUtil;
import wiley.automation.wol.util.wileyWolConstants;



public class DriverManager
{
	//Logger
	//Logger log = Logger.getLogger(DriverManager.class);
	
	private static Browsers browser = null;
	private static IDriver DriverService = null;

	//Constructors
	public DriverManager() {};
	
	public static WebDriver startDriver(String browsertype)
	{
		browser = Browsers.get(browsertype);

		if(null==DriverService)
		{
			switch(browser)
			{
				case IE:
					DriverService = new IEDriver();
					break;

				case FIREFOX:
					DriverService = new FFDriver();
					break;

				case CHROME:
					DriverService = new CHDriver();
					break;

				case SAFARI:
					DriverService = new SFDriver();
					break;
					
				case NEXUS:
					DriverService = new AndroidMobileDriver(wileyWolConstants.GALAXY_NEXUS_SERIALID);
					break;
					
				case IPAD:
					break;
					
				case IPHONE:
					break;
					
				case TOSHIBA:
					DriverService = new AndroidMobileDriver(wileyWolConstants.TOSHIBA_SERIALID);
					break;
					
				case OTHER:
					DriverService = new HeadLessDriver();
					break;
					
				default:
					break;	
			}
		}
		
		if(!DriverService.isServiceRunning())
			DriverService.startService();
		
		return DriverService.get();
	}

	
	public static void stopDriver()
	{
		if(null!=DriverService && DriverService.isServiceRunning())
			DriverService.stopDriver();
	}

	public static void stopService()
	{
		if(null!=DriverService && DriverService.isServiceRunning())
			DriverService.stopService();
	}
	
	public static void killAllDriverServices()
	{
		CommonUtil.killProcess("chromedriver.exe");
		CommonUtil.killProcess("IEDriverServer.exe");
	}
	
}