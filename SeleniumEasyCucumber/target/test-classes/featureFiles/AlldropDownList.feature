
Feature: User Open the Selenium Easy Demo hoe page click On Dropdown


  Scenario Outline: Demo Home Page Is Open Successfully
    Given User Launch Chrome Browser Opens URL
    And Close The Popup
 	 And Verify DemoHome Page Header
    

  #@tag2
 # @Scenario Outline: Click on Input form and Dropdown value
    When Click On Topup Value "<topUpValue>" and DropDown Value "<dropDownvalue>"
	And Navigate To Home Page
	
    Examples: 
      | topUpValue  | dropDownvalue |
      | Input Forms |Simple Form Demo|
      | Input Forms |Checkbox Demo|
      |Input Forms|Radio Buttons Demo|