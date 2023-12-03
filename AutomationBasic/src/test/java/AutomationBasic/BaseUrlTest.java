package AutomationBasic;

import org.testng.annotations.Test;

public class BaseUrlTest extends BaseDriver{
	
	String Url="https://digital-aid.ahmedmanan.com/";
	
	@Test
	public void OpenUrl(){
		driver.get(Url);
	}
}
