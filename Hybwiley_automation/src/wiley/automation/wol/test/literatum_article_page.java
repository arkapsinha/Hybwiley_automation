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
import wiley.automation.wol.workflow.LoginPage;
import wiley.automation.wol.workflow.article_page;
import wiley.automation.wol.workflow.journal_HomePage;

public class literatum_article_page extends VariableController {
	//static Logger log = Logger.getLogger(literatum_article_page.class);
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


@DataProvider(name="literatum6")
	public Object[][] literatum6() {
		Object[][] arrayObject = ReadExcelDataProvider.getExcelData(VariableController.dataSheet,VariableController.May_2_12_0,"literatum_TC6");
			return arrayObject;
		}
@Test(dataProvider="literatum6")
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
		
		
		
    	assertTrue(article_page.checkjournalSection(), "Journal List is not present");
    	assertTrue(article_page.checkjournalTitle(), "Journal is not present");
    	assertTrue(article_page.clickAbstractLink(), "Abstract Article is not Open");
    	assertTrue(article_page.checkAuthor(), "Author is not visible");
		
		
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

@DataProvider(name="literatum5")
public Object[][] literatum5() {
	Object[][] arrayObject = ReadExcelDataProvider.getExcelData(VariableController.dataSheet,VariableController.May_2_12_0,"literatum_TC5");
		return arrayObject;
	}
@Test(dataProvider="literatum5")
public void literatum5(String No,
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
		
	assertTrue(article_page.checkjournalSection(), "Journal List is not present");
	assertTrue(article_page.checkjournalTitle(), "Journal is not present");
	assertTrue(article_page.clickAbstractLink(), "Abstract Article is not Open");
	assertTrue(article_page.checkMultilingual(), "Multilingual Option is not visible");
	
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
