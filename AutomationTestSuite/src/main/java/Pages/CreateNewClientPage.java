package Pages;

import java.nio.file.Paths;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CreateNewClientPage extends PageBase {
	public CreateNewClientPage(WebDriver driver) {
		super(driver);
	}

	private By step_Info = By.xpath("//div[@class='stepInfo']/p");
	private By shortName_Input = By.name("short_name");
	private By ArName_Input = By.name("name.ar");
	private By EnName_Input = By.name("name.en");
	private By accountType_Input = By.xpath("(//input[contains(@class,'mantine-Input-input')])[1]");
	private By relationshipType_Input = By.xpath("(//input[contains(@class,'mantine-Input-input')])[2]");
	private By corporateType_Input = By.xpath("(//input[contains(@class,'mantine-Input-input')])[3]");
	private By menu_item = By.xpath("(//div[contains(@class, 'mantine-Select-item')])[1]");
	private By uploadLogo_Btn = By.xpath("//input[@type='file']");
	private By commercialRegistrationNumber_Input = By.name("registration_number");
	private By unifiedNumber_Input = By.name("id_number");
	private By website_Inout = By.name("website");
	private By vatRegistered_CheckBox = By.name("tax_registered");
	private By vatRegistrationNumber_Input = By.name("tax_number");
	private By uploadAttachment_Btn = By.xpath("(//input[@type='file'])[2]");
	private By country_Input = By.xpath("(//input[contains(@class,'mantine-Input-input')])[4]");
	private By city_Input = By.xpath("(//input[contains(@class,'mantine-Input-input')])[5]");
	private By district_Input = By.name("district");
	private By zipCode_Input = By.name("zip");
	private By referenceNumber_Input = By.name("reference_number");
	private By ArAddress_Input = By.name("address.ar");
	private By EnAddress_Input = By.name("address.en");
	private By phoneNumber_Input = By.name("phone");
	private By email_Input = By.name("email");
	private By next_Btn = By.xpath("//button[@type='submit']");
	
	private By ArTitle_Input = By.name("title.ar");
	private By EnTitle_Input = By.name("title.en");
	private By status_Input = By.xpath("//input[contains(@class,'mantine-Input-input')]");
	private By addToList_Btn = By.xpath("//button[@type='submit']");
	private By create_Btn = By.xpath("(//button[@type='submit'])[2]");
	
	public String getStepInfo() {
		return driverWait.until(ExpectedConditions.visibilityOfElementLocated(step_Info)).getText();
	}

	public void createNewClientStep1(String shortName, String ArName, String EnName, String accountType,
			String relationshipType, String corporateType, String commercialRegistartionNo, String unifiedNo,
			String website, String vatRegistrationNo, String country, String city, String district, String zip,
			String referenceNo, String ArAddress, String EnAddress, String phone, String mail)
			throws InterruptedException {
		driver.findElement(shortName_Input).sendKeys(shortName);
		driver.findElement(ArName_Input).sendKeys(ArName);
		driver.findElement(EnName_Input).sendKeys(EnName);
		selectFromList(accountType_Input, accountType, menu_item);
		selectFromList(relationshipType_Input, relationshipType, menu_item);
		selectFromList(corporateType_Input, corporateType, menu_item);
		String imagePath = Paths.get("src/test/resources/logo.jpg").toAbsolutePath().toString();
		driver.findElement(uploadLogo_Btn).sendKeys(imagePath);
		driver.findElement(commercialRegistrationNumber_Input).sendKeys(commercialRegistartionNo);
		driver.findElement(unifiedNumber_Input).sendKeys(unifiedNo);
		driver.findElement(website_Inout).sendKeys(website);
		driver.findElement(vatRegistered_CheckBox).click();
		driver.findElement(vatRegistrationNumber_Input).sendKeys(vatRegistrationNo);
		String filePath = Paths.get("src/test/resources/attachment.pdf").toAbsolutePath().toString();
		driver.findElement(uploadAttachment_Btn).sendKeys(filePath);
		selectFromList(country_Input, country, menu_item);
		selectFromList(city_Input, city, menu_item);
		driver.findElement(district_Input).sendKeys(district);
		driver.findElement(zipCode_Input).sendKeys(zip);
		driver.findElement(referenceNumber_Input).sendKeys(referenceNo);
		driver.findElement(ArAddress_Input).sendKeys(ArAddress);
		driver.findElement(EnAddress_Input).sendKeys(EnAddress);
		driver.findElement(phoneNumber_Input).sendKeys(phone);
		driver.findElement(email_Input).sendKeys(mail);
		driver.findElement(next_Btn).click();
		handleLoaderDisplay();
	}
	
	public void createNewClientStep2(String ArName, String EnName, String ArTitle, String EnTitle, String email, String status, String phone) throws InterruptedException {
		driver.findElement(ArName_Input).sendKeys(ArName);
		driver.findElement(EnName_Input).sendKeys(EnName);
		driver.findElement(ArTitle_Input).sendKeys(ArTitle);
		driver.findElement(EnTitle_Input).sendKeys(EnTitle);
		driver.findElement(email_Input).sendKeys(email);
		selectFromList(status_Input, status, menu_item);
		driver.findElement(phoneNumber_Input).sendKeys(phone);
		driver.findElement(addToList_Btn).click();
		driverWait.until(ExpectedConditions.elementToBeClickable(create_Btn)).click();
		handleLoaderDisplay();
		
		
		
	}
	

}
