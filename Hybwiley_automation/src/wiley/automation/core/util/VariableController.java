package wiley.automation.core.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import wiley.automation.core.report.ReportUtil;

public class VariableController{
	
	static{
	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm");
	    System.setProperty("current.date", dateFormat.format(new Date()));
	}
		//static Logger log = Logger.getLogger(VariableController.class);	
		
		public static String TestCaseName;
		public static String TestCaseScenario;
		public static int timetowait = 2000;
		public String MAX_WAIT_TIME_PAGE_LOAD_IN_MS = "180000";
		public int MAX_WAIT_TIME_PAGE_LOAD_IN_SEC = 120;
		public int MAX_WAIT_TIME_IN_SEC = 10;
		public static Date StartTime;
//		public static String dataSheet = "C:\\Users\\341023\\workspace\\QiReEngg\\tests\\QiReEngData.xls";
		public static String dataSheet = System.getProperty("user.dir")+"\\tests\\WolData.xls";

		public static String Search = "Search";
		public static String Alm = "ALM";
		public static String May_2_12_0 = "2.12.0_May";
		public static String pass = "Pass";
		public static String fail = "Fail";
		public static String matched = "Condition Satisfiled";
		public static String notmatched = "Condition Not Satisfiled";
		public static String SMUP = "SentenceMarkup";
		public static boolean smuLoadSVG = false;
		public static boolean smuLabelasButton = false;
		public static boolean itemSuppressChkbox = false;
		public static boolean smuLabelasButtonCreate = false;
		public static boolean smuLabelasButtonUpdate = false;
		public static boolean overlay1 = false;
		// Singe Card Item
		public static int noofscores,noofsecs;
		public static boolean scicond = false;
		public static String promptHTML;
		public static String sciscore1,scilable1,sciscore2,scilable2,sciscore3,scilable3,sciscore4,scilable4;
		public static String obLabel,osHeader,ossection1,ossection2; 
				
		public static int itemCount = 0;
		
		public static String getTestCaseName() {
			return TestCaseName;
		}
		
		public static String getTestScenario() {
			return TestCaseScenario;
		}
		
		public static void setTestCaseName(String testCaseName,String testCaseScenario) {
			TestCaseName = testCaseName;
			TestCaseScenario = testCaseScenario;
			StartTime =  new java.util.Date();
			ReportUtil.createDirectory();
			ReportUtil.copyFiles();
			highlevelReport(StartTime);
		}

		
		public static void highlevelReport(Date startTime) {
			try{
				ReportUtil.tcases.add(getTestCaseName());
				ReportUtil.tcasesscenario.add(getTestScenario());
				ReportUtil.tcasesstarttime.add(startTime);
			}catch(Exception e){e.printStackTrace();}
		}
		
	
}
