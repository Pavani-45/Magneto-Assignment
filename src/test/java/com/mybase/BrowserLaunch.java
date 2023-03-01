package com.mybase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;


public class BrowserLaunch {
    public WebDriver driver;

    @BeforeSuite
    //for intializing the webdriver before the launching the browser
    public void intializingWebDriver() {
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.get("https://magento.softwaretestingboard.com/customer/account/");


    }

  @BeforeClass
   // this is for lambda test
  public void lambdaapplication() throws MalformedURLException {
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
      DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
      ChromeOptions chromeOptions = new ChromeOptions();
      desiredCapabilities.setCapability("browser", "chrome");
      desiredCapabilities.merge(chromeOptions);
      driver = new RemoteWebDriver(new URL("https://masanammanjula:MoILEv0ExFoFNx4mDnYsS2NAAljBAzfD95UljcGkaoQazsW0Np@hub.lambdatest.com/wd/hub"), chromeOptions);

      driver.get("https://magento.softwaretestingboard.com/customer/account/");
      driver.manage().window().maximize();

  }

    //this is for closing the browser
    @AfterTest
    public void killSession(){
        driver.quit();

    }
}
