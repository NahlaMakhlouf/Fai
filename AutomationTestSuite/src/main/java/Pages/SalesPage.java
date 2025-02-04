package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SalesPage extends PageBase {
	public SalesPage(WebDriver driver) {
		super(driver);
	}

	private By invoicesRegistration_List = By.xpath("(//button[@class='sc-eCstZk dQmibS'])[2]");
	private By createInvoice_Btn = By.xpath("(//button[contains(@class, 'mantine-Menu-item')])[1]");
	private By createReturnInvoice_Btn = By.xpath("(//button[contains(@class, 'mantine-Menu-item')])[2]");
	private By importInvoices_Btn = By.xpath("(//button[contains(@class, 'mantine-Menu-item')])[3]");

	public void openImportInvoicesPage() {
		driverWait.until(ExpectedConditions.elementToBeClickable(invoicesRegistration_List)).click();
		driver.findElement(importInvoices_Btn).click();
		handleLoaderDisplay();
	}
	
	
	
	public void openCreateInvoicePage() {
		driverWait.until(ExpectedConditions.elementToBeClickable(invoicesRegistration_List)).click();
		driver.findElement(createInvoice_Btn).click();
		handleLoaderDisplay();
		
	}
	public void openCreateReturnInvoicePage() {
		driverWait.until(ExpectedConditions.elementToBeClickable(invoicesRegistration_List)).click();
		driver.findElement(createReturnInvoice_Btn).click();
		handleLoaderDisplay();
		
	}

}