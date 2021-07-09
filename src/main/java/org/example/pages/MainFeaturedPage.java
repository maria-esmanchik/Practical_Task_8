package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainFeaturedPage {

    public static final String PAGE_DESCRIPTION_TEXT = "Intel Core 2 Duo processor";
    public static final String ALERT_ADD_TO_CART_TEXT = "Success: You have added MacBook to your shopping cart!" + "\n" + "×";
    public static final String SOPPING_CART_TITLE = "Shopping Cart";

    private static final String MAIN_FEATURED_PAGE = "http://electonicstore.com";

    @FindBy(xpath = "//*[@href='http://electonicstore.com/index.php?route=product/product&product_id=43']")
    WebElement productTitleButtonElement;
    @FindBy(xpath = "//*[contains(text(),'Intel Core 2 Duo processor')]")
    WebElement productDescriptionElement;
    @FindBy(xpath = "//*[@id='button-cart']")
    WebElement addToCartButton;
    @FindBy(xpath = "//*[@class='alert alert-success alert-dismissible']")
    WebElement addToCartAlert;
    @FindBy(xpath = "//*[@class='btn btn-inverse btn-block btn-lg dropdown-toggle']")
    WebElement toCart;
    @FindBy(xpath = "//*[@href='http://electonicstore.com/index.php?route=checkout/checkout']")
    WebElement viewCart;
    @FindBy(xpath = "//*[@id='content']/h1")
    WebElement soppingCartTitle;

    private WebDriver driver;
    public String titleSoppingTest = null;

    public MainFeaturedPage(WebDriver driver) {
        this.driver = driver;

        PageFactory.initElements(driver, this); //Initialise Elements
    }

    public MainFeaturedPage open() {
        driver.get(MAIN_FEATURED_PAGE);
        return this;
    }

    public MainFeaturedPage openDescriptionProduct() {
        productTitleButtonElement.click();
        return this;
    }

    public String getTitleDescriptionElement() {
        titleSoppingTest = productDescriptionElement.getText();
        return titleSoppingTest;
    }

    public MainFeaturedPage clickAddToCart() {
        addToCartButton.click();
        return this;
    }

    public String getTitleAddToCartElement() {
        titleSoppingTest = addToCartAlert.getText();
        return titleSoppingTest;
    }

    public MainFeaturedPage clickToCart() {
        toCart.click();
        return this;
    }

    public MainFeaturedPage clickViewCart() {
        viewCart.click();
        return this;
    }

    public String getTitleSoppingCart() {
        titleSoppingTest = soppingCartTitle.getText();
        return titleSoppingTest;
    }
}
