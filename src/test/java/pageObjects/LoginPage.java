package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

	public LoginPage(WebDriver driver) {
		super(driver);
	
	}
	
	@FindBy(name="uid") WebElement username;
	@FindBy(name="password") WebElement password;
	@FindBy(name="btnLogin") WebElement loginButton;
	@FindBy(name="btnReset") WebElement resetButton;
	
	public void setUsername(String user)
	{
		username.clear();
		username.sendKeys(user);
	}
	
	public void setPassword(String pass)
	{
		password.clear();
		password.sendKeys(pass);
	}
	
	public void clickLoginButton()
	{
		loginButton.click();
	}

	public void clickResetButton()
	{
		resetButton.click();
	}
}
