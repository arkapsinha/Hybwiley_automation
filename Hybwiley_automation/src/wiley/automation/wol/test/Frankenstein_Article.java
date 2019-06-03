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
import wiley.automation.wol.workflow.DSS_Page;
import wiley.automation.wol.workflow.LiteratumPage;
import wiley.automation.wol.workflow.LoginPage;
import wiley.automation.wol.workflow.journal_HomePage;

public class Frankenstein_Article extends VariableController {
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
			WOLBrowser.NavigateTo(EnvUtil.getProperty("Browser"),EnvUtil.getProperty("DSS_QA_APPLICATION_URL"));	
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


@DataProvider(name="Frankenstein")
	public Object[][] literatumSearch() {
		Object[][] arrayObject = ReadExcelDataProvider.getExcelData(VariableController.dataSheet,VariableController.May_2_12_0,"Frankenstein_TC");
			return arrayObject;
		}

@Test(dataProvider="Frankenstein")
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
    	String value;
		assertTrue(LoginPage.loginDSSAs(EnvUtil.getProperty("DSS_QA_Username"), EnvUtil.getProperty("DSS_QA_Password")), "DSS Login Unsuccessful");
    	assertTrue(DSS_Page.hoverOn("MONITOR"),"Hover in MONITER unsccessful");
    	assertTrue(DSS_Page.clickOnLinkSync("Search Content"), "Search Content Click unsuccessful");
    	assertTrue(DSS_Page.searchContent(DOI), "Search unsuccessful");
    	assertTrue(DSS_Page.clickOnLink("Add to delivery"), "Add to delivery Click unsuccessful");
    	assertTrue(DSS_Page.hoverOn("DELIVER"),"Hover in DELIVER unsccessful");
    	assertTrue(DSS_Page.clickOnLinkSync("Manual Delivery"), "Manual Delivery Click unsuccessful");
    	assertTrue(DSS_Page.verifyAndCheckContent(DOI), "Manual Delivery Click unsuccessful");
    	assertTrue(DSS_Page.hoverOn("MONITOR"),"Hover in MONITER unsccessful");
    	assertTrue(DSS_Page.hoverOn("MONITOR"),"Hover in MONITER unsccessful");
    	assertTrue(DSS_Page.clickOnLinkSync("Bulk Deliveries"), "Bulk Deliveries Click unsuccessful");
    	assertTrue(DSS_Page.checkProcessStatus(Volumne), "Processing is unsuccessful");
    	assertNotNull(value= DSS_Page.checkWebdav(DOI),"Processing is unsuccessful");
    	DSS_Page.navigateToProcessQueuePage();
    	assertNotNull(LoginPage.ProcessingQueueloginAs(Username, Password), "Login Not successful");
    	assertTrue(DSS_Page.checkProcessingQueue(DOI,value), "Processing is unsuccessful");
    	//assertTrue(DSS_Page.checkProcessingQueue(DOI,"mrwseries_0470025077_20171101092500#24927.zip"), "Processing is unsuccessful");
    	
    	
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
