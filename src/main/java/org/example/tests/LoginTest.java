package org.example.tests;

import org.example.pages.LoginPage;
import org.example.pages.MyAccountPage;
import org.example.service.AuthorizationService;
//import org.example.service.LoginService;
//import org.example.service.LogoutService;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

import static org.example.data.AccountFactory.getAccountForLogin;
import static org.example.data.AccountFactory.getAccountForLoginInvalidPassword;


public class LoginTest {
    private static WebDriver driver = null;

//    private final String EMAIL = "login@login.com";
//    private final String PASSWORD = "password123";
//    private final String INVALID_PASSWORD = "123";
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
    public void loginToMailTest() {
        titleValue = AuthorizationService.loginAccount(driver, getAccountForLogin()).getTitleLoginValue();

        Assert.assertEquals(titleValue, LoginPage.PAGE_TITLE_TEXT, "Testing of logging with valid data is failed");
    }

    @Test()
    public void loginToMailLogOutTest() {
        AuthorizationService.loginAccount(driver, getAccountForLogin());
        titleValue = AuthorizationService.logoutAccount(driver).getTitleLogoutValue();

        Assert.assertEquals(titleValue, MyAccountPage.TEXT_LOCATOR_LOGOUT, "Testing of logging with valid data is failed");
    }

    @Test()
    public void loginToMailInvalidTest() {
        titleValue = AuthorizationService.loginAccount(driver, getAccountForLoginInvalidPassword()).getTitleInvalidPasswordValue();

        Assert.assertEquals(titleValue, LoginPage.TEXT_LOCATOR_INVALID_PASSWORD, "Testing of logging with valid data is failed");
    }

    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }
}
