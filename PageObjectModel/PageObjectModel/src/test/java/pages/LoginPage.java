package pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

import base.drivers.PageDriver;
import utilities.GetScreenShot;

public class LoginPage {

	ExtentTest test;
	public LoginPage(ExtentTest test) {
		PageFactory.initElements(PageDriver.getCurrentDriver(), this);
		this.test = test;
	}
	
	@FindBys({
	    @FindBy(xpath="//input[@id='username']"),
	    @FindBy(name="username")
	})
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(name="login")
	WebElement loginButton;
	
	public void failCase(String message, String scName) throws IOException {
		test.fail("<p style=\"color:#FF5353; font-size:13px\"><b>" + message + "</b></p>");
		Throwable t = new InterruptedException("Exception");
		test.fail(t);
		String screenShotPath = GetScreenShot.capture(PageDriver.getCurrentDriver(), "" + scName + "");
		String dest = System.getProperty("user.dir") + "\\screenshots\\" + "" + scName + ".png";
		test.fail(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
		PageDriver.getCurrentDriver().quit();
	}
	
	public void passCase(String message) {
		test.pass("<p style=\"color:#85BC63; font-size:13px\"><b>" + message + "</b></p>");
	}
	
	public void login() throws InterruptedException, IOException {
		
		try {
			test.info("Please enter username");
			if(username.isDisplayed()) {
				username.sendKeys("admin");
				test.pass("<p style=\"color:#85BC63; font-size:13px\"><b>" + "Test Passed" + "</b></p>");
			}
		}catch(Exception e){
			test.fail("<p style=\"color:#FF5353; font-size:13px\"><b>" + "Username is not located. Please check the error message" + "</b></p>");
			Throwable t = new InterruptedException("Exception");
			test.fail(t);
			String screenShotPath = GetScreenShot.capture(PageDriver.getCurrentDriver(), "" + "usernameFail" + "");
			String dest = System.getProperty("user.dir") + "\\screenshots\\" + "" + "usernameFail" + ".png";
			test.fail(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
			PageDriver.getCurrentDriver().quit();
		}
		
		try {
			test.info("Please enter password");
			if(password.isDisplayed()) {
				password.sendKeys("admin");
				test.pass("<p style=\"color:#85BC63; font-size:13px\"><b>" + "Test Passed" + "</b></p>");
			}
		}catch(Exception e){

		}
		
		loginButton.click();
		Thread.sleep(1000);
	}
}
