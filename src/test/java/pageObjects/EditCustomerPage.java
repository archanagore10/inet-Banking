package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditCustomerPage extends BasePage{

	public EditCustomerPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(name="cusid") WebElement custId;
	@FindBy(name="AccSubmit") WebElement submitButton;
	@FindBy(linkText="Home") WebElement homeLink;
	@FindBy(name="sub") WebElement submitAfterEdit;
	
	public void setCustomerID(String custID)
	{
		custId.sendKeys(custID);
	}
	
	public void clickSubmitBtn()
	{		
		submitButton.click();
	}
	
	public void clickHomeLink()
	{
		homeLink.click();
	}
	
	public void clickSubmitAfterEdit()
	{
		submitAfterEdit.click();
	}

}
