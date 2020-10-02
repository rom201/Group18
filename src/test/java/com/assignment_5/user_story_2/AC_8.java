package com.assignment_5.user_story_2;

import com.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class AC_8   {

    WebDriver driver;

    @BeforeMethod
    public void set_Up(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://login2.nextbasecrm.com/");
        driver.findElement(By.name("USER_LOGIN")).sendKeys("helpdesk18@cybertekschool.com");
        driver.findElement(By.name("USER_PASSWORD")).sendKeys("UserUser"+ Keys.ENTER);
        driver.findElement(By.xpath("//span[.='Task']")).click();
    }

    @Test
    public void tasks () throws InterruptedException {
         Thread.sleep( 2000);
         driver.findElement(By.xpath("//span[@id='feed-add-post-form-tab-tasks']")).click();

         WebElement name = driver.findElement(By.xpath("//input[@name='ACTION[0][ARGUMENTS][data][TITLE]']"));
         name.sendKeys("Tasks for Employees");

         driver.findElement(By.xpath("//span[@data-target='accomplice']")).click();
         driver.findElement(By.xpath("//*[@id='bx-component-scope-lifefeed_task_form-accomplice']/span[2]/a[2]")).click();
         List <WebElement> Participants =  driver.findElements(By.xpath("//div[@class='bx-finder-box-item-t7-name']"));
         for (WebElement each : Participants) {
            each.click();
         }
        driver.findElement(By.xpath("//*[@id='BXSocNetLogDestination']/span")).click();

        driver.findElement(By.xpath("//span[@data-target='auditor']")).click();
        driver.findElement(By.xpath("//*[@id='bx-component-scope-lifefeed_task_form-auditor']/span[2]/a[2]")).click();
        List <WebElement> Observers =  driver.findElements(By.xpath("//div[@class='bx-finder-box-item-t7-name']"));
        for (WebElement each : Observers) {
            each.click();
        }
        driver.findElement(By.xpath("//*[@id='BXSocNetLogDestination']/span")).click();

        driver.findElement(By.xpath("//button[@id='blog-submit-button-save']")).click();
        Thread.sleep( 2000);
        String expectResult = "Tasks for Employees";

        String actuallyResult =  driver.findElement(By.xpath("//div[@id='log_internal_container']")).getText();
        Assert.assertTrue(actuallyResult.contains(expectResult));

        // Second way
        //driver.findElement(By.linkText("Tasks")).click();
        //String actuallyResult2 = driver.findElement(By.xpath("//table[@class='main-grid-table']")).getText();
        //Assert.assertTrue(actuallyResult2.contains(expectResult));

        }

    @AfterMethod
    public void afterMethod(){
       driver.close();
    }


}
