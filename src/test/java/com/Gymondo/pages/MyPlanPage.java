package com.Gymondo.pages;

import com.Gymondo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MyPlanPage {

    public MyPlanPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(className = "calendar_dayName__0CSly")
    public List<WebElement> weekdays;
}
