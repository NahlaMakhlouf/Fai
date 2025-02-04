
package Tests;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Pages.LoginPage;
import Pages.DashboardPage;
import TestData.ExcelDataProvider;


public class LoginTest extends TestBase {
	LoginPage loginPage;
	DashboardPage dashboard;
	

	@BeforeClass
	public void beforeClass() {
		loginPage = new LoginPage(driver);
		dashboard = new DashboardPage(driver);
		

	}
	@DataProvider
	public static Object[][] getLoginData() throws FileNotFoundException, IOException{
		ExcelDataProvider.openExcel(".\\src\\test\\resources\\data.xlsx", "login");
		Object[][] data = ExcelDataProvider.getSheetData();
		return data;
	}
	

	@Test (dataProvider ="getLoginData")
	public void loginAndAssert(String email, String password) throws InterruptedException {
		loginPage.login(email, password);
		Assert.assertEquals(driver.getCurrentUrl(), "https://fai-staging.ahadtest.com/");
		
		
	}

}
