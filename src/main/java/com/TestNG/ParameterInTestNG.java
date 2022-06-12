package com.TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterInTestNG {
WebDriver driver;
	
	@Parameters("browser")
	@Test
	public void getLogin(String browser) throws Exception {
		
		if(browser.equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.chrome.driver", "./Drivers/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		
		if(browser.equalsIgnoreCase("Chrome")) {
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		driver = new ChromeDriver();  //Upper-casting
		}
		
		if(browser.equalsIgnoreCase("fireFox")) {
			System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
			driver = new FirefoxDriver();
		}
		
		driver.get("https://www.google.com/");  //driver.navigate().to("url");
		
		driver.manage().window().maximize();
		
		WebElement searchBox = driver.findElement(By.xpath("//input[@class='gLFyf gsfi']"));
		searchBox.sendKeys("ohio");
		searchBox.submit();
		
		Thread.sleep(3000);
		driver.navigate().back();
		Thread.sleep(3000);
		driver.navigate().forward();
		
		Thread.sleep(3000);
		driver.navigate().refresh();
		
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		
		WebElement imageTab = driver.findElement(By.xpath("//a[@data-hveid='CAEQBQ']"));
		imageTab.click();
		System.out.println(driver.getTitle());
		
		driver.close();

	}
}
