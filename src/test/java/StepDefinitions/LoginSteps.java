package StepDefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.*;

public class LoginSteps {
	
	WebDriver driver;
	
	@Given("User is on the Amazon home page")
	public void user_is_on_the_amazon_home_page() {
		 driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	     driver.get("https://www.amazon.in/");
	}

	@When("User clicks on the Sign in button")
	public void user_clicks_on_the_sign_in_button() {
		WebElement buttonElement = driver.findElement(By.id("nav-link-accountList"));
        buttonElement.click();
	}

	@When("User enters {string} and {string}")
	public void user_enters_and(String username, String password) {
		WebElement emailField = driver.findElement(By.xpath("//input[@id='ap_email']"));
		emailField.sendKeys(username);
		WebElement continueBtn = driver.findElement(By.xpath("//input[@id='continue']"));
		continueBtn.click();
        WebElement passwordField = driver.findElement(By.xpath("//input[@id='ap_password']"));
        passwordField.sendKeys(password);
	}

	@When("User clicks the Sign in button")
	public void user_clicks_the_sign_in_button() {
		WebElement signInButton = driver.findElement(By.id("signInSubmit"));
        signInButton.click();
	}

	@Then("User should be logged in and see the Amazon dashboard")
	public void user_should_be_logged_in_and_see_the_amazon_dashboard() {
		WebElement dashboardElement = driver.findElement(By.xpath("//span[@id='nav-link-accountList-nav-line-1']"));
		String actualValue = dashboardElement.getText();
		String expectedValue = "Hello, ";
        if(actualValue.contains(expectedValue)) {
        	System.out.println("Pass.");
        	Assert.assertTrue(true);
        	driver.quit();
        }
        else {
        	System.out.println("Invalid login...");
        	System.out.println("Fail.");
        	Assert.assertTrue(false);
        	driver.quit();
        }
        
	}

	

}
