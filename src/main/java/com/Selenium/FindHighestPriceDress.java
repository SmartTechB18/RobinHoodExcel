package com.Selenium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindHighestPriceDress {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();  //Upper-casting
		driver.get("http://automationpractice.com/index.php");
		
		WebElement dressTab =driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[2]/a"));
		dressTab.click();
		
		ArrayList<WebElement> allPrice = new ArrayList<WebElement>(driver.findElements(By.xpath("//div[@class='right-block']/div/span[@itemprop='price']")));
		
		ArrayList<Double> NumericAllPrice = new ArrayList<Double>();
		
		for(int i=0; i<allPrice.size(); i++) {
			System.out.println(allPrice.get(i).getText());
			String price = allPrice.get(i).getText().replace("$", "");
			double x = Double.parseDouble(price);
			NumericAllPrice.add(x);
	//		System.out.println(x);
		}
		
		double highestPrice = Collections.max(NumericAllPrice);
		System.out.println(highestPrice);
		
		String highString = String.valueOf(highestPrice);
		String FirstXpath = "//div[@class='right-block']//div//span[contains(text(),'";		
		String SecondXpath = "')]/parent::div/following-sibling::div/a/span[contains(text(),'Add to cart')]";		
		
		
		String highXpath = FirstXpath + highString + SecondXpath;
		
		WebElement HighAddToCartBtn = driver.findElement(By.xpath(highXpath));
		HighAddToCartBtn.click();
		
	}
}
