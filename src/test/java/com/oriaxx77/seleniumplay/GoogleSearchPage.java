package com.oriaxx77.seleniumplay;

import com.oriaxx77.seleniumplay.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class GoogleSearchPage extends BasePage
{
    public GoogleSearchPage( WebDriver driver )
    {
        super(driver);
    }

    public void submitQuery( String query )
    {
        input( By.name("q") ).sendKeys( query ).submit() ;
    }

    public List<WebElement> getSearchResult()
    {
        (new WebDriverWait( delegate, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.id("resultStats")));

        return delegate.findElements(By.xpath("//*[@id='rso']//h3/a"));
    }
}
