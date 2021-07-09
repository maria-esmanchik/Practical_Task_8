package org.example.service;

import org.example.data.Product;
import org.example.pages.MainFeaturedPage;
import org.openqa.selenium.WebDriver;

public class ProductService {

    public static MainFeaturedPage goToProductDescription(WebDriver driver, Product product) {
        MainFeaturedPage mainFeaturedPage = new MainFeaturedPage(driver);
        mainFeaturedPage.open()
                .openDescriptionProduct()
                .getTitleDescriptionElement();
        return mainFeaturedPage;
    }

    public static MainFeaturedPage checkShoppingCart(WebDriver driver, Product product) {
        MainFeaturedPage mainFeaturedPage = new MainFeaturedPage(driver);
        mainFeaturedPage.open()
                .openDescriptionProduct()
                .clickAddToCart()
                .getTitleAddToCartElement();
        return mainFeaturedPage;
    }

    public static MainFeaturedPage goToShoppingCart(WebDriver driver, Product product) {
        MainFeaturedPage mainFeaturedPage = new MainFeaturedPage(driver);
        mainFeaturedPage.open()
                .clickToCart()
                .clickViewCart()
                .getTitleSoppingCart();
        return mainFeaturedPage;
    }
}
