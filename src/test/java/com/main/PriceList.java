package com.main;

import com.genericmethods.CommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PriceList {
    private WebDriver driver;

    public PriceList(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        CommonMethods generics = new CommonMethods(driver);

    }

    //this is for finding the highestprice from the list of items
    public void highestPrice() throws InterruptedException {
        List<WebElement> listofallprices = new ArrayList<WebElement>();
        listofallprices = driver.findElements(By.xpath("//span[@class='price-wrapper ']"));
        List<Double> allproductsamount = new ArrayList<>();

        for (WebElement webElement : listofallprices) {
            allproductsamount.add(Double.parseDouble(webElement.getText().replace("$", "")));
        }

        System.out.println(Collections.max(allproductsamount));
        Double maxproductamount = Collections.max(allproductsamount);

        System.out.println("max product" + maxproductamount);



        WebElement highestprice = driver.findElement(By.xpath("//span[@data-price-type='finalPrice']/span[contains(.,'" + maxproductamount + "')]/parent::span/parent::span/parent::div/preceding-sibling::strong/a"));
        String actualtext = highestprice.getText();
        System.out.println(actualtext);
        highestprice.click();
    }




@FindBy(xpath="//span[text()='Add to Wish List']")
WebElement addtowishlist;

@FindBy(xpath = "//span[text()='Impulse Duffle']/../../following-sibling::div/following-sibling::div/div/button[@type='button']")
WebElement addtocart;
@FindBy(xpath = "//a[@class='action showcart']")
WebElement ClickOnCart;

   // Assert.assertTrue(driver.findElement(By.xpath("//span[text()='You have no items in your wish list.']")).isDisplayed());
@FindBy(xpath="//button[@class='action primary checkout']")
WebElement ProceedToCheckout;


   //this is for adding the product to wishlist
    public void addToWishList() throws InterruptedException {
        CommonMethods.clickingOnWebElement(addtowishlist);
        Thread.sleep(10000);
    }
        //this is for adding product to cart
    public void addToCart() throws InterruptedException {
            Thread.sleep(10000);
            CommonMethods.clickingOnWebElement(addtocart);
            Thread.sleep(10000);
            CommonMethods.clickingOnWebElement(ClickOnCart);
            Thread.sleep(2000);
            CommonMethods.clickingOnWebElement(ProceedToCheckout);
        }

        }










