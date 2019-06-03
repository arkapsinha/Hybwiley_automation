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

public class literatum_Sanity extends VariableController {
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


@DataProvider(name="literatum1")
	public Object[][] literatum1() {
		Object[][] arrayObject = ReadExcelDataProvider.getExcelData(VariableController.dataSheet,VariableController.May_2_12_0,"literatum_TC1");
			return arrayObject;
		}

@Test(dataProvider="literatum1")
	public void literatum1(String No,
		   String Active,
		   String Scenario,
		   String TestCase,
		   String DOI,
		   String Username,
		   String Password,
		   String Volumne
		  ) {
    String msg;
    flag = false;
    flag1 = false;
    flag2 = false;
    flag3 = false;
    flag4 = false;
    flag5 = false;
    
    try{
    	JavascriptExecutor je = (JavascriptExecutor) driver;
    	setTestCaseName(TestCase+"_"+No,Scenario);
    	
    	assertNotNull(LoginPage.loginAs(Username, Password), "Login Not successful");
		
    	assertTrue(LoginPage.goToMyProfile(), "My profile not available");
		
    	LiteratumPage.homepage();
    
    	assertTrue(LiteratumPage.checkFeaturedSection(), "Featured Section is not available");
    	assertTrue(LiteratumPage.checkFeaturedImage(), "Image is not present");
    	assertTrue(LiteratumPage.checkBrowseBySubject(), "Browse By Subject Section is not present");
    	assertTrue(LiteratumPage.subjectList(), "Subject List is not present");
    	assertTrue(LiteratumPage.searchcheck(DOI), "Search functionality is not present");
    	
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
@DataProvider(name="literatum23")
public Object[][] literatum23() {
	Object[][] arrayObject = ReadExcelDataProvider.getExcelData(VariableController.dataSheet,VariableController.May_2_12_0,"literatum_TC23");
		return arrayObject;
	}

@Test(dataProvider="literatum23")
public void literatum23(String No,
	   String Active,
	   String Scenario,
	   String TestCase,
	   String DOI,
	   String Username,
	   String Password,
	   String Volumne
	  ) {
String msg;
flag = false;
flag1 = false;
flag2 = false;
flag3 = false;
flag4 = false;
flag5 = false;

try{
	JavascriptExecutor je = (JavascriptExecutor) driver;
	setTestCaseName(TestCase+"_"+No,Scenario);
	
	assertNotNull(LoginPage.loginAs(Username, Password), "Login Not successful");
	
	assertTrue(LoginPage.goToMyProfile(), "My profile not available");
	
	assertTrue(LoginPage.updateUserProfile(),"User profile not updated");
	
		
	Status = "Pass";
	
	
	
}catch(Exception e){
	 CommonUtil.refresh(EnvUtil.getProperty("Literaturm_APPLICATION_URL"));
	 Status = "Fail";
	
}
finally{
	if(Status == null)
		Status = "Fail";
	ReportUtil.generateHTMLReport(Status);
	//Status=null;
}
}

@DataProvider(name="literatum19")
public Object[][] BrowsePubFilter() {
	Object[][] arrayObject = ReadExcelDataProvider.getExcelData(VariableController.dataSheet,VariableController.May_2_12_0,"literatum_TC19");
		return arrayObject;
	}

@Test(dataProvider="literatum19")
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

try{
	JavascriptExecutor je = (JavascriptExecutor) driver;
	setTestCaseName(TestCase+"_"+No,Scenario);
	
	CommonUtil.refresh(EnvUtil.getProperty("Literatum_Publication"));
	assertTrue(LiteratumPage.alphabeticalFilterOperation("A"), "Alphabetical filter not working");
	assertTrue(LiteratumPage.alphabeticalFilterOperation("B"), "Alphabetical filter not working");
	assertTrue(LiteratumPage.publicationFilterOperation("book"), "Publication filter not working");
	assertTrue(LiteratumPage.publicationFilterOperation("journal"), "Publication filter not working");
	
			
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
