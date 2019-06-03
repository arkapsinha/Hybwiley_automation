package wiley.automation.wol.workflow;

import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.LogStatus;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import wiley.automation.core.util.ObjectLocator;
import wiley.automation.wol.impl.WELImpl;


public class WEL_Page extends ObjectLocator {

	private final WebDriver driver;
	
	//static Logger log = Logger.getLogger(HomePage.class);

	
	static WELImpl alm;

	public WEL_Page(WebDriver driver) {
		this.driver = driver;
		alm = new WELImpl();
		// Check that we're on the right page.
		
	}

	
	
	public static boolean clickOnLinkSync(String string, ExtentTest test) {
		return WELImpl.clickOnLinkSync(string, test);
	}
	
	public static String createCustomer(ExtentTest test) {
		return WELImpl.createCustomer(test);
	}
	
	public static boolean disableCaptcha(ExtentTest test) {
		return WELImpl.disableCaptcha(test);
	}



	public static boolean enableCaptcha(ExtentTest test) {
		// TODO Auto-generated method stub
		return WELImpl.enableCaptcha(test);
	}



	public static boolean payment(String username, String password, ExtentTest test) {
		// TODO Auto-generated method stub
		return WELImpl.payment(username,password,test);
	}
	
	public static boolean studentDiscountpayment(String username, String password, ExtentTest test) {
		// TODO Auto-generated method stub
		return WELImpl.studentDiscountpayment(username,password,test);
	}



	public static boolean checkaddtocart(String course,ExtentTest test) {
		// TODO Auto-generated method stub
		return WELImpl.checkaddtocart(course,test);
	}
	
	
	
}
