package com.Selenium;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.PageFactory.HomePageFactory;
import com.config.Credentials;

public class DropDownMenu {
	
	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();  //Upper-casting
		driver.manage().window().maximize();		
		HomePageFactory pf = new HomePageFactory(driver);	
		driver.get(Credentials.getCofig("url"));
		
		WebElement dressTab = driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[2]/a"));
		dressTab.click();
		
		Select sl = new Select(driver.findElement(By.xpath("//select[@id='selectProductSort']")));
		// Select by index or Select by VisibleText or Value
		sl.selectByIndex(5);
	}

}
