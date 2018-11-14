package pages;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.LoadableComponent;

public class DashBoard extends LoadableComponent<DashBoard>{
	
	public WebDriver driver;
	NavigationBar navigation;
	
	public DashBoard(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(xpath="//a[contains(text(), 'Apply Leave')]")
	WebElement applyLeaveBtn;

	@Override
	protected void load() {
		navigation = new NavigationBar(driver).get();
	}

	@Override
	protected void isLoaded() throws Error {
		assertTrue(applyLeaveBtn.isDisplayed());
	}
	

}
