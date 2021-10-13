package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Selection {

    WebDriver driver;
    String label;
    String locator = "//span[contains(text(), '%s')]//ancestor::*[contains(@class, 'uiInput')]//descendant::*[contains(@class, 'select')]";
    String choiceLocator = "[title='%s']";

    public Selection(WebDriver driver, String label) {
        this.driver=driver;
        this.label=label;
    }

    public void select(String option) {
        WebElement list = driver.findElement(By.xpath(String.format(locator, label)));
        list.click();
        driver.findElement(By.cssSelector(String.format(choiceLocator, option))).click();
    }
}