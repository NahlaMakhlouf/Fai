package Tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.LoginPage;
import Pages.DashboardPage;
import Pages.CompanyDashboardPage;
import Pages.ReportsPage;
import Pages.CreateNewVATReportPage;

public class ReportsTest extends TestBase {
	LoginPage loginPage;
	DashboardPage dashboard;
	CompanyDashboardPage companyDashboard;
	ReportsPage reportsModule;
	CreateNewVATReportPage createNewVATReportPage;
	

	@BeforeClass
	public void beforeClass() {
		loginPage = new LoginPage(driver);
		dashboard = new DashboardPage(driver);
		companyDashboard = new CompanyDashboardPage(driver);
		reportsModule = new ReportsPage(driver);	
		createNewVATReportPage = new CreateNewVATReportPage(driver);
	}

	@BeforeMethod
	public void beforeMethod() throws InterruptedException {
		loginPage.login(username, password);
		dashboard.browseCompany("Automation");
		companyDashboard.openModule("vat_reports");
	}
	
	@Test
	public void openCreateNewReportPage() {
		reportsModule.OpenCreateNewReportPage();
		Assert.assertEquals(createNewVATReportPage.getPageTitle(), "إنشاء اقرار جديد");
	
	}

}
