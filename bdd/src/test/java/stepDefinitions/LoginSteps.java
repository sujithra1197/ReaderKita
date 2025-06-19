package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Pagelocator.Login;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {
	WebDriver driver;
@Given("user is on login page")
public void user_is_on_login_page() {
	   driver = new ChromeDriver();
       driver.get("https://example.com/login");
       Login a= new Login(driver);
}

@When("user enters valid username and password")
public void user_enters_valid_username_and_password() {
 
}

@When("clicks on login button")
public void clicks_on_login_button() {
}

@Then("user should be navigated to home page")
public void user_should_be_navigated_to_home_page() {
}
}
