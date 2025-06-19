package Pagelocator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
	public Login(WebDriver driver) {
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
	

}
