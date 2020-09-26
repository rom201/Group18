package com.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory {
    public static WebDriver getDriver(String browserType)
    {
        if (browserType.equalsIgnoreCase("Chrome"))
        {
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver();
        }

        else if (browserType.equalsIgnoreCase("Firefox"))
        {
            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver();
        }

        else if (browserType.equalsIgnoreCase("Edge"))
        {
            WebDriverManager.edgedriver().setup();
            return new EdgeDriver();
        }

        else
        {
            System.out.println("browserType = " + browserType+" is not exist");
            return null;
        }

    }
}
