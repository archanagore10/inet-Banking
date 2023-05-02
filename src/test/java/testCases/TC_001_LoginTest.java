package testCases;



import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import testBase.BaseClass;


public class TC_001_LoginTest extends BaseClass{

	@Test
	public void test_Login()
	{
		logger.info("************starting TC_001_Login_test*****************");	
		try
		{
				
		loginpage=new LoginPage(driver);
		
		logger.info("entering username");
		loginpage.setUsername(username);
		
		logger.info("entering password");
		loginpage.setPassword(password);
		
		logger.info("clicking on login button");
		loginpage.clickLoginButton();
		
		String title=driver.getTitle();
		if(title.equals("Guru99 Bank Manager HomePage" ))
		{
			logger.info("login successful");
			Assert.assertTrue(true);
		}
		else
		{
			logger.info("login unsuccessful");
			Assert.assertTrue(false);
		}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			Assert.fail();
		}
		logger.info("************ending TC_001_Login_test*****************");	
	
	}
}
