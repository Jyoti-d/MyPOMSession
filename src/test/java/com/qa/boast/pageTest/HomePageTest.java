package com.qa.boast.pageTest;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.qa.boast.baseTest.BasePageTest;
import com.qa.boast.pages.HomePage;

public class HomePageTest extends BasePageTest{
	
	public static Logger log = Logger.getLogger(HomePageTest.class.getName());
	
	

	@Test(priority=1)
	public void homePageTitleTest() {
		log.info("Get the title for Home page::");
		String title = homePage.getHomePageTitle();
		System.out.println(title);
	}
	@Test
	public void method() {
		
	}
}
