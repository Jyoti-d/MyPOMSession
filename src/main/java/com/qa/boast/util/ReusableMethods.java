package com.qa.boast.util;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.boast.base.BasePage;

public class ReusableMethods extends BasePage{
	
	 WebElement element;
	 WebDriver driver;
	
	//************** Constructor of Reusable Method ************************
	public ReusableMethods(WebDriver driver) {
		this.driver=driver;
	}
	
  //**************** element to be find using getElement Method *************	
	public WebElement getElement(By locator) {
		waitForElementPresent(locator);
		 element = null;
		try {
			element=driver.findElement(locator);
		}
		catch(Exception e) {
			System.out.println("Some exception occured while find element"+locator+""+e.getMessage());
		}
		return element;
	}
 //*************** wait till element to be present *********************	
	public void waitForElementPresent(By locator) {
		WebDriverWait wait = new WebDriverWait(driver,40);
		try{
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		}
		catch(Exception e){
			System.out.println("Some exceptions occured while wait for element present"+e.getMessage());
		}
	}
	
  //*************** login method *************************************	
	public void doEnterValues(By locator,String value)	{
		try {
		getElement(locator).clear();
		getElement(locator).sendKeys(value);
		}
		catch(Exception e) {
			System.out.println("some exception occurred while sending the key on the element " + locator);
			e.printStackTrace();
		}
	}
//*********************** Upload  File ********************************************
	public void uploadeFile(By locator,String Path) {
	try {
		getElement(locator).sendKeys(Path);
	}
	catch(Exception e) {
		e.getStackTrace();
	}
	}
  //**************** wait till element to be click on *******************
	public void waitForElementClickable(By locator) {
		TimeUtil.mediumWait();
		WebDriverWait wait = new WebDriverWait(driver,80);
		
		wait.until(ExpectedConditions.elementToBeClickable(locator));
		
	}
	
  //*************** click on element ********************************	
	public void doClick(By locator) {
		waitForElementClickable(locator);
		try {
		getElement(locator).click();
		}
		catch(Exception e) {
			System.out.println("Some exceptions occured while element clicking"+locator+""+e.getMessage());
		}
		}
 //*********************** Switch to window ********************************	
	public void getSwitchToWindow() {
		Set<String> handels = driver.getWindowHandles();
		Iterator<String> it = handels.iterator();
		String parentWindow = it.next();
		String childWindow = it.next();
		driver.switchTo().window(childWindow);	
	}
	
 //********************* Page Title *********************************	
	public String getPageTitle() {
		String title=null;
		try {
		title=driver.getTitle();
		System.out.println(title);
		}
		catch(Exception e) {
			System.out.println("Title is not valide "+title+e.getMessage());
		}
		return title;
	}
	
 //********************** wait for Page Title present *************************	
	public String waitForTitlePresent(String title) {
		WebDriverWait wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.titleContains(title));
		return driver.getTitle();
	}
	
//***************** select one Value from drop down	***********************
	public String doSelectFromDropDown(By locator,String text) {
		 element = getElement(locator);
		//WebElement element = driver.findElement(locator);
		Select select = new Select(element);
		select.selectByVisibleText(text);
		return select.getFirstSelectedOption().getText();
	}
	
//***************** Get text in page *******************	
	public String doGetText(By locator) {
		String text = null;
		try {
			text = getElement(locator).getText();
		} catch (Exception e) {
			System.out.println("some exception occurred while getting the text of the element " + locator);
		}
		return text;
	}
//**************** Scroll Down till where you want the element  *****************	
	public void getHorizontalScrollDown(By locator) {
		 element=getElement(locator);
		 JavascriptExecutor js = ((JavascriptExecutor)driver);
		 js.executeScript("arguments[0].scrollIntoView()", element);
		
	}
//	public void useFluentWait() {
//		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
//		.withTimeout(30,TimeUnit.SECONDS).pollingEvery(5,TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
//	}

//********* Handle JavaScript popUp *********************	
	public void getJavaScriptPopUp() {
		Alert alert= driver.switchTo().alert();
		String text = alert.getText();
		System.out.println("Print popUp massage::::"+text);
		
		alert.accept();
		
	}
//************ Capture error Message *********************
	public String getErrorMessage(By locator,String text) {
		String errorMsg = getElement(locator).getAttribute("text");
		//System.out.println(errorMsg);
		return errorMsg;
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
