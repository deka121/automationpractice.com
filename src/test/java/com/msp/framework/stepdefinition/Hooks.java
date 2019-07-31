package com.msp.framework.stepdefinition;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.cucumber.listener.Reporter;
import com.google.common.io.Files;
import com.msp.framework.base.TestBase;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks extends TestBase{
	

	@Before
	public void beforeScenario(Scenario scenario) {
	    Reporter.assignAuthor("Dhruba Jyoti Deka");
	   TestBase.initialization();
	}
	
	@After(order = 1)
	public void afterScenario(Scenario scenario) throws IOException {
		
		String screenshotName = scenario.getName().replaceAll(" ", "_");
		if (scenario.isFailed()) {
			
			
			try {
				File sourcePath = ((TakesScreenshot) TestBase.driver).getScreenshotAs(OutputType.FILE);			
				File destinationPath = new File(System.getProperty("user.dir") + "\\target\\cucumber-reports\\screenshots\\" + screenshotName + ".png");			
				Files.copy(sourcePath, destinationPath);   
				Reporter.addScreenCaptureFromPath(destinationPath.toString());
			} catch (IOException e) {
			} 
		}
		else if(!scenario.isFailed()) {
			
			File sourcePath = ((TakesScreenshot) TestBase.driver).getScreenshotAs(OutputType.FILE);
			File destinationPath = new File(System.getProperty("user.dir") + "\\target\\cucumber-reports\\screenshots\\" + screenshotName + ".png");	
			Files.copy(sourcePath, destinationPath);   
			Reporter.addScreenCaptureFromPath(destinationPath.toString());

		}
		    TestBase.driver.close();
	}
		

}