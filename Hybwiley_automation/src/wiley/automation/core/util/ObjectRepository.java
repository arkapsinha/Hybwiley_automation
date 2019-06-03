package wiley.automation.core.util;

import org.openqa.selenium.By;


public class ObjectRepository extends VariableController{

	// Home Page 
	public String wileyOnlineLibaryImageXpath = "//*[@id='header']/div[2]/div/h1/a/img";
	
	
	// Search Item 
	
	public String searchTextXpath = "searchText";
	public String allcontentXpath = "searchAllContent";
	public String searchButtonXpath = "searchSiteSubmit";
	public String searchResultPageXpath = "//*[@id='searchResults']/div[1]/h1";
	public String publicationLinkXpath = "//*[@id='globalMenu']/div/ul/li[1]/a";
	
	//Search Result Page
	public String journalFilterListXpath = "//*[@id='pubtype-facet']/li[1]/a";
	public String booksFilterListXpath = "//*[@id='pubtype-facet']/li[2]/a";
	public String referenceWorkFilterListXpath = "//*[@id='pubtype-facet']/li[3]/a";
	public String bookSeriesFilterListXpath = "//*[@id='pubtype-facet']/li[4]/a";
	public String databaseFilterListXpath = "//*[@id='pubtype-facet']/li[5]/a";
	public String labprotocolFilterListXpath ="//*[@id='pubtype-facet']/li[6]/a";
	public String reomvoeFilterXpath = "//*[@id='pubtype-facet']/li[7]/a";
	public String refworkFilterListNoLinkXpath = "//*[@id='pubtype-facet']/li[3]";
	
	
	public String view120Xpath =  "//*[@id='searchResultsList']/div[1]/ol/li[1]/a";
	public String view2140Xpath =  "//*[@id='searchResultsList']/div[1]/ol/li[2]/a";
	public String view4160Xpath = "//*[@id='searchResultsList']/div[1]/ol/li[3]/a";
	public String view6180Xpath =  "//*[@id='searchResultsList']/div[1]/ol/li[4]/a";
	public String viewnextXpath =  "//*[@id='searchResultsList']/div[1]/ol/li[5]/a";
	public String viewprevXpath =  "//*[@id='searchResultsList']/div[1]/ol/li[1]/a";
	
	
	public String noresultfoundXpath = "//*[@id='searchResultsList']/p";
	public String ContentvalueXpath = "//*[@id='searchedForText']/em[1]";
	public String ContenttypeXpath = "//*[@id='searchedForText']/em[2]";

	//Publicatin A-Z		
	public String journalFilterLista2zXpath = "//*[@id='filterLists']/ul/li[1]/a";
	public String booksFilterLista2zXpath = "//*[@id='filterLists']/ul/li[2]/a";
	public String refworkFilterLista2zXpath = "//*[@id='filterLists']/ul/li[3]/a";
	public String bookSeriesFilterLista2zXpath = "//*[@id='filterLists']/ul/li[4]/a";
	public String databaseFilterLista2zXpath = "//*[@id='filterLists']/ul/li[5]/a";
	public String labprotocolFilterLista2zXpath ="//*[@id='filterLists']/ul/li[6]/a";
	public String reomvoeFiltera2zXpath = "//*[@id='filterLists']/ul/li[7]/a";
	
	
	
	//Login Page
	
	public static String UserName_xpath = "//input[@id='login']";
	public static String Password_xpath = "//*[@id='password']";
	//public String Remember_me_xpath = "//*[@id='login']/div/form/p[3]/input";
	public static String Login_xpath = "//input[@name='submit']";
	public String loginoverlay_xpath = "//*[@id='header']/div[2]/div/div[1]/a/i";
	public static String loginchecker_xpath = "//a/span[2]";
	public String logout_xpath = "//*[@id='loggedIn']//a[contains(text(), 'Log Out')]";
	public static String UserName_xpath1 = "//input[@id='login']";

	//Journal Page
	
	public static String JournalToolsxpath = "//*[@id='pageNavAndTools']/div[1]/h2";
	public static String AALinkxpath = "//*[@id='acceptedArticlesLink']";
	public static String RequestPermissionLinkxpath = "//*[@id='promosAndTools']//a[.='Request Permissions']";
	public static String requestpermissionSearchresultxpath = "//*[@id='searchResultsList']/ol//a[.='Request Permissions']";
	public static String myprofilelinkxpath = "//*[@id='indivLogin']/span[2]";
	public static String myprofilelinkcheckxpath = "//a[contains(text(),'My account')]";
	public static String savedarticlesxpath = "//*[@id='savedItemsAndAlerts']//a[contains(text(), 'Saved Articles')]";
	public static String selectAllCheckBoxxpath = "//*[@id='selectAllTop']";
	public static String deletearticlebtnxpath = "//*[@id='savedArticlesList']/div[1]/ul/li/input";
	public static String selectcheckboxsearchresultxpath = "//*[@id='option1']";
	public static String savetoprofilebtnxpath = "//*[@id='searchResults']/form/div[1]/ul[1]/li[1]/input";
	public static String requestpermissioninmyprofilexpath = "//*[@id='savedArticlesList']/ol/li//a[.='Request Permissions']";
	public static String checkmyaccountxpath = "//*[@class=' col-sm-6 gutterless ']";
	public static String savetomyprofilexpath = "//*[@id='folder']";
	public static String savedpublicationsxpath = "//*[@id='savedItemsAndAlerts']//a[contains(text(), 'Saved Publications')]";
	public static String referenceworkinmyprofilexpath = "//*[@id='publications']//span[contains(text(), 'REFERENCE WORK')]";
	public static String deletepublicationbtnxpath = "//*[@id='savedPublicationsList']/div[1]/ul/li/input";
	public static String subscriptionaccesslinkxpath = "//a[contains(text(), 'Subscription Access')]";
	public static String subscriptionaccesscustidxpath = "//*[@id='customerId']";
	public static String subscriptionaccessaccesscodexpath = "//*[@id='accessCode']";
	public static String subscriptionsubmitxpath = "//*[@id='subscriptionAccess']/form/input";
	public static String clickupdatexpath= "//input[@value='UPDATE']";
	
	//literatumhomepage
	public static String homepagemovexpath = "//img[@alt='Wiley Online Library']";
	public static String checkFeaturedxpath = "//*[@class='pageBody']//section[3]//h4";
	
	//public static String checkImagesrcxpath = "//*[@id='pb-page-content']/div/div[7]/div/div/section[3]/div/div/div/div[2]/div[1]/div/div/div[1]/img";
	public static String checkImagesrcxpath = "//*[@class='pageBody']//section[3]//img";
	//public static String browseBysubjectxpath = "//*[@id='pb-page-content']/div/div[7]/div/div/section[1]/div/section/div/div/div/section/h2/span";
	public static String browseBysubjectxpath = "//*[@class='pageBody']//section[2]//h4";
	public static String checksubjectlistxpath = "//*[@class='accordion']/ul/li[1]/a";
	public static String searchvaluexpath = "//*[@id='searchField1']";
	public static String searchsubmitxpath = "//*[@ class='main-search-field-wrapper']/form/button";
	public static String checkthevaluexpath = "//*[@class='search__result search__result--space']/span[3]";
	public static String countthevaluexpath = "//*[@class='search__result search__result--space']/span[1]";
											   //*[@id='pb-page-content']/div/div[6]/div/div/div/div/div/div/div[2]/div/div/div[1]/div[1]/div[1]/span[1]
	
	public static String clickPublicationxpath= "(//a[@id='facetList-0']/span)[193]";
	public static String clickIcurContentxpath= "//*[@id='filter']/div[4]/div/ul/li/ul/li/a/span[1]";
	public static String journalnamexpath = "//*[@id='atl']/h2/span/i";
	// Literatum Jounral Homepage
	public static String clickJournalxpath = "//*[@class='homepage-search-headings']/div/div/div/div[1]/a";
	public static String checkJournalxpath = "//*[@class='search-result showPublications']/ul/li[1]/div/div[1]/span[1]";
	public static String clickJournalTitlexpath = "//*[@class='search-result showPublications']/ul/li[1]/div/h3/a";
	public static String issueFirstPublishDatexpath = "//*[@id='pb-page-content']/div/div[8]/div/div/div[1]/section/div/div/div[2]/ul/li/div[2]/div/span";
	public static String homepagemovejournalxpath = "//img[@alt='Wiley Online Library']";
	public static String checkmetadaISSNxpath = "//*[@class='journal-info-container col-md-8']/div[2]/div";
	public static String checksubjectxpath = "//*[@id='filter']/div[3]/a/h4";
	public static String searchtextboxid = "searchField0";
	public static String searchtextboxid1 = "searchField1";
	public static String SearchDropDownValueclassName = "dropBlock";
	public static String autosuggestionboxid = "ui-id-1";
	public static String autosuggestionboxelementxpath = "//*[@id='ui-id-1']//span";
	public static String clickvolumeissuexpath= "//*[@id='pane-47d7f162-6ab4-45a3-8f7c-7a3f66e0068e11con']";
	public static String checkvolumeissuexpath= "//*[@id='pane-47d7f162-6ab4-45a3-8f7c-7a3f66e0068e11']/ul/li[1]/div[2]/h4/a";
	public static String advSearchLinkclassName = "advanced-search-link";
	public static String advSearchTextBox1xpath = "text2";
	public static String advsearchsearchoptionid = "searchArea2";
	public static String submitButtonclass = "//button[contains(text(), 'Search')]";
	public static String submitButtonhome = "btn quick-search__button icon-search";
	public static String selectclickclass = "jcf-select-text";
	public static String advSearchLinkheaderText = "Advanced Search";
	public static String citationSearchLinkheaderText = "Citation Search";
	public static String citationSearchTextBox1name = "quickLinkJournal";
	public static String citationYearTextBoxname = "quickLinkYear";
	public static String citationVolumeTextBoxname = "quickLinkVolume";
	public static String citationIssueTextBoxname = "quickLinkIssue";
	public static String CitationSearchPageValuesclassName = "cover-image__details";
	public static String submitButtonCitationclass = "//button[.='SEARCH']";
	public static String SaveSearchOptionid = "saveSearchTriggerButton";
	public static String SaveSearchPopupid = "saveSearchDialog";
	public static String SaveSearchLoginOptionXpath = "//a[contains(text(), 'login')]";
	public static String searchItemClass = "//*[@class='clearfix separator search__item']";
	public static String pdfLinkText = "PDF";
	
	public static String clickissuerangexpath= "//*[@id='47d7f162-6ab4-45a3-8f7c-7a3f66e0068e']/div/ul/li[9]/div/a/span";
	public static String checkissueyearxpath= "//*[@id='pane-47d7f162-6ab4-45a3-8f7c-7a3f66e0068e02con']/span";
	public static String clcikbrowsearticlexpath= "(//a[@id='main-menu-1-3']/span)[2]";
	//public static String clickAllIssuescss= "#menubar > #menu-item-3 > ul.rlist.dropdown__menu > li.menu-item > a[title='All Issues']";
	public static String clickAllIssuescss= "a[title='All Issues']";
	public static String clickAllIssuesxpath= "(//li[@id='menu-item-main-menu-1-3']/ul/li[4]/a/span)[2]";
	public static String clickVolumexpath= "//*[@id='pane-47d7f162-6ab4-45a3-8f7c-7a3f66e0068e01']/ul/li[1]/div[2]/h4[1]/a";
	public static String scrollPagexpath= "//*[@class='cover-image__parent-item']";
	public static String clickFullTextxpath= "//*[@class='card card--light-shadow issue-items-container']/div/div[2]/ul/li[2]/a";
	
	 public static String checkHomeTabid= "a[title='Home'] > span";
	    public static String checkAboutTabid= "#menubar > #menu-item-main-menu-1-1 > #main-menu-1-1 > span";
	    public static String checkTOCTabid= "//li[3]/a/span";
	    public static String checkBBTTabid= "//li[4]/a/span";
	    public static String checkBAZTabid= "//li[5]/a/span";
	    public static String checkShareTabid= "i.icon-Icon_Share";
	    public static String checkShareTabvalueid= "//*[@id='share_Pop']/p";
	    public static String clickBookxpath = "//*[@class='homepage-search-headings']/ul/li[2]/a";
		public static String checkBookxpath = "//*[@class='search-result showPublications']";  
	
	//Literatum Article Page
	public static String clickAbstractxpath = "//*[@id='pane-01cbe741-499a-4611-874e-1061f1f4679e01']/div/div[2]/div[2]/ul/li[1]/a";
	//public static String clickAbstractxpath = "(//a[contains(text(),'Abstract')])[4]";
	public static String checkAbstractxpath = "//*[@id='section-1-n/a']/h3";
	public static String checkTheAuthorxpath1 = "//*[@id='a1_Ctrl']/span";
	public static String checkTheAuthorxpath2 = "//*[@id='a2_Ctrl']/span";
	public static String clickBeforeAbstractxpath = "//*[@id='pane-01cbe741-499a-4611-874e-1061f1f4679e01']/div/div[1]/a/h3/b";
	public static String checkMultilingualid = "//*[@id='section-1-en']/a";
	public static String BookHomeTOCtextXpath = "//*[@class= 'gutterless--xs gutterless--sm gutterless--md main-content col-md-8']";
	public static String JournalArticleLinkxpath = "//a[.='Full text']";
	public static String clickonArticleLinkclass = "//*[@class= 'journal-tabs card card--light-shadow']";
	public static String clickonArticleLinkclass1 = "//*[@class= 'publication-list__item' or @class= 'issue-item']";
	
	//Literatum Book Chapter
	public static String clickBooktxpath = "//*[@class='homepage-search-headings']/div/div/div/div[3]/a";
	public static String checkBooktxpath = "//*[@class='search-result showPublications']/ul/li[1]/div/div[1]/span[1]";
	public static String clickonABookxpath = "//*[@class='search-result showPublications']/ul/li[1]/div/h3/a";
	public static String checkmetadaISBNxpath = "//*[@class='journal-info-container col-md-8']/div[2]/div[3]/span[6]";
	public static String clickonAchapterxpath = "//*[@class='gutterless--xs gutterless--sm gutterless--md main-content book-toc-content col-md-8']/div/div[3]/div[2]/div/a/h5";
	public static String tableofcontentxpath = "//*[@class='gutterless--xs gutterless--sm gutterless--md main-content book-toc-content col-md-8']/div/div[2]/h4";
	public static String checkchaptersectionxpath = "//*[@class='article-citation']/div/h2";
	
	
	//Literatum about this book
	
	public static String checkcontentclass = "aboutBook";
	public static String checkshowid= "read-more";
	public static String checkshowallcontentsectionxpath = "//*[@class='gutterless--xs gutterless--sm gutterless--md main-content book-toc-content col-md-8']/div/div[1]/div/ul/li[1]";
	
	//Readcube 
	
	public static String ShareLinkArticleId = "share__ctrl";
	public static String ReadcubeSharingXpath = "//*[@class='readCube-sharing']/a";
	
	//Literatum book search box
	public static String clicksearchboxid= "searchField0";
	public static String clicksearchdropdownclass = "dropBlock";
	public static String clicksearchvalueid= "pane-67065c09-4a88-49cd-934c-ac707951d35c1-con";
	public static String checksearchboxxpath = "//div[@classname= 'dropBlock']/a/span";
	public static String searchsubmitbuttonxpath ="(//button[@type='submit'])[2]";
	public static String clickoutsidexpath= "page-header";
	
	//public static String clicksearchnewboxcss= "div.input-group.option-1 > #searchField";
	public static String clicksearchnewboxcss= "searchField1";
	// Cochrane
	
	public static String SearchTermFieldxpath = "//*[@id='search_query']";
	
	/*-----------------------------------------------------------------------------*/
	// Home Page
	public String Logout_xpath = "//*[@class='user-controls']/a/div";
	public String countoflink_xpath = "//*[@id='navTree']/div[2]/ul/li";
	public String testlevelxpath = "//*[@class='edit_area']/h3/a[1]";
	public String subtestlevelxpath = "//*[@class='edit_area']/h3/a[2]";
	public String itemLevelxpath = "//*[@class='content-tool-right-content']/div/div/h3/a[4]";
	public String itemGroupxpath = "//*[@class='edit_area']/h3/a[3]";
	public String itemxpath1 ="//*[@class='edit_area']/h3/a[4]";
	public String itemxpath2 = "//*[@class='edit_area trial_edit_page']/h3/a[4]";
	public String trialxpath = "//*[@class='edit_area trial_edit_page']/h3/a[5]";
	
	
	//DSS
	public static String DSSUserName = "j_username";
	public static String DSSPasswordName = "j_password";
	public static String button_login_class = "loginButton";
	public static String SearchBox_class = "//*[@class='panel-body']/table//tr//input";
	public static String SearchBtn_xpath = "//*[@value='Search']";
	public static String LogoutLink = "LOGOUT";
	public static String TitleTextXpath = "//*[@class='container-fluid']/table//tr/td[2]";
	public static String textAreaValueTag = "textarea";
	public static String Check_content_items_xpath = "//*[@value='Check content items']";
	public static String select_option_Tag = "select";
	public static String Ignore_validation_ID = "//ul[@class='list-group']/li/div";
	public static String Use_license_priority_ID = "(//ul[@class='list-group'])[2]/li/div";
	public static String Literatum_Issue_Test_xpath = "(//input[@type='checkbox'])[8]";
	public static String Deliver_btn_id = "deliverBtn";
	public static String checkrownumber_xpath = "//*[@id='striped']/tbody/tr";
	

}



