package com.qa.boast.pageTest;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.boast.baseTest.BasePageTest;

public class ExpensesTest extends BasePageTest{
	
	
	@BeforeMethod
	public void LunchExpensesPage() {
	expensesPage = homePage.goToExpensesPage();
	}
	@Test(priority=1)
	public void getCreateNewExpensesTest() {
	analyzeLog();
	expensesPage.getCreateNewExpensReport();
	}

	@Test(priority=2,dependsOnMethods= {"getCreateNewExpensesTest"})
	public void getTextFromExpensesPage() {
	expensesPage.getTextFromExpenses();
	}
}
