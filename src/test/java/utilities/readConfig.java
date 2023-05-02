package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class readConfig {

	Properties pro;
	
	public readConfig()	//constructor created to load the file
	{
		File src=new File("C:\\Users\\13313\\Downloads\\java projects\\inetBanking_testNG\\src\\test\\resources\\config.properties");
		try
		{
			FileInputStream fis=new FileInputStream(src);
			pro=new Properties();
			pro.load(fis);
		}catch(Exception e)
		{
			System.out.println("exception is "+e.getMessage());
		}
	}
	
	public String getApplicationUrl()
	{
		String url=pro.getProperty("appURL");
		return url;
	}
	
	public String getUserName()
	{
		String username=pro.getProperty("username");
		return username;
	}
	
	public String getPassword()
	{
		String password=pro.getProperty("password");
		return password;
	}
	
}
