package Pages;

import java.nio.file.Paths;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CreateNewReturnInvoicePage extends CreateNewInvoicePage {
	public CreateNewReturnInvoicePage(WebDriver driver) {
		super(driver);
	}

	private By hasNoReferenceInvoice_Btn = By.id("has_no_reference_invoice");
	private By cashBack_Btn = By.id("cashback");

	private By referenceInvoiceNumber_Input = By.xpath("//input[contains(@class,'mantine-Input-input')]");
	private By invoiceNumber_Input = By.name("invoice_number");
	private By invoiceDate_Input = By.xpath("(//button[contains(@class,'mantine-DatePickerInput-input')])[1]");
	private By paymentDate_Input = By.xpath("(//button[contains(@class,'mantine-DatePickerInput-input')])[2]");
	private By invoiceNotes_Input = By.name("description");
	private By upload_Btn = By.xpath("//input[@type='file']");
	private By editProduct_Btn = By.xpath("//div[@class='controls']/div");
	private By productQuantity_Input = By.name("quantity");
	private By productPrice_Input = By.name("product_price");
	private By VATCode_Input = By.xpath("//input[contains(@class,'mantine-Input-input')]");
	private By VATCode_Item = By.xpath("(//div[contains(@class, 'mantine-Select-item')])[2]");

	private By next_Btn = By.xpath("//button[@type='submit']");
	private By addToList_Btn = By.xpath("//button[@type='submit']");
	private By create_Btn = By.xpath("//button[@class='sc-eCstZk cjwIVv']");


	public void CreateNewReturnInvoiceStep1() {
		driverWait.until(ExpectedConditions.elementToBeClickable(next_Btn)).click();
		handleLoaderDisplay();
	}

	public void CreateNewReturnInvoiceStep2(String referenceInvoiceNumber) throws InterruptedException {
		selectFromList(referenceInvoiceNumber_Input, referenceInvoiceNumber);
		handleLoaderDisplay();
		driverWait.until(ExpectedConditions.elementToBeClickable(next_Btn)).click();
		handleLoaderDisplay();
	}

	public void CreateNewReturnInvoiceStep3(String invoiceNumber, String invoiceDate, String paymentDate,
			String invoiceNotes) throws InterruptedException {
		driver.findElement(invoiceNumber_Input).sendKeys(invoiceNumber);
		setDate(invoiceDate_Input, invoiceDate);
		Thread.sleep(1000);
		setDate(paymentDate_Input, paymentDate);
		driver.findElement(invoiceNotes_Input).sendKeys(invoiceNotes);
		String filePath = Paths.get("src/test/resources/attachment.pdf").toAbsolutePath().toString();
		driver.findElement(upload_Btn).sendKeys(filePath);
		driver.findElement(next_Btn).click();
		handleLoaderDisplay();
	}

	public void CreateNewReturnInvoiceStep4(String quantity) {
		driverWait.until(ExpectedConditions.elementToBeClickable(editProduct_Btn)).click();
		handleLoaderDisplay();
		driver.findElement(productQuantity_Input).sendKeys(Keys.BACK_SPACE);
		driver.findElement(productQuantity_Input).sendKeys(quantity);
		driver.findElement(addToList_Btn).click();
		handleLoaderDisplay();
		driver.findElement(create_Btn).click();
		handleLoaderDisplay();
	}

	public void CreateNewReturnInvoiceWithReferenceInvoiceStep1() throws InterruptedException {
		driver.findElement(hasNoReferenceInvoice_Btn).click();
		driverWait.until(ExpectedConditions.elementToBeClickable(next_Btn)).click();
		handleLoaderDisplay();
	}

	public void CreateNewReturnInvoiceWithReferenceInvoiceStep2(String invoiceNo, String clientName, String invoiceDate,
			String paymentDate, String invoiceNotes) throws InterruptedException {
		CreateNewInvoiceStep1(invoiceNo, clientName, invoiceDate, paymentDate, invoiceNotes);
	}

	public void CreateNewReturnInvoiceWithReferenceInvoiceStep3(String product, String category,
			String productDescription, String quantity, String discount, String VATCode) throws InterruptedException {
		CreateNewInvoiceStep2(product, category, productDescription, quantity, discount, VATCode);
	}

	public void CreateNewCashbackInvoiceStep1() {
		driver.findElement(cashBack_Btn).click();
		driverWait.until(ExpectedConditions.elementToBeClickable(next_Btn)).click();
		handleLoaderDisplay();
	}

	public void CreateNewCashbackStep2(String invoiceNo, String clientName, String invoiceDate, String paymentDate,
			String invoiceNotes) throws InterruptedException {
		CreateNewInvoiceStep1(invoiceNo, clientName, invoiceDate, paymentDate, invoiceNotes);
	}

	public void CreateNewCashbackInvoiceStep3(String price, String VATCode) throws InterruptedException {
		driver.findElement(productPrice_Input).sendKeys(price);
		
		driver.findElement(VATCode_Input).sendKeys(VATCode);
		handleLoaderDisplay();
		driverWait.until(ExpectedConditions.visibilityOfElementLocated(VATCode_Item)).click();
		handleLoaderDisplay();
		
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//button[@class='sc-eCstZk cjwIVv']")));
		System.out.println("button clicked");
		handleLoaderDisplay();
	}

}
