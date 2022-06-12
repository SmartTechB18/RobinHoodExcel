package com.Selenium;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.PageFactory.HomePageFactory;
import com.config.Credentials;

public class ActionsClass {

	public static void main(String[] args) throws IOException, InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();  //Upper-casting
		driver.manage().window().maximize();		
		HomePageFactory pf = new HomePageFactory(driver);	
		driver.get(Credentials.getCofig("url"));
		
		WebElement womenTab = driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[1]/a"));
		Thread.sleep(3000);
		Actions ac = new Actions(driver);
		ac.moveToElement(womenTab).build().perform();
		
	//	ac.dragAndDrop(SourcePoint, DropPoint)
	//  ac.contextClick();


	}

}
