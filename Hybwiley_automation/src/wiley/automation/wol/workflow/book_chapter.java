package wiley.automation.wol.workflow;

import org.openqa.selenium.WebDriver;

import wiley.automation.wol.impl.book_chapterImpl;

public class book_chapter extends book_chapterImpl {
	private String msg;
	 
	//static Logger log = Logger.getLogger(LiteratumPage.class);
	 
	private final WebDriver driver;

    public book_chapter(WebDriver driver) {
        this.driver = driver;

        // Check that we're on the right page.
        /*if (!"Wiley Online Library".equals(driver.getTitle())) {
            // Alternatively, we could navigate to the login page, perhaps logging out first
            throw new IllegalStateException("This is not the login page");
        }*/
    }

   
	public static void homepagemove() {
		// TODO Auto-generated method stub
		book_chapterImpl.homepagemove();
		
	}
	public static boolean checkbooksection(){
		if(book_chapterImpl.checkbooksection())
			return true;
		return false;
	}
	
	public static boolean checkbookpage(){
		if(book_chapterImpl.checkbookpage())
			return true;
		return false;
	}
	public static boolean checkchapterpage(){
		if(book_chapterImpl.checkchapterpage())
			return true;
		return false;
	}
}
