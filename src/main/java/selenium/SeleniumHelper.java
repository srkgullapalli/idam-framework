/**
 *
 */
package selenium;


import managers.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.Random;
import java.util.UUID;

/**
 * @author Siva Rama Krishna
 *
 */
public class SeleniumHelper {

    private static final int waitForSeconds = 30;
    private static int screencastCounter = 0;

    public static void waitForAngularRequestToFinish() {
        try {
            new WebDriverManager().getNGDriver().waitForAngularRequestsToFinish();
        } catch (Exception ignored) {
        }
    }

    public static void waitForElementToBeLoaded(WebElement webElement, WebDriver driver) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, waitForSeconds);
        webDriverWait
                .ignoring(StaleElementReferenceException.class)
                .until(ExpectedConditions.or(
                        ExpectedConditions.elementToBeClickable(webElement),
                        ExpectedConditions.elementToBeSelected(webElement)
                ));
    }

    public static void enterTextIntoTextBox(WebElement textBox, String textToBeEntered) {
        try {
            textBox.sendKeys(textToBeEntered);
        } catch (Exception ignored) {
        }
    }

    public static void clickElement(WebElement clickable,WebDriver driver) {
        try {
        	waitForElementToBeLoaded(clickable,driver);
            clickable.click();
        } catch (Exception ignored) {
        }
    }

    public static void clickElement_JS(WebElement element, WebDriver driver) {
        try {
            JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
            jsExecutor.executeScript("arguments[0].scrollIntoView();", element);
            jsExecutor.executeScript("arguments[0].click();", element);
        } catch (Exception ignored) {
        }
    }

    public static void selectOptionFromSelectBox(WebElement selectBox, String selection, WebDriver driver) {
        try {
            waitForAngularRequestToFinish();
            clickElement(selectBox,driver);
            waitInSeconds(2000);
            WebElement option = driver.findElement(By.xpath("//mat-option[contains(@value,'" + selection + "')]/span"));
            clickElement(option,driver);
            waitInSeconds(1000);
        } catch (Exception ignored) {
        }
    }

    public static void selectOptionFromDropDown(WebElement parent, WebElement option, WebDriver driver) {
        try {
            waitForAngularRequestToFinish();
            clickElement_JS(parent, driver);
            waitInSeconds(2000);
            clickElement_JS(option, driver);
            waitInSeconds(1000);
        } catch (Exception ignored) {
        }
    }

    /*
    public static void takeScreenshot(WebDriver driver, TestResult result, String screencastName) {
        try {
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String path = FileReaderManager.getInstance().getConfigReader().getScreenshotsPath() + screencastName + "_"
                    + screencastCounter + ".png";
            FileUtils.copyFile(src, new File(path));
            screencastCounter++;
            ReportUtil.addScreencastLog(path, result.name());
        } catch (Exception ignored) {

        }
    }

     */

    public static void scrollDown(WebDriver driver) {
        Actions at = new Actions(driver);
        at.sendKeys(Keys.PAGE_DOWN).build().perform();
        at.sendKeys(Keys.PAGE_DOWN).build().perform();
    }

    public static void scrollTillPageEnd(WebDriver driver) {
        ((JavascriptExecutor) driver)
                .executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    public static void waitForAlertAndAccept(WebDriver driver) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, waitForSeconds);
        webDriverWait.ignoring(NoAlertPresentException.class)
                .until(ExpectedConditions.alertIsPresent());

        Alert al = driver.switchTo().alert();
        al.accept();
    }

    public static void waitInSeconds(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void assertTrue(boolean result, String message) {
        Assert.assertTrue(message, result);
    }

    public static void assertFalse(boolean result, String message) {
        Assert.assertTrue(message, result);
    }

    public static void zoomOut() throws AWTException {
        Robot robot = new Robot();
        for (int i = 0; i < 4; i++) {
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_SUBTRACT);
            robot.keyRelease(KeyEvent.VK_SUBTRACT);
            robot.keyRelease(KeyEvent.VK_CONTROL);
        }
    }

    public static void fileUploadRobot(String msgPath) throws AWTException {
        StringSelection ss = new StringSelection(msgPath);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

        //imitate mouse events like ENTER, CTRL+C, CTRL+V
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }

    public static long generateRandomNo() {
        return (long) (Math.random() * Math.pow(10, 10));
    }

    public static String generateRandomEmail() {
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(1000);
        return UUID.randomUUID().toString().substring(0, 5) + randomInt + "@gmail.com";
    }

    public static void scrollToElementActions(WebDriver driver, WebElement ele) {
        Actions actions = new Actions(driver);
        actions.moveToElement(ele).build().perform();
    }
}
