package wrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Textarea {

    WebDriver driver;
    String label;
    String locator = "//span[contains(text(), '%s')]//ancestor::*[contains(@class, 'slds-form-element__control')]" +
            "//textarea";

    public Textarea(WebDriver driver, String label) {
        this.driver=driver;
        this.label=label;
    }

    public Textarea write(String text) {
        driver.findElement(By.xpath(String.format(locator, label))).sendKeys(text);
        return this;
    }
}