package com.oriaxx77.seleniumplay;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class GoogleAdvertisingPage extends BasePage
{
    public GoogleAdvertisingPage(WebDriver driver)
    {
        super(driver);
    }

    public String getUrl()
    {
        return "https://support.google.com/websearch";
    }
}
