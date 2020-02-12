package com.qa.boast.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.boast.base.BasePage;
import com.qa.boast.constant.Constants;
import com.qa.boast.util.ReusableMethods;

public class ReportPage extends BasePage{
	
	ReusableMethods reusableMethods;
	public static Logger log = Logger.getLogger(ReportPage.class.getName());
	
	private By analytics_Icon = By.xpath("//a[contains(@id,'cp-reports-analytics-nav-link')]");
	private By analytics_config = By.xpath("//a[contains(@id,'cp-reports-analytics-conf-nav-link')]");
	private By report_helps = By.xpath("//a[contains(@title,'Reports Help')]");
	private By runReportAs_dropDown = By.xpath("//select[contains(@id,'userList')]");
	private By report_DropDown = By.xpath("//select[contains(@id,'reportList')]");
	private By report_filed = By.xpath("//input[contains(@aria-activedescendant,'bs-select-2-0')]");
	private By newWorkSpace = By.xpath("//span[contains(@class,'pull-right')]");
	private By workSpaceName = By.xpath("//input[contains(@id,'Name')]");
	private By workSpace_create_btm = By.xpath("//input[contains(@type,'submit')]");
	private By workSpace_cancel_btm = By.xpath("//input[contains(@type,'button')]");
	private By Upload_NewReport = By.xpath("//a[contains(text(),'Upload New Report')]");
	private By dataSetName = By.id("DataSetName");
	private By filePath = By.id("UploadFile");
	private By uploade_btn = By.xpath("//input[contains(@type,'submit')]");
	private By uploade_cancel_btn = By.xpath("//input[contains(@type,'button')]");
	private By user_Tab = By.xpath("//a[contains(text(),'Users')]");
	private By addUser = By.xpath("//a[contains(text(),'Add Users')]");
	private By errorMsg_workSpaceName=By.id("Name-error");
	private By users = By.xpath("//button[contains(@title,'Nothing selected')]");
	private By users_save = By.xpath("//input[contains(@value,'Save')]");
	private By users_cancle = By.xpath("//input[contains(@value,'Cancel')]");
	private By user_searchBox = By.xpath("//div[contains(@class,'bs-searchbox')]");
	private By selectAll = By.xpath("//button[contains(text(),'Select All')]");
	private By deselectAll = By.id("//div//button[contains(text(),'Deselect All')]");
	private By userDropBox = By.id("bs-select-6");
	private By lastUser = By.xpath("//div[contains(@class,'dropdown-menu open')]//child::a[@id='bs-select-6-2']");
	
	
	public ReportPage(WebDriver driver) {
		this.driver=driver;
		reusableMethods= new ReusableMethods(this.driver);
	}
	
//click on Analytics Icon	
	public void getAnalyticsIcon() {
		log.info("@@@@@@@@@@@ Click on Analytics Icon @@@@@@@@@@@");
		reusableMethods.doClick(analytics_Icon);
	}
//click on Analytics power BI configuration	
	public void getAnalyticsConfigurationIcon() {
		log.info("@@@@@@@@@@@ Click on Analytics power BI Configurationa Icon @@@@@@@@@@");
		reusableMethods.doClick(analytics_config);
	}
//click on Reports Help Icon	
	public void getreportHelpIcon() {
		log.info("@@@@@@@@@@@@@@ Click on Help Icon @@@@@@@@@@@@");
		reusableMethods.doClick(report_helps);
	}
//click on Run report As Drop Down
	public void getRunAsDropList() {
		log.info("@@@@@@@@@@@@@@ Click on Run As Report Drop List @@@@@@@@@@@@@");
		reusableMethods.doClick(runReportAs_dropDown);
	}
//Click on Report Drop down	
	public void getReportDropList() {
		log.info("@@@@@@@@@@@ Click on Report Drop Down List @@@@@@@@@@@@@@@");
		reusableMethods.doClick(report_DropDown);
	}
//click on Report Filed	
	public void getReportFiled() {
		log.info("@@@@@@@@@@@ Click on Report Filed @@@@@@@@@@@");
		reusableMethods.doClick(report_filed);
	}
	
//click on New workspace	
	public void getNewWorkSpace() {
		log.info("@@@@@@@@@@@@@ click on Analytics Configuration Icon @@@@@@@@@@@");
		getAnalyticsConfigurationIcon();
		
		log.info("@@@@@@@@@@@@@@ Click on New Work Space @@@@@@@@@@@@");
		reusableMethods.doClick(newWorkSpace);
	}
	
  //click on upload new Report //	
	public void getUploadNewReport() {
		log.info("@@@@@@@@@@@@@ click on Analytics Configuration Icon @@@@@@@@@@@");
		getAnalyticsConfigurationIcon();
		
		log.info("@@@@@@@@@@@ Click on Upload new Report @@@@@@@@@@@@@@");
		reusableMethods.doClick(Upload_NewReport);
	}
	
	//click on users Tabs
	public void getUsersTabs() {
		log.info("@@@@@@@@@ click on user Tabs @@@@@@@@@@@");
		reusableMethods.doClick(user_Tab);
	}
	
   //click on +Add users
	public void getAddusers() {
		getUsersTabs();
		reusableMethods.doClick(addUser);
	}
    /*create NewWorkSpace	*/
	public void createNewWorkSpace() {
		log.info("@@@@@@@@@@@@@@ Click on New Work Space @@@@@@@@@@@@");
		getNewWorkSpace();
		
		log.info("@@@@@@@@@@@@@@@@ Create new Work Space @@@@@@@@@@@@@@@");
		reusableMethods.doEnterValues(workSpaceName, "New User");
		
		log.info("@@@@@@@@@@@@@@ Click Work Space Button @@@@@@@@@@@@@");
		reusableMethods.doClick(workSpace_create_btm);
	}
	
   /*  Upload new Report */
	public void getUploadNewReportPage() {
		log.info("@@@@@@@@@@@@ Click Upload New Report @@@@@@@@@@@@@");
		getUploadNewReport();
		
		log.info("@@@@@@@@ Enter value in Data Set Name @@@@@@@@@@@");
		reusableMethods.doEnterValues(dataSetName, "Sanity TC");
		
//		log.info("@@@@@@@@ Enter value in FilePath @@@@@@@@@@@@");
//		reusableMethods.doEnterValues(filePath, "bosterFile");
		
		log.info("@@@@@@@@@ upload file path @@@@@@@@@@");
		reusableMethods.uploadeFile(filePath, "C:\\Users\\Kamal\\Downloads\\BOAST Groupware.xlsx");
		reusableMethods.getJavaScriptPopUp();
		
		
		log.info("@@@@@@@@ Cancel upload Button @@@@@@@@@");
		reusableMethods.doClick(uploade_cancel_btn);
		
	}
	
   /* without enter value in New WorkSpace */
	public void createNewWorkSpaceWithOutValue() {
		getNewWorkSpace();
		reusableMethods.doClick(workSpace_create_btm);
		
		reusableMethods.getErrorMessage(errorMsg_workSpaceName,Constants.ErrorMsg_WorksapceName);
		
	}
	
   /* Add workspace users */
	public void addWorkspaceUser() {
		getAnalyticsConfigurationIcon();
		getAddusers();
		reusableMethods.doClick(users);
		reusableMethods.doClick(selectAll);
		reusableMethods.doClick(users_save);
		
	}

 /*Deselect all users */
	public void deselectUser() {
		getAnalyticsConfigurationIcon();
		getAddusers();
		reusableMethods.doClick(users);
		reusableMethods.doClick(selectAll);
		reusableMethods.doClick(deselectAll);
	}

  /*Select one value from workspace user  */
	public void selectOneUser() {
		getAnalyticsConfigurationIcon();
		getAddusers();
		reusableMethods.doClick(users);
		reusableMethods.doClick(lastUser);
		//reusableMethods.doSelectFromDropDown(firstUser, Constants.firstUserFromDropBox);
	}
	
  /*check popUp window display or not */
	public void getPopUpWindowOnUsers() {
		getAnalyticsConfigurationIcon();
		getAddusers();
		reusableMethods.doClick(users);
		reusableMethods.doClick(selectAll);
		reusableMethods.doClick(users_cancle);
		reusableMethods.getJavaScriptPopUp();
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
