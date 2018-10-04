package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashBoard extends NavigationBar{
	
	public WebDriver driver;
	
	public DashBoard(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//a[contains(text(), 'Apply Leave')]")
	WebElement applyLeaveBtn;
	
	

}
