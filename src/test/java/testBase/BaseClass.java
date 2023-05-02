package testBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import pageObjects.AddNewAccountPage;
import pageObjects.AddingNewCustomer;
import pageObjects.DeleteCustomerPage;
import pageObjects.EditCustomerPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import utilities.readConfig;

public class BaseClass {

	// public static readConfig config=new readConfig();
//	public String baseUrl=config.getApplicationUrl();
//	public String username=config.getUserName();
//	public String password=config.getPassword();

	protected static WebDriver driver;
	protected static LoginPage loginpage;
	protected static HomePage homepage;
	protected static AddingNewCustomer addnewcust;
	protected static EditCustomerPage editcust;
	protected static DeleteCustomerPage deletecust;
	protected static AddNewAccountPage addnewacc;
	protected static ResourceBundle rb;
	protected Logger logger;
	protected String baseUrl;
	protected String username;
	protected String password;
	
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String browser) throws Exception {

		rb = ResourceBundle.getBundle("config");

		logger = LogManager.getLogger(this.getClass());
		
		if(browser.equalsIgnoreCase("edge"))
		{
		driver = new EdgeDriver();
		}
		
		else if(browser.equalsIgnoreCase("firefox"))
		{
		driver = new FirefoxDriver();
		}
		
		else if(browser.equalsIgnoreCase("chrome"))
		{
		driver = new ChromeDriver();
		}
		
		else
		{
			throw new Exception("Browser is not correct");
		}
		
		
		logger.info(" browser launched");

		baseUrl = rb.getString("appURL");
		driver.get(baseUrl);
		logger.info("application url opened");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();

		username = rb.getString("username"); // reading username from config file and assigning it to variable
		password = rb.getString("password");
	}

	@AfterClass
	public void tearDown() {
	
		//driver.quit();
	}
	
	public String randomAlphabetic()
	{
		 String generatedString=RandomStringUtils.randomAlphabetic(5);
		 return generatedString;
	}
	
	public String randomNumber()
	{
		String generatedNumber=RandomStringUtils.randomNumeric(10);
		return generatedNumber;
	}
	
	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";

		try {
			FileUtils.copyFile(source, new File(destination));
			
		} catch (Exception e) {
			e.getMessage();
		}
		return destination;
	}
}
