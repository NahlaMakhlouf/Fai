package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class DashboardPage extends PageBase {
	public DashboardPage(WebDriver driver) {
		super(driver);
	}
	
	public void browseCompany(String companyName) {
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//div[@class='companyName'][text()='"+ companyName + "']")));
		handleLoaderDisplay();
		
		}

}
