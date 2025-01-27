package Pages;

import java.nio.file.Paths;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CreateNewCompanyPage extends PageBase {
	public CreateNewCompanyPage(WebDriver driver) {
		super(driver);
	}

	private By pageTitle = By.xpath("//div[@class='title']/p");
	private By uploadLogo_Btn = By.xpath("//input[@type='file']");
	private By companyShortName_Input = By.name("slug");
	private By companyType_Input = By.xpath("//input[contains(@class,'mantine-Input-input')]");
	private By menu_item = By.xpath("(//div[contains(@class, 'mantine-Select-item')])[1]");
	private By vatRegistered_CheckBox = By.name("invoice_number_method");
	private By next_Btn = By.xpath("//button[@type='submit']");

	private By organizationType_Input = By.xpath("(//input[contains(@class,'mantine-Input-input')])[1]");
	private By unifiedNumber_Input = By.name("unified_number");
	private By commercialRegistrationNumber_Input = By.name("commercial_registration");
	private By taxNumber_Input = By.name("tax_number");
	private By uploadCommercialRegistrationCertificate_Btn = By.xpath("(//input[@type='file'])[1]");
	private By vatRegistrtaionNumber_Input = By.name("vat_registeration_number");
	private By effectiveVATRegistrationDate_Input = By.xpath("//button[contains(@class,'mantine-DatePickerInput-input')]");
	private By reportType_Input = By.xpath("(//input[contains(@class,'mantine-Input-input')])[2]");
	private By uploadVATRegistrationCertificate_Btn = By.xpath("(//input[@type='file'])[2]");
	
	private By companyActivity_CheckBox = By.xpath("(//input[@name='activities'])[1]");
	private By financeManagerRole_CheckBox = By.xpath("(//input[@name='roles'])[2]");
	
	private By userEmail_Input = By.name("email");
	private By userName_Input = By.name("name");
	private By userRole_Input= By.xpath("//input[contains(@class,'mantine-MultiSelect')]");
	private By roleList_Item = By.xpath(" (//div[contains(@class, 'mantine-MultiSelect-item')])[1]");
	private By add_Btn = By.xpath("(//button[@type='submit'])[1]");
	private By create_Btn = By.xpath("(//button[@type='submit'])[2]");
	

	public String getPageTitle() {
		return driverWait.until(ExpectedConditions.visibilityOfElementLocated(pageTitle)).getText();
	}

	public void CreateNewCompanyStep1(String shortName, String compayType) throws InterruptedException {
		String imagePath = Paths.get("src/test/resources/companyLogo.png").toAbsolutePath().toString();
		driver.findElement(uploadLogo_Btn).sendKeys(imagePath);
		driver.findElement(companyShortName_Input).sendKeys(shortName);
		selectFromList(companyType_Input, compayType, menu_item);
		driver.findElement(vatRegistered_CheckBox).click();
		driverWait.until(ExpectedConditions.elementToBeClickable(next_Btn)).click();
		handleLoaderDisplay();
	}

	public void CreateNewCompanyStep2(String organizationType, String unifiedNo, String commercialRegistrationNo, String taxNo, 
			String vatRegistrationNo, String effectiveVATRegistrationDate, String reportType) throws InterruptedException {
		String filePath = Paths.get("src/test/resources/attachment.pdf").toAbsolutePath().toString();
		
		selectFromList(organizationType_Input, organizationType, menu_item);
		driver.findElement(unifiedNumber_Input).sendKeys(unifiedNo);
		driver.findElement(commercialRegistrationNumber_Input).sendKeys(commercialRegistrationNo);
		driver.findElement(taxNumber_Input).sendKeys(taxNo);
		driver.findElement(uploadCommercialRegistrationCertificate_Btn).sendKeys(filePath);
		driver.findElement(vatRegistrtaionNumber_Input).sendKeys(vatRegistrationNo);
		setDate(effectiveVATRegistrationDate_Input, effectiveVATRegistrationDate);
		selectFromList(reportType_Input, reportType, menu_item);
		driver.findElement(uploadVATRegistrationCertificate_Btn).sendKeys(filePath);
		driverWait.until(ExpectedConditions.elementToBeClickable(next_Btn)).click();
		handleLoaderDisplay();		
	}
	
	public void CreateNewCompanyStep3() {
		driverWait.until(ExpectedConditions.elementToBeClickable(companyActivity_CheckBox)).click();
		handleLoaderDisplay();
		driverWait.until(ExpectedConditions.elementToBeClickable(next_Btn)).click();
		handleLoaderDisplay();
	}
	
	public void CreateNewCompanyStep4() {
		driverWait.until(ExpectedConditions.elementToBeClickable(financeManagerRole_CheckBox)).click();
		driverWait.until(ExpectedConditions.elementToBeClickable(next_Btn)).click();
		handleLoaderDisplay();
	}
	
	public void CreateNewCompanyStep5(String mail, String name, String role) throws InterruptedException {
		driver.findElement(userEmail_Input).sendKeys(mail);
		driver.findElement(userName_Input).sendKeys(name);
		driver.findElement(userRole_Input).sendKeys(role);
		Thread.sleep(2000);
		driverWait.until(ExpectedConditions.elementToBeClickable(roleList_Item)).click();
		driver.findElement(add_Btn).click();
		Thread.sleep(2000);
		driverWait.until(ExpectedConditions.elementToBeClickable(create_Btn)).click();
		handleLoaderDisplay();	
	}
	

}
