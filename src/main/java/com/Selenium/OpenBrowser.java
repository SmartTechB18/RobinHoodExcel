package com.Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenBrowser {

	public static void main(String[] args) throws InterruptedException {
				
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();  //Upper-casting
		driver.get("https://robinhood.com/");  //driver.navigate().to("url");
		
		driver.manage().window().maximize();
		
		

	}

}
