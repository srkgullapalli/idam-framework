package stepDefinitions;

import cucumber.TestContext;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import managers.PageObjectManager;
import managers.WebDriverManager;
import pageObjects.DashboardPage;

public class DashboardPageSteps {

	TestContext testContext;
	DashboardPage dashboardPage;

	private PageObjectManager pageObjectManager;

	public DashboardPageSteps(TestContext context) {
		testContext = context;
		pageObjectManager = new PageObjectManager(testContext.getWebDriverManager().getDriver());
		dashboardPage = pageObjectManager.getDashboardPage();
	}

	@Given("^Select the service from the below menu options$")
	public void createUser(DataTable table) {
		dashboardPage.selectService(table);
	}

	@Then("Select sub service for main service selection")
	public void selectSubServiceForMainServiceSelection(DataTable table) {
		dashboardPage.selectSubService(table);
	}
}