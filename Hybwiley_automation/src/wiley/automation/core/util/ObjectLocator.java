package wiley.automation.core.util;

import org.openqa.selenium.By;


public class ObjectLocator extends ObjectRepository {
	
	// Home Page
	public By wileyOnlineLibaryImage = By.xpath(wileyOnlineLibaryImageXpath);
	
	// Search 
	public By searchText = By.id(searchTextXpath);
	public By allcontent = By.id(allcontentXpath);
	public By searchButton = By.id(searchButtonXpath);
	public By searchResultPage = By.xpath(searchResultPageXpath);
	public By publicationLink = By.xpath(publicationLinkXpath);
	
	
	//Search Result Page
	public By journalFilterList = By.xpath(journalFilterListXpath);
	public By booksFilterList = By.xpath(booksFilterListXpath);
	public By referenceWorkFilterList = By.xpath(referenceWorkFilterListXpath);
	public By bookSeriesFilterList = By.xpath(bookSeriesFilterListXpath);
	public By databaseFilterList = By.xpath(databaseFilterListXpath);
	public By labprotocolFilterList = By.xpath(labprotocolFilterListXpath);
	public By reomvoeFilter = By.xpath(reomvoeFilterXpath);
	public By refworkFilterListNoLink = By.xpath(refworkFilterListNoLinkXpath);
	

	public By view120 = By.xpath(view120Xpath);
	public By view2140 = By.xpath(view2140Xpath);
	public By view4160 = By.xpath(view4160Xpath);
	public By view6180 = By.xpath(view6180Xpath);
	public By viewnext = By.xpath(viewnextXpath);
	public By viewprev = By.xpath(viewprevXpath);
	
	public By Contenttype = By.xpath(ContenttypeXpath);
	public By Contentvalue = By.xpath(ContentvalueXpath);
	public By noResult = By.xpath(noresultfoundXpath);

	
	
	//Login Page
    public static By usernameLocator = By.xpath(UserName_xpath);
    public static By passwordLocator = By.xpath(Password_xpath);
    public By logout = By.xpath(logout_xpath);
    public static By loginButtonLocator = By.xpath(Login_xpath);
    public By loginoverlay = By.xpath(loginoverlay_xpath);
    public static By loginchecker=By.xpath(loginchecker_xpath);
    public static By usernameLocator1 = By.xpath(UserName_xpath1);
  
    //Journal Page
    
    public By JournalTools = By.xpath(JournalToolsxpath);
    public By AALink = By.xpath(AALinkxpath);
    public By RequestPermissionLink = By.xpath(RequestPermissionLinkxpath);
    public By requestpermissionSearchresult = By.xpath(requestpermissionSearchresultxpath);
    public By selectcheckboxsearchresult = By.xpath(selectcheckboxsearchresultxpath);
    public By savetoprofilebtn = By.xpath(savetoprofilebtnxpath);
    public By savetomyprofile = By.xpath(savetomyprofilexpath);
    public static By clickupdate = By.xpath(clickupdatexpath);
    
    
    //Myprofile
    
    public static By myprofilelink = By.xpath(myprofilelinkxpath);
    public static By myprofilelinkcheck = By.xpath(myprofilelinkcheckxpath);
    public By savedarticles = By.xpath(savedarticlesxpath);
    public By selectAllCheckBox = By.xpath(selectAllCheckBoxxpath);
    public By deletearticlebtn = By.xpath(deletearticlebtnxpath);
    public By requestpermissioninmyprofile = By.xpath(requestpermissioninmyprofilexpath);
    public static By checkmyaccount = By.xpath(checkmyaccountxpath);
    public By savedpublications = By.xpath(savedpublicationsxpath);
    public By referenceworkinmyprofile = By.xpath(referenceworkinmyprofilexpath);
    public By deletepublicationbtn = By.xpath(deletepublicationbtnxpath);
    public By subscriptionaccesslink = By.xpath(subscriptionaccesslinkxpath);
    public By subscriptionaccesscustid = By.xpath(subscriptionaccesscustidxpath);
    public By subscriptionaccessaccesscode = By.xpath(subscriptionaccessaccesscodexpath);
    public By subscriptionsubmit = By.xpath(subscriptionsubmitxpath);
    
    //Arka
    //Literatum Homepage
    public static By homepagemove= By.xpath(homepagemovexpath);
    public static By checkFeatured= By.xpath(checkFeaturedxpath);
    public static By checkImagesrc= By.xpath(checkImagesrcxpath);
    public static By browseBysubject= By.xpath(browseBysubjectxpath);
    public static By checksubjectlist= By.xpath(checksubjectlistxpath); 
    public static By searchvalue= By.xpath(searchvaluexpath); 
    public static By searchsubmit= By.xpath(searchsubmitxpath); 
    public static By checkthevalue= By.xpath(checkthevaluexpath);  
    public static By countthevalue= By.xpath(countthevaluexpath); 
    public static By clickIucr= By.xpath(clickPublicationxpath); 
    public static By clickIcurContent= By.xpath(clickIcurContentxpath);
    
    
    
    //Literatum Journal Homepage
    public static By clickJournal= By.xpath(clickJournalxpath);
    public static By checkJournal= By.xpath(checkJournalxpath);
    public static By clickJournalTitle= By.xpath(clickJournalTitlexpath);
    public static By issueFirstPublishDate= By.xpath(issueFirstPublishDatexpath);
    public static By homepagemovejournal= By.xpath(homepagemovejournalxpath);
    public static By checkmetadaISSN= By.xpath(checkmetadaISSNxpath);
    public static By checksubject= By.xpath(checksubjectxpath);
    public static By searchtextbox = By.id(searchtextboxid);
    public static By searchtextbox1 = By.id(searchtextboxid1);
    public static By SearchDropDownValue = By.className(SearchDropDownValueclassName);
    public static By autosuggestionbox = By.id(autosuggestionboxid);
    public static By autosuggestionboxelement = By.xpath(autosuggestionboxelementxpath);
    public static By clickvolumeissue= By.xpath(clickvolumeissuexpath);
    public static By checkvolumeissue= By.xpath(checkvolumeissuexpath);
    public static By clickissuerange= By.xpath(clickissuerangexpath);
    public static By checkissueyear= By.xpath(checkissueyearxpath);
    public static By clcikbrowsearticle= By.xpath(clcikbrowsearticlexpath);
    public static By clickAllIssues1= By.xpath(clickAllIssuesxpath);
    public static By clickAllIssues= By.cssSelector(clickAllIssuescss);
    public static By clickVolume= By.xpath(clickVolumexpath);
    public static By scrollPage= By.xpath(scrollPagexpath);
    public static By clickFullText= By.xpath(clickFullTextxpath);
    public static By journalname= By.xpath(journalnamexpath);
    public static By advSearchLink = By.className(advSearchLinkclassName);
    public static By advSearchTextBox1 = By.id(advSearchTextBox1xpath);
    public static By advsearchsearchoption = By.id(advsearchsearchoptionid);
    public static By submitButton = By.xpath(submitButtonclass);
    public static By submitButtonHome = By.className(submitButtonhome);
    public static By selectclick = By.className(selectclickclass);
    public static By advSearchLinkheader = By.partialLinkText(advSearchLinkheaderText);
    public static By citationSearchLinkheader = By.partialLinkText(citationSearchLinkheaderText);
    public static By citationSearchTextBox1 = By.name(citationSearchTextBox1name);
    public static By citationYearTextBox = By.name(citationYearTextBoxname);
    public static By citationVolumeTextBox = By.name(citationVolumeTextBoxname);
    public static By citationIssueTextBox = By.name(citationIssueTextBoxname);
    public static By CitationSearchPageValues = By.className(CitationSearchPageValuesclassName);
    public static By submitButtonCitation = By.xpath(submitButtonCitationclass);
    public static By SaveSearchOption = By.id(SaveSearchOptionid);
    public static By SaveSearchPopup = By.id(SaveSearchPopupid);
    public static By SaveSearchLoginOption = By.xpath(SaveSearchLoginOptionXpath);
    public static By searchItem = By.xpath(searchItemClass);
    public static By pdfLink = By.partialLinkText(pdfLinkText);
    public static By clickbook= By.xpath(clickBookxpath);
    public static By checkbook= By.xpath(checkBookxpath);
    
    
    
    
    
    // MRW Homepage
    public static By checkHomeTab= By.cssSelector(checkHomeTabid);
    public static By checkAboutTab= By.cssSelector(checkAboutTabid);
    public static By checkTOCTab= By.xpath(checkTOCTabid);
    public static By checkBBTTab= By.xpath(checkBBTTabid);
    public static By checkBAZTab= By.xpath(checkBAZTabid);
    public static By checkShareTab= By.cssSelector(checkShareTabid);
    public static By checkShareTabvalue= By.xpath(checkShareTabvalueid);
    //Literatum Abstract Page
    public static By clickAbstract= By.xpath(clickAbstractxpath);
    public static By checkAbstract= By.xpath(checkAbstractxpath);
    public static By clickBeforeAbstract= By.xpath(clickBeforeAbstractxpath);
    public static By checkTheAuthor1= By.xpath(checkTheAuthorxpath1);
    public static By checkTheAuthor2= By.xpath(checkTheAuthorxpath2);
    public static By checkMultilingual= By.xpath(checkMultilingualid);
    public static By clickonArticleLink= By.xpath(clickonArticleLinkclass);
    public static By BookHomeTOCtext = By.xpath(BookHomeTOCtextXpath);
    public static By JournalArticleLink = By.xpath(JournalArticleLinkxpath);
    public static By clickonArticleLink1= By.xpath(clickonArticleLinkclass1);
    
    
    //Literatum Book Chapter
    public static By clickBook1= By.xpath(clickBooktxpath);
    public static By checkBook1= By.xpath(checkBooktxpath);
    public static By clickonABook= By.xpath(clickonABookxpath);
    public static By checkmetadaISBN= By.xpath(checkmetadaISBNxpath);
    public static By clickonAchapter= By.xpath(clickonAchapterxpath);
    public static By checkchaptersection= By.xpath(checkchaptersectionxpath);
    public static By tableofcontent= By.xpath(tableofcontentxpath);
    
    //Literartum About this book
    public static By checkcontent= By.className(checkcontentclass);
    public static By checkshow= By.id(checkshowid);
    public static By checkshowallcontentsection= By.xpath(checkshowallcontentsectionxpath);
    
    //Literatum Book Search page
    public static By clicksearchbox= By.id(clicksearchboxid);
    public static By clicksearchdropdown= By.className(clicksearchdropdownclass);
    public static By clicksearchvalue= By.id(clicksearchvalueid);
    public static By checksearchbox= By.id(checksearchboxxpath);
    public static By searchsubmitbutton= By.xpath(searchsubmitbuttonxpath);
    public static By clickoutside= By.className(clickoutsidexpath);
    public static By clicksearchnewbox= By.id(clicksearchnewboxcss);
    
	//Readcube Page
    public static By ShareLinkArticle = By.id(ShareLinkArticleId);
    public static By ReadcubeSharing = By.xpath(ReadcubeSharingXpath);
	
   // clicksearchnewbox
    // Cochrane
    
    public By SearchTermField = By.xpath(SearchTermFieldxpath);
    
  //*[@id='pane-67065c09-4a88-49cd-934c-ac707951d35c1']/form/button
  //DSS
    public static By DSSUser = By.name(DSSUserName);
    public static By DSSPassword = By.name(DSSPasswordName);
    public static By button_login = By.className(button_login_class);
    public static By SearchBox = By.xpath(SearchBox_class);
    public static By SearchBtn = By.xpath(SearchBtn_xpath);
    public static By LogOut = By.linkText(LogoutLink);
    public static By TitleText = By.xpath(TitleTextXpath);
    public static By textAreaValue = By.tagName(textAreaValueTag);
    public static By Check_content_items = By.xpath(Check_content_items_xpath);
    public static By select_option = By.tagName(select_option_Tag);
    public static By Ignore_validation = By.xpath(Ignore_validation_ID);
    public static By Use_license_priority = By.xpath(Use_license_priority_ID);
    public static By Literatum_Issue_Test = By.xpath(Literatum_Issue_Test_xpath);
    public static By Deliver_btn = By.id(Deliver_btn_id);
 
    
    public static By checkrownumber = By.xpath(checkrownumber_xpath);
}
