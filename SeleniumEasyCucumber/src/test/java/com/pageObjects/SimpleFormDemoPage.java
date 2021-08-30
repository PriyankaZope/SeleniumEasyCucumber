package com.pageObjects;


import org.openqa.selenium.By;
import org.testng.Assert;

import com.generic.BaseTestFlow;

public class SimpleFormDemoPage {
	public boolean blnValue = false;
	private BaseTestFlow objBaseTest;
	
	public SimpleFormDemoPage(BaseTestFlow baseTest ){
		this.objBaseTest= baseTest;
		
	}
	
	/**
	 * Description : This method is used to verify Header of Simple Form Demo page
	 * Developer : Priyanka Zope
	 */
	public void verifyHeaderOfSimpleFormDemoPage() {
		//objBaseTest.getObjWrapperFunctions().setImplicitWait();
		By locator = By.xpath("//h3[text()='This would be your first example to start with Selenium.']");
		Assert.assertTrue(objBaseTest.getObjWrapperFunctions().checkElementDisplayed(locator));
		}
	
	/**
	 * Description : This method is used to set meesage for single input field
	 * @param strMessage
	 */
	public void setMessageForSingleInputField(String strMessage) {
		objBaseTest.getDriver().findElement(By.xpath("//input[@id='user-message']")).sendKeys(strMessage);
	}
	
	public void clickOnShowMessage(){
		objBaseTest.getDriver().findElement(By.xpath("//button[text()='Show Message']")).click();

	}
	
	/**
	 * Description : This method is used to verify message of single input field
	 * @param strExpectedMessage
	 */
	public void verifyMessageInSingleInputField(String strExpectedMessage) {
		String strActualMessage = objBaseTest.getDriver().findElement(By.xpath("//span[@id='display']")).getText();
		Assert.assertEquals(strActualMessage, strExpectedMessage);
	}
	
	/**
	 * Description : This method is used to set value for two input field
	 * @param strValue
	 * @param num
	 */
	public void setValuesOfAAndBInTwoInputField(String strValue, String num) {
		By locator = By.xpath("//form[@id='gettotal']//label[text()='" + strValue + "']/following-sibling::input[1]");
		objBaseTest.getDriver().findElement(locator).sendKeys(num);

	}

	/**
	 * Description : This method is used to Click on get total
	 */
	public void clickOnGetTotal() {
		objBaseTest.getDriver().findElement(By.xpath("//button[text()='Get Total']")).click();
	}
	public String getTotal() {
		String strTotal = objBaseTest.getDriver().findElement(By.xpath("//span[@id='displayvalue']")).getText();
		return strTotal;
	}
	/**
	 * Description : This method is used to verify the total of two input field
	 * @param strExpectedTotal
	 */
	public void verifyTotal(String strExpectedTotal) {
		String strActualTotal = this.getTotal();
		Assert.assertTrue(strActualTotal.equals(strExpectedTotal));
		

	}

}
