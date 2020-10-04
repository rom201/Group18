package com.assignment_5.user_story_1;

import com.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class User_Story_1_Test_Suit {
    WebDriver driver;

    @BeforeMethod
    public void set_Up(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://login2.nextbasecrm.com/");
    }



    @Test
    public void  User_Story_1_AC_6(){
        WebElement userName= driver.findElement(By.xpath("//input[@type='text']"));
        userName.sendKeys("helpdesk18@cybertekschool.com");
        WebElement passWord=driver.findElement(By.xpath("//input[@type='password']"));
        passWord.sendKeys("UserUser");
        WebElement logIn= driver.findElement(By.xpath("//input[@type='submit']"));
        logIn.click();

        WebElement messageBotton= driver.findElement(By.xpath("//span[.='Message']"));
        messageBotton.click();

        WebElement icon= driver.findElement(By.id("bx-b-mention-blogPostForm"));
        icon.click();

        WebElement user1=driver.findElement(By.xpath("//div[.='hr77@cybertekschool.com']"));
        user1.click();

        WebElement icon2= driver.findElement(By.id("bx-b-mention-blogPostForm"));
        icon2.click();

        WebElement user2=driver.findElement(By.xpath("//div[.='helpdesk27@cybertekschool.com']"));
        user2.click();











    }

    public void User_Story_1_AC_7(){
        //PRE-CONDITION
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement usernameBoxElement = driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
        usernameBoxElement.sendKeys("helpdesk18@cybertekschool.com");
        WebElement passwordBoxElement = driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        passwordBoxElement.sendKeys("UserUser");
        WebElement logInButtonElement = driver.findElement(By.xpath("//input[@type='submit']"));
        logInButtonElement.click();
        WebElement messageButtonElement = driver.findElement(By.xpath("//span[@class='feed-add-post-form-link feed-add-post-form-link-active']"));
        messageButtonElement.click();

        //TEST
        WebElement visualEditorButtonElement = driver.findElement(By.xpath("//span[@id='lhe_button_editor_blogPostForm']"));
        visualEditorButtonElement.click();

        WebElement editorTextBarElement = driver.findElement(By.xpath("//div[@class='bxhtmled-toolbar-cnt']"));
        Assert.assertTrue(editorTextBarElement.isDisplayed(),"Editor-text bar is not displayed. Test FAILED!!!");
    }

    @Test
    public void User_Story_1_AC_8(){
        //PRE-CONDITION
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement usernameBoxElement = driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
        usernameBoxElement.sendKeys("helpdesk18@cybertekschool.com");
        WebElement passwordBoxElement = driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        passwordBoxElement.sendKeys("UserUser");
        WebElement logInButtonElement = driver.findElement(By.xpath("//input[@type='submit']"));
        logInButtonElement.click();
        WebElement messageButtonElement = driver.findElement(By.xpath("//span[@class='feed-add-post-form-link feed-add-post-form-link-active']"));
        messageButtonElement.click();

        //TEST
        WebElement topicButtonElement = driver.findElement(By.xpath("//span[@onclick='showPanelTitle_blogPostForm(this);']"));
        topicButtonElement.click();

        WebElement topicTextBoxElement = driver.findElement(By.xpath("//div[@id='blog-title']"));
        Assert.assertTrue(topicTextBoxElement.isDisplayed(),"Topic text box is not displayed. Test FAILED!!!");

    }

    @Test
    public void User_Story_1_AC_2() throws InterruptedException {
        //BeforeMethod
        driver.findElement(By.name("USER_LOGIN")).sendKeys("helpdesk18@cybertekschool.com");
        driver.findElement(By.name("USER_PASSWORD")).sendKeys("UserUser"+ Keys.ENTER);

        //Click the "Message"
        driver.findElement(By.xpath("//span[@id='feed-add-post-form-tab-message']")).click();
        Thread.sleep(2000);

        //Click "To"
        driver.findElement(By.xpath("//div[@id='feed-add-post-destination-container']")).click();

        //Send email address as expectsResult
        WebElement toSendBox =driver.findElement(By.xpath("//input[@id='feed-add-post-destination-input']"));
        String expectsResult ="test123@gmail.com";
        toSendBox.sendKeys(Keys.BACK_SPACE+ expectsResult);
        Thread.sleep(5000);
        driver.findElement(By.xpath("//div[@id='feed-add-post-destination-container']")).click();

        //Verify test Pass or fail
        WebElement actuallyResults= driver.findElement(By.xpath("//span[@class='feed-add-post-destination-text']"));
        Assert.assertEquals(expectsResult,actuallyResults.getText());

    }

    @AfterMethod
    public void afterMethod(){
        driver.manage().window().maximize();
    }
}
