package by.teachmeskills;

import by.teachmeskills.page.AccountsPage;
import by.teachmeskills.page.LoginPage;
import by.teachmeskills.wrapper.Input;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class AccountCreationTest extends BaseTest {

    @Test
    public void checkAccountCreation() {
        new LoginPage(driver).open()
                             .login()
                             .waitForPageOpening();
        new AccountsPage(driver).open()
                                .waitForPageOpening()
                                .createNewAccount();


        new Input(driver, "Account Name").fillIn(new Faker().name().fullName());
        new Input(driver, "Account Information", "Phone").fillIn(new Faker().phoneNumber().cellPhone());
        new Input(driver, "Website").fillIn(new Faker().internet().domainName());
        new Input(driver, "Employees").fillIn("5");

        driver.findElement(By.xpath(" //button[@name='SaveEdit']")).click();

        System.out.println();
    }
}
