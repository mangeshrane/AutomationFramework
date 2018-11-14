package pages;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

public class NavigationBar extends LoadableComponent<NavigationBar>{
	
	public WebDriver driver;
	
	public NavigationBar(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(xpath="//a/b[contains(text(), 'Dashboard')]")
	WebElement dashBoard;
	
	@FindBy(xpath="//a/b[contains(text(), 'Self Service')]")
	WebElement selfService;
	
	@FindBy(xpath="//a/b[contains(text(), 'Time')]")
	WebElement Time;
	
	public DashBoard goToDashBoard() {
		dashBoard.click();
		return PageFactory.initElements(driver, DashBoard.class);
	}
	
	public SelfService goToSelfService() {
		dashBoard.click();
		return PageFactory.initElements(driver, SelfService.class);
	}
	
	public pages.Time goToTime() {
		dashBoard.click();
		return PageFactory.initElements(driver, Time.class);
	}

	@Override
	protected void load() {
		
	}

	@Override
	protected void isLoaded() throws Error {
		assertTrue(Time.isDisplayed());
	}
}
