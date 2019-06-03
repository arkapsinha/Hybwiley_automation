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
import wiley.automation.wol.workflow.about_this_book;
import wiley.automation.wol.workflow.book_chapter;

public class literatum_About_This_Book extends VariableController {
	//static Logger log = Logger.getLogger(literatum_About_This_Book.class);
	protected WebBrowser WOLBrowser = null;
	private boolean flag, flag1, flag2, flag3, flag4, flag5 = false;
	private  WebDriver driver;
	String Status;
	static String DOI_local = null;


	@BeforeMethod
	public void Setup()
  {
	  // log.info("Before Test");
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


@DataProvider(name="literatum8")
	public Object[][] literatum8() {
		Object[][] arrayObject = ReadExcelDataProvider.getExcelData(VariableController.dataSheet,VariableController.May_2_12_0,"literatum_TC8");
			return arrayObject;
		}
@Test(dataProvider="literatum8")
	public void literatum8(String No,
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
    	
  		assertTrue(about_this_book.checkbooksection(), "Book Home Page Failed to open");
   		assertTrue(about_this_book.checkbookpage(), "Failed to open the book");
    	assertTrue(about_this_book.checkbookcontent(), "Book content not present");
    	assertTrue(about_this_book.checkshowall(), "Show all content is not present");
    	assertTrue(about_this_book.checkshowallcontent(), "Show all remaining content is not present");
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
