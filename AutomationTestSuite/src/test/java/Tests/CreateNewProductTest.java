package Tests;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Pages.LoginPage;
import Pages.DashboardPage;
import Pages.CompanyDashboardPage;
import Pages.ProductsPage;
import TestData.ExcelDataProvider;
import Pages.CreateNewProductPage;

public class CreateNewProductTest extends TestBase{
	LoginPage loginPage;
	DashboardPage dashboard;
	CompanyDashboardPage companyDashboard;
	ProductsPage productsModule;
	CreateNewProductPage createNewProductPage;
	
	@BeforeClass
	public void beforeClass() throws InterruptedException {
		loginPage = new LoginPage(driver);
		dashboard = new DashboardPage(driver);
		companyDashboard = new CompanyDashboardPage(driver);
		productsModule = new ProductsPage(driver);
		createNewProductPage = new CreateNewProductPage(driver);
		loginPage.login(username, password);
		dashboard.browseCompany("Automation");
		companyDashboard.openModule("products");
	}
	@BeforeMethod
	public void beforeMethod() throws InterruptedException {
		
		
		productsModule.openCreateNewProductPage();
	}

	
	@DataProvider
	public static Object[][] getProductData() throws FileNotFoundException, IOException {
		ExcelDataProvider.openExcel(".\\src\\test\\resources\\data.xlsx", "products");
		Object[][] data = ExcelDataProvider.getSheetData();
		return data;
	}

	@Test(dataProvider = "getProductData")
	public void createNewProduct(String ArName, String EnName, String ArDescription, String EnDescription,
			String productType, String price, String code) throws InterruptedException {
		createNewProductPage.createNewProduct(ArName, EnName, ArDescription, EnDescription, productType, price, code);
		
		Assert.assertTrue(productsModule.getSuccessMsg().contains("تم إنشاء المنتج"));
	
	}

}
