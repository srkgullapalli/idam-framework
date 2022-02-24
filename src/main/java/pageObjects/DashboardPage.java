package pageObjects;

import cucumber.api.DataTable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Map;

import static selenium.SeleniumHelper.clickElement;
import static selenium.SeleniumHelper.waitForAngularRequestToFinish;

public class DashboardPage {
    WebDriver driver;
    @FindBy(xpath = "//span[contains(.,'IDAM')]")
    private WebElement label_IDAM;

    @FindBy(xpath = "//span[text()='Users']")
    private WebElement label_Users;

    @FindBy(xpath = "//span[text()='Pending Approvals']")
    private WebElement label_PendingApprovals;

    @FindBy(xpath = "//a[@href=\"/ticket-enablement/imports\"]/span")
    private WebElement lbl_TicketImports;

    @FindBy(xpath = "//a[@href=\"/user-management/imports\"]/span")
    private WebElement lbl_UserImports;

    @FindBy(xpath = "//span[contains(.,'Ticket Enablement')]")
    private WebElement label_TicketEnablement;

    @FindBy(xpath = "//span[contains(.,'Mass Access')]")
    private WebElement label_MassAccess;

    @FindBy(xpath = "//a[@href=\"/ticket-enablement/tickets\"]/span")
    private WebElement label_TESTickets;

    @FindBy(xpath = "//a[@href=\"/mass-access/tickets\"]/span")
    private WebElement label_MASTickets;

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void selectService(DataTable table) {
        final Map<String, String> input = table.asMap(String.class, String.class);
        waitForAngularRequestToFinish();
        switch (input.get("service")) {
            case "IDAM":
                clickElement(label_IDAM, driver);
                break;
            case "TicketEnablement":
                clickElement(label_TicketEnablement, driver);
                break;
            case "MassAccess":
                clickElement(label_MassAccess, driver);
                break;
            case "SpecialNeeds":
                break;
        }
    }

    public void selectSubService(DataTable table) {
        final Map<String, String> input = table.asMap(String.class, String.class);
        switch (input.get("subService")) {
            case "Users":
                clickElement(label_Users, driver);
                break;
            case "Pending Approvals":
                clickElement(label_PendingApprovals, driver);
                break;
            case "TES Imports":
                clickElement(lbl_TicketImports, driver);
                break;
            case "User Imports":
                clickElement(lbl_UserImports, driver);
                break;
            case "TES Tickets":
                clickElement(label_TESTickets, driver);
                break;
            case "Mass Access Tickets":
                clickElement(label_MASTickets, driver);
                break;
        }
    }
}