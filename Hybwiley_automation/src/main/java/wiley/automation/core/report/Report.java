package wiley.automation.core.report;

public class Report {

	/**
	 * @param args
	 */
	 //static Logger log = Logger.getLogger(Report.class);
	 
	 
	//static String path = "C:\\Users\\341023\\workspace\\QiReEngg\\output\\";
	static String path = System.getProperty("user.dir")+"\\output\\";
	public static String getPath() {
		return path;
	}

	public static void setPath(String path) {
		Report.path = path;
	}

	

}
