package AutomationBasic;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class LoginAutomation extends BaseDriver {
	
	String Url="https://www.wafilife.com/my-account";
	
	@Test
	public void SelectWritter() throws InterruptedException {
		
		driver.get(Url);	
        driver.manage().window().maximize();
		Thread.sleep(2000); // 1000 = 1sec
		
		driver.findElement(By.xpath("//input[@id='username']")).clear();
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("email");
		driver.findElement(By.xpath("//input[@id='password']")).clear();
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("password");
		driver.findElement(By.name("login")).click();
		Thread.sleep(5000); // 1000 = 1sec
		
        
	}

}
