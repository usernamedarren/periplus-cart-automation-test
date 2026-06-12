package com.periplus.carttest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage {
    WebDriver driver;

    By product = By.cssSelector(".product-img");

    public ProductPage(WebDriver driver){
        this.driver = driver;
    }

    public void checkProductDetail(){
        driver.findElement(product).click();
    }
}
