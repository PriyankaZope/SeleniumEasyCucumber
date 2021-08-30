@DemoTest
Feature: Verify SEDemoHomePage

Scenario: Successfully open the Simple Form Demo Page

Given User Launch Chrome Browser Opens URL
When User Close Popup
And Demo Home Page Is Opened
Then User Click On Input Forms
And User Click Simple Form Demo
When User Enter Message in Single Input Field
And User Click on Show Message
Then User Get Message
Then Close Browser




