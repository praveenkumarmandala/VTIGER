package testCases;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseclass.BaseTest;
import objectRepositories.Homepage;
import objectRepositories.Organizationspage;

public class Tc_02_Organization extends BaseTest{
	@Test
	public void newOrganization() throws IOException, Exception
	{
		Homepage h = new Homepage(driver);
		Organizationspage o = h.clickOnOrganizatios();
		o.enterOrgName(du.excelData("Sheet3",2,1));
		o.savebutton();
		Assert.assertTrue(o.orgvalidationtext().contains("QSP"));
		
		
	}

}
