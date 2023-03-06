package by.teachmeskills.page;

import by.teachmeskills.BasePage;
import by.teachmeskills.util.PropertiesLoader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Properties;

public class LoginPage extends BasePage {

    @FindBy(id = "username")
    private WebElement username;
    @FindBy(id = "password")
    private WebElement password;
    @FindBy(id = "Login")
    private WebElement loginButton;

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public LoginPage open() {
        Properties properties = PropertiesLoader.loadProperties();
        driver.get(properties.getProperty("base.url"));
        waitForPageLoaded();
        return this;
    }

    @Override
    protected LoginPage waitForPageOpening() {
        return null;
    }

    public HomePage login() {
        Properties properties = PropertiesLoader.loadProperties();
        username.sendKeys(properties.getProperty("username"));
        password.sendKeys(properties.getProperty("password"));
        loginButton.click();
        return new HomePage(driver);
    }
}
