package com.qa.boast.pageTest;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.boast.baseTest.BasePageTest;

public class CaseTest extends BasePageTest{
	
	
	@BeforeMethod
	public void lunchCasePage() {
	casePage = homePage.goToCasePage();
	}
	@Test
	public void createNewCaseTest() {
		casePage.getCreateNewCase();
	}

}
