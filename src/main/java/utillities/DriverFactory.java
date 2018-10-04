package utillities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import configProvider.Configuration;
import testBase.BaseClass;

public class DriverFactory extends BaseClass{

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
				log.info("Chrome Browser Started");
				break;

			case FIREFOX:
				System.setProperty("webdriver.ghecko.driver", Configuration.getConfig("webdriver.ghecko.driver"));
				driver = new FirefoxDriver();
				log.info("Firefox Browser Started");
				break;

			case IE:
				System.setProperty("webdriver.ie.driver", Configuration.getConfig("webdriver.ie.driver"));
				driver = new InternetExplorerDriver();
				log.info("IE Browser Started");
				break;

			case SAFARI:
				System.setProperty("webdriver.safari.noinstall", "true"); // To stop uninstall each time
				driver = new SafariDriver();
				log.info("SAFARI Browser Started");

			default:
				System.setProperty("webdriver.chrome.driver", Configuration.getConfig("webdriver.chrome.driver"));
				driver = new ChromeDriver();
				log.info("using deafult Chrome Browser Started");
				break;
			}
		}
		driverHolder.set(driver);
	}

	public WebDriver getDriver() {
		return driverHolder.get();
	}

}
