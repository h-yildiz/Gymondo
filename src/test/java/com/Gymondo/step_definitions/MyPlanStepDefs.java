package com.Gymondo.step_definitions;

import com.Gymondo.pages.BasePage;
import com.Gymondo.pages.LoginPage;
import com.Gymondo.pages.MyPlanPage;
import com.Gymondo.utilities.BrowserUtils;
import com.Gymondo.utilities.ConfigurationReader;
import com.Gymondo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Assert;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

public class MyPlanStepDefs {

    @Given("the user is logged in")
    public void the_user_is_logged_in() {
        new LoginPage().login();
    }

    @When("the user is on the {string} page")
    public void the_user_is_on_the_page(String expectedUrl) {
        String actualUrl = Driver.get().getCurrentUrl();
        Assert.assertEquals(ConfigurationReader.get("url") + BasePage.getUrl(expectedUrl), actualUrl);
    }

    @Then("the weekdays are displayed correctly")
    public void the_weekdays_are_displayed_correctly() {
        // creates days of the week in the format as in the website
        Calendar calendar = Calendar.getInstance();
        String[] days = new String[] { "Su", "Mo", "Tu", "We", "Th", "Fr", "Sa" };
        int today = calendar.get(Calendar.DAY_OF_WEEK)-1; // 1

        // separates the days before and after today and reformat them by replaying todays weekday name with "Today"
        String[] prevDays= Arrays.copyOfRange(days, 0, today);
        String[] nextDays = Arrays.copyOfRange(days, today, days.length);
        nextDays[0] = "Today";

        // merges the weekdays again as displayed in the website
        String[] expectedWeekdays = ArrayUtils.addAll(nextDays, prevDays);

        // Asserts if the actual list of the days in the website is as expected
        List<String> actualWeekdays = BrowserUtils.getElementsText(new MyPlanPage().weekdays);
        for (int i = 0; i < expectedWeekdays.length; i++) {
            Assert.assertEquals(actualWeekdays.get(i), expectedWeekdays[i]);
        }
    }

    @Then("the day number are displayed correctly")
    public void the_day_number_are_displayed_correctly() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
}
