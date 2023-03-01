package com.genericmethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CommonMethods {
    public static WebDriver driver;
    public CommonMethods(WebDriver driver)

    {        this.driver = driver;
    }
    /*public void applicationLaunch() {
         WebDriverManager.chromedriver().setup();
               driver = new ChromeDriver();
                     driver.get("https://magento.softwaretestingboard.com/customer/account/");
                        }*/
    //this is for click action
    public static void clickingOnWebElement(WebElement element)
       {
           WebDriverWait webwait = new WebDriverWait(driver, Duration.ofSeconds(10));
      WebElement elements =null;
        elements =webwait.until(ExpectedConditions.elementToBeClickable(element));
       elements.click();
       }

    // this is for sendkeys action
       public static void sendKeysOnWebElement(WebElement element, String text)    {
      //element.click();
      element.sendKeys(text);    }
     //this is for selecting value from dropdownlist
     public static void selectFromDropDown(WebElement element, String text, String value)
     {
         Select select =new Select(element);
    select.selectByVisibleText(text);
     select.selectByValue(value);}
   // this is for accepting or dismissing alerts
     public void acceptAlerts(WebDriver driver)
     {        driver.switchTo().alert().accept();    }
}
