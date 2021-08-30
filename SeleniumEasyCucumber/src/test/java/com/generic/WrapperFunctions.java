package com.generic;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WrapperFunctions {
	public boolean blnFlag = false;
	private BaseTestFlow objBaseTest;
	
	public WrapperFunctions(BaseTestFlow baseTest){
		this.objBaseTest = baseTest;
	}
	
	public void checkElementVisibility(By locator,int timeUnitInSecond) {
		WebDriverWait wait = new WebDriverWait(objBaseTest.getDriver(), timeUnitInSecond);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

	}
	
	public boolean checkElementDisplayed(By locator){
		boolean blnFlag=false;
	try {
		this.checkElementVisibility(locator, Integer.parseInt(objBaseTest.objconfig.getProperty("explicitwait")));
		 WebDriverWait wait = new WebDriverWait(objBaseTest.getDriver(), 5);
	     wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	     WebElement webElement = objBaseTest.getDriver().findElement(locator);
	  blnFlag=   webElement.isDisplayed();
		return blnFlag;
	} catch (Exception exception) {
		System.out.println("I got Exception : "+exception.getMessage());
		return blnFlag;
	}
	}
	
	public boolean checkElementSelected(By locator){
		boolean blnFlag=false;
	try {
		 WebDriverWait wait = new WebDriverWait(objBaseTest.getDriver(), 5);
	     wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	     WebElement webElement = objBaseTest.getDriver().findElement(locator);
	  blnFlag=   webElement.isSelected();
		return blnFlag;
	} catch (Exception exception) {
		System.out.println("I got Exception : "+exception.getMessage());
		return blnFlag;
	}
	}
	
	public void setImplicitWait(){
		objBaseTest.getDriver().manage().timeouts().implicitlyWait(Integer.parseInt(objBaseTest.objconfig.getProperty("implicitWait")), TimeUnit.SECONDS);
	}
public void navigateToHomePage(){
		objBaseTest.getDriver().findElement(By.xpath("//a[text()='Demo Home']")).click();
	}
/*public void setFluentWiat(By locator){
    
    Wait<WebDriver> wait = new FluentWait<WebDriver>(objBaseTest.getDriver())
            .withTimeout(Duration.ofSeconds(90))
            .pollingEvery(Duration.ofSeconds(2))
            .ignoring(NoSuchElementException.class,TimeoutException.class);
    WebElement webElement = wait.until(new Function<WebDriver, WebElement>() {



      //  @Override
        public WebElement apply(WebDriver t) {
            // TODO Auto-generated method stub
            return objBaseTest.getDriver().findElement(locator);
        };
        
    

};)
    }*/
public void setFluentWait( final By locator){
	Wait<WebDriver>wait = new FluentWait<WebDriver>(objBaseTest.getDriver())
			.withTimeout(Duration.ofSeconds(16))
			.pollingEvery(Duration.ofSeconds(2))
			.ignoring(NoSuchElementException.class);
	WebElement objWebElement = wait.until(new Function<WebDriver, WebElement>() {

		public WebElement apply(WebDriver driver) {
			return objBaseTest.getDriver().findElement(locator);
		
		}
		
	});
	
}

}
