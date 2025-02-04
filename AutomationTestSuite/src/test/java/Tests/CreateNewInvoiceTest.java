package Tests;

import Pages.LoginPage;
import Pages.DashboardPage;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Pages.CompanyDashboardPage;
import Pages.PurchasesPage;
import Pages.SalesPage;
import TestData.ExcelDataProvider;
import Pages.CreateNewInvoicePage;

public class CreateNewInvoiceTest extends TestBase {
	LoginPage loginPage;
	DashboardPage dashboard;
	CompanyDashboardPage companyDashboard;
	SalesPage salesModule;
	PurchasesPage purchasesModule;
	CreateNewInvoicePage createNewInvoicePage;

	@BeforeClass
	public void beforeClass() throws InterruptedException {
		loginPage = new LoginPage(driver);
		dashboard = new DashboardPage(driver);
		companyDashboard = new CompanyDashboardPage(driver);
		salesModule = new SalesPage(driver);
		purchasesModule = new PurchasesPage(driver);
		createNewInvoicePage = new CreateNewInvoicePage(driver);
		loginPage.login(username, password);
		dashboard.browseCompany("Automation");
	}

	@DataProvider
	public static Object[][] getSalesInvoiceData() throws FileNotFoundException, IOException {
		ExcelDataProvider.openExcel(".\\src\\test\\resources\\data.xlsx", "sales");
		Object[][] data = ExcelDataProvider.getSheetData();
		return data;
	}

	@DataProvider
	public static Object[][] getPurchasesInvoiceData() throws FileNotFoundException, IOException {
		ExcelDataProvider.openExcel(".\\src\\test\\resources\\data.xlsx", "purchases");
		Object[][] data = ExcelDataProvider.getSheetData();
		return data;
	}

	@Test(dataProvider = "getSalesInvoiceData", priority = 1)
	public void createNewSalesInvoice(String invoiceNumber, String clientName, String invoiceDate, String payementDate,
			String invoiceNotes, String product, String category, String productDescription, String quantity,
			String discount, String VATCode) throws InterruptedException {

		companyDashboard.openModule("sales");
		salesModule.openCreateInvoicePage();
		Assert.assertEquals(createNewInvoicePage.getStepInfo(), "1 - البيانات الأساسية");
		createNewInvoicePage.CreateNewInvoiceStep1(invoiceNumber, clientName, invoiceDate, payementDate, invoiceNotes);

		Assert.assertEquals(createNewInvoicePage.getStepInfo(), "2 - إضافة المنتجات");
		createNewInvoicePage.CreateNewInvoiceStep2(product, category, productDescription, quantity, discount, VATCode);

		Assert.assertTrue(salesModule.getSuccessMsg().contains("تم إنشاء الفاتورة"));
	}

	@Test(dataProvider = "getPurchasesInvoiceData", priority = 2)
	public void createNewPurchaseInvoice(String invoiceNumber, String clientName, String invoiceDate,
			String payementDate, String invoiceNotes, String product, String category, String productDescription,
			String quantity, String discount, String VATCode) throws InterruptedException {

		companyDashboard.openModule("purchases");
		purchasesModule.openCreateInvoicePage();
		Assert.assertEquals(createNewInvoicePage.getStepInfo(), "1 - البيانات الأساسية");
		createNewInvoicePage.CreateNewInvoiceStep1(invoiceNumber, clientName, invoiceDate, payementDate, invoiceNotes);

		Assert.assertEquals(createNewInvoicePage.getStepInfo(), "2 - إضافة المنتجات");
		createNewInvoicePage.CreateNewInvoiceStep2(product, category, productDescription, quantity, discount, VATCode);

		Assert.assertTrue(purchasesModule.getSuccessMsg().contains("تم إنشاء الفاتورة"));
	}

}
