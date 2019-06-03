package wiley.automation.wol.impl;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import jxl.Range;
import wiley.automation.core.util.CommonUtil;
import wiley.automation.core.util.EnvUtil;
import wiley.automation.core.util.ObjectLocator;

public class Mrw_HomePageImpl<IWebElement> extends ObjectLocator {
	
	 //static Logger log = Logger.getLogger(LiteratumPageImpl.class);
	 private static String msg;
	public static void homepagemove() {
		
		CommonUtil.clicksync(homepagemovejournal);
		CommonUtil.sleep(2000);
		
	}

	
	
	public static boolean checkMrwHomepage(String MRW){
		
		CommonUtil.refresh(EnvUtil.getProperty("Literatum_APPLICATION_URL_MRW"));
		CommonUtil.sleep(2000);
		System.out.println(MRW);
		String MRW_link = "//a[.='"+MRW+"']";
		By clickMRWTitle= By.xpath(MRW_link);
		String MRWname=CommonUtil.getAttributeValue(clickMRWTitle, "href");
		System.out.println(MRWname);
		CommonUtil.clicksync(clickMRWTitle);
		
		
		
		
		if(CommonUtil.verifyCurrentURL(MRW)){
			msg = "MRW homepage is open";	
			//log.info(msg);
			CommonUtil.report(msg,pass);
			return true;
		}else{
			msg = "MRW Homepage is not open";	
			//log.info(msg);
			CommonUtil.report(msg,fail, "Present");
			return false;
		}
	}
public static boolean checkMrwPageContent(){
		
		String HomeTab= CommonUtil.getText(checkHomeTab);
		String AboutTab= CommonUtil.getText(checkAboutTab);
		String TOCTab= CommonUtil.getText(checkTOCTab);
		String BBTTab = CommonUtil.getText(checkBBTTab);
		String BAZTab= CommonUtil.getText(checkBAZTab);
		CommonUtil.click(checkShareTab);
		String ShareTab = CommonUtil.getText(checkShareTabvalue);
		String[] textTempArray1=ShareTab.split(" A ");
		ShareTab=textTempArray1[0];
        	
		System.out.println(HomeTab);
		System.out.println(AboutTab);
		System.out.println(TOCTab);
		System.out.println(BBTTab);
		System.out.println(BAZTab);
		System.out.println(ShareTab);
		
		if(HomeTab.contains("HOME") && AboutTab.contains("ABOUT") && TOCTab.contains("TABLE OF CONTENTS") && BBTTab.contains("BROWSE BY TOPIC") && BAZTab.contains("BROWSE A-Z") &&  ShareTab.contains("SHARE")){
			msg = "MRW Home Page Contents are present";	
			//log.info(msg);
			CommonUtil.report(msg,pass);
			return true;
		}else{
			msg = "Home Page Contents are not present";	
			//log.info(msg);
			CommonUtil.report(msg,fail, "Present");
			return false;
		}
	}


	
	
}
