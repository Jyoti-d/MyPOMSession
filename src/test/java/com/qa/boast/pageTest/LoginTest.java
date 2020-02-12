package com.qa.boast.pageTest;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.qa.boast.base.BasePage;
import com.qa.boast.baseTest.BasePageTest;
import com.qa.boast.pages.LoginPage;

public class LoginTest extends BasePageTest{
	
	WebDriver driver;
	Properties prop;
	BasePage basepage;
	LoginPage loginpage;
	
	
 
	@Test
	public void loginTest() {
		//loginpage.loginWithValidCredentials(prop.getProperty("userName"), prop.getProperty("passWord"));
	}
	
	
}
