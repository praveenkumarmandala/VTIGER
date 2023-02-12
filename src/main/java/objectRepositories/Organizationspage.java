package objectRepositories;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import webDriverutilities.WebDriverUtilits;

public class Organizationspage extends WebDriverUtilits{


	public Organizationspage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//img[@alt='Create Organization...']")
	private WebElement neworg;
	@FindBy(xpath="//input[@name='accountname']")
	private WebElement orgname;
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement savebtn;
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement orgvalidation;
	@FindBy(xpath="//select[@name='industry']")
	private WebElement industry;
	@FindBy(xpath="//select[@name='accounttype']")
	private WebElement acctype;
	
	public WebElement getAcctype() {
		return acctype;
	}

	public WebElement getIndustry() {
		return industry;
	}
	Random r = new Random();
	
	
	public WebElement getNeworg() {
		return neworg;
	}

	public WebElement getOrgname() {
		return orgname;
	}

	public WebElement getSavebtn() {
		return savebtn;
	}

	public WebElement getOrgvalidation() {
		return orgvalidation;
	}

	public void enterOrgName(String orgName)
	{
		int num = r.nextInt(1000);
		getNeworg().click();
		getOrgname().sendKeys(orgName+num);
			
	}
	public String orgvalidationtext()
	{
		String orgvalid = getOrgvalidation().getText();
		return orgvalid;
	}
	public void selectIndustry(String industrtytype)
	{
		getIndustry().click();
		select_By_Text(getIndustry(),industrtytype);
	}
	public void selectAccType(String accType)
	{
		getAcctype().click();
		select_By_Text(getAcctype(), accType);
	}
	public void savebutton()
	{
		getSavebtn().click();
	}
	

}
