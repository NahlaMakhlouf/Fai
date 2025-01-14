package Tests;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;


import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	public WebDriver driver;

	@BeforeClass
	public void setUp() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://fai-staging.ahadtest.com/login");
		

	}

//	@AfterSuite
//	public void tearDown() {
//		if (driver != null) {
//			driver.quit();
//		}
//	}

}