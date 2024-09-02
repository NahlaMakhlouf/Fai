package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends PageBase {

	public LoginPage(WebDriver driver) {
		super(driver);	
	}
	
	private By email_Input = By.name("username");
	private By password_Input = By.name("password");
	private By login_Btn = By.xpath("//button[@type='submit']");
	
	
	public void login(String email , String password) throws InterruptedException {
		
	driver.findElement(email_Input).sendKeys(email);
	driver.findElement(password_Input).sendKeys(password);
	driver.findElement(login_Btn).click();
	handleLoaderDisplay();

	
}
	
	

}

