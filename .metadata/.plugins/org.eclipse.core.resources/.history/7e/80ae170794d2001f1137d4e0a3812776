package Tests;

import Pages.LoginPage;
import Pages.DashboardPage;
import Pages.CompanyDashboardPage;
import Pages.ProductsPage;
import Pages.CreateNewProductPage;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProductsTest extends TestBase{
	LoginPage loginPage;
	DashboardPage dashboard;
	CompanyDashboardPage companyDashboard;
	ProductsPage productsModule;
	CreateNewProductPage createNewProductPage;
	
	@BeforeClass
	public void beforeClass() {
		loginPage = new LoginPage(driver);
		dashboard = new DashboardPage(driver);
		companyDashboard = new CompanyDashboardPage(driver);
		productsModule = new ProductsPage(driver);
		createNewProductPage = new CreateNewProductPage(driver);
	}
	@BeforeMethod
	public void beforeMethod() throws InterruptedException {
		loginPage.login("nahlamakhlouf1@gmail.com", "123456");
		dashboard.browseCompany("Automation");
		companyDashboard.openModule("products");
	}
	
	@Test
	public void openCreateNewProductPage() {
		productsModule.openCreateNewProductPage();
		Assert.assertEquals(createNewProductPage.getPageTitle(), "إضافة منتج جديد");
	}
	
	


}
