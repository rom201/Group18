package com.assignment_5.user_story_2;

import com.assignment_5.Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class User_Story_2_AC_10 {
    WebDriver driver;

    @BeforeMethod
    public void set_Up(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://login2.nextbasecrm.com/");
        driver.findElement(By.name("USER_LOGIN")).sendKeys("helpdesk18@cybertekschool.com");
        driver.findElement(By.name("USER_PASSWORD")).sendKeys("UserUser"+ Keys.ENTER);
        driver.findElement(By.xpath("//span[.='Task']")).click();
    }

    @Test//US1_AC#10:  Users should be able to add mention by clicking on the Add mention icon and select contacts from the lists provided in dropdown.
    public void add_Mention() throws InterruptedException {
        //Click "More"
        driver.findElement(By.xpath("//div[@data-bx-id='task-edit-additional-header']")).click();

        WebElement isDisplay = driver.findElement(By.xpath("//div[@data-bx-id='task-edit-unchosen-blocks']"));
        System.out.println("isDisplay = " + isDisplay.isDisplayed());
        Assert.assertTrue(isDisplay.isDisplayed(),"its not visible");
    }

    @AfterMethod
    public void afterMethod(){
        driver.manage().window().maximize();
        //driver.close();
    }

}
