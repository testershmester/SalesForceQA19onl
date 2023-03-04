package by.teachmeskills.page;

import by.teachmeskills.BasePage;
import by.teachmeskills.wrapper.DropDown;
import by.teachmeskills.wrapper.Input;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NewAccountModalPage extends BasePage {

    public static final By SAVE_BUTTON = By.xpath("//button[@name='SaveEdit']");
    public static final By CANCEL = By.xpath("//button[@name='Cancel']");
    public static final By SAVE_AND_NEW_BUTTON = By.xpath("//button[@name='Save & New']");

    public NewAccountModalPage(WebDriver driver) {
        super(driver);
    }

    public AccountDetailsPage createNewAccount(String accountName, String type, String industry, String phone) {
        new Input(driver, "Account Name").fillIn(accountName);
        new Input(driver, "Account Information", "Phone").fillIn(phone);
        new DropDown(driver, "Type").select(type);
        new DropDown(driver, "Industry").select(industry);
        driver.findElement(SAVE_BUTTON).click();
        return new AccountDetailsPage(driver);
    }
}
