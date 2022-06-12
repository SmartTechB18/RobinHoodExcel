package com.TestExecution;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.GenericLibrary.BaseLogin;

public class TestNGExecution {
	
	BaseLogin obj = new BaseLogin();
	
	@BeforeTest
	public void getApplication() throws IOException {
		obj.openUrl();
	}
	
	@Test(dependsOnMethods = "getSignInButton")
	public void getLogin() throws IOException, InterruptedException {
		obj.login();
	}
	
	@Test
	public void getSignInButton() throws InterruptedException {
		obj.signIn();
	}
	
	@AfterTest
	public void tearDown() throws InterruptedException {
		obj.tearDown();
	}

}
