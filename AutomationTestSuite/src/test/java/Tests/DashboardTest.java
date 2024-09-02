package Tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Test;

import Pages.LoginPage;
import Pages.DashboardPage;
import Pages.CompanyDashboardPage;

public class DashboardTest extends TestBase{
	
	LoginPage loginPage;
	DashboardPage dashboard;
	CompanyDashboardPage companyDashboard;
	

	@BeforeClass
	public void beforeClass() {
		loginPage = new LoginPage(driver);
		dashboard = new DashboardPage(driver);
		companyDashboard = new CompanyDashboardPage(driver);

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
}



