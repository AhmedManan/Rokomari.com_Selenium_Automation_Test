package AutomationBasic;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BaseUrlTest extends BaseDriver{
	
	String Url="https://digital-aid.ahmedmanan.com/";
	
	@Test
	public void OpenUrl() throws InterruptedException{
		driver.get(Url);
		driver.manage().window().maximize();
		
        // Find the element
        String actualText = driver.findElement(By.cssSelector("html > body > div > div > div > div > div > div > h1")).getText();

        // Compare the text with the expected value
        String expectedText = "একটি মশার কামড়ও হতে পারে বিপদজনক!";
        Assert.assertEquals(actualText, expectedText, "Text does not match the expected value.");

        Thread.sleep(5000); // 1000 = 1 sec
	}
}
