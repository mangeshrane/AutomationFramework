package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NavigationBar {
	
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
}
