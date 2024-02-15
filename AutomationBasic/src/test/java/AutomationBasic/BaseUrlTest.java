package AutomationBasic;

import org.testng.Assert;
import org.testng.annotations.Test;

public class BaseUrlTest extends BaseDriver{
	
	String Url="https://www.wafilife.com/";
	
	@Test
	public void OpenUrl() throws InterruptedException{
		driver.get(Url);
        driver.manage().window().maximize();
		Thread.sleep(5000); // 1000 = 1sec
		String title=driver.getTitle();
		String expected="Buy Islamic Books - Online Book Shop in Bangladesh | Wafilife";
        Assert.assertEquals(title, expected, "Text does not match the expected value.");
	}
}
