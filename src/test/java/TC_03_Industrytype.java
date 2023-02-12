import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import baseclass.BaseTest;
import objectRepositories.Homepage;
import objectRepositories.Organizationspage;


@Listeners(testUtilities.Listenerstest.class)
public class TC_03_Industrytype extends BaseTest {
	@Test
	public void selectIndusrtytype() throws IOException, Exception
	{
	
		Homepage h = new Homepage(driver);
		Organizationspage o = h.clickOnOrganizatios();
		o.enterOrgName(du.excelData("Sheet3",2,1));
		o.selectIndustry(du.excelData("Sheet3",3,1));
		o.savebutton();
		Assert.assertTrue(o.orgvalidationtext().contains("QSP"));	
		
	}

}
