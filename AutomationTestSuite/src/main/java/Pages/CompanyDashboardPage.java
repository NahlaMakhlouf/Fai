package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CompanyDashboardPage extends PageBase {
	public CompanyDashboardPage(WebDriver driver) {
		super(driver);
	}

	private By financialManagenet_list = By.xpath("(//span[@class='mantine-gm39d mantine-Accordion-label'])[1]");
	private By reports_List = By.xpath("(//span[@class='mantine-gm39d mantine-Accordion-label'])[2]");

	public boolean isCompanyNameDisplayed(String companyName) {
		driverWait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[@class='title']/p[text()='" + companyName + "']")));
		return true;
	}

	public void openModule(String moduleName) {
		By dynamicLocator = By.xpath("//a[contains(@href, '" + moduleName + "')]");
		if (moduleName == "sales" || moduleName == "purchases") {
			driver.findElement(financialManagenet_list).click();

		} else if (moduleName.contains("reports")) {
			driver.findElement(reports_List).click();

		}
		driverWait.until(ExpectedConditions.visibilityOfElementLocated(dynamicLocator)).click();
		handleLoaderDisplay();
	}
	


}
