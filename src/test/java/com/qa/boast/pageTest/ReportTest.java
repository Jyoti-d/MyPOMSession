package com.qa.boast.pageTest;

import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.boast.baseTest.BasePageTest;

public class ReportTest extends BasePageTest{
	
	public static Logger log = Logger.getLogger(ReportTest.class);
	
	@BeforeMethod
	public void lunchReportPage() {
	reportPage = homePage.goToReportPage();
	}
	
	@Test(priority=1,enabled=false)
	public void creatNewWorkspaceTest() {
		reportPage.createNewWorkSpace();
	}

	@Test(priority=2,enabled=false)
	public void uploadeFileTest() {
		reportPage.getUploadNewReportPage();
	}
	@Test(priority=3,enabled=false)
	public void createNewWorkSpaceWithOutValueTest() {
		reportPage.createNewWorkSpaceWithOutValue();
	}
	@Test(priority=4,enabled=true)
	public void addWorksapceUsersTest() {
		reportPage.addWorkspaceUser();
	}
	@Test(priority=5,enabled=false)
	public void deSelectUserTest() {
		reportPage.deselectUser();
	}
	
	@Test(priority=6,enabled=false)
	public void selectOneUserTest() {
		reportPage.selectOneUser();
	}
	
	@Test(priority=7,enabled=true)
	public void getPopupWindowOnUsersPage() {
		reportPage.getPopUpWindowOnUsers();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
