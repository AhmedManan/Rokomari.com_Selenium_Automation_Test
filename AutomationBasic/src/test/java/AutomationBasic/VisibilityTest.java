package AutomationBasic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class VisibilityTest extends BaseDriver {

	String Url="https://www.wafilife.com/";
	
	@Test
	public void SelectWritter() throws InterruptedException {
		
		driver.get(Url);	
        driver.manage().window().maximize();
		Thread.sleep(2000); // 1000 = 1sec
		WebElement search = driver.findElement(By.xpath("//div[@class='header_search']//input[@id='freeSearchBoxWeb']"));
		
		try {
			if(search.isDisplayed()){
				search.click();
				search.sendKeys("email");
				Thread.sleep(2000);
			}
		}catch(Exception e){
			System.out.println("Search was not found");
		}
		
	}
}
