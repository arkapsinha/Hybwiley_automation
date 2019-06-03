package wiley.automation.wol.workflow;

import org.openqa.selenium.WebDriver;

import wiley.automation.wol.impl.journal_HomePageImpl;

@SuppressWarnings("rawtypes")
public class journal_HomePage extends journal_HomePageImpl {
	private static String msg;
	 
	//static Logger log = Logger.getLogger(LiteratumPage.class);
	 
	private final WebDriver driver;

    public journal_HomePage(WebDriver driver) {
        this.driver = driver;

        // Check that we're on the right page.
        /*if (!"Wiley Online Library".equals(driver.getTitle())) {
            // Alternatively, we could navigate to the login page, perhaps logging out first
            throw new IllegalStateException("This is not the login page");
        }*/
    }

   
	public static void homepagemove() {
		// TODO Auto-generated method stub
		journal_HomePageImpl.homepagemove();
		
	}
	
	public static void navigatetoLoiPage() {
		// TODO Auto-generated method stub
		journal_HomePageImpl.navigatetoLoiPage();
		
	}
	public static boolean checkjournalSection(){
		if(journal_HomePageImpl.checkjournalSection())
			return true;
		return false;
	}
	
	public static boolean checkjournalTitle(){
		if(journal_HomePageImpl.checkjournalTitle())
			return true;
		return false;
	}
	
	//Added by Tamaghna
	
	public static boolean checkjournalTitle(String string){
		if(journal_HomePageImpl.checkjournalTitle(string))
			return true;
		return false;
	}
	
	public static boolean loadIucrPage(String string){
		if(journal_HomePageImpl.loadIucrPage(string))
			return true;
		return false;
	}
	//
	
	public static boolean checkcurrentIssue(){
		if(journal_HomePageImpl.checkcurrentIssue())
			return true;
		return false;
}
	public static boolean checksubjectsection(){
		if(journal_HomePageImpl.checksubjectsection())
			return true;
		return false;
}

	//Added by Tamaghna
	public static boolean clickOnSearchTextField() {
		// TODO Auto-generated method stub
		if(journal_HomePageImpl.clickOnSearchTextField())
			return true;
		return false;
	}
	
	public static boolean clickOnSearchTextField1() {
		// TODO Auto-generated method stub
		if(journal_HomePageImpl.clickOnSearchTextField1())
			return true;
		return false;
	}
	
	public static boolean checkissuedropdown() {
		// TODO Auto-generated method stub
		if(journal_HomePageImpl.checkissuedropdown())
			return true;
		return false;
	}
	
	public static boolean navigatejournalloi() {
		// TODO Auto-generated method stub
		if(journal_HomePageImpl.navigatejournalloi())
			return true;
		return false;
	}
	public static boolean navigatejournalTOC(String string) {
		// TODO Auto-generated method stub
		if(journal_HomePageImpl.navigatejournalTOC(string))
			return true;
		return false;
	}
	
	public static boolean verifySearchDropDownValueAs(String string) {
		// TODO Auto-generated method stub
		if(journal_HomePageImpl.verifySearchDropDownValueAs(string))
			return true;
		return false;
	}


	public static boolean enterSearchTermAndVerifyAutoSuggestions(String string) {
		// TODO Auto-generated method stub
		if(journal_HomePageImpl.enterSearchTermAndVerifyAutoSuggestions(string))
			return true;
		return false;
	}


	public static boolean clickOnAdvanceSearch() {
		// TODO Auto-generated method stub
		if(journal_HomePageImpl.clickOnAdvanceSearch())
			return true;
		return false;
	}


	public static boolean performAdvanceSearch(String string, String string1) {
		if(journal_HomePageImpl.performAdvanceSearch(string, string1))
			return true;
		return false;
	}


	public static boolean clickOnAdvanceSearchFromHeader() {
		if(journal_HomePageImpl.clickOnAdvanceSearchFromHeader())
			return true;
		return false;
	}


	public static boolean clickOnCitationSearchFromHeader() {
		if(journal_HomePageImpl.clickOnCitationSearchFromHeader())
			return true;
		return false;
	}


	public static boolean performCitationSearch(String[] values) {
		if(journal_HomePageImpl.performCitationSearch(values))
			return true;
		return false;
	}


	public static String clickOnPDFArticleLink() {
		return journal_HomePageImpl.clickOnPDFArticleLink();
	}


	public static boolean checkbookSection() {
		if(journal_HomePageImpl.checkbookSection())
			return true;
		return false;
	}


	public static String clickOnNormalPDFArticleLink() {
		return journal_HomePageImpl.clickOnNormalPDFArticleLink();
		
	}


	public static boolean checkbookTitle(String dOI) {
		if(journal_HomePageImpl.checkbookTitle(dOI))
			return true;
		return false;
	}


	public static String clickOnJournalArticleLink() {
		// TODO Auto-generated method stub
		return journal_HomePageImpl.clickOnJournalArticleLink();
	}


	/*public static boolean performSearch(String SearchString) {
		if(journal_HomePageImpl.performSearch(SearchString))
			return true;
		return false;
	}*/	
	
}

