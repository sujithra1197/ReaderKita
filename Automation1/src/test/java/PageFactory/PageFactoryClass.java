package PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageFactoryClass {
	// Constructor to initialize the page elements
		public PageFactoryClass(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}



		@FindBy(id="id_navbar_moreoptions")
		public WebElement options;
		@FindBy (id="id_navbar_moreoptions_signin")
		public WebElement signin;
		@FindBy(xpath="//img[@alt=\"Sign in with Google\"]")
		public WebElement googlesign;
		@FindBy(xpath="//input[@id=\"identifierId\"]")
		public WebElement googleusername;
		@FindBy(xpath= "//span[text()='Next']")
		public WebElement next;
		@FindBy(xpath= "//input[@type=\"password\"]")
		public WebElement password ;
		@FindBy(xpath= "//span[text()='Next']")
		public WebElement passwordnext;
		@FindBy(xpath= "//span[text()='Continue']")
		public WebElement Continue ;
		@FindBy(id="id_navbar_moreoptions")
		public WebElement options2;
		@FindBy (xpath= "//button[@id=\"id_navbar_moreoptions_advanced\"]")
		public WebElement advancedoptions;
		@FindBy (id="id_frmImportSession")
		public WebElement choosefile;
		@FindBy (id="id_config_import")
		public WebElement upload;
		@FindBy (xpath="//button[text()='Yes']")
		public WebElement yes;
		@FindBy(id="id_navbar_connect")
		public WebElement connect;
		@FindBy (xpath="//button[@mattooltip=\"Text Format\"]")
		public WebElement textformat ;
		@FindBy (xpath="//mat-slider[@role=\"slider\"]")
		public WebElement slider;
		@FindBy (xpath="//div[text()=' Noto Serif ']")
		public WebElement nototext ;
		@FindBy (xpath="//div[text()=' Merriweather ']")
		public WebElement merriweather ;
		@FindBy (xpath="//div[text()=' Open Sans Regular ']")
		public WebElement opensansregular ;
		@FindBy (xpath="//div[text()= ' Default ']")
		public WebElement defaulttext ;
		@FindBy (xpath="//div[text()=  ' Roboto ']")
		public WebElement roboto ;
		@FindBy (xpath="//div[text()='Layout']")
		public WebElement layout ;
		@FindBy(id="day-mode")
		public WebElement daymode;
		@FindBy(id="mid-mode")
		public WebElement midmode;
		@FindBy(id="night-mode")
		public WebElement nightmode;
		@FindBy (xpath="//button[@aria-label=\"Left Align\"]")
		public WebElement leftalign ;
		@FindBy (xpath="//button[@aria-label=\"Justify Align\"]")
		public WebElement justifyalign ;
		@FindBy (xpath="//button[@aria-label=\"Center Align\"]")
		public WebElement centrealign ;
		@FindBy (xpath="//button[@aria-label=\"Narrow Line Spacing\"]")
		public WebElement narrowline ;
		@FindBy (xpath="//button[@aria-label=\"Normal Line Spacing\"]")
		public WebElement linespacing ;
		@FindBy (xpath="//button[@aria-label=\"Wide Line Spacing\"]")
		public WebElement wideline ;
		@FindBy (xpath="//button[@aria-label=\"Margin Wide\"]")
		public WebElement marginwide ;
		@FindBy (xpath="//button[@aria-label=\"Margin Normal\"]")
		public WebElement marginnormal;
		@FindBy (xpath="//button[@aria-label=\"Margin Narrow\"]")
		public WebElement marginnarrow ;
		@FindBy (xpath="//button[@aria-label=\"Reset Font Setting\"]")
		public WebElement rest ;
		@FindBy (xpath="//button[@mattooltip=\"Text Format\"]")
		public WebElement textformatreturn ;
		@FindBy (xpath="//button[@aria-label=\"Table of Contents (Alt + C)\"]")
		
	// toc fetching specific datas from list
		
		public WebElement toc ;
		@FindBy (xpath="(//div[@class=\"toc-content-list ng-star-inserted\"]/ul/li)[1]")
		public WebElement toc1 ;
		@FindBy (xpath="(//div[@class=\"toc-content-list ng-star-inserted\"]/ul/li)[5]")
		public WebElement toc5 ;
		@FindBy (xpath="(//div[@class=\"toc-content-list ng-star-inserted\"]/ul/li)[8]")
		public WebElement toc8 ;
		@FindBy (xpath="(//div[@class=\"toc-content-list ng-star-inserted\"]/ul/li)[12]")
		public WebElement toc12 ;
		@FindBy (xpath="(//div[@class=\"toc-content-list ng-star-inserted\"]/ul/li)[6]")
		public WebElement toc6 ;
		@FindBy (xpath="//button[@aria-label=\"Table of Contents (Alt + C)\"]")
		public WebElement tocreturn ;
		@FindBy(xpath="//button[text()='Yes']")
		public WebElement lastaccessedpage;
		@FindBy(id="nextChapter")
		public WebElement nextchapter1;
		@FindBy(id="previousChapter")
		public WebElement previouschapter1;
		@FindBy(id="previousChapter")
		public WebElement previouschapter2;
		@FindBy (xpath="//mat-icon[@mattooltip=\"Author Info\"]")
		public WebElement authorinfo;
		//Scroll functionality
		@FindBy (xpath="(//div[text()=' Summary: ']//following::span)[2]")
		public WebElement authorinfoscrolldown;
		@FindBy (xpath="//div[text()=' Source: ']")
		public WebElement authorinfoscrollup;
		@FindBy (xpath="//mat-icon[@class=\"mat-icon notranslate close-icon material-icons mat-icon-no-color\"]")
		public WebElement closebutton;
		//search functionality
		@FindBy (xpath="//button[@id=\"Search\"]")
		public WebElement search;
		@FindBy (id="searchinput")
		public WebElement searchinput;
		@FindBy (xpath ="(//mat-list[@class=\"mat-list mat-list-base ng-star-inserted\"]/mat-list-item/div)[1]")
		public WebElement searchinput1;
		@FindBy (xpath ="(//mat-list[@class=\"mat-list mat-list-base ng-star-inserted\"]/mat-list-item/div)[2]")
		public WebElement searchinput2;
		@FindBy (xpath ="(//mat-list[@class=\"mat-list mat-list-base ng-star-inserted\"]/mat-list-item/div)[3]")
		public WebElement searchinput3;
		@FindBy (xpath ="(//mat-list[@class=\"mat-list mat-list-base ng-star-inserted\"]/mat-list-item/div)[4]")
		public WebElement searchinput4;
		@FindBy (id="searchinput")
		public WebElement searchinputalice;
		@FindBy (xpath ="(//mat-list[@class=\"mat-list mat-list-base ng-star-inserted\"]/mat-list-item/div)[7]")
		public WebElement searchinput5;
		@FindBy (xpath ="(//mat-list[@class=\"mat-list mat-list-base ng-star-inserted\"]/mat-list-item/div)[8]")
		public WebElement searchinput6;
		@FindBy (xpath ="(//mat-list[@class=\"mat-list mat-list-base ng-star-inserted\"]/mat-list-item/div)[17]")
		public WebElement searchinput7;
		@FindBy (xpath ="(//mat-list[@class=\"mat-list mat-list-base ng-star-inserted\"]/mat-list-item/div)[18]")
		public WebElement searchinput8;
		@FindBy (xpath ="(//mat-list[@class=\"mat-list mat-list-base ng-star-inserted\"]/mat-list-item/div)[27]")
		public WebElement searchinput9;
		@FindBy (xpath ="(//mat-list[@class=\"mat-list mat-list-base ng-star-inserted\"]/mat-list-item/div)[28]")
		public WebElement searchinput10;
		@FindBy (xpath ="(//mat-list[@class=\"mat-list mat-list-base ng-star-inserted\"]/mat-list-item/div)[3]")
		public WebElement searchinput11;
		@FindBy (xpath ="(//mat-list[@class=\"mat-list mat-list-base ng-star-inserted\"]/mat-list-item/div)[4]")
		public WebElement searchinput12;
		@FindBy (xpath ="//mat-icon[@aria-label=\"Cancel\"]")
		public WebElement searchcancelbutton;
		@FindBy (xpath ="//div[@class=\"result-count-block ng-star-inserted\"]")
		public WebElement searchresult;
		@FindBy (xpath ="//div[text()='search result not found']")
		public WebElement searchresultfortext;
		@FindBy (xpath ="(//div[@class=\"list-inner activeChapterBackground\"]/button/span)[1]")
		public WebElement lastaccessedpageconfirmation;
		@FindBy (xpath ="(//body[@page-id=\"6\"]/div/p/kdn//following::i)[1]")
		public WebElement addingnotes;
		@FindBy (xpath = "//button[@aria-label=\"Print Pages\"]")
		public WebElement print;
		@FindBy (xpath = "(//body[@page-id=\"6\"]/div/p/kdn//following::i)[2]")
		public WebElement highlight2;
		@FindBy (xpath="//button[@aria-label=\"Yellow\"]")
		public WebElement yellow ;
		@FindBy (xpath="//button[@aria-label=\"Pink\"]")
		public WebElement pink  ;
		@FindBy (xpath="//button[@aria-label=\"Green\"]")
		public WebElement green ;
		@FindBy (xpath="//button[@aria-label=\"Blue\"]")
		public WebElement blue ;
		@FindBy (xpath="//button[@aria-label=\"Violet\"]")
		public WebElement violet ;
		@FindBy (xpath="(//button[@class=\"context-menu-item btn\"])[4]")
		public WebElement addnote  ;
		@FindBy (xpath="//textarea[@aria-label=\"Include a note\"]")
		public WebElement inserttext ;
		@FindBy(id="saveNotes")
		public WebElement savenotes;
		@FindBy (xpath="//div[@class=\"note-addedat\"]") 	 	 	
		public WebElement notecolor ;
		@FindBy (xpath="//span[@class=\"highlight-class kitaboo-ignore-class\"]")
		public WebElement highlightclick;
		@FindBy(id="Pink")
		public WebElement pinknote ;
		@FindBy(id="Green")
		public WebElement greennote ;
		@FindBy(id="Blue")
		public WebElement blunote ;
		@FindBy(id="Violet")
		public WebElement violetnote ;
		@FindBy(id="104")
		public WebElement Addvocab ;
		@FindBy (xpath="//div[@class=\"note-addedat\"]")
		public WebElement vocabcolors;
		@FindBy(id="Pink")
		public WebElement pinknotevocab ;
		@FindBy(id="Violet")
		public WebElement violetnotevocab ;
		@FindBy(id="Green")
		public WebElement greennotevocab ;
		@FindBy(id="Blue")
		public WebElement blunotevocab;
		@FindBy (xpath="//kdn[text( )='CHAPTER IV.']")
		public WebElement searchfromtext;
		@FindBy(id="deleteNotes")
		public WebElement deletenote ;
		@FindBy (xpath="//span[text( )='Yes, Delete']")
		public WebElement deletehighlightnote;
		@FindBy (xpath="(//span[@class=\"highlight-class kitaboo-ignore-class\"])[2]")
		public WebElement vocabclick;
		@FindBy (xpath="(//span[@name=\"highlight1244_1374\"])[2]")
		public WebElement capterthreehighlightone;
		@FindBy (xpath="(//span[@class=\"highlight-class kitaboo-ignore-class\"])[1]")
		public WebElement scrollfortext;
		@FindBy(id="103")
		public WebElement textsearch ;
		@FindBy(id="800")
		public WebElement highlightdelete ;
		@FindBy (xpath="(//body[@page-id=\"5\"]/div/p/kdn//following::i)[2]")
		public WebElement capterthreehighlightwo;
		@FindBy (xpath="//button[@aria-label=\"Vocabulary Journal\"]")
		public WebElement vocabnote;
		@FindBy (xpath="//div[@class=\"render-setting-expand\"]")
		public WebElement vocabexpand;
		@FindBy (xpath="(//div[@class=\"left-description\"])[1]")
		public WebElement vocabexpandclick;
		@FindBy (xpath="//span[text()='Edit']")
		public WebElement vocabexpandedit;
		@FindBy (xpath="(//button[@class=\"mat-focus-indicator mat-menu-trigger mat-icon-button mat-button-base\"])[1]")
		public WebElement vocabexpandthreedots;
		@FindBy (xpath="(//mat-icon[@class=\"mat-icon notranslate bicon-More-vertical material-icons mat-icon-no-color\"])[1]")
		public WebElement vocabexpandthreedots2;
		@FindBy (xpath="//span[text()='Delete']")
		public WebElement vocabexpanddelete;
		
		
		
		
}
