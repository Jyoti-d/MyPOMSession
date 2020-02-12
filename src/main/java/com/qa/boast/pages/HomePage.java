package com.qa.boast.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.boast.base.BasePage;
import com.qa.boast.constant.Constants;
import com.qa.boast.util.ReusableMethods;

public class HomePage extends BasePage{
	
	ReusableMethods reusableMehods;
	
	private By reportsMenu = By.id("nav-reports");
	private By expensesMenu = By.id("nav-expenses");
	private By docsMenu = By.id("nav-smartdocs");
	private By academyMenu = By.id("nav-academy");
	private By conferenceMenu = By.id("nav-conference");
	private By conexionMenu = By.id("nav-conexion");
	private By caseMenu = By.id("nav-smartcase");
	private By trackerMenu = By .id("nav-tracker");
	private By chatMenu = By.id("nav-chat");
	private By timesheetMenu = By.id("nav-timesheet");
	private By tomsMenu = By.id("nav-toms");
	private By contactsMenu = By.id("nav-contacts");
	private By oppsMenu = By.id("nav-opportunity");
	private By rosterMenu = By.id("nav-roster");
	private By serviceMenu = By.id("nav-service");
	
	public static Logger log = Logger.getLogger(HomePage.class.getName());
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		reusableMehods= new ReusableMethods(this.driver);
	}
	
	public ReportPage goToReportPage() {
		log.info("Click on Report Icon: >>>>>>>>>>>>>");
		reusableMehods.doClick(reportsMenu);
		return new ReportPage(driver);
	}
	public ExpensesPage goToExpensesPage() {
		log.info("Click on Expenses Icon: >>>>>>>>>>>>");
		reusableMehods.doClick(expensesMenu);
		return new ExpensesPage(driver);
	}
	public void goToDocsPage() {
		reusableMehods.doClick(docsMenu);
	}
	public void goToAcademyPage() {
		log.info("Click on Academy Icon: >>>>>>>>>>>>>>>>");
		reusableMehods.doClick(academyMenu);
	}
	public void goToConferencePage() {
		reusableMehods.doClick(conferenceMenu);
	}
	public void goToConexionPage() {
		log.info("Click on Case Icon: >>>>>>>>>>>>>>>>>>>>>>>");
		reusableMehods.doClick(conexionMenu);
		
	}
	public CasePage goToCasePage() {
		reusableMehods.doClick(caseMenu);
		return new CasePage(driver);
	}
	public void goToChatPage() {
		reusableMehods.doClick(chatMenu);
	}
	public void goToTrackerPage() {
		reusableMehods.doClick(trackerMenu);
	}
	public void goToOppsPage() {
		reusableMehods.doClick(oppsMenu);
	}
	public void goToTomsPage() {
		reusableMehods.doClick(tomsMenu);
	}
	public void goToContactPage() {
		reusableMehods.doClick(contactsMenu);
	}
	public void goToTimesheetPage() {
		reusableMehods.doClick(timesheetMenu);
	}
	public void goToRosterPage() {
		reusableMehods.doClick(rosterMenu);
	}
	public void goToServicePage() {
		reusableMehods.doClick(serviceMenu);
	}
	
	public String getHomePageTitle() {
		//return reusableMehods.getPageTitle();
		return reusableMehods.waitForTitlePresent(Constants.HomePageTitle);
	}
}
