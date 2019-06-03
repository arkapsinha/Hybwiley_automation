/*package wiley.automation.wol.impl;

import wiley.automation.core.util.CommonUtil;
import wiley.automation.core.util.ObjectLocator;

public class DeleteMethodImpl extends ObjectLocator{
	
	//static Logger log = Logger.getLogger(DeleteMethodImpl.class);
	private String msg;
	
	public void clickondeletebutton(){
		try {
		if(CommonUtil.isElementPresent(deletetrialLocator) && CommonUtil.getSize(deletetrialLocator) == 1 ){
			msg = "Click on Delete Button";	
	    	//log.info(msg);
	    	CommonUtil.report(msg,pass);
			CommonUtil.clicksync(deletetrialLocator);
			msg = "Click on Ok Button";	
	    	//log.info(msg);
	    	CommonUtil.report(msg,pass);
			CommonUtil.getDriver().switchTo().alert().accept();
		}else if(CommonUtil.isElementPresent(deleteitemLocator) && CommonUtil.getSize(deleteitemLocator) == 1  ) {
			msg = "Click on Delete Button";	
	    	//log.info(msg);
	    	CommonUtil.report(msg,pass);
			CommonUtil.clicksync(deleteitemLocator);
			msg = "Click on Ok Button";	
	    	//log.info(msg);
	    	CommonUtil.report(msg,pass);
			CommonUtil.getDriver().switchTo().alert().accept();
		}else if(CommonUtil.isElementPresent(deleteitemgrouplLocator) && CommonUtil.getSize(deleteitemgrouplLocator) == 1 ) {
			msg = "Click on Delete Button";	
	    	//log.info(msg);
	    	CommonUtil.report(msg,pass);
			CommonUtil.clicksync(deleteitemgrouplLocator);
			msg = "Click on Ok Button";	
	    	//log.info(msg);
	    	CommonUtil.report(msg,pass);
			CommonUtil.getDriver().switchTo().alert().accept();
		}else if(CommonUtil.isElementPresent(deletesubtestLocator)  && CommonUtil.getSize(deletesubtestLocator) == 1  ) {
			msg = "Click on Delete Button";	
	    	//log.info(msg);
	    	CommonUtil.report(msg,pass);
			CommonUtil.clicksync(deletesubtestLocator);
			msg = "Click on Ok Button";	
	    	//log.info(msg);
	    	CommonUtil.report(msg,pass);
			CommonUtil.getDriver().switchTo().alert().accept();
		}else if(CommonUtil.isElementPresent(deletetestLocator) && CommonUtil.getSize(deletetestLocator) == 1 ) {
			msg = "Click on Delete Button";	
	    	//log.info(msg);
	    	CommonUtil.report(msg,pass);
			CommonUtil.clicksync(deletetestLocator);
			msg = "Click on Ok Button";	
	    	//log.info(msg);
	    	CommonUtil.report(msg,pass);
			CommonUtil.getDriver().switchTo().alert().accept();
		} 	 	
		
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean overlay(){
		CommonUtil.pageLoadTimeout(MAX_WAIT_TIME_IN_SEC);
		if(CommonUtil.isElementPresent(overlayLocator)){
		  //log.info(CommonUtil.getText(overlayLocator));
		  CommonUtil.clicksync(overlaycloselocator);
		  msg = CommonUtil.getText(overlayLocator);	
		  //log.info(msg);
		  CommonUtil.report(msg,fail);
		  return false;
		}
		msg = "Delete Successfully";	
    	//log.info(msg);
    	CommonUtil.report(msg,pass);
		return true;
		
	}
	
}
*/