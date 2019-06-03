package wiley.automation.wol.impl;


import static org.testng.Assert.assertTrue;

import java.sql.Array;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import org.testng.ITestResult;
import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.HasInputDevices;
import org.openqa.selenium.interactions.Mouse;
import org.openqa.selenium.internal.Locatable;
import org.openqa.selenium.support.ui.Select;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.LogStatus;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import wiley.automation.core.util.CommonUtil;
import wiley.automation.core.util.EnvUtil;
import wiley.automation.core.util.ObjectLocator;
//import wiley.automation.wol.impl.Sample.Season;
import wiley.automation.wol.workflow.LoginPage;

public class WELImpl extends ObjectLocator {

 static //Logger log = Logger.getLogger(HomePageImpl.class);
 String msg;
 static String idname,getDOI;
 static int k=1;
 static int q=1;
 static int rowtocheck=0;

 public static void navigateToProcessQueuePage() {
		
	 CommonUtil.refresh(EnvUtil.getProperty("Literatum_APPLICATION_URL_Process_Queue"));
		CommonUtil.sleep(2000);
		
	}

public static boolean hoverOn(String string) {
	// TODO Auto-generated method stub
	CommonUtil.sleep(2000);
	By by = By.linkText(string);
	CommonUtil.mouseOverAction(by);
	CommonUtil.sleep(2000);
	msg = "MouseOver on "+string+" Successful";	
	CommonUtil.report(msg,pass);
	return true;
}


public static boolean clickOnLinkSync(String linktext, ExtentTest test) {
	// TODO Auto-generated method stub
	By by = By.linkText(linktext);
		if(CommonUtil.isElementPresent(by)){
			CommonUtil.clicksync(by);
			msg = "clicked on "+linktext+" Successful";	
			test.log(Status.PASS, MarkupHelper.createLabel(msg, ExtentColor.GREEN));
			//test.log(LogStatus.PASS, msg);
			CommonUtil.report(msg,pass, test);
			return true;
	}
	msg = "clicked on "+linktext+" UnSuccessful";
	test.log(Status.PASS, MarkupHelper.createLabel(msg, ExtentColor.RED));
	CommonUtil.report(msg,fail,test);
	return false;
}


	

public static boolean clickOnLink(String linktext) {
	// TODO Auto-generated method stub
	By by = By.linkText(linktext);
		if(CommonUtil.isElementPresent(by)){
			CommonUtil.click(by);
			msg = "clicked on "+linktext+" Successful";	
			CommonUtil.report(msg,pass);
			return true;
	}
	msg = "clicked on "+linktext+" UnSuccessful";	
	CommonUtil.report(msg,fail);
	return false;
}

public static String createCustomer(ExtentTest test) {
	// TODO Auto-generated method stub
	DateFormat ts = new SimpleDateFormat("yyyyMMddHHmmss");
	Date date = new Date();
	String timestamp = ts.format(date);

    String data1="WEL"+timestamp;
    String custdata=data1.toUpperCase();
    String emailid=custdata+"@yopmail.com";
    
	CommonUtil.sendKeys(firstname, "Arka");
	CommonUtil.sendKeys(lastname, custdata);
	CommonUtil.sendKeys(email,emailid);
	CommonUtil.sendKeys(confirmEmail, emailid);
	CommonUtil.sendKeys(password, "password");
	CommonUtil.sendKeys(confpassword, "password");
	
	CommonUtil.sleep(200);
	CommonUtil.driver.findElement(confpassword).sendKeys(Keys.ENTER);
	//CommonUtil.clicksync(submitLIT_login);
	
	CommonUtil.sleep(1000);
		
	if(CommonUtil.verifyCurrentURL("myproduct")) {
		msg = "Customer  creation successfull";
		
		test.log(Status.PASS, MarkupHelper.createLabel(msg, ExtentColor.GREEN));
		CommonUtil.report(msg,pass, test);
		return emailid;
	}
	else {
		msg = "Customer creation failed";	
		CommonUtil.report(msg,fail, test);
		test.log(Status.FAIL, MarkupHelper.createLabel(msg, ExtentColor.RED));
		return null;
	}
}


public static boolean disableCaptcha(ExtentTest test) {
	CommonUtil.refresh(EnvUtil.getProperty("HAC_UAT_URL_IMPORT"));
	
	CommonUtil.sleep(1000);
	String details="UPDATE BaseStore;uid[unique=true];captchacheckenabled;\n" + 
			"                ;wel;false;";
	CommonUtil.sendKeys(impexcode, details);
	
	CommonUtil.clicksync(importclick);
	
	
		CommonUtil.sleep(1000);
		
		while(true){
			if(CommonUtil.driver.findElements(By.xpath("//*[contains(text(),'Import finished successfully')]")).size()>0)
			{
				CommonUtil.sleep(1000);
				break;
				
			}
			else
				continue;
			
			
		}
	
	try {
		
		CommonUtil.driver.findElement(By.xpath("//*[contains(text(),'Import finished successfully')]"));
		msg = "Captcha Disable Successful";
		
		test.log(Status.PASS, MarkupHelper.createLabel(msg, ExtentColor.GREEN));
		//String Screenpath=ImageUtil.CaptureScreen(driver,"All");
		//test.log(LogStatus.PASS, test.addScreenCapture(Screenpath));
		CommonUtil.report(msg,pass, test);
		return true;
		
		}
		catch (org.openqa.selenium.NoSuchElementException e) 
		{
			
			msg = "Captcha Disable Failed";	
			CommonUtil.report(msg,fail, test);
			test.log(Status.FAIL, MarkupHelper.createLabel(msg, ExtentColor.RED));
			return false;
			
			}

}

public static boolean enableCaptcha(ExtentTest test) {
	CommonUtil.refresh(EnvUtil.getProperty("HAC_UAT_URL_IMPORT"));
	
	CommonUtil.sleep(1000);
	String details="UPDATE BaseStore;uid[unique=true];captchacheckenabled;\n" + 
			"                ;wel;true;";
	CommonUtil.sendKeys(impexcode, details);
	
	CommonUtil.clicksync(importclick);
	
	
		CommonUtil.sleep(1000);
		
		while(true){
			if(CommonUtil.driver.findElements(By.xpath("//*[contains(text(),'Import finished successfully')]")).size()>0)
			{
				CommonUtil.sleep(1000);
				break;
				
			}
			else
				continue;
			
			
		}
	
	try {
		
		CommonUtil.driver.findElement(By.xpath("//*[contains(text(),'Import finished successfully')]"));
		msg = "Captcha Enable Successful";
		
		test.log(Status.PASS, MarkupHelper.createLabel(msg, ExtentColor.GREEN));
		
		CommonUtil.report(msg,pass, test);
		return true;
		
		}
		catch (org.openqa.selenium.NoSuchElementException e) 
		{
			
			msg = "Captcha Enable Failed";	
			CommonUtil.report(msg,fail, test);
			test.log(Status.FAIL, MarkupHelper.createLabel(msg, ExtentColor.RED));
			return false;
			
			}

}

public static boolean payment(String username, String passwrd, ExtentTest test) {
	// TODO Auto-generated method stub

	String priceDetails=CommonUtil.getText(addprice);
	
	CommonUtil.clicksync(addtocart);
	int tabsize=CommonUtil.driver.findElements(By.xpath("//div[@class='subscriptions-subtotal-value']")).size();
	String pricegridDetails=CommonUtil.getText(By.xpath("(//div[@class='subscriptions-subtotal-value'])["+tabsize+"]"));	
	if(pricegridDetails.contains(priceDetails)) {
		
		msg = "Total price details matches with the product price details";
		CommonUtil.report(msg,pass, test);
		test.log(Status.PASS, MarkupHelper.createLabel(msg, ExtentColor.GREEN));
		
		CommonUtil.clicksync(continueButton);
		DateFormat ts = new SimpleDateFormat("yyyyMMddHHmmss");
		Date date = new Date();
		String timestamp = ts.format(date);

	    String data1="WEL"+timestamp;
	    String custdata=data1.toUpperCase();
	    String emailid=custdata+"@yopmail.com";
	    
		CommonUtil.sendKeys(firstname, "Arka");
		CommonUtil.sendKeys(lastname, custdata);
		CommonUtil.sendKeys(email,emailid);
		CommonUtil.sendKeys(confirmEmail, emailid);
		CommonUtil.sendKeys(password, "password");
		CommonUtil.sendKeys(confpassword, "password");
		
		CommonUtil.sleep(200);
		CommonUtil.driver.findElement(confpassword).sendKeys(Keys.ENTER);
		
		CommonUtil.sleep(2000);
		if(CommonUtil.verifyCurrentURL("Checkout")) {
			msg = "Customer  creation successfull";
			CommonUtil.report(msg,pass, test);
			test.log(Status.PASS, MarkupHelper.createLabel(msg, ExtentColor.GREEN));
			CommonUtil.sendKeys(billingFirstName, "Arka");
			CommonUtil.sendKeys(billingLastname, custdata);
			CommonUtil.sendKeys(billingAddress1, "209 River Street");
			CommonUtil.sendKeys(billingCity, "Hooboken");
			CommonUtil.sendKeys(billingZipcode, "07030");
			CommonUtil.sendKeys(billingPhone, "9769175640");
			
			Select drpState = new Select(CommonUtil.driver.findElement(By.id("billingAddress.addressRegion")));
			drpState.selectByVisibleText("New Jersey");
			int size =CommonUtil.driver.findElements(By.tagName("iframe")).size();
			CommonUtil.driver.switchTo().frame(0);
			CommonUtil.sendKeys(cardNumber,"5123456789012346");
			CommonUtil.driver.switchTo().parentFrame();
			CommonUtil.sendKeys(expiryMonth,"05 (May");
			CommonUtil.sendKeys(expiryYear,"2021");
			CommonUtil.driver.switchTo().frame(1);	
			CommonUtil.sendKeys(securityCode,"000");
			CommonUtil.driver.switchTo().parentFrame();
			
			CommonUtil.clicksync(continueorder);
			CommonUtil.sleep(3000);
			if(CommonUtil.verifyURL("order-review")) {
				msg = "Order Review Successfully";
				test.log(Status.PASS, MarkupHelper.createLabel(msg, ExtentColor.GREEN));
				CommonUtil.report(msg,pass, test);
				CommonUtil.clicksync(placeOrder);
				if(CommonUtil.verifyURL("orderConfirmation")) {
					msg = "Order Placed Successfully";
					test.log(Status.PASS, MarkupHelper.createLabel(msg, ExtentColor.GREEN));
					CommonUtil.report(msg,pass, test);
					return true;
				}
				else {
					msg = "Order Confirmation Failed";	
					CommonUtil.report(msg,fail, test);
					test.log(Status.FAIL, MarkupHelper.createLabel(msg, ExtentColor.RED));
					return false;
				}
			}else {
				msg = "Order Review Failed";	
				CommonUtil.report(msg,fail, test);
				test.log(Status.FAIL, MarkupHelper.createLabel(msg, ExtentColor.RED));
				return false;
			}	
		
	}else {
		msg = "CCustomer Creation Failed";	
		CommonUtil.report(msg,fail, test);
		test.log(Status.FAIL, MarkupHelper.createLabel(msg, ExtentColor.RED));
		return false;
	}
		
	}else {
		msg = "Price Details do not match";	
		CommonUtil.report(msg,fail, test);
		test.log(Status.FAIL, MarkupHelper.createLabel(msg, ExtentColor.RED));
		return false;
	}
}


public static boolean studentDiscountpayment(String username, String passwrd, ExtentTest test) {
	// TODO Auto-generated method stub
	JavascriptExecutor jse = (JavascriptExecutor)CommonUtil.driver;
    jse.executeScript("window.scrollBy(0,900)", "");
   // CommonUtil.driver.findElement(By.linkText("Apply 20% student discount")).click();
	CommonUtil.click(By.xpath("//div[contains(@class, 'product-discount')]//label[@for = 'student-discount-0']"));
	String priceDetails=CommonUtil.getText(addprice);
	
	CommonUtil.clicksync(addtocart);
	int tabsize=CommonUtil.driver.findElements(By.xpath("//div[@class='subscriptions-subtotal-value']")).size();
	int student_discSize=CommonUtil.driver.findElements(By.xpath("//span[@id='voucher-code-STUDENT']")).size();
	String pricegridDetails=CommonUtil.getText(By.xpath("(//div[@class='subscriptions-subtotal-value'])["+tabsize+"]"));
	if(student_discSize>0) {
		msg = "Student Discount applied successfully";
		CommonUtil.report(msg,pass, test);
		test.log(Status.PASS, MarkupHelper.createLabel(msg, ExtentColor.GREEN));
	if(pricegridDetails.contains(priceDetails)) {
		
		msg = "Total price details matches with the product price details";
		CommonUtil.report(msg,pass, test);
		test.log(Status.PASS, MarkupHelper.createLabel(msg, ExtentColor.GREEN));
		
		CommonUtil.clicksync(continueButton);
		DateFormat ts = new SimpleDateFormat("yyyyMMddHHmmss");
		Date date = new Date();
		String timestamp = ts.format(date);

	    String data1="WEL"+timestamp;
	    String custdata=data1.toUpperCase();
	    String emailid=custdata+"@yopmail.com";
	    
		CommonUtil.sendKeys(firstname, "Arka");
		CommonUtil.sendKeys(lastname, custdata);
		CommonUtil.sendKeys(email,emailid);
		CommonUtil.sendKeys(confirmEmail, emailid);
		CommonUtil.sendKeys(password, "password");
		CommonUtil.sendKeys(confpassword, "password");
		
		CommonUtil.sleep(200);
		CommonUtil.driver.findElement(confpassword).sendKeys(Keys.ENTER);
		
		CommonUtil.sleep(2000);
		if(CommonUtil.verifyCurrentURL("Checkout")) {
			msg = "Customer  creation successfull";
			CommonUtil.report(msg,pass, test);
			test.log(Status.PASS, MarkupHelper.createLabel(msg, ExtentColor.GREEN));
			CommonUtil.sendKeys(billingFirstName, "Arka");
			CommonUtil.sendKeys(billingLastname, custdata);
			CommonUtil.sendKeys(billingAddress1, "209 River Street");
			CommonUtil.sendKeys(billingCity, "Hooboken");
			CommonUtil.sendKeys(billingZipcode, "07030");
			CommonUtil.sendKeys(billingPhone, "9769175640");
			
			Select drpState = new Select(CommonUtil.driver.findElement(By.id("billingAddress.addressRegion")));
			drpState.selectByVisibleText("New Jersey");
			int size =CommonUtil.driver.findElements(By.tagName("iframe")).size();
			CommonUtil.driver.switchTo().frame(0);
			CommonUtil.sendKeys(cardNumber,"5123456789012346");
			CommonUtil.driver.switchTo().parentFrame();
			CommonUtil.sendKeys(expiryMonth,"05 (May");
			CommonUtil.sendKeys(expiryYear,"2021");
			CommonUtil.driver.switchTo().frame(1);	
			CommonUtil.sendKeys(securityCode,"000");
			CommonUtil.driver.switchTo().parentFrame();
			
			CommonUtil.clicksync(continueorder);
			CommonUtil.sleep(3000);
			if(CommonUtil.verifyURL("student-verification")) {
				msg = "Student Verification page opened Successfully";
				test.log(Status.PASS, MarkupHelper.createLabel(msg, ExtentColor.GREEN));
				CommonUtil.report(msg,pass, test);
				
				Select drpCountry = new Select(CommonUtil.driver.findElement(By.id("country")));
				drpCountry.selectByVisibleText("United States");
				CommonUtil.sleep(500);
				Select drpState1 = new Select(CommonUtil.driver.findElement(By.id("region")));
				drpState1.selectByVisibleText("New Jersey");
				CommonUtil.sleep(2000);
				Select drpUniversity = new Select(CommonUtil.driver.findElement(By.id("university")));
				drpUniversity.selectByVisibleText("Other");
				CommonUtil.sleep(500);
				JavascriptExecutor js = (JavascriptExecutor)CommonUtil.driver;
			    js.executeScript("window.scrollBy(0,900)", "");
				CommonUtil.click(By.xpath("//div[@class='checkbox-component']//label[@class='control-label ']"));
				CommonUtil.clicksync(clickNextButton);
				
			if(CommonUtil.verifyURL("order-review")) {
				msg = "Order Review Successfully";
				test.log(Status.PASS, MarkupHelper.createLabel(msg, ExtentColor.GREEN));
				CommonUtil.report(msg,pass, test);
				CommonUtil.clicksync(placeOrder);
				if(CommonUtil.verifyURL("orderConfirmation")) {
					msg = "Order Placed Successfully";
					test.log(Status.PASS, MarkupHelper.createLabel(msg, ExtentColor.GREEN));
					CommonUtil.report(msg,pass, test);
					return true;
				}
				else {
					msg = "Order Confirmation Failed";	
					CommonUtil.report(msg,fail, test);
					test.log(Status.FAIL, MarkupHelper.createLabel(msg, ExtentColor.RED));
					return false;
				}
			}else {
				msg = "Order Review Failed";	
				CommonUtil.report(msg,fail, test);
				test.log(Status.FAIL, MarkupHelper.createLabel(msg, ExtentColor.RED));
				return false;
			}
			}else {
				msg = "Student Verification Failed";	
				CommonUtil.report(msg,fail, test);
				test.log(Status.FAIL, MarkupHelper.createLabel(msg, ExtentColor.RED));
				return false;
			}
		
	}else {
		msg = "CCustomer Creation Failed";	
		CommonUtil.report(msg,fail, test);
		test.log(Status.FAIL, MarkupHelper.createLabel(msg, ExtentColor.RED));
		return false;
	}
		
	}else {
		msg = "Price Details do not match";	
		CommonUtil.report(msg,fail, test);
		test.log(Status.FAIL, MarkupHelper.createLabel(msg, ExtentColor.RED));
		return false;
	}
	}else {
		msg = "Student Discount application failed";	
		CommonUtil.report(msg,fail, test);
		test.log(Status.FAIL, MarkupHelper.createLabel(msg, ExtentColor.RED));
		return false;
	}
}


public static boolean checkaddtocart(String course, ExtentTest test) {
	// TODO Auto-generated method stub
	
	
	
	CommonUtil.clicksync(addtocart);
	
	
	if(CommonUtil.driver.findElements(By.xpath("//*[contains(text(),'"+course+"')]")).size()>0)
		{
		msg = "Course has been successfully added in the cart";
		
		test.log(Status.PASS, MarkupHelper.createLabel(msg, ExtentColor.GREEN));
		
		CommonUtil.report(msg,pass, test);
		return true;
			
		}
		else
		{
			msg = "Course failed to add in the cart";	
			CommonUtil.report(msg,fail, test);
			test.log(Status.FAIL, MarkupHelper.createLabel(msg, ExtentColor.RED));
			return false;
			}
		
		
	
	
}


}




