package webDriverutilities;


import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import baseclass.BaseTest;

public class WebDriverUtilits extends BaseTest{
	public WebDriver driver;
	public WebDriverUtilits(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);	
	}
	
	
	
	public void move_To_Element(WebElement ele)
	{
		Actions a = new Actions(driver);
		a.moveToElement(ele).perform();	
	}
	public void double_Click(WebElement ele1)
	{
		Actions a = new Actions(driver);
		a.moveToElement(ele1).doubleClick().perform();	
	}
	public void right_Click(WebElement ele2)
	{
		Actions a = new Actions(driver);
		a.moveToElement(ele2).contextClick().perform();	
	}
	public void select_By_Text(WebElement ele3,String text)
	{
		Select s = new Select(ele3);
		s.selectByVisibleText(text);	
	}

	public void select_By_Index(WebElement ele4,int index)
	{
		Select s = new Select(ele4);
		s.selectByIndex(index);	
	}
	public void select_By_Value(WebElement ele5,String value)
	{
		Select s = new Select(ele5);
		s.selectByValue(value);;	
	}
	public void visibility_Of_Element(WebElement ele6)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(ele6));
	}
	
	
	public void window_Handles()
	{
		String parentwindow = driver.getWindowHandle();
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> itr =  windows.iterator();
		while(itr.hasNext())
		{
			String childwindow = itr.next();
			driver.switchTo().window(childwindow);
		}
		
	}
	/*public void toParentWindow()
	{
		driver.switchTo().window(parentwindow);
		
	}*/

	

		
	
		
		 public void switchToWindow() {
		        Set<String> windows = driver.getWindowHandles();

		        for (String window : windows) {
		            driver.switchTo().window(window);
		        }
		           
		    }

		    public void switchToParentWindow() {
		        String parentWindow = driver.getWindowHandle();
		        driver.switchTo().window(parentWindow);
		    }
}
	

