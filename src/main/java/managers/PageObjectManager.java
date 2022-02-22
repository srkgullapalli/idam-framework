package managers;

import org.openqa.selenium.WebDriver;
import pageObjects.*;

public class PageObjectManager {
    private WebDriver driver;
    private HomePage homePage;
    private LoginPage loginPage;
    private DashboardPage dashboardPages;
    private UserPage userPage;

    public PageObjectManager(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage getLoginPage() {
        return (loginPage == null) ? loginPage = new LoginPage(driver) : loginPage;
    }
    
    public DashboardPage getDashboardPage() {
        return (dashboardPages == null) ? dashboardPages = new DashboardPage(driver) : dashboardPages;
    }
    
    public UserPage getUserPage() {
        return (userPage == null) ? userPage = new UserPage(driver) : userPage;
    }


    public HomePage getHomePage() {
        return (homePage == null) ? homePage = new HomePage(driver) : homePage;
    }

 
}
