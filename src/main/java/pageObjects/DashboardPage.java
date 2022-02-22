package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.DataTable;

import java.util.Map;
import static selenium.SeleniumHelper.clickElement;
import static selenium.SeleniumHelper.waitForAngularRequestToFinish;

public class DashboardPage {
	WebDriver driver;

	public DashboardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[contains(.,'IDAM')]")
	private WebElement label_IDAM;

	@FindBy(xpath = "//span[text()='Users']")
	private WebElement label_Users;

	@FindBy(xpath = "//span[text()='Pending Approvals']")
	private WebElement label_PendingApprovals;

	@FindBy(xpath = "//span[text()='Imports']")
	private WebElement label_Imports;

	public void selectService(DataTable table) {
		final Map<String, String> input = table.asMap(String.class, String.class);
		waitForAngularRequestToFinish();
		switch (input.get("service")) {
		case "IDAM":
			clickElement(label_IDAM,driver);
			break;
		case "TicketEnablement":
			break;
		case "MassAccess":
			break;
		case "SpecialNeeds":
			break;
		}
	}

	public void selectSubService(DataTable table) {
		final Map<String, String> input = table.asMap(String.class, String.class);
		switch (input.get("subService")) {
		case "Users":
			clickElement(label_Users,driver);
			break;
		case "Pending Approvals":
			clickElement(label_PendingApprovals,driver);
			break;
		case "Imports":
			clickElement(label_Imports,driver);
			break;
		}
	}
}