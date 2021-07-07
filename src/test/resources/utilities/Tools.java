package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Tools {
	public WebDriver driver;
	public static WebDriverWait webDriverWait;
	
	@BeforeMethod(alwaysRun=true)
	public void launchbrowser(){
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Downloads\\chrome\\chromedriver.exe");
		//disabling chrome notifications
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--disable-notifications");
		driver = new ChromeDriver();
		webDriverWait = new WebDriverWait(driver,10);
	}
	
	@AfterMethod(alwaysRun=true)
	public void closeBrowser() {
		driver.close();
	}
	}
	

