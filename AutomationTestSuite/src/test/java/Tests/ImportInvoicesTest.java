package Tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Pages.LoginPage;
import Pages.PurchasesPage;
import Pages.DashboardPage;
import Pages.CompanyDashboardPage;
import Pages.SalesPage;
import Pages.ImportInvoicesPage;

public class ImportInvoicesTest extends TestBase{
	LoginPage loginPage;
	DashboardPage dashboard;
	CompanyDashboardPage companyDashboard;
	SalesPage salesModule ;
	PurchasesPage purchasesModule;
	ImportInvoicesPage importInvoicesPage;
	

	@BeforeClass
	public void beforeClass() throws InterruptedException {
		loginPage = new LoginPage(driver);
		dashboard = new DashboardPage(driver);
		companyDashboard = new CompanyDashboardPage(driver);
		salesModule = new SalesPage(driver);
		purchasesModule = new PurchasesPage(driver);
		importInvoicesPage = new ImportInvoicesPage(driver);
		loginPage.login(username, password);
		dashboard.browseCompany("Automation");

	}

	@Test (priority = 1)
	public void ImportSalesInvoices() throws InterruptedException {
		companyDashboard.openModule("sales");
		salesModule.openImportInvoicesPage();
		importInvoicesPage.importSalesInvoices();
		Assert.assertEquals(salesModule.getSuccessMsg(), "تم رفع الملف بنجاح. سيتم عرض البيانات بعد إنتهاء عملية المعالجة!");
	}
	
	@Test (priority = 2)
	public void ImportPurchaseInvoices() throws InterruptedException {
		companyDashboard.openModule("purchases");
		purchasesModule.openImportInvoicesPage();
		importInvoicesPage.importPurchasesInvoices();
		Assert.assertEquals(purchasesModule.getSuccessMsg(), "تم رفع الملف بنجاح. سيتم عرض البيانات بعد إنتهاء عملية المعالجة!");
	}
	
		

}
