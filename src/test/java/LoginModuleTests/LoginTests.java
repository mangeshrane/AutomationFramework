package LoginModuleTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import configProvider.Configuration;
import pages.LoginPage;
import testBase.BaseClass;

public class LoginTests extends BaseClass{
	
	WebDriver driver;
	LoginPage loginPage;
	
	@BeforeClass
	public void setup() {
		driver = new BaseClass().getDriver();
		loginPage = PageFactory.initElements(driver, LoginPage.class);
		driver.get(Configuration.getConfig("application.url"));
	}
	
	
	@Test
	public void login() {
		loginPage.login(Configuration.getConfig("application.user.username"), Configuration.getConfig("application.user.password"));
		AssertJUnit.assertEquals(driver.getTitle(), "Aurus Leave Management");
	}
	
	@Test
	public void invalidLogin() {
		loginPage.login("qwertyu", "qwerr134");
		AssertJUnit.assertTrue(loginPage.errorMessage.isDisplayed());
	}
	
	@AfterClass
	public void teardown() {
		driver.quit();
	}
	
}
