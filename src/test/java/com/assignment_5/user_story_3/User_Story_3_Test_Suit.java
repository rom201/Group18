package com.assignment_5.user_story_3;

import com.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class User_Story_3_Test_Suit {
    WebDriver driver;

    @BeforeMethod
    public void set_Up(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://login2.nextbasecrm.com/");
    }

    @Test
    public void User_Story_3_AC_1(){

    }

    @Test
    public void User_Story_3_AC_2(){

    }

    @AfterMethod
    public void afterMethod(){
        driver.manage().window().maximize();
    }
}
