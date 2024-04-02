package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
public BasePage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}
}
