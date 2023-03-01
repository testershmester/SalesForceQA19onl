package by.teachmeskills.wrapper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Input {

    private WebDriver driver;
    private String inputLabel;
    private String infoBlockLabel;

    private static final String INPUT_LOCATOR = "//label[text()='%s']//ancestor::lightning-input//input";
    private static final String INPUT_LOCATOR_IN_INFO_BLOCK = "//span[text()='%s']//ancestor::flexipage-field-section2" +
            INPUT_LOCATOR;

    public Input(WebDriver driver, String inputLabel) {
        this.driver = driver;
        this.inputLabel = inputLabel;
    }

    public Input(WebDriver driver, String infoBlockLabel, String inputLabel) {
        this.driver = driver;
        this.inputLabel = inputLabel;
        this.infoBlockLabel = infoBlockLabel;
    }

    public void fillIn(String value) {
        if (this.infoBlockLabel != null) {
            driver.findElement(By.xpath(String.format(INPUT_LOCATOR_IN_INFO_BLOCK, infoBlockLabel, inputLabel)))
                  .sendKeys(value);
        } else {
            driver.findElement(By.xpath(String.format(INPUT_LOCATOR, inputLabel))).sendKeys(value);
        }
    }
}
