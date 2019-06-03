package wiley.automation.core.report;

import org.testng.annotations.AfterSuite;

public class TeardownReport {

	/**
	 * @param args
	 */
	 @AfterSuite
	 public void teardownReport() {
		 HighLevelReportUtil.highlevelgenerateHTMLReport();
		 Zip.zipfile();
		}

}
