package com.sprint1Implementation.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.io.ObjectInputFilter;
import java.time.Duration;

public class Driver {

    //private constructor to remove access to the driver object
    private Driver() {
    } //the value of this is currently null


    /*
    make WebDriver also private to also close access from outside of class.
    Make it static bc we will use it in a static method
     */

    private static InheritableThreadLocal<WebDriver> driverPool = new InheritableThreadLocal<>();

    public static WebDriver getDriver() {

        /*
        below is a re-useable util method which implements Singleton to return the same driver instance
        if an instance doesn't exist, it will be created and always return that instance
         */

        if(driverPool.get() == null){

            // first we read the browser type from config.prop file
            //this way we can control which browser is opened from outside our code

            String browserType = ConfigurationReader.getProperty("browser");

            /*
            depending on which browser type is returned from config.prop file
            the following switch will open corresponding browser
             */

            switch (browserType){
                case "chrome":
                    //WebDriverManager.chromedriver().setup();
                    driverPool.set(new ChromeDriver());
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                    break;
                case "firefox":
                    //WebDriverManager.firfoxdriver().setup();
                    driverPool.set(new FirefoxDriver());
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                    break;
            }

        }
        return driverPool.get();

    }

    public static void closeDriver(){
        if(driverPool.get()!=null){
            driverPool.get().quit();

            driverPool.remove();
        }
    }

}

