package com.oriaxx77.seleniumplay;

import org.openqa.selenium.WebDriver;
import org.seleniumhq.selenium.fluent.FluentWebDriver;

public class BasePage extends FluentWebDriver
{
    public BasePage( WebDriver driver )
    {
        super( driver );
    }
}
