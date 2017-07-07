package com.oriaxx77.seleniumplay;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.seleniumhq.selenium.fluent.FluentWebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.concurrent.TimeUnit;



@ContextConfiguration(classes = {GoogleTestsConfig.class})
@ActiveProfiles( {"chrome"} )
@RunWith(SpringJUnit4ClassRunner.class)
public class GoogleSearchTests
{

    @Autowired
    private WebDriver driver;
    private FluentWebDriver fluentWebDriver;
    @Autowired
    private GoogleAccess googleAccess;


    @Before
    public void createDriverAndGetPage() throws Exception
    {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get( googleAccess.getUrl() );
        fluentWebDriver = new FluentWebDriver( driver );
    }

    @Test
    public void testSearch()
    {
        fluentWebDriver.input( By.name("q") ).sendKeys( googleAccess.getSearch() ).submit() ;

        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.id("resultStats")));

        long actualResultCount = driver.findElements(By.xpath("//*[@id='rso']//h3/a")).stream()
                .map( webElement -> webElement.getAttribute( "href") ).count();

        long expectedResultCount = 12;

        Assert.assertEquals( expectedResultCount, actualResultCount );


    }


    @After
    public void quitDriver() throws Exception
    {
        driver.quit();
    }

}