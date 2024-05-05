package tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.drivers.BaseDriver;
import base.drivers.PageDriver;
import pages.LoginPage;

public class LoginTest extends BaseDriver{

	@BeforeClass
	public void start() throws InterruptedException {
		PageDriver.getCurrentDriver().get(url);
		Thread.sleep(5000);
	}
	
	@Test
	public void loginTest() throws InterruptedException {
		LoginPage loginPage = new LoginPage();
		loginPage.login();
	}
}
