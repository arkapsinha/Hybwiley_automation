package wiley.automation.wol.impl;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.TimeoutException;
import jxl.Range;
import wiley.automation.core.util.CommonUtil;
import wiley.automation.core.util.EnvUtil;
import wiley.automation.core.util.ObjectLocator;

public class journal_HomePageImpl<IWebElement> extends ObjectLocator {
	
	 //static Logger log = Logger.getLogger(LiteratumPageImpl.class);
	 private static String msg;
	public static void homepagemove() {
		
		CommonUtil.clicksync(homepagemovejournal);
		CommonUtil.sleep(2000);
		
	}
public static void navigatetoLoiPage() {
		
		CommonUtil.refresh(EnvUtil.getProperty("Literatum_APPLICATION_URL_LOI"));
		CommonUtil.sleep(2000);
		
	}
	
	
	public static boolean checkjournalSection(){
		
		CommonUtil.click(clickJournal);
		if(CommonUtil.verifyTextPresent(checkJournal, "JOURNAL")){
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


//Added by Tamaghna

public static boolean checkjournalTitle(String Journal){
	
	String jouranl_link = "//a[.='"+Journal+"']";
	By clickJournalTitle= By.xpath(jouranl_link);
	
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


public static boolean loadIucrPage(String IUCRdata){
	
	String xpathscroll= "//*[@class='search-result showPublications']/ul/li[3]/div/div[1]/span[1]";
	By xpathscrollink= By.xpath(xpathscroll);
	CommonUtil.scrolldown(xpathscrollink);
	CommonUtil.clicksync(clickIucr);
	CommonUtil.sleep(2000);
	CommonUtil.clicksync(clickIcurContent);
	
	String jouranl_link = "//a[.='"+IUCRdata+"']";
	By clickJournalTitle= By.xpath(jouranl_link);
	
	//String journalname=CommonUtil.getText(clickJournalTitle);
	 
	CommonUtil.clicksync(clickJournalTitle);
	CommonUtil.click(clcikbrowsearticle);
	
	
	
	CommonUtil.clicksync(clickAllIssues);
	
	CommonUtil.clicksync(clickVolume);
	CommonUtil.scrolldown(scrollPage);
	CommonUtil.clicksync(clickFullText);
	String URL= CommonUtil.driver.getCurrentUrl();
	String[] textTempArray1=URL.split("/");
	URL= textTempArray1[3];
	
	String checkjournal= CommonUtil.getText(journalname);
	
	if(URL.contains("iucr") && checkjournal.contains(IUCRdata)){
		msg = "IUCR Page is Open";	
		//log.info(msg);
		CommonUtil.report(msg,pass);
		return true;
	}else{
		msg = "IUCR Page Failed to open";	
		//log.info(msg);
		CommonUtil.report(msg,fail, "Present");
		return false;
	}
}
public static boolean checkcurrentIssue(){
	
	CommonUtil.clicksync(clickJournal);
	// To find the ISSN number from the journal link
	String journalname=CommonUtil.getAttributeValue(clickJournalTitle, "href");
	String[] textTempArray1=journalname.split("journal/");
    String journalISSN=textTempArray1[1];
    journalISSN= journalISSN.substring(0,8);
    //log.info(journalISSN);
    //To retrieve the ISSN number form the journal page Meta data
    CommonUtil.clicksync(clickJournalTitle);
    String metadatasection=CommonUtil.getText(checkmetadaISSN);
    //log.info(metadatasection);
    String[] textTempArray2=metadatasection.split("Online ISSN: ");
    String OnlineISSN=textTempArray2[1];
    OnlineISSN = OnlineISSN.replace("-", "");
	//log.info(OnlineISSN);
	//if(journalISSN.contains(OnlineISSN) && CommonUtil.isElementPresent(issueFirstPublishDate)){
    if(journalISSN.contains(OnlineISSN)){
		msg = "Current Issue ISSN number is present";	
		//log.info(msg);
		CommonUtil.report(msg,pass);
		return true;
	}else{
		msg = "Current Issue ISSN number is not present";	
		//log.info(msg);
		CommonUtil.report(msg,fail, "Present");
		return false;
	}
}


	/*private static void hitEnter() {
		// TODO Auto-generated method stub
		Actions builder = new Actions(CommonUtil.driver);
		builder.moveToElement(CommonUtil.driver.findElement(SearchTermField)).perform();
		//builder.keyDown(CommonUtil.driver.findElement(SearchTermField), Keys.ENTER).perform();
		//builder.keyUp(CommonUtil.driver.findElement(SearchTermField), Keys.ENTER).perform();
		builder.sendKeys(Keys.ENTER).perform();
	}*/
public static  boolean checksubjectsection(){
		
	CommonUtil.clicksync(clickJournal);
		if(CommonUtil.isElementPresent(checksubject)){
			msg = "Subject Section is present";	
			//log.info(msg);
			CommonUtil.report(msg,pass);
			return true;
		}else{
			msg = "Subject Section is not present";	
			//log.info(msg);
			CommonUtil.report(msg,fail, "Present");
			return false;
		}
	}


//Added By Tamaghna
public static boolean clickOnSearchTextField() {
	// TODO Auto-generated method stub
	if(CommonUtil.isElementPresent(searchtextbox))
	{
		CommonUtil.click(searchtextbox);
		msg = "search box is present";	
		//log.info(msg);
		CommonUtil.report(msg,pass, "Present");
		return true;
	}else{
		msg = "Search box is not present";	
		//log.info(msg);
		CommonUtil.report(msg,fail, "not Present");
		return false;
	}
	
}

public static boolean clickOnSearchTextField1() {
	// TODO Auto-generated method stub
	if(CommonUtil.isElementPresent(searchtextbox1))
	{
		CommonUtil.click(searchtextbox1);
		msg = "search box is present";	
		//log.info(msg);
		CommonUtil.report(msg,pass, "Present");
		return true;
	}else{
		msg = "Search box is not present";	
		//log.info(msg);
		CommonUtil.report(msg,fail, "not Present");
		return false;
	}
	
}



public static boolean verifySearchDropDownValueAs(String text) {
	// TODO Auto-generated method stub
	if(CommonUtil.isElementPresent(SearchDropDownValue))
	{
		if(CommonUtil.getText(SearchDropDownValue).trim().equals(text))
		{		
			msg = "search dropdown default value shows as "+CommonUtil.getText(SearchDropDownValue);	
			//log.info(msg);
			CommonUtil.report(msg,pass, "Present");
			return true;
		}else{
			msg = "search dropdown default value shows as "+CommonUtil.getText(SearchDropDownValue);	
			//log.info(msg);
			CommonUtil.report(msg,fail, "not Present");
			return false;
		}
	}
	return false;
}



public static boolean enterSearchTermAndVerifyAutoSuggestions(String string) {
	// TODO Auto-generated method stub
	if(CommonUtil.isElementPresent(searchtextbox))
	{
		CommonUtil.sendKeys(searchtextbox, string);
		CommonUtil.sleep(3000);
		if(CommonUtil.isElementPresent(autosuggestionbox) && CommonUtil.isElementDisplay(autosuggestionbox) && CommonUtil.isElementDisplay(autosuggestionboxelement)){
			if(CommonUtil.getText(autosuggestionboxelement).trim().contains(string)){
				msg = "search box Autosuggestion present";	
				//log.info(msg);
				CommonUtil.report(msg,pass, "Autosuggestion Present");
				return true;
			}
			msg = "search box Autosuggestion is not present";	
			CommonUtil.report(msg,fail, "Autosuggestion not worked");
			return false;
		}
		msg = "search box Autosuggestion is not present";	
		CommonUtil.report(msg,fail, "Autosuggestion not worked");
		return false;
		
	}else{
		msg = "search box Autosuggestion is not present";	
		//log.info(msg);
		CommonUtil.report(msg,fail, "Autosuggestion not Present");
		return false;
	}
}

public static boolean clickOnAdvanceSearch() {
	if(CommonUtil.isElementPresent(advSearchLink)){
		CommonUtil.clicksync(advSearchLink);
		if(CommonUtil.isElementPresent(advSearchTextBox1)){
			
			return true;
		}
		return false;
	}
	return false;
}



public static boolean performAdvanceSearch(String filteroption, String text) {
	// select Dropdown values
	String selectoption = "//span[.='"+filteroption+"']";
	//CommonUtil.selectdropdownvaluebyvisibletext(advsearchsearchoption, filteroption);
	CommonUtil.click(selectclick);
	CommonUtil.sleep(2000);
	CommonUtil.click(By.xpath(selectoption));
	CommonUtil.sleep(2000);
	CommonUtil.sendKeys(advSearchTextBox1, text);
	CommonUtil.scrolldown(By.xpath("//*[@class='advanced-search--filters']"));
	CommonUtil.clicksync(submitButton);
	if(LiteratumPageImpl.searchResultVerify(text))
		return true;
	
	return false;
}



public static boolean clickOnAdvanceSearchFromHeader() {
	if(CommonUtil.isElementPresent(advSearchLinkheader)){
		CommonUtil.clicksync(advSearchLinkheader);
		if(CommonUtil.isElementPresent(advSearchTextBox1)){
			
			return true;
		}
		return false;
	}
	return false;
}



public static boolean clickOnCitationSearchFromHeader() {
	if(CommonUtil.isElementPresent(citationSearchLinkheader)){
		CommonUtil.clicksync(citationSearchLinkheader);
		if(CommonUtil.isElementPresent(citationSearchTextBox1)){
			
			return true;
		}
		return false;
	}
	return false;
}

public static boolean checkissuedropdown(){
	String VolumeNumber= CommonUtil.getText(clickvolumeissue);
	String[] textTempArray1=VolumeNumber.split("Volume\n-");
    VolumeNumber=textTempArray1[1];
    CommonUtil.click(clickvolumeissue);
	String JournalVolumeNumber= CommonUtil.getText(checkvolumeissue);
	String[] textTempArray2=VolumeNumber.split(",");
	JournalVolumeNumber=textTempArray2[0];
    CommonUtil.scrolldown(clickvolumeissue);
    String issueyearrange= CommonUtil.getText(clickissuerange);
    CommonUtil.click(clickissuerange);
    String[] textTempArray3=issueyearrange.split("-");
    String issuerange1=textTempArray3[0];
 
   String issuerange2=textTempArray3[1];
   int issueStartRange = Integer.parseInt(issuerange1);
   int issueEndRange= Integer.parseInt(issuerange2);

   
   String getissueyear= CommonUtil.getText(checkissueyear);
   String[] textTempArray4=getissueyear.split(" - ");
   getissueyear= textTempArray4[0];
   int getyear= Integer.parseInt(getissueyear);
   
 
	if((VolumeNumber.contains(JournalVolumeNumber)) && (issueStartRange <= getyear && getyear <= issueEndRange)){
		msg = "Drop Down is open";	
		//log.info(msg);
		CommonUtil.report(msg,pass);
		return true;
	}else{
		msg = "Drop Down is not open";	
		//log.info(msg);
		CommonUtil.report(msg,fail, "Present");
		return false;
	}
}

public static boolean performCitationSearch(String[] values) {
	if(CommonUtil.isElementPresent(citationSearchTextBox1)
			&& CommonUtil.isElementPresent(citationYearTextBox)
			&& CommonUtil.isElementPresent(citationVolumeTextBox)
			&& CommonUtil.isElementPresent(citationIssueTextBox)){
		CommonUtil.sleep(5000);
		CommonUtil.sendKeys(citationSearchTextBox1, values[0]);
		CommonUtil.sendKeys(citationYearTextBox, values[1]);
		CommonUtil.sendKeys(citationVolumeTextBox, values[2]);
		CommonUtil.sendKeys(citationIssueTextBox, values[3]);
		CommonUtil.scrolldown(submitButtonCitation);
		CommonUtil.clicksync(submitButtonCitation);
		CommonUtil.sleep(5000);
		if(LiteratumPageImpl.citationSearchResultPageVerify(values))
			return true;
		return false;
	}
	return false;
}



public static String clickOnPDFArticleLink() {
	CommonUtil.sleep(2000);
	CommonUtil.scrolldown(clickonArticleLink);
	CommonUtil.sleep(2000);
	if(CommonUtil.isElementPresent(pdfLink)){
		String href = CommonUtil.getAttributeValue(pdfLink, "href");
		try{
			ReadcubePageImpl.loginAs("labtiva", "canary", href);
		}catch(TimeoutException e){
			
		}
		
		return href;	
	}
	return null;
}


public static boolean checkbookSection() {
	CommonUtil.click(clickbook);
	if(CommonUtil.isElementPresent(checkJournal)){
		msg = "Book List is present";	
		//log.info(msg);
		CommonUtil.report(msg,pass);
		return true;
	}else{
		msg = "Book List is not present";	
		//log.info(msg);
		CommonUtil.report(msg,fail, "Not Present");
		return false;
	}
}



public static String clickOnNormalPDFArticleLink() {
	// TODO Auto-generated method stub
	CommonUtil.sleep(2000);
	CommonUtil.scrolldown(BookHomeTOCtext);
	CommonUtil.sleep(2000);
	if(CommonUtil.isElementPresent(pdfLink)){
		String href = CommonUtil.getAttributeValue(pdfLink, "href");
		CommonUtil.clicksync(pdfLink);
		msg = "clicked on PDF";	
		CommonUtil.report(msg,pass);
		return href;	
	}
	msg = "clicked on PDF";	
	CommonUtil.report(msg,fail, "Not clicked");
	return null;
}



public static boolean checkbookTitle(String book) {
	String book_link = "//a[contains(text(),'"+book+"')]";
	By clickBookTitle= By.xpath(book_link);
	
	String bookname=CommonUtil.getText(clickBookTitle);
	 
	CommonUtil.clicksync(clickBookTitle);
	
	
	if(CommonUtil.verifyCurrentURL(bookname.split(",")[0])){
		msg = "Book Title is present";	
		//log.info(msg);
		CommonUtil.report(msg,pass);
		return true;
	}else{
		msg = "Book Title is not present";	
		//log.info(msg);
		CommonUtil.report(msg,fail, "Not Present");
		return false;
	}
}



public static String clickOnJournalArticleLink() {
	// TODO Auto-generated method stub
	CommonUtil.sleep(2000);
	CommonUtil.scrolldown(clickonArticleLink);
	CommonUtil.sleep(2000);
	if(CommonUtil.isElementPresent(JournalArticleLink)){
		String href = CommonUtil.getAttributeValue(JournalArticleLink, "href");
		CommonUtil.clicksync(JournalArticleLink);
		msg = "clicked on Full Text";	
		CommonUtil.report(msg,pass);
		return href;
	}
	msg = "clicked on Full Text";	
	CommonUtil.report(msg,fail);
	return null;
}

public static boolean navigatejournalloi() {
	// TODO Auto-generated method stub
	CommonUtil.scrolldown(clickBeforeAbstract);
	CommonUtil.click(clcikbrowsearticle);
	
	
	String getURLdetails= CommonUtil.getAttributeValue(clickAllIssues, "href");
	CommonUtil.clicksync(clickAllIssues1);
	
	System.out.println(getURLdetails);
	String[] textTempArray=getURLdetails.split("/");
	getURLdetails= textTempArray[3];
	
	System.out.println(getURLdetails);
	
	
	
	if(CommonUtil.verifyURL(getURLdetails)){
		msg = "List of Issue page is open";	
		//log.info(msg);
		CommonUtil.report(msg,pass);
		return true;
	}else{
		msg = "List of Issue Page is not open";	
		//log.info(msg);
		CommonUtil.report(msg,fail, "Present");
		return false;
	}

}


public static boolean navigatejournalTOC(String VOL) {
	// TODO Auto-generated method stub"
	//a[.='"+Journal+"']";
	//a[contains(text(),'Volume 53, Issue 2')]
	String VOL_link = "//a[contains(text(),'"+VOL+"')]";
	System.out.println(VOL_link);

	By clickVOL_link= By.xpath(VOL_link);
	
	
	String gettocpage=CommonUtil.getAttributeValue(clickVOL_link, "href");
	CommonUtil.clicksync(clickVOL_link);
	System.out.println(gettocpage);
	String[] textTempArray=gettocpage.split("/");
	gettocpage= textTempArray[3];
	
	System.out.println(gettocpage);
	
	
	if(CommonUtil.verifyURL(gettocpage)){
		msg = "Issue TOC page is open";	
		//log.info(msg);
		CommonUtil.report(msg,pass);
		return true;
	}else{
		msg = "Issue TOC Page is not open";	
		//log.info(msg);
		CommonUtil.report(msg,fail, "Present");
		return false;
	}

}
}
