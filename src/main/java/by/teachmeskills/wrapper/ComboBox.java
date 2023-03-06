package by.teachmeskills.wrapper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ComboBox {

    private WebDriver driver;
    private WebDriverWait wait;
    private String label;

    public static final String COMBO_BOX_LOCATOR = "//label[text()='%s']//ancestor::lightning-grouped-combobox//input";
    public static final String ITEM_LOCATOR = "//li//span[@title='%s']";

    public ComboBox(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    public void select(String text) {
        driver.findElement(By.xpath(String.format(COMBO_BOX_LOCATOR, label))).click();
        By item = By.xpath(String.format(ITEM_LOCATOR, text));
        wait.until(ExpectedConditions.visibilityOfElementLocated(item));
        driver.findElement(item).click();
    }

    public void createNewContact() {
        select("New Account");
    }
}