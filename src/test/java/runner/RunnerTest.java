package runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(strict=false,features = {"src/test/resources"},glue={"StepDefinitions"},monochrome=true, format = {"json:target/cucumber.json",
       "html:target/site/cucumber-pretty" }, tags = { "~@ignore" })
public class RunnerTest {

}
