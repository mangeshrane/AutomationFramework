package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(id="username")
	WebElement username;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(id="loginsubmit")
	WebElement loginButtonBtn;
	
	@FindBy(id="forgotpwdtext")
	WebElement forgotPassword;
	
	@FindBy(id="emailaddress")
	public WebElement emailAddress;
	
	@FindBy(xpath="//*[@value='Send password']")
	public WebElement sendPasswordBtn;
	
	@FindBy(xpath="//div[@id='usernameerror']")
	public WebElement errorMessage;
	
	public DashBoard login(String username, String password) {
		this.username.clear();
		this.username.sendKeys(username);
		this.password.clear();
		this.password.sendKeys(password);
		this.loginButtonBtn.click();
		return PageFactory.initElements(driver, DashBoard.class);
	}
	
	public void forgotPassword(String email) {
		forgotPassword.click();
		emailAddress.sendKeys(email);
		sendPasswordBtn.click();
	}
	
}
