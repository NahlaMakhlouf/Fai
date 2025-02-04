package Pages;

import java.nio.file.Paths;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ImportInvoicesPage extends PageBase{
	public ImportInvoicesPage(WebDriver driver) {
		super(driver);
	}
	
	private By upload_Btn= By.xpath("//input[@type='file']");
	private By confirm_Btn = By.xpath("//button[@type='submit']");
	
	public void importSalesInvoices() {
		String filePath = Paths.get("src/test/resources/fai_import-sales-template.xlsx").toAbsolutePath().toString();
		driver.findElement(upload_Btn).sendKeys(filePath);	
		driver.findElement(confirm_Btn).click();
		handleLoaderDisplay();
		}
	
	public void importPurchasesInvoices() {
		String filePath = Paths.get("src/test/resources/fai_import-purchases-template.xlsx").toAbsolutePath().toString();
		driver.findElement(upload_Btn).sendKeys(filePath);	
		driver.findElement(confirm_Btn).click();
		handleLoaderDisplay();
		}

}
