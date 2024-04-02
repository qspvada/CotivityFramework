package testScripts;

import org.testng.annotations.Test;

import genericLibrary.BaseClass;
import objectRepository.HomePage;

public class BooksTest extends BaseClass {

	@Test
	public void book_001() {
		HomePage homePage=new  HomePage(driver);
		
		homePage.getBookLink().click();
		
		
	}
}
