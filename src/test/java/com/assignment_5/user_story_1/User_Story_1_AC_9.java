package com.assignment_5.user_story_1;


import com.assignment_5.Utilities.WebDriverFactory;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
<<<<<<< HEAD
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;
=======
>>>>>>> ba8bee85379c62ec8af340fa4872d3699d3cfd98

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.Keys.TAB;

<<<<<<< HEAD
        WebElement recordButton = driver.findElement(By.xpath("//span[@class='feed-add-post-form-but-cnt feed-add-videomessage']"));
        recordButton.click();
        WebElement deviceAccess = driver.findElement(By.xpath("//div[@class='popup-window-buttons']//span[@class='popup-window-button popup-window-button-blue']"));
        deviceAccess.click();

        Robot robot = new Robot();
        Thread.sleep(3000);
        robot.keyPress(KeyEvent.VK_TAB);
        Thread.sleep(3000);
        robot.delay(100);
        Thread.sleep(3000);
        robot.keyPress(KeyEvent.VK_TAB);
        Thread.sleep(3000);
        robot.delay(100);
        Thread.sleep(3000);
        robot.keyPress(KeyEvent.VK_ENTER);
        Thread.sleep(3000);
        Thread.sleep(2000);
=======
public class User_Story_1_AC_9 {
>>>>>>> ba8bee85379c62ec8af340fa4872d3699d3cfd98


}



