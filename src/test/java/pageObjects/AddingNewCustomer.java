package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddingNewCustomer extends BasePage {

	public AddingNewCustomer(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(name="name") WebElement custName;
	@FindBy(xpath="//input[@value='f']") WebElement gender;
	@FindBy(name="dob") WebElement birthDate;
	@FindBy(name="city") WebElement custcity;
	@FindBy(name="addr") WebElement address;
	@FindBy(name="state") WebElement state;
	@FindBy(name="pinno") WebElement pinNumber;
	@FindBy(name="telephoneno") WebElement phoneNumber;
	@FindBy(name="emailid") WebElement emailId;
	@FindBy(name="password") WebElement password;
	@FindBy(name="sub") WebElement submitButton;
	@FindBy(xpath="//p[text()='Customer Registered Successfully!!!']") WebElement successtext;

	public void setCustomerName(String cname)
	{
		custName.sendKeys(cname);
	}
	
	public void setGender()
	{
		gender.click();
	}
	
	public void setBirthDate(String date)
	{
		birthDate.sendKeys(date);
	}
	
	public void setCity(String city)
	{
		custcity.sendKeys(city);
	}
	
	public void setAddress(String addr)
	{
		address.clear();
		address.sendKeys(addr);
	}
	
	public void setState(String custstate)
	{
		state.sendKeys(custstate);
	}
	
	public void setPinNumber(String pin)
	{
		pinNumber.sendKeys(pin);
	}
	
	public void setTelephoneNumber(String phone)
	{
		phoneNumber.sendKeys(phone);
	}
	
	public void setEmailID(String mail)
	{
		emailId.sendKeys(mail);
	}
	
	public void setPassword(String pass)
	{
		password.sendKeys(pass);
	}
	
	public void clickSubmitButton()
	{
		submitButton.click();
	}
	
	public boolean verifySuccessText()
	{
		try
		{
		return successtext.isDisplayed();
		}
		catch(Exception e)
		{
			return false;
		}
	}
}
