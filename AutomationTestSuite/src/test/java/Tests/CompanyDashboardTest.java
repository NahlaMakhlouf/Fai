package Tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.LoginPage;
import Pages.DashboardPage;
import Pages.CompanyDashboardPage;
import Pages.SalesPage;

public class CompanyDashboardTest extends TestBase {

	LoginPage loginPage;
	DashboardPage dashboard;
	CompanyDashboardPage companyDashboard;
	SalesPage salesModule ;

	@BeforeClass
	public void beforeClass() {
		loginPage = new LoginPage(driver);
		dashboard = new DashboardPage(driver);
		companyDashboard = new CompanyDashboardPage(driver);
		salesModule = new SalesPage(driver);

	}

	@BeforeMethod
	public void login() throws InterruptedException {
		loginPage.login(username, password);
		dashboard.browseCompany("Automation");
	}
	@Test
	public void openModuleAndAssertPageTitle() {
		companyDashboard.openModule("sales");
		Assert.assertEquals(salesModule.getPageTitle(), "فواتير المبيعات");
		
	}
	@AfterMethod
	public void gotoCompanyDashboard() {
		companyDashboard.openModule("company-dashboard");
	}

}
