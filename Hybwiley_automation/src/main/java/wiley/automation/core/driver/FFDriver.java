package wiley.automation.core.driver;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import wiley.automation.wol.util.wileyWolConstants;



class FFDriver implements IDriver 
{
	//Logger
	//Logger log = Logger.getLogger(FFDriver.class);
	public static String pass = "Pass";
	public static String fail = "Fail";
	private static long PageLoadTimeOut =0; 
	private static WebDriver driver = null;

	FFDriver()
	{
		PageLoadTimeOut = wileyWolConstants.PAGE_LOAD_TIME_OUT;
	}
	
	
	public void startService() 	{
		// TODO Auto-generated method stub
	}

	
	public void stopService() {
		// TODO Auto-generated method stub

	}

	
	public void startDriver()
	{
		try{
		//File pathBinary = new File("C:\\Program Files\\Mozilla Firefox\\firefox.exe");
		//FirefoxBinary Binary = new FirefoxBinary(pathBinary);
		//FirefoxProfile firefoxPro = new FirefoxProfile();      
		//driver = new FirefoxDriver(Binary,firefoxPro); 	
		//driver = new FirefoxDriver();
		//driver = new RemoteWebDriver(new URL("http://10.6.6.228:4444/wd/hub"), DesiredCapabilities.firefox())
		//http://10.6.6.228:4444/wd/hub
//			FirefoxProfile profile = new ProfilesIni().getProfile("default");
//			profile.setPreference("network.cookie.cookieBehavior", 2);
//			driver = new FirefoxDriver(profile);
////			
			
			
			ProfilesIni firProfiles = new ProfilesIni();
			DesiredCapabilities dc=DesiredCapabilities.firefox();
			FirefoxProfile wbdrverprofile = firProfiles.getProfile("default");
			dc.setCapability(FirefoxDriver.PROFILE, wbdrverprofile);
			driver = new FirefoxDriver();
//			
			
			
			
		//driver = new RemoteWebDriver(new URL("http://192.168.56.47:4444/wd/hub"),DesiredCapabilities.firefox());
		//	driver = new RemoteWebDriver(new URL("http://192.168.56.47:4444/wd/hub"),dc.firefox());
		
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		// Create Firefox Profile  
        /*FirefoxProfile profile = new FirefoxProfile();  
		ProfilesIni profile = new ProfilesIni();
		FirefoxProfile myprofile = profile.getProfile("default");
        // Accept Untrusted Certificates  
		profile.setAcceptUntrustedCertificates(true);
		//myprofile.setAssumeUntrustedCertificateIssuer(true);
		driver = new FirefoxDriver(profile);
		String msg = "Firefox Driver setAcceptUntrustedCertificates(true)";	
		log.info(msg);
		CommonUtil.report(msg, pass);
		System.out.println(msg);*/
		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(PageLoadTimeOut, TimeUnit.MILLISECONDS);
		}catch(Exception e){e.printStackTrace();
		}
	}

	
	public void stopDriver() {
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

	
	public WebDriver get() {
		if(null==driver)
			this.startDriver();
		return driver;
	}

	
	public boolean isServiceRunning() {
		// TODO Auto-generated method stub
		return true;
	}
	
	

}