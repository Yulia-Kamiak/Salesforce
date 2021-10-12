package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AccountPage extends BasePage {

    public static final By BUTTON_NEW_ACCOUNT_LOCATOR = By.xpath("//*[contains(@class, 'slds-grid')]//descendant::*" +
            "[contains(@title, 'New')]");
    public static final By NEW_ACCOUNT_FORM_LOCATOR = By.xpath("//span[contains(text(), 'Account Name')]/ancestor::" +
            "div[contains(@class, 'uiInput')]//input");

    public AccountPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get(BASE_URL + "lightning/o/Account/list?filterName=Recent");
        wait.until(ExpectedConditions.visibilityOfElementLocated(BUTTON_NEW_ACCOUNT_LOCATOR));
    }

    public void createAccount(String accountName, String parentAccount, String phone, String fax, String website,
                              String employees, String annualRevenue, String description, String billingStreet,
                              String billingCity, String billingState, String billingZip, String billingCountry) {
        driver.findElement(BUTTON_NEW_ACCOUNT_LOCATOR).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(NEW_ACCOUNT_FORM_LOCATOR));
        new Input(driver, "Account Name").write(accountName);
        new Input(driver, "Parent Account").write(parentAccount);
        new Input(driver, "Phone").write(phone);
        new Input(driver, "Fax").write(fax);
        new Input(driver, "Website").write(website);
        new Selection(driver, "Type").select("Analyst");
        new Selection(driver, "Industry").select("Apparel");
        new Input(driver, "Employees").write(employees);
        new Input(driver, "Annual Revenue").write(annualRevenue);
        new Textarea(driver, "Description").write(description);
        new Textarea(driver, "Billing Street").write(billingStreet);
        new Input(driver, "Billing City").write(billingCity);
        new Input(driver, "Billing State/Province").write(billingState);
        new Input(driver, "Billing Zip/Postal Code").write(billingZip);
        new Input(driver, "Billing Country").write(billingCountry);
        new Checkbox(driver, "Copy Billing Address to Shipping Address").choose();
    }
}