package AutomationBasic;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class WaitExample extends BaseDriver{

	String Url="https://www.wafilife.com/";
	
	@Test
	public void waitTest() throws InterruptedException {
        driver.manage().window().maximize();
		driver.get(Url);
		
		//Implicit
		//driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		//Explicit
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		WebElement search = (WebElement) wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='header_search']//input[@id='freeSearchBoxWeb']")));
	}
}
