package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {

    private final String pageAddress = "http://electonicstore.com/index.php?route=account/account";

    @FindBy(xpath = "//span[contains(text(), 'My Account')]")
    WebElement myAccount;
    //private By myAccount = By.xpath("//span[contains(text(), 'My Account')]");

    @FindBy(xpath = "//a[@href='http://electonicstore.com/index.php?route=account/logout']")
    WebElement logoutButton;
    //private By logoutButton = By.xpath("//a[@href='http://electonicstore.com/index.php?route=account/logout']");

    public static final String TEXT_LOCATOR_LOGOUT = "Account Logout";
    @FindBy(xpath = "//div[@id='content']/h1")
    WebElement logOutValue;
    //private By logOutValue = By.xpath("//div[@id='content']/h1");

    private WebDriver driver;

    public MyAccountPage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public MyAccountPage open() {
        driver.get(pageAddress);
        return this;
    }
    public MyAccountPage clickMyAccountButton() {
        //driver.findElement(myAccount).click();
        myAccount.click();
        return this;
    }

    public MyAccountPage clickLogoutButton() {
        //driver.findElement(logoutButton).click();
        logoutButton.click();
        return this;
    }

    public String getTitleLogoutValue() {
//        String titleLogoutTest = driver.findElement(logOutValue).getText();
        String titleLogoutTest = logOutValue.getText();
        return titleLogoutTest;
    }
}
