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
	
	public void passCaseWithSC(String message, String scName) throws IOException {
		test.pass("<p style=\"color:#85BC63; font-size:13px\"><b>" + message + "</b></p>");
		String screenShotPath = GetScreenShot.capture(PageDriver.getCurrentDriver(), "" + scName + "");
		String dest = System.getProperty("user.dir") + "\\screenshots\\" + "" + scName + ".png";
		test.fail(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
		PageDriver.getCurrentDriver().quit();
	}
	
	public void login() throws InterruptedException, IOException {
		
		try {
			test.info("Please enter username");
			if(username.isDisplayed()) {
				username.sendKeys("admin");
				passCase("Username Entered");
			}
		}catch(Exception e){
			failCase("Username was not located, Please check the error message.","usernamefail");
		}
		
		try {
			test.info("Please enter password");
			if(password.isDisplayed()) {
				password.sendKeys("admin");
				passCase("Password Sent");
			}
		}catch(Exception e){
			failCase("Password was not located, Please check the error message.","passwordfail");
		}
		try {
			test.info("Click on the link");
			if(loginButton.isDisplayed()) {
				loginButton.click();
				Thread.sleep(1000);
				passCaseWithSC("Login Successfull","loginPass");
			}
		}catch(Exception e) {
			failCase("Login button was not located, Please check the error message.","loginbuttonfail");
		}
		Thread.sleep(1000);
	}
}
