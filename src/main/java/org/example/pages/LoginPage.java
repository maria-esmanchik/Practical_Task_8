package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.example.data.AccountFactory.getAccountForLogin;

public class LoginPage {

    public static final String PAGE_TITLE_TEXT = "My Account";
    public static final String TEXT_LOCATOR_INVALID_PASSWORD = "Warning: No match for E-Mail Address and/or Password.";

    private final String LOGIN_PAGE_ADDRESS = "http://electonicstore.com/index.php?route=account/login";

    @FindBy(xpath = "//input[@id='input-email']")
    WebElement emailElement;
    //private By emailElement = By.xpath("//input[@id='input-email']");

    @FindBy(xpath = "//input[@id='input-password']")
    WebElement passwordElement;
    //private By passwordElement = By.xpath("//input[@id='input-password']");

    @FindBy(xpath = "//input[@value='Login']")
    WebElement loginButton;
    //private By loginButton = By.xpath("//input[@value='Login']");

    @FindBy(xpath = "//h2[contains(text(), 'My Account')]")
    WebElement myAccount;
    //private By myAccount = By.xpath("//h2[contains(text(), 'My Account')]");

    @FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
    WebElement invalidPassword;
    //private By invalidPassword = By.xpath("//div[@class='alert alert-danger alert-dismissible']");

    private WebDriver driver;
    public String titleLoginTest = null;

    public LoginPage(WebDriver driver) {
        this.driver = driver;

        PageFactory.initElements(driver, this); //Initialise Elements
    }

    public LoginPage open() {
        driver.get(LOGIN_PAGE_ADDRESS);
        return this;
    }

    public LoginPage inputPasswordValue(String password) {
        //driver.findElement(passwordElement).sendKeys(password);
        passwordElement.clear();
        passwordElement.sendKeys(password);
        return this;
    }

    public LoginPage inputEmailValue(String email) {
        //driver.findElement(emailElement).sendKeys(email);
        emailElement.clear();
        emailElement.sendKeys(email);
        return this;
    }

    public LoginPage clickLoginButton() {
        getAccountForLogin();
        //driver.findElement(loginButton).click();
        loginButton.click();
        return this;
    }

    public String getTitleLoginValue() {
        //titleLoginTest = driver.findElement(myAccount).getText();
        titleLoginTest = myAccount.getText();
        return titleLoginTest;
    }

    public String getTitleInvalidPasswordValue() {
        //titleLoginTest = driver.findElement(invalidPassword).getText();
        titleLoginTest = invalidPassword.getText();
        return titleLoginTest;
    }
}
