package com.GenericLibrary;

import java.io.IOException;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;


import com.PageFactory.HomePageFactory;
import com.Utility.Highlight;
import com.Utility.ScreenShot;
import com.Utility.Wait;
import com.config.Credentials;

public class BaseLogin {

	WebDriver driver;
	HomePageFactory pf;
	
	public void openUrl() throws IOException {
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		driver = new ChromeDriver();  //Upper-casting
		driver.manage().window().maximize();		
		pf = new HomePageFactory(driver);	
		driver.get(Credentials.getCofig("url"));
		String pt = driver.getTitle();
		System.out.println(pt);
		if(pt.equalsIgnoreCase("My Store")) {
			ScreenShot.captureScreenShot(driver, "HomePage");
			System.out.println("User is in application home page.");
		}
		else {
			System.out.println("This is not the application home page");
		}
	}
	
	public void signIn() throws InterruptedException {
		Highlight.getcolor(driver, pf.getHpSignButton());
		ScreenShot.captureScreenShot(driver, "SighnInButton");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		pf.getHpSignButton().click();	
	}
	
	public void login() throws IOException, InterruptedException {
		
		Wait.getExplicitWaitClicable(driver, pf.getEmailBox());
		Highlight.getcolor(driver, pf.getEmailBox(), "yellow");
		pf.getEmailBox().sendKeys(Credentials.getCofig("userName"));
		
		Highlight.getcolor(driver, pf.getEmailBox(), "blue");
		pf.getPassBox().sendKeys(Credentials.getCofig("password"));	
		
		Wait.getExplicitWaitClicable(driver, pf.getLoginSigninButton());
		
		Highlight.getcolor(driver, pf.getLoginSigninButton());
		pf.getLoginSigninButton().click();	
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
	}
	
	
	public void tearDown() throws InterruptedException {
		driver.close();
	}

}
