package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductsPage extends PageBase{
	public ProductsPage(WebDriver driver) {
		super(driver);
	}
	
	private By addProductList = By.cssSelector("button.sc-eCstZk.dDpUpp");
	private By addProductBtn = By.xpath("//button[contains(@class, 'mantine-Menu-item')]");
	
	public void openCreateNewProductPage() {
		driverWait.until(ExpectedConditions.elementToBeClickable(addProductList)).click();
		driver.findElement(addProductBtn).click();
		handleLoaderDisplay();
	}

}
