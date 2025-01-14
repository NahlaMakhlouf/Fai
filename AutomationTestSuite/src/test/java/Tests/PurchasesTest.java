package Tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.CompanyDashboardPage;
import Pages.CreateNewInvoicePage;
import Pages.CreateNewReturnInvoicePage;
import Pages.DashboardPage;
import Pages.ImportInvoicesPage;
import Pages.LoginPage;
import Pages.PurchasesPage;

public class PurchasesTest extends TestBase{
	LoginPage loginPage;
	DashboardPage dashboard;
	CompanyDashboardPage companyDashboard;
	PurchasesPage purchaseModule;
	ImportInvoicesPage importInvoicesPage;
	CreateNewInvoicePage createNewInvoicePage;
	CreateNewReturnInvoicePage createNewRerutnInvoicePage;

	@BeforeClass
	public void beforeClass() {
		loginPage = new LoginPage(driver);
		dashboard = new DashboardPage(driver);
		companyDashboard = new CompanyDashboardPage(driver);
		purchaseModule = new PurchasesPage(driver);
		importInvoicesPage = new ImportInvoicesPage(driver);
		createNewInvoicePage = new CreateNewInvoicePage(driver);
		createNewRerutnInvoicePage = new CreateNewReturnInvoicePage(driver);

	}

	@BeforeMethod
	public void login() throws InterruptedException {
		loginPage.login(username, password);
		dashboard.browseCompany("Automation");
		companyDashboard.openModule("purchases");
	}
	@Test
	public void openImportSalesPage() {
		purchaseModule.openImportInvoicesPage();
		Assert.assertEquals(importInvoicesPage.getPageTitle(),"رفع ملف الفواتير");
		
	}
	@Test
	public void openCreateSalesInvoicePage() {
		purchaseModule.openCreateInvoicePage();
		Assert.assertEquals(createNewInvoicePage.getPageTitle() , "إنشاء فاتورة يدوياً");
	}
	
	@Test
	public void openCreateReturnSalesInvoicePage() {
		purchaseModule.openCreateReturnInvoicePage();
		Assert.assertEquals(createNewInvoicePage.getPageTitle() , "إنشاء فاتورة مرتجع");
	}


}
