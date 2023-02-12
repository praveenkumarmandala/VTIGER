import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import baseclass.BaseTest;
import objectRepositories.Contactspage;
import objectRepositories.Homepage;

@Listeners(testUtilities.Listenerstest.class)
public class TC_05 extends BaseTest{
	
	@Test 
	public void selectOrgName() throws IOException, Exception
	{
		Homepage h = new Homepage(driver);
		Contactspage c= h.clickOnContacts();
		c.enterName(du.excelData("Sheet3",1,1));
		c.selectOrgName();
		c.clickSaveBtn();
		Assert.assertTrue(c.validationmsg().contains("Praveen"));
	}
	
}
