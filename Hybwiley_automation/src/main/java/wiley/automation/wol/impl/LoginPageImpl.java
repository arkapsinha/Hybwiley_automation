package wiley.automation.wol.impl;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import wiley.automation.core.report.ImageUtil;
import wiley.automation.core.util.CommonUtil;
import wiley.automation.core.util.EnvUtil;
import wiley.automation.core.util.ObjectLocator;
//import wiley.automation.core.util.dbConnection;
import wiley.automation.wol.workflow.LoginPage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.LogStatus;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;



public class LoginPageImpl extends ObjectLocator {
	
	 //static Logger log = Logger.getLogger(LoginPageImpl.class);
	 private static String msg;
	 public static WebDriver driver; 
	
	

	public static boolean LoginWEL(String username, String password, ExtentTest test) {
		// TODO Auto-generated method stub
		if(CommonUtil.isElementPresent(WELuser) && CommonUtil.isElementPresent(WELpassword)){
			CommonUtil.sendKeys(WELuser, username);
			CommonUtil.sendKeys(WELpassword, password);
			CommonUtil.scrolldown(WELuser);
			CommonUtil.sleep(200);
			CommonUtil.driver.findElement(WELpassword).sendKeys(Keys.ENTER);
			//CommonUtil.clicksync(submitLIT_login);
			
 			CommonUtil.sleep(1000);
 			
 			while(true){
 				if(CommonUtil.driver.findElements(By.xpath("//*[contains(text(),'Welcome')]")).size()>0)
 				{
 					CommonUtil.sleep(1000);
 					break;
 					
 				}
 				else
 					continue;
 				
 				
 			}
			
			try {
				
				CommonUtil.driver.findElement(By.xpath("//*[contains(text(),'Welcome')]"));
				msg = "WEL Login is Successful";
				
				test.log(Status.PASS, MarkupHelper.createLabel(msg, ExtentColor.GREEN));
				//String Screenpath=ImageUtil.CaptureScreen(driver,"All");
				//test.log(LogStatus.PASS, test.addScreenCapture(Screenpath));
				CommonUtil.report(msg,pass, test);
				return true;
				
				}
				catch (org.openqa.selenium.NoSuchElementException e) 
				{
					
					msg = "WEL Login failed";	
					CommonUtil.report(msg,fail, test);
					test.log(Status.FAIL, MarkupHelper.createLabel(msg, ExtentColor.RED));
					return false;
					
					}
		
			
						//return true;
			
		}
		msg = "WEL Login UnSuccessful";	
		test.log(Status.FAIL, MarkupHelper.createLabel(msg, ExtentColor.RED));
		return false;
	}



	public static boolean LoginHAC(String username, String password, ExtentTest test) {
		if(CommonUtil.isElementPresent(HACuser) && CommonUtil.isElementPresent(HACpassword)){
			CommonUtil.clear(HACuser);
			CommonUtil.sendKeys(HACuser, username);
			CommonUtil.clear(HACpassword);
			CommonUtil.sendKeys(HACpassword, password);
			CommonUtil.scrolldown(HACuser);
			CommonUtil.sleep(200);
			CommonUtil.driver.findElement(HACpassword).sendKeys(Keys.ENTER);
			//CommonUtil.clicksync(submitLIT_login);
			
 			CommonUtil.sleep(1000);
 			
 			while(true){
 				if(CommonUtil.driver.findElements(By.xpath("//a[@id='platform']")).size()>0)
 				{
 					CommonUtil.sleep(1000);
 					break;
 					
 				}
 				else
 					continue;
 				
 				
 			}
			
			try {
				
				/* CommonUtil.driver.findElement(By.xpath("//a[@id='platform']")); */
				msg = "HAC Login is Successful";
				
				test.log(Status.PASS, MarkupHelper.createLabel(msg, ExtentColor.GREEN));
				//String Screenpath=ImageUtil.CaptureScreen(driver,"All");
				//test.log(LogStatus.PASS, test.addScreenCapture(Screenpath));
				CommonUtil.report(msg,pass, test);
				return true;
				
				}
				catch (org.openqa.selenium.NoSuchElementException e) 
				{
					
					msg = "HAC Login failed";	
					CommonUtil.report(msg,fail, test);
					test.log(Status.FAIL, MarkupHelper.createLabel(msg, ExtentColor.RED));
					return false;
					
					}
		
			
						//return true;
			
		}
		msg = "HAC Login UnSuccessful";	
		test.log(Status.FAIL, MarkupHelper.createLabel(msg, ExtentColor.RED));
		return false;
	}




	}
	
	

