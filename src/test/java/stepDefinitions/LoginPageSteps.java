package stepDefinitions;

import cucumber.TestContext;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import managers.PageObjectManager;
import pageObjects.LoginPage;

public class LoginPageSteps {

	TestContext testContext;
	LoginPage loginPage;
	private PageObjectManager pageObjectManager;

	public LoginPageSteps(TestContext context) {
		testContext = context;
		pageObjectManager = new PageObjectManager(testContext.getWebDriverManager().getDriver());
		loginPage = pageObjectManager.getLoginPage();
	}

	@Given("^Launch Application with URL$")
	public void launchBrowser() throws Exception {
		loginPage.launchApp();
	}

	@Given("^User is in LoginPage and performs login with below fields$")
	public void login(DataTable table) throws Exception {
		loginPage.appLogin(table);
	}

	@Given("^Logout of the Application$")
	public void logout() throws Exception {
		loginPage.appLogout();
	}

}