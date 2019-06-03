package wiley.automation.wol.impl;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.HasInputDevices;
import org.openqa.selenium.interactions.Mouse;
import org.openqa.selenium.internal.Locatable;

import wiley.automation.core.util.CommonUtil;
import wiley.automation.core.util.ObjectLocator;

public class ReadcubePageImpl extends ObjectLocator {

 static //Logger log = Logger.getLogger(HomePageImpl.class);
 String msg;

public static boolean checkReadcubePDF(String string) {
	// TODO Auto-generated method stub
	String readyStateComplete = "";
	if(CommonUtil.driver.getCurrentUrl().endsWith(string)){
		JavascriptExecutor executor = (JavascriptExecutor) CommonUtil.driver;
        executor.executeScript("window.scrollTo(0, document.body.offsetHeight)");
        readyStateComplete = (String) executor.executeScript("return document.readyState");
        if(readyStateComplete.equalsIgnoreCase("complete")){
        	msg = "ePDF page contains document.readyState = 'complete'";	
        	CommonUtil.report(msg,pass);
        	return true;
        }
        else{
        	msg = "ePDF page does not contain document.readyState = 'complete'";	
        	CommonUtil.report(msg,fail);
        	return false;
        }
	}
		
	return false;
}

public static boolean loginAs(String username, String password, String href) {
	String string = href.split("doi/epdf/")[1];
	String url = "https://"+username+":"+password+"@"+"staging.readcube.com/articles/"+string+"?publisher=wiley&access_api=1&use_basic_auth=1&parent_url="+href+"&preview=1&ssl=1";
	CommonUtil.refresh(url);
	CommonUtil.sleep(5000);
	/*CommonUtil.driver.switchTo().alert().accept();
	CommonUtil.sleep(5000);*/
	CommonUtil.refresh(href);
	CommonUtil.sleep(5000);
	msg = "ePDF page opened";	
	CommonUtil.report(msg,pass);
	return true;
}

public static boolean checkPDF(String string) {
	String readyStateComplete = "";
	if(CommonUtil.driver.getCurrentUrl().endsWith(string.replace("epdf", "pdf"))){
		JavascriptExecutor executor = (JavascriptExecutor) CommonUtil.driver;
        executor.executeScript("window.scrollTo(0, document.body.offsetHeight)");
        readyStateComplete = (String) executor.executeScript("return document.readyState");
        if(readyStateComplete.equalsIgnoreCase("complete")){
        	msg = "PDF page contains document.readyState = 'complete'";	
        	CommonUtil.report(msg,pass);
        	return true;
        }
        else{
        	msg = "PDF page does not contain document.readyState = 'complete'";	
        	CommonUtil.report(msg,fail);
        	return false;
        }
	}
	return false;
}

public static boolean checkReadcubeSharing(String string) {
	// TODO Auto-generated method stub
	if(CommonUtil.isElementPresent(ShareLinkArticle)){
		CommonUtil.scrolldown(ShareLinkArticle);
		CommonUtil.click(ShareLinkArticle);
		CommonUtil.sleep(5000);
		if(CommonUtil.isElementDisplay(ReadcubeSharing) || CommonUtil.isElementPresent(ReadcubeSharing)){
			if(CommonUtil.getText(ReadcubeSharing).contains(string)){
				msg = "Share full text access option present";	
				CommonUtil.report(msg,pass);
				return true;
			}
			msg = "Share full text access option present";	
			CommonUtil.report(msg,fail);
			return false;
		}
	}
	msg = "Share full text access option present";	
	CommonUtil.report(msg,fail);
	return false;
}

	
} 