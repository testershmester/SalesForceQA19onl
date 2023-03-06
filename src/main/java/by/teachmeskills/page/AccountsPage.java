package by.teachmeskills.page;

import by.teachmeskills.BasePage;
import by.teachmeskills.util.PropertiesLoader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Properties;

public class AccountsPage extends BasePage {

    public static final String ACCOUNTS_PAGE_PATH = "/lightning/o/Account/list?filterName=Recent";

    private By ACCOUNTS_TITLE_LOCATOR = By.xpath("//span[text()='Accounts' and @class='slds-var-p-right_x-small']");
    private By NEW_BTN_LOCATOR = By.xpath("//div[@title='New']");

    public AccountsPage(WebDriver driver) {
        super(driver);
    }

    public AccountsPage open() {
        Properties properties = PropertiesLoader.loadProperties();
        driver.get(properties.getProperty("base.url") + ACCOUNTS_PAGE_PATH);
        waitForPageLoaded();
        return this;
    }

    public AccountsPage waitForPageOpening() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(ACCOUNTS_TITLE_LOCATOR));
        return this;
    }

    public NewAccountModalPage clickNewButton() {
        driver.findElement(NEW_BTN_LOCATOR).click();
        return new NewAccountModalPage(driver);
    }
}
