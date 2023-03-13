package by.teachmeskills;

import by.teachmeskills.dto.Account;
import by.teachmeskills.page.AccountDetailsPage;
import by.teachmeskills.page.AccountsPage;
import by.teachmeskills.page.LoginPage;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Log4j2
public class AccountCreationTest extends BaseTest {

    private Account expectedAccount;

    @BeforeClass
    public void generateUser() {
        expectedAccount = Account.builder()
                                 .accountName(faker.name().fullName())
                                 .type("Investor")
                                 .industry("Banking")
                                 .phone(faker.phoneNumber().cellPhone())
                                 .build();
    }

    @Test
    public void checkAccountCreation() {
        new LoginPage(driver).open()
                             .login()
                             .waitForPageOpening();
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
    public void deleteAccount() {
        new AccountsPage(driver).open()
                                .waitForPageOpening()
                                .deleteAccount(expectedAccount.getAccountName());
    }
}
