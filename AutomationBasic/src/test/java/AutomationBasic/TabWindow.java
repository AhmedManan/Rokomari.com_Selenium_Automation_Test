package AutomationBasic;

import org.openqa.selenium.WindowType;
import org.testng.annotations.Test;

public class TabWindow extends BaseDriver{

	String Url="https://demoqa.com/frames";
	String secondUrl="https://www.daraz.com.bd/";
	
	@Test
	public void TabWindow() throws InterruptedException {
		
		driver.get(Url);	
        driver.manage().window().maximize();
		Thread.sleep(2000); // 1000 = 1sec
		
		String OrginalTab= driver.getWindowHandle();
		Thread.sleep(3000);
		
		driver.switchTo().newWindow(WindowType.WINDOW);
		String secondTab= driver.getWindowHandle();
		driver.get(secondUrl);
		Thread.sleep(3000);
		
		driver.switchTo().window(OrginalTab);
		
		
	}
}
