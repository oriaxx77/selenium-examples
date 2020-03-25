package com.oriaxx77.seleniumplay;


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

    public GoogleSearchPage submitQuery( String query )
    {
        input( By.name("q") ).sendKeys( query ).submit() ;
        return this;
    }

    public List<WebElement> getSearchResult()
    {
        (new WebDriverWait( delegate, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.id("search")));
        return delegate.findElements(By.className("g"));
    }

    public GoogleAdvertisingPage clickAdvertising()
    {
        String bottomLinkSectionId = "fsl";
        (new WebDriverWait( delegate, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.id(bottomLinkSectionId)));

        WebElement links = delegate.findElement(By.id(bottomLinkSectionId));
        System.out.println( "Help text: " + links.findElements(By.tagName("a")).get(0).getText());

        new IO(() ->{new WebDriverWait(delegate, 10).wait();});
        return new GoogleAdvertisingPage(this.delegate);
    }

}
