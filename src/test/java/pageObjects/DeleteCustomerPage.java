package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DeleteCustomerPage extends BasePage{

	public DeleteCustomerPage(WebDriver driver) {
		super(driver);
	}
	

	
	@FindBy(name="cusid") WebElement custID;
	@FindBy(name="AccSubmit") WebElement submit;
	
	
	
	
	public void enterCustomerId(String id)
	{
		custID.sendKeys(id);
	}
	
	public void clickSubmitButton()
	{
		submit.click();
	}
}
