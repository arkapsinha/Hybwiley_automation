package wiley.automation.wol.workflow;

import org.openqa.selenium.WebDriver;

import wiley.automation.core.util.ObjectLocator;
import wiley.automation.wol.impl.DSSImpl;

public class DSS_Page extends ObjectLocator {

	private final WebDriver driver;
	
	//static Logger log = Logger.getLogger(HomePage.class);

	
	static DSSImpl dss;

	public DSS_Page(WebDriver driver) {
		this.driver = driver;
		dss = new DSSImpl();
		// Check that we're on the right page.
		
	}

	public static boolean hoverOn(String string) {
		return DSSImpl.hoverOn(string);
	}

	public static boolean clickOnLink(String string) {
		return DSSImpl.clickOnLink(string);
	}
	
	public static boolean clickOnLinkSync(String string) {
		return DSSImpl.clickOnLinkSync(string);
	}
	
	public static boolean checkProcessStatus(String string) {
		return DSSImpl.checkProcessStatus(string);
	}
	public static boolean searchContent(String dOI) {
		// TODO Auto-generated method stub
		return DSSImpl.searchContent(dOI);
	}

	public static boolean verifyAndCheckContent(String dOI) {
		// TODO Auto-generated method stub
		return DSSImpl.verifyAndCheckContent(dOI);
	}
	
	public static String checkWebdav(String string) {
		return DSSImpl.checkWebdav(string);
	}
	
	public static boolean checkProcessingQueue(String string1, String string) {
		return DSSImpl.checkProcessingQueue(string1,string);
	}
	
	public static void navigateToProcessQueuePage() {
		DSSImpl.navigateToProcessQueuePage();
	}
	
	
}
