package objectRepositories;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import webDriverutilities.WebDriverUtilits;


public class Homepage extends WebDriverUtilits {
	
	public Contactspage c; 
	public Homepage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//a[text()='Contacts']")
	private WebElement contacts;
	@FindBy(xpath="//td[@class='tabUnSelected']/a[text()='Organizations']")
	private WebElement orgs;

	public WebElement getOrgs() {
		return orgs;
	}
	public WebElement getContacts() {
		return contacts;
	}
	public Contactspage clickOnContacts()
	{
		getContacts().click();
		c = new Contactspage(driver);
		return c;
	}
	public Organizationspage clickOnOrganizatios()
	{
		getOrgs().click();
		Organizationspage o = new Organizationspage(driver);
		return o;
	}

}
