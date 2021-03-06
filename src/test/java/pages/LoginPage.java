package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage{

    public static final By USERNAME_LOCATOR = By.id("username");
    public static final By PASSWORD_LOCATOR = By.id("password");
    public static final By LOGIN_BUTTON_LOCATOR = By.id("Login");
    public static final By SUCCESS_LOGIN_LOCATOR = By.xpath("//*[contains(@class, 'slds-context-bar')]//descendant::*" +
            "[contains(@title, 'Home')]");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public LoginPage open() {
        driver.get(BASE_URL);
        return this;
    }

    public boolean isPageOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(LOGIN_BUTTON_LOCATOR));
        } catch (TimeoutException exception) {
            return false;
        }
        return true;
    }

    public HomePage login(String user, String password) {
        driver.findElement(USERNAME_LOCATOR).sendKeys(user);
        driver.findElement(PASSWORD_LOCATOR).sendKeys(password);
        driver.findElement(LOGIN_BUTTON_LOCATOR).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(SUCCESS_LOGIN_LOCATOR));
        return new HomePage(driver);
    }
}
