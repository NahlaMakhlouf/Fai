package Tests;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Pages.LoginPage;
import Pages.DashboardPage;
import Pages.CompanyDashboardPage;
import Pages.ReportsPage;
import TestData.ExcelDataProvider;
import Pages.CreateNewVATReportPage;

public class CreateNewVATReportTest extends TestBase{
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
	public void login() throws InterruptedException {
		loginPage.login(username, password);
		dashboard.browseCompany("Automation");
		companyDashboard.openModule("vat_reports");
		reportsModule.OpenCreateNewReportPage();
	}
	
	@DataProvider
	public static Object[][] getReportData() throws FileNotFoundException, IOException{
		ExcelDataProvider.openExcel(".\\src\\test\\resources\\data.xlsx", "VatReport");
		Object[][] data = ExcelDataProvider.getSheetData();
		return data;
	}
	@Test (dataProvider ="getReportData")
	public void createNewVatReport(String ArName, String EnName, String period, String year, String description) throws InterruptedException {
		
		createNewVATReportPage.createNewReportStep1(ArName,EnName, period,year, description );
		createNewVATReportPage.createNewReportStep2();
		
		Assert.assertEquals(reportsModule.getSuccessMsg(), "تم إضافة التقارير بنجاح");
		
	}

	

}
