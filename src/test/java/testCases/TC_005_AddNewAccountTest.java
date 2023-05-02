package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AddNewAccountPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC_005_AddNewAccountTest extends BaseClass {

	@Test
	public void test_addNewAccount() {
		logger.info("*********************started TC_005_AddNewAccountTest***************************");
		try {

			loginpage = new LoginPage(driver);
			loginpage.setUsername(username);
			loginpage.setPassword(password);
			loginpage.clickLoginButton();
			logger.info("successfully logged in");

			homepage = new HomePage(driver);
			homepage.clickNewAccountLink();
			logger.info("clicked on new account link");

			addnewacc = new AddNewAccountPage(driver);
			addnewacc.enterCustomerID("49101");
			addnewacc.selectAccountType();
			addnewacc.enterInitialDeposite("10000");
			
			logger.info("entered information to create new account");
			addnewacc.clickSubmitButton();

			boolean targetpage = driver.getPageSource().contains("Account Generated Successfully!!!");

			if (targetpage == true) {
				logger.info("account created successfully");
				Assert.assertTrue(true);
			} else {
				logger.info("account creation unsuccessful");
				Assert.assertTrue(false);
			}
		} catch (Exception e) {
			Assert.fail();
		}

		logger.info("*********************ended TC_005_AddNewAccountTest***************************");
	}

}
