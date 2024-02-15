package AutomationBasic;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ViewBooksByWriter extends BaseDriver {
	
	String Url="https://www.wafilife.com/";
	
	@Test
	public void SelectWritter() throws InterruptedException {
		
		driver.get(Url);	
        driver.manage().window().maximize();
		Thread.sleep(2000); // 1000 = 1sec
		
		driver.findElement(By.xpath("//span[@class='menu-label-level-0'][contains(text(),'লেখক')]")).click();
		Thread.sleep(5000); // 1000 = 1sec
		
		//Verify Page Title
		String title=driver.getTitle();
		String expected="English & Bangla Islamic Books by Authors | Wafilife";
        Assert.assertEquals(title, expected, "Text does not match the expected value.");
        
		//Verify Page Url        
		String pageUrl=driver.getCurrentUrl();
		String expectedUrl="https://www.wafilife.com/cat/books/author";
        Assert.assertEquals(pageUrl, expectedUrl, "Text does not match the expected value.");
        
		driver.findElement(By.xpath("//h3[normalize-space()='M. N. Pearson']")).click();
		Thread.sleep(5000); // 1000 = 1sec
		
		//Verify Page Title
		String title2=driver.getTitle();
		String expected2="M. N. Pearson Books | List of books by author M. N. Pearson | Wafilife";
        Assert.assertEquals(title2, expected2, "Text does not match the expected value.");
        
		//Verify Page Url        
		String pageUrl2=driver.getCurrentUrl();
		String expectedUrl2="https://www.wafilife.com/cat/books/author/m-n-pearson";
        Assert.assertEquals(pageUrl2, expectedUrl2, "Text does not match the expected value.");
        
	}

}
