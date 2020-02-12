package com.qa.boast.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.boast.base.BasePage;
import com.qa.boast.util.ReusableMethods;

public class LoginPage extends BasePage{
	
	ReusableMethods reusableMethods;
	
	private By sign_in = By.xpath("//a[contains(text(),'Sign In')]");
	private By email_id = By.id("Email");
	private By psw = By.id("Password");
	private By login = By.id("cnx-btn-login");
	
//############# Login Constructor ##############################
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		reusableMethods = new ReusableMethods(this.driver);
	}
	
//################ click on sign in button #######################	
	public void clickOn_sign_IN() {
	reusableMethods.doClick(sign_in);
	reusableMethods.waitForElementClickable(sign_in);
	reusableMethods.getSwitchToWindow();
	}

 //############### login with valid username and password #########	
	public HomePage loginWithValidCredentials(String userName,String password) {
		
		clickOn_sign_IN();
		reusableMethods.doEnterValues(email_id, userName);
		reusableMethods.doEnterValues(psw, password);
		reusableMethods.doClick(login);
		
		return new HomePage(driver);
		
	}
	
	
	
	}
