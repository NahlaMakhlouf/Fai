package Tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.LoginPage;
import Pages.DashboardPage;
import Pages.CompanyDashboardPage;
import Pages.SalesPage;
import Pages.ImportInvoicesPage;
import Pages.CreateNewInvoicePage;
import Pages.CreateNewReturnInvoicePage;

public class SalesTest extends TestBase {
	LoginPage loginPage;
	DashboardPage dashboard;
	CompanyDashboardPage companyDashboard;
	SalesPage salesModule;
	ImportInvoicesPage importInvoicesPage;
	CreateNewInvoicePage createNewInvoicePage;
	CreateNewReturnInvoicePage createNewReturnInvoicePage;

	@BeforeClass
	public void beforeClass() {
		loginPage = new LoginPage(driver);
		dashboard = new DashboardPage(driver);
		companyDashboard = new CompanyDashboardPage(driver);
		salesModule = new SalesPage(driver);
		importInvoicesPage = new ImportInvoicesPage(driver);
		createNewInvoicePage = new CreateNewInvoicePage(driver);
		createNewReturnInvoicePage = new CreateNewReturnInvoicePage(driver);

	}

	@BeforeMethod
	public void beforeMethod() throws InterruptedException {
		loginPage.login("nahlamakhlouf1@gmail.com", "123456");
		dashboard.browseCompany("Automation");
		companyDashboard.openModule("sales");
	}

	@Test(priority = 1)
	public void openCreateSalesInvoicePage() {
		salesModule.openCreateInvoicePage();
		Assert.assertEquals(createNewInvoicePage.getPageTitle(), "إنشاء فاتورة يدوياً");
	}

	@Test(priority = 2)
	public void openCreateReturnSalesInvoicePage() {
		salesModule.openCreateReturnInvoicePage();
		Assert.assertEquals(createNewReturnInvoicePage.getPageTitle(), "إنشاء فاتورة مرتجع");
	}

	@Test(priority = 3)
	public void openImportSalesPage() {
		salesModule.openImportInvoicesPage();
		Assert.assertEquals(importInvoicesPage.getPageTitle(), "رفع ملف الفواتير");
	}

}
