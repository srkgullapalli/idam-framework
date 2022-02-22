package stepDefinitions;

import org.json.JSONObject;

import cucumber.TestContext;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import enums.Context;
import static pageObjects.WebservicePage.*;

public class WebServicesSteps {
	TestContext testContext;

	public WebServicesSteps(TestContext context) {
		testContext = context;
	}

	@Given("Generate the Auth Token with following request \"([^\"]*)\"$")
	public void generateAuthToken(String msgPath, DataTable table) {
		String apiResponse = triggerWebService(msgPath, table, testContext);
		testContext.getScenarioContext().setContext(Context.API_RESPONSE, apiResponse);

		JSONObject obj = new JSONObject((String) testContext.getScenarioContext().getContext(Context.API_RESPONSE));
		testContext.getScenarioContext().setContext(Context.ACCESS_TOKEN,
				obj.getJSONObject("msg").getString("access_token"));

	}

	@Then("Trigger the API with authToken and request-body \"([^\"]*)\"$")
	public void triggerAPI(String msgPath, DataTable table) {
		String apiResponse = triggerWebService(msgPath, table, testContext);
		testContext.getScenarioContext().setContext(Context.API_RESPONSE, apiResponse);
	}

	@Given("^Delete The Resource$")
	public void deleteResource(DataTable table) {
		String msgPath = "";
		String apiResponse = triggerWebService(msgPath, table, testContext);
		testContext.getScenarioContext().setContext(Context.API_RESPONSE, apiResponse);
	}

	/*
	 * This Method saves the eventID in Sessions map to be used in Subsesquent API
	 * calls like Put and Delete in case Resource ID is not passed
	 */
	@Then("^Verify API Response for the following service$")
	public void verifyAPIResponseForTheFollowingService(DataTable table) {
		validateAPIResponse(table, testContext);
	}

	@Then("Verify response data for the get request")
	public void verifyResponseDataForTheGetRequest() {
		validateResponseGetRequest((String) testContext.getScenarioContext().getContext(Context.API_RESPONSE));
	}
}