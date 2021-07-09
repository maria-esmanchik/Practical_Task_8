package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {
    public static final String PAGE_TITLE_TEXT = "Your Account Has Been Created!";
    public static final String TEXT_INVALID_EMAIL = "Warning: E-Mail Address is already registered!";
    public static final String TEXT_CHECK_BOX = "Warning: You must agree to the Privacy Policy!";

    private final String REGISTRATION_PAGE_ADDRESS = "http://electonicstore.com/index.php?route=account/register";

    @FindBy(xpath = "//input[@name='firstname']")
    WebElement firstNameElement;
    @FindBy(xpath = "//input[@name='lastname']")
    WebElement lastNameElement;
    @FindBy(xpath = "//input[@name='email']")
    WebElement emailElement;
    @FindBy(xpath = "//input[@name='telephone']")
    WebElement telephoneElement;
    @FindBy(xpath = "//input[@name='password']")
    WebElement passwordElement;
    @FindBy(xpath = "//input[@name='confirm']")
    WebElement confirmPasswordElement;
    @FindBy(xpath = "//*[@name='newsletter']")
    WebElement newsletterSubscribeElement;
    @FindBy(xpath = "//input[@name='agree']")
    WebElement checkBoxPrivacyPolicyElement;
    @FindBy(xpath = "//input[@value='Continue']")
    WebElement continueElement;
    @FindBy(xpath = "//h1[contains(text(), 'Your Account Has Been Created!')]")
    WebElement pageTitleTextElement;
    @FindBy(xpath = "//*[contains(text(), 'Warning')]")
    WebElement invalidEmailTextElement;
    @FindBy(xpath = "//*[contains(text(), 'Warning')]")
    WebElement checkBoxTextElement;

    private WebDriver driver;
    public String titleRegistrationTest = null;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;

        PageFactory.initElements(driver, this); //Initialise Elements
    }

    public RegistrationPage open() {
        driver.get(REGISTRATION_PAGE_ADDRESS);
        return this;
    }

    public RegistrationPage inputFirstName(String firstName) {
        firstNameElement.clear();
        firstNameElement.sendKeys(firstName);
        return this;
    }

    public RegistrationPage inputLastName(String lastName) {
        lastNameElement.clear();
        lastNameElement.sendKeys(lastName);
        return this;
    }

    public RegistrationPage inputEmailValue(String email) {
        emailElement.clear();
        emailElement.sendKeys(email);
        return this;
    }

    public RegistrationPage inputTelephoneValue(String telephone) {
        telephoneElement.clear();
        telephoneElement.sendKeys(telephone);
        return this;
    }

    public RegistrationPage inputPasswordValue(String password) {
        passwordElement.clear();
        passwordElement.sendKeys(password);
        return this;
    }

    public RegistrationPage inputConfirmPasswordValue(String password) {
        confirmPasswordElement.clear();
        confirmPasswordElement.sendKeys(password);
        return this;
    }

    public RegistrationPage clickNewsletterSubscribeValue() {
        newsletterSubscribeElement.click();
        return this;
    }

    public RegistrationPage clickCheckBoxPrivacy() {
        checkBoxPrivacyPolicyElement.click();
        return this;
    }

    public RegistrationPage clickContinueButton() {
        continueElement.click();
        return this;
    }

    public String getTitleRegistrationValue() {
        titleRegistrationTest = pageTitleTextElement.getText();
        return titleRegistrationTest;
    }

    public String getTitleRegistrationInvalidEmailValue() {
        titleRegistrationTest = invalidEmailTextElement.getText();
        return titleRegistrationTest;
    }

    public String getTitleRegistrationCheckBoxValue() {
        titleRegistrationTest = checkBoxTextElement.getText();
        return titleRegistrationTest;
    }
}
