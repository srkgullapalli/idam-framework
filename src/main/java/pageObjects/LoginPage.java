package pageObjects;

import com.paulhammant.ngwebdriver.ByAngularButtonText;
import cucumber.api.DataTable;
import managers.FileReaderManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Map;

import static selenium.SeleniumHelper.*;

public class LoginPage {
    WebDriver driver;
    @FindBy(xpath = "//button[contains(.,'Login')]")
    private WebElement btn_Login;
    @FindBy(id = "email")
    private WebElement text_Email;
    @FindBy(id = "password")
    private WebElement text_Password;
    @FindBy(id = "next")
    private WebElement btn_Singin;
    @FindBy(xpath = "//idams-toolbar-user/div")
    private WebElement btn_Profile;
    @ByAngularButtonText.FindBy(buttonText = "Logout")
    private WebElement btn_Logout;
    @ByAngularButtonText.FindBy(buttonText = "Yes")
    private WebElement confirm_Yes;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void appLogin(DataTable table) {
        final Map<String, String> hmap = table.asMap(String.class, String.class);

        clickElement(btn_Login, driver);
        waitForAngularRequestToFinish();
        waitForElementToBeLoaded(text_Email, driver);
        enterTextIntoTextBox(text_Email, hmap.get("UserName"));
        enterTextIntoTextBox(text_Password, hmap.get("Password"));
        clickElement(btn_Singin, driver);
        waitForAngularRequestToFinish();
    }

    public void appLogout() {
        waitForElementToBeLoaded(btn_Profile, driver);
        clickElement_JS(btn_Profile, driver);
        waitForElementToBeLoaded(btn_Logout, driver);
        clickElement_JS(btn_Logout, driver);
        clickElement(confirm_Yes, driver);
        waitForAngularRequestToFinish();
        waitInSeconds(5000);
    }

    public void launchApp() {
        String appUrl = FileReaderManager.getInstance().getConfigReader().getApplicationUrl();

        driver.get(appUrl);
        waitForAngularRequestToFinish();
    }
}