package wrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Input {

    WebDriver driver;
    String label;
    String locator = "//span[contains(text(), '%s')]/ancestor::div[contains(@class, 'uiInput')]//input";

    public Input(WebDriver driver, String label) {
        this.driver=driver;
        this.label=label;
    }

    public Input write(String text) {
        driver.findElement(By.xpath(String.format(locator, label))).sendKeys(text);
        return this;
    }
}