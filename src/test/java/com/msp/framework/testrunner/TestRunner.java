package com.msp.framework.testrunner;

import java.io.File;
import org.testng.annotations.AfterClass;
import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
/**
 * Created by Dhruba Deka  on 29/07/2019.
 */

@CucumberOptions(
		features= "src\\test\\java\\com\\msp\\framework\\feature\\MyAccountModule.feature",
        glue = "com.msp.framework.stepdefinition",
        plugin = { "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"},
		dryRun = false,
		monochrome = true,
		strict = false
		 )

public class TestRunner extends AbstractTestNGCucumberTests {
	
	@AfterClass
	public static void after() {
		Reporter.loadXMLConfig(new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\msp\\framework\\config\\extent-config.xml"));
		Reporter.assignAuthor("Dhruba");
		Reporter.setSystemInfo("Username", System.getProperty("user.name"));
		Reporter.setSystemInfo("Time zone", System.getProperty("user.timezone"));
		Reporter.setSystemInfo("Selenium version", "3.14");
	
	}

}
