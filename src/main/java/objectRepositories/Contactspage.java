package objectRepositories;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import webDriverutilities.WebDriverUtilits;

public class Contactspage extends WebDriverUtilits {
	
	public Contactspage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//img[@alt='Create Contact...']")
	private WebElement newcontact;
	@FindBy(xpath="//input[@name='lastname']")
	private WebElement name;
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement savebtn;
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement validation;
	@FindBy(xpath="//input[@name='account_name']/following-sibling::img")
	private WebElement orglookupicon;
	@FindBy(xpath="//a[text()='QSP925']")
	private WebElement orgname;
	
	
	public WebElement getOrglookupicon() {
		return orglookupicon;
	}
	public WebElement getOrgname() {
		return orgname;
	}
	public WebElement getValidation() {
		return validation;
	}
	public WebElement getNewcontact() {
		return newcontact;
	}
	public WebElement getName() {
		return name;
	}
	public WebElement getSavebtn() {
		return savebtn;
	}
	public void enterName(String name)
	{
		getNewcontact().click();
		getName().sendKeys(name);
			
	}
	public void selectOrgName()
	{
		getOrglookupicon().click();
		String parentwindow = driver.getWindowHandle();
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> itr =  windows.iterator();
		while(itr.hasNext())
		{
			String childwindow = itr.next();
			driver.switchTo().window(childwindow);
		}

		getOrgname().click();
		driver.switchTo().window(parentwindow);
		
		
	}
	public void clickSaveBtn()
	{
		
		getSavebtn().click();
	}
	public String validationmsg()
	{
		String validationtext = getValidation().getText();
		return validationtext;
	}
	
	
	

}
