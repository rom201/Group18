package com.assignment_5.user_story_1;


import com.assignment_5.Utilities.WebDriverFactory;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.Keys.TAB;

public class User_Story_1_AC_9 {

        WebDriver driver;

        @BeforeMethod
        public void setUpDriver() {
            driver = WebDriverFactory.getDriver("Chrome");
            driver.manage().window().maximize();
            driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

        }

        @Test
        public void insertVideo() throws InterruptedException, AWTException {

            driver.get("https://login2.nextbasecrm.com/");
            driver.findElement(By.xpath("//input[@name='USER_LOGIN']")).sendKeys("helpdesk18@cybertekschool.com");
            driver.findElement(By.xpath("//input[@name = 'USER_PASSWORD']")).sendKeys("UserUser"+ Keys.ENTER);
            WebElement message = driver.findElement(By.xpath("//span[@id='feed-add-post-form-tab-message']"));
            message.click();
            Thread.sleep(1000);
            //  message.click();
            WebElement recordButton = driver.findElement(By.xpath("//span[@class='feed-add-post-form-but-cnt feed-add-videomessage']"));
            recordButton.click();

            WebElement deviceAccess = driver.findElement(By.xpath("//div[@class='popup-window-buttons']//span[@class='popup-window-button popup-window-button-blue']"));
            deviceAccess.click();

            Thread.sleep(3000);

            Robot robot =new Robot();
            robot.keyPress(KeyEvent.VK_TAB);
            robot.delay(100);
            robot.keyPress(KeyEvent.VK_TAB);
            robot.delay(100);
            robot.keyPress(KeyEvent.VK_ENTER);
            Thread.sleep(2000);


            //WebElement resultText = driver.findElement(By.xpath("//span[@class='popup-window-button popup-window-button-blue']"));
            //Assert.assertTrue(resultText.isDisplayed(),"Result text is not dispalyed.Verification FAILED!!");

            WebElement errorText = driver.findElement(By.xpath("//span[@class='popup-window-button popup-window-button-blue']"));

            //Assert.assertTrue(errorText.isDisplayed(),"Error text is not displayed.Verification Failed!!!");

            errorText.click();
        }

        @AfterMethod
        public void close() throws InterruptedException {
            Thread.sleep(3000);
            //driver.close();
        }


}




