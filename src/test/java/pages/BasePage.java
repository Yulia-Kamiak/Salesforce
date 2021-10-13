package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {

    public static final String BASE_URL = "https://krimmaa2.my.salesforce.com/";
    String PAGE_OPENED_LOCATOR = "//*[contains(@class, 'slds-grid')]//*[contains(@class, 'slds-is-active')]//*[span" +
            "[contains(text(), '%s')]]";

    WebDriver driver;
    WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    public abstract BasePage open();

    public boolean isPageOpened(String pageName) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(PAGE_OPENED_LOCATOR,
                    pageName))));
        } catch (TimeoutException exception) {
            return false;
        }
        return true;
    }
}