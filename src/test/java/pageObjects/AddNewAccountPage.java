package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class AddNewAccountPage extends BasePage{

	public AddNewAccountPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(name="cusid")WebElement custid;
	@FindBy(name="inideposit")WebElement initDeposit;
	@FindBy(name="selaccount")WebElement accType;
	
	@FindBy(name="button2")WebElement submitbtn;
	
	public void enterCustomerID(String id)
	{
		custid.sendKeys(id);
	}
	public void enterInitialDeposite(String deposite)
	{
		initDeposit.sendKeys(deposite);
	}
	
	public void selectAccountType()
	{
		accType.click();
		Select select=new Select(accType);
		List<WebElement> options=select.getOptions();
		System.out.println("total options are: "+options.size());
		
		for(WebElement op:options)
		{
			System.out.println(op.getText());
			op.click();
		}
	}
	
	public void clickSubmitButton()
	{
		submitbtn.click();
	}

}
