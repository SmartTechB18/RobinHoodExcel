package com.TestExecution;

import java.io.IOException;

import com.GenericLibrary.BaseLogin;

public class LoginTest {
	
	public static void main(String[] args) throws IOException, InterruptedException {
		
		BaseLogin bl = new BaseLogin();
		bl.openUrl();
		bl.signIn();
		bl.login();
		bl.tearDown();	
	}


}
