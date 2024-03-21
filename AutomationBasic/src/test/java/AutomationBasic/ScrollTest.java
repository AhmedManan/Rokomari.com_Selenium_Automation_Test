package AutomationBasic;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class ScrollTest extends BaseDriver {
	
	String Url="https://www.wafilife.com/";
	
	@Test
	public void Scroll() throws InterruptedException {
		
		driver.get(Url);	
        driver.manage().window().maximize();
		Thread.sleep(2000); // 1000 = 1sec
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		//down
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Thread.sleep(5000); // 1000 = 1sec
		
		//Specific
		WebElement location = driver.findElement(By.xpath("//a[contains(text(),'দুআ ও যিকির')]"));
		js.executeScript("arguments[0].scrollIntoView(true)", location);
		Thread.sleep(10000); // 1000 = 1sec
		
		//Top
		js.executeScript("window.scrollTo(0,0)");
		Thread.sleep(5000); // 1000 = 1sec
        
	}

}
