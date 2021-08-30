package com.stepDefinition;

import com.generic.BaseTestFlow;
import com.pageObjects.DemoHomePage;
import com.pageObjects.SimpleFormDemoPage;

import io.cucumber.java.en.*;

public class StepDemoHomePage extends BaseTestFlow {
	DemoHomePage objDemoHomePage;
	SimpleFormDemoPage objSimpleFormDemoPage;

	public StepDemoHomePage(BaseTestFlow baseTestFlow) {
		objDemoHomePage = new DemoHomePage(this);
		objSimpleFormDemoPage = new SimpleFormDemoPage(this);
	}

	
	@Given("User Launch Chrome Browser Opens URL")
	public void user_launch_chrome_browser_opens_url() {
		this.initializedWebEnvironment();
	}
	


	@When("User Close Popup")
	public void user_close_popup() {
		objDemoHomePage.closePopup();
	}

	@When("Demo Home Page Is Opened")
	public void demo_home_page_is_opened() {
		objDemoHomePage.verifyDemoHomePageHeaderIsDisplayed();
	}

	@Then("User Click On Input Forms")
	public void user_click_on_input_forms() {
		objDemoHomePage.clickAllHeaderOnTopupMenu(this.objconfig.getProperty("topUpValue"));
	}

	@Then("User Click Simple Form Demo")
	public void user_click_simple_form_demo() {
		objDemoHomePage.dropDownValue(this.objconfig.getProperty("strDropDownValue"));
	}

	@When("User Enter Message in Single Input Field")
	public void user_enter_message_in_single_input_field() {
		objSimpleFormDemoPage.setMessageForSingleInputField(this.objconfig.getProperty("strMessage"));
	}

	@When("User Click on Show Message")
	public void user_click_on_show_message() {
		objSimpleFormDemoPage.clickOnShowMessage();
	}

	@Then("User Get Message")
	public void user_get_message() {
		objSimpleFormDemoPage
				.verifyMessageInSingleInputField(this.objconfig.getProperty("strExpectedMessage"));
	}

	@Then("Close Browser")
	public void close_browser() {

	}
	
	

}
