package wiley.automation.core.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import wiley.automation.core.util.CommonUtil;
import wiley.automation.wol.util.wileyWolConstants;



public class DriverManager
{
	//Logger
	//Logger log = Logger.getLogger(DriverManager.class);
	
	private static Browsers browser = null;
	public static IDriver DriverService = null;

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
					
				case MOBILE:
					DriverService = new MOBDriver();
					break;

				case SAFARI:
					DriverService = new SFDriver();
					break;
					
				
					
				case IPAD:
					break;
					
				case IPHONE_CHROME:
					DriverService = new CHDriver();
					break;
					
				case IPHONE_FIREFOX:
					DriverService = new FFDriver();
					break;
					
				case IPHONE_SAFARI:
					DriverService = new FFDriver();
					break;	
					
				case IPHONEPLUS_CHROME:
					DriverService = new CHDriver();
					break;
					
				case IPHONEPLUS_FIREFOX:
					DriverService = new FFDriver();
					break;
					
				case IPHONEPLUS_SAFARI:
					DriverService = new FFDriver();
					break;	
						
				case GOOGLEPIXCEL_CHROME:
					DriverService = new CHDriver();
					break;
					
				case GOOGLEPIXCEL_SAFARI:
					DriverService = new CHDriver();
					break;
					
				
					
				case OTHER:
					//DriverService = new HeadLessDriver();
					DriverService = (IDriver) new HtmlUnitDriver();
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