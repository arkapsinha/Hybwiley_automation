/*package wiley.automation.wol.impl;


import wiley.automation.core.util.CommonUtil;
import wiley.automation.core.util.ObjectLocator;

public class HomePageImpl extends ObjectLocator {

 //Logger log = Logger.getLogger(HomePageImpl.class);
 String msg;

public void goToLink(String string) {
	// TODO Auto-generated method stub//
	switch (string){
		case "Publication":
			CommonUtil.click(publicationLink);
			CommonUtil.waitForpageToLoad();
			break;
	}
	
}

public boolean verifyReferenceWork() {
	// TODO Auto-generated method stub
	if(CommonUtil.isElementPresent(journalFiltera2zList) && CommonUtil.isElementPresent(booksFiltera2zList) &&
			CommonUtil.isElementPresent(referenceWorksFiltera2zList) && CommonUtil.isElementPresent(bookSeriesFiltera2zList) &&
			CommonUtil.isElementPresent(databaseFiltera2zList) && CommonUtil.isElementPresent(labprotocolFiltera2zList) &&
			 !CommonUtil.isElementPresent(reomvoea2zFilter)){
		msg = "Filter link present";	
		//log.info(msg);
		CommonUtil.report(msg,pass);
		if(CommonUtil.getText(referenceWorksFiltera2zList).trim().contains("Reference Works")){
			CommonUtil.clicksync(referenceWorksFiltera2zList);
			msg = "Reference Works link present";	
			//log.info(msg);
			CommonUtil.report(msg,pass);
			if(CommonUtil.isElementPresent(reomvoea2zFilter)){
				CommonUtil.clicksync(reomvoea2zFilter);
				msg = "Remove filter link present";	
				//log.info(msg);
				CommonUtil.report(msg,pass);
				return true;	
			}
		}
	}
	return false;
}

public boolean verifyReferenceWorkLinkNotPresent() {
	// TODO Auto-generated method stub
	if(!CommonUtil.isElementPresent(referenceWorksFiltera2zList) && CommonUtil.isElementPresent(refworkFilterListNoLink)){
		msg = "Reference Works link not present";	
		//log.info(msg);
		CommonUtil.report(msg,pass);
		return true;
	}
	return false;
}
 
	
} */