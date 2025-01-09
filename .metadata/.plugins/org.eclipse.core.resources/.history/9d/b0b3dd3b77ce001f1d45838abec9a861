package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ClientsPage extends PageBase{
	public ClientsPage(WebDriver driver) {
		super(driver);
	}
	
	private By addClient_List = By.xpath("//button[@class='sc-eCstZk doAwyZ']");
	private By addClient_Btn = By.xpath("(//button[contains(@class, 'mantine-Menu-item')])[1]");
	
	public void openCreateNewClientPage() {
		driverWait.until(ExpectedConditions.elementToBeClickable(addClient_List)).click();
		driver.findElement(addClient_Btn).click();
		handleLoaderDisplay();
	}

}
