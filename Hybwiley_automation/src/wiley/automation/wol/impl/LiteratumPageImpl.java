package wiley.automation.wol.impl;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import wiley.automation.core.util.CommonUtil;
import wiley.automation.core.util.ObjectLocator;

public class LiteratumPageImpl<IWebElement> extends ObjectLocator {
	
	 //static Logger log = Logger.getLogger(LiteratumPageImpl.class);
	 private static String msg;
	public static void homepage() {
		
		CommonUtil.clicksync(homepagemove);
		CommonUtil.sleep(2000);
		
	}
	
	public static boolean checkFeaturedImage(){
		
		CommonUtil.scrolldown(checkFeatured);
		if(CommonUtil.isAttribtuePresent(checkImagesrc, "src")){
			msg = "Image is present";	
			//log.info(msg);
			CommonUtil.report(msg,pass);
			return true;
			
		}else{
			msg = "Image is not present";	
			//log.info(msg);
			CommonUtil.report(msg,fail, "Present");
			return false;
		}
		
	}
	
	public static boolean checkFeaturedSection(){
		
		CommonUtil.scrolldown(checkFeatured);
		if(CommonUtil.isElementPresent(checkFeatured)){
			msg = "Featured Section is present";	
			//log.info(msg);
			CommonUtil.report(msg,pass);
			return true;
		}else{
			msg = "Featured Section is not present";	
			//log.info(msg);
			CommonUtil.report(msg,fail, "Present");
			return false;
		}
	}
	
public static boolean checkBrowseBySubject(){
		
	CommonUtil.scrolldown(browseBysubject);
		if(CommonUtil.isElementPresent(browseBysubject)){
			msg = "Browse by Subject Section is present";	
			//log.info(msg);
			CommonUtil.report(msg,pass);
			return true;
		}else{
			msg = "Browse By Subject Section is not present";	
			//log.info(msg);
			CommonUtil.report(msg,fail, "Present");
			return false;
		}
	}

public static boolean subjectList(){
	
	CommonUtil.scrolldown(browseBysubject);
	if(CommonUtil.isElementPresent(checksubjectlist)){
		msg = "Subject List is present";	
		//log.info(msg);
		CommonUtil.report(msg,pass);
		return true;
	}else{
		msg = "Subject List is not present";	
		//log.info(msg);
		CommonUtil.report(msg,fail, "Present");
		return false;
	}
}
public static boolean searchcheck(String dOI){
	
	CommonUtil.sendKeys(searchvalue, dOI);
	CommonUtil.click(searchsubmit);
	CommonUtil.waitForpageToLoad();
	CommonUtil.sleep(2000);

	if (searchResultVerify(dOI))
		return true;
	else
		return false;
		
}

public static boolean searchResultVerify(String string){

    boolean countValue= CommonUtil.verifycount(countthevalue);
    //log.info(countValue);
    if(CommonUtil.verifyTextPresent(checkthevalue, string) && countValue){
            msg = "Search functionality is working";        
            //log.info(msg);
            CommonUtil.report(msg,pass);
            return true;
    }else{
            msg = "Search functionality is not present";    
            //log.info(msg);
            CommonUtil.report(msg,fail, "Present");
            return false;
    }
}


	private void hitEnter() {
		// TODO Auto-generated method stub
		Actions builder = new Actions(CommonUtil.driver);
		builder.moveToElement(CommonUtil.driver.findElement(SearchTermField)).perform();
		//builder.keyDown(CommonUtil.driver.findElement(SearchTermField), Keys.ENTER).perform();
		//builder.keyUp(CommonUtil.driver.findElement(SearchTermField), Keys.ENTER).perform();
		builder.sendKeys(Keys.ENTER).perform();
	}

	public static boolean citationSearchResultPageVerify(String[] values) {
		// TODO Auto-generated method stub
		if(CommonUtil.isElementPresent(CitationSearchPageValues) && CommonUtil.isElementDisplay(CitationSearchPageValues)){
			if(CommonUtil.getText(CitationSearchPageValues).contains(values[1])
					&& CommonUtil.getText(CitationSearchPageValues).contains(values[2])
					&& CommonUtil.getText(CitationSearchPageValues).contains(values[3])){
				msg = "Volume, Issue, Year present";	
				//log.info(msg);
				CommonUtil.report(msg,pass);
				return true;
			}
			msg = "Volume, Issue, Year not present";	
			//log.info(msg);
			CommonUtil.report(msg,fail);
			return false;
		}
		msg = "Citation Search result page not opened properly";	
		//log.info(msg);
		CommonUtil.report(msg,fail);
		return false;
	}

	public static boolean ClickAndVerifySaveSearchForNotLogin() {
		if(CommonUtil.isElementPresent(SaveSearchOption)){
			CommonUtil.click(SaveSearchOption);
			msg = "Clicked on Saved Search option";	
			//log.info(msg);
			CommonUtil.report(msg,pass);
			if(CommonUtil.isElementDisplay(SaveSearchPopup)
					&& CommonUtil.isElementDisplay(SaveSearchLoginOption)){
				CommonUtil.clicksync(SaveSearchLoginOption);
				return true;
			}
			return false;
		}
		return false;
	}

	public static boolean alphabeticalFilterOperation(String selectAlphabetic) {
		String linkvalue = "//div[@id='alphaFace']/*[.='"+selectAlphabetic+"']";
		By link = By.xpath(linkvalue);
		if(CommonUtil.isElementPresent(link)){
			CommonUtil.clicksync(link);
			CommonUtil.sleep(2000);
			String appliedFacet="//div[@id='appliedFacet']//a[@title='"+selectAlphabetic.toLowerCase()+"']";
			By appliedfacet = By.xpath(appliedFacet);
			if(CommonUtil.isElementPresent(appliedfacet)){
				List<WebElement> element = CommonUtil.driver.findElements(searchItem);
				for(int i=1; i<=element.size(); i++){
					String Titlexpath = "//*[@class='rlist search-result__body titles-results']/li["+i+"]/*[@class='item__body']/h2/a";
					By Title = By.xpath(Titlexpath);
					if(!CommonUtil.getText(Title).startsWith(selectAlphabetic)){
						msg = "Alphabetical Facet not applied properly";	
						//log.info(msg);
						CommonUtil.report(msg,fail);
						return false;
					}
				}
				msg = "Alphabetical Facet applied properly";	
				//log.info(msg);
				CommonUtil.report(msg,pass);
				String appliedFacetRemove="//div[@id='appliedFacet']//a[@title='"+selectAlphabetic.toLowerCase()+"']/span";
				By appliedfacetremove = By.xpath(appliedFacetRemove);
				CommonUtil.clicksync(appliedfacetremove);
				msg = "Alphabetical Facet removed properly";	
				//log.info(msg);
				CommonUtil.report(msg,pass);
				return true;
			}
			return false;
		}
		return false;
	}

	public static boolean publicationFilterOperation(String selectAlphabetic) {
		String linkvalue = "//a[@title='"+selectAlphabetic+"']";
		By link = By.xpath(linkvalue);
		if(CommonUtil.isElementPresent(link)){
			CommonUtil.clicksync(link);
			CommonUtil.sleep(2000);
			String appliedFacet="//div[@id='appliedFacet']//a[@title='"+selectAlphabetic.toLowerCase()+"']";
			By appliedfacet = By.xpath(appliedFacet);
			if(CommonUtil.isElementPresent(appliedfacet)){
				List<WebElement> element = CommonUtil.driver.findElements(searchItem);
				for(int i=1; i<=element.size(); i++){
					String Titlexpath = "//*[@class='rlist search-result__body titles-results']/li["+i+"]/*[@class='item__body']/div/span";
					By Title = By.xpath(Titlexpath);
					if(!CommonUtil.getText(Title).startsWith(selectAlphabetic.toUpperCase())){
						msg = "publication Facet not applied properly";	
						//log.info(msg);
						CommonUtil.report(msg,fail);
						return false;
					}
				}
				msg = "publication Facet applied properly";	
				//log.info(msg);
				CommonUtil.report(msg,pass);
				String appliedFacetRemove="//div[@id='appliedFacet']//a[@title='"+selectAlphabetic.toLowerCase()+"']/span";
				By appliedfacetremove = By.xpath(appliedFacetRemove);
				CommonUtil.clicksync(appliedfacetremove);
				msg = "publication Facet removed properly";	
				//log.info(msg);
				CommonUtil.report(msg,pass);
				return true;
			}
			return false;
		}
		return false;
	
	
	}
}