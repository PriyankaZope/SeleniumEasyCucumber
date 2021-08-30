/*package com.stepDefinition;

import com.generic.BaseTestFlow;
import com.pageObjects.DemoHomePage;
import com.pageObjects.SimpleFormDemoPage;

import io.cucumber.java.en.*;

public class StepDropDownValue {
	BaseTestFlow objBaseTestFlow;
	DemoHomePage objDemoHomePage;
	SimpleFormDemoPage objSimpleFormDemoPage;
	
	public  StepDropDownValue(BaseTestFlow baseTestFlow){
		objBaseTestFlow = new BaseTestFlow();
		objDemoHomePage = new DemoHomePage(objBaseTestFlow);
		objSimpleFormDemoPage = new SimpleFormDemoPage(objBaseTestFlow);
	}
	
	 @Given("User Launch Chrome Browser Opens URL")					
	    public void User_Launch_Chrome_Browser_Opens_URL() 							
	    {		
	       				objBaseTestFlow.initializedWebEnvironment();
	    }		
	 @Given("Close The Popup")
	 public void close_the_popup() {
	   objDemoHomePage.closePopup();
	 }
	 @Given("Verify DemoHome Page Header")
	public void verify_demo_home_page_header() {
	   objDemoHomePage.verifyDemoHomePageHeaderIsDisplayed();
	}
	

	 @When("Click On Topup Value {string} and DropDown Value {string}")
	 public void click_on_topup_value_and_drop_down_value(String topUpValue, String dropDownvalue) {
	    objDemoHomePage.clickAllHeaderOnTopupMenu(topUpValue);
	    objDemoHomePage.dropDownValue(dropDownvalue);
	 }

	 @When ("Navigate To Home Page")
	   public void Navigate_To_Home_Page(){
		   objBaseTestFlow.getObjWrapperFunctions().navigateToHomePage();
	   }
}
*/