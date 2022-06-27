package com.Gymondo.pages;

import com.Gymondo.utilities.BrowserUtils;
import com.Gymondo.utilities.ConfigurationReader;
import com.Gymondo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public LoginPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(css = "input#mail")
    public WebElement emailInput;

    @FindBy(css = "input#password")
    public WebElement passwordInput;

    @FindBy(xpath = "(//div[@class=\"btn-gym__content\"])[2]")
    public WebElement loginButton;

    @FindBy(xpath = "(//div[@class=\"btn-gym__content\"])[1]")
    public WebElement innerLoginButton;

    /**
     * fills out login fields for a given user
     *
     * @param email
     * @param password
     */
    public void loginWith(String email, String password) {
        loginButton.click();
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        innerLoginButton.click();
    }

    /**
     * logs in the default user by going through all login steps
     */
    public void login() {
        String url = ConfigurationReader.get("url");
        Driver.get().get(url);
        new BasePage().acceptCookiesButton.click();

        String email = ConfigurationReader.get("email_address");
        String password = ConfigurationReader.get("password");

        loginButton.click();
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        innerLoginButton.click();

        WebElement modal = new BasePage().whatIsNewModal;
        BrowserUtils.waitForVisibility(modal, 5);
        modal.click();
    }
}
