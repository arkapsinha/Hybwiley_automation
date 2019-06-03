package wiley.automation.wol.workflow;

import org.openqa.selenium.WebDriver;

import wiley.automation.wol.impl.about_this_bookImpl;

public class about_this_book extends about_this_bookImpl {
	private String msg;
	 
	//static Logger log = Logger.getLogger(LiteratumPage.class);
	 
	private final WebDriver driver;

    public about_this_book(WebDriver driver) {
        this.driver = driver;

        // Check that we're on the right page.
        /*if (!"Wiley Online Library".equals(driver.getTitle())) {
            // Alternatively, we could navigate to the login page, perhaps logging out first
            throw new IllegalStateException("This is not the login page");
        }*/
    }

   
	public static void homepagemove() {
		// TODO Auto-generated method stub
		about_this_bookImpl.homepagemove();
		
	}
	public static boolean checkbooksection(){
		if(about_this_bookImpl.checkbooksection())
			return true;
		return false;
	}
	
	public static boolean checkbookpage(){
		if(about_this_bookImpl.checkbookpage())
			return true;
		return false;
	}
	public static boolean checkbookcontent(){
		if(about_this_bookImpl.checkbookcontent())
			return true;
		return false;
	}
	
	public static boolean checkshowall(){
		if(about_this_bookImpl.checkshowall())
			return true;
		return false;
	}
	public static boolean checkshowallcontent(){
		if(about_this_bookImpl.checkshowallcontent())
			return true;
		return false;
	}
}
