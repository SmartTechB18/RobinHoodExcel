package com.Selenium;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
	
	public static void robinHoodShareStatus(String sheet, double balance) throws IOException {
		String baba = "C:\\Users\\Urmi\\Desktop\\Robinhood BABA.xlsx";
		File file = new File(baba);
		
		FileInputStream fi = new FileInputStream(file);
		
		Workbook wb = new XSSFWorkbook(fi);
		Sheet sht = wb.getSheet(sheet);
		
		int rowCount = sht.getLastRowNum();
		System.out.println("Total rows : "+rowCount);
		
		Row rw = sht.getRow(rowCount);
		
		ArrayList<Double> buy = new ArrayList<Double>();		
		ArrayList<Double> sell = new ArrayList<Double>();
		for(int i=0; i<=rowCount; i=i+4) {
			String testCell = sht.getRow(i).getCell(0).getStringCellValue();
			if(testCell.contains("Buy")) {
			double testInt = sht.getRow(i+2).getCell(0).getNumericCellValue();
			buy.add(testInt);
			}
		else if(testCell.contains("Sell")) {
			double testInt = sht.getRow(i+2).getCell(0).getNumericCellValue();
			sell.add(testInt);
			}
		}
		System.out.println(buy);
		System.out.println(buy.size());
		System.out.println(sell);
		System.out.println(sell.size());
		double totalBuy = 0;
		for(int i=0; i<buy.size(); i++) {
			totalBuy = totalBuy + buy.get(i);
		}
		double totalSell = 0;
		for(int i=0; i<sell.size(); i++) {
			totalSell = totalSell + sell.get(i);
		}
		
		System.out.println("Total Buy :"+totalBuy);
		System.out.println("Total Sell :"+totalSell);
		
		
		double diff = totalSell-totalBuy;
		System.out.println("Total Buy - Total Sell : "+(diff));
		double NetBal = diff + balance;
		System.out.println("Net Balance ---------->: "+NetBal);
	}

	public static void main(String[] args) throws IOException {
		ReadExcel.robinHoodShareStatus("Sheet4", 0);
	}

}
