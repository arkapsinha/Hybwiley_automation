package wiley.automation.wol.workflow;

import org.openqa.selenium.WebDriver;

import wiley.automation.wol.impl.Mrw_HomePageImpl;

@SuppressWarnings("rawtypes")
public class Mrw_HomePage extends Mrw_HomePageImpl {
	private static String msg;
	 
	//static Logger log = Logger.getLogger(LiteratumPage.class);
	 
	private final WebDriver driver;

    public Mrw_HomePage(WebDriver driver) {
        this.driver = driver;

        // Check that we're on the right page.
        /*if (!"Wiley Online Library".equals(driver.getTitle())) {
            // Alternatively, we could navigate to the login page, perhaps logging out first
            throw new IllegalStateException("This is not the login page");
        }*/
    }

   
	public static void homepagemove() {
		// TODO Auto-generated method stub
		Mrw_HomePageImpl.homepagemove();
		
	}
	

	public static boolean checkMrwHomepage(String string){
		if(Mrw_HomePageImpl.checkMrwHomepage(string))
			return true;
		return false;
	}
	

	public static boolean checkMrwPageContent() {
		if(Mrw_HomePageImpl.checkMrwPageContent())
			return true;
		return false;
	}
	
	
	
}

