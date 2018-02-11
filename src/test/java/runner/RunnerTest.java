package runner;

import java.io.File;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.ExtentCucumberFormatter;
import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(strict=false,features = {"src/test/resources"},glue={"StepDefinitions"},monochrome=true, 
format = {"json:target/cucumber.json",
"html:target/site/cucumber-pretty"}, tags = { "~@ignore" })

public class RunnerTest {
	
	/*
		   @AfterClass
		    public static void teardown() {
		        Reporter.loadXMLConfig(new File("src\\test\\java\\runner\\extent-config.xml"));
		        Reporter.setSystemInfo("user", System.getProperty("user.name"));
		        Reporter.setSystemInfo("64 Bit", "Windows 10");
		        Reporter.setTestRunnerOutput("Sample test runner output message");
		    
		

    	    }
   */

}


