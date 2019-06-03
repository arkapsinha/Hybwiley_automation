/*package wiley.automation.wol.workflow;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import wiley.automation.core.util.ObjectLocator;
import wiley.automation.wol.impl.HomePageImpl;

public class HomePage extends ObjectLocator {

	private final WebDriver driver;
	
	//static Logger log = Logger.getLogger(HomePage.class);

	int i, j, k, l, m;
	int h1, h2, h3, h4, h5;
	int countoflinkh1, countoflinkh2, countoflinkh3, countoflinkh4,
			countoflinkh5;
	int HierKeyValue;
	boolean flag = false;
	String lgth;
	By hiercharkeypath;
	private String msg;
	HomePageImpl homepage;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		homepage = new HomePageImpl();
		// Check that we're on the right page.
		if (!"Wiley Online Library"
				.equals(driver.getTitle())) {
			// Alternatively, we could navigate to the login page, perhaps
			// logging out first
			throw new IllegalStateException("This is not the Home page");
		}
	}
	
	
	public SearchPage SearchPage() {
		return PageFactory.initElements(driver, SearchPage.class);
	}
	
	
	public LicenseSourcePage licenseSourcePage() {
		return PageFactory.initElements(driver, LicenseSourcePage.class);
	}
	
	
	public JournalPage Journapage() {
		// TODO Auto-generated method stub
		return PageFactory.initElements(driver, JournalPage.class);
	}


	public void goToLink(String string) {
		// TODO Auto-generated method stub
		homepage.goToLink(string);
	}


	public boolean verifyReferenceWork() {
		// TODO Auto-generated method stub
		if(homepage.verifyReferenceWork())
			return true;
		return false;
	}


	public boolean verifyReferenceWorkLinkNotPresent() {
		// TODO Auto-generated method stub
		if(homepage.verifyReferenceWorkLinkNotPresent())
			return true;
		return false;
	}

	
	
}
*/