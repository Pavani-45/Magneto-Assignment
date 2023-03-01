package com.main;


import com.genericmethods.CommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class LoginPage  {
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        CommonMethods generics = new CommonMethods(driver);
    }

    @FindBy(xpath = "//div[@class='panel header']/ul//a[normalize-space()='Sign In']")
    WebElement signin;
    @FindBy(xpath = "//div[@class='control']/input[@id='email']")
    WebElement email;
    @FindBy(xpath = "//div[@class='field password required']/label/following-sibling::div/input[@title='Password']")
    WebElement password;
    @FindBy(xpath = "//fieldset/div[@class='actions-toolbar']/div/button[@id='send2']")
    WebElement signinbutton;


    //this is for login credentials
    public void loginScreen() {
        CommonMethods.clickingOnWebElement(signin);
        CommonMethods.sendKeysOnWebElement(email, "spr_selenium@yopmail.com");
        CommonMethods.sendKeysOnWebElement(password, "Selenium@4");
        CommonMethods.clickingOnWebElement(signinbutton);
    }
}