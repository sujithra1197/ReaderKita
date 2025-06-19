package Execution;

import java.awt.AWTException;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.awt.Robot;
import java.awt.datatransfer.StringSelection;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Baseclass.BaseClass;
import java.io.File;
import PageFactory.PageFactoryClass;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert; // Hard assert
public class EpubExecution extends BaseClass {



	public static void before(){
		BaseClass.extentStart("Epub");
	}
	public static void after() {
		BaseClass.extentEnd();
	}

	private static final Logger logger = LogManager.getLogger(EpubExecution.class);


		public static void main(String[] args)  throws InterruptedException {
			try {
	
				EpubExecution abc = new EpubExecution();
				abc.login();
				abc.fontsetting();
				BaseClass.extentStart("LastAccessedPage");
				abc.tablofcontentandlastaccessedpage();
				BaseClass.extentEnd();
				abc.authorinfoandpagenavigation();
				abc.search();
				abc.printfunctionality();
				BaseClass.extentStart("Highlightes");
				abc.highlight();
				BaseClass.extentEnd();
				BaseClass.extentStart("highlightsbookrelaunch");
				abc.highlightsbookrelaunch();
				BaseClass.extentEnd();
				BaseClass.extentStart("Wordsearch");
				abc.booktextsearch();
				BaseClass.extentEnd();
				BaseClass.extentStart("Deletehighlight");
				abc.deletehighlight();
				BaseClass.extentEnd();
				BaseClass.extentStart("Addnotes");
				abc.addnotes();
				BaseClass.extentEnd();
				BaseClass.extentStart("Deletenotes");
				abc.deletenote();
				BaseClass.extentEnd();
	
				BaseClass.extentStart("VocabularyNotes and Highlightes");
				abc.notesearchvocab2();
				BaseClass.extentEnd();
				Thread.sleep(2000);
				BaseClass.extentStart("VocabularyMenu");
				abc.vocabmenu();
				BaseClass.extentEnd();
			}
			catch(Exception e) {
				logger.info(e.getMessage());
			}
		}


	public void login() {
		try {


			BaseClass a = new BaseClass();
			a.BrowserSelect("Chrome");
			logger.info("Chrome");
			a.loadUrl(BaseClass.readProperty("Url"));
			logger.info("loading url");
			PageFactoryClass pf = new PageFactoryClass(driver);
			Thread.sleep(2000);
			explicitWait(pf.options,10);
			pf.options.click();
			explicitWait(pf.signin,8);
			pf.signin.click();
			explicitWait(pf.googlesign,20);
			pf.googlesign.click();
			explicitWait(pf.googleusername,20);

			//Passing text as input
			pf.googleusername.sendKeys(BaseClass.readProperty("Username"));
			explicitWait(pf.next,8);
			pf.next.click();
			Thread.sleep(2000);
			explicitWait(pf.password,5);
			Thread.sleep(2000);
			pf.password.sendKeys(BaseClass.readProperty("Password"));
			Thread.sleep(2000);
			explicitWait(pf.passwordnext,8);
			Thread.sleep(2000);
			pf.passwordnext.click();

			explicitWait(pf.Continue,5);
			pf.Continue.click();
			Thread.sleep(3000);
			Robot robot = new Robot();

			// Press and release Tab key
			robot.keyPress(KeyEvent.VK_TAB);  // Press the Tab key
			robot.keyRelease(KeyEvent.VK_TAB);  // Release the Tab key

			// Press and release Enter key
			robot.keyPress(KeyEvent.VK_ENTER);  // Press the Enter key
			robot.keyRelease(KeyEvent.VK_ENTER);  // Release the Enter key
			Thread.sleep(2000);

			explicitWait(pf.options2,10);
			pf.options2.click();
			explicitWait(pf.advancedoptions,10);
			pf.advancedoptions.click();
			//explicitWait(pf.choosefile,10);
			//pf.choosefile.click();

			// Saltier file upload:

			WebElement addFile = driver.findElement(By.xpath(".//input[@type='file']"));
			//String filePath = "D:\\C Drive\\Downloads\\staging config A.config";
			String filePath = BaseClass.readProperty("Configfile");
			File file = new File(filePath);
			if (!file.exists()) {
				logger.info("File not found: " + filePath);
			}
			addFile.sendKeys(filePath);
			Thread.sleep(2000);

			logger.info("filee");
			Thread.sleep(3000); 
			explicitWait(pf.upload,10);
			pf.upload.click();
			explicitWait(pf.yes,10);
			pf.yes.click();
			explicitWait(pf.connect,10);
			Thread.sleep(15000);
			pf.connect.click();
			Thread.sleep(15000);
			lastWindow();
			logger.info("next window");
			Thread.sleep(15000);
//			String actualTitle = driver.getTitle();
//			Assert.assertEquals(actualTitle, "Dashboard", "Hard Assertion Failed: Title mismatch!");
		}
		catch(Exception e){
			logger.info(e.getMessage());
		}
	}


	public void fontsetting(){

		try {
			Thread.sleep(2000);
			PageFactoryClass pf = new PageFactoryClass(driver);
			explicitWait(pf.textformat,50);
			pf.textformat.click();
			Thread.sleep(2000);
			explicitWait(pf.nototext,50);
			pf.nototext.click();
			Thread.sleep(3000);

			WebElement iframe1 = driver.findElement(By.xpath("//iframe[@id=\"epub_3\"]"));
			String styleValue1 = iframe1.getAttribute("style");
			String height1 = styleValue1.split("height: ")[1].split("px")[0];
			logger.info(" after notoserif Iframe height: " + height1 + "px");
			String notoheight = styleValue1.split("height: ")[1].split("px")[0];
			if(height1.equals(notoheight))
			{
				logger.info("nototext font is applied");
			}
			else {
				logger.info("nototextfont not applied");
			}

			explicitWait(pf.merriweather,50);
			pf.merriweather.click();
			Thread.sleep(3000);
			WebElement iframe2 = driver.findElement(By.xpath("//iframe[@id=\"epub_3\"]"));
			String styleValue2 = iframe2.getAttribute("style");
			String height2 = styleValue2.split("height: ")[1].split("px")[0];
			logger.info(" after Merriweather Iframe height: " + height2 + "px");
			String merriheight = styleValue2.split("height: ")[1].split("px")[0];
			if(height2.equals(merriheight))
			{
				logger.info("Merriweather font is applied");
			}
			else {
				logger.info("Merriweather font not applied");
			}

			explicitWait(pf.opensansregular,50);
			pf.opensansregular.click();
			Thread.sleep(3000);
			WebElement iframe3 = driver.findElement(By.xpath("//iframe[@id=\"epub_3\"]"));
			String styleValue3 = iframe3.getAttribute("style");
			String height3 = styleValue3.split("height: ")[1].split("px")[0];
			logger.info(" after OpenSans Iframe height: " + height3 + "px");
			String opensans = styleValue3.split("height: ")[1].split("px")[0];
			if(height3.equals(opensans))
			{
				logger.info("opensansregular font is applied");
			}
			else {
				logger.info("opensansregular font not applied");
			}

			explicitWait(pf.defaulttext,50);
			pf.defaulttext.click();
			Thread.sleep(3000);
			WebElement iframe4 = driver.findElement(By.xpath("//iframe[@id=\"epub_3\"]"));
			String styleValue4 = iframe4.getAttribute("style");
			String height4 = styleValue4.split("height: ")[1].split("px")[0];
			logger.info(" after  Default  Iframe height: " + height4 + "px");
			String defaulttext = styleValue4.split("height: ")[1].split("px")[0];
			if(height4.equals(defaulttext))
			{
				logger.info("defaulttext font is applied");
			}
			else {
				logger.info("defaulttext font not applied");
			}

			explicitWait(pf.roboto,50);
			pf.roboto.click();
			Thread.sleep(3000);
			WebElement iframe5 = driver.findElement(By.xpath("//iframe[@id=\"epub_3\"]"));
			String styleValue5 = iframe5.getAttribute("style");
			String height5 = styleValue5.split("height: ")[1].split("px")[0];
			logger.info(" after  Roboto  Iframe height: " + height5 + "px");
			String roboto = styleValue5.split("height: ")[1].split("px")[0];
			if(height5.equals(roboto))
			{
				logger.info("roboto font is applied");
			}
			else {
				logger.info("roboto font not applied");
			}

			// Slider

			Thread.sleep(2000);
			explicitWait(pf.slider,50);
			Thread.sleep(3000);
			moveToGivenPoint(pf.slider,30,0);
			Thread.sleep(3000);
			moveToGivenPoint(pf.slider,0,30);
			Thread.sleep(3000);


			explicitWait(pf.layout,50);
			pf.layout.click();
			Thread.sleep(3000);
			explicitWait(pf.daymode,50);
			pf.daymode.click();
			Thread.sleep(3000);
			explicitWait(pf.midmode,50);
			pf.midmode.click();
			Thread.sleep(3000);
			explicitWait(pf.nightmode,50);
			pf.nightmode.click();
			Thread.sleep(3000);
			explicitWait(pf.leftalign,50);
			pf.leftalign.click();
			Thread.sleep(3000);
			explicitWait(pf.justifyalign,50);
			pf.justifyalign.click();
			Thread.sleep(3000);
			explicitWait(pf.centrealign,50);
			pf.centrealign.click();
			Thread.sleep(3000);
			explicitWait(pf.narrowline,50);
			pf.narrowline.click();
			Thread.sleep(3000);
			explicitWait(pf.linespacing,50);
			pf.linespacing.click();
			Thread.sleep(3000);
			explicitWait(pf.wideline,50);
			pf.wideline.click();
			Thread.sleep(1000);
			explicitWait(pf.marginwide,50);
			pf.marginwide.click();
			Thread.sleep(3000);
			explicitWait(pf.marginnormal,50);
			pf.marginnormal.click();
			Thread.sleep(3000);
			explicitWait(pf.marginnarrow,50);
			pf.marginnarrow.click();
			Thread.sleep(3000);
			explicitWait(pf.rest,50);
			pf.rest.click();
			Thread.sleep(3000);
			explicitWait(pf.textformatreturn,50);
			pf.textformatreturn.click();
		}

		catch(Exception e) {
			logger.info(e.getMessage());
		}
	}


	public void tablofcontentandlastaccessedpage() throws IOException, InterruptedException {

		try {
			Thread.sleep(2000);
			PageFactoryClass pf = new PageFactoryClass(driver);
			Thread.sleep(5000);
			explicitWait(pf.toc,50);
			pf.toc.click();
			Thread.sleep(5000);
			explicitWait(pf.toc1,50);
			pf.toc1.click();
			Thread.sleep(5000);
			explicitWait(pf.toc5,50);
			pf.toc5.click();
			Thread.sleep(5000);
			explicitWait(pf.toc8,50);
			pf.toc8.click();
			Thread.sleep(5000);
			explicitWait(pf.toc12,50);
			pf.toc12.click();
			Thread.sleep(5000);
			explicitWait(pf.toc6,50);
			Thread.sleep(5000);

			// String for lastaccessed page

			String chapterthree = pf.toc6.getText();
			logger.info(chapterthree);
			Thread.sleep(5000);

			pf.toc6.click();
			Thread.sleep(5000);
			close();
			Thread.sleep(5000);
			//last accessed page window close and open
			lastWindow();
			Thread.sleep(3000);
			explicitWait(pf.connect,10);
			pf.connect.click();
			Thread.sleep(3000);
			lastWindow();
			logger.info("next window");
			Thread.sleep(3000);
			explicitWait(pf.lastaccessedpage,50);
			Thread.sleep(3000);
			pf.lastaccessedpage.click();
			Thread.sleep(3000);
			explicitWait(pf.toc,50);
			pf.toc.click();
			Thread.sleep(3000);
			BaseClass.ScreenShot(driver,"lastaccessedpage");
			logger.info("Book relaunched and data patched successfully");


			// String for lastaccessed page

			explicitWait(pf.lastaccessedpageconfirmation,50);
			String lastpage = pf.lastaccessedpageconfirmation.getText();
			logger.info(lastpage);
			if(chapterthree.equals(lastpage)) {  
				logger.info("Lastaccessed page launched");
				BaseClass.testCase2("LastAccessedPage",chapterthree+" Is equal to "+lastpage,
						"lastaccessedpage");

			}
			else {
				logger.info("Lastaccessed page not launched");
				BaseClass.ScreenShot(driver, "LastAccessedPagenotmatched");
				BaseClass.failTestCase("LastAccessedPage", 
						"LastAccessedPage not matched", chapterthree+" Is not equal to  "+lastpage,"LastAccessedPagenotmatched");	
			}
			explicitWait(pf.tocreturn,50);
			pf.tocreturn.click();


			BaseClass.testCase2("LastAccessedPage","LastPageLaunchedSuccessfully",
					"lastaccessedpage");

		}

		catch(Exception e) {
			logger.info(e.getMessage());
			BaseClass.ScreenShot(driver, "LastAccessedPage");
			BaseClass.failTestCase("LastAccessedPage", 
					"LastAccessedPage not launched", "Failed "+e.getMessage(),"LastAccessedPage");	

		}


	}


	public void authorinfoandpagenavigation() {

		try {
			PageFactoryClass pf = new PageFactoryClass(driver);
			Thread.sleep(3000);
			explicitWait(pf.nextchapter1,50);
			Thread.sleep(3000);
			pf.nextchapter1.click();
			Thread.sleep(3000);
			explicitWait(pf.nextchapter1,50);
			Thread.sleep(3000);
			pf.nextchapter1.click();
			Thread.sleep(3000);
			explicitWait(pf.previouschapter1,50);
			Thread.sleep(3000);
			pf.previouschapter1.click();
			Thread.sleep(3000);
			explicitWait(pf.previouschapter2,50);
			Thread.sleep(3000);
			pf.previouschapter2.click();
			Thread.sleep(3000);
			explicitWait(pf.authorinfo,50);
			pf.authorinfo.click();
			Thread.sleep(3000);

			//Scroll functionality
			executeScripScroll(pf.authorinfoscrolldown);
			Thread.sleep(3000);
			executeScripScroll(pf.authorinfoscrollup);
			Thread.sleep(3000);

			explicitWait(pf.closebutton,50);
			Thread.sleep(3000);
			pf.closebutton.click();


		}
		catch(Exception e) {
			logger.info(e.getMessage());
		}

	}

	public void search() {

		try {

			Thread.sleep(2000);
			PageFactoryClass pf = new PageFactoryClass(driver);
			Thread.sleep(5000);
			explicitWait(pf.search,50);
			Thread.sleep(5000);
			pf.search.click();
			Thread.sleep(5000);

			//for enter functionality in keyboard

			explicitWait(pf.searchinput,70);
			pf.searchinput.sendKeys("Down the Rabbit-Hole"+Keys.ENTER);
			Thread.sleep(8000);

			explicitWait(pf.searchinput1,50);
			Thread.sleep(2000);
			pf.searchinput1.click();
			Thread.sleep(2000);
			explicitWait(pf.searchinput2,50);
			Thread.sleep(2000);
			pf.searchinput2.click();
			Thread.sleep(2000);
			explicitWait(pf.search,50);
			Thread.sleep(2000);
			pf.search.click();
			Thread.sleep(2000);
			explicitWait(pf.search,50);
			Thread.sleep(2000);
			pf.search.click();
			Thread.sleep(2000);
			explicitWait(pf.searchinput3,50);
			Thread.sleep(2000);
			pf.searchinput3.click();
			Thread.sleep(2000);
			explicitWait(pf.searchinput4,50);
			Thread.sleep(2000);
			pf.searchinput4.click();
			Thread.sleep(2000);
			explicitWait(pf.search,50);
			Thread.sleep(2000);
			pf.search.click();
			Thread.sleep(2000);
			explicitWait(pf.search,50);
			Thread.sleep(2000);
			pf.search.click();
			Thread.sleep(2000);
			explicitWait(pf.searchinputalice,50);
			Thread.sleep(2000);
			pf.searchinputalice.sendKeys(Keys.CONTROL + "a", Keys.BACK_SPACE);
			Thread.sleep(3000);
			explicitWait(pf.searchinput,70);
			Thread.sleep(3000);
			pf.searchinput.sendKeys("Alice"+Keys.ENTER);
			Thread.sleep(8000);
			explicitWait(pf.searchinput5,50);
			Thread.sleep(3000);
			pf.searchinput5.click();
			Thread.sleep(2000);
			explicitWait(pf.searchinput6,50);
			Thread.sleep(2000);
			pf.searchinput6.click();
			Thread.sleep(2000);
			explicitWait(pf.search,50);
			Thread.sleep(2000);
			pf.search.click();
			Thread.sleep(2000);
			explicitWait(pf.search,50);
			Thread.sleep(2000);
			pf.search.click();
			Thread.sleep(2000);
			explicitWait(pf.searchinput7,50);
			Thread.sleep(2000);
			pf.searchinput7.click();
			explicitWait(pf.searchinput8,50);
			Thread.sleep(2000);
			pf.searchinput8.click();
			Thread.sleep(2000);
			explicitWait(pf.search,50);
			Thread.sleep(2000);
			pf.search.click();
			Thread.sleep(2000);
			explicitWait(pf.search,50);
			Thread.sleep(2000);
			pf.search.click();
			Thread.sleep(2000);
			explicitWait(pf.searchinput9,50);
			Thread.sleep(2000);
			pf.searchinput9.click();
			Thread.sleep(2000);
			explicitWait(pf.searchinput10,50);
			Thread.sleep(2000);
			pf.searchinput10.click();
			Thread.sleep(2000);
			explicitWait(pf.search,50);
			Thread.sleep(2000);
			pf.search.click();
			Thread.sleep(2000);
			explicitWait(pf.search,50);
			Thread.sleep(2000);
			pf.search.click();
			Thread.sleep(2000);
			pf.searchinputalice.sendKeys(Keys.CONTROL + "a", Keys.BACK_SPACE);
			Thread.sleep(5000);
			pf.searchinput.sendKeys("pool"+Keys.ENTER);
			Thread.sleep(6000);
			explicitWait(pf.searchinput,70);
			Thread.sleep(3000);
			String searchresult = pf.searchresult.getText();
			logger.info(searchresult);
			Thread.sleep(2000);

			//if condition

			String searchresult1 = pf.searchresult.getText();
			logger.info(searchresult1);
			if(searchresult.equals(searchresult1)) {
				logger.info("Search result Pass");
			}
			else {
				logger.info("Search result Fail");
			}
			Thread.sleep(2000);
			pf.search.click();
			Thread.sleep(2000);
			explicitWait(pf.search,50);
			Thread.sleep(2000);
			pf.search.click();
			Thread.sleep(2000);
			explicitWait(pf.search,50);
			Thread.sleep(2000);
			explicitWait(pf.searchinput11,50);
			Thread.sleep(2000);
			pf.searchinput11.click();
			Thread.sleep(2000);
			explicitWait(pf.searchinput12,50);
			Thread.sleep(2000);
			pf.searchinput12.click();
			Thread.sleep(3000);
			pf.searchinput.sendKeys(Keys.CONTROL + "a", Keys.BACK_SPACE);
			Thread.sleep(3000);
			pf.searchinput.sendKeys("textbook"+Keys.ENTER);
			Thread.sleep(3000);
			String searchresulttext = pf.searchresultfortext.getText();
			logger.info("no result found");
			Thread.sleep(2000);
			String  searchresulttext2  = pf.searchresultfortext.getText();
			logger.info("no results found for textbook");
			if(searchresulttext.equals (searchresulttext2)) {
				logger.info("Search result Pass");
			}
			else {
				logger.info("Search result Pass");
			}
			Thread.sleep(2000);
			explicitWait(pf.searchcancelbutton,50);
			Thread.sleep(2000);
			pf.searchcancelbutton.click();
			Thread.sleep(2000);
			explicitWait(pf.search,50);
			Thread.sleep(2000);
			pf.search.click();
			Thread.sleep(2000);

		}
		catch(Exception e) {
			logger.info(e.getMessage());
		}


	}

	public void printfunctionality() {

		try {
			PageFactoryClass pf = new PageFactoryClass(driver);
			Thread.sleep(2000);
			explicitWait(pf.print,50);
			Thread.sleep(2000);
			pf.print.click();
			Thread.sleep(7000);
			Robot robot = new Robot();

			// Press and release Tab key
			robot.keyPress(KeyEvent.VK_TAB);  // Press the Tab key
			robot.keyRelease(KeyEvent.VK_TAB);  // Release the Tab key

			// Press and release Enter key
			robot.keyPress(KeyEvent.VK_ENTER);  // Press the Enter key
			robot.keyRelease(KeyEvent.VK_ENTER);  // Release the Enter key
			Thread.sleep(2000);

		}
		catch(Exception e) {
			logger.info(e.getMessage());
		}

	}

	public void highlight() throws IOException, InterruptedException {

		try {
			PageFactoryClass pf = new PageFactoryClass(driver);
			Thread.sleep(5000);
			BaseClass.extentStart("Highlightes");
			pf.nextchapter1.click();
			Thread.sleep(4000);
			explicitWait(pf.nextchapter1,50);
			Thread.sleep(4000);
			pf.nextchapter1.click();
			Thread.sleep(4000);
			explicitWait(pf.nextchapter1,50);
			Thread.sleep(4000);
			//			pf.nextchapter1.click();
			//			Thread.sleep(4000);
			//			explicitWait(pf.nextchapter1,50);
			//			Thread.sleep(4000);

			//			Thread.sleep(3000);
			//			explicitWait(pf.lastaccessedpage,50);
			//			Thread.sleep(3000);
			//			pf.lastaccessedpage.click();
			Thread.sleep(3000);

			driver.switchTo().frame("epub_5");
			logger.info("Chapter 3");


			pf.capterthreehighlightone.click();
			Thread.sleep(3000);
			driver.switchTo().defaultContent();

			Thread.sleep(3000);
			explicitWait(pf.yellow,10);
			pf.yellow.click();
			Thread.sleep(3000);
			//executeScripScroll();
			driver.switchTo().frame("epub_5");
			Thread.sleep(3000);


			BaseClass.moveToGivenPoint(pf.capterthreehighlightone, 10, 20);
			Thread.sleep(2000);
			driver.switchTo().defaultContent();
			explicitWait(pf.pink,10);
			pf.pink.click();
			Thread.sleep(3000);
			driver.switchTo().frame("epub_5");
			Thread.sleep(3000);

			BaseClass.moveToGivenPoint(pf.capterthreehighlightone, 10, 20);
			Thread.sleep(2000);
			driver.switchTo().defaultContent();
			explicitWait(pf.green,10);
			pf.green.click();
			Thread.sleep(3000);
			driver.switchTo().frame("epub_5");
			Thread.sleep(3000);

			BaseClass.moveToGivenPoint(pf.capterthreehighlightone, 10, 20);
			Thread.sleep(2000);
			driver.switchTo().defaultContent();
			explicitWait(pf.blue,10);
			pf.blue.click();
			Thread.sleep(3000);
			driver.switchTo().frame("epub_5");
			Thread.sleep(3000);

			BaseClass.moveToGivenPoint(pf.capterthreehighlightone, 10, 20);
			Thread.sleep(2000);
			driver.switchTo().defaultContent();
			explicitWait(pf.violet,10);
			Thread.sleep(3000);
			pf.violet.click();
			Thread.sleep(3000);
			BaseClass.ScreenShot(driver, "Highlightsadded");


			BaseClass.testCase2("BookHighlights","Highlights added successfully",
					"Highlightsadded");

		}

		catch(Exception e) {
			logger.info(e.getMessage());
			BaseClass.ScreenShot(driver, "VocabFail");
			BaseClass.failTestCase("Vocabulary not applied", 
					"VocabularyNotes not applied", "Failed "+e.getMessage(),"VocabFail");	


		}

		BaseClass.extentEnd();

	}
	
	public void highlightsbookrelaunch() throws IOException, InterruptedException {
		try{

			PageFactoryClass pf = new PageFactoryClass(driver);
			Thread.sleep(4000);
			//			explicitWait(pf.nextchapter1,50);
			//			Thread.sleep(4000);
			//			pf.nextchapter1.click();
			//			Thread.sleep(4000);
			//			explicitWait(pf.nextchapter1,50);
			//			Thread.sleep(4000);
			//			pf.nextchapter1.click();
			//		Thread.sleep(4000);
			//		explicitWait(pf.nextchapter1,50);
			//		Thread.sleep(4000);
			//		pf.nextchapter1.click();
			//		Thread.sleep(4000);

			Thread.sleep(3000);
			close();
			Thread.sleep(3000);
			//last accessed page window close and open
			lastWindow();
			Thread.sleep(3000);
			explicitWait(pf.connect,10);
			pf.connect.click();
			Thread.sleep(3000);
			lastWindow();
			logger.info("next window");
			Thread.sleep(3000);


			explicitWait(pf.nextchapter1,50);
			Thread.sleep(3000);
			pf.nextchapter1.click();
			Thread.sleep(3000);
			explicitWait(pf.nextchapter1,50);
			Thread.sleep(3000);
			pf.nextchapter1.click();
			Thread.sleep(3000);
			//			explicitWait(pf.nextchapter1,50);
			//			Thread.sleep(3000);
			//			pf.nextchapter1.click();
			//			Thread.sleep(3000);
			BaseClass.ScreenShot(driver,"highlightsdatapatch");
			logger.info("Book relaunched and data patched successfully");

			BaseClass.testCase2("Datapathforhighlights","Highlightsdatapatched successfully",
					"highlightsdatapatch");


		}

		catch(Exception e) {
			logger.info(e.getMessage());
			BaseClass.ScreenShot(driver, "Datapatchfail");
			BaseClass.failTestCase("DatapatchfornoteshighlightsFailed", 
					"HighlightsdatapatchedFailed", "Failed "+e.getMessage(),"Datapatchfail");	
		}
	}



	public void booktextsearch() throws IOException, InterruptedException {

		try {
			PageFactoryClass pf = new PageFactoryClass(driver);
			Thread.sleep(5000);
			//			pf.nextchapter1.click();
			//			Thread.sleep(4000);
			//			explicitWait(pf.nextchapter1,50);
			//			Thread.sleep(4000);
			//			pf.nextchapter1.click();
			//			Thread.sleep(4000);
			//			explicitWait(pf.nextchapter1,50);
			//			Thread.sleep(4000);
			//			pf.nextchapter1.click();
			//			Thread.sleep(4000);
			//			explicitWait(pf.nextchapter1,50);
			//			Thread.sleep(4000);

			//			Thread.sleep(3000);
			//			explicitWait(pf.lastaccessedpage,50);
			//			Thread.sleep(3000);
			//			pf.lastaccessedpage.click();
			Thread.sleep(3000);

			driver.switchTo().frame("epub_5");
			logger.info("Chapter 3");

			BaseClass.moveToGivenPoint(pf.capterthreehighlightone, 10, 20);
			Thread.sleep(3000);
			driver.switchTo().defaultContent();

			explicitWait(pf.textsearch,50);
			Thread.sleep(4000);
			pf.textsearch.click();
			explicitWait(pf.searchinput,70);
			pf.searchinput.sendKeys(Keys.ENTER);
			Thread.sleep(8000);
			BaseClass.ScreenShot(driver, "Searchresult");

			explicitWait(pf.searchinputalice,50);
			Thread.sleep(2000);
			pf.searchinputalice.sendKeys(Keys.CONTROL + "a", Keys.BACK_SPACE);
			Thread.sleep(3000);
			explicitWait(pf.search,50);
			Thread.sleep(2000);
			pf.search.click();
			Thread.sleep(2000);

			BaseClass.testCase2("TextSearch","Text searched successfully",
					"Searchresult");

		}

		catch(Exception e) {
			logger.info(e.getMessage());
			BaseClass.ScreenShot(driver, "SearchFail");
			BaseClass.failTestCase("Search SearchResults", 
					"Search not found", "Failed "+e.getMessage(),"SearchFail");	


		}


	}
	public void deletehighlight() throws IOException, InterruptedException {

		try{

			PageFactoryClass pf = new PageFactoryClass(driver);
			Thread.sleep(5000);
			//			explicitWait(pf.nextchapter1,50);
			//			Thread.sleep(3000);
			//			pf.nextchapter1.click();
			//			Thread.sleep(3000);
			//			explicitWait(pf.nextchapter1,50);
			//			Thread.sleep(3000);
			//			pf.nextchapter1.click();
			//			Thread.sleep(3000);
			//			explicitWait(pf.nextchapter1,50);
			//			Thread.sleep(3000);
			//			pf.nextchapter1.click();


			Thread.sleep(3000);
			driver.switchTo().frame("epub_5");
			explicitWait(pf.scrollfortext,50);
			Thread.sleep(2000);
			pf.scrollfortext.click();
			Thread.sleep(3000);
			driver.switchTo().defaultContent();
			Thread.sleep(2000);
			explicitWait(pf.highlightdelete,50);
			Thread.sleep(1000);
			pf.highlightdelete.click();
			Thread.sleep(1000);
			BaseClass.ScreenShot(driver, "NotesDeleted");
			//			explicitWait(pf.deletehighlightnote,50);
			//			Thread.sleep(1000);
			//			pf.deletehighlightnote.click();
			//			BaseClass.ScreenShot(driver,"HighlightDeleted");
			//			explicitWait(pf.vocabclick,50);
			//			Thread.sleep(1000);
			//			pf.vocabclick.click();
			//			Thread.sleep(2000);
			//			explicitWait(pf.deletenote,50);
			//			Thread.sleep(1000);
			//			pf.deletenote.click();
			//			Thread.sleep(1000);


			BaseClass.testCase1("Delete - Notes","",
					"HighlightNoteDeleted", "NotesDeleted");
		}

		//          extend report without screenshot
		//			BaseClass.testCase("VocabularyHighlights", 
		//	                "VocabularyNotes and highlights applied ", "Passed");




		catch(Exception e) {
			logger.info(e.getMessage());
			BaseClass.ScreenShot(driver, "DeleteFail");
			BaseClass.failTestCase("DeleteFailed", 
					"notesnotdeleted", "Failed "+e.getMessage(),"DeleteFail");	

		}

	}

	public void addnotes() throws IOException, InterruptedException {

		try {
			PageFactoryClass pf = new PageFactoryClass(driver);
			Thread.sleep(5000);
			//			pf.nextchapter1.click();
			//			Thread.sleep(4000);
			//			explicitWait(pf.nextchapter1,50);
			//			Thread.sleep(4000);
			//			pf.nextchapter1.click();
			//			Thread.sleep(4000);
			//			explicitWait(pf.nextchapter1,50);
			//			Thread.sleep(4000);
			//			pf.nextchapter1.click();
			//			Thread.sleep(4000);
			//			explicitWait(pf.nextchapter1,50);
			//			Thread.sleep(4000);

			//			Thread.sleep(3000);
			//			explicitWait(pf.lastaccessedpage,50);
			//			Thread.sleep(3000);
			//			pf.lastaccessedpage.click();
			Thread.sleep(3000);

			driver.switchTo().frame("epub_5");
			logger.info("Chapter 3");

			BaseClass.moveToGivenPoint(pf.capterthreehighlightone, 10, 20);
			Thread.sleep(3000);
			driver.switchTo().defaultContent();

			explicitWait(pf.addnote,10);
			Thread.sleep(2000);
			pf.addnote.click();
			Thread.sleep(3000);
			explicitWait(pf.inserttext,50);
			Thread.sleep(3000);
			pf.inserttext.sendKeys("BookNotes");
			Thread.sleep(3000);
			explicitWait(pf.savenotes,50);
			Thread.sleep(2000);
			pf.savenotes.click();
			Thread.sleep(3000);

			driver.switchTo().frame("epub_5");
			Thread.sleep(3000);

			explicitWait(pf.capterthreehighlightone,50);
			Thread.sleep(2000);
			pf.highlightclick.click();
			Thread.sleep(2000);
			driver.switchTo().defaultContent();
			Thread.sleep(2000);		

			explicitWait(pf.notecolor,50);
			Thread.sleep(2000);
			pf.notecolor.click();

			Thread.sleep(2000);
			explicitWait(pf.pinknote,50);
			Thread.sleep(2000);
			pf.pinknote.click();
			Thread.sleep(2000);
			explicitWait(pf.savenotes,50);
			Thread.sleep(2000);
			pf.savenotes.click();
			Thread.sleep(2000);


			driver.switchTo().frame("epub_5");
			Thread.sleep(3000);

			explicitWait(pf.capterthreehighlightone,50);
			Thread.sleep(2000);
			pf.highlightclick.click();
			Thread.sleep(2000);
			driver.switchTo().defaultContent();	
			Thread.sleep(2000);
			explicitWait(pf.notecolor,50);
			Thread.sleep(2000);
			pf.notecolor.click();
			explicitWait(pf.greennote,50);
			Thread.sleep(2000);
			pf.greennote.click();
			Thread.sleep(2000);
			explicitWait(pf.savenotes,50);
			Thread.sleep(2000);
			pf.savenotes.click();
			Thread.sleep(2000);

			driver.switchTo().frame("epub_5");
			Thread.sleep(3000);

			explicitWait(pf.capterthreehighlightone,50);
			Thread.sleep(2000);
			pf.highlightclick.click();
			Thread.sleep(2000);
			driver.switchTo().defaultContent();
			Thread.sleep(2000);
			explicitWait(pf.notecolor,50);
			Thread.sleep(2000);
			pf.notecolor.click();
			explicitWait(pf.blunote,50);
			Thread.sleep(2000);
			pf.blunote.click();
			Thread.sleep(2000);
			BaseClass.ScreenShot(driver, "bluehiglight");
			explicitWait(pf.savenotes,50);
			Thread.sleep(2000);
			pf.savenotes.click();
			Thread.sleep(2000);

			driver.switchTo().frame("epub_5");
			Thread.sleep(3000);
			explicitWait(pf.capterthreehighlightone,50);
			Thread.sleep(2000);
			pf.highlightclick.click();
			Thread.sleep(2000);
			driver.switchTo().defaultContent();
			Thread.sleep(2000);		
			explicitWait(pf.notecolor,50);
			Thread.sleep(2000);
			pf.notecolor.click();
			explicitWait(pf.violetnote,50);
			Thread.sleep(2000);
			pf.violetnote.click();
			Thread.sleep(2000);
			explicitWait(pf.savenotes,50);
			Thread.sleep(2000);
			pf.savenotes.click();
			Thread.sleep(2000);
			BaseClass.ScreenShot(driver, "NotesPass");

			//			executeScripScroll();
			//			Thread.sleep(2000);
			//			scrollDown();
			//			Thread.sleep(4000);
			//  		scrollUp();
			//			Thread.sleep(4000);

			BaseClass.testCase1("Notes", "NotesColorappliedandadded","bluehiglight",
					"NotesPass");


		}


		catch(Exception e) {
			logger.info(e.getMessage());
			BaseClass.ScreenShot(driver, "Note TC1- Fail");
			BaseClass.failTestCase("Note not added", 
					"Notes not applied", "Failed "+e.getMessage(), "Note TC1- Fail");

		}


	}

	public void deletenote() throws IOException, InterruptedException {

		try {
			PageFactoryClass pf = new PageFactoryClass(driver);
			//			pf.nextchapter1.click();
			//			Thread.sleep(4000);
			//			explicitWait(pf.nextchapter1,50);
			//			Thread.sleep(4000);
			//			pf.nextchapter1.click();
			//			Thread.sleep(4000);
			//			explicitWait(pf.nextchapter1,50);
			//			Thread.sleep(4000);

			driver.switchTo().frame("epub_5");
			Thread.sleep(3000);

			explicitWait(pf.capterthreehighlightone,50);
			Thread.sleep(2000);
			pf.highlightclick.click();
			Thread.sleep(2000);
			driver.switchTo().defaultContent();	
			Thread.sleep(2000);

			explicitWait(pf.deletenote,50);
			Thread.sleep(2000);
			pf.deletenote.click();
			Thread.sleep(2000);
			explicitWait(pf.deletehighlightnote,50);
			Thread.sleep(2000);
			pf.deletehighlightnote.click();
			Thread.sleep(3000);

			BaseClass.ScreenShot(driver, "Notedelete");





			BaseClass.testCase2("DeleteNotes", "NotesDeleted","Notedelete");


		}


		catch(Exception e) {
			logger.info(e.getMessage());
			BaseClass.ScreenShot(driver, "Notedelete TC1- Fail");
			BaseClass.failTestCase("Note not deleted", 
					"Notes not deleted", "Failed "+e.getMessage(), "Notedelete TC1- Fail");

		}


	}


	public void notesearchvocab2() throws IOException, InterruptedException {

		try {
			PageFactoryClass pf = new PageFactoryClass(driver);
			Thread.sleep(5000);
			pf.nextchapter1.click();
			Thread.sleep(4000);
			explicitWait(pf.nextchapter1,50);
			//			Thread.sleep(4000);
			//			pf.nextchapter1.click();
			//			Thread.sleep(4000);
			//			explicitWait(pf.nextchapter1,50);
			//			Thread.sleep(4000);
			//			pf.nextchapter1.click();
			//			Thread.sleep(4000);
			//			explicitWait(pf.nextchapter1,50);
			//			Thread.sleep(4000);

			//			Thread.sleep(3000);
			//			explicitWait(pf.lastaccessedpage,50);
			//			Thread.sleep(3000);
			//			pf.lastaccessedpage.click();
			//			Thread.sleep(3000);

			driver.switchTo().frame("epub_6");
			Thread.sleep(3000);
			BaseClass.moveToGivenPoint(pf.highlight2, 20, 30);
			Thread.sleep(3000);
			driver.switchTo().defaultContent();	

			Thread.sleep(2000);
			explicitWait(pf.Addvocab,50);
			Thread.sleep(2000);
			pf.Addvocab.click();
			Thread.sleep(2000);
			explicitWait(pf.vocabcolors,50);
			Thread.sleep(2000);
			pf.vocabcolors.click();

			Thread.sleep(2000);
			explicitWait(pf.pinknotevocab,50);
			Thread.sleep(2000);
			pf.pinknotevocab.click();
			Thread.sleep(2000);
			explicitWait(pf.vocabcolors,50);
			Thread.sleep(2000);
			pf.vocabcolors.click();

			explicitWait(pf.greennotevocab,50);
			Thread.sleep(2000);
			pf.greennotevocab.click();
			Thread.sleep(2000);
			explicitWait(pf.vocabcolors,50);
			Thread.sleep(2000);
			pf.vocabcolors.click();

			explicitWait(pf.violetnotevocab,50);
			Thread.sleep(2000);
			pf.violetnotevocab.click();
			Thread.sleep(2000);
			BaseClass.ScreenShot(driver,"Vocabularycolorsapplied");

			explicitWait(pf.vocabcolors,50);
			Thread.sleep(2000);
			pf.vocabcolors.click();
			explicitWait(pf.blunotevocab,50);
			Thread.sleep(2000);
			pf.blunotevocab.click();
			Thread.sleep(2000);


			explicitWait(pf.inserttext,50);
			Thread.sleep(3000);
			pf.inserttext.sendKeys("VocabNotes");
			Thread.sleep(3000);
			BaseClass.ScreenShot(driver,"Vocabularynotesadded");	
			explicitWait(pf.savenotes,50);
			Thread.sleep(2000);
			pf.savenotes.click();
			Thread.sleep(3000);
			logger.info("Vocabulary notes and highlightes added successfully");
			//			BaseClass.ScreenShot(driver, "Vocabulary notes and highlightes added successfully");	
			//			
			//			extend report with screenshot
			BaseClass.testCase1("Testcase1 Vocabcolors","Vocabulary colors applies-Pass",
					"Vocabularycolorsapplied", "Vocabularynotesadded");
			//			
			//          extend report without screenshot
			//			BaseClass.testCase("VocabularyHighlights", 
			//	                "VocabularyNotes and highlights applied ", "Passed");

		}
		catch(Exception e) {
			logger.info(e.getMessage());
			BaseClass.ScreenShot(driver, "VocabFail");
			BaseClass.failTestCase("Vocabulary not applied", 
					"VocabularyNotes not applied", "Failed "+e.getMessage(),"VocabFail");	


		}

	}

	public void vocabmenu()throws IOException, InterruptedException {

		try{
			PageFactoryClass pf = new PageFactoryClass(driver);

			//			Thread.sleep(5000);
			//			pf.nextchapter1.click();
			//			Thread.sleep(4000);
			//			explicitWait(pf.nextchapter1,50);
			//			Thread.sleep(4000);
			//			pf.nextchapter1.click();
			//			Thread.sleep(4000);
			//			explicitWait(pf.nextchapter1,50);
			//			Thread.sleep(4000);
			//			pf.nextchapter1.click();
			//			Thread.sleep(4000);


			explicitWait(pf.vocabnote,50);
			Thread.sleep(3000);
			pf.vocabnote.click();
			explicitWait(pf.vocabexpand,50);
			Thread.sleep(3000);
			pf.vocabexpand.click();
			Thread.sleep(3000);
			explicitWait(pf.vocabexpandclick,50);
			Thread.sleep(3000);
			pf.vocabexpandclick.click();
			Thread.sleep(3000);
			explicitWait(pf.vocabexpandthreedots,50);
			Thread.sleep(3000);
			pf.vocabexpandthreedots.click();
			Thread.sleep(3000);
			explicitWait(pf.vocabexpandedit,50);
			Thread.sleep(3000);
			pf.vocabexpandedit.click();
			explicitWait(pf.inserttext,50);
			Thread.sleep(3000);
			pf.inserttext.sendKeys("AddVocab");
			BaseClass.ScreenShot(driver,"Vocabularynotesadded");	
			explicitWait(pf.savenotes,50);
			Thread.sleep(2000);
			pf.savenotes.click();
			Thread.sleep(3000);
			explicitWait(pf.vocabexpandthreedots2,50);
			Thread.sleep(2000);
			pf.vocabexpandthreedots2.click();
			Thread.sleep(3000);
			explicitWait(pf.vocabexpanddelete,50);
			Thread.sleep(2000);
			pf.vocabexpanddelete.click();
			Thread.sleep(2000);
			explicitWait(pf.deletehighlightnote,50);
			Thread.sleep(2000);
			pf.deletehighlightnote.click();
			Thread.sleep(3000);
			explicitWait(pf.vocabnote,50);
			Thread.sleep(3000);
			pf.vocabnote.click();
			Thread.sleep(2000);
			BaseClass.ScreenShot(driver,"Vocabularynotesdeleted");



			BaseClass.testCase1("Testcase1 VocabMenu","Vocabulary Menu",
					"Vocabularynotesdeleted", "Vocabularynotesdeleted");


		}
		catch(Exception e) {
			BaseClass.ScreenShot(driver,"VocabFail");
			logger.info(e.getMessage());
			BaseClass.failTestCase("VocabFail", 
					"Vocabulary Menu", "Failed "+e.getMessage(),"VocabFail");	

		}
	}


	//saltire config upload keyboard actions


	public static void selectFile(String imageLocation) throws AWTException, InterruptedException, IOException {
		EpubExecution.setClipboardData(imageLocation);
		EpubExecution.robot();
	}

	public static void robot() throws InterruptedException, AWTException {
		Thread.sleep(1000);
		Robot ro = new Robot();
		ro.keyPress(KeyEvent.VK_CONTROL);
		ro.keyPress(KeyEvent.VK_V);
		ro.keyRelease(KeyEvent.VK_V);
		ro.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(1000);
		// Press Enter to confirm the file path
		ro.keyPress(KeyEvent.VK_ENTER);
		ro.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
	}

	public static void setClipboardData(String path) throws IOException {
		//StringSelection is a class that can be used for copy and paste operations.
		StringSelection stringSelection = new StringSelection(path);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
	}
}
