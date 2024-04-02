package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends  BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	
	@FindBy(id = "Email")
	private WebElement emailTextfield;
	
	@FindBy(id = "Password")
	private WebElement passwordTextField;
	
	@FindBy(css = "[value='Log in']")
	private WebElement loginButton;

	public WebElement getEmailTextfield() {
		return emailTextfield;
	}

	public WebElement getPasswordTextField() {
		return passwordTextField;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}
	
}
