package wiley.automation.wol.impl;

import wiley.automation.core.util.CommonUtil;
import wiley.automation.core.util.ObjectLocator;

public class article_PageImpl<IWebElement> extends ObjectLocator {
	
	 //static Logger log = Logger.getLogger(LiteratumPageImpl.class);
	 private static String msg;
	public static void homepagemove() {
		
		CommonUtil.clicksync(homepagemovejournal);
		CommonUtil.sleep(2000);
		
	}
	public static boolean checkjournalSection(){
		
		CommonUtil.click(clickJournal);
		if(CommonUtil.isElementPresent(checkJournal)){
			msg = "Journal List is present";	
			//log.info(msg);
			CommonUtil.report(msg,pass);
			return true;
		}else{
			msg = "Journal List is not present";	
			//log.info(msg);
			CommonUtil.report(msg,fail, "Present");
			return false;
		}
	}
public static boolean checkjournalTitle(){
		
		/*String journalname=CommonUtil.getAttributeValue(clickJournalTitle, "href");
		String[] textTempArray1=journalname.split("journal/");
        String journalName=textTempArray1[1];
        journalName= journalName.substring(0,7);*/
		String journalname=CommonUtil.getText(clickJournalTitle);
		 
		CommonUtil.clicksync(clickJournalTitle);
		
		
		if(CommonUtil.verifyCurrentURL(journalname)){
			msg = "Journal is present";	
			//log.info(msg);
			CommonUtil.report(msg,pass);
			return true;
		}else{
			msg = "Journal is not present";	
			//log.info(msg);
			CommonUtil.report(msg,fail, "Present");
			return false;
		}
	}
	
public static boolean clickAbstractLink(){
		
		//This scrolldown is required as it has been observed that if the Abstract is not visible then it cannot click
		CommonUtil.scrolldown(clickBeforeAbstract);
		CommonUtil.sleep(2000);
		//CommonUtil.LinKText();
		CommonUtil.clicksync(clickAbstract);
		if(CommonUtil.verifyTextPresent(checkAbstract, "Abstract")){
			msg = "Abstract Article is Open";	
			//log.info(msg);
			CommonUtil.report(msg,pass);
			return true;
		}else{
			msg = "Abstract Article is not Open";	
			//log.info(msg);
			CommonUtil.report(msg,fail, "Present");
			return false;
		}
	}

public static boolean checkAuthor(){
	
	
	if(CommonUtil.isElementPresent(checkTheAuthor1) && CommonUtil.isElementPresent(checkTheAuthor2)){
		msg = "Author is Visible and Present";	
		//log.info(msg);
		CommonUtil.report(msg,pass);
		return true;
	}else{
		msg = "Author is not visible";	
		//log.info(msg);
		CommonUtil.report(msg,fail, "Present");
		return false;
	}
}
public static boolean checkMultilingual(){
	
	
	if(CommonUtil.verifyTextPresent(checkMultilingual, "en")){
		msg = "Multilingual Option is Visible and Present";	
		//log.info(msg);
		CommonUtil.report(msg,pass);
		return true;
	}else{
		msg = "Multilingual Option is not visible";	
		//log.info(msg);
		CommonUtil.report(msg,fail, "Present");
		return false;
	}
}
}