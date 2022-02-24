package stepDefinitions;

import java.awt.AWTException;
import java.io.IOException;
import java.util.Map;

import cucumber.TestContext;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import enums.Context;
import managers.PageObjectManager;
import managers.WebDriverManager;
import pageObjects.UserPage;

public class UserSteps  {
	
	TestContext testContext;
	UserPage userPage;
	private PageObjectManager pageObjectManager;
	
	public UserSteps(TestContext context) {
		testContext = context;
		pageObjectManager = new PageObjectManager(testContext.getWebDriverManager().getDriver());
		userPage = pageObjectManager.getUserPage();
	}
	
	@Given("^Create new user with the below fields$")
	public void selectIDAMService(DataTable table) throws AWTException {
		userPage.createUsers(table,testContext);
	}

	
	@Then("Inject data into testContext")
	public void injectDataIntoTestContext(DataTable table) {
		final Map<String, String> hmap = table.asMap(String.class, String.class);
		if(hmap.get("phoneNo")!=null) {
			testContext.getScenarioContext().setContext(Context.USER_PHN, hmap.get("phoneNo"));		
		}
		else if(hmap.get("userEmail")!=null){
			testContext.getScenarioContext().setContext(Context.USER_EMAIL, hmap.get("userEmail"));
		}
	}
	

	@Then("navigate to view details screen for the user")
	public void navigateToViewDetaisScreenForTheUser() {
		userPage.navigateViewDetails(testContext);
	}

	@Then("Approve or Reject RequestAccess for the user")
	public void approveOrRejectRequestAccessForTheUser(DataTable table) {
		userPage.approveRejectUserAccess(table);

	}

	@Then("Verify Status in Search Screen")
	public void verifyApprovalStatusInUserDetailsScreen(DataTable table) {
		userPage.verifySearchStatus(testContext,table);
	}

	@Then("Perform Block and UnBlock Access for user")
	public void performBlockAndUnBlockAccessForUser(DataTable table) {
		userPage.blockUnBlockUser(table);

	}

	@Then("Approve or Reject Block Access For User")
	public void approveOrRejectBlockAccessForUser(DataTable table) {
		userPage.approveRejectBlock(table);
	}

    @Then("Perform User import using the file \"([^\"]*)\"$")
    public void performUserImportUsingTheFile(String msgPath) throws IOException, AWTException {
		userPage.importUser(msgPath);
    }

	@Then("Perform search using below criteria")
	public void performSearchForUserInUsersScreenWithTheFollowing(DataTable table) {
	userPage.searchUser(table,testContext);
	}
}