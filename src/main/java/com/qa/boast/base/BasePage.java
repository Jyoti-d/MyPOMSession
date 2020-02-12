package com.qa.boast.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;
import java.util.logging.Level;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.qa.boast.util.TimeUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {
	
	public Properties prop;
	public WebDriver driver;
	DesiredCapabilities caps;
	
	public Properties intialze_properties() {
		
		prop = new Properties();
		FileInputStream fi;
		try {
			fi = new FileInputStream("D:\\SeleniumProjects\\boastgrp\\src\\main\\java\\com\\qa\\"
					+ "boast\\config\\configuraction.properties");
			prop.load(fi);
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
		
			e.printStackTrace();
		}
		return prop;

		
	}
	
	public WebDriver intialize_driver(Properties prop) {
		
		String BrowserName=prop.getProperty("browser");
		if(BrowserName.equals("Chrome")) {
			WebDriverManager.chromedriver().setup();
			 caps = DesiredCapabilities.chrome();
	        LoggingPreferences logPrefs = new LoggingPreferences();
	        logPrefs.enable(LogType.BROWSER, Level.ALL);
	        caps.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);
	        driver = new ChromeDriver(caps);
			//driver=new ChromeDriver();
		}
		else if(BrowserName.equals("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
		}
		else {
			System.out.println("Browser is not present in prop::"+BrowserName);
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(prop.getProperty("Boasturl"));
		TimeUtil.shortWait();
		return driver;
	}
	
	 

}
