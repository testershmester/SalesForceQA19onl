package by.teachmeskills.wrapper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static java.time.temporal.ChronoUnit.SECONDS;

public class DropDown {

    private WebDriver driver;
    private String label;

    public static final String DROP_DOWN_LOCATOR = "//label[text()='%s']//ancestor::lightning-combobox//button";
    public static final String ITEM_LOCATOR = "//lightning-base-combobox-item//span[text()='%s']";

    public DropDown(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    public void select(String text) {
        driver.findElement(By.xpath(String.format(DROP_DOWN_LOCATOR, label))).click();
        By item = By.xpath(String.format(ITEM_LOCATOR, text));
        new WebDriverWait(driver, Duration.of(10, SECONDS)).until(ExpectedConditions.visibilityOfElementLocated(item));
        driver.findElement(item).click();
    }
}
