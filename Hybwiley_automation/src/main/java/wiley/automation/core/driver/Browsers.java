package wiley.automation.core.driver;


public enum Browsers 
{
	IE,
	FIREFOX,
	CHROME,
	SAFARI,
	NEXUS,
	TOSHIBA,
	IPHONE_CHROME,
	IPHONE_FIREFOX,
	IPHONE_SAFARI,
	IPAD,
	OTHER,
	MOBILE,
	GOOGLEPIXCEL_CHROME,
	GOOGLEPIXCEL_FIREFOX,
	GOOGLEPIXCEL_SAFARI,
	IPHONEPLUS_CHROME,
	IPHONEPLUS_FIREFOX,
	IPHONEPLUS_SAFARI;
	
	//Get the Enum
	public static Browsers get(String s)
	{
		return Browsers.valueOf(s.trim().toUpperCase());
	}
	
}