package com.oriaxx77.seleniumplay;

import com.oriaxx77.seleniumplay.browserstereotypes.Chrome;
import com.oriaxx77.seleniumplay.browserstereotypes.Headless;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;

import java.io.File;
import java.io.IOException;


@Configuration
@PropertySource({
        "classpath:app.properties"
})
public class GoogleTestsConfig
{
    @Autowired
    Environment env;


    @Bean( destroyMethod = "stop" )
    @Chrome
    DriverService chromeSeleniumDriverService() throws IOException
    {
        ChromeDriverService service = new ChromeDriverService.Builder()
                .usingDriverExecutable(new File( env.getProperty("selenium.drivers.chrome.path")))
                .usingAnyFreePort()
                .build();
        service.start();
        return service;
   }


   @Bean()
   @Scope( "prototype" )
   @Chrome
   WebDriver chromeSeleniumWebDriver( DriverService service )
   {
       return new RemoteWebDriver(service.getUrl(),
               DesiredCapabilities.chrome());

   }

   @Bean
   @Scope( "prototype" )
   @Headless
   WebDriver phantomJsDriver()
   {
       File file = new File(env.getProperty( "selenium.drivers.phantomjs.path" ));
       System.setProperty("phantomjs.binary.path", file.getAbsolutePath());
       System.out.println( "headless" );
       return new PhantomJSDriver();
   }

   @Bean
   GoogleAccess googleAccess()
   {
       return new GoogleAccess( env.getProperty( "google.url" ),
                                env.getProperty( "google.question" ));

   }
}
