package wiley.automation.wol.workflow;

import org.openqa.selenium.WebDriver;

import wiley.automation.wol.impl.LiteratumPageImpl;

@SuppressWarnings("rawtypes")
public class LiteratumPage extends LiteratumPageImpl {
	private String msg;
	 
	//static Logger log = Logger.getLogger(LiteratumPage.class);
	 
	private final WebDriver driver;

    public LiteratumPage(WebDriver driver) {
        this.driver = driver;

        // Check that we're on the right page.
        /*if (!"Wiley Online Library".equals(driver.getTitle())) {
            // Alternatively, we could navigate to the login page, perhaps logging out first
            throw new IllegalStateException("This is not the login page");
        }*/
    }

   
	public static void homepage() {
		// TODO Auto-generated method stub
		LiteratumPageImpl.homepage();
		
	}
	
	public static boolean checkFeaturedSection(){
		if(LiteratumPageImpl.checkFeaturedSection())
			return true;
		return false;
	}
	
	public static boolean checkFeaturedImage(){
		if(LiteratumPageImpl.checkFeaturedImage())
			return true;
		return false;
	}
	
	public static boolean checkBrowseBySubject(){
		if(LiteratumPageImpl.checkBrowseBySubject())
			return true;
		return false;
	}
	
	public static boolean subjectList(){
		if(LiteratumPageImpl.subjectList())
			return true;
		return false;
	}
	public static boolean searchcheck(String DOI){
		if(LiteratumPageImpl.searchcheck(DOI))
			return true;
		return false;
	}


	public static boolean ClickAndVerifySaveSearchForNotLogin() {
		if(LiteratumPageImpl.ClickAndVerifySaveSearchForNotLogin())
			return true;
		return false;
	}


	public static boolean alphabeticalFilterOperation(String filter) {
		if(LiteratumPageImpl.alphabeticalFilterOperation(filter))
			return true;
		return false;
	}


	public static boolean publicationFilterOperation(String filter) {
		if(LiteratumPageImpl.publicationFilterOperation(filter))
			return true;
		return false;
	}
}