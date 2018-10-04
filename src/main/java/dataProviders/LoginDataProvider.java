package dataProviders;

import org.testng.annotations.DataProvider;

public class LoginDataProvider {
	
	@DataProvider
	public static Object[][] loginCredentials(){
		return new Object[][] {{"test@test.com", "qwert123"},{"qwe@test.com", "qwer123"},{"qwezx@test.com", "qwer123"},{"qweqwe@test.com", "qwer123"}};
	}

}
