package Tests;

import Pages.LoginPage;
import Pages.DashboardPage;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import TestData.ExcelDataProvider;
import Pages.CompanyDashboardPage;
import Pages.SalesPage;
import Pages.PurchasesPage;
import Pages.CreateNewInvoicePage;
import Pages.CreateNewReturnInvoicePage;

public class CreateNewReturnInvoiceTest extends TestBase {
	LoginPage loginPage;
	DashboardPage dashboard;
	CompanyDashboardPage companyDashboard;
	SalesPage salesModule;
	PurchasesPage purchasesModule;
	CreateNewInvoicePage createNewInvoicePage;
	CreateNewReturnInvoicePage createNewReturnIncoicePage;

	@BeforeClass
	public void beforeClass() throws InterruptedException {
		loginPage = new LoginPage(driver);
		dashboard = new DashboardPage(driver);
		companyDashboard = new CompanyDashboardPage(driver);
		salesModule = new SalesPage(driver);
		purchasesModule = new PurchasesPage(driver);
		createNewInvoicePage = new CreateNewInvoicePage(driver);
		createNewReturnIncoicePage = new CreateNewReturnInvoicePage(driver);
		loginPage.login(username, password);
		dashboard.browseCompany("Automation");
	}


	@DataProvider
	public static Object[][] getSalesReturnInvoiceData() throws FileNotFoundException, IOException {
		ExcelDataProvider.openExcel(".\\src\\test\\resources\\data.xlsx", "salesReturn"); 
		Object[][] data = ExcelDataProvider.getSheetData();
		return data;
	}
	
	@DataProvider
	public static Object[][] getPurchasesReturnInvoiceData() throws FileNotFoundException, IOException {
		ExcelDataProvider.openExcel(".\\src\\test\\resources\\data.xlsx", "purchaseReturn"); 
		Object[][] data = ExcelDataProvider.getSheetData();
		return data;
	}
	
	@DataProvider
	public static Object[][] getSalesReturnWithoutReferenceInvoiceData() throws FileNotFoundException, IOException {
		ExcelDataProvider.openExcel(".\\src\\test\\resources\\data.xlsx", "salesReturnWithoutRef"); 
		Object[][] data = ExcelDataProvider.getSheetData();
		return data;
	}
	
	@DataProvider
	public static Object[][] getPurchasesReturnWithoutReferenceInvoiceData() throws FileNotFoundException, IOException {
		ExcelDataProvider.openExcel(".\\src\\test\\resources\\data.xlsx", "purchaseReturnWithoutRef"); 
		Object[][] data = ExcelDataProvider.getSheetData();
		return data;
	}
	
	@DataProvider
	public static Object[][] getSalesCashbackInvoiceData() throws FileNotFoundException, IOException {
		ExcelDataProvider.openExcel(".\\src\\test\\resources\\data.xlsx", "salesCashback"); 
		Object[][] data = ExcelDataProvider.getSheetData();
		return data;
	}
	
	@DataProvider
	public static Object[][] getPurchasesCashbackInvoiceData() throws FileNotFoundException, IOException {
		ExcelDataProvider.openExcel(".\\src\\test\\resources\\data.xlsx", "purchaseCashback"); 
		Object[][] data = ExcelDataProvider.getSheetData();
		return data;
	}

	@Test(dataProvider = "getSalesReturnInvoiceData", priority = 1)
	public void createNewReturnSalesInvoice(String referenceInvoiceNumber, String returnInvoiceNumber,
			String invoiceDate, String paymentDate, String invoiceNotes, String returnQuantity)
			throws InterruptedException {
		
		companyDashboard.openModule("sales");
		salesModule.openCreateReturnInvoicePage();
		
		Assert.assertEquals(createNewReturnIncoicePage.getStepInfo(), "1 - نوع الفواتير");
		createNewReturnIncoicePage.CreateNewReturnInvoiceStep1();
		
		Assert.assertEquals(createNewReturnIncoicePage.getStepInfo(), "2 - فاتورة مرجعية");
		createNewReturnIncoicePage.CreateNewReturnInvoiceStep2(referenceInvoiceNumber);
		
		Assert.assertEquals(createNewReturnIncoicePage.getStepInfo(), "3 - البيانات الأساسية");
		createNewReturnIncoicePage.CreateNewReturnInvoiceStep3(returnInvoiceNumber, invoiceDate, paymentDate, invoiceNotes);
		
		Assert.assertEquals(createNewReturnIncoicePage.getStepInfo(), "4 - إضافة المرتجعات");
		createNewReturnIncoicePage.CreateNewReturnInvoiceStep4(returnQuantity);
		
		Assert.assertEquals(createNewReturnIncoicePage.getStepInfo(),"5 - مراجعة المرتجعات");
		createNewReturnIncoicePage.CreateNewReturnInvoiceStep5();

		Assert.assertTrue(salesModule.getSuccessMsg().contains("تم إنشاء الفاتورة"));
	}

	@Test(dataProvider = "getSalesReturnWithoutReferenceInvoiceData", priority = 2)
	public void createNewSalesReturnInvoiceWithoutReferenceInvoice(String invoiceNumber, String clientName, String invoiceDate,
			String paymentDate, String invoiceNotes, String product, String category, String productDescription, String quantity,
			String discount, String VATCode) throws InterruptedException {
		
		companyDashboard.openModule("sales");
		salesModule.openCreateReturnInvoicePage();
		
		Assert.assertEquals(createNewReturnIncoicePage.getStepInfo(), "1 - نوع الفواتير");
		createNewReturnIncoicePage.CreateNewReturnInvoiceWithReferenceInvoiceStep1();
		
		Assert.assertEquals(createNewReturnIncoicePage.getStepInfo(), "2 - البيانات الأساسية");
		createNewReturnIncoicePage.CreateNewReturnInvoiceWithReferenceInvoiceStep2(invoiceNumber, clientName, invoiceDate, paymentDate, invoiceNotes);
		
		Assert.assertEquals(createNewReturnIncoicePage.getStepInfo(), "3 - إضافة المرتجعات");
		createNewReturnIncoicePage.CreateNewReturnInvoiceWithReferenceInvoiceStep3(product, category, productDescription, quantity, discount, VATCode);
		
		Assert.assertTrue(salesModule.getSuccessMsg().contains("تم إنشاء الفاتورة"));
	}
	
	@Test (dataProvider = "getSalesCashbackInvoiceData", priority = 3)
	public void createNewCashbackSalesInvoice(String invoiceNumber, String clientName, String invoiceDate,
			String paymentDate, String invoiceNotes, String productPrice, String VATCode) throws InterruptedException {
		
		companyDashboard.openModule("sales");
		salesModule.openCreateReturnInvoicePage();
		
		Assert.assertEquals(createNewReturnIncoicePage.getStepInfo(), "1 - نوع الفواتير");
		createNewReturnIncoicePage.CreateNewCashbackInvoiceStep1();

		Assert.assertEquals(createNewReturnIncoicePage.getStepInfo(), "2 - البيانات الأساسية");
		createNewReturnIncoicePage.CreateNewCashbackStep2(invoiceNumber, clientName, invoiceDate, paymentDate, invoiceNotes);
		
		Assert.assertEquals(createNewReturnIncoicePage.getStepInfo(), "3 - إضافة المرتجعات");
		createNewReturnIncoicePage.CreateNewCashbackInvoiceStep3(productPrice, VATCode);
		
		Assert.assertTrue(salesModule.getSuccessMsg().contains("تم إنشاء الفاتورة"));
	}
	
	@Test(dataProvider = "getPurchasesReturnInvoiceData", priority = 4)
	public void createNewReturnPurchaseInvoice(String referenceInvoiceNumber, String returnInvoiceNumber,
			String invoiceDate, String paymentDate, String invoiceNotes, String returnQuantity)
			throws InterruptedException {
		
		companyDashboard.openModule("purchases");
		purchasesModule.openCreateReturnInvoicePage();
		
		Assert.assertEquals(createNewReturnIncoicePage.getStepInfo(), "1 - نوع الفواتير");
		createNewReturnIncoicePage.CreateNewReturnInvoiceStep1();
		
		Assert.assertEquals(createNewReturnIncoicePage.getStepInfo(), "2 - فاتورة مرجعية");
		createNewReturnIncoicePage.CreateNewReturnInvoiceStep2(referenceInvoiceNumber);
		
		Assert.assertEquals(createNewReturnIncoicePage.getStepInfo(), "3 - البيانات الأساسية");
		createNewReturnIncoicePage.CreateNewReturnInvoiceStep3(returnInvoiceNumber, invoiceDate, paymentDate, invoiceNotes);
		
		Assert.assertEquals(createNewReturnIncoicePage.getStepInfo(), "4 - إضافة المرتجعات");
		createNewReturnIncoicePage.CreateNewReturnInvoiceStep4(returnQuantity);
		
		Assert.assertEquals(createNewReturnIncoicePage.getStepInfo(),"5 - مراجعة المرتجعات");
		createNewReturnIncoicePage.CreateNewReturnInvoiceStep5();
		
		Assert.assertTrue(purchasesModule.getSuccessMsg().contains("تم إنشاء الفاتورة"));
	}
	
	@Test(dataProvider = "getPurchasesReturnWithoutReferenceInvoiceData", priority = 5)
	public void createNewPurchaseReturnInvoiceWithoutReferenceInvoice(String invoiceNumber, String clientName, String invoiceDate,
			String paymentDate, String invoiceNotes, String product, String category, String productDescription, String quantity,
			String discount, String VATCode) throws InterruptedException {
		
		companyDashboard.openModule("purchases");
		purchasesModule.openCreateReturnInvoicePage();
		
		Assert.assertEquals(createNewReturnIncoicePage.getStepInfo(), "1 - نوع الفواتير");
		createNewReturnIncoicePage.CreateNewReturnInvoiceWithReferenceInvoiceStep1();
		
		Assert.assertEquals(createNewReturnIncoicePage.getStepInfo(), "2 - البيانات الأساسية");
		createNewReturnIncoicePage.CreateNewReturnInvoiceWithReferenceInvoiceStep2(invoiceNumber, clientName, invoiceDate, paymentDate, invoiceNotes);
		
		Assert.assertEquals(createNewReturnIncoicePage.getStepInfo(), "3 - إضافة المرتجعات");
		createNewReturnIncoicePage.CreateNewReturnInvoiceWithReferenceInvoiceStep3(product, category, productDescription, quantity, discount, VATCode);
		
		Assert.assertTrue(purchasesModule.getSuccessMsg().contains("تم إنشاء الفاتورة"));
	}
	
	@Test (dataProvider = "getPurchasesCashbackInvoiceData", priority = 6)
	public void createNewPurchaseCashbackInvoice(String invoiceNumber, String clientName, String invoiceDate,
			String paymentDate, String invoiceNotes, String productPrice, String vatCode) throws InterruptedException {
		
		companyDashboard.openModule("purchases");
		purchasesModule.openCreateReturnInvoicePage();
		
		Assert.assertEquals(createNewReturnIncoicePage.getStepInfo(), "1 - نوع الفواتير");
		createNewReturnIncoicePage.CreateNewCashbackInvoiceStep1();

		Assert.assertEquals(createNewReturnIncoicePage.getStepInfo(), "2 - البيانات الأساسية");
		createNewReturnIncoicePage.CreateNewCashbackStep2(invoiceNumber, clientName, invoiceDate, paymentDate, invoiceNotes);
		
		Assert.assertEquals(createNewReturnIncoicePage.getStepInfo(), "3 - إضافة المرتجعات");
		createNewReturnIncoicePage.CreateNewCashbackInvoiceStep3( productPrice, vatCode);
		
		Assert.assertTrue(purchasesModule.getSuccessMsg().contains("تم إنشاء الفاتورة"));		
	}


}
