package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.DeleteCustomerPage;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC_004_DeleteCustomerTest extends BaseClass {

	@Test
	public void test_deleteCustomer() 
	{
		logger.info("**************started TC_004_DeleteCustomerTest**********************");
		try
		{
		loginpage = new LoginPage(driver);
		loginpage.setUsername(username);
		loginpage.setPassword(password);
		loginpage.clickLoginButton();
		logger.info("login successful");

		homepage = new HomePage(driver);
		homepage.clickDeleteCustomerLink();
		logger.info("clicked on delete customer link");

		deletecust = new DeleteCustomerPage(driver);
		deletecust.enterCustomerId("81655");
		deletecust.clickSubmitButton();
		logger.info("clicked on submit button");
		
		boolean targetMsg = driver.getPageSource().contains("Customer Deleted Successfully!!!");

		if (targetMsg==true) {
			logger.info("Customer deleted successful");
			Assert.assertTrue(true);
		} else {
			logger.info("Customer delete unsuccessful");
			Assert.assertTrue(false);
		}
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		logger.info("**************Ended TC_004_DeleteCustomerTest**********************");
	}
}
