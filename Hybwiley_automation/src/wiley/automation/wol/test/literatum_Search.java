package wiley.automation.wol.test;

import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import wiley.automation.core.driver.BrowserList;
import wiley.automation.core.driver.WebBrowser;
import wiley.automation.core.report.ReportUtil;
import wiley.automation.core.util.CommonUtil;
import wiley.automation.core.util.EnvUtil;
import wiley.automation.core.util.ReadExcelDataProvider;
import wiley.automation.core.util.VariableController;
import wiley.automation.wol.workflow.LiteratumPage;
import wiley.automation.wol.workflow.LoginPage;
import wiley.automation.wol.workflow.journal_HomePage;

public class literatum_Search extends VariableController {
	//static Logger log = Logger.getLogger(literatum_Sanity.class);
	protected WebBrowser WOLBrowser = null;
	private  WebDriver driver;
	String Status;
	static String DOI_local = null;


	@BeforeMethod
	public void Setup()
  {
	   //log.info("Before Test");
		try {
			WOLBrowser = BrowserList.Browser("QI");
			WOLBrowser.NavigateTo(EnvUtil.getProperty("Browser"),EnvUtil.getProperty("Literaturm_APPLICATION_URL"));	
			driver = CommonUtil.getDriver();
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			Status = null;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}     
  }
@AfterMethod
	 public void TearDown(){
			try {
				WOLBrowser.Quit();
				WOLBrowser = null;
				CommonUtil.CloseDriver();
				Status = null;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				if(WOLBrowser != null){
					WOLBrowser.Quit();
					WOLBrowser = null;
					Status = null;
				}
			}
	    }


@DataProvider(name="literatum12")
	public Object[][] literatumSearch() {
		Object[][] arrayObject = ReadExcelDataProvider.getExcelData(VariableController.dataSheet,VariableController.May_2_12_0,"literatum_TC12");
			return arrayObject;
		}

@Test(dataProvider="literatum12")
	public void literatumSearch(String No,
		   String Active,
		   String Scenario,
		   String TestCase,
		   String DOI,
		   String Username,
		   String Password,
		   String Volumne
		  ) {
    String msg;
    
    try{
    	JavascriptExecutor je = (JavascriptExecutor) driver;
    	setTestCaseName(TestCase+"_"+No,Scenario);
    	assertNotNull(LoginPage.loginAs(Username, Password), "Login Not successful");
		
    	assertTrue(LoginPage.goToMyProfile(), "My profile not available");
		
		LiteratumPage.homepage();
    	
		assertTrue(journal_HomePage.checkjournalSection(), "Journal List is not present");
		assertTrue(journal_HomePage.checkjournalTitle(DOI), "Journal is not present");
		assertTrue(journal_HomePage.clickOnSearchTextField(), "Search text box present in Journal Home Page");
		assertTrue(journal_HomePage.verifySearchDropDownValueAs("This Journal"), "Search DropDown Value does not present correctly");
		assertTrue(journal_HomePage.enterSearchTermAndVerifyAutoSuggestions(DOI));
		
    	Status = "Pass";
    	
    	
    	
    }catch(Exception e){
    	 CommonUtil.refresh(EnvUtil.getProperty("Literaturm_APPLICATION_URL"));
		 Status = "Fail";
		 
    }
    finally{
    	if(Status == null)
    		Status = "Fail";
    	ReportUtil.generateHTMLReport(Status);
    	
    }
}


@DataProvider(name="literatum13")
public Object[][] literatumAdvSearch() {
	Object[][] arrayObject = ReadExcelDataProvider.getExcelData(VariableController.dataSheet,VariableController.May_2_12_0,"literatum_TC13");
		return arrayObject;
	}

@Test(dataProvider="literatum13")
public void literatumAdvSearch(String No,
	   String Active,
	   String Scenario,
	   String TestCase,
	   String DOI,
	   String Username,
	   String Password,
	   String Volumne
	  ) {
    
try{
	JavascriptExecutor je = (JavascriptExecutor) driver;
	setTestCaseName(TestCase+"_"+No,Scenario);
	
	assertNotNull(LoginPage.loginAs(Username, Password), "Login Not successful");
	
	assertTrue(LoginPage.goToMyProfile(), "My profile not available");
	
	LiteratumPage.homepage();
	
	assertTrue(journal_HomePage.clickOnSearchTextField1(), "Search text box present in Home Page");
	assertTrue(journal_HomePage.clickOnAdvanceSearch(), "Advance search page opened");
	assertTrue(journal_HomePage.performAdvanceSearch("Title", DOI), "Advance search page opened");
	CommonUtil.refresh(EnvUtil.getProperty("Literaturm_APPLICATION_URL"));
	assertTrue(journal_HomePage.checkjournalSection(), "Journal List is not present");
	assertTrue(journal_HomePage.clickOnSearchTextField1(), "Search text box present in Journal Home Page");
	assertTrue(journal_HomePage.clickOnAdvanceSearchFromHeader(), "Advance search clicked");
	assertTrue(journal_HomePage.performAdvanceSearch("Title", DOI), "Advance search page opened");
	
	Status = "Pass";

	
	
}catch(Exception e){
	 CommonUtil.refresh(EnvUtil.getProperty("Literaturm_APPLICATION_URL"));
	 Status = "Fail";
	 
}
finally{
	if(Status == null)
		Status = "Fail";
	ReportUtil.generateHTMLReport(Status);
}
}

@DataProvider(name="literatum14")
public Object[][] literatumCitationSearch() {
	Object[][] arrayObject = ReadExcelDataProvider.getExcelData(VariableController.dataSheet,VariableController.May_2_12_0,"literatum_TC14");
		return arrayObject;
	}

@Test(dataProvider="literatum14")
public void literatumCitationSearch(String No,
	   String Active,
	   String Scenario,
	   String TestCase,
	   String DOI,
	   String Username,
	   String Password,
	   String Volumne
	  ) {
    
try{
	String[] values = DOI.split(";");
	JavascriptExecutor je = (JavascriptExecutor) driver;
	setTestCaseName(TestCase+"_"+No,Scenario);
	assertNotNull(LoginPage.loginAs(Username, Password), "Login Not successful");
	assertTrue(LoginPage.goToMyProfile(), "My profile not available");
	
	LiteratumPage.homepage();
	
	assertTrue(journal_HomePage.checkjournalSection(), "Journal List is not present");
	assertTrue(journal_HomePage.clickOnSearchTextField1(), "Search text box not present in Journal Home Page");
	assertTrue(journal_HomePage.clickOnCitationSearchFromHeader(), "Citation search did not click");
	assertTrue(journal_HomePage.performCitationSearch(values), "Citation search did not work");
	
	Status = "Pass";
	
	
	
}catch(Exception e){
	 CommonUtil.refresh(EnvUtil.getProperty("Literaturm_APPLICATION_URL"));
	 Status = "Fail";
	 
}
finally{
	if(Status == null)
		Status = "Fail";
	ReportUtil.generateHTMLReport(Status);
	
}
}


@DataProvider(name="literatum15")
public Object[][] literatumSaveSearchNonLogin() {
	Object[][] arrayObject = ReadExcelDataProvider.getExcelData(VariableController.dataSheet,VariableController.May_2_12_0,"literatum_TC15");
		return arrayObject;
	}

@Test(dataProvider="literatum15")
public void literatumSaveSearchNonLogin(String No,
	   String Active,
	   String Scenario,
	   String TestCase,
	   String DOI,
	   String Username,
	   String Password,
	   String Volumne
	  ) {
    
try{

	setTestCaseName(TestCase+"_"+No,Scenario);
		
	assertTrue(journal_HomePage.clickOnSearchTextField1(), "Search text box present in Home Page");
	assertTrue(LiteratumPage.searchcheck(DOI), "Search did not work in Home Page");
	assertTrue(LiteratumPage.ClickAndVerifySaveSearchForNotLogin(), "Saved search did not work");
	assertTrue(LoginPage.verifyLoginPage("text"), "Login page not loaded");
	
	
	Status = "Pass";
	
	
	
}catch(Exception e){
	 CommonUtil.refresh(EnvUtil.getProperty("Literaturm_APPLICATION_URL"));
	 Status = "Fail";
	 
}
finally{
	if(Status == null)
		Status = "Fail";
	ReportUtil.generateHTMLReport(Status);
	
}
}

}
