package Pages;

import java.nio.file.Paths;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CreateNewProductPage extends PageBase{
	public CreateNewProductPage(WebDriver driver) {
		super(driver);
	}
	
	private By uploadLogo_Btn = By.xpath("//input[@type='file']");
	private By ArName_Input = By.name("name_ar");
	private By EnName_Input = By.name("name_en");
	private By ArDescription_Input = By.name("description_ar");
	private By EnDescription_Input = By.name("description_en");
	private By productType_Input = By.xpath("//input[contains(@class,'mantine-Input-input')]");
	private By menu_item = By.xpath("(//div[contains(@class, 'mantine-Select-item')])[1]");
	private By productPrice_Input = By.name("price");
	private By productCode_Input = By.name("sku");
	private By create_Btn = By.xpath("//button[@type='submit']");


	
	public void createNewProduct(String ArName, String EnName, String ArDescription, String EnDescription, String productType, String price, String code) throws InterruptedException {
		String imagePath = Paths.get("src/test/resources/product.png").toAbsolutePath().toString();
		driver.findElement(uploadLogo_Btn).sendKeys(imagePath);
		driver.findElement(ArName_Input).sendKeys(ArName);
		driver.findElement(EnName_Input).sendKeys(EnName);
		driver.findElement(ArDescription_Input).sendKeys(ArDescription);
		driver.findElement(EnDescription_Input).sendKeys(EnDescription);
		selectFromList(productType_Input, productType, menu_item);
		driver.findElement(productPrice_Input).sendKeys(price);
		driver.findElement(productCode_Input).sendKeys(code);
		driverWait.until(ExpectedConditions.elementToBeClickable(create_Btn)).click();
		handleLoaderDisplay();
	}

}
