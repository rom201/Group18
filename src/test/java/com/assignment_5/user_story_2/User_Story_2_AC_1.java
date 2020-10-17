package com.assignment_5.user_story_2;


import com.assignment_5.Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class User_Story_2_AC_1 {

    WebDriver driver;

    @BeforeMethod
    public void set_Up(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://login2.nextbasecrm.com/");
    }

    @Test
    public void us_2_AC_1_High_Priority() throws InterruptedException{
            // before method
        String helpDeskUserName = "Helpdesk18@cybertekschool.com";
        String pass = "UserUser";

        WebElement userLogin = driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
        userLogin.sendKeys(helpDeskUserName);
        WebElement password = driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        password.sendKeys(pass);
        WebElement loginSubmitBox = driver.findElement(By.xpath("//input[@class='login-btn']"));
        loginSubmitBox.click();
        Thread.sleep(1000);
           //click on Activity Stream button
        WebElement buttonActivityStream = driver.findElement(By.xpath("//a[@title='Activity Stream']/span[1]"));
        buttonActivityStream.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
           // click on Task tab
        WebElement taskTab = driver.findElement(By.xpath("//span[@id='feed-add-post-form-tab-tasks']"));
        taskTab.click();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

            //actual test

        //click on High priority check box
        WebElement checkBox_High_Priority = driver.findElement(By.xpath("//input[@id='tasks-task-priority-cb']"));
        checkBox_High_Priority.click();

        boolean actual = driver.findElement(By.xpath("//input[@id='tasks-task-priority-cb']")).isSelected();
        //boolean expected = true;

        Assert.assertTrue(actual);


    }

    @AfterMethod
    public void tearDown(){
        driver.close();
    }



}
