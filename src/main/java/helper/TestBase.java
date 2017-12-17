package helper;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class TestBase {
	
	public static Properties CONFIG = null;
	public static Properties OR = null;
	public static WebDriver driver;
	
    public void initialize() throws IOException{
    	
    	if(driver==null){
	
    	CONFIG=new Properties();
    	//user might need to add the exact location of their config.properties file as this path might be different
    	FileInputStream fi= new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\helper\\config.properties");
    	CONFIG.load(fi);
    	
    	
    	
    	if(CONFIG.getProperty("browser").equalsIgnoreCase("chrome")){
    		//user will need to specify the location of their chrome driver to run this
    		System.setProperty("webdriver.chrome.driver",
    				"C:\\Users\\kenad\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
    		driver=new ChromeDriver();
    		
    	}else if(CONFIG.getProperty("browser").equalsIgnoreCase("firefox")){
    		driver = new FirefoxDriver();
    		
    	}else if(CONFIG.getProperty("browser").equalsIgnoreCase("IE")){
    		driver = new InternetExplorerDriver();
    	}
    	
    	driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	
	
}
	
    }
	
		
		//C:\Users\kenad\workspace\learncucumber=user.dir
	}



