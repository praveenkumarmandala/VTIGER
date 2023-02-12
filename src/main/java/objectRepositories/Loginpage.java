package objectRepositories;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import webDriverutilities.WebDriverUtilits;

public class Loginpage extends WebDriverUtilits{
	WebDriver driver;
	public Loginpage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver,this);	
	}
	@FindBy(xpath="//input[@name='user_name']")
	private WebElement UserName;
	@FindBy(xpath="//input[@name='user_password']")
	private WebElement PassWord;
	@FindBy(xpath="//input[@id='submitButton']")
	private WebElement loginbtn;
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement logoutele;
	@FindBy(xpath="//a[text()='Sign Out']")
	private WebElement sign_out;

	public WebElement getSign_out() {
		return sign_out;
	}
	public WebElement getLogoutele() {
		return logoutele;
	}
	public WebElement getUserName() {
		return UserName;
	}
	public WebElement getPassWord() {
		return PassWord;
	}
	public WebElement getLoginbtn() {
		return loginbtn;
	}
	
	public void login(String Uname,String Pwd)
	{
		getUserName().sendKeys(Uname);
		getPassWord().sendKeys(Pwd);
		getLoginbtn().click();
		
	}
	
	
	public void logout()
	{
		
		move_To_Element(getLogoutele());
		visibility_Of_Element(sign_out);
		getSign_out().click();
	}
	
	

}
