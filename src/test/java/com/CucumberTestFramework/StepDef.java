package com.CucumberTestFramework;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.PageFactory.HomePageFactory;
import com.Utility.ScreenShot;
import com.config.Credentials;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDef {
	
	WebDriver driver;
	HomePageFactory pf;
	
	@Given("User open chrome browser")
	public void user_open_chrome_browser(){
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		driver = new ChromeDriver();  //Upper-casting
		driver.manage().window().maximize();		
		pf = new HomePageFactory(driver);	
	}

	@Given("Open application URL")
	public void open_application_url() throws IOException {
		driver.get(Credentials.getCofig("url"));
	}

	@When("Click on Sign in button on the homepage")
	public void click_on_sign_in_button_on_the_homepage() {
		pf.getHpSignButton().click();
	}

	@When("Eneter user Name")
	public void eneter_user_name() throws IOException {
		pf.getEmailBox().sendKeys(Credentials.getCofig("userName"));
	}

	@When("Enter password")
	public void enter_password() throws IOException {
		pf.getPassBox().sendKeys(Credentials.getCofig("password"));
	}

	@When("Click on sign in button")
	public void click_on_sign_in_button() {
		pf.getLoginSigninButton().click();
	}

	@Then("User is logged into the account home page")
	public void user_is_logged_into_the_account_home_page() {
		String actual = pf.getAccName().getText();
		System.out.println(actual);			
		if(actual.equalsIgnoreCase("Biz Bee")) {
			System.out.println("User Successfully logged in.");
			ScreenShot.captureScreenShot(driver, "SuccessSignedIn");
		}
		else {
			System.out.println("User not logged in.");
			ScreenShot.captureScreenShot(driver, "UnsuccessSignedIn");
		}
		driver.close();
	}

	@When("Eneter user name <{string}>")
	public void eneter_user_name(String string) {
		pf.getEmailBox().sendKeys(string);
	}

	@When("Enter password <{string}>")
	public void enter_password(String string) {
		pf.getPassBox().sendKeys(string);
	}

	@Then("User is redirected to error page")
	public void user_is_redirected_to_error_page() {
	   String error = pf.getErrorPage().getText();
	   if(error.equalsIgnoreCase("There is 1 error")) {
		   System.out.println("User unable to login ");
	   }
	   else {System.out.println("Something is wrong");}
	   
	   driver.quit();
	}

}
