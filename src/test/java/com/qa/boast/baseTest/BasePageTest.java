package com.qa.boast.baseTest;

import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.qa.boast.base.BasePage;
import com.qa.boast.pages.CasePage;
import com.qa.boast.pages.ExpensesPage;
import com.qa.boast.pages.HomePage;
import com.qa.boast.pages.LoginPage;
import com.qa.boast.pages.ReportPage;

public class BasePageTest {
	
	public WebDriver driver;
	public Properties prop;
	public BasePage basePage;
	public LoginPage loginPage;
	public HomePage homePage;
	public ReportPage reportPage;
	public ExpensesPage expensesPage;
	public CasePage casePage;
	
	
	@BeforeMethod
	public void setUp() {
		basePage = new BasePage();
		prop = basePage.intialze_properties();
		driver = basePage.intialize_driver(prop);
		loginPage = new LoginPage(driver);
		homePage = loginPage.loginWithValidCredentials(prop.getProperty("userName"), prop.getProperty("passWord"));
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	public  void analyzeLog() {
        LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
        for (LogEntry entry : logEntries) {
            System.out.println(new Date(entry.getTimestamp()) + " " + entry.getLevel() + " " + entry.getMessage());
            //do something useful with the data
        }
    }

}
