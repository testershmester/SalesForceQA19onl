package by.teachmeskills;

import by.teachmeskills.page.AccountDetailsPage;
import by.teachmeskills.page.AccountsPage;
import by.teachmeskills.page.LoginPage;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AccountCreationTest extends BaseTest {

    @Test
    public void checkAccountCreation() {
        new LoginPage(driver).open()
                             .login()
                             .waitForPageOpening();
        String accountName = faker.name().fullName();
        AccountDetailsPage accDetailsPage = new AccountsPage(driver).open()
                                                                    .waitForPageOpening()
                                                                    .createNewAccount()
                                                                    .createNewAccount(accountName,
                                                                                      "Investor",
                                                                                      "Banking",
                                                                                      faker.phoneNumber().cellPhone())
                                                                    .waitForAccountCreationNotificationDisplayed();
        WebElement accountCreationNotification = accDetailsPage.getAccountCreationNotification();
        assertThat(accountCreationNotification.isDisplayed()).as("Notification message should be shown after " +
                                                                         "account was created");

        String message = accountCreationNotification.getText();
        assertThat(message).as("Notification does not contain account name")
                           .contains(accountName);
        assertThat(accDetailsPage.getAccountInformation("Account Name")).as("Account name is invalid")
                                                                        .isEqualTo(accountName);
        assertThat(accDetailsPage.getAccountInformation("Type")).as("Type is invalid")
                                                                .isEqualTo("Investor");
    }
}
