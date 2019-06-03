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
import wiley.automation.wol.workflow.ReadcubePage;
import wiley.automation.wol.workflow.journal_HomePage;

public class literatum_Readcube extends VariableController {
	//static Logger log = Logger.getLogger(literatum_Sanity.class);
	protected WebBrowser WOLBrowser = null;
	private boolean flag, flag1, flag2, flag3, flag4, flag5 = false;
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


@DataProvider(name="literatum20")
	public Object[][] readcubePDFContent() {
		Object[][] arrayObject = ReadExcelDataProvider.getExcelData(VariableController.dataSheet,VariableController.May_2_12_0,"literatum_TC20");
			return arrayObject;
		}

@Test(dataProvider="literatum20")
	public void readcubePDFContent(String No,
		   String Active,
		   String Scenario,
		   String TestCase,
		   String DOI,
		   String Username,
		   String Password,
		   String Volumne
		  ) {
    String string;
    
    try{
    	JavascriptExecutor je = (JavascriptExecutor) driver;
    	setTestCaseName(TestCase+"_"+No,Scenario);
    	    	
    	assertNotNull(LoginPage.loginAs(Username, Password), "Login Not successful");
		
    	CommonUtil.refresh(EnvUtil.getProperty("Literaturm_APPLICATION_URL"));
    	
		assertTrue(journal_HomePage.checkjournalSection(), "Journal List is not present");
		assertTrue(journal_HomePage.checkjournalTitle(DOI), "Journal is not present");
		assertNotNull(string = journal_HomePage.clickOnPDFArticleLink(), "PDF Link not present");
		assertTrue(ReadcubePage.checkReadcubePDF(string), "Journal is not present");
    			
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

@DataProvider(name="literatum21")
public Object[][] BrowsePubFilter() {
	Object[][] arrayObject = ReadExcelDataProvider.getExcelData(VariableController.dataSheet,VariableController.May_2_12_0,"literatum_TC21");
		return arrayObject;
	}

@Test(dataProvider="literatum21")
public void BrowsePubFilter(String No,
	   String Active,
	   String Scenario,
	   String TestCase,
	   String DOI,
	   String Username,
	   String Password,
	   String Volumne
	  ) {
String msg;
String string;

try{
	JavascriptExecutor je = (JavascriptExecutor) driver;
	setTestCaseName(TestCase+"_"+No,Scenario);
	
	assertTrue(journal_HomePage.checkbookSection(), "Book List is not present");
	assertTrue(journal_HomePage.checkbookTitle(DOI), "Book is not present");
	assertNotNull(string = journal_HomePage.clickOnNormalPDFArticleLink(), "PDF Link not present");
	assertTrue(ReadcubePage.checkPDF(string), "Journal is not present");
			
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


@DataProvider(name="literatum26")
public Object[][] readcubePDFContentOption() {
	Object[][] arrayObject = ReadExcelDataProvider.getExcelData(VariableController.dataSheet,VariableController.May_2_12_0,"literatum_TC26");
		return arrayObject;
	}

@Test(dataProvider="literatum26")
public void readcubePDFSharing(String No,
	   String Active,
	   String Scenario,
	   String TestCase,
	   String DOI,
	   String Username,
	   String Password,
	   String Volumne
	  ) {
String string;

try{
	JavascriptExecutor je = (JavascriptExecutor) driver;
	setTestCaseName(TestCase+"_"+No,Scenario);
	    	
	assertNotNull(LoginPage.loginAs(Username, Password), "Login Not successful");
	
	CommonUtil.refresh(EnvUtil.getProperty("Literaturm_APPLICATION_URL"));
	
	assertTrue(journal_HomePage.clickOnSearchTextField1(), "Search text box present in Home Page");
	assertTrue(LiteratumPage.searchcheck(DOI.split(";")[0]), "Search did not work in Home Page");
	assertTrue(journal_HomePage.checkjournalTitle(DOI.split(";")[1]), "Journal is not present");
	assertNotNull(string = journal_HomePage.clickOnJournalArticleLink(), "Full Text Link not present");
	assertTrue(ReadcubePage.checkReadcubeSharing("Share full text access"), "Read cube sharing option is not present");
				
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
