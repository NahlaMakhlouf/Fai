package Pages;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageBase {
	public WebDriver driver;
	public Actions action;
	public WebDriverWait driverWait;
	public JavascriptExecutor js;

	public PageBase(WebDriver driver) {
		this.driver = driver;
		this.js = (JavascriptExecutor) driver;

		action = new Actions(driver);
		driverWait = new WebDriverWait(driver, Duration.ofSeconds(480));

	}

	private By calendarHeader = By.xpath("//button[contains(@class, 'mantine-CalendarHeader-calendarHeaderLevel')]");
	private By loader = By.id("partiallyLoader");
	private By pageTitle = By.xpath("(//div/p)[5]");
	private By success_Msg =  By.cssSelector("div[class*='Toastify__toast--success'] > div >:last-child");
	

	public void setDate(By dateFeild, String dateValue) {

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd yyyy");
		LocalDate date = LocalDate.parse(dateValue, formatter);

		String year = String.valueOf(date.getYear());
		String month = date.getMonth().getDisplayName(TextStyle.SHORT, Locale.ENGLISH);
		String day = String.valueOf(date.getDayOfMonth());

		driver.findElement(dateFeild).click();

		driverWait.until(ExpectedConditions.elementToBeClickable(calendarHeader)).click();
		driverWait.until(ExpectedConditions.elementToBeClickable(calendarHeader)).click();
		driver.findElement(By
				.xpath("//button[contains(@class, 'mantine-DatePickerInput-pickerControl')and text()='" + year + "']"))
				.click();
		driver.findElement(By.xpath(
				"//button[contains(@class, 'mantine-DatePickerInput-pickerControl') and text()='" + month + "']"))
				.click();
		driver.findElement(
				By.xpath("//button[contains(@class, 'mantine-DatePickerInput-day') and text()='" + day + "']")).click();
	}

	private boolean isLoaderDisplayed() {
		try {
			return driver.findElement(loader).isDisplayed();
		} 
		catch (NoSuchElementException e) {
			return false;
		}
	}
	public void handleLoaderDisplay() {
		try {
			if (isLoaderDisplayed()) {
				driverWait.until(ExpectedConditions.invisibilityOfElementLocated(loader));
			}
		} catch (TimeoutException e) {
			System.out.println("Loader did not disappear in time or wasn't present: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error while handling loader: " + e.getMessage());
		}
	}

	public String getPageTitle() {
		return driverWait.until(ExpectedConditions.visibilityOfElementLocated(pageTitle)).getText();
	}

	public String getSuccessMsg() throws InterruptedException {
		handleLoaderDisplay();
		String successMsg = driverWait.until(ExpectedConditions.visibilityOfElementLocated(success_Msg)).getText();
		return successMsg;
		}

	public void selectFromList(By input, String value, By menu_Item) throws InterruptedException {

		driverWait.until(ExpectedConditions.visibilityOfElementLocated(input)).sendKeys(value);
		handleLoaderDisplay();
		driverWait.until(ExpectedConditions.visibilityOfElementLocated(menu_Item)).click();
		handleLoaderDisplay();
	}

}