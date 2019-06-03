package wiley.automation.wol.test;

import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

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
import wiley.automation.wol.workflow.Mrw_HomePage;

public class literatum_journal_homepage extends VariableController {
	//static Logger log = Logger.getLogger(literatum_journal_homepage.class);
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


@DataProvider(name="literatum2")
	public Object[][] literatum2() {
		Object[][] arrayObject = ReadExcelDataProvider.getExcelData(VariableController.dataSheet,VariableController.May_2_12_0,"literatum_TC2");
			return arrayObject;
		}
@Test(dataProvider="literatum2")
	public void literatum(String No,
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
    	
    	setTestCaseName(TestCase+"_"+No,Scenario);
    	LoginPage login = new LoginPage(driver);
	
    	assertNotNull(LoginPage.loginAs(Username, Password), "Login Not successful");

    	assertTrue(journal_HomePage.checkjournalSection(), "Journal List is not present");
    	assertTrue(journal_HomePage.checkjournalTitle(DOI), "Journal is not present");
    	journal_HomePage.homepagemove();
    	assertTrue(journal_HomePage.checkcurrentIssue(), "Current Issue ISSN number is not present");
		
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

@DataProvider(name="literatum3")
public Object[][] literatum3() {
	Object[][] arrayObject = ReadExcelDataProvider.getExcelData(VariableController.dataSheet,VariableController.May_2_12_0,"literatum_TC3");
		return arrayObject;
	}
@Test(dataProvider="literatum3")
public void literatum3(String No,
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
	
	setTestCaseName(TestCase+"_"+No,Scenario);
	LoginPage login = new LoginPage(driver);
	
	assertNotNull(LoginPage.loginAs(Username, Password), "Login Not successful");
	
	assertTrue(Mrw_HomePage.checkMrwHomepage(DOI), "MRW Home page is not open");
	assertTrue(Mrw_HomePage.checkMrwPageContent(), "All Content are not present");
		
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


@DataProvider(name="literatum25")
public Object[][] literatum25() {
	Object[][] arrayObject = ReadExcelDataProvider.getExcelData(VariableController.dataSheet,VariableController.May_2_12_0,"literatum_TC25");
		return arrayObject;
	}
@Test(dataProvider="literatum25")
public void literatum25(String No,
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
	
	setTestCaseName(TestCase+"_"+No,Scenario);
	LoginPage login = new LoginPage(driver);
	
	assertNotNull(LoginPage.loginAs(Username, Password), "Login Not successful");
	assertTrue(journal_HomePage.checkjournalSection(), "Journal List is not present");
	assertTrue(journal_HomePage.loadIucrPage(DOI), "IUCR Page is not Loaded");
	
	
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
