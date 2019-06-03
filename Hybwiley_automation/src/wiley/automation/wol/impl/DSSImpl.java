package wiley.automation.wol.impl;


import java.sql.Array;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;
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
import wiley.automation.core.util.EnvUtil;
import wiley.automation.core.util.ObjectLocator;

public class DSSImpl extends ObjectLocator {

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


public static boolean clickOnLinkSync(String linktext) {
	// TODO Auto-generated method stub
	By by = By.linkText(linktext);
		if(CommonUtil.isElementPresent(by)){
			CommonUtil.clicksync(by);
			msg = "clicked on "+linktext+" Successful";	
			CommonUtil.report(msg,pass);
			return true;
	}
	msg = "clicked on "+linktext+" UnSuccessful";	
	CommonUtil.report(msg,fail);
	return false;
}

public static boolean checkProcessStatus(String linktext) {
	// TODO Auto-generated method stub
	int rowcount= CommonUtil.driver.findElements(checkrownumber).size();
	// find the customer table
	System.out.println(rowcount);
	//WebElement table = CommonUtil.driver.findElement(By.xpath("//*[@id='striped']"));

	// find the row
	//WebElement customer = table.findElement(By.xpath("//tr/td[contains(text(), 'Literatum_Issue_Test')]"));
	CommonUtil.scrolldown(LogOut);
	for (int i=2; i<=rowcount; i++)
	{
		String getname= CommonUtil.driver.findElement(By.xpath("//*[@id='striped']/tbody/tr["+i+"]/td[3]")).getText();
		if (getname.contains(linktext))
		{
			idname= CommonUtil.driver.findElement(By.xpath("//*[@id='striped']/tbody/tr["+i+"]/td[1]")).getText();
			break;
		}
		
	}
	System.out.println(idname);
	while(k==1 || q==1)
	{
		for (int i=2; i<=rowcount; i++)
		{
			String checkid= CommonUtil.driver.findElement(By.xpath("//*[@id='striped']/tbody/tr["+i+"]/td[1]")).getText();
			if (checkid.equals(idname))
			{
				String pocessflag= CommonUtil.driver.findElement(By.xpath("//*[@id='striped']/tbody/tr["+i+"]/td[10]")).getText();
				String queuedflag= CommonUtil.driver.findElement(By.xpath("//*[@id='striped']/tbody/tr["+i+"]/td[8]")).getText();
				k = Integer.parseInt(pocessflag);
				q = Integer.parseInt(queuedflag);
				if(k==1 || q==1)
				{
					CommonUtil.driver.navigate().refresh();
					CommonUtil.sleep(10000);
					break;
				}
				else
					break;
			}
			
		}
	}
	


	// click on the row
	//customer.click();
return true;
	
	
//	//String getvalue= CommonUtil.getText(by)
//	By by = By.linkText(linktext);
//		if(CommonUtil.isElementPresent(by)){
//			CommonUtil.clicksync(by);
//			msg = "clicked on "+linktext+" Successful";	
//			CommonUtil.report(msg,pass);
//			return true;
//	}
//	msg = "clicked on "+linktext+" UnSuccessful";	
//	CommonUtil.report(msg,fail);
//	return false;
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

public static boolean checkProcessingQueue(String DOIvalue,String linktext) {
	// TODO Auto-generated method stub
	int rowcount= CommonUtil.driver.findElements(By.xpath("//*[@id='queuetable']/tbody/tr")).size();
	for (int i=1; i<=rowcount;i++)
	{
		getDOI= CommonUtil.driver.findElement(By.xpath("//*[@id='queuetable']/tbody/tr["+i+"]/td[1]")).getText();
		if(getDOI.contains(linktext))
		{
			rowtocheck= i;
			break;
		}
	}
	while(!CommonUtil.getText(By.xpath("//*[@id='queuetable']/tbody/tr["+rowtocheck+"]/td[3]")).contains("Completed"))
	{
		CommonUtil.driver.navigate().refresh();
		CommonUtil.sleep(2000);
	}
	if(CommonUtil.getText(By.xpath("//*[@id='queuetable']/tbody/tr["+rowtocheck+"]/td[4]")).contains("Error"))
	{
		CommonUtil.click(By.xpath("//*[@id='queuetable']/tbody/tr["+rowtocheck+"]/td[4]"));
		String Error_URL_details=CommonUtil.driver.getCurrentUrl();
		System.out.println(Error_URL_details);
		CommonUtil.sleep(5000);
		CommonUtil.report(Error_URL_details,fail);
		return false;
		
	}
	else{
		
	
	CommonUtil.sendKeys(By.xpath("//*[@id='txt-universal-doi']"), DOIvalue);
	CommonUtil.clicksync(By.xpath("//*[@id='btn-universal-doi-search']"));
	
	CommonUtil.sleep(2000);
	//*[@id='serialRel']/a
	if(CommonUtil.isElementPresent(By.xpath("//*[@id='journalRel']/a")))
	{
	
	CommonUtil.click(By.xpath("//*[@id='issueDetails']/div[1]/div/button"));
	CommonUtil.clicksync(By.xpath("//*[@id='issueDetails']/div[1]/div/div/a[6]"));
	}
	else
	{
		CommonUtil.click(By.xpath("//*[@id='chapterDetails']/div[1]/div/button"));
		CommonUtil.clicksync(By.xpath("//*[@id='chapterDetails']/div[1]/div/div/a[6]"));
	}
	
	
	
	String timestamp= CommonUtil.getText(By.xpath("//*[@id='queuetable']/tbody/tr[1]/td[6]"));


	CommonUtil.sendKeys(By.xpath("//*[@id='txt-universal-doi']"), DOIvalue);
	CommonUtil.clicksync(By.xpath("//*[@id='btn-universal-doi-search']"));
	if(CommonUtil.isElementPresent(By.xpath("//*[@id='journalRel']/a")))
		CommonUtil.clicksync(By.xpath("//*[@id='issueDetails']/fieldset[1]/dl/dd[5]/a"));
	else
		CommonUtil.clicksync(By.xpath("//*[@id='chapterDetails']/fieldset[1]/dl/dd[3]/a"));
	CommonUtil.sleep(2000);
	Set<String> winids = CommonUtil.driver.getWindowHandles(); 
	 Iterator<String> itr = winids.iterator();
	System.out.println("Total number of windows/tabs are:" +winids.size());  
	String mainWindow = itr.next();    
	String childWindow = itr.next();  
	System.out.println(mainWindow);   
	System.out.println(childWindow);        
	CommonUtil.driver.switchTo().window(childWindow);
	//CommonUtil.driver.switchTo().window("CDwindow-e670cce1-8d75-4aa1-a574-0857ff9c3f0a");

	if (CommonUtil.verifyCurrentURL("Error"))
	{
		msg= "The page has failed to open";
		CommonUtil.report(msg+timestamp,fail);
		return false;
	}
	else
	{
		msg= "The DOI has been loaded successfully";
		CommonUtil.report(msg+timestamp,pass);
		return true;
	}
	
	}
	
	
	
	

}

public static String checkWebdav(String linktext) {
	// TODO Auto-generated method stub
	CommonUtil.refresh(EnvUtil.getProperty("Literatum_APPLICATION_URL_Webdav"));
	int rowcount= CommonUtil.driver.findElements(By.xpath("html/body/table/tbody/tr")).size();
	String[] textTempArray1=linktext.split("/");
	
	String doiName=textTempArray1[1];
	String checkDOI = null;
	for(int i=4;i<rowcount;i++)
	{
		if(rowcount == 5)
			break;
		getDOI= CommonUtil.driver.findElement(By.xpath("html/body/table/tbody/tr["+i+"]/td[2]/a")).getText();
		String[] textTempArray2=getDOI.split("_");
		checkDOI= textTempArray2[1];
		if(doiName.contains(checkDOI))
		{
			break;
		}
	}
	
	
	//while(rowcount>5)
	while(CommonUtil.getText(By.xpath("html/body")).contains(getDOI))
	{
			 
		CommonUtil.driver.navigate().refresh();
		rowcount= CommonUtil.driver.findElements(By.xpath("html/body/table/tbody/tr")).size();
		CommonUtil.sleep(5000);
	}
	CommonUtil.driver.findElement(By.xpath("html/body/table/tbody/tr["+(rowcount-1)+"]/td[2]/a")).click();
	rowcount= CommonUtil.driver.findElements(By.xpath("html/body/table/tbody/tr")).size();
	CommonUtil.driver.findElement(By.xpath("html/body/table/tbody/tr["+(rowcount-1)+"]/td[2]/a")).click();
	rowcount= CommonUtil.driver.findElements(By.xpath("html/body/table/tbody/tr")).size();
	CommonUtil.driver.findElement(By.xpath("html/body/table/tbody/tr["+(rowcount-1)+"]/td[2]/a")).click();
	CommonUtil.driver.findElement(By.xpath("html/body/table/tbody/tr[1]/th[3]/a")).click();
	CommonUtil.driver.findElement(By.xpath("html/body/table/tbody/tr[1]/th[3]/a")).click();
	
	rowcount= CommonUtil.driver.findElements(By.xpath("html/body/table/tbody/tr")).size();
	
	for(int j=4;j<rowcount;j++)
	{
		String DOIValue= CommonUtil.driver.findElement(By.xpath("html/body/table/tbody/tr["+j+"]/td[2]/a")).getText();
		if(getDOI.equals(DOIValue))
		{
			msg = "Porcessing at webdav page successfull";	
			
			CommonUtil.report(msg,pass);
			return getDOI;
		}
	}
	return null;
//	String gettime= CommonUtil.driver.findElement(By.xpath("html/body/table/tbody/tr[4]/td[3]")).getText();
//	
//	
//	
//	  Calendar cal = Calendar.getInstance();
//	  SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
//      String currenttime=sdf.format(cal.getTime());
//      
//      String startTime = "10:00";
//      String endTime = "12:00";
//      
//    Date d1 = new Date();
//	Date d2 = new Date();
//	try {
//		d1 = sdf.parse(lastProcesstime);
//		d2 = sdf.parse(currenttime);
//	} catch (ParseException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//      
//      long elapsed = d2.getTime() - d1.getTime(); 
//     
//      System.out.println(elapsed);
//	
//	return true;
}

public static boolean searchContent(String dOI) {
	// TODO Auto-generated method stub
	CommonUtil.sleep(2000);
	CommonUtil.click(TitleText);
	CommonUtil.sleep(2000);
	if(CommonUtil.isElementPresent(SearchBox)){
		CommonUtil.click(SearchBox);
		CommonUtil.sleep(2000);
		CommonUtil.sendKeys(SearchBox, dOI);
		CommonUtil.click(SearchBtn);
		msg = "clicked on search button Successful";	
		CommonUtil.report(msg,pass);
		return true;
	}
	msg = "clicked on search button UnSuccessful";	
	CommonUtil.report(msg,fail);
	return false;
}


public static boolean verifyAndCheckContent(String dOI) {
	// TODO Auto-generated method stub
	if(CommonUtil.isElementPresent(textAreaValue)){
		String article_doi = CommonUtil.driver.findElement(textAreaValue).getAttribute("value").toString().trim();
		if(article_doi.equals(dOI)){
			msg = "Doi present in Content IDs area";	
			CommonUtil.report(msg,pass);
		}else{
			msg = "Doi not present in Content IDs area";	
			CommonUtil.report(msg,fail);
			return false;
		}
		if(CommonUtil.isElementPresent(Check_content_items)){
			CommonUtil.click(Check_content_items);
			CommonUtil.sleep(2000);
		}else{
			msg = "Check content items not present in Content IDs area";	
			CommonUtil.report(msg,fail);
			return false;
		}
		if(CommonUtil.isElementPresent(select_option)){
			CommonUtil.selectdropdownvaluebyvisibletext(select_option, "ISSUE");
			msg = "Issue dropdown selected";	
			CommonUtil.report(msg,pass);
		}else{
			msg = "Issue dropdown not selected";	
			CommonUtil.report(msg,fail);
			return false;
		}
		if(CommonUtil.isElementPresent(Ignore_validation) && CommonUtil.isElementPresent(Use_license_priority)){
			CommonUtil.click(Ignore_validation);
			CommonUtil.sleep(1000);
			CommonUtil.click(Use_license_priority);
			CommonUtil.sleep(1000);
			msg = "Ignore validation and Use license priority selected";	
			CommonUtil.report(msg,pass);
			
		}else{
			msg = "Ignore validation and Use license priority not selected";	
			CommonUtil.report(msg,fail);
			return false;
		}
		
		if(CommonUtil.isElementPresent(Literatum_Issue_Test)){
			CommonUtil.click(Literatum_Issue_Test);
			msg = "Delivery option checkbox selected";	
			CommonUtil.report(msg,pass);
		}else{
			msg = "Delivery option checkbox not selected";	
			CommonUtil.report(msg,fail);
		}
		
		if(CommonUtil.isElementPresent(Deliver_btn)){
			CommonUtil.scrolldown(LogOut);
			CommonUtil.click(Deliver_btn);
			CommonUtil.sleep(5000);
			msg = "Clicked on Delivery button";	
			CommonUtil.report(msg,pass);
		}else{
			msg = "Not Clicked on Delivery button";	
			CommonUtil.report(msg,fail);
			return false;
		}
		return true;
	}
	return false;
}

	
} 