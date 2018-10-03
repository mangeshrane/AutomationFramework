package utillities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import configProvider.Configuration;

public class DriverFactory {

	private WebDriver driver;

	ThreadLocal<WebDriver> driverHolder = new ThreadLocal<WebDriver>();

	enum Browsers {
		CHROME, FIREFOX, IE, SAFARI
	}

	{
		Browsers browser = Browsers.CHROME;
		browser = Browsers.valueOf(Configuration.getConfig("webdriver.browser"));
		if (Configuration.getConfig("webdriver.type").equalsIgnoreCase("GRID")) {
			DesiredCapabilities capabilities = new DesiredCapabilities();
			driver = new RemoteWebDriver(capabilities);
		} else {
			switch (browser) {
			case CHROME:
				System.setProperty("webdriver.chrome.driver", Configuration.getConfig("webdriver.chrome.driver"));
				driver = new ChromeDriver();
				break;

			case FIREFOX:
				System.setProperty("webdriver.ghecko.driver", Configuration.getConfig("webdriver.ghecko.driver"));
				driver = new FirefoxDriver();
				break;

			case IE:
				System.setProperty("webdriver.ie.driver", Configuration.getConfig("webdriver.ie.driver"));
				driver = new InternetExplorerDriver();
				break;

			case SAFARI:
				System.setProperty("webdriver.safari.noinstall", "true"); // To stop uninstall each time
				driver = new SafariDriver();

			default:
				System.setProperty("webdriver.chrome.driver", Configuration.getConfig("webdriver.chrome.driver"));
				driver = new ChromeDriver();
				break;
			}
		}
		driverHolder.set(driver);
	}

	public WebDriver getDriver() {
		return driverHolder.get();
	}

}
