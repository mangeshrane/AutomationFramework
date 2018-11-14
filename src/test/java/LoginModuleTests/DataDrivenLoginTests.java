package LoginModuleTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import configProvider.Configuration;
import dataProviders.LoginDataProvider;
import pages.LoginPage;
import testBase.DriverFactory;

public class DataDrivenLoginTests extends DriverFactory {
	WebDriver driver;
	LoginPage loginPage;

	@BeforeClass
	@Parameters("browser")
	public void setup(String browser) {
		setDriver(browser);
		driver = getDriver();
		loginPage = PageFactory.initElements(driver, LoginPage.class);
		driver.get(Configuration.getConfig("application.url"));
	}

	@Test(dataProviderClass = LoginDataProvider.class, dataProvider = "loginCredentials")
	public void login(String username, String password) {
		log.info("Logging in using username: " + username + " password: " + password);
		loginPage.login(Configuration.getConfig("application.user.username"), Configuration.getConfig("application.user.password"));
		AssertJUnit.assertEquals(driver.getTitle(), "Aurus Leave Management");
	}

	@AfterClass
	public void teardown() {
		driver.quit();
	}
}
