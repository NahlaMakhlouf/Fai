package Pages;

import java.nio.file.Paths;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CreateNewInvoicePage extends PageBase {
	public CreateNewInvoicePage(WebDriver driver) {
		super(driver);
	}

	private By step_Info = By.xpath("//div[@class='stepInfo']/p");
	private By invoiceNumber_Input = By.name("invoice_number");
	private By clientName_Input = By.xpath("//input[contains(@class,'mantine-Input-input')]");
	private By invoiceDate_Input = By.xpath("(//button[contains(@class,'mantine-DatePickerInput-input')])[1]");
	private By paymentDate_Input = By.xpath("(//button[contains(@class,'mantine-DatePickerInput-input')])[2]");
	private By menu_item = By.xpath("(//div[contains(@class, 'mantine-Select-item')])[1]");
	private By invoiceNotes_Input = By.name("description");
	private By upload_Btn=By.xpath("//input[@type='file']");
	private By next_Btn = By.xpath("//button[@type='submit']");
	
	private By product_Input = By.xpath("(//input[contains(@class,'mantine-Input-input')])[1]");
	private By Category_Input = By.xpath("(//input[contains(@class,'mantine-Input-input')])[2]");
	private By productDescription_Input = By.name("description_product");
	private By productQuantity_Input = By.name("quantity");
	private By discount_Input = By.name("the_discount");
	private By VATCode_Input = By.xpath("(//input[contains(@class,'mantine-Input-input')])[3]");
	private By VATCode_Item = By.xpath("(//div[contains(@class, 'mantine-Select-item')])[2]");
	private By addToList_Btn = By.xpath("//button[@type='submit']");
	private By create_Btn = By.cssSelector("button.sc-eCstZk.hYQKNc");
	
	public String getStepInfo() {
		return driverWait.until(ExpectedConditions.visibilityOfElementLocated(step_Info)).getText();
	}

	public void CreateNewInvoiceStep1(String invoiceNo, String clientName, String invoiceDate, String paymentDate, String invoiceNotes) throws InterruptedException {
		
		driver.findElement(invoiceNumber_Input).sendKeys(invoiceNo);
		selectFromList(clientName_Input, clientName, menu_item);
		setDate(invoiceDate_Input, invoiceDate);
		Thread.sleep(1000);
		setDate(paymentDate_Input, paymentDate);
		driver.findElement(invoiceNotes_Input).sendKeys(invoiceNotes);
		String filePath = Paths.get("src/test/resources/attachment.pdf").toAbsolutePath().toString();
		driver.findElement(upload_Btn).sendKeys(filePath);
		driver.findElement(next_Btn).click();
		handleLoaderDisplay();

	}
	
	public void CreateNewInvoiceStep2(String product, String category, String productDescription, String quantity, String discount, String VATCode) throws InterruptedException {
		
		selectFromList(product_Input, product, menu_item);
		selectFromList(Category_Input, category, menu_item);
		driver.findElement(productDescription_Input).sendKeys(productDescription);
		driver.findElement(productQuantity_Input).sendKeys(Keys.BACK_SPACE);
		driver.findElement(productQuantity_Input).sendKeys(quantity);
		driver.findElement(discount_Input).sendKeys(Keys.BACK_SPACE);
		driver.findElement(discount_Input).sendKeys(discount);
		driver.findElement(VATCode_Input).sendKeys(VATCode);
		driverWait.until(ExpectedConditions.visibilityOfElementLocated(VATCode_Item)).click();
		handleLoaderDisplay();
		driver.findElement(addToList_Btn).click();
		handleLoaderDisplay();
		driver.findElement(create_Btn).click();
		handleLoaderDisplay();
		
		
	}

}
