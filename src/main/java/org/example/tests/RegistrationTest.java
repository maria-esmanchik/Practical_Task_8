package org.example.tests;

import org.example.pages.RegistrationPage;
import org.example.service.AuthorizationService;
//import org.example.service.RegistrationService;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.example.data.AccountFactory.*;

public class RegistrationTest {
    private static WebDriver driver = null;

//    private final static String FIRST_NAME = "Mary";
//    private static String LAST_NAME = "Poppins";
//    private static String INVALID_EMAIL = "xzlk8@vmani.com";
//    private static String TELEPHONE = "2515643465";
//    private static String PASSWORD = "password123";
    private static long NUM = System.currentTimeMillis();
//    private static String EMAIL = "login@login" + NUM +".com";
    String titleValue = null;

    @BeforeMethod
    public void openBrowser() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--ignore-ssl-errors=yes");
        options.addArguments("--ignore-certificate-errors");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test()
    public void registrationToMailInvalidTest() {
        titleValue = AuthorizationService.registrationAccount(driver, getAccountForRegistrationInvalidEmail()).getTitleRegistrationInvalidEmailValue();

        Assert.assertEquals(titleValue, RegistrationPage.TEXT_INVALID_EMAIL, "Testing of logging with valid data is failed");
    }

    @Test()
    public void registrationToMailTest() {
        titleValue = AuthorizationService.registrationAccount(driver, getAccountForRegistration()).getTitleRegistrationValue();

        Assert.assertEquals(titleValue, RegistrationPage.PAGE_TITLE_TEXT, "Testing of logging with valid data is failed");
    }

    @Test()
    public void registrationToMailCheckBoxTest() {
        titleValue = AuthorizationService.registrationCheckBoxAccount(driver, getAccountForRegistration()).getTitleRegistrationCheckBoxValue();

        Assert.assertEquals(titleValue, RegistrationPage.TEXT_CHECK_BOX, "Testing of logging with valid data is failed");
    }

    @AfterMethod
    public void closeBrowser() {

        driver.quit();
    }
}
