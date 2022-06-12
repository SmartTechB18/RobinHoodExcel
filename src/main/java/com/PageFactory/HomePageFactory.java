package com.PageFactory;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageFactory {
	
	public HomePageFactory(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath = "//a[@class='login']")
	private WebElement hpSignButton;
	
	@FindBy(id = "email")
	private WebElement emailBox;
	
	@FindBy(name = "passwd")
	private WebElement passBox;
	
	@FindBy(xpath = "(//button[@type='submit'])[3]")
	private WebElement loginSigninButton;
	
	@FindBy(xpath = "//span[contains(text(),'Biz Bee')]")
	private WebElement accName;
	
	@FindBy(xpath="//p[contains(text(),'There is 1 error')]")
	private WebElement errorPage;
	
	public WebElement getErrorPage() {
		return errorPage;
	}
	
	public WebElement getPassBox() {
		return passBox;
	}

	public WebElement getLoginSigninButton() {
		return loginSigninButton;
	}

	public WebElement getAccName() {
		return accName;
	}

	public WebElement getHpSignButton() {
		return hpSignButton;
	}

	public WebElement getEmailBox() {
		return emailBox;
	}

}
