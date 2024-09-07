package Tests;

import Pages.LoginPage;
import Pages.DashboardPage;
import Pages.CompanyDashboardPage;
import Pages.ClientsPage;
import Pages.CreateNewClientPage;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class ClientsTest extends TestBase{
	LoginPage loginPage;
	DashboardPage dashboard;
	CompanyDashboardPage companyDashboard;
	ClientsPage clientsModule;
	CreateNewClientPage createNewClientPage;
	
	@BeforeClass
	public void beforeClass() {
		loginPage = new LoginPage(driver);
		dashboard = new DashboardPage(driver);
		companyDashboard = new CompanyDashboardPage(driver);
		clientsModule = new ClientsPage(driver);
		createNewClientPage = new CreateNewClientPage(driver);
	}
	@BeforeMethod
	public void beforeMethod() throws InterruptedException {
		loginPage.login("nahlamakhlouf1@gmail.com", "123456");
		dashboard.browseCompany("Automation");
		companyDashboard.openModule("clients");
	}
	
	@Test
	public void openCreateNewClientPage() {
		clientsModule.openCreateNewClientPage();
		Assert.assertEquals(createNewClientPage.getPageTitle(), "إضافة عميل / مورد");
		
	}
	

}
