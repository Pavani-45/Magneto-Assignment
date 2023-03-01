package com.main;

import com.genericmethods.CommonMethods;
import com.jsonfile.ReadingdataFromJson;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.io.FileNotFoundException;
import java.time.Duration;

public class AddressPage {
    private WebDriver driver;
    ReadingdataFromJson readingdatafromjson= new ReadingdataFromJson();

    public AddressPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        CommonMethods generics = new CommonMethods(driver);
    }

    @FindBy(xpath = "//td[@class='col col-method'][1]")
   WebElement radiobutton;
   @FindBy(xpath ="//span[text()='New Address']")
    WebElement newAddress;

    @FindBy (xpath = "//input[@ name='company']")
    WebElement companytextfield;
    @FindBy (xpath ="//input[@name='street[0]']")
    WebElement addressline1;
    @FindBy(xpath = "//input[@name='street[1]']")
    WebElement addressline2;
    @FindBy(xpath = "//input[@name='street[2]']")
    WebElement addressline3;
    @FindBy(xpath = "//input[@name='city']")
    WebElement citytextfield;
    @FindBy(xpath = "//input[@name='postcode']")
    WebElement postcodetextfield;

@FindBy(xpath = "//input[@name='telephone']")
WebElement phonenumbertextfield;
@FindBy(xpath="//span[text()='Ship here']")
WebElement shiphere;
    @FindBy(xpath = "//span[text()='Next']")
    WebElement next;
@FindBy(xpath = "//button[@type='submit']/span[text()='Place Order']")
WebElement placeorder;
@FindBy(xpath = "//a[@class='order-number']")
WebElement ordernumber;


    //this is for adding address
    public  void addNewAddress() throws InterruptedException {
        Thread.sleep(10000);
        CommonMethods.clickingOnWebElement(radiobutton);
        CommonMethods.clickingOnWebElement(newAddress);
    }
   //this is for filling the shipping address details
    public void fillShippingAddress() throws  InterruptedException, FileNotFoundException {
        Thread.sleep(1000);
        CommonMethods.sendKeysOnWebElement(companytextfield,readingdatafromjson.readFile("company") );
        CommonMethods.sendKeysOnWebElement(addressline1, readingdatafromjson.readFile("address1"));
        CommonMethods.sendKeysOnWebElement(addressline2, readingdatafromjson.readFile("address2"));
        CommonMethods.sendKeysOnWebElement(addressline3, readingdatafromjson.readFile("address3"));
        CommonMethods.sendKeysOnWebElement(citytextfield,readingdatafromjson.readFile("city"));
         WebElement State=driver.findElement(By.name("region_id"));
         State.sendKeys("Texas");
        CommonMethods.sendKeysOnWebElement(postcodetextfield,readingdatafromjson.readFile("postcode"));
        CommonMethods.sendKeysOnWebElement(phonenumbertextfield,readingdatafromjson.readFile("phone"));
    }
    //this is for generation ordernumber
    public void OrderNumber() throws InterruptedException {
        Thread.sleep(1000);
        CommonMethods.clickingOnWebElement(shiphere);
        Thread.sleep(1000);
        CommonMethods.clickingOnWebElement(next);
        Thread.sleep(10000);
        CommonMethods.clickingOnWebElement(placeorder);
        Thread.sleep(10000);
        CommonMethods.clickingOnWebElement(ordernumber);
    }
//        public void verifyOrderNumber() {
//
//            Assert.assertTrue(ordernumber.isDisplayed());
//            System.out.println("My order id is verified");
//
//        }
    }



