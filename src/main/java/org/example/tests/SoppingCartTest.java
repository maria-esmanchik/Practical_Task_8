package org.example.tests;

import org.example.data.Product;
import org.example.pages.MainFeaturedPage;
import org.example.service.ProductService;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.example.data.ProductFactory.getDescriptionValue;

public class SoppingCartTest {

    private static WebDriver driver = null;
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

    @Test(priority = 1)
    public void openDescriptionProductTest() {
        titleValue = ProductService.goToProductDescription(driver, getDescriptionValue()).getTitleDescriptionElement();
        Assert.assertEquals(titleValue, MainFeaturedPage.PAGE_DESCRIPTION_TEXT, "Intel Core 2 Duo processor");
    }

    @Test(priority = 2)
    public void addToListShoppingCart() {
        titleValue = String.valueOf(ProductService.checkShoppingCart(driver, getDescriptionValue()).getTitleAddToCartElement());
        Assert.assertEquals(titleValue, MainFeaturedPage.ALERT_ADD_TO_CART_TEXT, "Success: You have added MacBook to your shopping cart!" + "\n" + "×");
    }

    @Test(priority = 3)
    public void openShoppingCart() {
        titleValue = String.valueOf(ProductService.goToShoppingCart(driver, getDescriptionValue()).getTitleSoppingCart());
        Assert.assertEquals(titleValue, MainFeaturedPage.SOPPING_CART_TITLE, "Shopping Cart");
    }

    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }
}
