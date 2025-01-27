package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PurchasesPage extends PageBase {
	public PurchasesPage(WebDriver driver) {
		super(driver);
	}

	private By generateInvoice_List = By.cssSelector("button.sc-eCstZk.dQmibS");
	private By createInvoice_Btn = By.xpath("(//button[contains(@class, 'mantine-Menu-item')])[1]");
	private By createReturnInvoice_Btn = By.xpath("(//button[contains(@class, 'mantine-Menu-item')])[2]");
	private By importInvoices_Btn = By.xpath("(//button[contains(@class, 'mantine-Menu-item')])[3]");

	public void openImportInvoicesPage() {
		driverWait.until(ExpectedConditions.elementToBeClickable(generateInvoice_List)).click();
		driver.findElement(importInvoices_Btn).click();
		handleLoaderDisplay();
	}
	
	public void openCreateInvoicePage() {
		driverWait.until(ExpectedConditions.elementToBeClickable(generateInvoice_List)).click();
		driver.findElement(createInvoice_Btn).click();
		handleLoaderDisplay();
		
	}
	public void openCreateReturnInvoicePage() {
		driverWait.until(ExpectedConditions.elementToBeClickable(generateInvoice_List)).click();
		driver.findElement(createReturnInvoice_Btn).click();
		handleLoaderDisplay();
		
	}

}