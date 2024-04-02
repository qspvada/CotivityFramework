package testScripts;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Fileutility.ExcelUtility;
import genericLibrary.BaseClass;
import objectRepository.HomePage;
import objectRepository.LoginPage;


public class LoginTest extends BaseClass{

	@DataProvider
	public String[][] loginData() throws IOException, Exception {
		return ExcelUtility.readRowData("login");
	}
	
	
	
	@Test(dataProvider = "loginData")
	public void login_001(String email, String password) {
		HomePage homePage=new HomePage(driver);
		LoginPage loginPage=new LoginPage(driver);
		//Click on Log out link
		homePage.getLogOutLink().click();
		
		
		getWebElementScreenshot(homePage.getLoginLink());
		//Click on Login link
		homePage.getLoginLink().click();
		
		//Enter email
		loginPage.getEmailTextfield().sendKeys(email);
		getWebElementScreenshot(loginPage.getEmailTextfield());
		
		//Enter password
		loginPage.getPasswordTextField().sendKeys(password);
		getWebElementScreenshot(loginPage.getPasswordTextField());
		
		//Click on login button
		getWebElementScreenshot(loginPage.getLoginButton());
		loginPage.getLoginButton().click();
		
		
		
	}
	
}
