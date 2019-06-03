package wiley.automation.wol.impl;

import wiley.automation.core.util.CommonUtil;
import wiley.automation.core.util.ObjectLocator;

public class about_this_bookImpl<IWebElement> extends ObjectLocator {
	
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
	
	public static boolean checkbookcontent(){
		CommonUtil.scrolldown(checkmetadaISBN);
		String bookfullcontent= CommonUtil.getText(checkcontent);
		bookfullcontent= bookfullcontent.substring(0,11);
		System.out.println(bookfullcontent);
		if(bookfullcontent.contains("This unique")){
			msg = "Book content is present";	
			//log.info(msg);
			CommonUtil.report(msg,pass);
			return true;
		}else{
			msg = "Book content is not present";
			//log.info(msg);
			CommonUtil.report(msg,fail, "Present");
			return false;
		}
	}
	
public static boolean checkshowall(){
		
		String showalltitle=CommonUtil.getAttributeValue(checkshow, "title");
		System.out.println(showalltitle);
		if(showalltitle.contains(" Show all")){
			msg = "Show all content tag is present";	
			//log.info(msg);
			CommonUtil.report(msg,pass);
			return true;
		}else{
			msg = "Show all content is not present";
			//log.info(msg);
			CommonUtil.report(msg,fail, "Present");
			return false;
		}
	}
	
public static boolean checkshowallcontent(){
	
	System.out.println("inside");
	CommonUtil.clicksync(checkshow);
	if(CommonUtil.isElementPresent(checkshowallcontentsection)){
		msg = "Show all remaning content is present";	
		//log.info(msg);
		CommonUtil.report(msg,pass);
		return true;
	}else{
		msg = "Show all remaining content is not present";
		//log.info(msg);
		CommonUtil.report(msg,fail, "Present");
		return false;
	}
}
}