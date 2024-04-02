package genericLibrary;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

public class UtilityMethods {

	public static void switchToWindowByTitle(WebDriver driver, String expectedTitle ) {
		Set<String> allWindows = driver.getWindowHandles();
	
		for(String window:allWindows) {
			driver.switchTo().window(window);
			String actualTitle=driver.getTitle();
			if(actualTitle.contains(expectedTitle)) {
				break;
			}
		}
	}
	
	public static void switchToWindowByUrl(WebDriver driver, String expectedUrl ) {
		Set<String> allWindows = driver.getWindowHandles();
	
		for(String window:allWindows) {
			driver.switchTo().window(window);
			String actualUrl=driver.getCurrentUrl();
			if(actualUrl.contains(expectedUrl)) {
				break;
			}
		}
	}
	
	
	public static void getWebPageScreenshot(WebDriver driver) {
		TakesScreenshot ts=(TakesScreenshot) driver;
		
		File temp=ts.getScreenshotAs(OutputType.FILE);
		
		File file=new File("./Screenshots/"+getTime()+".png");
		
		try {
			FileHandler.copy(temp, file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static void getWebElementScreenshot(WebElement element) {
		File temp=element.getScreenshotAs(OutputType.FILE);
		
		File perm=new File("./Screenshots/"+getTime()+".png");
		
		try {
			FileHandler.copy(temp,perm);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public static void selectOptionByIndex(WebElement dropdown,int index) {
		
		Select selct=new Select(dropdown);
		selct.selectByIndex(index);
	}
	
public static void selectOptionByValue(WebElement dropdown,String value) {
		
		Select selct=new Select(dropdown);
		selct.selectByValue(value);
	}

public static void selectOptionByVisibleText(WebElement dropdown,String text) {
	
	Select selct=new Select(dropdown);
	selct.selectByVisibleText(text);
}
	

public static void scrollWindowBy(WebDriver driver,int x, int y) {
	JavascriptExecutor jse=(JavascriptExecutor) driver;
	jse.executeScript("window.scrollBy("+x+","+y+")");
}

public static void scrollIntoView(WebDriver driver, boolean position, WebElement element) {
	JavascriptExecutor jse=(JavascriptExecutor) driver;
	jse.executeScript("arguments[0].scrollIntoView("+position+");",element);
}
	
	public static String getTime() {
		return LocalDateTime.now().toString().replace(":", "_").replace("-", "_");
	}
	
}
