package pageObjects;

import com.paulhammant.ngwebdriver.ByAngularButtonText;

import cucumber.TestContext;
import cucumber.api.DataTable;
import enums.Context;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.awt.*;
import java.util.List;
import java.util.Map;
import static selenium.SeleniumHelper.*;

public class UserPage {
	WebDriver driver;

	public UserPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[contains(.,'IDAM')]")
	private WebElement label_IDAM;

	@FindBy(xpath = "//span[text()='Users']")
	private WebElement label_Users;

	@ByAngularButtonText.FindBy(buttonText = "Add User")
	private WebElement btn_AddUser;

	@FindBy(xpath = "//button[contains(.,'Create User')]")
	private WebElement btn_CreateUser;

	@FindBy(id = "firstName")
	private WebElement input_FirstName;

	@FindBy(id = "lastName")
	private WebElement input_LastName;

	@FindBy(id = "email")
	private WebElement input_Email;

	@FindBy(xpath = "//mat-select[@id='userType']//div[contains(@id,'mat-select')]/span")
	private WebElement select_userType;

	@FindBy(xpath = "//span[contains(.,'Select Document Type')]")
	private WebElement select_IdType;

	@FindBy(xpath = "//mat-select[@id='gender']//div[contains(@id,'mat-select')]/span")
	private WebElement select_Gender;

	@FindBy(id = "documentId")
	private WebElement input_DocumentID;

	@FindBy(xpath = "//mat-select[@id='dialcode']//span[contains(.,'Select Country Code')]")
	private WebElement select_dialcode;

	@FindBy(id = "phone")
	private WebElement input_Phone;

	@FindBy(xpath = "//mat-label[contains(.,'Role Group')]")
	private WebElement select_RoleGroup;

	@FindBy(id = "title")
	private WebElement input_JobTitle;

	@FindBy(id = "description")
	private WebElement input_Justification;

	@FindBy(id = "physicalDeliveryOfficeName")
	private WebElement input_Employer;

	@FindBy(id = "info")
	private WebElement input_SupervisorName;

	@FindBy(xpath = "//mat-select[@id='dialcodei']//span[contains(.,'Select Country Code')]")
	private WebElement select_SupDialCode;

	@FindBy(id = "otherMobile")
	private WebElement input_SupervisorMobile;

	@FindBy(id = "otherMailbox")
	private WebElement input_OtherMail;

	@FindBy(id = "postOfficeBox")
	private WebElement input_ProjectName;

	@FindBy(xpath = "//input[@id='datej']/following-sibling::mat-datepicker")
	private WebElement expiryDate;

	@FindBy(id = "streetAddress")
	private WebElement input_Tag;

	@FindBy(id = "roomNumber")
	private WebElement input_TicketID;

	@FindBy(xpath = "//span[contains(.,'Select Nationality')]")
	private WebElement select_Nationality;

	@FindBy(xpath = "//button[contains(@class,'toggle')]")
	private WebElement toggle;

	@FindBy(xpath = "//img[contains(@src,'avatars')]")
	private WebElement avatar;

	@FindBy(xpath = "//span[@class='mat-option-text' and contains(.,'+91')]")
	private WebElement option_PhnIndia;

	@FindBy(xpath = "//span[@class='mat-option-text' and contains(.,'Automation Administrator')]")
	private WebElement option_Role;

	@FindBy(xpath = "//mat-option[contains(@value,'Qatar ID')]/span")
	private WebElement option_Qatar;

	@FindBy(xpath = "//span[@class='mat-option-text' and contains(.,'🇮🇳 India')]")
	private WebElement option_NationIndia;

	@FindBy(xpath = "//mat-label[contains(.,'Date Of Birth')]/ancestor::mat-form-field//button")
	private WebElement calenderBtn1;

	@FindBy(id = "filterText")
	private WebElement input_SearchUser;

	@FindBy(xpath = "//table[@id='mytable']//td[3]")
	private WebElement table_IDAMID;

	@FindBy(xpath = "//table[@id='mytable']//td[6]")
	private WebElement table_userStatus;

	@FindBy(xpath = "//table[@id='mytable']//td[9]")
	private WebElement table_userApprovalStatus;

	@FindBy(xpath = "//button[contains(@aria-label,'row action with a menu')]")
	private WebElement btn_ActionUsers;

	@FindBy(xpath = "//span[contains(.,'View Details')]")
	private WebElement btn_ViewDetails;

	@FindBy(xpath = "//mat-button-toggle[@value='Approved']//button[@name='approvalStatus']//mat-icon")
	private List<WebElement> btn_approve;

	@FindBy(xpath = "//mat-button-toggle[@value='Rejected']//button[@name='approvalStatus']//mat-icon")
	private List<WebElement> btn_Reject;

	@FindBy(xpath = "//textarea[@name='Comment']")
	private List<WebElement> textarea_Comments;

	@FindBy(id = "rejectBtn")
	private WebElement btn_Submit;

	@ByAngularButtonText.FindBy(buttonText = "Yes")
	private WebElement confirm_Yes;

	@ByAngularButtonText.FindBy(buttonText = "No")
	private WebElement confirm_No;

	@ByAngularButtonText.FindBy(buttonText = "Block Access")
	private WebElement btn_BlockAccess;

	@ByAngularButtonText.FindBy(buttonText = "Unblock Access")
	private WebElement btn_UnBlockAccess;

	@ByAngularButtonText.FindBy(buttonText = "Close")
	private WebElement btn_CloseUserScreen;

	@FindBy(xpath = "//textarea[contains(@name,'comment.managerComment')]")
	private WebElement textArea_ManagerComments;

	@FindBy(xpath = "(//textarea[contains(@name,'comment.approverComment')])[2]")
	private WebElement textArea_ApproverComments;

	@ByAngularButtonText.FindBy(buttonText = "Ok")
	private WebElement btn_Ok;

	@ByAngularButtonText.FindBy(buttonText = "OK")
	private WebElement btn_OK;

	@FindBy(xpath = "//button//span[contains(.,'Approve Block')]")
	private WebElement btn_ApproveBlock;

	@FindBy(xpath = "//button//span[contains(.,'Approve Unblock')]")
	private WebElement btn_ApproveUnBlock;

	@ByAngularButtonText.FindBy(buttonText = "Next")
	private WebElement btn_Next;

	@FindBy(xpath = "(//button[@type='submit']//span[contains(.,'Next')])[2]")
	private WebElement btn_NextUpload;

	@ByAngularButtonText.FindBy(buttonText = "Upload")
	private WebElement btn_Upload;

	@FindBy(xpath = "//mat-icon[@id='inputFileIcon']")
	private WebElement input_UploadClick;

	@FindBy(id = "inputFile")
	private WebElement input_File;

	private WebElement getElementByXpath(String xpath) {
		return driver.findElement(By.xpath(xpath));
	}

	private WebElement getElementByCss(String css) {
		return driver.findElement(By.cssSelector(css));
	}

	public void createUsers(DataTable table, TestContext context) throws AWTException {
		final Map<String, String> map = table.asMap(String.class, String.class);

		waitForElementToBeLoaded(btn_AddUser,driver);
		clickElement(btn_AddUser,driver);
		waitForAngularRequestToFinish();
		enterTextIntoTextBox(input_FirstName, map.get("firstName"));
		enterTextIntoTextBox(input_LastName, map.get("lastName"));
		enterTextIntoTextBox(input_Email, generateRandomEmail());
		waitInSeconds(2000);

		clickElement_JS(calenderBtn1,driver);
		waitInSeconds(1000);
		getElementByXpath("//mat-calendar[contains(@id,'mat-datepicker')]/mat-calendar-header//button/span/div")
				.click();
		getElementByXpath(
				"//mat-calendar[contains(@id,'mat-datepicker')]//mat-multi-year-view/table//td[contains(.,'1982')]")
						.click();
		getElementByXpath("//mat-calendar[contains(@id,'mat-datepicker')]//td[contains(.,'MAR')]").click();
		getElementByXpath("//mat-calendar[contains(@id,'mat-datepicker')]//td[contains(.,'20')]").click();
		waitInSeconds(2000);
		selectOptionFromSelectBox(select_userType, map.get("userType"),driver);
		waitForAngularRequestToFinish();
		selectOptionFromSelectBox(select_Gender, map.get("gender"),driver);
		waitForAngularRequestToFinish();

		scrollDown(driver);
		enterTextIntoTextBox(input_DocumentID, map.get("documentID"));
		waitInSeconds(1000);
		selectOptionFromDropDown(select_IdType, option_Qatar,driver);
		waitForAngularRequestToFinish();

		selectOptionFromDropDown(select_dialcode, option_PhnIndia,driver);
		long phnNo = generateRandomNo();
		enterTextIntoTextBox(input_Phone, String.valueOf(phnNo));
		waitInSeconds(2000);
		
		context.getScenarioContext().setContext(Context.USER_PHN, String.valueOf(phnNo));
		selectOptionFromDropDown(select_RoleGroup, option_Role,driver);

		enterTextIntoTextBox(input_JobTitle, map.get("jobTitle"));
		enterTextIntoTextBox(input_Justification, map.get("justification"));
		enterTextIntoTextBox(input_Employer, map.get("employer"));
		enterTextIntoTextBox(input_SupervisorName, map.get("supervisorName"));

		waitInSeconds(3000);
		selectOptionFromDropDown(select_SupDialCode, option_PhnIndia,driver);
		enterTextIntoTextBox(input_SupervisorMobile, String.valueOf(generateRandomNo()));
		enterTextIntoTextBox(input_OtherMail, generateRandomEmail());
		enterTextIntoTextBox(input_ProjectName, map.get("projectName"));

		getElementByXpath("//mat-label[contains(.,'Access Expiry Date')]/ancestor::mat-form-field//button").click();
		waitInSeconds(1000);
		getElementByXpath("//mat-calendar[contains(@id,'mat-datepicker')]/mat-calendar-header//button/span/div")
				.click();
		getElementByXpath(
				"//mat-calendar[contains(@id,'mat-datepicker')]//mat-multi-year-view/table//td[contains(.,'2022')]")
						.click();
		getElementByXpath("//mat-calendar[contains(@id,'mat-datepicker')]//td[contains(.,'MAR')]").click();
		getElementByXpath("//mat-calendar[contains(@id,'mat-datepicker')]//td[contains(.,'20')]").click();

		enterTextIntoTextBox(input_Tag, map.get("tag"));
		enterTextIntoTextBox(input_TicketID, map.get("ticketID"));
		selectOptionFromDropDown(select_Nationality, option_NationIndia,driver);
		clickElement_JS(btn_CreateUser,driver);
		waitForAngularRequestToFinish();
	}

	public void navigateViewDetails(TestContext testContext) {
		clickElement_JS(btn_ActionUsers,driver);
		waitForElementToBeLoaded(btn_ViewDetails,driver);
		clickElement_JS(btn_ViewDetails,driver);
		waitForAngularRequestToFinish();
		waitInSeconds(3000);
	}

	public void approveRejectUserAccess(DataTable table) {
		final Map<String, String> map = table.asMap(String.class, String.class);
		scrollDown(driver);
		Actions act = new Actions(driver);
		act.moveToElement(textarea_Comments.get(0)).build().perform();

		if (map.get("setRoleStatus").equalsIgnoreCase("approved")) {
			for (int i = 0; i < btn_approve.size(); i++) {
				waitForElementToBeLoaded(btn_approve.get(i),driver);
				clickElement_JS(btn_approve.get(i),driver);
			}
		} else {
			for (int i = 0; i < btn_Reject.size(); i++) {
				waitForElementToBeLoaded(btn_Reject.get(i),driver);
				clickElement_JS(btn_Reject.get(i),driver);
				waitInSeconds(2000);
				enterTextIntoTextBox(textarea_Comments.get(i), "Reject Access");
			}
		}
		clickElement_JS(btn_Submit,driver);
		waitInSeconds(2000);
		waitForAngularRequestToFinish();
		clickElement_JS(confirm_Yes,driver);
		waitForAngularRequestToFinish();

	}

	public void verifyRoleApprovalStatus(TestContext testContext, DataTable table) {
		final Map<String, String> hmap = table.asMap(String.class, String.class);
		Actions act = new Actions(driver);

		if (hmap.get("approvalStatus") != null) {
			waitForElementToBeLoaded(table_userApprovalStatus,driver);
			act.moveToElement(table_userApprovalStatus).build().perform();
			Assert.assertEquals(table_userApprovalStatus.getText(), hmap.get("approvalStatus"));
		} else if (hmap.get("IDAMID") != null) {
			waitForElementToBeLoaded(table_IDAMID,driver);
			act.moveToElement(table_IDAMID).build().perform();
			Assert.assertNotNull( "IDAM ID is not generated for user",table_IDAMID);
		} else if (hmap.get("userStatus") != null) {
			waitForElementToBeLoaded(table_userStatus,driver);
			act.moveToElement(table_userStatus).build().perform();
			Assert.assertEquals(table_userStatus.getText(), hmap.get("userStatus"));
		}
	}

	public void blockUnBlockUser(DataTable table) {
		final Map<String, String> hmap = table.asMap(String.class, String.class);
		if (hmap.get("action").equalsIgnoreCase("Block")) {
			clickElement(btn_BlockAccess,driver);
			waitInSeconds(2000);
			clickElement(confirm_Yes,driver);
			waitInSeconds(2000);
			enterTextIntoTextBox(textArea_ManagerComments, hmap.get("blockComments"));
			waitInSeconds(2000);
			clickElement(btn_OK,driver);
			waitForAngularRequestToFinish();
			clickElement(btn_CloseUserScreen,driver);
		} else {
			clickElement(btn_UnBlockAccess,driver);
			waitInSeconds(2000);
			clickElement(confirm_Yes,driver);
			waitInSeconds(2000);
			enterTextIntoTextBox(textArea_ManagerComments, hmap.get("blockComments"));
			waitInSeconds(2000);
			clickElement(btn_OK,driver);
			waitForAngularRequestToFinish();
			clickElement(btn_CloseUserScreen,driver);
		}
	}

	public void approveRejectBlock(DataTable table) {
		final Map<String, String> hmap = table.asMap(String.class, String.class);

		if (hmap.get("action").equalsIgnoreCase("approveBlock")) {
			scrollTillPageEnd(driver);
			clickElement_JS(btn_ApproveBlock,driver);
			waitInSeconds(2000);
			enterTextIntoTextBox(textArea_ApproverComments, hmap.get("blockComments"));
			waitInSeconds(2000);
			clickElement(btn_Ok,driver);
			waitForAngularRequestToFinish();
		} else {
			scrollTillPageEnd(driver);
			clickElement_JS(btn_ApproveUnBlock,driver);
			waitInSeconds(2000);
			enterTextIntoTextBox(textArea_ApproverComments, hmap.get("blockComments"));
			waitInSeconds(2000);
			clickElement(btn_Ok,driver);
			waitForAngularRequestToFinish();
		}
	}

	public void importUser(String msgPath) throws AWTException {
		msgPath = System.getProperty("user.dir") + msgPath;
		waitForAngularRequestToFinish();
		waitInSeconds(10000);
		clickElement(btn_Next,driver);

		String winHandleBefore = driver.getWindowHandle();
		clickElement(input_UploadClick,driver);
		waitInSeconds(3000);
		fileUploadRobot(msgPath);
		waitForAngularRequestToFinish();

		driver.switchTo().window(winHandleBefore);
		scrollTillPageEnd(driver);
		waitInSeconds(3000);

		scrollToElementActions(driver, btn_NextUpload);
		clickElement_JS(btn_NextUpload,driver);
		waitInSeconds(2000);
		clickElement(btn_Upload,driver);
		waitForAngularRequestToFinish();
		waitInSeconds(5000);

	}

	public void searchUser(DataTable table, TestContext testContext) {
		final Map<String, String> map = table.asMap(String.class, String.class);
		waitForElementToBeLoaded(input_SearchUser,driver);

		switch (map.get("searchCriteria")) {
		case "email":
			input_SearchUser.sendKeys((String)testContext.getScenarioContext().getContext(Context.USER_EMAIL));
			break;
		case "phoneNo":
			String phn = (String)testContext.getScenarioContext().getContext(Context.USER_PHN);
			input_SearchUser.sendKeys(phn);
			System.out.println("Search User with No===>"+phn);
			break;
		}
		input_SearchUser.sendKeys(Keys.ENTER);
		waitInSeconds(3000);
		waitForAngularRequestToFinish();
		waitForElementToBeLoaded(btn_ActionUsers,driver);
	}
}