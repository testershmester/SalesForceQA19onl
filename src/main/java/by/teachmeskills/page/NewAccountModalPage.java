package by.teachmeskills.page;

import by.teachmeskills.BasePage;
import by.teachmeskills.dto.Account;
import by.teachmeskills.wrapper.DropDown;
import by.teachmeskills.wrapper.Input;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class NewAccountModalPage extends BasePage {

    public static final By SAVE_BUTTON = By.xpath("//button[@name='SaveEdit']");
    public static final By CANCEL = By.xpath("//button[@name='Cancel']");
    public static final By SAVE_AND_NEW_BUTTON = By.xpath("//button[@name='Save & New']");

    public NewAccountModalPage(WebDriver driver) {
        super(driver);
    }

    public AccountDetailsPage createNewAccount(Account account) {
        new Input(driver, "Account Name").fillIn(account.getAccountName());
        new Input(driver, "Account Information", "Phone").fillIn(account.getPhone());
        new DropDown(driver, "Type").select(account.getType());
        new DropDown(driver, "Industry").select(account.getIndustry());
        driver.findElement(SAVE_BUTTON).click();
        log.info("Account {} has been created", account.getAccountName());
        return new AccountDetailsPage(driver);
    }
}
