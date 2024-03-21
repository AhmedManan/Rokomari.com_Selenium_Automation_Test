package AutomationBasic;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class IFrameHandling extends BaseDriver {

	String Url="https://demoqa.com/frames";
	
	@Test
	public void IFrame() throws InterruptedException {
		
		driver.get(Url);	
        driver.manage().window().maximize();
		Thread.sleep(2000); // 1000 = 1sec
		
		List<WebElement> iframeNumber = driver.findElements(By.tagName("iframe"));
		System.out.println(iframeNumber.size());
		
		driver.switchTo().frame("frame1");
		
		WebElement text = driver.findElement(By.xpath("//h1[@id='sampleHeading']"));
		System.out.println(text.getText());

		driver.switchTo().defaultContent();
		driver.switchTo().frame("frame2");
		
		WebElement text2 = driver.findElement(By.xpath("//h1[@id='sampleHeading']"));
		System.out.println(text2.getText());
	}
}
