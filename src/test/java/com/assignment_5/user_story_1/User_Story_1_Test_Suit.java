package com.assignment_5.user_story_1;

import com.assignment_5.Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class User_Story_1_Test_Suit {
    WebDriver driver;

    @BeforeMethod
    public void set_Up(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://login2.nextbasecrm.com/");
        driver.findElement(By.xpath("//input[@name='USER_LOGIN']")).sendKeys("helpdesk18@cybertekschool.com");
        driver.findElement(By.xpath("//input[@name = 'USER_PASSWORD']")).sendKeys("UserUser"+ Keys.ENTER);
    }

    @Test
    public void User_Story_1_AC_2() throws InterruptedException {
        //BeforeMethod


        //Click the "Message"
        driver.findElement(By.xpath("//span[@id='feed-add-post-form-tab-message']")).click();
        Thread.sleep(2000);

        //Click "To"
        driver.findElement(By.xpath("//div[@id='feed-add-post-destination-container']")).click();

        //delete exist text or emall
        WebElement toSendBox =driver.findElement(By.xpath("//input[@id='feed-add-post-destination-input']"));
        toSendBox.sendKeys(Keys.BACK_SPACE);

        //Click one of the email in the list
        WebElement expectsResult = driver.findElement(By.xpath("//span[@class='bx-finder-groupbox false']//a[3]"));//a[x]: x>=1, x<=12
        expectsResult.click();

        //Verify test Pass or fail
        WebElement actuallyResults= driver.findElement(By.xpath("//span[@class='feed-add-post-destination-text']"));
        Assert.assertEquals(expectsResult.getText(),actuallyResults.getText());
    }

    @Test
    public void User_Story_1_AC_4() throws InterruptedException {

        WebElement message = driver.findElement(By.xpath("//span[@id='feed-add-post-form-tab-message']"));
        message.click();
        Thread.sleep(1000);
        WebElement insertVideo = driver.findElement(By.xpath("//span[@title='Insert video']"));
        insertVideo.click();
        Thread.sleep(1000);
        WebElement videoSource = driver.findElement(By.xpath("//input[@placeholder='YouTube or Vimeo video URL']"));

        Thread.sleep(1000);
        videoSource.sendKeys("https://youtu.be/N-8QUdOdXls");

        Thread.sleep(3000);
        WebElement save = driver.findElement(By.xpath("//input[@value='Save']"));
        Thread.sleep(3000);
        save.click();
        WebElement messagesend = driver.findElement(By.xpath("//button[@id='blog-submit-button-save']"));
        Thread.sleep(3000);
        messagesend.click();

    }

    @Test
    public void User_Story_1_AC_7(){
        //PRE-CONDITION

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
    public void User_Story_1_AC_9(){
    WebElement recordButton = driver.findElement(By.xpath("//span[@class='feed-add-post-form-but-cnt feed-add-videomessage']"));
            recordButton.click();

    WebElement deviceAccess = driver.findElement(By.xpath("//div[@class='popup-window-buttons']//span[@class='popup-window-button popup-window-button-blue']"));
            deviceAccess.click();

    WebElement resultText = driver.findElement(By.xpath("//span[@class='popup-window-button popup-window-button-blue']"));
            Assert.assertTrue(resultText.isDisplayed(),"Result text is not dispalyed.Verification FAILED!!");

    WebElement errorText = driver.findElement(By.xpath("//span[@class='popup-window-button popup-window-button-blue']"));

            Assert.assertTrue(errorText.isDisplayed(),"Error text is not displayed.Verification Failed!!!");

            errorText.click();
}

    @AfterMethod
    public void afterMethod(){
        driver.manage().window().maximize();
    }
}
