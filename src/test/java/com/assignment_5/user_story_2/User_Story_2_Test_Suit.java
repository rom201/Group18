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

public class User_Story_2_Test_Suit {
    WebDriver driver;

    @BeforeMethod
    public void set_Up(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://login2.nextbasecrm.com/");
    }

    @Test
    public void User_Story_2_AC_1(){

    }

    @Test
    public void User_Story_2_AC_2(){

    }

    @Test//US1_AC#5:  Users should be able to add mention by clicking on the Add mention icon and select contacts from the lists provided in dropdown.
    public void add_Mention() throws InterruptedException {

        //beforeMethod
        driver.findElement(By.name("USER_LOGIN")).sendKeys("helpdesk18@cybertekschool.com");
        driver.findElement(By.name("USER_PASSWORD")).sendKeys("UserUser"+ Keys.ENTER);
        //US#2 Only:
        driver.findElement(By.xpath("//span[.='Task']")).click();
        Thread.sleep(3000);

        //AC#5 Add mention icon and select contacts from the lists provided in dropdown
        driver.findElement(By.xpath("//div[@id='feed-add-post-content-tasks']//span[@title='Add mention']")).click();
        Thread.sleep(2000);
        WebElement mention = driver.findElement(By.xpath("//span[@class='bx-finder-groupbox-content']//a[8]"));//a[i] -->can be more
        String expectResult = mention.getText();
        System.out.println("expectResult = " + expectResult);

        mention.click();
        List<WebElement> ifram = driver.findElements(By.xpath("//iframe[@class='bx-editor-iframe']"));
        driver.switchTo().frame(1);
        String actuallyResult = driver.findElement(By.xpath("//span[@class='bxhtmled-metion']")).getText();
        driver.switchTo().parentFrame();

        Assert.assertEquals(expectResult,actuallyResult);
    }

    @Test//US1_AC#10:  Users should be able to add mention by clicking on the Add mention icon and select contacts from the lists provided in dropdown.
    public void is_More_Visible() throws InterruptedException {
        //beforeMethod
        driver.findElement(By.name("USER_LOGIN")).sendKeys("helpdesk18@cybertekschool.com");
        driver.findElement(By.name("USER_PASSWORD")).sendKeys("UserUser"+ Keys.ENTER);
        //US#2 Only:
        driver.findElement(By.xpath("//span[.='Task']")).click();
        Thread.sleep(3000);

        //AC#10
        //Click "More"
        driver.findElement(By.xpath("//div[@data-bx-id='task-edit-additional-header']")).click();

        WebElement isDisplay = driver.findElement(By.xpath("//div[@data-bx-id='task-edit-unchosen-blocks']"));
        System.out.println("isDisplay = " + isDisplay.isDisplayed());
        Assert.assertTrue(isDisplay.isDisplayed(),"its not visible");
    }


    @AfterMethod
    public void afterMethod(){
        driver.manage().window().maximize();
        driver.close();
    }
}
