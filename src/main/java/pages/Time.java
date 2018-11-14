package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.LoadableComponent;

public class Time extends LoadableComponent<Time>{
	
	public WebDriver driver;
	
	public Time(WebDriver driver) {
		this.driver = driver;
	}

	@Override
	protected void load() {
		// TODO
	}

	@Override
	protected void isLoaded() throws Error {
		// TODO 
		
	}

}
