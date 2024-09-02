package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ReportsPage extends PageBase{
	public ReportsPage(WebDriver driver) {
		super(driver);
	}
	
	private By createNewReport_Btn= By.xpath("(//button[@type='button'])[3]");
	
	public void OpenCreateNewReportPage() {
		driver.findElement(createNewReport_Btn).click();
		handleLoaderDisplay();
	}

}
