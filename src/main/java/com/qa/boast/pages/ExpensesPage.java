package com.qa.boast.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.boast.base.BasePage;
import com.qa.boast.constant.Constants;
import com.qa.boast.util.ReusableMethods;

public class ExpensesPage extends BasePage{
	
	ReusableMethods reusableMethod;
	
	private By newExpensReport = By.xpath("//a[contains(@id,'cp-expenses-newexpense-nav-link')]");
	private By myExpense = By.xpath("//a[contains(@id,'cp-expenses-my-expenses-nav-link')]");
	private By pendingAproval = By.xpath("//a[contains(@id,'cp-expenses-pending-approval-nav-link')]");
	private By approvedExpense = By.xpath("//a[contains(@id,'cp-expenses-approved-expenses-nav-link')]");
	private By readyForPayment = By.xpath("//a[contains(@id,'cp-expenses-ready-for-payment-nav-link')]");
	private By extractedExpense = By.xpath("//a[contains(@id,'cp-expenses-extracted-expenses-nav-link')]");
	private By allExpenses = By.xpath("//a[contains(@id,'cp-expenses-all-expenses-nav-link')]");
	private By searchExpens = By.xpath("//input[contains(@aria-controls,'tblExpenseList')]");
	private By reportDate = By.xpath("//input[contains(@id,'datepicker')]");
	private By reportName = By.xpath("//input[contains(@id,'report-name')]");
	private By businessUnit = By.xpath("//select[contains(@id,'BusinessUnit')]");
	private By businessProppose = By.id("BusinessPurpose");
	private By create_Expense = By.xpath("//input[contains(@type,'submit')]");
	private By cancel_Expense = By.xpath("//input[contains(@type,'button')]");
	private By expenses_Text = By.xpath("//span[contains(text(),'My Expenses')]");
	private By dateBar = By.id("datePeriodExpenseList");
	
	public ExpensesPage(WebDriver driver) {
		this.driver=driver;
		reusableMethod= new ReusableMethods(this.driver);
	}
	
	public void getNewExpensReport() {
		reusableMethod.doClick(newExpensReport);
	}
	public void getMyExpense() {
		reusableMethod.doClick(myExpense);
	}
	public void getPendingAproval() {
		reusableMethod.doClick(pendingAproval);
	}
	public void getApprovedExpens() {
		reusableMethod.doClick(approvedExpense);
	}
	public void getReadyForPayment() {
		reusableMethod.doClick(readyForPayment);
	}
	public void getExtractExpens() {
		reusableMethod.doClick(extractedExpense);
	}
	public void getAllExpens() {
		reusableMethod.doClick(allExpenses);
	}
	public void getSearchExpens() {
		reusableMethod.doClick(searchExpens);
	}
	
	public void getCreateNewExpensReport() {
		getNewExpensReport();
		reusableMethod.doEnterValues(reportDate,Constants.Date);
		reusableMethod.doEnterValues(reportName, "Regreeion Testing");
		reusableMethod.doSelectFromDropDown(businessUnit,Constants.BusinessUnit2);
		reusableMethod.doEnterValues(businessProppose, "New");
		reusableMethod.doClick(cancel_Expense);
	}
	public void getTextFromExpenses() {
		reusableMethod.doGetText(expenses_Text);

  }
	public void clickOnDateBar() {
		
	}
	public void getReportIdValueInPendingAprovalTable() {
		
	}
	public void getValueOnApprovedExpenses() {
		
	}
	
	
}
