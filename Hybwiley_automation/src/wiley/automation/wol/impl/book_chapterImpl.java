package wiley.automation.wol.impl;

import wiley.automation.core.util.CommonUtil;
import wiley.automation.core.util.ObjectLocator;

public class book_chapterImpl<IWebElement> extends ObjectLocator {
	
	 //static Logger log = Logger.getLogger(LiteratumPageImpl.class);
	 private static String msg;
	public static void homepagemove() {
		
		CommonUtil.clicksync(homepagemovejournal);
		CommonUtil.sleep(2000);
		
	}
	public static boolean checkbooksection(){
		
		CommonUtil.clicksync(clickBook1);
		if(CommonUtil.verifyTextPresent(checkBook1,"BOOK")){
			msg = "Book Home Page is open";	
			//log.info(msg);
			CommonUtil.report(msg,pass);
			return true;
		}else{
			msg = "Book Home Page Failed to open";	
			//log.info(msg);
			CommonUtil.report(msg,fail, "Present");
			return false;
		}
	}
	
	public static boolean checkbookpage(){
		
		String bookhref=CommonUtil.getAttributeValue(clickonABook, "href");
		String[] textTempArray1=bookhref.split("/book/");
	    String BookISBN=textTempArray1[1];
	    //log.info(BookISBN);
	    
		CommonUtil.clicksync(clickonABook);
		String DOI=CommonUtil.getText(checkmetadaISBN);
	    //log.info(DOI);
		
		if(BookISBN.contains(DOI)){
			msg = "Book has been openned successfully";	
			//log.info(msg);
			CommonUtil.report(msg,pass);
			return true;
		}else{
			msg = "Failed to open the book";	
			//log.info(msg);
			CommonUtil.report(msg,fail, "Present");
			return false;
		}
	}
	public static boolean checkchapterpage(){
		
		CommonUtil.scrolldown(tableofcontent);
	    
		CommonUtil.clicksync(clickonAchapter);
		
		if(CommonUtil.verifyTextPresent(checkchaptersection,"Introduction")){
			msg = "Book Chapter has been openned successfully";	
			//log.info(msg);
			CommonUtil.report(msg,pass);
			return true;
		}else{
			msg = "Failed to open the book's chapter";	
			//log.info(msg);
			CommonUtil.report(msg,fail, "Present");
			return false;
		}
	}
}