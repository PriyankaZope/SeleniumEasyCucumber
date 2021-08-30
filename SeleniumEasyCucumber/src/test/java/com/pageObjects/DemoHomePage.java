package com.pageObjects;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.generic.BaseTestFlow;

public class DemoHomePage {

	private BaseTestFlow objBaseTest;
	public boolean blnFlag = false;

	
	public DemoHomePage(BaseTestFlow baseTest){
		this.objBaseTest = baseTest;
	}
	
	By loc_hdr_DemoHomePage=By.xpath("//a[text()='Demo Home']");
	By loc_popup_close=By.xpath("//a[@id='at-cv-lightbox-close']");
	By loc_lnk_InputForm = By.xpath("//a[contains(.,'Input Forms')][1]");
	By loc_lnkSimpleFormDemo = By.xpath("//a[contains(.,'Simple Form Demo')][1]");
	
	
	
	/**
	 * Description : This method checks the popup is displayed or not
	 * @return true/false
	 * Developer : Priyanka Zope
	 */
	public boolean isPopUpVisible(){
		objBaseTest.getObjWrapperFunctions().setFluentWait(loc_popup_close);
		try {
			blnFlag = objBaseTest.getDriver().findElement(loc_popup_close).isDisplayed();
			System.out.println("Popup is displayed");
			return blnFlag;
		} catch (Exception exception) {
			System.out.println("Got Exception : "+exception );
			exception.printStackTrace();
		}
		return blnFlag;
	}
	/**
	 * Description : This Method close the popup
	 */
	public void closePopup(){
		objBaseTest.getObjWrapperFunctions().setFluentWait(loc_popup_close);

		if(this.isPopUpVisible()){
			objBaseTest.getDriver().findElement(loc_popup_close).click();
		}else {
			System.out.println("No popup");
		}
	}

	
	/**
	 * Description : This method is used to verify Header of demo home page
	 */
	public void verifyDemoHomePageHeaderIsDisplayed(){
		Assert.assertTrue(objBaseTest.getObjWrapperFunctions().checkElementDisplayed(loc_hdr_DemoHomePage));
	}
	
	/**
	 * Description : This method is used click topup menu of home page
	 * @param topUpValue
	 */
	public void clickAllHeaderOnTopupMenu(String topUpValue) {
		// Dynamic Locator
		By locator = By
				.xpath("//div[@id='navbar-brand-centered']//li[@class='dropdown']/a[@data-toggle='dropdown'][contains(.,'"
						+ topUpValue + "')]");
		objBaseTest.getDriver().findElement(locator).click();

	}
	
	/**
	 * Description : This method is used to select dropdown value of of home page
	 * @param strDropDownValue
	 */
	public void dropDownValue(String strDropDownValue) {
		// Dynamic Locator
		By locator = By.xpath("//div[@id='navbar-brand-centered']//ul/li/a[text()='" + strDropDownValue + "']");
		objBaseTest.getDriver().findElement(locator).click();

	}
	/**
	 * Description : This method is used to select topup value and dropdown value of of home page .
	 * @param strTopUpValue
	 * @param strDropDownValue
	 */
	public void selectDropdownValue(String strTopUpValue, String strDropDownValue) {
		this.clickAllHeaderOnTopupMenu(strTopUpValue);
		this.dropDownValue(strDropDownValue);
	}


	
	
	
	
	
}
