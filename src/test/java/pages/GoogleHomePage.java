package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class GoogleHomePage {
	
WebDriver driver;
	
	
	@FindBy(how=How.CSS,using="#lst-ib")
	
	public static WebElement searchfield;
	
	
	
	
	public void enterSearchItem(String searchitem){
		
		searchfield.sendKeys(searchitem);
		searchfield.sendKeys(Keys.ENTER);
		
	}
	
 }
