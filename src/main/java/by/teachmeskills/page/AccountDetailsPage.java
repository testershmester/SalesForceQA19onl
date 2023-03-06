package by.teachmeskills.page;

import by.teachmeskills.BasePage;
import by.teachmeskills.dto.Account;
import by.teachmeskills.wrapper.FormattedText;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AccountDetailsPage extends BasePage {

    private final By accCreationToastMsgLocator = By.xpath("//span[contains(@class,'toastMessage')]");
    private final By accName = By.xpath("//span[text()='Account Name']//ancestor::flexipage-field//lightning-formatted-text");
    private final By phone = By.xpath("//span[text()='Phone']//ancestor::flexipage-field//a");

    public AccountDetailsPage(WebDriver driver) {
        super(driver);
    }

    public AccountDetailsPage waitForAccountCreationNotificationDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(accCreationToastMsgLocator));
        return this;
    }

    public WebElement getAccountCreationNotification() {
        return driver.findElement(accCreationToastMsgLocator);
    }

    public String getAccountInformation(String label) {
        return new FormattedText(driver, label).getText();
    }

    public Account getAccount() {
        String phone = driver.findElement(this.phone).getText();
        return new Account(getAccountInformation("Account Name"), getAccountInformation("Type"),
                           getAccountInformation("Industry"), phone);
    }
}
