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

    @Test//1.	Users should be able to click on the upload files icon to upload files and images from local disks.
    public void User_Story_1_AC_1() throws InterruptedException {

        WebElement Message = driver.findElement(By.xpath("//span[.='Message']"));
        Message.click();
        Thread.sleep(1000);

        WebElement uploadFile = driver.findElement(By.id("bx-b-uploadfile-blogPostForm"));
        uploadFile.click();

        WebElement uploadFileAndImages = driver.findElement(By.xpath("//div[@class='diskuf-uploader']"));
        //uploadFileAndImages.sendKeys("C:Users\\Resho\\Desktop\\Automation Task Photo\\Task5.4.jpg");
        uploadFileAndImages.click();
        Thread.sleep(3000);


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
    public void User_Story_1_AC_3() throws InterruptedException {



        Thread.sleep(3000);
        driver.findElement(By.xpath("//span[@id='feed-add-post-form-tab-message'] ")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//span[@title='Link'] ")).click();


        String expectedText="Cybertek School";//expected
        String email2="https://www.cybertekschool.com/";

        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@id='linkidPostFormLHE_blogPostForm-text'] ")).sendKeys(expectedText);
        driver.findElement(By.xpath("//input[@id='linkidPostFormLHE_blogPostForm-href'] ")).sendKeys(email2);
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@id='undefined'] ")).click();

        Thread.sleep(3000);



        driver.switchTo().frame(0);
        String actuallyResult = driver.findElement(By.xpath("//a[.='"+expectedText+"']")).getText();
        driver.switchTo().parentFrame();

        Assert.assertEquals(expectedText,actuallyResult);



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
    public void  User_Story_1_AC_6() throws InterruptedException {
        Thread.sleep(3000);
        WebElement messageBotton= driver.findElement(By.xpath("//span[.='Message']"));
        messageBotton.click();
        Thread.sleep(1000);
        WebElement icon= driver.findElement(By.id("bx-b-mention-blogPostForm"));
        icon.click();
        Thread.sleep(1000);
        WebElement user1=driver.findElement(By.xpath("//div[.='hr77@cybertekschool.com']"));
        user1.click();
        Thread.sleep(1000);
        WebElement icon2= driver.findElement(By.id("bx-b-mention-blogPostForm"));
        icon2.click();
        Thread.sleep(1000);
        WebElement user2=driver.findElement(By.xpath("//div[.='helpdesk27@cybertekschool.com']"));
        user2.click();

    }

    @Test
    public void User_Story_1_AC_7(){
        //PRE-CONDITION

        //WebElement logInButtonElement = driver.findElement(By.xpath("//input[@type='submit']"));
        //logInButtonElement.click();
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

        // WebElement logInButtonElement = driver.findElement(By.xpath("//input[@type='submit']"));
        //logInButtonElement.click();
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


        driver.close();

    }
}
