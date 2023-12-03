package AutomationBasic;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class BaseUrlTest extends BaseDriver{
	
	String Url="https://digital-aid.ahmedmanan.com/";
	
	@Test
	public void OpenUrl() throws InterruptedException{
		driver.get(Url);
		driver.manage().window().maximize();
		
		driver.findElement(By.cssSelector("html > body > div > div > div > div > div > div > h1")).click();
		
		Thread.sleep(5000); // 1000 = 1 sec 
	}
}
