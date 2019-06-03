/*package wiley.automation.wol.impl;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import wiley.automation.core.util.CommonUtil;
import wiley.automation.core.util.EnvUtil;
import wiley.automation.core.util.ObjectLocator;


public class SearchImpl extends ObjectLocator{
	
	//static Logger log = Logger.getLogger(SearchImpl.class);
	private String msg;
	private String emsg,emsgs,emsgss,emsgsss;
	private String lgth;
	private String error = "";
	WebDriver driver2;
	
	
	
	public boolean search(){
		if(CommonUtil.isElementPresent(searchText))
		{
			msg = "Verify Search Text Box Present";	
			////log.info(msg);
			CommonUtil.report(msg,pass);
			return CommonUtil.isElementDisplay(searchText);
		}
		msg = "Verify Search Text Box Present";	
		////log.fatal(msg);
		CommonUtil.report(msg,fail,"Search Text Box not Present");
		return false;
	}
	
	public void clickonviewpage(){

		if(CommonUtil.isElementPresent(view2140)){
			CommonUtil.clicksync(view2140);
			msg = "Verify 21-40 text box is present & clickable";	
			////log.info(msg);
			CommonUtil.report(msg,pass);
		}
		
		if(CommonUtil.isElementPresent(view4160)){
			CommonUtil.clicksync(view4160);
			msg = "Verify 41-60 text box is present & clickable";	
			////log.info(msg);
			CommonUtil.report(msg,pass);
		}
		
		
		if(CommonUtil.isElementPresent(view6180)){
			CommonUtil.clicksync(view6180);
			msg = "Verify 61-80 text box is present & clickable";	
			//log.info(msg);
			CommonUtil.report(msg,pass);
		}
		
		
		if(CommonUtil.isElementPresent(viewnext)){
			CommonUtil.clicksync(viewnext);
			msg = "Verify view-next text is present & clickable";	
			//log.info(msg);
			CommonUtil.report(msg,pass);
		}
		
		if(CommonUtil.isElementPresent(viewprev)){
			if(CommonUtil.getText(viewprev).contains("Prev")){
				CommonUtil.clicksync(viewprev);
				msg = "Verify view-prev text box is present & clickable";	
				//log.info(msg);
				CommonUtil.report(msg,pass);
			}
			
		}
	
		
	}
	
	
	public boolean checkResult(String content){
		int i = 0 ;
		i = Integer.parseInt(CommonUtil.getText(Contentvalue));
		
		if(CommonUtil.getText(Contenttype).equals(content) && i > 0){
			msg = "Verify Provided search Text and Result Count is present in Result Page";	
			//log.info(msg);
			CommonUtil.report(msg,pass);
			return true;
		}
		return false;
	}
	
	public boolean checkcontent(String type){
		if(CommonUtil.isElementPresent(noResult)){
			msg = "No Result Found";	
			//log.fatal(msg);
			CommonUtil.report(msg,fail);
			return false;
		}else if(checkResult(type)){
			msg = "Search Result found for the provided search term";	
			//log.info(msg);
			CommonUtil.report(msg,pass);
			return true;
		}
		
		return false;
		
	}
	
	public boolean searchResultPage(){
		if(CommonUtil.isElementPresent(searchResultPage))
		{
			msg = "Verify the page is search result page";	
			//log.info(msg);
			CommonUtil.report(msg,pass);
			return CommonUtil.isElementDisplay(searchResultPage);
		}
		return false;
	}
	
	public void clickonradiobutton(String button){
		if(CommonUtil.getAttributeValue(allcontent, "value)").contains(button)){
			CommonUtil.click(allcontent);
			msg = "Search for all contain type";	
			//log.info(msg);
			CommonUtil.report(msg,pass);
		}		
	}
	
	public void searchText(String search){
		//CommonUtil.sleep(10000);
		CommonUtil.click(searchText);
		CommonUtil.clear(searchText);
		CommonUtil.sendKeys(searchText, search);
		msg = "Enter the Search Text";	
		//log.info(msg);
		CommonUtil.report(msg,pass,search);
		
	}
	public void clcikonFilterList(){
		if(CommonUtil.isElementPresent(journalFilterList)){
			if(CommonUtil.isEnabled(journalFilterList)){
				CommonUtil.clicksync(journalFilterList);
				msg = "Verify click on Journal filter";	
				//log.info(msg);
				CommonUtil.report(msg,pass);
			}else{
				msg = "Journal filter is not present";	
				//log.info(msg);
				CommonUtil.report(msg,pass);
			}
		}
		
		if(CommonUtil.isElementPresent(booksFilterList)){
			if(CommonUtil.isEnabled(booksFilterList)){
				CommonUtil.clicksync(booksFilterList);
				msg = "Verify click on book filter";	
				//log.info(msg);
				CommonUtil.report(msg,pass);
			}else{
				msg = "Book filter is not present";	
				//log.info(msg);
				CommonUtil.report(msg,pass);
			}
		}
		
		if(CommonUtil.isElementPresent(referenceWorkFilterList)){
			if(CommonUtil.isEnabled(referenceWorkFilterList)){
				CommonUtil.clicksync(referenceWorkFilterList);
				msg = "Verify click on Reference Work filter";	
				//log.info(msg);
				CommonUtil.report(msg,pass);
			}else{
				msg = "Reference Work filter is not present";	
				//log.info(msg);
				CommonUtil.report(msg,pass);
			}
		}
		
		if(CommonUtil.isElementPresent(bookSeriesFilterList)){
			if(CommonUtil.isEnabled(bookSeriesFilterList)){
				CommonUtil.clicksync(bookSeriesFilterList);
				msg = "Verify click on book Series filter";	
				//log.info(msg);
				CommonUtil.report(msg,pass);
			}else{
				msg = "book Series is not present";	
				//log.info(msg);
				CommonUtil.report(msg,pass);
			}
		}
		
		
		if(CommonUtil.isElementPresent(databaseFilterList)){
			if(CommonUtil.isEnabled(databaseFilterList)){
				CommonUtil.clicksync(databaseFilterList);
				msg = "Verify click on Database filter";	
				//log.info(msg);
				CommonUtil.report(msg,pass);
			}else{
				msg = "Database filter is not present";	
				//log.info(msg);
				CommonUtil.report(msg,pass);
			}
		}
		
		
		if(CommonUtil.isElementPresent(labprotocolFilterList)){
			if(CommonUtil.isEnabled(labprotocolFilterList)){
				CommonUtil.clicksync(labprotocolFilterList);
				msg = "Verify click on labprotocal filter";	
				//log.info(msg);
				CommonUtil.report(msg,pass);
			}else{
				msg = "Lab Protocol filter is not present";	
				//log.info(msg);
				CommonUtil.report(msg,pass);
			}
		}
		
		if(CommonUtil.isElementPresent(reomvoeFilter)){
			CommonUtil.clicksync(reomvoeFilter);
			msg = "Verify click on Remove filter";	
			//log.info(msg);
			CommonUtil.report(msg,pass);
		}
	}
	
	public void clickonSearchButton(){
		CommonUtil.click(searchButton);
		msg = "Verify click on Search Button";	
		//log.info(msg);
		CommonUtil.report(msg,pass);
		CommonUtil.waitForpageToLoad();
	}
	
	
	
	public void clickOnAbstractLink(int i){
		int count = CommonUtil.getSize(By.xpath("//*[@id='searchResultsList']/ol/li"));
		for(int k = 1; k <= count; k++){
			By abstractkink = By.xpath("//*[@id='searchResultsList']/ol/li["+k+"]/div[2]/ul[1]/li[1]/a");
			if(CommonUtil.getText(abstractkink).equalsIgnoreCase("abstract")){
				CommonUtil.click(abstractkink);
				CommonUtil.waitForpageToLoad();
				break;
			}
		}
	}
	
	public void clickOnArticlePDFLink(int i){
		int count = CommonUtil.getSize(By.xpath("//*[@id='searchResultsList']/ol/li"));
		for(int k = 1; k <= count; k++){
			By articleLink = By.xpath("//*[@id='searchResultsList']/ol/li["+k+"]/div[2]/ul[1]/li[2]/a");
			if(CommonUtil.getText(articleLink).contains("Article") || CommonUtil.getText(articleLink).contains("PDF")){
				CommonUtil.click(articleLink);
				msg = "Verify click on Article / PDF link";	
				//log.info(msg);
				CommonUtil.report(msg,pass);
				CommonUtil.waitForpageToLoad();
				CommonUtil.sleep(5000);
				break;
			}
		}
	}
	
	
	
	
	
	
	
	
	
	//-------------------------------------------------------------------------
	
	
	
	public boolean singleCardItemCreateItem(){
		 CommonUtil.clicksync(createItem);
		 CommonUtil.sleep(5000);
		 if(CommonUtil.isElementPresent(createItem)){
			 // if Create Item Link is not Present then it will return false.
			msg = "Create Item Link is Present";	
			CommonUtil.report(msg,fail);
			 return false;
		 }
		 msg = "Create Item Link is not Present";	
		CommonUtil.report(msg,pass);
		 return true;
	}
	
	public void enterTitleAndUniqueQuestion(String title,String unique){
		if(CommonUtil.isElementPresent(titles)){
			CommonUtil.sendKeys(titles, title);
			msg = "Enter Title";	
			CommonUtil.report(msg,pass,title);
		}
		
		if(CommonUtil.isElementPresent(uniques)){
			CommonUtil.sendKeys(uniques, unique);
			msg = "Enter Unique Question";	
			CommonUtil.report(msg,pass,title);
		}
		
	}
	
	public boolean selectScoringMethod(String method){ 
		CommonUtil.selectdropdownvaluebyvisibletext(scoringmethodropdown, method);
		if(CommonUtil.isElementPresent(section)){
			msg = "Select from Drop Down";	
			CommonUtil.report(msg,pass,method);
			return true;
		} 
		return false;
	}
	
	public boolean clsaveAndPreview(){

		  try {
		CommonUtil.clicksync(itemSavePreview);
		msg = "Click on Save and Preview Button";	
		//log.info(msg);
		CommonUtil.report(msg,pass);
		
		String currentWindoTitle = CommonUtil.getTitle();
		CommonUtil.sleep(6000);
		
		//Switch to newly opened window -Order Status and get the page title
				for(String winHandle : CommonUtil.getDriver().getWindowHandles()){
						CommonUtil.getDriver().switchTo().window(winHandle);		
					}
				
		for(int j=0;j<8;j++){
			if(CommonUtil.getDriver().getTitle().contains("Content")){
				CommonUtil.getDriver().manage().window().maximize();
				break;
			}else{
				CommonUtil.sleep(30000);
			}
		}
		
		for(int j=0;j<3;j++){
			if(CommonUtil.getDriver().findElement(By.xpath("//*[@class='question-content with-sidepanel']/table/tr[2]/td[2]/div/div[1]")).getText().equalsIgnoreCase("1.")){
				 //log.info(CommonUtil.getDriver().getTitle()); 	
				    msg = "Save and Preview Page Loaded Successfully";	
					//log.info(msg);
					CommonUtil.report(msg,pass);
				 break;
			}else{
				CommonUtil.sleep(60000);
			}
			}
				 if(CommonUtil.getDriver().findElement(promptHTMLtext).getText().equalsIgnoreCase(promptHTML)){
					 //log.info(CommonUtil.getDriver().findElement(promptHTMLtext).getText());
					  	
					msg = "Verified Prompt HTML";
					//log.info(msg);
					CommonUtil.report(msg,pass,promptHTML);
					
					if(CommonUtil.isElementPresent(By.className("scoring-guide-button"))){
						System.out.println(CommonUtil.getDriver().findElement(By.className("scoring-guide-button")).getLocation());
						System.out.println(CommonUtil.getDriver().findElement(By.className("scoring-guide-button")).getTagName());
						
						WebElement element = CommonUtil.getDriver().findElement(By.className("scoring-guide-button"));
						Actions action = new Actions(CommonUtil.getDriver());
						action.moveToElement(element).click().build().perform();
						
						if(noofsecs == 1){
							if(CommonUtil.getDriver().findElement(By.xpath("//*[@class='scoring-guide']/div[1]/div[3]/div/p")).getText().equalsIgnoreCase(ossection1)){
								msg = "Verified First Section";	
								//log.info(msg);
							}
						}else if(noofsecs > 1){
							if(CommonUtil.getDriver().findElement(By.xpath("//*[@class='scoring-guide']/div[1]/div[3]/div/p")).getText().equalsIgnoreCase(ossection1)){
								msg = "Verified First Section";	
								//log.info(msg);
							}
							
							if(CommonUtil.getDriver().findElement(By.xpath("//*[@class='scoring-guide']/div[2]/div[3]/div/p")).getText().equalsIgnoreCase(ossection2)){
								msg = "Verified Second Section";	
								//log.info(msg);
							}
							
						}	
						
					}
					
				 }
				 
				 
				 
				//log.info(CommonUtil.getDriver().findElement(promptHTMLtext).getText());
				CommonUtil.getDriver().close();
				
				//Switch to newly opened window -Order Status and get the page title
				for(String winHandle : CommonUtil.getDriver().getWindowHandles()){
						CommonUtil.getDriver().switchTo().window(winHandle);		
					}
		
				 //log.info(CommonUtil.getDriver().getTitle());
				 return true;
		
		  } catch (Exception e) {
				// TODO Auto-generated catch block
			    msg = "Verify Save and Preview Page ";	
				//log.fatal(msg);
				CommonUtil.report(msg,fail,e.getMessage());
				e.printStackTrace();
				return false;
			}
	
	}
	
	public boolean saveAndPreview(){
		  try {
		CommonUtil.clicksync(itemSavePreview);
		msg = "Click on Save and Preview Button";	
		//log.info(msg);
		CommonUtil.report(msg,pass);
		CommonUtil.sleep(30000);
		String currentWindoTitle = CommonUtil.getTitle();
		CommonUtil.sleep(30000);

		
		//Switch to newly opened window -Order Status and get the page title
				for(String winHandle : CommonUtil.getDriver().getWindowHandles()){
						CommonUtil.getDriver().switchTo().window(winHandle);		
					}
				
		for(int j=0;j<8;j++){
			if(CommonUtil.getDriver().getTitle().contains("Content")){
				CommonUtil.getDriver().manage().window().maximize();
				break;
			}else{
				CommonUtil.sleep(30000);
			}
		}
		
		for(int j=0;j<3;j++){
			if(CommonUtil.getDriver().findElement(By.xpath("//*[@class='question-content with-sidepanel']/table/tr[2]/td[2]/div/div[1]")).getText().equalsIgnoreCase("1.")){
				 //log.info(CommonUtil.getDriver().getTitle()); 	
				    msg = "Save and Preview Page Loaded Successfully";	
					//log.info(msg);
					CommonUtil.report(msg,pass);
				 break;
			}else{
				CommonUtil.sleep(60000);
			}
			}
				 if(CommonUtil.getDriver().findElement(promptHTMLtext).getText().equalsIgnoreCase(promptHTML)){
					 //log.info(CommonUtil.getDriver().findElement(promptHTMLtext).getText());
					  	
					msg = "Verified Prompt HTML";
					//log.info(msg);
					CommonUtil.report(msg,pass,promptHTML);
					 if(scicond){
						 if(noofscores == 2){
							 
							 if(CommonUtil.getDriver().findElement(By.xpath(uniqueSCI+"/table/tbody/tr/td[1]")).getText().equalsIgnoreCase(EnvUtil.getProperty(CommonUtil.firstMaxvalue(sciscore1,sciscore2,sciscore3,sciscore4)))){
								 
								 	msg = "Verified Button Value";	
									//log.info(msg);
									CommonUtil.report(msg,pass,EnvUtil.getProperty(CommonUtil.firstMaxvalue(sciscore1,sciscore2,sciscore3,sciscore4)));
							 }
							 
							 if(CommonUtil.getDriver().findElement(By.xpath(uniqueSCI+"/table/tbody/tr/td[2]")).getText().equalsIgnoreCase(EnvUtil.getProperty(CommonUtil.secondMaxvalue(sciscore1,sciscore2,sciscore3,sciscore4)))){
								 
								 	msg = "Verified Button Value";	
									//log.info(msg);
									CommonUtil.report(msg,pass,EnvUtil.getProperty(CommonUtil.secondMaxvalue(sciscore1,sciscore2,sciscore3,sciscore4)));
							 }
							 
						 }else if(noofscores == 3){
							
								 
								 if(CommonUtil.getDriver().findElement(By.xpath(uniqueSCI+"/table/tbody/tr/td[1]")).getText().equalsIgnoreCase(EnvUtil.getProperty(CommonUtil.firstMaxvalue(sciscore1,sciscore2,sciscore3,sciscore4)))){
									 
									 	msg = "Verified Button Value";	
										//log.info(msg);
										CommonUtil.report(msg,pass,EnvUtil.getProperty(CommonUtil.firstMaxvalue(sciscore1,sciscore2,sciscore3,sciscore4)));
								 }
								 
								  if(CommonUtil.getDriver().findElement(By.xpath(uniqueSCI+"/table/tbody/tr/td[2]")).getText().equalsIgnoreCase(EnvUtil.getProperty(CommonUtil.secondMaxvalue(sciscore1,sciscore2,sciscore3,sciscore4)))){
									 
									    msg = "Verified Button Value";	
										//log.info(msg);
										CommonUtil.report(msg,pass,EnvUtil.getProperty(CommonUtil.secondMaxvalue(sciscore1,sciscore2,sciscore3,sciscore4)));
								 }
								 
								  if(CommonUtil.getDriver().findElement(By.xpath(uniqueSCI+"/table/tbody/tr/td[3]")).getText().equalsIgnoreCase(EnvUtil.getProperty(CommonUtil.thirdMaxvalue(sciscore1,sciscore2,sciscore3,sciscore4)))){
									 
									    msg = "Verified Button Value";	
										//log.info(msg);
										CommonUtil.report(msg,pass,EnvUtil.getProperty(CommonUtil.thirdMaxvalue(sciscore1,sciscore2,sciscore3,sciscore4)));
								 }
								  
						 }else if(noofscores == 4){
							
							 // Contain "0" or Not
							 if(CommonUtil.containvalue(sciscore1,sciscore2,sciscore3,sciscore4, "0")){
								 
								 if(CommonUtil.getDriver().findElement(By.xpath(uniqueSCI+"/div/ul/li[1]/button")).getText().equalsIgnoreCase(EnvUtil.getProperty(CommonUtil.firstMaxvalue(sciscore1,sciscore2,sciscore3,sciscore4)))){
									 
										msg = "Verified Button Value";	
										//log.info(msg);
										CommonUtil.report(msg,pass,EnvUtil.getProperty(CommonUtil.firstMaxvalue(sciscore1,sciscore2,sciscore3,sciscore4)));
								 }
								 
								  if(CommonUtil.getDriver().findElement(By.xpath(uniqueSCI+"/div/ul/li[2]/button")).getText().equalsIgnoreCase(EnvUtil.getProperty(CommonUtil.secondMaxvalue(sciscore1,sciscore2,sciscore3,sciscore4)))){
									 
									    msg = "Verified Button Value";	
										//log.info(msg);
										CommonUtil.report(msg,pass,EnvUtil.getProperty(CommonUtil.secondMaxvalue(sciscore1,sciscore2,sciscore3,sciscore4)));
								 }
								 
								  if(CommonUtil.getDriver().findElement(By.xpath(uniqueSCI+"/div/ul/li[3]/button")).getText().equalsIgnoreCase(EnvUtil.getProperty(CommonUtil.thirdMaxvalue(sciscore1,sciscore2,sciscore3,sciscore4)))){
									 
									    msg = "Verified Button Value";	
										//log.info(msg);
										CommonUtil.report(msg,pass,EnvUtil.getProperty(CommonUtil.thirdMaxvalue(sciscore1,sciscore2,sciscore3,sciscore4)));
								 }
								  
								  if(CommonUtil.getDriver().findElement(By.xpath(uniqueSCI+"/div/div/button")).getText().equalsIgnoreCase(EnvUtil.getProperty(CommonUtil.fourthtMaxvalue(sciscore1,sciscore2,sciscore3,sciscore4)))){
										 
									   msg = "Verified Button Value";	
										//log.info(msg);
										CommonUtil.report(msg,pass,EnvUtil.getProperty(CommonUtil.fourthtMaxvalue(sciscore1,sciscore2,sciscore3,sciscore4)));
									 }
								  
							 }else{
								 
								 if(CommonUtil.getDriver().findElement(By.xpath(uniqueSCI+"/div/ul/li[1]/button")).getText().equalsIgnoreCase(EnvUtil.getProperty(CommonUtil.firstMaxvalue(sciscore1,sciscore2,sciscore3,sciscore4)))){
									 
										msg = "Verified Button Value";	
										//log.info(msg);
										CommonUtil.report(msg,pass,EnvUtil.getProperty(CommonUtil.firstMaxvalue(sciscore1,sciscore2,sciscore3,sciscore4)));
								 }
								 
								  if(CommonUtil.getDriver().findElement(By.xpath(uniqueSCI+"/div/ul/li[2]/button")).getText().equalsIgnoreCase(EnvUtil.getProperty(CommonUtil.secondMaxvalue(sciscore1,sciscore2,sciscore3,sciscore4)))){
									 
									    msg = "Verified Button Value";	
										//log.info(msg);
										CommonUtil.report(msg,pass,EnvUtil.getProperty(CommonUtil.secondMaxvalue(sciscore1,sciscore2,sciscore3,sciscore4)));
								 }
								 
								  if(CommonUtil.getDriver().findElement(By.xpath(uniqueSCI+"/div/ul/li[3]/button")).getText().equalsIgnoreCase(EnvUtil.getProperty(CommonUtil.thirdMaxvalue(sciscore1,sciscore2,sciscore3,sciscore4)))){
									 
									   msg = "Verified Button Value";	
										//log.info(msg);
										CommonUtil.report(msg,pass,EnvUtil.getProperty(CommonUtil.thirdMaxvalue(sciscore1,sciscore2,sciscore3,sciscore4)));
								 }
							
								  if(CommonUtil.getDriver().findElement(By.xpath(uniqueSCI+"/div/ul/li[4]/button")).getText().equalsIgnoreCase(EnvUtil.getProperty(CommonUtil.fourthtMaxvalue(sciscore1,sciscore2,sciscore3,sciscore4)))){
										 
									    msg = "Verified Button Value";	
										//log.info(msg);
										CommonUtil.report(msg,pass,EnvUtil.getProperty(CommonUtil.fourthtMaxvalue(sciscore1,sciscore2,sciscore3,sciscore4)));
									 }
								 
							 }
							 
						 }
						 
					 }else{
						 // Not True 
						 if(noofscores == 2){
							 	if(scilable1.trim().length() > 0){
							 		 if(CommonUtil.getDriver().findElement(By.xpath(uniqueSCI+"/table/tbody/tr[2]/td[1]")).getText().equalsIgnoreCase(EnvUtil.getProperty(CommonUtil.firstMaxvalue(sciscore1,sciscore2,sciscore3,sciscore4))) && (CommonUtil.getDriver().findElement(By.xpath(uniqueSCI+"/table/tbody/tr[1]/td[1]")).getText().contains(CommonUtil.firstMaxvalue(sciscore1,sciscore2,sciscore3,sciscore4)))){
										 
										    msg = "Verified Button and Label Value";	
											//log.info(msg);
											CommonUtil.report(msg,pass,EnvUtil.getProperty(CommonUtil.firstMaxvalue(sciscore1,sciscore2,sciscore3,sciscore4))+" and "+CommonUtil.firstMaxvalue(sciscore1,sciscore2,sciscore3,sciscore4)+" Points");
										 
									 }
							 	}else{
							 		if((CommonUtil.getDriver().findElement(By.xpath(uniqueSCI+"/table/tbody/tr[1]/td[1]")).getText().contains(CommonUtil.firstMaxvalue(sciscore1,sciscore2,sciscore3,sciscore4)))){
										 
									    msg = "Verified Button Value";	
										//log.info(msg);
										CommonUtil.report(msg,pass,CommonUtil.firstMaxvalue(sciscore1,sciscore2,sciscore3,sciscore4)+" Points");
									 
								 }
							 	}
							 
							 
							 	if(scilable2.trim().length() > 0){
							 		 if(CommonUtil.getDriver().findElement(By.xpath(uniqueSCI+"/table/tbody/tr[2]/td[2]")).getText().equalsIgnoreCase(EnvUtil.getProperty(CommonUtil.secondMaxvalue(sciscore1,sciscore2,sciscore3,sciscore4))) && (CommonUtil.getDriver().findElement(By.xpath(uniqueSCI+"/table/tbody/tr[1]/td[2]")).getText().contains(CommonUtil.secondMaxvalue(sciscore1,sciscore2,sciscore3,sciscore4)))){
										 
										    msg = "Verified Button and Label Value";	
											//log.info(msg);
											CommonUtil.report(msg,pass,EnvUtil.getProperty(CommonUtil.secondMaxvalue(sciscore1,sciscore2,sciscore3,sciscore4))+" and "+CommonUtil.secondMaxvalue(sciscore1,sciscore2,sciscore3,sciscore4)+" Points");
										 
									 }
							 	}else{
							 		 if((CommonUtil.getDriver().findElement(By.xpath(uniqueSCI+"/table/tbody/tr[1]/td[2]")).getText().contains(CommonUtil.secondMaxvalue(sciscore1,sciscore2,sciscore3,sciscore4)))){
										 
										    msg = "Verified Button Value";	
											//log.info(msg);
											CommonUtil.report(msg,pass,CommonUtil.secondMaxvalue(sciscore1,sciscore2,sciscore3,sciscore4)+" Points");
										 
									 }
							 	}
							 
							 
						 }else if(noofscores == 3){
							
							 if(scilable1.trim().length() > 0){
								 if(CommonUtil.getDriver().findElement(By.xpath(uniqueSCI+"/table/tbody/tr[2]/td[1]")).getText().equalsIgnoreCase(EnvUtil.getProperty(CommonUtil.firstMaxvalue(sciscore1,sciscore2,sciscore3,sciscore4))) && (CommonUtil.getDriver().findElement(By.xpath(uniqueSCI+"/table/tbody/tr[1]/td[1]")).getText().contains(CommonUtil.firstMaxvalue(sciscore1,sciscore2,sciscore3,sciscore4)))){
									 
									    msg = "Verified Button and Label Value";	
										//log.info(msg);
										CommonUtil.report(msg,pass,EnvUtil.getProperty(CommonUtil.firstMaxvalue(sciscore1,sciscore2,sciscore3,sciscore4))+" and "+CommonUtil.firstMaxvalue(sciscore1,sciscore2,sciscore3,sciscore4)+" Points");
									 
									 }
							 }else{
								 if((CommonUtil.getDriver().findElement(By.xpath(uniqueSCI+"/table/tbody/tr[1]/td[1]")).getText().contains(CommonUtil.firstMaxvalue(sciscore1,sciscore2,sciscore3,sciscore4)))){
									 
									    msg = "Verified Button Value";	
										//log.info(msg);
										CommonUtil.report(msg,pass,CommonUtil.firstMaxvalue(sciscore1,sciscore2,sciscore3,sciscore4)+" Points");
									 
									 }
							 }
								 
							 
							 if(scilable2.trim().length() > 0){
								 if(CommonUtil.getDriver().findElement(By.xpath(uniqueSCI+"/table/tbody/tr[2]/td[2]")).getText().equalsIgnoreCase(EnvUtil.getProperty(CommonUtil.secondMaxvalue(sciscore1,sciscore2,sciscore3,sciscore4))) && (CommonUtil.getDriver().findElement(By.xpath(uniqueSCI+"/table/tbody/tr[1]/td[2]")).getText().contains(CommonUtil.secondMaxvalue(sciscore1,sciscore2,sciscore3,sciscore4)))){
									 
									    msg = "Verified Button and Label Value";	
										//log.info(msg);
										CommonUtil.report(msg,pass,EnvUtil.getProperty(CommonUtil.secondMaxvalue(sciscore1,sciscore2,sciscore3,sciscore4))+" and "+CommonUtil.secondMaxvalue(sciscore1,sciscore2,sciscore3,sciscore4)+" Points");
									 
									 }
							 }else{
								 if((CommonUtil.getDriver().findElement(By.xpath(uniqueSCI+"/table/tbody/tr[1]/td[2]")).getText().contains(CommonUtil.secondMaxvalue(sciscore1,sciscore2,sciscore3,sciscore4)))){
									 
									    msg = "Verified Button Value";	
										//log.info(msg);
										CommonUtil.report(msg,pass,CommonUtil.secondMaxvalue(sciscore1,sciscore2,sciscore3,sciscore4)+" Points");
									 
									 }
							 }
							 
							 if(scilable3.trim().length() > 0){	 
								 if(CommonUtil.getDriver().findElement(By.xpath(uniqueSCI+"/table/tbody/tr[2]/td[3]")).getText().equalsIgnoreCase(EnvUtil.getProperty(CommonUtil.thirdMaxvalue(sciscore1,sciscore2,sciscore3,sciscore4))) && (CommonUtil.getDriver().findElement(By.xpath(uniqueSCI+"/table/tbody/tr[1]/td[3]")).getText().contains(CommonUtil.thirdMaxvalue(sciscore1,sciscore2,sciscore3,sciscore4)))){
									 
									    msg = "Verified Button and Label Value";	
										//log.info(msg);
										CommonUtil.report(msg,pass,EnvUtil.getProperty(CommonUtil.thirdMaxvalue(sciscore1,sciscore2,sciscore3,sciscore4))+" and "+CommonUtil.thirdMaxvalue(sciscore1,sciscore2,sciscore3,sciscore4)+" Points");
									 
									 }
							 }else{
								 if((CommonUtil.getDriver().findElement(By.xpath(uniqueSCI+"/table/tbody/tr[1]/td[3]")).getText().contains(CommonUtil.thirdMaxvalue(sciscore1,sciscore2,sciscore3,sciscore4)))){
									 
									    msg = "Verified Button Value";	
										//log.info(msg);
										CommonUtil.report(msg,pass,CommonUtil.thirdMaxvalue(sciscore1,sciscore2,sciscore3,sciscore4)+" Points");
									 
									 }
							 }
							

						 }else if(noofscores == 4){
							
							 // Contain "0" or Not
							 if(CommonUtil.containvalue(sciscore1,sciscore2,sciscore3,sciscore4, "0")){
								 
								 if(scilable1.trim().length() > 0){	 
									 if(CommonUtil.getDriver().findElement(By.xpath(uniqueSCI+"/div/ul/li[1]/div")).getText().equalsIgnoreCase(EnvUtil.getProperty(CommonUtil.firstMaxvalue(sciscore1,sciscore2,sciscore3,sciscore4))) &&  CommonUtil.getDriver().findElement(By.xpath(uniqueSCI+"/div/ul/li[1]/button")).getText().contains(CommonUtil.firstMaxvalue(sciscore1,sciscore2,sciscore3,sciscore4))){
										 
										 msg = "Verified Button and Label Value";	
											//log.info(msg);
											CommonUtil.report(msg,pass,EnvUtil.getProperty(CommonUtil.firstMaxvalue(sciscore1,sciscore2,sciscore3,sciscore4))+" and "+CommonUtil.firstMaxvalue(sciscore1,sciscore2,sciscore3,sciscore4)+" Points");
										 
									 }
								 }else{
									 if(CommonUtil.getDriver().findElement(By.xpath(uniqueSCI+"/div/ul/li[1]/button")).getText().contains(CommonUtil.firstMaxvalue(sciscore1,sciscore2,sciscore3,sciscore4))){
										 
										 msg = "Verified Button Value";	
											//log.info(msg);
											CommonUtil.report(msg,pass,CommonUtil.firstMaxvalue(sciscore1,sciscore2,sciscore3,sciscore4)+" Points");
										 
									 }
								 }
								 
								 if(scilable2.trim().length() > 0){	
									 if(CommonUtil.getDriver().findElement(By.xpath(uniqueSCI+"/div/ul/li[2]/div")).getText().equalsIgnoreCase(EnvUtil.getProperty(CommonUtil.secondMaxvalue(sciscore1,sciscore2,sciscore3,sciscore4))) &&  CommonUtil.getDriver().findElement(By.xpath(uniqueSCI+"/div/ul/li[2]/button")).getText().contains(CommonUtil.secondMaxvalue(sciscore1,sciscore2,sciscore3,sciscore4))){
										 
										  msg = "Verified Button and Label Value";	
											//log.info(msg);
											CommonUtil.report(msg,pass,EnvUtil.getProperty(CommonUtil.secondMaxvalue(sciscore1,sciscore2,sciscore3,sciscore4))+" and "+CommonUtil.secondMaxvalue(sciscore1,sciscore2,sciscore3,sciscore4)+" Points");
										 
									 }
								 }else{
									 if(CommonUtil.getDriver().findElement(By.xpath(uniqueSCI+"/div/ul/li[2]/button")).getText().contains(CommonUtil.secondMaxvalue(sciscore1,sciscore2,sciscore3,sciscore4))){
										 
										  msg = "Verified Button Value";	
											//log.info(msg);
											CommonUtil.report(msg,pass,CommonUtil.secondMaxvalue(sciscore1,sciscore2,sciscore3,sciscore4)+" Points");
										 
									 }
								 }
								  
								 if(scilable3.trim().length() > 0){	
									 if(CommonUtil.getDriver().findElement(By.xpath(uniqueSCI+"/div/ul/li[3]/div")).getText().equalsIgnoreCase(EnvUtil.getProperty(CommonUtil.thirdMaxvalue(sciscore1,sciscore2,sciscore3,sciscore4))) &&  CommonUtil.getDriver().findElement(By.xpath(uniqueSCI+"/div/ul/li[3]/button")).getText().contains(CommonUtil.thirdMaxvalue(sciscore1,sciscore2,sciscore3,sciscore4))){
										 
										  msg = "Verified Button and Label Value";	
											//log.info(msg);
											CommonUtil.report(msg,pass,EnvUtil.getProperty(CommonUtil.thirdMaxvalue(sciscore1,sciscore2,sciscore3,sciscore4))+" and "+CommonUtil.thirdMaxvalue(sciscore1,sciscore2,sciscore3,sciscore4)+" Points");
										 
									 }
								 }else{
									 if(CommonUtil.getDriver().findElement(By.xpath(uniqueSCI+"/div/ul/li[3]/button")).getText().contains(CommonUtil.thirdMaxvalue(sciscore1,sciscore2,sciscore3,sciscore4))){
										 
										  msg = "Verified Button  Value";	
											//log.info(msg);
											CommonUtil.report(msg,pass,CommonUtil.thirdMaxvalue(sciscore1,sciscore2,sciscore3,sciscore4)+" Points");
										 
									 }
								 }
								  
								 if(scilable4.trim().length() > 0){	
									 if(CommonUtil.getDriver().findElement(By.xpath(uniqueSCI+"/div/div/div")).getText().equalsIgnoreCase(EnvUtil.getProperty(CommonUtil.fourthtMaxvalue(sciscore1,sciscore2,sciscore3,sciscore4))) &&  CommonUtil.getDriver().findElement(By.xpath(uniqueSCI+"/div/div/button")).getText().contains(CommonUtil.fourthtMaxvalue(sciscore1,sciscore2,sciscore3,sciscore4))){
										 
										  msg = "Verified Button and Label Value";	
											//log.info(msg);
											CommonUtil.report(msg,pass,EnvUtil.getProperty(CommonUtil.fourthtMaxvalue(sciscore1,sciscore2,sciscore3,sciscore4))+" and "+CommonUtil.fourthtMaxvalue(sciscore1,sciscore2,sciscore3,sciscore4)+" Points");
										 
										 }
								 }else{
									 if(CommonUtil.getDriver().findElement(By.xpath(uniqueSCI+"/div/div/button")).getText().contains(CommonUtil.fourthtMaxvalue(sciscore1,sciscore2,sciscore3,sciscore4))){
										 
										  msg = "Verified Button Value";	
											//log.info(msg);
											CommonUtil.report(msg,pass,CommonUtil.fourthtMaxvalue(sciscore1,sciscore2,sciscore3,sciscore4)+" Points");
										 
										 }
								 }
								 
								  
							 }else{
								 if(scilable1.trim().length() > 0){	
									 if(CommonUtil.getDriver().findElement(By.xpath(uniqueSCI+"/div/ul/li[1]/div")).getText().equalsIgnoreCase(EnvUtil.getProperty(CommonUtil.firstMaxvalue(sciscore1,sciscore2,sciscore3,sciscore4))) &&  CommonUtil.getDriver().findElement(By.xpath(uniqueSCI+"/div/ul/li[1]/button")).getText().contains(CommonUtil.firstMaxvalue(sciscore1,sciscore2,sciscore3,sciscore4))){
										 
										    msg = "Verified Button and Label Value";	
											//log.info(msg);
											CommonUtil.report(msg,pass,EnvUtil.getProperty(CommonUtil.firstMaxvalue(sciscore1,sciscore2,sciscore3,sciscore4))+" and "+CommonUtil.firstMaxvalue(sciscore1,sciscore2,sciscore3,sciscore4)+" Points");
										 
									 }
								 }else{ 
									 if(CommonUtil.getDriver().findElement(By.xpath(uniqueSCI+"/div/ul/li[1]/button")).getText().contains(CommonUtil.firstMaxvalue(sciscore1,sciscore2,sciscore3,sciscore4))){
										 
										    msg = "Verified Button Value";	
											//log.info(msg);
											CommonUtil.report(msg,pass,CommonUtil.firstMaxvalue(sciscore1,sciscore2,sciscore3,sciscore4)+" Points");
										 
									 }
								 }
								 
								 
								 if(scilable2.trim().length() > 0){
									 if(CommonUtil.getDriver().findElement(By.xpath(uniqueSCI+"/div/ul/li[2]/div")).getText().equalsIgnoreCase(EnvUtil.getProperty(CommonUtil.secondMaxvalue(sciscore1,sciscore2,sciscore3,sciscore4))) &&  CommonUtil.getDriver().findElement(By.xpath(uniqueSCI+"/div/ul/li[2]/button")).getText().contains(CommonUtil.secondMaxvalue(sciscore1,sciscore2,sciscore3,sciscore4))){
										 
										    msg = "Verified Button and Label Value";	
											//log.info(msg);
											CommonUtil.report(msg,pass,EnvUtil.getProperty(CommonUtil.secondMaxvalue(sciscore1,sciscore2,sciscore3,sciscore4))+" and "+CommonUtil.secondMaxvalue(sciscore1,sciscore2,sciscore3,sciscore4)+" Points");
										 
									 }
								 }else{ 
									 if(CommonUtil.getDriver().findElement(By.xpath(uniqueSCI+"/div/ul/li[2]/button")).getText().contains(CommonUtil.secondMaxvalue(sciscore1,sciscore2,sciscore3,sciscore4))){
										 
										    msg = "Verified Button Value";	
											//log.info(msg);
											CommonUtil.report(msg,pass,CommonUtil.secondMaxvalue(sciscore1,sciscore2,sciscore3,sciscore4)+" Points");
										 
									 }
								 }
								  
								  if(scilable3.trim().length() > 0){
									  if(CommonUtil.getDriver().findElement(By.xpath(uniqueSCI+"/div/ul/li[3]/div")).getText().equalsIgnoreCase(EnvUtil.getProperty(CommonUtil.thirdMaxvalue(sciscore1,sciscore2,sciscore3,sciscore4))) &&  CommonUtil.getDriver().findElement(By.xpath(uniqueSCI+"/div/ul/li[3]/button")).getText().contains(CommonUtil.thirdMaxvalue(sciscore1,sciscore2,sciscore3,sciscore4))){
											 
										    msg = "Verified Button and Label Value";	
											//log.info(msg);
											CommonUtil.report(msg,pass,EnvUtil.getProperty(CommonUtil.thirdMaxvalue(sciscore1,sciscore2,sciscore3,sciscore4))+" and "+CommonUtil.thirdMaxvalue(sciscore1,sciscore2,sciscore3,sciscore4)+" Points");
										 
									 }
								  }else{ 
									  if(CommonUtil.getDriver().findElement(By.xpath(uniqueSCI+"/div/ul/li[3]/button")).getText().contains(CommonUtil.thirdMaxvalue(sciscore1,sciscore2,sciscore3,sciscore4))){
											 
										    msg = "Verified Button Value";	
											//log.info(msg);
											CommonUtil.report(msg,pass,CommonUtil.thirdMaxvalue(sciscore1,sciscore2,sciscore3,sciscore4)+" Points");
										 
									 }
								  }
								 
								  if(scilable4.trim().length() > 0){
									  if(CommonUtil.getDriver().findElement(By.xpath(uniqueSCI+"/div/ul/li[4]/div")).getText().equalsIgnoreCase(EnvUtil.getProperty(CommonUtil.fourthtMaxvalue(sciscore1,sciscore2,sciscore3,sciscore4))) &&  CommonUtil.getDriver().findElement(By.xpath(uniqueSCI+"/div/ul/li[4]/button")).getText().contains(CommonUtil.fourthtMaxvalue(sciscore1,sciscore2,sciscore3,sciscore4))){
											 
										    msg = "Verified Button and Label Value";	
											//log.info(msg);
											CommonUtil.report(msg,pass,EnvUtil.getProperty(CommonUtil.fourthtMaxvalue(sciscore1,sciscore2,sciscore3,sciscore4))+" and "+CommonUtil.fourthtMaxvalue(sciscore1,sciscore2,sciscore3,sciscore4)+" Points");
										 
										 }
								  }else{ 
									  if(CommonUtil.getDriver().findElement(By.xpath(uniqueSCI+"/div/ul/li[4]/button")).getText().contains(CommonUtil.fourthtMaxvalue(sciscore1,sciscore2,sciscore3,sciscore4))){
											 
										    msg = "Verified Button Value";	
											//log.info(msg);
											CommonUtil.report(msg,pass,CommonUtil.fourthtMaxvalue(sciscore1,sciscore2,sciscore3,sciscore4)+" Points");
										 
										 }
								  }
								  
								 
							 }
							 
						 }
						 
					 }
				 }
				noofscores = 0;
				noofsecs = 0;
				scicond = false;
			    promptHTML = null;
			    sciscore1 = null;
			    scilable1 = null;
			    sciscore2 = null;
			    scilable2 = null;
			    sciscore3 = null;
			    scilable3 = null;
			    sciscore4 = null;
			    scilable4 = null;

				 
				 
				//log.info(CommonUtil.getDriver().findElement(promptHTMLtext).getText());
				CommonUtil.getDriver().close();
				
				//Switch to newly opened window -Order Status and get the page title
				for(String winHandle : CommonUtil.getDriver().getWindowHandles()){
						CommonUtil.getDriver().switchTo().window(winHandle);		
					}
		
				 //log.info(CommonUtil.getDriver().getTitle());
				 return true;
		
		  } catch (Exception e) {
				// TODO Auto-generated catch block
			    msg = "Verify Save and Preview Page ";	
				//log.fatal(msg);
				CommonUtil.report(msg,fail,e.getMessage());
				
				e.printStackTrace();
				return false;
			}
	}
	

	public boolean ClickonTabList(String tab) {
		msg = "Click on "+tab+" tab";	
		//log.info(msg);
		CommonUtil.report(msg,pass);
		return CommonUtil.clickontab(tablist_subtest_Locator,tablist_subtest_xpath,tab);
	}
	
	public boolean sinCarItm(String method,String promptHTML,String skillAnalysisLabel,String pronunciation ,String alwayshideitem ,String uselabelbuttonastext , String countScore , String scoreval1 , String labelval1  ,String scoreval2 , String labelval2 ,String scoreval3 , String labelval3 ,String scoreval4 , String labelval4,String OverlayButton,String OverlayButtonLabel, String OverlayButtonHeader,String SectionCount,String OverlayButtonSection1,String OverlayButtonSection2){
		int scre = Integer.parseInt(countScore);
		int sect = Integer.parseInt(SectionCount);
		try {
			
		if(CommonUtil.getText(sectionNameSinCarItm).equalsIgnoreCase(method)){
			
			// Prompt HTML
			driver2 = CommonUtil.getDriver();
			driver2.switchTo().frame(driver2.findElement(promt));
			driver2.findElement(By.tagName("body")).clear();
			driver2.findElement(By.tagName("body")).sendKeys(promptHTML);
			
			driver2.switchTo().parentFrame();
			msg = "Enter Prompt HTML ";	
			CommonUtil.report(msg,pass,promptHTML);
			CommonUtil.sleep(timetowait);
			CommonUtil.sleep(timetowait);
			
			// Skill Analysis Label 
			if(skillAnalysisLabel.length()>0){
			CommonUtil.scrolltoview(skill);
			CommonUtil.clear(skill);
			CommonUtil.sendKeys(skill, skillAnalysisLabel);
			msg = "Enter Skill Analysis Label  ";	
			CommonUtil.report(msg,pass,skillAnalysisLabel);
			CommonUtil.sleep(timetowait);
			}
			
			// Pronunciation 
			if(pronunciation.length()>0){
			CommonUtil.scrolltoview(pronunc);
			CommonUtil.clear(pronunc);
			CommonUtil.sendKeys(pronunc, pronunciation);
			msg = "Enter Pronunciation";	
			CommonUtil.report(msg,pass,pronunciation);
			CommonUtil.sleep(timetowait);
			}
			
			// Always hide the item in the skills analysis overlay:
			if(alwayshideitem.length()>0){
				CommonUtil.sleep(timetowait);
				CommonUtil.scrolltoview(alwaysHideItem);
				CommonUtil.click(alwaysHideItem);
				CommonUtil.sleep(timetowait);
				msg = "Checked :  Always hide the item in the skills analysis overlay";	
				CommonUtil.report(msg,pass);
			}
			
			// Use label as button text:
			if(uselabelbuttonastext.length()>0){
				CommonUtil.sleep(timetowait);
				CommonUtil.scrolltoview(uselabelasbuttontext);
				CommonUtil.click(uselabelasbuttontext);
				CommonUtil.sleep(timetowait);
				msg = "Checked :  Use label as button text";	
				CommonUtil.report(msg,pass);
			}
			
			// Add new Score Button 
			for(int i = 1; i<=scre; i++){
				CommonUtil.sleep(timetowait);
				if(CommonUtil.isElementPresent(addNewScoreButtons)){
					CommonUtil.scrolltoview(addNewScoreButtons);
	                CommonUtil.click(addNewScoreButtons);
				}
				
				CommonUtil.sleep(timetowait);
			}
			
			switch (scre) {      
			  case 1:
				  score1(scoreval1 , labelval1);
				  break;
	          
			  case 2:
				  score1(scoreval1 , labelval1);
				  score2(scoreval2 , labelval2);
				  break;
		          
			  case 3:
				  score1(scoreval1 , labelval1);
				  score2(scoreval2 , labelval2);	
				  score3(scoreval3 , labelval3);
				  break;
			  case 4:
				  score1(scoreval1 , labelval1);
				  score2(scoreval2 , labelval2);	
				  score3(scoreval3 , labelval3);
				  score4(scoreval4 , labelval4);
				  break;
			}
			
			//Should show overlay button
			if(OverlayButton.length() > 1){
					CommonUtil.sleep(timetowait);
					CommonUtil.scrolltoview(overlayCheckBox);
					CommonUtil.click(overlayCheckBox);
					CommonUtil.sleep(timetowait);
					msg = "Checked : Should show overlay button ";	
					CommonUtil.report(msg,pass);
				
			}
			
			
			// Overlay Button Label
			CommonUtil.scrolltoview(overlayButtonLabel);
			CommonUtil.clear(overlayButtonLabel);
			CommonUtil.sendKeys(overlayButtonLabel, OverlayButtonLabel);
			CommonUtil.sleep(timetowait);
			msg = "Enter Overlay Button Label ";	
			CommonUtil.report(msg,pass);
			
			// Overlay Section Header
			CommonUtil.scrolltoview(overlaySectionHeader);
			CommonUtil.clear(overlaySectionHeader);
			CommonUtil.sendKeys(overlaySectionHeader, OverlayButtonHeader);
			CommonUtil.sleep(timetowait);
			msg = "Enter Overlay Section Header ";	
			CommonUtil.report(msg,pass);
			
			//Add Overlay Section
			for(int i = 1; i<=sect; i++){
				CommonUtil.sleep(timetowait);
				if(CommonUtil.isElementPresent(addOverlaySection)){
						CommonUtil.scrolltoview(addOverlaySection);
	                    CommonUtil.click(addOverlaySection);
				}
				
				CommonUtil.sleep(timetowait);
			}
			
			if(OverlayButtonSection1.length() >0){
				driver2 = CommonUtil.getDriver();
				driver2.switchTo().frame(driver2.findElement(overlaySection1VisiblePromptHTML1));
				driver2.findElement(By.tagName("body")).clear();
				driver2.findElement(By.tagName("body")).sendKeys(OverlayButtonSection1);
				
				driver2.switchTo().parentFrame();
				msg = "Enter Overlay Section 1 Visible HTML";	
				CommonUtil.report(msg,pass,OverlayButtonSection1);
				CommonUtil.sleep(timetowait);
				
				driver2 = CommonUtil.getDriver();
				driver2.switchTo().frame(driver2.findElement(overlaySection1ExpandPromptHTML1));
				driver2.findElement(By.tagName("body")).clear();
				driver2.findElement(By.tagName("body")).sendKeys(OverlayButtonSection1);
				
				driver2.switchTo().parentFrame();
				msg = "Enter Overlay Section 1 Expanded HTML";	
				CommonUtil.report(msg,pass,OverlayButtonSection1);
				CommonUtil.sleep(timetowait);
				
				
			}
			
			if(OverlayButtonSection2.length() >0){
				
				driver2 = CommonUtil.getDriver();
				driver2.switchTo().frame(driver2.findElement(overlaySection2VisiblePromptHTML1));
				driver2.findElement(By.tagName("body")).sendKeys(OverlayButtonSection2);
				
				driver2.switchTo().parentFrame();
				msg = "Enter Overlay Section 2 Visible HTML";	
				CommonUtil.report(msg,pass,OverlayButtonSection2);
				CommonUtil.sleep(timetowait);
				
				driver2 = CommonUtil.getDriver();
				driver2.switchTo().frame(driver2.findElement(overlaySection2ExpandPromptHTML1));
				driver2.findElement(By.tagName("body")).sendKeys(OverlayButtonSection2);
				
				driver2.switchTo().parentFrame();
				msg = "Enter Overlay Section 2 Expanded HTML";	
				CommonUtil.report(msg,pass,OverlayButtonSection2);
				CommonUtil.sleep(timetowait);
				
				driver2 = CommonUtil.getDriver();
			}
			
			
			// Click on Save
			if(clicksyncError(itemSave)){
			msg = "Scoring Method Save Successfully";
			CommonUtil.report(msg,pass);
			return true;
			}else{
				if(CommonUtil.isDisplayed(errorMsg)){
					CommonUtil.scrolltoview(errorMsg);
					emsg = CommonUtil.getText(errorMsg);
				}
				if(CommonUtil.isDisplayed(errorMsg1)){
					CommonUtil.scrolltoview(errorMsg1);
					emsgs = CommonUtil.getText(errorMsg1);
				}
				if(CommonUtil.isDisplayed(errorMsg2)){
					CommonUtil.scrolltoview(errorMsg2);
					emsgss = CommonUtil.getText(errorMsg2);
				}
				if(CommonUtil.isDisplayed(errorMsg3)){
					CommonUtil.scrolltoview(errorMsg3);
					emsgsss = CommonUtil.getText(errorMsg3);
				}
				
				msg = "Scoring Method not Save Successfully";	
				//log.fatal(emsg+emsgs+emsgss);
				if(emsg!= null) {
					error = emsg;
				}
				if(emsgs!= null) {
					error = error + emsgs;
				}
				if(emsgss!= null) {
					error = error + emsgss;
				}
				if(emsgsss!= null) {
					error = error + emsgsss;
				}
				
				CommonUtil.report(msg,fail,error);
				return false;
				}
			} 
		}catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
		return false;
		}	
	
	
	
	public boolean updateScoringMethod(String method,String PromptHTML,String SkillsAnalysisLabel,String Pronunciation,String Alwayshidetheitem,String Uselabelasbuttontext,String ScoreCount,String Score1,String Label1,String Score2,String Label2,String Score3,String Label3,String Score4,String Label4,String OverlayButton,String OverlayButtonLabel, String OverlayButtonHeader,String SectionCount,String OverlayButtonSection1,String OverlayButtonSection2){
			
		try {
			
		if(CommonUtil.getText(sectionNameSinCarItm).equalsIgnoreCase(method)){
			
			// Prompt HTML
			if(PromptHTML.length()>1){
				driver2 = CommonUtil.getDriver();
				driver2.switchTo().frame(driver2.findElement(promt));
				driver2.findElement(By.tagName("body")).clear();
				driver2.findElement(By.tagName("body")).sendKeys(PromptHTML);
				
				driver2.switchTo().parentFrame();
				msg = "Enter Prompt HTML ";	
				CommonUtil.report(msg,pass,PromptHTML);
				CommonUtil.sleep(timetowait);
				
			}
			
			// Skill Analysis Label 
			if(SkillsAnalysisLabel.length()>1){
				CommonUtil.scrolltoview(skill);
				CommonUtil.clear(skill);
				CommonUtil.sendKeys(skill, SkillsAnalysisLabel);
				msg = "Enter Skill Analysis Label  ";	
				CommonUtil.report(msg,pass,SkillsAnalysisLabel);
				CommonUtil.sleep(timetowait); 
				
			}
			
			// Pronunciation 
			if(Pronunciation.length()>1){
				CommonUtil.scrolltoview(pronunc);
				CommonUtil.clear(pronunc);
				CommonUtil.sendKeys(pronunc, Pronunciation);
				msg = "Enter Pronunciation";	
				CommonUtil.report(msg,pass,Pronunciation);
				CommonUtil.sleep(timetowait);
			
			}
			
			// Always hide the item in the skills analysis overlay:
			if(Alwayshidetheitem.length()>0){
				CommonUtil.sleep(timetowait);
				CommonUtil.scrolltoview(alwaysHideItem);
				CommonUtil.click(alwaysHideItem);
				CommonUtil.sleep(timetowait);
				msg = "Always hide the item in the skills analysis overlay ";	
				CommonUtil.report(msg,pass);
			}
			
			// Use label as button text:
			if(Uselabelasbuttontext.length()>0){
				CommonUtil.sleep(timetowait);
				CommonUtil.scrolltoview(uselabelasbuttontext);
				CommonUtil.click(uselabelasbuttontext);
				CommonUtil.sleep(timetowait);
				msg = "Checked :  Use label as button text";	
				CommonUtil.report(msg,pass);			
			}
			// Add new Score Button 
			// Permutation & Combination of Score Button
			int noofscore = CommonUtil.getDriver().findElements(By.xpath("//*[@id='scoreItems']/section/header/span[1]")).size();
			for(int j = 1;j<=noofscore;j++ ){
				CommonUtil.scrolltoview(By.xpath("//*[@id='scoreItems']/section["+j+"]/header/span[1]"));
				CommonUtil.clicksync("//*[@id='scoreItems']/section["+j+"]/header/span[1]");
				Thread.sleep(5000); 
			}
				
			 switch (ScoreCount.replaceAll("\\s","")) {
	            case "-1":	deleteSection(Score1);
	                        
	            break;
	                        
	            case "-2":	deleteSection(Score1);
	            			deleteSection(Score2);
	            			
                break;
                			
	            case "-3":	deleteSection(Score1);
    						deleteSection(Score2);
    						deleteSection(Score3);
    							
                break;
                			
	            case "-4":	deleteSection(Score1);
	            			deleteSection(Score2);
	            			deleteSection(Score3);
	            			deleteSection(Score4);
	            
	            break;
                			
	            case "1":	addSection(Score1,Label1);
                
	            break;
	            
	            case "2":	addSection(Score1,Label1);
	            			addSection(Score2,Label2);
    			
	            break;
                
	            case "3":	addSection(Score1,Label1);
	            			addSection(Score2,Label2);
	            			addSection(Score3,Label3);
    			
	            break;
    			
	            case "4":	addSection(Score1,Label1);
	            			addSection(Score2,Label2);
	            			addSection(Score3,Label3);
	            			addSection(Score4,Label4);
    			
	            break;
    			
	            case "5":	updateSection(Score1,Label1,Score2,Label2,Score3,Label3,Score4,Label4);

	            break;
			 }
			 
			 
			//Should show overlay button
				if(OverlayButton.length() > 1){
						CommonUtil.sleep(timetowait);
						CommonUtil.scrolltoview(overlayCheckBox);
						CommonUtil.click(overlayCheckBox);
						CommonUtil.sleep(timetowait);
						msg = "Should show overlay button ";	
						CommonUtil.report(msg,pass);
					
				}
				
				
				// Overlay Button Label
				if(OverlayButtonLabel.length() > 0 ){
				CommonUtil.scrolltoview(overlayButtonLabel);
				CommonUtil.clear(overlayButtonLabel);
				CommonUtil.sendKeys(overlayButtonLabel, OverlayButtonLabel);
				CommonUtil.sleep(timetowait);
				msg = "Enter Overlay Button Label ";	
				CommonUtil.report(msg,pass);
				}
			
				// Overlay Section Header
				if(OverlayButtonHeader.length() > 0 ){
				CommonUtil.scrolltoview(overlaySectionHeader);
				CommonUtil.clear(overlaySectionHeader);
				CommonUtil.sendKeys(overlaySectionHeader, OverlayButtonHeader);
				CommonUtil.sleep(timetowait);
				msg = "Enter Overlay Section Header ";	
				CommonUtil.report(msg,pass);
				}
				
				// Permutation & Combination of Overlay Section 
				if(OverlayButton.length() > 0){
				int noofsec = CommonUtil.getDriver().findElements(By.xpath("//*[@id='culturalSections']/section")).size();
				for(int k = 1;k<=noofsec;k++ ){
					CommonUtil.scrolltoview(By.xpath("//*[@id='culturalSections']/section["+k+"]/header/span[1]"));
					CommonUtil.clicksync("//*[@id='culturalSections']/section["+k+"]/header/span[1]");
					Thread.sleep(5000); 
				}
				}
				
				
				//Add Overlay Section
				switch (SectionCount.replaceAll("\\s","")) {
	            case "-1":	deleteOverlaySection(OverlayButtonSection1);
	            break;
	                        
	            case "-2":	deleteOverlaySection(OverlayButtonSection1);
	            			deleteOverlaySection(OverlayButtonSection2);
                break;
                	                			
	            case "1":	addOverlaySection(OverlayButtonSection1);
	            break;
	            
	            case "2":	addOverlaySection(OverlayButtonSection1);
	            			addOverlaySection(OverlayButtonSection2);
	            break;
                
	            case "3":	updateOverlaySection(OverlayButtonSection1,OverlayButtonSection2);
	            break;
	            
    			
				}
			
			if(OverlayButton.length() > 0){
				driver2.switchTo().parentFrame();	
				driver2 = CommonUtil.getDriver();
			}
			
			 
			
			
			// Click on Save
			if(clicksyncError(itemSave1)){
			msg = "Scoring Method Save Successfully";	
			//log.info(msg);
			CommonUtil.report(msg,pass);
			return true;
			}else{
				if(CommonUtil.isDisplayed(errorMsg)){
					CommonUtil.scrolltoview(errorMsg);
					emsg = CommonUtil.getText(errorMsg);
				}
				if(CommonUtil.isDisplayed(errorMsg1)){
					CommonUtil.scrolltoview(errorMsg1);
					emsgs = CommonUtil.getText(errorMsg1);
				}
				if(CommonUtil.isDisplayed(errorMsg2)){
					CommonUtil.scrolltoview(errorMsg2);
					emsgss = CommonUtil.getText(errorMsg2);
				}
				if(CommonUtil.isDisplayed(errorMsg3)){
					CommonUtil.scrolltoview(errorMsg3);
					emsgsss = CommonUtil.getText(errorMsg3);
				}
				
				msg = "Scoring Method not Save Successfully";	
				//log.fatal(emsg+emsgs+emsgss);
				if(emsg!= null) {
					error = emsg;
				}
				if(emsgs!= null) {
					error = error + emsgs;
				}
				if(emsgss!= null) {
					error = error + emsgss;
				}
				if(emsgsss!= null) {
					error = error + emsgsss;
				}
				CommonUtil.scrolltoview(errorMsg1);
				CommonUtil.report(msg,fail,error);
				return false;
				}
			} 
		}catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
		return false;
		}
	
	public void readSingleCardItemCulturalBkgd(){
		
		// Prompt HTML
			try {
				driver2 = CommonUtil.getDriver();
				driver2.switchTo().frame(driver2.findElement(promt));
				promptHTML = driver2.findElement(By.tagName("body")).getText();
				driver2.switchTo().parentFrame();
				CommonUtil.sleep(timetowait);
			
				msg = "Store the PromptHTML Data";	
				//log.info(msg);
				CommonUtil.report(msg,pass,promptHTML);	
				
				CommonUtil.scrolltoview(overlayButtonLabel);
				obLabel = CommonUtil.getAttributeValue(overlayButtonLabel,"value");
				CommonUtil.sleep(timetowait);
				osHeader = CommonUtil.getAttributeValue(overlaySectionHeader,"value");
				
			} catch (Exception es) {
				// TODO Auto-generated catch block
				es.printStackTrace();
				msg = "PromptHTML Data unable to Store";	
				//log.fatal(msg);
				CommonUtil.report(msg,fail,promptHTML);	
			}
		
		// Read values of Cultural Background
			cultrualReadValue();
	}
	
	public void readSingleCardItem(){
		
		// Prompt HTML
			try {
				driver2 = CommonUtil.getDriver();
				driver2.switchTo().frame(driver2.findElement(promt));
				promptHTML = driver2.findElement(By.tagName("body")).getText();
				driver2.switchTo().parentFrame();
				CommonUtil.sleep(timetowait);
			
				msg = "Store the PromptHTML Data";	
				//log.info(msg);
				CommonUtil.report(msg,pass,promptHTML);	
				
			} catch (Exception es) {
				// TODO Auto-generated catch block
				es.printStackTrace();
				msg = "PromptHTML Data unable to Store";	
				//log.fatal(msg);
				CommonUtil.report(msg,fail,promptHTML);	
			}
		// Use label as button text
		if(CommonUtil.isSelected(uselabelasbuttontext)){
			msg = "Label of Single Card Item ";	
			//log.info(msg);
			CommonUtil.report(msg,pass,"Selected");	
			scicond = true;
		}
		
		// Enlarge all score button 
		int noofscore = CommonUtil.getSize("//*[@id='scoreItems']/section/header/span[1]");                
		for(int j = 1;j<=noofscore;j++ ){
			 try {
	            	JavascriptExecutor jse = (JavascriptExecutor)CommonUtil.getDriver();
	            	jse.executeScript("arguments[0].scrollIntoView(true);",CommonUtil.getDriver().findElement(By.xpath("//*[@id='scoreItems']/section["+j+"]/header/span[1]")));
	            
	            	Thread.sleep(5000); 
	            } catch (Exception e) {	  
	            }
			CommonUtil.clicksync("//*[@id='scoreItems']/section["+j+"]/header/span[1]");
			CommonUtil.report("Score Point Frame "+j,pass);	
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
		
		// Read values of score and label
		readValue();
	}
	
	public void cultrualReadValue(){
		
		// Permutation & Combination of Overlay Section 
		try {
		int noofsec = CommonUtil.getDriver().findElements(By.xpath("//*[@id='culturalSections']/section")).size();
		for(int k = 1;k<=noofsec;k++ ){
			CommonUtil.scrolltoview(By.xpath("//*[@id='culturalSections']/section["+k+"]/header/span[1]"));
			CommonUtil.clicksync("//*[@id='culturalSections']/section["+k+"]/header/span[1]");	
			Thread.sleep(5000);
		}
		
		noofsecs = noofsec;
		if(noofsec==1){
				driver2 = CommonUtil.getDriver();
				driver2.switchTo().frame(driver2.findElement(overlaySection1VisiblePromptHTML1));
				ossection1 = driver2.findElement(By.tagName("body")).getText();
				driver2.switchTo().parentFrame();
				
		}else if(noofsec > 1){
			driver2 = CommonUtil.getDriver();
			driver2.switchTo().frame(driver2.findElement(overlaySection1VisiblePromptHTML1));
			ossection1 = driver2.findElement(By.tagName("body")).getText();
			driver2.switchTo().parentFrame();
			
			driver2 = CommonUtil.getDriver();
			driver2.switchTo().frame(driver2.findElement(overlaySection2VisiblePromptHTML1));
			ossection2 = driver2.findElement(By.tagName("body")).getText();
			driver2.switchTo().parentFrame();
			
		}
		
		} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
	}
	
	public void readValue(){
		String readvaluepath = "//*[@id='scoreItems']/section/header";
		int size = 0;
		
		size = CommonUtil.getSize(By.xpath(readvaluepath));
		noofscores = size;
		for(int k=1; k<=size; k++){
			if(k==1){
				sciscore1 = CommonUtil.getAttributeValue(score1, "value");
				msg = "Point Score Value ";	
				//log.info(msg);
				CommonUtil.report(msg,pass,sciscore1);	
				scilable1 = CommonUtil.getAttributeValue(label1, "value");
				msg = "Point Label Value ";	
				//log.info(msg);
				CommonUtil.report(msg,pass,scilable1);	
				EnvUtil.SetProperty(sciscore1,scilable1);
			}else if (k==2){
				sciscore2 = CommonUtil.getAttributeValue(score2, "value");
				msg = "Point Score Value ";	
				//log.info(msg);
				CommonUtil.report(msg,pass,sciscore2);
				scilable2 = CommonUtil.getAttributeValue(label2, "value");
				msg = "Point Label Value ";	
				//log.info(msg);
				CommonUtil.report(msg,pass,scilable2);
				EnvUtil.SetProperty(sciscore2,scilable2); 
			}else if (k==3){
				sciscore3 = CommonUtil.getAttributeValue(score3,"value");
				msg = "Point Score Value ";	
				//log.info(msg);
				CommonUtil.report(msg,pass,sciscore3);
				scilable3 = CommonUtil.getAttributeValue(label3, "value");
				msg = "Point Label Value ";	
				//log.info(msg);
				CommonUtil.report(msg,pass,scilable3);	
				EnvUtil.SetProperty(sciscore3,scilable3);
			}else if (k==4){
				sciscore4 = CommonUtil.getAttributeValue(score4, "value");
				msg = "Point Score Value ";	
				//log.info(msg);
				CommonUtil.report(msg,pass,sciscore4);
				scilable4 = CommonUtil.getAttributeValue(label4, "value");
				msg = "Point Label Value ";	
				//log.info(msg);
				CommonUtil.report(msg,pass,scilable4);	
				EnvUtil.SetProperty(sciscore4,scilable4); 
			}   
			
		}
		
		
	}
	
	public void score1(String scoreval1 , String labelval1 ){
		 
		 CommonUtil.clear(score1);
		 CommonUtil.sendKeys(score1, scoreval1);
		 CommonUtil.clear(label1);
		 CommonUtil.sendKeys(label1,labelval1);
		 msg = "Enter Score and Label Value";	
		 CommonUtil.report(msg,pass,scoreval1+"  "+labelval1);
	}
	
	public void score2(String scoreval2 , String labelval2 ){
		 
		 CommonUtil.clear(score2);
		 CommonUtil.sendKeys(score2, scoreval2);
		 CommonUtil.clear(label2);
		 CommonUtil.sendKeys(label2,labelval2);
		 msg = "Enter Score and Label Value";	
		 CommonUtil.report(msg,pass,scoreval2+"  "+labelval2);
	}
	
	public void score3(String scoreval3 , String labelval3 ){
		 
		 CommonUtil.clear(score3);
		 CommonUtil.sendKeys(score3, scoreval3);
		 CommonUtil.clear(label3);
		 CommonUtil.sendKeys(label3,labelval3);
		 msg = "Enter Score and Label Value";	
		 CommonUtil.report(msg,pass,scoreval3+"  "+labelval3);
	}
	
	public void score4(String scoreval4 , String labelval4 ){
		 
		 CommonUtil.clear(score4);
		 CommonUtil.sendKeys(score4, scoreval4);
		 CommonUtil.clear(label4);
		 CommonUtil.sendKeys(label4,labelval4);
		 
		 msg = "Enter Score and Label Value";	
		 CommonUtil.report(msg,pass,scoreval4+"  "+labelval4);
	}
	
	public boolean deleteSection(String deleteSection){
		try {
			
		if(CommonUtil.getAttributeValue(score1, "value").equalsIgnoreCase(deleteSection)){
			CommonUtil.clicksync(removeScore1);
			CommonUtil.getDriver().switchTo().alert().accept();
			CommonUtil.scrolltoview(score1);
			msg = "Remove Score "+deleteSection;	
			CommonUtil.report(msg,pass,deleteSection);
			return true;
		}else if(CommonUtil.getAttributeValue(score2, "value").equalsIgnoreCase(deleteSection)){
			CommonUtil.clicksync(removeScore2);
			CommonUtil.getDriver().switchTo().alert().accept();
			CommonUtil.scrolltoview(score1);
			msg = "Remove Score "+deleteSection;	
			CommonUtil.report(msg,pass,deleteSection);
			return true;
		}else if(CommonUtil.getAttributeValue(score3, "value").equalsIgnoreCase(deleteSection)){
			CommonUtil.clicksync(removeScore3);
			CommonUtil.getDriver().switchTo().alert().accept();	
			CommonUtil.scrolltoview(score1);
			msg = "Remove Score "+deleteSection;	
			CommonUtil.report(msg,pass,deleteSection);;
			return true;
		}else if(CommonUtil.getAttributeValue(score4, "value").equalsIgnoreCase(deleteSection)){
			CommonUtil.clicksync(removeScore4);
			CommonUtil.getDriver().switchTo().alert().accept();
			CommonUtil.scrolltoview(score1);
			msg = "Remove Score "+deleteSection;	
			CommonUtil.report(msg,pass,deleteSection);
			return true;
		}
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return false;
	}
	
	public boolean deleteOverlaySection(String Overlay){
		try {
			
		if(Overlay.length() > 0){
			driver2 = CommonUtil.getDriver();
			driver2.switchTo().frame(driver2.findElement(overlaySection1VisiblePromptHTML1));
			
			if(driver2.findElement(By.tagName("body")).getText().equalsIgnoreCase(Overlay)){
				driver2.switchTo().parentFrame();
				CommonUtil.scrolltoview(removeOverlay1);
				CommonUtil.clicksync(removeOverlay1);
				CommonUtil.getDriver().switchTo().alert().accept();
				CommonUtil.scrolltoview(overlaySectionHeader);
				msg = "Remove Overlay Section";	
				CommonUtil.report(msg,pass,Overlay);
				driver2.switchTo().parentFrame();
				driver2 = CommonUtil.getDriver();
				return true;
			}else{
				CommonUtil.sleep(5000);
				driver2.switchTo().parentFrame();
				driver2 = CommonUtil.getDriver();
				driver2.switchTo().frame(driver2.findElement(overlaySection2VisiblePromptHTML1));
				if(driver2.findElement(By.tagName("body")).getText().equalsIgnoreCase(Overlay)){
					driver2.switchTo().parentFrame();
					CommonUtil.scrolltoview(removeOverlay2);
					CommonUtil.clicksync(removeOverlay2);
					CommonUtil.getDriver().switchTo().alert().accept();
					CommonUtil.scrolltoview(overlaySectionHeader);
					msg = "Remove Overlay Section";	
					CommonUtil.report(msg,pass,Overlay);
					driver2.switchTo().parentFrame();
					driver2 = CommonUtil.getDriver();
					return true;
				}
			}
			
			
		}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return false;
	}
	
	public boolean addSection(String addscore ,String addlabel){
		
		if(CommonUtil.isElementPresent(addNewScoreButtons)){
			CommonUtil.scrolltoview(addNewScoreButtons);
            CommonUtil.click(addNewScoreButtons);
        
	         CommonUtil.clear(By.xpath("//*[@id='scoreItems']//section[last()]/div/div[1]/div[2]/input"));
	   		 CommonUtil.sendKeys(By.xpath("//*[@id='scoreItems']//section[last()]/div/div[1]/div[2]/input"), addscore);
	   		 CommonUtil.clear(By.xpath("//*[@id='scoreItems']//section[last()]/div/div[2]/div[2]/input"));
	   		 CommonUtil.sendKeys(By.xpath("//*[@id='scoreItems']//section[last()]/div/div[2]/div[2]/input"),addlabel);
	   		msg = "Added New Score and Label";	
			CommonUtil.report(msg,pass,addscore+"  "+addlabel);
	         return true;   
	}
		return false;
	}
	
public boolean addOverlaySection(String Overlay1){
	try{
		if(Overlay1.length()>0){
			if(CommonUtil.isElementPresent(addOverlaySection)){
					CommonUtil.scrolltoview(addOverlaySection);
                    CommonUtil.click(addOverlaySection);
                    CommonUtil.sleep(timetowait);
			
                    driver2 = CommonUtil.getDriver();
					driver2.switchTo().frame(driver2.findElement(addoverlaySection1VisiblePromptHTML1));
					driver2.findElement(By.tagName("body")).clear();
					driver2.findElement(By.tagName("body")).sendKeys(Overlay1);
					
					driver2.switchTo().parentFrame();
					msg = "Enter Overlay Section 1 Visible HTML";	
					CommonUtil.report(msg,pass,Overlay1);
					CommonUtil.sleep(timetowait);
					
					driver2 = CommonUtil.getDriver();
					driver2.switchTo().frame(driver2.findElement(addoverlaySection1ExpandPromptHTML1));
					driver2.findElement(By.tagName("body")).clear();
					driver2.findElement(By.tagName("body")).sendKeys(Overlay1);
					
					driver2.switchTo().parentFrame();
					msg = "Enter Overlay Section 1 Expanded HTML";	
					CommonUtil.report(msg,pass,Overlay1);
					CommonUtil.sleep(timetowait);
       	           return true;
			}
			
			
		}
	}catch(Exception e){e.printStackTrace(); return false;}
		return false;
	}

	public void updateSection(String Score1,String Label1,String Score2,String Label2,String Score3,String Label3,String Score4,String Label4){
		if(Score1.length() > 0 && Label1.length() > 0){
			score1(Score1 , Label1);
		}
		if(Score2.length() > 0 && Label2.length() > 0){
			score2(Score2 , Label2);
		}
		if(Score3.length() > 0 && Label3.length() > 0){
			score3(Score3 , Label3);
		}
		if(Score4.length() > 0 && Label4.length() > 0){
			score4(Score4 , Label4);
		}
		
	}	

	public void updateOverlaySection(String Overlay1,String Overlay2){
		try{
		if(Overlay1.length() > 0 && Overlay2.length() > 0){
			
			if(Overlay1.length() > 0){
				driver2 = CommonUtil.getDriver();
				driver2.switchTo().frame(driver2.findElement(overlaySection1VisiblePromptHTML1));
				driver2.findElement(By.tagName("body")).clear();
				driver2.findElement(By.tagName("body")).sendKeys(Overlay1);
				
				driver2.switchTo().parentFrame();
				msg = "Enter Overlay Section 1 Visible HTML";	
				CommonUtil.report(msg,pass,Overlay1);
				CommonUtil.sleep(timetowait);
				
				driver2 = CommonUtil.getDriver();
				driver2.switchTo().frame(driver2.findElement(overlaySection1ExpandPromptHTML1));
				driver2.findElement(By.tagName("body")).clear();
				driver2.findElement(By.tagName("body")).sendKeys(Overlay1);
				
				driver2.switchTo().parentFrame();
				msg = "Enter Overlay Section 1 Expanded HTML";	
				CommonUtil.report(msg,pass,Overlay1);
				CommonUtil.sleep(timetowait);
				
			}
			
			
				if(Overlay2.length() > 0){
				
				driver2 = CommonUtil.getDriver();
				driver2.switchTo().frame(driver2.findElement(overlaySection2VisiblePromptHTML1));
				driver2.findElement(By.tagName("body")).clear();
				driver2.findElement(By.tagName("body")).sendKeys(Overlay2);
				
				driver2.switchTo().parentFrame();
				msg = "Enter Overlay Section 2 Visible HTML";	
				CommonUtil.report(msg,pass,Overlay2);
				CommonUtil.sleep(timetowait);
				
				driver2 = CommonUtil.getDriver();
				driver2.switchTo().frame(driver2.findElement(overlaySection2ExpandPromptHTML1));
				driver2.findElement(By.tagName("body")).clear();
				driver2.findElement(By.tagName("body")).sendKeys(Overlay2);
				
				driver2.switchTo().parentFrame();
				msg = "Enter Overlay Section 2 Expanded HTML";	
				CommonUtil.report(msg,pass,Overlay2);
				CommonUtil.sleep(timetowait);
				
			}
			
		}
		}catch(Exception e){e.printStackTrace();}
	}
	
	public boolean  verifySingleCardItemClikablePage(String hier1 , String hier2 , String hier3 , String hier4 ,String hier5){
	    	
	    	if(!hier1.equals(""))
	    	{
	    		lgth = hier1+" -> ";
	    	}
	    	if(!hier2.equals(""))
	    	{
	    		lgth = lgth +hier2+" -> ";
	    	}
	    	if(!hier3.equals(""))
	    	{
	    		lgth = lgth+hier3+" -> ";
	    	}
	    	if(!hier4.equals(""))
	    	{
	    		lgth = lgth+hier4+" -> ";
	    	}
	    	if(!hier5.equals(""))
	    	{
	    		lgth = lgth+hier5+" -> ";
	    	}
	    	
	    	// Remove last 4 char from the String
	    	lgth = lgth.substring(0,lgth.length()-4);
	    	//log.info(lgth);
	    	CommonUtil.sleep(30000);
	    	if(CommonUtil.getText(hiercharkeypathLocator).equals(lgth)){
	    		msg = "Verified the Clickable Page";	
	    		//log.info(msg);
	    		//CommonUtil.report(msg,pass,CommonUtil.getText(hiercharkeypathLocator));
	    		return true;
	    	}
	    	msg = "Clickable Page is different with Expected Page";	
    		//log.fatal(msg);
    		CommonUtil.report(msg,fail,CommonUtil.getText(hiercharkeypathLocator));
	    	return false;
	    	
	    }
		
	public void clickonChangeScoringMethod(){
		CommonUtil.clicksync(changescoringLocator);
	}
	
	public void clickonalertbox(){
		try {
			CommonUtil.getDriver().switchTo().alert().accept();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean scoringCkhBoxButtonExist(){
		return CommonUtil.isElementPresent(scoringcheckbox);
	}
	
	

	public boolean errorHandlePopUp(){
		return CommonUtil.isElementPresent(errorPoupUp);
	}
	
	public boolean errorHandlePopUps(){
		return CommonUtil.isElementPresent(errorPoupUps);
	}
	public boolean clicksyncError(By by) {
		try{
		if(CommonUtil.isDisplayed(by) && CommonUtil.isEnabled(by)){
			CommonUtil.click(by);
			 if(errorHandlePopUp()){
			     CommonUtil.clicksync(errorSave);
				 return false; 
			 }
			 else if(errorHandlePopUps()){
				 CommonUtil.getDriver().switchTo().alert().accept();
				 CommonUtil.clicksync(errorSaves);
				 return false; 
			 }
			 else{
				 return true;
			 }
		}
		}catch(Exception e){e.printStackTrace();}
		return false;
			
		
	}

	public void selectAllCheckBoxSearchResult() {
		// TODO Auto-generated method stub
		CommonUtil.sleep(2000);
		CommonUtil.driver.findElement(selectcheckboxsearchresult).click();
		CommonUtil.sleep(4000);
		CommonUtil.clicksync(savetoprofilebtn);
		CommonUtil.sleep(4000);
		msg = "Article Saved to My Profile";	
		//log.info(msg);
		CommonUtil.report(msg,pass);
	}
}*/