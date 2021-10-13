package wrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Checkbox {

    WebDriver driver;
    String label;
    String locator = "//span[contains(text(), '%s')]//ancestor::*[contains(@class, 'uiInput')]//descendant::*" +
            "[contains(@type, 'checkbox')]";

    public Checkbox(WebDriver driver, String label) {
        this.driver=driver;
        this.label=label;
    }

    public Checkbox choose() {
        driver.findElement(By.xpath(String.format(locator, label))).click();
        return this;
    }
}