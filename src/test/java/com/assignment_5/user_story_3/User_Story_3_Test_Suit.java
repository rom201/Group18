package com.assignment_5.user_story_3;

import com.assignment_5.Utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class User_Story_3_Test_Suit {
    WebDriver driver;

    @BeforeMethod
    public void set_Up(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://login2.nextbasecrm.com/");
        driver.manage().window().maximize();
    }

    @Test
    public void User_Story_3_AC_2(){
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
        WebElement linkButton = driver.findElement(By.xpath("//span[@class='bxhtmled-top-bar-btn bxhtmled-button-link']"));
        linkButton.click();


        // 1ST ASSERTION CHECKING IF LINK BUTTON BRINGS UP THE LINK BOX
        WebElement linkBox = driver.findElement(By.xpath("//div[@class='bx-core-window bx-core-adm-dialog']"));
        Assert.assertTrue(linkBox.isDisplayed(),"Link box is not displayed. Test FAILED!!!");

        // 2ND ASSERTION VERIFYING IF AFTER PROVIDING THE INFO AND CLICKING SAVE LINK IS POSTED INTO MESSAGE BOX
        WebElement inputTextBox = driver.findElement(By.xpath("//input[@id='linkidPostFormLHE_blogPostForm-text']"));
        inputTextBox.sendKeys("Gherkin Language Best Practices");

        WebElement inputLinkBox = driver.findElement(By.xpath("//input[@id='linkidPostFormLHE_blogPostForm-href']"));
        inputLinkBox.sendKeys("https://www.youtube.com/watch?v=nrggIRWK6qo");

        WebElement saveButton = driver.findElement(By.xpath("//input[@class='adm-btn-save']"));
        saveButton.click();

        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='bx-editor-iframe']")));

        WebElement textLinkElement = driver.findElement(By.xpath("//a[.='Gherkin Language Best Practices']"));
        Assert.assertTrue(textLinkElement.isDisplayed(),"Text link is not displayed. Test FAILED!!!");

        // 3RD ASSERTION VERIFYING THAT AFTER CLICKING SEND BUTTON LINK HAS BEEN POSTED ON ACTIVITY STREAM
        driver.switchTo().defaultContent();
        WebElement sendButton = driver.findElement(By.xpath("//button[@id='blog-submit-button-save']"));
        sendButton.click();

        WebElement postOnPage = driver.findElement(By.xpath("//div[.='Gherkin Language Best Practices']"));
        Assert.assertTrue(postOnPage.isDisplayed(),"Link is not displayed on the page. Test FAILED!!!");

        //4TH ASSERTION AFTER CLICKING USER SHOULD BE REDIRECTED TO THE POSTED LINK
        postOnPage.click();
        Set<String> windowHandles = driver.getWindowHandles();
        for (String eachHandle : windowHandles) {
            if (driver.switchTo().window(eachHandle).getTitle().equals("Gherkin Best Practices - YouTube")){
                driver.switchTo().window(eachHandle);
                break;
            }
        }

        String expectedTitle = "Gherkin Best Practices - YouTube";
        String actualTitle = driver.getTitle();

        Assert.assertEquals(expectedTitle,actualTitle,"Actual title doesn't match the expected. Test FAILED!!!");

        // NOT PART OF THE TEST, JUST DELETING THE POST THAT HAS BEEN POSTED
        // THIS STEP IS NEEDED IN ORDER TO RUN THE TEST AGAIN, BECAUSE SAME POST CANNOT BE DONE MORE THAN ONCE

        for (String eachHandle : windowHandles) {
            if (driver.switchTo().window(eachHandle).getTitle().equals("(3) Portal")){
                driver.switchTo().window(eachHandle);
                break;
            }
        }

        WebElement moreDropdownMenu = driver.findElement(By.xpath("//a[contains(@id,'feed-post-menuanchor')]"));
        moreDropdownMenu.click();
        WebElement deleteButtonFromMoreDropdown = driver.findElement(By.xpath("//div[@class='menu-popup-items']//span[5]"));
        deleteButtonFromMoreDropdown.click();

        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    @Test
    public void User_Story_3_AC_4_quote() throws InterruptedException {

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
        // click on Event tab
        WebElement eventTab = driver.findElement(By.xpath("//span[@id='feed-add-post-form-tab-calendar']"));
        eventTab.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // actual test
        //click on quote icon
        WebElement quoteIcon = driver.findElement(By.xpath("//span[@id='bx-b-quote-blogPostForm_calendar']/span"));
        quoteIcon.click();
        // switch to iframe
        WebDriver iframe = driver.switchTo().frame(1);
        //find element in the text message box
        WebElement quote = driver.findElement(By.xpath("//blockquote[@class='bxhtmled-quote']"));
        boolean actualResult = quote.isDisplayed();
        // verify element is displayed
        Assert.assertTrue(actualResult);
    }

    @Test
    public void User_Story_3_AC_10() throws InterruptedException {
        driver.get("https://login2.nextbasecrm.com/?login=yes");
        driver.findElement(By.xpath("//input[@name='USER_LOGIN']")).sendKeys("helpdesk18@cybertekschool.com");
        driver.findElement(By.xpath("//input[@name='USER_PASSWORD']")).sendKeys("UserUser");
        driver.findElement(By.xpath("//input[@value='Log In']")).click();


        WebElement More = driver.findElement(By.xpath("//span[.='More']"));
        More.click();
        Thread.sleep(2000);

        WebElement file = driver.findElement(By.xpath("//span[.='File']"));
        file.click();

        WebElement selectDocument = driver.findElement(By.xpath("//span[.='Select document from Bitrix24']"));
        selectDocument.click();
        Thread.sleep(2000);
        WebElement cancel = driver.findElement(By.xpath("//div[@class='popup-window-buttons']//span[2]"));
        cancel.click();

        // WebElement photo = driver.findElement(By.xpath("//div[@class='bx-file-dialog-content-wrap']//span[1]"));
        //  photo.click();

        //  driver.findElement(By.xpath("//span[.='Select document']")).click();

        //  WebElement send = driver.findElement(By.id("blog-submit-button-save"));
        //  send.click();
        /*
try {
    WebElement more2 = driver.findElement(By.xpath("//span[@class='feed-post-more-text'][1]"));
    more2.click();
    Thread.sleep(2000);
    WebElement delete = driver.findElement(By.xpath("//div[@class='menu-popup']//span[5]//span[2]"));
    delete.click();

    Alert alert = driver.switchTo().alert();
    alert.accept();
}catch (RuntimeException e){

}

         */

        Thread.sleep(2000);

        driver.findElement(By.xpath("//span[.='File']")).click();
        Thread.sleep(2000);
        WebElement appreciation = driver.findElement(By.xpath("//span[.='Appreciation']"));
        appreciation.click();

        Thread.sleep(2000);

        //  driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='bx-editor-iframe']")));

//WebElement text  = driver.findElement(By.xpath("//body[@contenteditable='true']"));

//text.sendKeys("Test");



//WebElement saveButton  =driver.findElement(By.xpath("//div[@class='feed-buttons-block']//button[2]"));
//saveButton.click();

        WebElement AppreciationClick = driver.findElement(By.xpath("//span[.='Appreciation']"));
        AppreciationClick.click();
        Thread.sleep(2000);
        WebElement Announcement = driver.findElement(By.xpath("//span[.='Announcement']"));
        Announcement.click();
        Thread.sleep(1000);
        WebElement AnnouncementClick =  driver.findElement(By.xpath("//span[.='Announcement']"));
        AnnouncementClick.click();
        Thread.sleep(2000);
        WebElement workflow = driver.findElement(By.xpath("//span[.='Workflow']"));
        workflow.click();

//WebElement workflowClick = driver.findElement(By.xpath("//span[.='Workflow']"));
//workflowClick.click();

    }

    @AfterMethod
    public void afterMethod(){

        driver.close();
    }
}
