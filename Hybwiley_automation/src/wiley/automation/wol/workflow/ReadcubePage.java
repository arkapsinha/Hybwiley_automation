package wiley.automation.wol.workflow;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import wiley.automation.core.util.ObjectLocator;
import wiley.automation.wol.impl.LiteratumPageImpl;
import wiley.automation.wol.impl.ReadcubePageImpl;

public class ReadcubePage extends ObjectLocator {

	private final WebDriver driver;
	
	//static Logger log = Logger.getLogger(HomePage.class);

	
	ReadcubePageImpl readcubepage;

	public ReadcubePage(WebDriver driver) {
		this.driver = driver;
		readcubepage = new ReadcubePageImpl();
		// Check that we're on the right page.
		/*if (!"Wiley Online Library"
				.equals(driver.getTitle())) {
			// Alternatively, we could navigate to the login page, perhaps
			// logging out first
			throw new IllegalStateException("This is not the Home page");
		}*/
	}
	
	
	/*public SearchPage SearchPage() {
		return PageFactory.initElements(driver, SearchPage.class);
	}*/


	public static boolean checkReadcubePDF(String string) {
		if(ReadcubePageImpl.checkReadcubePDF(string))
			return true;
		return false;
	}


	public static boolean checkPDF(String string) {
		if(ReadcubePageImpl.checkPDF(string))
			return true;
		return false;
	}


	public static boolean checkReadcubeSharing(String string) {
		// TODO Auto-generated method stub
		return ReadcubePageImpl.checkReadcubeSharing(string);
	}


	/*public static boolean loginAs(String string, String string2) {
		if(ReadcubePageImpl.loginAs(string, string2))
			return true;
		return false;
	}*/
	
	
	
}
