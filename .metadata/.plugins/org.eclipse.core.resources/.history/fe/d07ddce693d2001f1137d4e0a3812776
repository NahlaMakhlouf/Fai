package Tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Test;

import Pages.LoginPage;
import Pages.DashboardPage;
import Pages.CompanyDashboardPage;
import Pages.CreateNewCompanyPage;
public class DashboardTest extends TestBase{
	
	LoginPage loginPage;
	DashboardPage dashboard;
	CompanyDashboardPage companyDashboard;
	CreateNewCompanyPage createNewCompanyPage;
	

	@BeforeClass
	public void beforeClass() {
		loginPage = new LoginPage(driver);
		dashboard = new DashboardPage(driver);
		companyDashboard = new CompanyDashboardPage(driver);
		createNewCompanyPage = new CreateNewCompanyPage(driver);

	}
	@BeforeMethod
	public void login() throws InterruptedException{
		loginPage.login("nahlamakhlouf1@gmail.com", "123456");
}
	@Test 
	public void goToCompanyDashboardAndAssertCompanyNameIsDisplayed() {
		dashboard.browseCompany("Automation");
		Assert.assertTrue(companyDashboard.isCompanyNameDisplayed("Automation"));
	}
	
	@Test 
	public void openCreateNewCompanyPage() {
		dashboard.openCreateNewCompanyPage();
		Assert.assertEquals(createNewCompanyPage.getPageTitle(), "انشاء كيان جديد");
	}
}



