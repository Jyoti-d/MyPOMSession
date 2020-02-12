package com.qa.boast.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.boast.base.BasePage;
import com.qa.boast.util.ReusableMethods;

public class CasePage extends BasePage{
	
	public ReusableMethods reusableMethod;
	
	private By newCase = By.id("cp-case-newcase-nav-link");
	private By callBackPhone = By.id("CallBackPhone");
	private By title = By.id("caseTitle");
	private By description = By.id("caseDescription");
	private By caseType = By.id("caseType");
	private By category = By.id("caseCategory");
	private By sub_category = By.id("SubCategory");
	private By urgencyOfNeed = By.id("caseUrgencyOfNeed");
	private By attachment = By.id("uploadFile");
	private By create = By.xpath("//input[contains(@type,'submit')]");
	private By cancel = By.xpath("//input[contains(@type,'button')]");
	
	public CasePage(WebDriver driver) {
		this.driver=driver;
		reusableMethod = new ReusableMethods(this.driver);
	}
	
	public void getNewCase() {
		reusableMethod.doClick(newCase);
	}
	public void getCreateNewCase() {
		getNewCase();
		reusableMethod.doEnterValues(callBackPhone, "8861395561");
		reusableMethod.doEnterValues(title, "new case");
		reusableMethod.doEnterValues(description, "login and logout");
		reusableMethod.doSelectFromDropDown(caseType, "Issue");
		reusableMethod.doSelectFromDropDown(category, "Software Issue");
		reusableMethod.doSelectFromDropDown(sub_category, "Sub Category 1");
		reusableMethod.doSelectFromDropDown(urgencyOfNeed, "Medium");
		reusableMethod.doEnterValues(attachment, "C:\\Users\\Kamal\\Downloads\\BOAST Groupware.xlsx");
		reusableMethod.doClick(cancel);
	}
}
