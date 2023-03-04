package by.teachmeskills.wrapper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FormattedText {

    private WebDriver driver;
    private String label;

    public static final String TEXT_LOCATOR = "//span[text()='%s']//ancestor::flexipage-field//lightning-formatted-text";

    public FormattedText(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    public String getText() {
        return driver.findElement(By.xpath(String.format(TEXT_LOCATOR, label))).getText();
    }
}
