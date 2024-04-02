package testScripts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import genericLibrary.UtilityMethods;

public class SwitchWindow {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.shoppersstack.com/products_page/7");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		
		
		driver.findElement(By.id("compare")).click();
		
		Thread.sleep(2000);
		
		wait.until(ExpectedConditions.numberOfWindowsToBe(4));
		
		UtilityMethods.switchToWindowByTitle(driver, "Amazon");
		driver.manage().window().maximize();
		UtilityMethods.getWebPageScreenshot(driver);
		UtilityMethods.getWebElementScreenshot(driver.findElement(By.id("twotabsearchtextbox")));
		Thread.sleep(2000);
		driver.close();
		
		UtilityMethods.switchToWindowByTitle(driver, "eBay");
		driver.manage().window().maximize();
		UtilityMethods.getWebPageScreenshot(driver);
		Thread.sleep(2000);
		driver.close();
		UtilityMethods.switchToWindowByUrl(driver, "flipkart");
		driver.manage().window().maximize();
		UtilityMethods.getWebPageScreenshot(driver);
		Thread.sleep(2000);
		driver.close();
		
		UtilityMethods.switchToWindowByTitle(driver, "ShoppersStack");
		
		driver.quit();
	}
	
	
	@Test
	public void scroll() throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://amazon.com");
		Thread.sleep(3000);
		
		UtilityMethods.scrollWindowBy(driver, 0, 1000);
	
		UtilityMethods.scrollIntoView(driver, true, driver.findElement(By.xpath("//h2[.='Toys under $25']/./../..//span[.='Shop now' and @class='a-truncate-full a-offscreen']")));
	}
}
