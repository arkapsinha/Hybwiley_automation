package wiley.automation.wol.workflow;

import org.openqa.selenium.WebDriver;

import wiley.automation.wol.impl.journal_HomePageImpl;
import wiley.automation.wol.impl.search_book_pageImpl;

public class search_book_page extends search_book_pageImpl {
	private String msg;
	 
	//static Logger log = Logger.getLogger(LiteratumPage.class);
	 
	private final WebDriver driver;

    public search_book_page(WebDriver driver) {
        this.driver = driver;

        // Check that we're on the right page.
        /*if (!"Wiley Online Library".equals(driver.getTitle())) {
            // Alternatively, we could navigate to the login page, perhaps logging out first
            throw new IllegalStateException("This is not the login page");
        }*/
    }

   
	public static void homepagemove() {
		// TODO Auto-generated method stub
		search_book_pageImpl.homepagemove();
		
	}
	public static boolean checkbooksection(){
		if(search_book_pageImpl.checkbooksection())
			return true;
		return false;
	}
	
	public static boolean checkbookpage(String string){
		if(search_book_pageImpl.checkbookpage(string))
			return true;
		return false;
	}
	public static boolean checkbookcontent(){
		if(search_book_pageImpl.checkbookcontent())
			return true;
		return false;
	}
	public static boolean checksearchbox(String str){
		if(search_book_pageImpl.checksearchbox(str))
			return true;
		return false;
	}
	public static boolean clickOnSearchTextField(String string) {
		// TODO Auto-generated method stub
		if(search_book_pageImpl.clickOnSearchTextField(string))
			return true;
		return false;
	}

}
