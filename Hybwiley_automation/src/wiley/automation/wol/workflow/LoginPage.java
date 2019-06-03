package wiley.automation.wol.workflow;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import wiley.automation.core.util.CommonUtil;
import wiley.automation.wol.impl.LoginPageImpl;



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
    
 
    public static void typeUsername(String username) {
    	try{
    		CommonUtil.driver.findElement(usernameLocator).click();
    		CommonUtil.driver.findElement(usernameLocator).sendKeys(username);
    		CommonUtil.report("Enter Username in the text field ","Pass");
            
    	}catch(Exception e){
    		
    		msg = "Enter Username in the text field";	
        	//log.fatal(msg);
        	CommonUtil.report(msg,fail);
    		//CommonUtil.report("Enter Username in the text field ",fail,e.getMessage());
    		//return null;
    		}
    }

    public static void typePassword(String password) {
    	try{
    		CommonUtil.driver.findElement(passwordLocator).click();
    		CommonUtil.driver.findElement(passwordLocator).sendKeys(password);
    		CommonUtil.report("Enter Password in the text field","Pass");
        }catch(Exception e){
        	msg = "Enter Password in the text field";	
        	//log.fatal(msg);
        	CommonUtil.report(msg,fail);
    		//CommonUtil.report(msg,"Fail",e.getMessage());
    		//return null;
    		}    
    }


	public static LiteratumPage submitLogin() {
		try{
			CommonUtil.clicksync(loginButtonLocator);
			msg = "Click on login";
			//log.info(msg);
			CommonUtil.report(msg,pass);
			
        return PageFactory.initElements(driver, LiteratumPage.class);
       
        }catch(Exception e){
        	msg = "Click on login";	
        	//log.fatal(msg);
        	CommonUtil.report(msg,fail,e.getMessage());
    		return null;
    		}    
    }


    public static LiteratumPage loginAs(String username, String password) {
    	if(CommonUtil.isElementPresent(loginchecker)){
    		CommonUtil.waitForpageToLoad();
    		CommonUtil.click(loginchecker);
    		CommonUtil.sleep(2000);
    		typeUsername(username);
    		typePassword(password);
    	}
        return submitLogin();
        
    }
    public static LiteratumPage ProcessingQueueloginAs(String username, String password) {
    	
    		typeUsername(username);
    		typePassword(password);
    
        return submitLogin();
        
    }
   /* 
    public HomePage homepage() {
		return PageFactory.initElements(driver, HomePage.class);
	}
    
    public LicenseSourcePage licensesourcepage() {
		return PageFactory.initElements(driver, LicenseSourcePage.class);
	}


	public boolean registerUser(String User_email) {
		if(super.registerUser(User_email))
			return true;
		return false;
	}





	public boolean yopmailLogin(String user_email) {
		// TODO Auto-generated method stub
		if(super.yopmailLogin(user_email))
			return true;
		return false;
	}


	public boolean ActivateYopmailUser() {
		// TODO Auto-generated method stub
		if(super.ActivateYopmailUser())
			return true;
		return false;
	}





	public static boolean goToMyProfile() {
		// TODO Auto-generated method stub
		if(LoginPageImpl.goToMyProfile())
			return true;
		return false;
			
	}
	
	public static boolean updateUserProfile() {
		// TODO Auto-generated method stub
		if(LoginPageImpl.updateUserProfile())
			return true;
		return false;
			
	}
	public void deleteAllSavedArticle() {
		// TODO Auto-generated method stub
		super.deleteAllSavedArticle();
	}


	public boolean verifySavedAAArticleReqPermission(String dOI) {
		// TODO Auto-generated method stub
		if(super.verifySavedAAArticleReqPermission(dOI))
			return true;
		return false;
	}


	public void deleteSavedPublication() {
		// TODO Auto-generated method stub
		super.deleteSavedPublication();
	}


	public boolean verifyReferenceWorkInSavedPub() {
		// TODO Auto-generated method stub
		if(super.verifyReferenceWorkInSavedPub())
			return true;
		return false;
	}


	public void logout() {
		// TODO Auto-generated method stub
		super.logout();
	}


	public boolean goToSubscriptionAccess() {
		// TODO Auto-generated method stub
		return super.goToSubscriptionAccess();
		
	}



	public boolean verifySubscrption(boolean b) {
		// TODO Auto-generated method stub
		return super.verifySubscrption(b);
	}


	public boolean enterSubscriptionDetailsforInstitution() {
		// TODO Auto-generated method stub
		return super.enterSubscriptionDetailsforInstitution();
	}*/
	
	public static boolean verifyLoginPage(String username) {
    	try{
    		CommonUtil.sleep(2000);
    		CommonUtil.driver.findElement(usernameLocator1).click();
    		CommonUtil.driver.findElement(usernameLocator1).sendKeys(username);
    		CommonUtil.report("Enter Username in the text field ","Pass");
            return true;
    	}catch(Exception e){
    		
    		msg = "Enter Username in the text field";	
        	//log.fatal(msg);
        	CommonUtil.report(msg,fail);
    		//CommonUtil.report("Enter Username in the text field ",fail,e.getMessage());
    		return false;
    		}
    }


	public static boolean loginDSSAs(String user, String password) {
		// TODO Auto-generated method stub
		return LoginPageImpl.loginDSSAs(user, password);
	}

}
