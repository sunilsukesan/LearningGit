package resume;

import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Naukri {
	
	public static WebDriver driver;
	@BeforeMethod
	public static void naukri() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Downloads\\chrome\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.naukri.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
		// **attribute**
		// driver.findElement(By.xpath("//input[text()='Home']")).click(); **text**
		// driver.findElement(By.linkText("Courses")).click(); **linktext**
		// driver.findElement(By.partialLinkText("Free")).click(); //partiallinktext
		// driver.findElement(By.xpath("//button[contains(@Class,'btn')]")).click();
		// //**partial attribute**
		// driver.findElement(By.xpath("//button[contains(text(),'Ho')]")).click();
		// //**partial text**

		// frame//
//	driver.switchTo().frame(driver.findElement(By.id("singleframe")));
//	driver.findElement(By.xpath("(//input[@type='text'])[1]")).click();
//	driver.findElement(By.xpath("(//input[@type='text'])[1]")).sendKeys("hi");
//	Thread.sleep(5000);
//	driver.close();
//	
//	//
//	driver.switchTo().defaultContent()

		// window handling//
		String mainWindow = driver.getWindowHandle();
		Thread.sleep(3000);
		Set<String> windowHandles = driver.getWindowHandles();
		ArrayList<String> list = new ArrayList<String>();
		list.addAll(windowHandles);
		for (int i = 0; i < list.size(); i++) {
//			System.out.println(" Session ID " + list.get(i));
//			System.out.println(" Main Window " + mainWindow);
//			System.out.println(mainWindow.equals(list.get(i)));
//			System.out.println(!mainWindow.equals(list.get(i)));
//			System.out.println("");
			if (!mainWindow.equals(list.get(i))) {
				driver.switchTo().window(list.get(i));
				driver.close();
			}

		}
		driver.switchTo().window(mainWindow);
		driver.findElement(By.xpath("//div[text()='Login']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Enter your active Email ID / Username']"))
				.sendKeys("raghavendran_tu@yahoo.co.in");
		driver.findElement(By.xpath("//input[@placeholder='Enter your password']")).sendKeys("MultiUse@89");
		driver.findElement(By.xpath("//button[text()='Login']")).click();
		Thread.sleep(3000);
	}
		@Test(priority=1)
		public static void resume()
		{
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(By.xpath("//div[text()='My Naukri']"))).build().perform();
		driver.findElement(By.linkText("Edit Profile")).click();
		driver.findElement(By.id("attachCV")).sendKeys("C:\\RaghavendranTUAutomation.pdf");

	}
	
		@Test(priority=2)
		public static void apply() throws InterruptedException
		{
			driver.findElement(By.id("qsb-keyskill-sugg")).sendKeys("automation test lead 9years");
			driver.findElement(By.id("qsb-location-sugg")).sendKeys("chennai,bangalore, Hyderabad/Secunderabad, ");
			driver.findElement(By.xpath("//button[text()='SEARCH']")).click();
			driver.findElement(By.xpath("//div[@class='jobTupleHeader']")).click();
			String mainWindow = driver.getWindowHandle();
			Thread.sleep(3000);
			Set<String> windowHandles = driver.getWindowHandles();
			ArrayList<String> list = new ArrayList<String>();
			list.addAll(windowHandles);
			for (int i = 0; i < list.size(); i++) {
				if (!mainWindow.equals(list.get(i))) {
					driver.switchTo().window(list.get(i));
					}

			}
			driver.findElement(By.xpath("//button[text()='Apply']")).click();
			driver.switchTo().window(mainWindow);
		
			}
		
		@Test(priority=3)
		public static void apply2() throws InterruptedException
		{
			driver.findElement(By.id("qsb-keyskill-sugg")).sendKeys("automation test lead 9years");
			driver.findElement(By.id("qsb-location-sugg")).sendKeys("chennai,bangalore, Hyderabad/Secunderabad, ");
			driver.findElement(By.xpath("//button[text()='SEARCH']")).click();
			driver.findElement(By.xpath("//article[@class='jobTuple bgWhite br4 mb-8']/parent::div//following-sibling::article[@class='jobTuple bgWhite br4 mb-8']")).click();
			String mainWindow = driver.getWindowHandle();
			Thread.sleep(3000);
			Set<String> windowHandles = driver.getWindowHandles();
			ArrayList<String> list = new ArrayList<String>();
			list.addAll(windowHandles);
			for (int i = 0; i < list.size(); i++) {
				if (!mainWindow.equals(list.get(i))) {
					driver.switchTo().window(list.get(i));
					}

			}
			driver.findElement(By.xpath("//button[text()='Apply']")).click();
			driver.switchTo().window(mainWindow);
		}
		
		@Test(priority=4)
		public static void apply21() throws InterruptedException
		{
			driver.findElement(By.id("qsb-keyskill-sugg")).sendKeys("automation test lead 9years");
			driver.findElement(By.id("qsb-location-sugg")).sendKeys("chennai,bangalore, Hyderabad/Secunderabad, ");
			driver.findElement(By.xpath("//button[text()='SEARCH']")).click();
			driver.findElement(By.xpath("//article[@class='jobTuple bgWhite br4 mb-8']/parent::div//following-sibling::article[@class='jobTuple bgWhite br4 mb-8']//following-sibling::article[@class='jobTuple bgWhite br4 mb-8']")).click();
			String mainWindow = driver.getWindowHandle();
			Thread.sleep(3000);
			Set<String> windowHandles = driver.getWindowHandles();
			ArrayList<String> list = new ArrayList<String>();
			list.addAll(windowHandles);
			for (int i = 0; i < list.size(); i++) {
				if (!mainWindow.equals(list.get(i))) {
					driver.switchTo().window(list.get(i));
					}

			}
			driver.findElement(By.xpath("//button[text()='Apply']")).click();
			driver.switchTo().window(mainWindow);
		}
		@AfterMethod
		public void close()
		{
			driver.close();
		}
		}



