package pages;

import models.Account;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import wrappers.Checkbox;
import wrappers.Input;
import wrappers.Dropdown;
import wrappers.Textarea;

public class AccountPage extends BasePage {

    public static final By BUTTON_NEW_ACCOUNT_LOCATOR = By.xpath("//*[contains(@class, 'slds-grid')]//descendant::*" +
            "[contains(@title, 'New')]");
    public static final By NEW_ACCOUNT_FORM_LOCATOR = By.xpath("//span[contains(text(), 'Account Name')]/ancestor::" +
            "div[contains(@class, 'uiInput')]//input");
    public static final By SAVE_BUTTON_LOCATOR = By.cssSelector("[title='Save']");

    public AccountPage(WebDriver driver) {
        super(driver);
    }

    public AccountPage clickNew() {
        driver.findElement(BUTTON_NEW_ACCOUNT_LOCATOR).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(NEW_ACCOUNT_FORM_LOCATOR));
        return new AccountPage(driver);
    }

    @Override
    public AccountPage open() {
        driver.get(BASE_URL + "lightning/o/Account/list?filterName=Recent");
        wait.until(ExpectedConditions.visibilityOfElementLocated(BUTTON_NEW_ACCOUNT_LOCATOR));
        return this;
    }

    public AccountPage createAccount(Account account) {
        new Input(driver, "Account Name").write(account.getAccountName());
        new Input(driver, "Parent Account").write(account.getParentAccount());
        new Input(driver, "Phone").write(account.getPhone());
        new Input(driver, "Fax").write(account.getFax());
        new Input(driver, "Website").write(account.getWebsite());
        new Dropdown(driver, "Type").select("Analyst");
        new Dropdown(driver, "Industry").select("Apparel");
        new Input(driver, "Employees").write(account.getEmployees());
        new Input(driver, "Annual Revenue").write(account.getAnnualRevenue());
        new Textarea(driver, "Description").write(account.getDescription());
        new Textarea(driver, "Billing Street").write(account.getBillingStreet());
        new Input(driver, "Billing City").write(account.getBillingCity());
        new Input(driver, "Billing State/Province").write(account.getBillingState());
        new Input(driver, "Billing Zip/Postal Code").write(account.getBillingZip());
        new Input(driver, "Billing Country").write(account.getBillingCountry());
        new Checkbox(driver, "Copy Billing Address to Shipping Address").choose();
        return new AccountPage(driver);
    }

    public AccountPage clickSave() {
        driver.findElement(SAVE_BUTTON_LOCATOR).click();
        return new AccountPage(driver);
    }
}
