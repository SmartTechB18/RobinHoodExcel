package com.TestNG;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestSequence {
	
	
	
	@BeforeTest
	public void d() {
		System.out.println("I am before test");
	}
	
	@AfterTest
	public void a() {
		System.out.println("I am after test");
	}
	
	@Parameters("a")
	@Test()
	public void x(String a) {
		System.out.println("I am method 1");
		System.out.println(a);
	}
	
	@Test
	public void b() {
		System.out.println("I am method 2");
	}
	
	@Test(enabled = false)
	public void f() {
		System.out.println("I am method 3");
	}
	
	@Test()
	public void c() {
		System.out.println("I am method 4");
	}
	
}
