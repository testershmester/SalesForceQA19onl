package by.teachmeskills;

import by.teachmeskills.dto.Account;
import by.teachmeskills.page.AccountDetailsPage;
import by.teachmeskills.page.AccountsPage;
import by.teachmeskills.page.LoginPage;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AccountCreationTest extends BaseTest {

    private Account expectedAccount;

    @BeforeClass
    public void generateUser() {
        expectedAccount = new Account(faker.name().fullName(), "Investor", "Banking",
                                      faker.phoneNumber().cellPhone());
    }

    @Test
    public void checkAccountCreation() {
        new LoginPage(driver).open().login().waitForPageOpening();
        AccountDetailsPage accDetailsPage = new AccountsPage(driver).open()
                                                                    .waitForPageOpening()
                                                                    .clickNewButton()
                                                                    .createNewAccount(expectedAccount)
                                                                    .waitForAccountCreationNotificationDisplayed();
        //Notification
        WebElement accountCreationNotification = accDetailsPage.getAccountCreationNotification();
        assertThat(accountCreationNotification.isDisplayed()).as("Notification message should be shown after " + "account was created");

        String message = accountCreationNotification.getText();
        assertThat(message).as("Notification does not contain account name").contains(expectedAccount.getAccountName());

        //Account validation
        Account actualAccount = accDetailsPage.getAccount();
        assertThat(actualAccount).as("Account name is invalid").isEqualTo(expectedAccount);
    }

    @AfterClass
    public void deleteUser() {
        //TODO delete user after test
    }
}
