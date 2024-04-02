package genericLibrary;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import Fileutility.PropertiesUtility;

public class BaseClass extends UtilityMethods{

	public WebDriver driver;
	
	//@Parameters({"browser","url"})
	@BeforeClass
	public void browserConfig () {  //(String browser, String url) {
		
		String browser=PropertiesUtility.getProperty("browser");
		
		
		if(browser.equalsIgnoreCase("chrome")) {
		driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("edge")) {
			driver=new EdgeDriver();
		}
		
		else if(browser.equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();
		}
		
		else {
			driver=new ChromeDriver();
		}
		
		driver.manage().window().maximize();
		
		driver.get(PropertiesUtility.getProperty("url"));
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

  
	//@Parameters({"email","pass"})
	@BeforeMethod
	public void login() {//(String email, String pass) {
		
		
		driver.findElement(By.linkText("Log in")).click();
		driver.findElement(By.id("Email")).sendKeys(PropertiesUtility.getProperty("email"));
		driver.findElement(By.id("Password")).sendKeys(PropertiesUtility.getProperty("password"));
		driver.findElement(By.cssSelector("[value='Log in']")).click();
	}


	//@AfterMethod
	public void logOut() {
		driver.findElement(By.linkText("Log out")).click();
	}

	@AfterClass 	
	public void closeBrowser() {
		driver.quit();
	}

}
