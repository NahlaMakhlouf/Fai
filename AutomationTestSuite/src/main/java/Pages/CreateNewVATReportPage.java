package Pages;

import java.nio.file.Paths;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class CreateNewVATReportPage extends PageBase{
	public CreateNewVATReportPage(WebDriver driver) {
		super(driver);
	}
	
	private By step_No = By.xpath("//p[contains(@class, 'sc-jJEJze')]");
	private By ArName_Input = By.name("name.ar");
	private By EnName_Input = By.name("name.en");
	private By period_Input = By.xpath("(//input[contains(@class,'mantine-Input-input')])[1]");
	private By year_Input = By.xpath("(//input[contains(@class,'mantine-Input-input')])[2]");
	private By menu_item = By.xpath("(//div[contains(@class, 'mantine-Select-item')])[1]");
	private By description_Input = By.name("description");
	private By upload_Btn=By.xpath("//input[@type='file']");
	private By next_Btn = By.xpath("//button[@type='submit']");
	private By create_Btn = By.cssSelector("button.sc-eCstZk.dDpUpp");
	
	public String getStepInfo() {
		return driverWait.until(ExpectedConditions.visibilityOfElementLocated(step_No)).getText();
	}
	
	public void createNewReportStep1 (String ArName, String EnName, String period, String year, String description) throws InterruptedException {
		driver.findElement(ArName_Input).sendKeys(ArName);
		driver.findElement(EnName_Input).sendKeys(EnName);
		selectFromList(period_Input, period, menu_item);
		selectFromList(year_Input, year, menu_item);
		driver.findElement(description_Input).sendKeys(description);
		String filePath = Paths.get("src/test/resources/attachment.pdf").toAbsolutePath().toString();
		driver.findElement(upload_Btn).sendKeys(filePath);
		driver.findElement(next_Btn).click();
		handleLoaderDisplay();
	}
	
	public void createNewReportStep2() {
		driverWait.until(ExpectedConditions.elementToBeClickable(create_Btn)).click();
		handleLoaderDisplay();
	}
}
