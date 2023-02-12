import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import baseclass.BaseTest;
import objectRepositories.Contactspage;
import objectRepositories.Homepage;


@Listeners(testUtilities.Listenerstest.class)
public class TC_01_Contacts extends BaseTest{
	@Test
	public void newContact() throws IOException, Exception
	{
		Homepage h = new Homepage(driver);
		Contactspage c = h.clickOnContacts();
		c.enterName(du.excelData("Sheet3",1,1));
		c.clickSaveBtn();
		Assert.assertTrue(c.validationmsg().contains("praveen"));
		
	}

}
