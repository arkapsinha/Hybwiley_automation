package wiley.automation.core.driver;

import java.util.Hashtable;

public class BrowserList {
	
	private static Hashtable<String, WebBrowser> browsers = new Hashtable<String, WebBrowser>();
	
    public static WebBrowser Browser(String name)
	{
		if(browsers.containsKey(name))
		{
			return (WebBrowser) browsers.get(name);
		}
		else
		{
			WebBrowser temp = new WebBrowser();
			browsers.put(name, temp);
			return temp;
		}
		
	}
    
    public static void QuitBrowser(String browser)
    {
    	browsers.get(browser).Quit();
    	browsers.remove("QG");
    }
}