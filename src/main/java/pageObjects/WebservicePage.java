package pageObjects;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Assert;

import cucumber.TestContext;
import cucumber.api.DataTable;
import enums.Context;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

public class WebservicePage {

	private static Response response;
	private static String jsonString;

	public static String triggerWebService(String filePath, DataTable table, TestContext context) {
		final Map<String, String> inputMap = table.asMap(String.class, String.class);

		String httpMethod = inputMap.get("httpMethod") != null ? inputMap.get("httpMethod").trim() : "";
		String endPoint = inputMap.get("endPoint") != null ? inputMap.get("endPoint").trim() : "";

		String authToken = (String) context.getScenarioContext().getContext(Context.ACCESS_TOKEN) != null
				? (String) context.getScenarioContext().getContext(Context.ACCESS_TOKEN)
				: "";
		String restrictedAccess = inputMap.get("restrictedAccess") != null ? inputMap.get("restrictedAccess").trim()
				: "";
		String requestBody = new File(filePath).exists() ? generateStringFromRes(filePath) : "";

		String baseURL = "https://identity-staging.hostcountry.qa";
		RestAssured.baseURI = baseURL;
		RequestSpecification request = RestAssured.given();

		request.headers("Content-Type", "application/json", "Authorization", authToken, "restrictAccess",
				restrictedAccess);
		String resourceID;

		switch (httpMethod) {
		case "Get":
			if (inputMap.get("resourceID") != null) {
				String resource = inputMap.get("resourceID").trim();
				endPoint = endPoint + "/" + resource;
			}
			System.out.println("Endpoint=======>" + endPoint);
			response = request.log().all().get(endPoint);
			break;
		case "Post":
			response = request.log().all().body(requestBody).post(endPoint);
			break;
		case "Delete":
			resourceID = inputMap.get("resourceID") != null ? inputMap.get("resourceID")
					: (String) context.getScenarioContext().getContext(Context.RESOURCE_ID);
			endPoint = endPoint + "/" + resourceID;
			response = request.log().all().body(requestBody).delete(endPoint);
			break;
		case "Put":
			resourceID = inputMap.get("resourceID") != null ? inputMap.get("resourceID")
					: (String) context.getScenarioContext().getContext(Context.RESOURCE_ID);
			endPoint = endPoint + "/" + resourceID;
			response = request.log().all().body(requestBody).put(endPoint);
			break;
		}
		int statusCode = response.getStatusCode();
		// Verify Response Status is 200
		Assert.assertEquals(200, statusCode);
		ResponseBody body = response.getBody();
		jsonString = body.asPrettyString();
		
		System.out.println("######################Completed WebService Cal#####################");
		return jsonString;

	}

	private static String generateStringFromRes(String path) {
		String requestBody = null;

		try {
			requestBody = new String(Files.readAllBytes(Paths.get(path)));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return requestBody;
	}

	public static void validateAPIResponse(DataTable table, TestContext testContext) {
		final Map<String, String> inputMap = table.asMap(String.class, String.class);
		
		String jsonResponse = (String)testContext.getScenarioContext().getContext(Context.API_RESPONSE);

		switch (inputMap.get("service")) {
		case "PostingEvent":
			validatePostAndUpdateEvents(jsonResponse,testContext);
			break;
		case "Update Event":
			validatePostAndUpdateEvents(jsonResponse,testContext);
			break;
		case "DeleteEvent":
			validateDeleteEvent(jsonResponse);
			break;
		case "GetAllServices":
			validateGetAllServices(jsonResponse);
			break;
		case "PostService":
			validatePostService(jsonResponse);
			break;
		case "GetSingleUser":
			validateGetSingleUserData(jsonResponse);
			break;
		case "GetSingleEvent":
			validateGetSingleEventData(jsonResponse);
			break;
		}
	}

	private static void validateGetSingleEventData(String jsonResponse) {
		JSONObject obj = new JSONObject(jsonResponse);
		// Verify Status is OK
		Assert.assertEquals("ok", obj.getString("status"));
		JSONObject msgBody = obj.getJSONObject("msg");
		// Verify message body is not null
		Assert.assertNotNull("Message Body is not Null", msgBody);
		// Verify Data is present for following fields
		Assert.assertNotNull("Event ID is null", msgBody.getString("_id"));
		Assert.assertNotNull("Event ID is null", msgBody.getString("eventId"));
		Assert.assertNotNull("Event Name is null", msgBody.getString("eventName"));
		Assert.assertNotNull("Event Status is null", msgBody.getString("eventStatus"));
		Assert.assertNotNull("Tournament is null", msgBody.getString("tournament"));
	}

	private static void validateGetSingleUserData(String jsonResponse) {
		JSONObject obj = new JSONObject(jsonResponse);
		// Verify Status is OK
		Assert.assertEquals("ok", obj.getString("status"));
		JSONObject msgBody = obj.getJSONObject("msg");
		// Verify message body is not null
		Assert.assertNotNull("Message Body is not Null", msgBody);
		// Verify IDAM ID is not null for user
		Assert.assertNotNull("IDAM ID  Null For user", msgBody.getString("idamUniqueId"));
		Assert.assertNotNull("Email  Null For user", msgBody.getString("email"));
		Assert.assertNotNull("PhoneNo  Null For user", msgBody.getString("phone"));
		Assert.assertNotNull("FirstName  Null For user", msgBody.getString("firstName"));
		Assert.assertNotNull("LastName  Null For user", msgBody.getString("lastName"));
	}

	private static void validatePostService(String jsonResponse) {
		JSONObject obj = new JSONObject(jsonResponse);
		// Verify Status is OK
		Assert.assertEquals("ok", obj.getString("status"));
		JSONObject msgBody = obj.getJSONObject("msg");
		// Verify message body is not null
		Assert.assertNotNull("Message Body is  Null", msgBody);
		String status = msgBody.getString("status");
		Assert.assertEquals("Valid", msgBody.getString("status"));
	}

	private static void validateGetAllServices(String jsonResponse) {
		JSONObject obj = new JSONObject(jsonResponse);
		// Verify Status is OK
		Assert.assertEquals("ok", obj.getString("status"));

		JSONArray eventsArray = obj.getJSONObject("msg").getJSONArray("data");
		// Verify Data array is not null
		Assert.assertNotNull("No data retruned from API", eventsArray);
		// Verify Current Events Count equals no of objects in Data Array
		int currentEvents = obj.getJSONObject("msg").getInt("current");
		Assert.assertEquals(currentEvents, eventsArray.length());
	}

	private static void validateDeleteEvent(String jsonResponse) {
		JSONObject obj = new JSONObject(jsonResponse);
		// Verify Status is OK and message is deleted
		Assert.assertEquals("ok", obj.getString("status"));
		Assert.assertEquals("Deleted", obj.getString("msg"));
	}

	/*
	 * This Method saves the eventID in Sessions map to be used in Subsesquent API
	 * calls like Put and Delete in case Resource ID is not passed
	 */
	private static void validatePostAndUpdateEvents(String response,TestContext testContext) {
		JSONObject obj = new JSONObject(response);
		// Verify Status is OK
		Assert.assertEquals("ok", obj.getString("status"));
		JSONObject msgBody = obj.getJSONObject("msg");
		// Verify message body is not null
		Assert.assertNotNull("Message Body is  Null", msgBody);
		
		// Verify EventID is created for the Input
		int eventID = Integer.parseInt(msgBody.getString("eventId"));
		Assert.assertNotNull("EventID is  Null", eventID);
		
		//Insert Resource ID into test Context
		testContext.getScenarioContext().setContext(Context.RESOURCE_ID, eventID);
	}

	public static void validateResponseGetRequest(String response) {
		JSONObject obj = new JSONObject(response);
		// Verify Status is OK
		Assert.assertEquals("ok", obj.getString("status"));
		// Verify Current Events Count equals no of objects in Data Array
		int currentEvents = obj.getJSONObject("msg").getInt("current");
		JSONArray eventsArray = obj.getJSONObject("msg").getJSONArray("data");
		Assert.assertEquals(currentEvents, eventsArray.length());
		// Verify Data array is not null
		Assert.assertNotNull("No data retruned from API", eventsArray);
	}
}
