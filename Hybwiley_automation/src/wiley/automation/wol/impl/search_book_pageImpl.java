package wiley.automation.wol.impl;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import wiley.automation.core.util.CommonUtil;
import wiley.automation.core.util.ObjectLocator;

public class search_book_pageImpl<IWebElement> extends ObjectLocator {
	
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
	
	public static boolean checkbookpage(String Book){
		
		//String Book_link = "//a[.='"+Book+"']";
		String Book_link = "//a[contains(text(), '"+Book+"')]";
		By clickBookTitle= By.xpath(Book_link);
		
		//String bookname=CommonUtil.getText(clickBookTitle);
		 
		CommonUtil.clicksync(clickBookTitle);
		
		
		if(CommonUtil.verifyCurrentURL(Book)){
			msg = "Book Home page is open";	
			//log.info(msg);
			CommonUtil.report(msg,pass);
			return true;
		}else{
			msg = "Book Home page is not openned";	
			//log.info(msg);
			CommonUtil.report(msg,fail, "Present");
			return false;
		}
	}
	
public static boolean checksearchbox(String Search){
		
		CommonUtil.click(clicksearchbox);
		CommonUtil.click(clicksearchdropdown);
		CommonUtil.click(clicksearchvalue);
		
		String SearchValue= CommonUtil.getText(clicksearchdropdown);
		System.out.println(SearchValue);
		if(SearchValue.contains("Anywhere")){
			msg = "Anywhere search has been selected";	
			//log.info(msg);
			CommonUtil.report(msg,pass);
			return true;
							
		}else{
			msg = "Anywhere search not selected";
			//log.info(msg);
			CommonUtil.report(msg,fail, "Present");
			return false;
		}
	}

public static boolean clickOnSearchTextField(String search) {
	// TODO Auto-generated method stub
	System.out.println(search);
	
	CommonUtil.LinKText();
	CommonUtil.click(clicksearchnewbox);
	CommonUtil.sendKeys(clicksearchnewbox, search);
	CommonUtil.clicksync(searchsubmitbutton);
	//CommonUtil.clickEnter(searchsubmitbutton);
	CommonUtil.waitForpageToLoad();
	
	if (LiteratumPageImpl.searchResultVerify(search))
		return true;
	else
		return false;
	
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