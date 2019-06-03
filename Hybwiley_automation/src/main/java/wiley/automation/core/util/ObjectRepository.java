package wiley.automation.core.util;

import org.openqa.selenium.By;


public class ObjectRepository extends VariableController{


	public static String WELuserid="j_username";
	public static String WELpasswordid="j_password";
	//public static String submitLIT_loginname="submit";
	public static String submitLIT_loginname="submitButton";
	//submitButton
	
	public static String HACuserxpath="j_username";
	public static String HACpasswordxpath="j_password";
	
	public static String impexcode_xpath="div:nth-child(1) > textarea";
	public static String importclick_xpath="//body//p//input[1]";
	
	public static String firstnameid="register.firstName";
	public static String lastnameid="register.lastName";
	public static String emailid="register.email";
	public static String confirmEmailid="register.confirmEmail";
	public static String passwordid="password";
	public static String confpasswordid="register.checkPwd";
	
	public static String addtocartxpath="//div[contains(@class,'pdp-addtocart-div')]";
	public static String addpricexpath="//p[@id='product-price-0']";
	public static String gridPricexpath="(//div[@class='subscriptions-subtotal-value'])[3]";
	public static String continueButtonxpath="(//button[@class='btn btn-primary checkoutButton'])[2]";
	public static String billingFirstNameid="billingAddress.addressFirstName";
    public static String billingLastnameid="billingAddress.addressSurname";
    public static String billingAddress1id="billingAddress.addressLine1";
    public static String billingCityid="billingAddress.addressTownCity";
    public static String billingZipcodeid="billingAddress.addressPostcode";
    public static String billingPhoneid="billingAddress.addressPhone";
    public static String cardNumberXpath="//input";
    public static String expiryMonthxpath="//div[@id='expiry-month']//select[@id='expiry-month-select']";
    public static String expiryYearxpath="//div[@id='expiry-year']//select[@id='expiry-year-select']";
    //public static String securityCodeXpath="//div[@id='security-code']//iframe";
    public static String securityCodeXpath="//input";
    public static String continueorderid="saveBilling";
    public static String placeOrderid="placeOrderButtonId";
    
    
    public static String clickNextButtonid="//button[@class='button form-button']";
}










