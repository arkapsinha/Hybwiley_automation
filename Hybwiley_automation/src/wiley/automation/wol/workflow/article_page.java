package wiley.automation.wol.workflow;

import org.openqa.selenium.WebDriver;

import wiley.automation.wol.impl.article_PageImpl;

public class article_page extends article_PageImpl {
	private String msg;
	 
	//static Logger log = Logger.getLogger(LiteratumPage.class);
	 
	private final WebDriver driver;

    public article_page(WebDriver driver) {
        this.driver = driver;

        // Check that we're on the right page.
        /*if (!"Wiley Online Library".equals(driver.getTitle())) {
            // Alternatively, we could navigate to the login page, perhaps logging out first
            throw new IllegalStateException("This is not the login page");
        }*/
    }

   
	public static void homepagemove() {
		// TODO Auto-generated method stub
		article_PageImpl.homepagemove();
		
	}
	public static boolean checkjournalSection(){
		if(article_PageImpl.checkjournalSection())
			return true;
		return false;
	}
	public static boolean checkjournalTitle(){
		if(article_PageImpl.checkjournalTitle())
			return true;
		return false;
}
	public static boolean clickAbstractLink(){
		if(article_PageImpl.clickAbstractLink())
			return true;
		return false;
	}
	
	public static boolean checkAuthor(){
		if(article_PageImpl.checkAuthor())
			return true;
		return false;
	}
	public static boolean checkMultilingual(){
		if(article_PageImpl.checkMultilingual())
			return true;
		return false;
	}
}

