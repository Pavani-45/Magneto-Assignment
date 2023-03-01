package com.test;

import com.main.AddressPage;
import com.main.LoginPage;
import com.main.PriceList;
import com.main.SelectBagPage;
import com.mybase.BrowserLaunch;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

public class magentoTest  extends BrowserLaunch {

   public LoginPage loginPage;
   public SelectBagPage selectbagpage;
   public PriceList pricelist;
   public AddressPage addressPage;


    @Test(priority = 1)
    public void loginApplication() throws InterruptedException, FileNotFoundException {
        loginPage= new LoginPage(driver);
        loginPage.loginScreen();
    }
   @Test(priority =2)
   public void selectItem() throws InterruptedException {
        selectbagpage = new SelectBagPage(driver);
        selectbagpage.chooseBag();
        selectbagpage.verifyCart();
    }
    @Test(priority = 3)
    public  void priceItemList() throws InterruptedException {
        pricelist = new PriceList(driver);
        pricelist.highestPrice();
        pricelist.addToWishList();
        pricelist.addToCart();
    }
    @Test(priority = 4)
    public void addressForOrder() throws InterruptedException, FileNotFoundException {
        addressPage = new AddressPage(driver);
        addressPage.addNewAddress();
        addressPage.fillShippingAddress();
        addressPage.OrderNumber();
       // addressPage.verifyOrderNumber();
    }



    }



