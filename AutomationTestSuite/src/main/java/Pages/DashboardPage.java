package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class DashboardPage extends PageBase {
	public DashboardPage(WebDriver driver) {
		super(driver);
	}
	
	private By createNewCompany_Btn= By.xpath("(//div[@class='controlButton']/button)[1]");
	
	public void browseCompany(String companyName) {
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//div[@class='companyName'][text()='"+ companyName + "']")));
		handleLoaderDisplay();
		
		}
	
	public void openCreateNewCompanyPage() {
		driverWait.until(ExpectedConditions.elementToBeClickable(createNewCompany_Btn)).click();
		
	}

}
