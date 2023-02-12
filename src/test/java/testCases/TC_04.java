package testCases;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseclass.BaseTest;
import objectRepositories.Homepage;
import objectRepositories.Organizationspage;

public class TC_04 extends BaseTest {
	@Test
	public void select_Industry_AccType() throws IOException, Exception
	{
		Homepage h = new Homepage(driver);
		Organizationspage o = h.clickOnOrganizatios();
		o.enterOrgName(du.excelData("Sheet3",2,1));
		o.selectIndustry(du.excelData("Sheet3",4,1));
		o.selectAccType(du.excelData("Sheet3",4,3));
		o.savebutton();
		Assert.assertTrue(o.orgvalidationtext().contains("QSP"));
	}
	

}
