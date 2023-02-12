package baseclass;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;


import dataUtility.DataUtility;
import objectRepositories.Loginpage;

public class BaseTest {
	
	public WebDriver driver;
	public DataUtility du = new DataUtility();
	public Loginpage log; 
	
	
	@BeforeSuite
	public void dbOpen()
	{
		System.out.println("DB OPEN");
	}
	@BeforeClass
	public void launchBrowser() throws IOException
	{
		String URL = du.propertfileData("url");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(URL);	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	@BeforeMethod
	public void loginApp() throws Exception
	{
		
		String USERNAME = du.propertfileData("username");
		String PASSWORD = du.propertfileData("password");
		log = new Loginpage(driver);
		log.login(USERNAME, PASSWORD);			
	}
	@AfterMethod
	public void logOut()
	{
		log.logout();
	}
	@AfterClass
	public void closeBroewser()
	{
		driver.quit();
	}
	@AfterSuite
	public void dbClose()
	{
		System.out.println("db close");
	}

}
