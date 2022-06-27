package com.Gymondo.step_definitions;

import com.Gymondo.pages.BasePage;
import com.Gymondo.pages.LoginPage;
import com.Gymondo.utilities.BrowserUtils;
import com.Gymondo.utilities.ConfigurationReader;
import com.Gymondo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;



public class LoginStepDefs {

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        String url = ConfigurationReader.get("url");
        Driver.get().get(url);
        new BasePage().acceptCookiesButton.click();
    }

    @When("the user enters the credentials")
    public void the_user_enters_the_credentials() {
        String email = ConfigurationReader.get("email_address");
        String password = ConfigurationReader.get("password");

        LoginPage loginPage = new LoginPage();
        loginPage.loginWith(email,password);

        WebElement modal = new BasePage().whatIsNewModal;
        BrowserUtils.waitForVisibility(modal,5);
        modal.click();
    }

    @Then("the user should be logged in")
    public void the_user_should_be_logged_in() {
        new BasePage().myPlan.isDisplayed();
    }

}
