package Tests;

import Pages.LoginPage;
import Pages.DashboardPage;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.CompanyDashboardPage;
import Pages.SalesPage;
import Pages.PurchasesPage;
import Pages.CreateNewReturnInvoicePage;


public class CreateNewReturnInvoiceTest extends TestBase{
	LoginPage loginPage;
	DashboardPage dashboard;
	CompanyDashboardPage companyDashboard;
	SalesPage salesModule;
	PurchasesPage purchasesModule;
	CreateNewReturnInvoicePage createNewReturnIncoicePage;
	
	@BeforeClass
	public void beforeClass() {
		loginPage = new LoginPage(driver);
		dashboard = new DashboardPage(driver);
		companyDashboard = new CompanyDashboardPage(driver);
		salesModule = new SalesPage(driver);
		purchasesModule = new PurchasesPage(driver);
		createNewReturnIncoicePage = new CreateNewReturnInvoicePage(driver);
	}
	
	@BeforeMethod
	public void login() throws InterruptedException {
		loginPage.login("nahlamakhlouf1@gmail.com", "123456");
		dashboard.browseCompany("Automation");
	}
	
	@Test
	public void createNewReturnSalesInvoice() throws InterruptedException {
		companyDashboard.openModule("sales");
		salesModule.openCreateReturnInvoicePage();
		createNewReturnIncoicePage.CreateNewReturnInvoice("sales001", "sales001_return", "Nov 05 2023", "Nov 05 2023", "test return invoice notes", "1");
		Assert.assertTrue(purchasesModule.getSuccessMsg().contains("تم إنشاء الفاتورة"));
	}
	@Test
	public void createNewReturnInvoiceWithReferenceInvoice() {
		companyDashboard.openModule("sales");
		salesModule.openCreateReturnInvoicePage();
		createNewReturnIncoicePage.CreateNewReturnInvoiceWithReferenceInvoice();
	}

}
