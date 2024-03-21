package AutomationBasic;

import org.testng.annotations.Test;

public class AssertionExample extends BaseDriver {
	
	String Url="https://www.wafilife.com/";
	
	@Test
	public void Scroll() throws InterruptedException {
		
		driver.get(Url);	
        driver.manage().window().maximize();
		Thread.sleep(2000); // 1000 = 1sec
	}
}