package Tests;

import TestData.ExcelDataProvider;
import Pages.LoginPage;
import Pages.DashboardPage;
import Pages.CompanyDashboardPage;
import Pages.ClientsPage;
import Pages.CreateNewClientPage;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.Assert;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class CreateNewClientTest extends TestBase {
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
	public void login() throws InterruptedException {
		loginPage.login(username, password);
		dashboard.browseCompany("Automation");
		companyDashboard.openModule("clients");
		clientsModule.openCreateNewClientPage();
	}

	@DataProvider
	public static Object[][] getClientData() throws FileNotFoundException, IOException {
		ExcelDataProvider.openExcel(".\\src\\test\\resources\\data.xlsx", "clients");
		Object[][] data = ExcelDataProvider.getSheetData();
		return data;
	}

	@Test(dataProvider = "getClientData")
	public void createNewClient(String shortName, String ArName, String EnName, String accountType,
			String relationshipType, String corporateType, String commercialRegistartionNo, String unifiedNo,
			String website, String vatRegistrationNo, String country, String city, String district, String zip,
			String referenceNo, String ArAddress, String EnAddress, String phone, String mail, String repArName,
			String repEnName, String ArTitle, String EnTitle, String email, String status, String phoneNo)
			throws InterruptedException {

		Assert.assertEquals(createNewClientPage.getStepInfo(), "1- البيانات الأساسية للعميل / المورد");
		createNewClientPage.createNewClientStep1(shortName, ArName, EnName, accountType, relationshipType,
				corporateType, commercialRegistartionNo, unifiedNo, website, vatRegistrationNo, country, city, district,
				zip, referenceNo, ArAddress, EnAddress, phone, mail);

		Assert.assertEquals(createNewClientPage.getStepInfo(), "2- إضافة الممثلين");
		createNewClientPage.createNewClientStep2(repArName, repEnName, ArTitle, EnTitle, email, status, phoneNo);
		
		assertTrue(driver.getCurrentUrl().contains("clients-and-vendors"));

	}

}
