package AutomationBasic;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.testng.annotations.Test;

public class IncognitoMode extends BaseDriver{

	String Url="https://demoqa.com/frames";
	
	@Test
	public void IncognitoMode() throws InterruptedException, AWTException {
		
        driver.manage().window().maximize();
		Thread.sleep(2000); // 1000 = 1sec
		
		Robot robot = new Robot();
		
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.delay(100);
		robot.keyPress(KeyEvent.VK_SHIFT);
		robot.delay(100);
		robot.keyPress(KeyEvent.VK_N);
		robot.delay(100);
		
		robot.keyRelease(KeyEvent.VK_N);
		robot.delay(100);
		robot.keyRelease(KeyEvent.VK_SHIFT);
		robot.delay(100);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.delay(100);
		
		driver.switchTo().window(windowHandling().get(1));
		driver.get(Url);
		Thread.sleep(2000); // 1000 = 1sec
		
		driver.switchTo().window(windowHandling().get(0));
		driver.get(Url);
		Thread.sleep(2000); // 1000 = 1sec
		
		
	}
	
	public List<String> windowHandling() {
		Set<String> WindowHandles = driver.getWindowHandles();
		List<String> WindowHandleList = new ArrayList<String>(WindowHandles);
		return WindowHandleList;
	}
}
