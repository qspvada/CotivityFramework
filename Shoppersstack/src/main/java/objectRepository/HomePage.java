package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage  extends BasePage{

	
	
	public HomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(linkText = "BOOKS")
	private WebElement bookLink;

	@FindBy(linkText = "Log in")
	private WebElement loginLink;
	
	@FindBy(linkText = "Log out")
	private WebElement logOutLink;
	
	
	public WebElement getLogOutLink() {
		return logOutLink;
	}

	public WebElement getLoginLink() {
		return loginLink;
	}

	public WebElement getBookLink() {
		return bookLink;
	}
	
}
