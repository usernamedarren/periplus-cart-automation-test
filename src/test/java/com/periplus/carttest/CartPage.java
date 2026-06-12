package com.periplus.carttest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
    WebDriver driver;
    By productNameLabel = By.className("product-name");

    public CartPage(WebDriver driver){
        this.driver = driver;
    }

    public Boolean verifyProductInCart(String expectedProductName){
        if(driver.findElement(productNameLabel).isDisplayed()){
            
            String productName = driver.findElement(productNameLabel).getText().trim();

            return productName.equals(expectedProductName);
        }

        return false;
    }
}
