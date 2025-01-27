package Tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	public WebDriver driver;
	protected String url;
	protected String username;
	protected String password;

	@BeforeClass()
	public void setUp() throws InterruptedException, IOException {

		// Load properties file
		Properties prop = new Properties();
		FileInputStream inputStream = new FileInputStream("src/test/resources/config.properties");
		prop.load(inputStream);

		// Get values from the properties file
		url = prop.getProperty("url");
		username = prop.getProperty("username");
		password = prop.getProperty("password");

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);

	}

//	@AfterSuite
//	public void tearDown() {
//		if (driver != null) {
//			driver.quit();
//		}
//	}

}