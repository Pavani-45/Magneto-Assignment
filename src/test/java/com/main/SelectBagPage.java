package com.main;

import com.genericmethods.CommonMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class SelectBagPage {
    private WebDriver driver;
    public SelectBagPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
        CommonMethods generics = new CommonMethods(driver);

    }
    @FindBy(xpath = "//span[text()='Gear']")
    WebElement geardropdown;
    @FindBy(xpath = "//span[text()='Bags']")
    WebElement bags;
    @FindBy(xpath="//a[@class='action showcart']")
    WebElement cart;
    @FindBy(xpath="//div[contains(@class,\"block block-minicart\")]")
    WebElement empty;

  //this is for selecting bag option from geardropdown
    public void chooseBag() throws InterruptedException {
        CommonMethods.clickingOnWebElement(geardropdown);
        Actions actions = new Actions(driver);
        actions.moveToElement(geardropdown).perform();
        Thread.sleep(1000);
        actions.moveToElement(bags).click().perform();
    }

    //this is for verifying empty cart
    public void verifyCart(){

        CommonMethods.clickingOnWebElement(cart);
        //Assert.assertFalse(empty.isDisplayed());
        Assert.assertTrue(empty.isDisplayed());
        System.out.println("empty list");




    }



}
