package Tests;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Pages.LoginPage;
import TestData.ExcelDataProvider;
import Pages.DashboardPage;
import Pages.CreateNewCompanyPage;

public class CreateNewCompanyTest extends TestBase {
	LoginPage loginPage;
	DashboardPage dashboard;
	CreateNewCompanyPage createNewCompanyPage;

	@BeforeClass
	public void beforeClass() {
		loginPage = new LoginPage(driver);
		dashboard = new DashboardPage(driver);
		createNewCompanyPage = new CreateNewCompanyPage(driver);

	}

	@BeforeMethod
	public void login() throws InterruptedException {
		loginPage.login(username, password);
		dashboard.openCreateNewCompanyPage();
	}

	@DataProvider
	public static Object[][] getCompanyData() throws FileNotFoundException, IOException {
		ExcelDataProvider.openExcel(".\\src\\test\\resources\\data.xlsx", "company");
		Object[][] data = ExcelDataProvider.getSheetData();
		return data;
	}

	@Test(dataProvider = "getCompanyData")
	public void createNewCompany(String shortName, String companyType, String organizationType, String unifiedNo,
			String commercialRegistrationNo, String taxNo, String vatRegistrationNo,
			String effectiveVATRegistrationDate, String reportType, String userEmail, String userName, String role) throws InterruptedException {
		createNewCompanyPage.CreateNewCompanyStep1(shortName, companyType);

		createNewCompanyPage.CreateNewCompanyStep2(organizationType, unifiedNo, commercialRegistrationNo, taxNo,
				vatRegistrationNo, effectiveVATRegistrationDate, reportType);
		
		createNewCompanyPage.CreateNewCompanyStep3();
		
		createNewCompanyPage.CreateNewCompanyStep4();
		
		createNewCompanyPage.CreateNewCompanyStep5(userEmail, userName, role);
	}

}
