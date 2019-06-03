package wiley.automation.wol.test;

import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import wiley.automation.core.driver.BrowserList;
import wiley.automation.core.driver.WebBrowser;
import wiley.automation.core.report.ReportUtil;
import wiley.automation.core.util.CommonUtil;
import wiley.automation.core.util.EnvUtil;
import wiley.automation.core.util.ReadExcelDataProvider;
import wiley.automation.core.util.VariableController;
import com.github.invictum.fixtures.AbstractFixture;
import wiley.automation.core.hybris.Hybriser;
import wiley.automation.core.hybris.baseStoreModel;
import wiley.automation.wol.workflow.LoginPage;

import wiley.automation.wol.workflow.WEL_Page;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.LogStatus;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class welstorefront extends VariableController {
	//static Logger log = Logger.getLogger(literatum_Sanity.class);
	//static ExtentTest test;
	//static ExtentReports report;
	
	protected WebBrowser WOLBrowser = null;
	private  WebDriver driver;
	String Statu, BrowserDetails;
	String value,value1,value2, value3, value4, value5, value6, value7, value8, value9, value10, value11, value12, value13, value14, value15, value16, value17, value18, value19;
	static String DOI_local = null;
	// new change
	public ExtentHtmlReporter htmlReporter;
	 public ExtentReports extent;
	 public ExtentTest test;
//

	@BeforeSuite
	public void Setupreport()
	  {
		   //log.info("Before Test");
			try {
				
				//report = new ExtentReports(System.getProperty("user.dir")+"\\output\\ExtentReportResults.html");
				htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/output/STMExtentReport.html");
		         // Create an object of Extent Reports
				extent = new ExtentReports();  
				
//			      htmlReporter = new ExtentHtmlReporter(filePath);
		        htmlReporter.loadXMLConfig(System.getProperty("user.dir")+"/extent-config.xml");
			        
			
				extent.attachReporter(htmlReporter);
				extent.setSystemInfo("Host Name", "SoftwareTestingMaterial");
		         extent.setSystemInfo("Environment", "Production");
		         extent.setSystemInfo("User Name", "Arka Sinha");
		         
//		             Hybriser.getInstance().runImport(new baseStoreModel(false));
		         
//		         htmlReporter.config().setDocumentTitle("Hybris Functional Testing"); 
//		                // Name of the report
//		         htmlReporter.config().setReportName("Hybris Functional Testing Report "); 
//		                // Dark Theme
//		         htmlReporter.config().setTheme(Theme.DARK);
				
				
				Statu = null;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}     
	  }
	@BeforeMethod
	public void Setup()
  {
	   //log.info("Before Test");
		try {
			
			WOLBrowser = BrowserList.Browser("QI");
			WOLBrowser.NavigateTo(EnvUtil.getProperty("Browser"),EnvUtil.getProperty("WEL_STOREFRONT_URL_UAT"));	
			BrowserDetails= EnvUtil.getProperty("Browser");
			driver = CommonUtil.getDriver();
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			driver.manage().window().maximize();
//			report = new ExtentReports(System.getProperty("user.dir")+"\\ExtentReportResults.html");
			
			
			Statu = null;
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
//				report.endTest(test);
//		
//				report.flush();

				Statu = null;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				if(WOLBrowser != null){
					WOLBrowser.Quit();
					WOLBrowser = null;
					Statu = null;
				}
			}
	    }

// Personal User Customer Creation in LIT

@AfterSuite
public void TearDownreport(){
	try {
		
		

		extent.flush();
		//Hybriser.getInstance().runImport(new baseStoreModel(true));
		Statu = null;
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally{
		if(WOLBrowser != null){
			WOLBrowser.Quit();
			WOLBrowser = null;
			Statu = null;
		}
	}
}



@DataProvider(name="welstore1")
	public Object[][] welstore1() {
	Object[][] arrayObject = ReadExcelDataProvider.getExcelData(VariableController.welstoredata,VariableController.WEL,"T0001_TC" + 
			"");
	
			return arrayObject;
		}

@Test(dataProvider="welstore1")
	public void welstore1(String No,
		   String Active,
		   String Scenario,
		   String TestCase,
		   String Description,
		   String Username,
		   String Password,
		   String Course
		  
		  ) {
    String msg;
    
    try{
    	test = extent.createTest(Description);
    	JavascriptExecutor je = (JavascriptExecutor) driver;
    	setTestCaseName(No , Description, Scenario);
    	 
    	assertTrue(WEL_Page.clickOnLinkSync("Login",test), "Users Link click is unsuccessful");
    	
    	assertTrue(LoginPage.LoginWEL(Username, Password,test),"WEL Login Unsuccessful");
    	
    	
    	

    	

    	
    	
    	Statu = "Pass";
    	msg="Login to WEL checks completed successfull";
    	test.log(Status.PASS, MarkupHelper.createLabel(msg, ExtentColor.GREEN));
    	    	
    	
    }catch(Exception e){
    	msg="Failed step";
    	CommonUtil.report(msg,fail);
    	 CommonUtil.refresh(EnvUtil.getProperty("WEL_STOREFRONT_URL_UAT"));
		 Statu = "Fail";
		 test.log(Status.FAIL, MarkupHelper.createLabel(msg, ExtentColor.RED));
		 
    }
    finally{
    	if(Statu == null) {
    		Statu = "Fail";
    		 test.log(Status.FAIL, MarkupHelper.createLabel("Login Failed", ExtentColor.RED));
    		
    	}
    	ReportUtil.generateHTMLReport(Statu);
    }
}



@DataProvider(name="welstore2")
	public Object[][] welstore2() {
	Object[][] arrayObject = ReadExcelDataProvider.getExcelData(VariableController.welstoredata,VariableController.WEL,"T0002_TC" + 
			"");
	
			return arrayObject;
		}

@Test(dataProvider="welstore2")
	public void welstore2(String No,
		   String Active,
		   String Scenario,
		   String TestCase,
		   String Description,
		   String Username,
		   String Password,
		   String Course
		  
		  ) {
    String msg;
    
    try{
    	test = extent.createTest(Description);
    	JavascriptExecutor je = (JavascriptExecutor) driver;
    	setTestCaseName(No , Description, Scenario);
    	CommonUtil.refresh(EnvUtil.getProperty("HAC_UAT_URL"));
    	
    	assertTrue(LoginPage.LoginHAC(Username, Password,test),"HAC Login Unsuccessful");
    	assertTrue(WEL_Page.disableCaptcha(test), "Captcha disable failed");
    	
    	CommonUtil.refresh(EnvUtil.getProperty("WEL_STOREFRONT_URL_UAT"));
    	assertTrue(WEL_Page.clickOnLinkSync("Login",test), "Users Link click is unsuccessful");
    	assertNotNull(value = WEL_Page.createCustomer(test), "Customer is not created");
    	
    	CommonUtil.driver.manage().deleteAllCookies();
    	CommonUtil.refresh(EnvUtil.getProperty("HAC_UAT_URL"));
    	
    	assertTrue(LoginPage.LoginHAC(Username, Password,test),"HAC Login Unsuccessful");
    	assertTrue(WEL_Page.enableCaptcha(test), "Captcha disable failed");

    	Statu = "Pass";
    	msg="Customer has been created successfull";
    	test.log(Status.PASS, MarkupHelper.createLabel(msg, ExtentColor.GREEN));
	
    }catch(Exception e){
    	msg="Failed step";
    	CommonUtil.report(msg,fail);
    	 CommonUtil.refresh(EnvUtil.getProperty("WEL_STOREFRONT_URL_UAT"));
		 Statu = "Fail";
		 test.log(Status.FAIL, MarkupHelper.createLabel(msg, ExtentColor.RED));
		 
    }
    finally{
    	if(Statu == null) {
    		Statu = "Fail";
    		 test.log(Status.FAIL, MarkupHelper.createLabel("Customer Creation Failed", ExtentColor.RED));
    		
    	}
    	ReportUtil.generateHTMLReport(Statu);
    }
}



@DataProvider(name="welstore3")
	public Object[][] welstore3() {
	Object[][] arrayObject = ReadExcelDataProvider.getExcelData(VariableController.welstoredata,VariableController.WEL,"T0003_TC" + 
			"");
	
			return arrayObject;
		}

@Test(dataProvider="welstore3")
	public void welstore3(String No,
		   String Active,
		   String Scenario,
		   String TestCase,
		   String Description,
		   String Username,
		   String Password,
		   String Course
		  
		  ) {
    String msg;
    
    try{
    	test = extent.createTest(Description);
    	JavascriptExecutor je = (JavascriptExecutor) driver;
    	setTestCaseName(No , Description, Scenario);
    	
    	
    	CommonUtil.refresh(EnvUtil.getProperty("WEL_STOREFRONT_URL_UAT_CPA_PLAT"));

    	assertTrue(WEL_Page.checkaddtocart(Course, test), "Users Link click is unsuccessful");
    	

    	Statu = "Pass";
    	msg="Login to WEL checks completed successfull";
    	test.log(Status.PASS, MarkupHelper.createLabel(msg, ExtentColor.GREEN));
    	    	
    	
    }catch(Exception e){
    	msg="Failed step";
    	CommonUtil.report(msg,fail);
    	 CommonUtil.refresh(EnvUtil.getProperty("WEL_STOREFRONT_URL_UAT"));
		 Statu = "Fail";
		 test.log(Status.FAIL, MarkupHelper.createLabel(msg, ExtentColor.RED));
		 
    }
    finally{
    	if(Statu == null) {
    		Statu = "Fail";
    		 test.log(Status.FAIL, MarkupHelper.createLabel("Login Failed", ExtentColor.RED));
    		
    	}
    	ReportUtil.generateHTMLReport(Statu);
    }
}

@DataProvider(name="welstore4")
public Object[][] welstore4() {
Object[][] arrayObject = ReadExcelDataProvider.getExcelData(VariableController.welstoredata,VariableController.WEL,"T0004_TC" + 
		"");

		return arrayObject;
	}

@Test(dataProvider="welstore4")
public void welstore4(String No,
	   String Active,
	   String Scenario,
	   String TestCase,
	   String Description,
	   String Username,
	   String Password,
	   String Course
	  
	  ) {
String msg;

try{
	test = extent.createTest(Description);
	JavascriptExecutor je = (JavascriptExecutor) driver;
	setTestCaseName(No , Description, Scenario);
	CommonUtil.refresh(EnvUtil.getProperty("HAC_UAT_URL"));
	assertTrue(LoginPage.LoginHAC(Username, Password,test),"HAC Login Unsuccessful");
	assertTrue(WEL_Page.disableCaptcha(test), "Captcha disable failed");
	
	CommonUtil.refresh(EnvUtil.getProperty("WEL_STOREFRONT_URL_UAT_CPA_PLAT"));

	assertTrue(WEL_Page.payment(Username, Password, test), "Users Link click is unsuccessful");
	

	CommonUtil.driver.manage().deleteAllCookies();
	CommonUtil.refresh(EnvUtil.getProperty("HAC_UAT_URL"));
	
	assertTrue(LoginPage.LoginHAC(Username, Password,test),"HAC Login Unsuccessful");
	assertTrue(WEL_Page.enableCaptcha(test), "Captcha enable failed");
	
	Statu = "Pass";
	msg="Login to WEL checks completed successfull";
	test.log(Status.PASS, MarkupHelper.createLabel(msg, ExtentColor.GREEN));
	    	
	
}catch(Exception e){
	msg="Failed step";
	CommonUtil.report(msg,fail);
	 CommonUtil.refresh(EnvUtil.getProperty("WEL_STOREFRONT_URL_UAT"));
	 Statu = "Fail";
	 test.log(Status.FAIL, MarkupHelper.createLabel(msg, ExtentColor.RED));
	 
}
finally{
	if(Statu == null) {
		Statu = "Fail";
		 test.log(Status.FAIL, MarkupHelper.createLabel("Login Failed", ExtentColor.RED));
		
	}
	ReportUtil.generateHTMLReport(Statu);
}
}


@DataProvider(name="welstore5")
public Object[][] welstore5() {
Object[][] arrayObject = ReadExcelDataProvider.getExcelData(VariableController.welstoredata,VariableController.WEL,"T0005_TC" + 
		"");

		return arrayObject;
	}

@Test(dataProvider="welstore5")
public void welstore5(String No,
	   String Active,
	   String Scenario,
	   String TestCase,
	   String Description,
	   String Username,
	   String Password,
	   String Course
	  
	  ) {
String msg;

try{
	test = extent.createTest(Description);
	JavascriptExecutor je = (JavascriptExecutor) driver;
	setTestCaseName(No , Description, Scenario);
	CommonUtil.refresh(EnvUtil.getProperty("HAC_UAT_URL"));
	assertTrue(LoginPage.LoginHAC(Username, Password,test),"HAC Login Unsuccessful");
	assertTrue(WEL_Page.disableCaptcha(test), "Captcha disable failed");
	
	CommonUtil.refresh(EnvUtil.getProperty("WEL_STOREFRONT_URL_UAT_CPA_PLAT"));

	assertTrue(WEL_Page.studentDiscountpayment(Username, Password, test), "Users Link click is unsuccessful");
	

		
	CommonUtil.refresh(EnvUtil.getProperty("HAC_UAT_URL"));
	CommonUtil.driver.manage().deleteAllCookies();
	CommonUtil.refresh(EnvUtil.getProperty("HAC_UAT_URL"));
	
	assertTrue(LoginPage.LoginHAC(Username, Password,test),"HAC Login Unsuccessful");
	assertTrue(WEL_Page.enableCaptcha(test), "Captcha enable failed");

	

	Statu = "Pass";
	msg="Login to WEL checks completed successfull";
	test.log(Status.PASS, MarkupHelper.createLabel(msg, ExtentColor.GREEN));
	    	
	
}catch(Exception e){
	msg="Failed step";
	CommonUtil.report(msg,fail);
	 CommonUtil.refresh(EnvUtil.getProperty("WEL_STOREFRONT_URL_UAT"));
	 Statu = "Fail";
	 test.log(Status.FAIL, MarkupHelper.createLabel(msg, ExtentColor.RED));
	 
}
finally{
	if(Statu == null) {
		Statu = "Fail";
		 test.log(Status.FAIL, MarkupHelper.createLabel("Login Failed", ExtentColor.RED));
		
	}
	ReportUtil.generateHTMLReport(Statu);
}
}


@DataProvider(name="welstore6")
public Object[][] welstore6() {
Object[][] arrayObject = ReadExcelDataProvider.getExcelData(VariableController.welstoredata,VariableController.WEL,"T0006_TC" + 
		"");

		return arrayObject;
	}

@Test(dataProvider="welstore6")
public void welstore6(String No,
	   String Active,
	   String Scenario,
	   String TestCase,
	   String Description,
	   String Username,
	   String Password,
	   String Course
	  
	  ) {
String msg;

try{
	test = extent.createTest(Description);
	JavascriptExecutor je = (JavascriptExecutor) driver;
	setTestCaseName(No , Description, Scenario);
	CommonUtil.refresh(EnvUtil.getProperty("HAC_UAT_URL"));
	assertTrue(LoginPage.LoginHAC(Username, Password,test),"HAC Login Unsuccessful");
	assertTrue(WEL_Page.disableCaptcha(test), "Captcha disable failed");
	
	CommonUtil.refresh(EnvUtil.getProperty("WEL_STOREFRONT_URL_UAT_CPA_PLAT"));

	assertTrue(WEL_Page.studentDiscountpayment(Username, Password, test), "Users Link click is unsuccessful");
	

		
	CommonUtil.refresh(EnvUtil.getProperty("HAC_UAT_URL"));
	CommonUtil.driver.manage().deleteAllCookies();
	CommonUtil.refresh(EnvUtil.getProperty("HAC_UAT_URL"));
	
	assertTrue(LoginPage.LoginHAC(Username, Password,test),"HAC Login Unsuccessful");
	assertTrue(WEL_Page.enableCaptcha(test), "Captcha enable failed");

	

	Statu = "Pass";
	msg="Login to WEL checks completed successfull";
	test.log(Status.PASS, MarkupHelper.createLabel(msg, ExtentColor.GREEN));
	    	
	
}catch(Exception e){
	msg="Failed step";
	CommonUtil.report(msg,fail);
	 CommonUtil.refresh(EnvUtil.getProperty("WEL_STOREFRONT_URL_UAT"));
	 Statu = "Fail";
	 test.log(Status.FAIL, MarkupHelper.createLabel(msg, ExtentColor.RED));
	 
}
finally{
	if(Statu == null) {
		Statu = "Fail";
		 test.log(Status.FAIL, MarkupHelper.createLabel("Login Failed", ExtentColor.RED));
		
	}
	ReportUtil.generateHTMLReport(Statu);
}
}





}
