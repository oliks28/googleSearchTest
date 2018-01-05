package StepDefinitions;

import java.io.IOException;
import java.util.List;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import helper.TestBase;
import pages.GoogleHomePage;

public class googleTestSteps extends TestBase {

	@Before
	// I have created a TestBase class in the helper package and i have used
	// class inheritance to inherit functions and webdriver instances
	public void setup() throws IOException {
		initialize();
	}

	@Given("^I am on the google\\.co\\.uk search page using chrome browser$")
	public void i_am_on_the_google_co_uk_search_page_using_chrome_browser() throws Throwable {
		// the testsiteName could be obtained from the config.properties file
		driver.get(CONFIG.getProperty("testsiteName"));

	}

	@Given("^I search for the searchterm \"([^\"]*)\" in the search box field$")
	public void i_search_for_the_searchterm_in_the_search_box_field(String searchterm) throws Throwable {
		// I have used page object design pattern to abstract functions in this
		// test.Page is in the src/test/java folder
		GoogleHomePage ghp = PageFactory.initElements(driver, GoogleHomePage.class);
		ghp.enterSearchItem(searchterm);
	}

	@Then("^I verify and report that the expected site \"([^\"]*)\" is on the first page of results$")
	public void i_verify_and_report_that_the_expected_site_is_on_the_first_page_of_results(String expectedsite)
			throws Throwable {
		int pageNo = 1;
		String Gotexpectedsite = "";
		boolean isFound = false;
		while (!isFound) {
			
			
			List<WebElement> res = driver.findElements(By.xpath("//div[@class='_NId']//h3/a"));
			for (int i = 0; i < res.size(); i++) {
				String values = res.get(i).getText();
				String href = res.get(i).getAttribute("href");
				System.out.println(values);
				if (href.contains(expectedsite)) {
					System.out.println("It is on the first page");
					//System.out.println(
							//String.format("Expected site is found on Page Number %d", pageNo, Gotexpectedsite));
					isFound = true;
					//break;
				}
			}
			if(isFound==true){
				break;
			}
				else{
			
			pageNo = pageNo + 1;
			Thread.sleep(3000);
				}
			
			driver.findElement(By.xpath("//*[@id='pnnext']/span[2]")).click();
			
		}
		System.out.println(
				String.format("Expected site is found on Page Number %d", pageNo, Gotexpectedsite));
	}
	
	@Then("^I close my browser$")
	public void i_close_my_browser() throws Throwable {
	    driver.close();
	}


//	@After
//	public void quit() {
//		driver.quit();
//	}
}
  