package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AddingNewCustomer;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;


public class TC_002_AddingNewCustomerTest extends BaseClass{
	
	@Test
	public void test_AddNewCustomer()
	{
		logger.info("************starting TC_002_AddingNewCustomerTest*****************");	
		try
		{
		loginpage=new LoginPage(driver);
		loginpage.setUsername(username);
		loginpage.setPassword(password);
		loginpage.clickLoginButton();
		logger.info("successfully logged in");
		
		homepage=new HomePage(driver);
		homepage.clickNewCustomer();
		logger.info("clicked on new customer link on home page");
		
		addnewcust=new AddingNewCustomer(driver);
		addnewcust.setCustomerName("archana");
		addnewcust.setGender();
		addnewcust.setBirthDate("10/20/1995");
		addnewcust.setAddress("4317 chesapeake drive");
		addnewcust.setCity("Aurora");
		addnewcust.setState("California");
		addnewcust.setPinNumber("605074");
		addnewcust.setTelephoneNumber("2341567891");
		addnewcust.setEmailID(randomAlphabetic()+"@gmail.com");
		addnewcust.setPassword("test@123");
		
		logger.info("entered all of the customer information");
		
		addnewcust.clickSubmitButton();
		logger.info("clicked on submit button");
		
		//boolean targetMsg=driver.getPageSource().contains("Customer Registered Successfully!!!");
		boolean targetMsg=addnewcust.verifySuccessText();
		if(targetMsg==true)
		{
			logger.info("new customer added successfully ");
			Assert.assertTrue(true);
		}
		
		else
		{
			logger.info("new customer addition unsuccessful");
			Assert.assertTrue(false);
		}
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		logger.info("************ending TC_002_AddingNewCustomerTest*****************");	
	}

}
