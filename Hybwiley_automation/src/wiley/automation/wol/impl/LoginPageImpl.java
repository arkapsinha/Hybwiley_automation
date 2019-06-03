package wiley.automation.wol.impl;

import java.util.ArrayList;

import org.openqa.selenium.By;

import wiley.automation.core.util.CommonUtil;
import wiley.automation.core.util.ObjectLocator;
import wiley.automation.core.util.dbConnection;
import wiley.automation.wol.workflow.LoginPage;



public class LoginPageImpl extends ObjectLocator {
	
	 //static Logger log = Logger.getLogger(LoginPageImpl.class);
	 private static String msg;

	/*public boolean registerUser(String User_email) {
		// TODO Auto-generated method stub
		CommonUtil.click(loginoverlay);
		CommonUtil.sleep(2000);
		if(CommonUtil.isElementPresent(register)){
			CommonUtil.click(register);
			CommonUtil.waitForpageToLoad();
			if(CommonUtil.isElementPresent(email)
					&& CommonUtil.isElementPresent(confirm_email)
					&& CommonUtil.isElementPresent(password)
					&& CommonUtil.isElementPresent(confirm_password)
					&& CommonUtil.isElementPresent(firstName)
					&& CommonUtil.isElementPresent(lastName)
					&& CommonUtil.isElementPresent(country)
					&& CommonUtil.isElementPresent(aoi)
					&& CommonUtil.isElementPresent(atnc)
					&& CommonUtil.isElementPresent(submitReg)){
				CommonUtil.sendKeys(email, User_email);
				CommonUtil.sendKeys(confirm_email, User_email);
				CommonUtil.sendKeys(password, "password");
				CommonUtil.sendKeys(confirm_password, "password");
				CommonUtil.sendKeys(firstName, User_email.split("@")[0]);
				CommonUtil.sendKeys(lastName, User_email.split("@")[0]);
				CommonUtil.selectdropdownvaluebyvisibletext(country, "INDIA");
				CommonUtil.selectdropdownvaluebyvisibletext(aoi, "Accounting");
				CommonUtil.driver.findElement(atnc).click();
				CommonUtil.click(submitReg);
				msg = "Registration page filled and submitted";	
				//log.info(msg);
				CommonUtil.report(msg,pass);
				CommonUtil.waitForpageToLoad();
				if(CommonUtil.isElementPresent(successmessage)){
					msg = "Registration page filled and submitted";	
					//log.info(msg);
					CommonUtil.report(msg,pass);
					return true;
				}
				return false;
			}else{
				msg = "Registration page Not opened properly";	
				//log.info(msg);
				CommonUtil.report(msg,fail);
				return false;
			}
				
		}
		return false;
	}

/*	public boolean verifyAddContentXML(String user_email) {
		// TODO Auto-generated method stub
		MarkLogicImpl ml = new MarkLogicImpl();
		if(ml.verifyCreateUserXML(user_email))
			return true;
		return false;
	}

	public boolean yopmailLogin(String user_email) {
		// TODO Auto-generated method stub
		CommonUtil.isElementPresent(yopmailemail);
		CommonUtil.sendKeys(yopmailemail, user_email);
		CommonUtil.isElementPresent(yopmailsubmit);
		CommonUtil.click(yopmailsubmit);
		CommonUtil.waitForpageToLoad();
		CommonUtil.sleep(2000);
		if(CommonUtil.isElementPresent(yopmailInbox))
			return true;
		return false;
	}

	public boolean ActivateYopmailUser() {
		// TODO Auto-generated method stub
		int count = 0;
		while(true){
			CommonUtil.driver.switchTo().frame(CommonUtil.driver.findElement(By.cssSelector("iframe#ifinbox.whc")));
			if(!CommonUtil.isElementPresent(emailsubject)){
				CommonUtil.click(deletebtn);
				CommonUtil.waitForpageToLoad();
				CommonUtil.sleep(2000);
				count++;
				if(count == 10)
					break;
			}else{
				if(CommonUtil.isElementPresent(authenticationlink)){
					CommonUtil.click(authenticationlink);
					CommonUtil.sleep(5000);
					return true;
				}
				return false;
			}
			
		}
			
		return false;
	}*/
	 



	public static boolean goToMyProfile() {
		CommonUtil.sleep(2000);
		CommonUtil.clicksync(myprofilelink);
		CommonUtil.clicksync(myprofilelinkcheck);
		if(CommonUtil.verifyTextPresent(checkmyaccount, "My account")){
			msg = "Login is successfull";	
			//log.info(msg);
			CommonUtil.report(msg,pass);
			return true;
		}else{
			msg = "Login is unsuccessfull";	
			//log.info(msg);
			CommonUtil.report(msg,fail, "Present");
			return false;
		}
			}

	
	public static boolean updateUserProfile() {
		CommonUtil.sleep(2000);
		long number = (long) Math.floor(Math.random() * 9_000_000_000L) + 1_000_000_000L;
		String phone_number = "phone[0].value";
		By phone_number_link= By.id(phone_number);
		String number1= String.valueOf(number);
		CommonUtil.clear(phone_number_link);
		CommonUtil.sendKeys(phone_number_link, number1);
		CommonUtil.scrolldown(phone_number_link); 
		CommonUtil.clicksync(clickupdate);
		CommonUtil.clicksync(homepagemove);
		CommonUtil.clicksync(myprofilelink);
		CommonUtil.clicksync(myprofilelinkcheck);
		String ret_phoneNumber= CommonUtil.getAttributeValue(phone_number_link, "value");
		
		if(ret_phoneNumber.contains(number1)){
			msg = "Update is successfull";	
			//log.info(msg);
			CommonUtil.report(msg,pass);
			return true;
		}else{
			msg = "Update is unsuccessfull";	
			//log.info(msg);
			CommonUtil.report(msg,fail, "Present");
			return false;
		}
			}
	public void deleteAllSavedArticle() {
		// TODO Auto-generated method stub
		if(CommonUtil.isElementPresent(savedarticles)){
			CommonUtil.clicksync(savedarticles);
			CommonUtil.sleep(2000);
			CommonUtil.driver.findElement(selectAllCheckBox).click();
			CommonUtil.clicksync(deletearticlebtn);
			CommonUtil.sleep(2000);
			msg = "Delete all saved articles in my profile";	
			//log.info(msg);
			CommonUtil.report(msg,pass);
		}
	}

	public boolean verifySavedAAArticleReqPermission(String dOI) {
		// TODO Auto-generated method stub
		if(CommonUtil.isElementPresent(savedarticles)){
			CommonUtil.clicksync(savedarticles);
			CommonUtil.sleep(5000);
			if(!CommonUtil.isElementPresent(requestpermissioninmyprofile)){
				msg = "Request Permission not present";	
				//log.info(msg);
				CommonUtil.report(msg,pass);
				return true;
			}else{
				msg = "Request Permission not present";	
				//log.info(msg);
				CommonUtil.report(msg,fail, "Present");
				return false;
			}
		}
		return false;
	}

	public void deleteSavedPublication() {
		// TODO Auto-generated method stub
		if(CommonUtil.isElementPresent(savedpublications)){
			CommonUtil.clicksync(savedpublications);
			CommonUtil.sleep(2000);
			CommonUtil.driver.findElement(selectAllCheckBox).click();
			CommonUtil.sleep(2000);
			CommonUtil.clicksync(deletepublicationbtn);
			CommonUtil.sleep(2000);
			msg = "Delete all saved publication in my profile";	
			//log.info(msg);
			CommonUtil.report(msg,pass);
		}else{
			msg = "Delete all saved publication in my profile";	
			//log.info(msg);
			CommonUtil.report(msg,fail);
		}
	}

	public boolean verifyReferenceWorkInSavedPub() {
		// TODO Auto-generated method stub
		if(CommonUtil.isElementPresent(savedpublications)){
			CommonUtil.clicksync(savedpublications);
			CommonUtil.sleep(2000);
			if(CommonUtil.isElementPresent(referenceworkinmyprofile)){
				msg = "Reference work in saved publication present";	
				//log.info(msg);
				CommonUtil.report(msg,pass);
				return true;
			}else{
				msg = "Reference work in saved publication present";	
				//log.info(msg);
				CommonUtil.report(msg,fail);
			}
			
		}
		return false;
	}

	public void logout() {
		// TODO Auto-generated method stub
		CommonUtil.logoutMyProfile(logout);
	}

	public boolean goToSubscriptionAccess() {
		if(CommonUtil.isElementPresent(subscriptionaccesslink)){
			CommonUtil.clicksync(subscriptionaccesslink);
			msg = "Clicked on Subscription Access";	
			//log.info(msg);
			CommonUtil.report(msg,pass);
			CommonUtil.sleep(2000);
			if(CommonUtil.isElementPresent(subscriptionaccesscustid) &&
					CommonUtil.isElementPresent(subscriptionaccessaccesscode)){
				msg = "Subscription Access for Individuals page loaded";	
				//log.info(msg);
				CommonUtil.report(msg,pass);
				return true;
			}
			else{
				msg = "Subscription Access for Individuals page loaded";	
				//log.info(msg);
				CommonUtil.report(msg,fail);
				return false;
			}
		}
		msg = "Clicked on Subscription Access";	
		//log.info(msg);
		CommonUtil.report(msg,fail);
		return false;
	}

	

	public boolean verifySubscrption(boolean b) {
		// TODO Auto-generated method stub
		if(!b){
			CommonUtil.driver.getPageSource().toString().contains("The Access Code entered is invalid");
			msg = "The Access Code entered is invalid";	
			//log.info(msg);
			CommonUtil.report(msg,pass);
			return true;
		}else{
			
		}
		return false;
	}


	public static boolean loginDSSAs(String user, String password) {
		// TODO Auto-generated method stub
		if(CommonUtil.isElementPresent(DSSUser) && CommonUtil.isElementPresent(DSSPassword)){
			CommonUtil.sendKeys(DSSUser, user);
			CommonUtil.sendKeys(DSSPassword, password);
			CommonUtil.clicksync(button_login);
			msg = "DSS Login Successful";	
			CommonUtil.report(msg,pass);
			return true;
		}
		msg = "DSS Login UnSuccessful";	
		CommonUtil.report(msg,fail);
		return false;
	}

	/*public boolean enterSubscriptionDetailsforInstitution() {
		// TODO Auto-generated method stub
		ArrayList<String> details = null;
		dbConnection connection = new dbConnection();
		if(connection.getConnection(strDBTimeout, strDBName, strDBURL, strDBUserName, strDBPassword)){
			details = connection.getValue("select top 1 external_id, administration_key from customer where customer_type_id = 2 and customer_status_id = 1 and administration_key != 'null'");
		    connection.endConnection();
		    if(details != null && details.size() == 2){
		    	CommonUtil.sendKeys(subscriptionaccesscustid, details.get(0));
		    	CommonUtil.sendKeys(subscriptionaccessaccesscode, details.get(1));
		    	msg = "Customer details";	
				//log.info(msg);
				CommonUtil.report(msg,pass, details.get(0)+", "+details.get(1));
		    	CommonUtil.clicksync(subscriptionsubmit);
		    	CommonUtil.sleep(2000);
		    	msg = "submit subscription";	
				//log.info(msg);
				CommonUtil.report(msg,pass);
		    	return true;
		    }
		    msg = "submit subscription";	
			//log.info(msg);
			CommonUtil.report(msg,fail);
		    return false;
		}
		return false;
	}*/
}
