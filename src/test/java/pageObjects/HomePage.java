package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

	public HomePage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(linkText="New Customer") WebElement newcust;
	@FindBy(linkText="Edit Customer") WebElement editCust;
	@FindBy(linkText="Delete Customer") WebElement deleteCust;
	@FindBy(linkText="New Account") WebElement newacc;
	@FindBy(linkText="Edit Account") WebElement editacc;
	@FindBy(linkText="Delete Account") WebElement deleteacc;
	
	
	
	public void clickNewCustomer()
	{
		newcust.click();
	}
	
	public void cickEditCustomer()
	{
		editCust.click();
	}
	public void clickDeleteCustomerLink()
	{
		deleteCust.click();
	}
	
	public void clickNewAccountLink()
	{
		newacc.click();
	}
	public void clickDeleteAccountLink()
	{
		deleteacc.click();
	}
	public void clickEditAccountLink()
	{
		editacc.click();
	}
}
