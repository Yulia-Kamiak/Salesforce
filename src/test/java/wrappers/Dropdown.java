package wrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Dropdown {

    WebDriver driver;
    String label;
    String locator = "//span[contains(text(), '%s')]//ancestor::*[contains(@class, 'uiInputSelect')]//descendant::*" +
            "[contains(@class, 'select')]";
    String choiceLocator = "[title='%s']";

    public Dropdown(WebDriver driver, String label) {
        this.driver=driver;
        this.label=label;
    }

    public Dropdown select(String option) {
        driver.findElement(By.xpath(String.format(locator, label))).click();
        driver.findElement(By.cssSelector(String.format(choiceLocator, option))).click();
        return this;
    }
}