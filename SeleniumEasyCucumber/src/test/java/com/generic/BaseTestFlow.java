package com.generic;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTestFlow {
	WebDriver driver = null;
	public Properties objconfig;
	private WrapperFunctions objWrapperFunctions;

	
	public void initializedWebEnvironment() {
		objWrapperFunctions = new WrapperFunctions(this);
		this.setObjWrapperFunctions(objWrapperFunctions);

		this.loadConfigProperties();
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(objconfig.getProperty("AUT_URL"));
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

	}

	public void loadConfigProperties() {

		try {
			objconfig = new Properties();
			objconfig.load(new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/configuration/config.properties"));

		} catch (Exception exception) {
			System.out.println("I got the exception : " + exception.getMessage());
			exception.printStackTrace();
		}
	}
	
	public WebDriver getDriver(){
		return driver;
		
	}
	
	public WrapperFunctions getObjWrapperFunctions() {
		return objWrapperFunctions;
	}


	public void setObjWrapperFunctions(WrapperFunctions objWrapperFunctions) {
		this.objWrapperFunctions = objWrapperFunctions;
	}
	

	public void quitBrowser(){
		driver.quit();
	}
}
