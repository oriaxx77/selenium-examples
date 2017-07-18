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

    @Autowired
    private GoogleAccess googleAccess;


    @Before
    public void createDriverAndGetPage() throws Exception
    {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get( googleAccess.getUrl() );
    }

    @Test
    public void testSearch()
    {
        new GoogleSearchPage( driver ){{
            submitQuery( googleAccess.getSearch() );
            Assert.assertEquals( 11, getSearchResult().size() );
        }};
    }


    @After
    public void quitDriver() throws Exception
    {
        driver.quit();
    }

}