package wiley.automation.core.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class ObjectLocator extends ObjectRepository {
	
	//WEL LOGIN
    public static By WELuser= By.id(WELuserid);
    public static By WELpassword = By.id(WELpasswordid);
    public static By submitLIT_login= By.name(submitLIT_loginname);
    
    //HAC LOGIN
    public static By HACuser= By.name(HACuserxpath);
    public static By HACpassword = By.name(HACpasswordxpath);
   // public static By submitLIT_login= By.name(submitLIT_loginname);
    
    
    public static By impexcode= By.cssSelector(impexcode_xpath);
    
    public static By importclick=By.xpath(importclick_xpath);
    
    //WEl Create cusotmer
    public static By firstname= By.id(firstnameid);
    public static By lastname= By.id(lastnameid);
    public static By email= By.id(emailid);
    public static By confirmEmail= By.id(confirmEmailid);
    public static By password= By.id(passwordid);
    public static By confpassword= By.id(confpasswordid);
    
    
    //Add to cart
    public static By addprice=By.xpath(addpricexpath);
    public static By addtocart= By.xpath(addtocartxpath);
    public static By gridPrice= By.xpath(gridPricexpath);
    public static By continueButton=By.xpath(continueButtonxpath);
    public static By billingFirstName= By.id(billingFirstNameid);
    public static By billingLastname= By.id(billingLastnameid);
    public static By billingAddress1= By.id(billingAddress1id);
    public static By billingCity= By.id(billingCityid);
    public static By billingZipcode= By.id(billingZipcodeid);
    public static By billingPhone= By.id(billingPhoneid);
    public static By cardNumber=By.xpath(cardNumberXpath);
    public static By expiryMonth=By.xpath(expiryMonthxpath);
    public static By expiryYear=By.xpath(expiryYearxpath);
    public static By securityCode=By.xpath(securityCodeXpath);
    public static By continueorder=By.id(continueorderid);
    public static By placeOrder=By.id(placeOrderid);
    
    
    //Student Discount
    public static By clickNextButton=By.xpath(clickNextButtonid);
	
    
} 

