package runners;

import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import java.io.File;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/testcases", 
glue = { "stepDefinitions" }, 
plugin = {"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/IDAM_AutomationReport.html" },
monochrome = true, 
tags = {"@IDAMAPI"})

public class TestRunner {
	@AfterClass
	public static void writeExtentReport() {
		File reportConfig = new File(System.getProperty("user.dir")+"/configs/extent-config.xml");
		Reporter.loadXMLConfig(reportConfig);
		Reporter.setSystemInfo("User Name", System.getProperty("user.name"));
		Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
		Reporter.setSystemInfo("Machine", "Windows 10" + "64 Bit");
		Reporter.setSystemInfo("Selenium", "3.7.0");
		Reporter.setSystemInfo("Maven", "3.5.2");
		Reporter.setSystemInfo("Java Version", "1.8.0_151");
	}
}