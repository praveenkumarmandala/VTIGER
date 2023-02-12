package testCases;
import org.testng.Assert;
import org.testng.annotations.Test;

import baseclass.BaseTest;
import objectRepositories.Contactspage;
import objectRepositories.Homepage;

public class TC_05 extends BaseTest{
	
	@Test 
	public void selectOrgName()
	{
		Homepage h = new Homepage(driver);
		Contactspage c= h.clickOnContacts();
		c.enterName("Praveen");
		c.selectOrgName();
		c.clickSaveBtn();
		Assert.assertTrue(c.validationmsg().contains("Praveen"));
	}
	
}
