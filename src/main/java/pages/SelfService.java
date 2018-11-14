package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.LoadableComponent;

public class SelfService extends LoadableComponent<SelfService>{
	public WebDriver driver;
	public NavigationBar navigation;
	
	public SelfService(WebDriver driver) {
		this.driver = driver;
	}

	@Override
	protected void load() {
		navigation = new NavigationBar(driver);
	}

	@Override
	protected void isLoaded() throws Error {
		// unimplemented
		
	}
	
	
	
}
