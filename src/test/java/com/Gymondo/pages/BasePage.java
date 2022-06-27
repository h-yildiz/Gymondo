package com.Gymondo.pages;

import com.Gymondo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.HashMap;
import java.util.Map;

public class BasePage {

    public BasePage() {
        PageFactory.initElements(Driver.get(), this);
    }

    public static String getUrl(String url) {
        Map<String, String> navUrl = new HashMap<>();
        navUrl.put("My plan","/train/timeline");
        navUrl.put("Programs","/train/fitness/programs");
        navUrl.put("Workouts","/train/fitness/workouts");
        navUrl.put("Challenges","/train/fitness/challenges");
        navUrl.put("Recipes","/secure/#/recipes");
        navUrl.put("Nutrition","/secure/#/nutrition");
        navUrl.put("Progress","/train/progress");

        return navUrl.get(url);
    }

    @FindBy(xpath = "//*[@class=\"top-nav__list\"]//a[text()=\"My plan\"]")
    public WebElement myPlan;

    @FindBy(xpath = "//*[@class=\"top-nav__list\"]//a[text()=\"Programs\"]")
    public WebElement programsLink;

    @FindBy(xpath = "//*[@class=\"top-nav__list\"]//a[text()=\"Workouts\"]")
    public WebElement workoutsLink;

    @FindBy(xpath = "//*[@class=\"top-nav__list\"]//a[text()=\"Challenges\"]")
    public WebElement challengesLink;

    @FindBy(xpath = "//*[@class=\"top-nav__list\"]//a[text()=\"Recipes\"]")
    public WebElement recipesLink;

    @FindBy(xpath = "//*[@class=\"top-nav__list\"]//a[text()=\"Nutrition\"]")
    public WebElement nutritionLink;

    @FindBy(xpath = "//*[@class=\"top-nav__list\"]//a[text()=\"Progress\"]")
    public WebElement progressLink;

    @FindBy(xpath = "//button/div[ text() = \"Accept\"]")
    public WebElement acceptCookiesButton;

    @FindBy(className = "modal_closeIcon__ZIDaj")
    public WebElement whatIsNewModal;

    @FindBy(className = "modal_closeIcon__ZIDaj")
    public WebElement logout;

}
