package utillities;

import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {
	
	ThreadLocal<Object> driver = new ThreadLocal<Object>();
	{
		driver.set(new ChromeDriver());
	}
}
