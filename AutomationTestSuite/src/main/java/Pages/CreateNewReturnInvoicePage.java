package Pages;

import java.nio.file.Paths;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CreateNewReturnInvoicePage extends PageBase {
	public CreateNewReturnInvoicePage(WebDriver driver) {
		super(driver);
	}
	

	private By hasNoReferenceInvoice_Btn = By.id("has_no_reference_invoice");
	private By cashBack_Btn = By.id("cashback");

	private By referenceInvoiceNumber_Input = By.xpath("//input[contains(@class,'mantine-Input-input')]");
	private By invoiceNumber_Input = By.name("invoice_number");
	private By clientName_Input = By.xpath("//input[contains(@class,'mantine-Input-input')]");
	private By invoiceDate_Input = By.xpath("(//button[contains(@class,'mantine-DatePickerInput-input')])[1]");
	private By paymentDate_Input = By.xpath("(//button[contains(@class,'mantine-DatePickerInput-input')])[2]");
	private By invoiceNotes_Input = By.name("description");
	private By upload_Btn=By.xpath("//input[@type='file']");
	private By editProduct_Btn = By.xpath("//div[@class='controls']/div");
	private By productQuantity_Input = By.name("quantity");
	
	private By next_Btn = By.xpath("//button[@type='submit']");
	private By addToList_Btn = By.xpath("//button[@type='submit']");
	private By create_Btn = By.xpath("(//button[@type='button'])[6]");
	
	
	
	public void CreateNewReturnInvoice(String referenceInvoiceNumber, String invoiceNumber, String invoiceDate, String paymentDate, String invoiceNotes, String quantity) throws InterruptedException {
		driverWait.until(ExpectedConditions.elementToBeClickable(next_Btn)).click();
		handleLoaderDisplay();
		selectFromList(referenceInvoiceNumber_Input, referenceInvoiceNumber);
		handleLoaderDisplay();
		driverWait.until(ExpectedConditions.elementToBeClickable(next_Btn)).click();
		handleLoaderDisplay();
		
		driver.findElement(invoiceNumber_Input).sendKeys(invoiceNumber);
		setDate(invoiceDate_Input, invoiceDate);
		Thread.sleep(1000);
		setDate(paymentDate_Input, paymentDate);
		driver.findElement(invoiceNotes_Input).sendKeys(invoiceNotes);
		String filePath = Paths.get("src/test/resources/attachment.pdf").toAbsolutePath().toString();
		driver.findElement(upload_Btn).sendKeys(filePath);
		driver.findElement(next_Btn).click();
		handleLoaderDisplay();
		
		driverWait.until(ExpectedConditions.elementToBeClickable(editProduct_Btn)).click();
		handleLoaderDisplay();
		driver.findElement(productQuantity_Input).sendKeys(Keys.BACK_SPACE);
		driver.findElement(productQuantity_Input).sendKeys(quantity);
		driver.findElement(addToList_Btn).click();
		handleLoaderDisplay();
		driver.findElement(create_Btn).click();
		handleLoaderDisplay();
		
	}
	
	public void CreateNewReturnInvoiceWithReferenceInvoice() {
		driver.findElement(hasNoReferenceInvoice_Btn).click();
		driverWait.until(ExpectedConditions.elementToBeClickable(next_Btn)).click();
		handleLoaderDisplay();
		
	}

}
