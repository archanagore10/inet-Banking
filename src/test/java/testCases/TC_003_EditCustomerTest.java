package testCases;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AddingNewCustomer;
import pageObjects.EditCustomerPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC_003_EditCustomerTest extends BaseClass {

	@Test
	public void test_EditCustomer() {
		
		logger.info("**************started TC_003_EditCustomerTest**********************");
		try {
			loginpage = new LoginPage(driver);
			loginpage.setUsername(username);
			loginpage.setPassword(password);
			loginpage.clickLoginButton();
			logger.info("login successful");

			homepage = new HomePage(driver);
			homepage.cickEditCustomer();
			logger.info("clicked on edit customer link");

			editcust = new EditCustomerPage(driver);
			editcust.setCustomerID("62723");
			editcust.clickSubmitBtn();
			logger.info("clicked on submit button");
			
			addnewcust=new AddingNewCustomer(driver);
			addnewcust.setAddress(randomAlphabetic());
			logger.info("address edited");
			
			editcust.clickSubmitAfterEdit();
			logger.info("clicked on submit button after editing");
			
//			String myalert=driver.switchTo().alert().getText();
//			System.out.println("alert message: "+myalert);
			
			boolean targetMsg = driver.getPageSource().contains("Customer Edited Successfully!!!");

			if (targetMsg==true) {
				logger.info("Customer edit successful");
				Assert.assertTrue(true);
			} else {
				logger.info("Customer edit unsuccessful");
				Assert.assertTrue(false);
			}
		} catch (Exception e) {
			Assert.fail();
		}
		logger.info("**************Ended TC_003_EditCustomerTest**********************");
	}

}
