package wiley.automation.wol.workflow;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import wiley.automation.core.util.CommonUtil;
import wiley.automation.core.util.EnvUtil;
import wiley.automation.wol.impl.LoginPageImpl;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.LogStatus;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;



public class LoginPage extends LoginPageImpl {
	private static String msg;
	 
	//static Logger log = Logger.getLogger(LoginPage.class);
	 
	private static WebDriver driver;

    public LoginPage(WebDriver driver) {
        LoginPage.driver = driver;

        // Check that we're on the right page.
        /*if (!"Wiley Online Library".equals(driver.getTitle())) {
            // Alternatively, we could navigate to the login page, perhaps logging out first
            throw new IllegalStateException("This is not the login page");
        }*/
    }
    
    
    
 

    
    public static boolean LoginWEL(String username, String password,ExtentTest test) {
		// TODO Auto-generated method stub
		return LoginPageImpl.LoginWEL(username, password, test);
	}






	public static boolean LoginHAC(String username, String password, ExtentTest test) {
		// TODO Auto-generated method stub
		return LoginPageImpl.LoginHAC(username, password, test);
	}
    
    



}
