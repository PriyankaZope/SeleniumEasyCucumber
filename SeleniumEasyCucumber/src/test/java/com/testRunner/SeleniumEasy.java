package com.testRunner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//@RunWith(Cucumber.class)
@CucumberOptions(
		
        features = "src/test/resources/featureFiles/SEDemoHomePage.feature",
        glue={"com.stepDefinition"},
        dryRun = false,
        monochrome = true
     
        )
public class SeleniumEasy extends AbstractTestNGCucumberTests {

	
	
	
	
}
