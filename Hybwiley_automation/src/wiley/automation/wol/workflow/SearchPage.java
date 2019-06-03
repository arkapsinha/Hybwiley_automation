/*package wiley.automation.wol.workflow;

import org.openqa.selenium.WebDriver;

import wiley.automation.core.util.CommonUtil;
import wiley.automation.wol.impl.SearchImpl;

public class SearchPage extends SearchImpl {
	private String msg;
	private boolean flag = false; 
	//static Logger log = Logger.getLogger(SearchPage.class);
	private final WebDriver driver;
	
	public SearchPage(WebDriver driver) {
        this.driver = driver;

        // Check that we're on the right page.
        if (!"Wiley Online Library".equals(driver.getTitle())) {
            // Alternatively, we could navigate to the login page, perhaps logging out first
            throw new IllegalStateException("This is not the login page");
        }
    }
	
	public boolean searchAllContent( String search , String SearchCond){
		if(search()){
			searchText(search);
			clickonradiobutton(SearchCond);
			clickonSearchButton();
		if(searchResultPage()){
			if(checkcontent(search)){
				clcikonFilterList();
				clickonviewpage();
				return true;
				//ReportUtil.generateHTMLReport("Pass");
			}
			
			return false;
			//ReportUtil.generateHTMLReport("Fail");
			}	
		}
		return false;
	
	}
	
	public boolean searchHomePage( String search , String SearchCond){
		if(search()){
			searchText(search);
			clickonradiobutton(SearchCond);
			clickonSearchButton();
		if(searchResultPage()){
			if(checkcontent(search)){
				return true;
				//ReportUtil.generateHTMLReport("Pass");
			}
			
			return false;
			//ReportUtil.generateHTMLReport("Fail");
			}	
		}
		return false;
	
	}
		
	public void clickOnAbstractLink(String searchterm, int i) {
		// TODO Auto-generated method stub
		if(searchResultPage()){
			if(checkcontent(searchterm)){
				clickOnAbstractLink(i);
			}
		}
	}
	
	public void clickOnArticlePDFLink(String searchterm, int i) {
		// TODO Auto-generated method stub
		if(searchResultPage()){
			if(checkcontent(searchterm)){
				clickOnArticlePDFLink(i);
			}
		}
	}
	
	public PPVPage PPVPage() {
		return PageFactory.initElements(driver, PPVPage.class);
	}
	
	//---------------------------------------------------------------------------------------------
	
	public boolean createItem(String method){
		return singleCardItemCreateItem();
	}
	
	public boolean createItemInfo(String title,String unique,String method,String PromptHTML,String SkillsAnalysisLabel,String Pronunciation,String Alwayshidetheitem,String Uselabelasbuttontext,String ScoreCount,String Score1,String Label1,String Score2,String Label2,String Score3,String Label3,String Score4,String Label4,String OverlayButton,String OverlayButtonLabel, String OverlayButtonHeader,String SectionCount,String OverlayButtonSection1,String OverlayButtonSection2){
		if(createItem(method)){
			if(CommonUtil.isDisplayed(scoringmethodropdown)){
	
				selectScoringMethod(method);
			}
			if(ClickonTabList("Item Info")){
				enterTitleAndUniqueQuestion(title,unique);
						}
			if(ClickonTabList("Scoring Method")){
				if(changeScoringMethod(method,PromptHTML, SkillsAnalysisLabel, Pronunciation, Alwayshidetheitem, Uselabelasbuttontext, ScoreCount, Score1, Label1, Score2, Label2, Score3, Label3, Score4,Label4, OverlayButton, OverlayButtonLabel,  OverlayButtonHeader,SectionCount, OverlayButtonSection1, OverlayButtonSection2)){
					return true;
				}
				
			}
		}
		return false;
	}
	
	public boolean updateItemInfo(String method,String PromptHTML,String SkillsAnalysisLabel,String Pronunciation,String Alwayshidetheitem,String Uselabelasbuttontext,String ScoreCount,String Score1,String Label1,String Score2,String Label2,String Score3,String Label3,String Score4,String Label4,String OverlayButton,String OverlayButtonLabel, String OverlayButtonHeader,String SectionCount,String OverlayButtonSection1,String OverlayButtonSection2){
			if(ClickonTabList("Scoring Method")){
				if(updateScoringMethod(method,PromptHTML, SkillsAnalysisLabel, Pronunciation, Alwayshidetheitem, Uselabelasbuttontext, ScoreCount, Score1, Label1, Score2, Label2, Score3, Label3, Score4,Label4, OverlayButton, OverlayButtonLabel,  OverlayButtonHeader, SectionCount, OverlayButtonSection1, OverlayButtonSection2)){
					return true;
				}
				
			}
		return false;
	}
	
	public boolean saveandPreview(){
		if(ClickonTabList("Scoring Method")){
			return saveAndPreview();
		}
		return false;
			}
	
	public boolean clsaveandPreview(){
		if(ClickonTabList("Scoring Method")){
			return clsaveAndPreview();
		}
		return false;
			}
	
	
	
	
	
	public void readSingleCardItemValue(){
		if(ClickonTabList("Scoring Method")){
		readSingleCardItem();
		}
	}
	
	public void readSingleCardItemValueCulturalBkgd(){
		if(ClickonTabList("Scoring Method")){
		readSingleCardItemCulturalBkgd();
		}
	}
	
	
	public boolean changeScoringMethod(String method,String PromptHTML,String SkillsAnalysisLabel,String Pronunciation,String Alwayshidetheitem,String Uselabelasbuttontext,String ScoreCount,String Score1,String Label1,String Score2,String Label2,String Score3,String Label3,String Score4,String Label4,String OverlayButton,String OverlayButtonLabel, String OverlayButtonHeader,String SectionCount,String OverlayButtonSection1,String OverlayButtonSection2){
		String mtd;
		mtd = method.replaceAll(" ", "_");
		
		switch (mtd) {      
		  case "Single_Card_Items":
			  flag = selectScoringMethod(method);
		  		if(flag){
		  			boolean sincardStatus = sinCarItm(method,PromptHTML, SkillsAnalysisLabel, Pronunciation, Alwayshidetheitem, Uselabelasbuttontext, ScoreCount, Score1, Label1, Score2, Label2, Score3, Label3, Score4,Label4, OverlayButton, OverlayButtonLabel,  OverlayButtonHeader,SectionCount, OverlayButtonSection1, OverlayButtonSection2);
		  			return sincardStatus;
		  		}
              break;
              
		

		}
		return false;
 } 
	
	public boolean verifyCreatePage(String TestLevel,String SubTestLevel,String ItemGroupLevel,String ItemLevel,String Title){
		return verifySingleCardItemClikablePage(TestLevel,SubTestLevel,ItemGroupLevel,ItemLevel,Title);
	}
	
	public boolean errorPopUp(){
		return errorHandlePopUp();
		
	}

	public void selectAllCheckBoxSearchResult() {
		// TODO Auto-generated method stub
		super.selectAllCheckBoxSearchResult();
	}



	
	
}



*/