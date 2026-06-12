package com.periplus.carttest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailPage {
    WebDriver driver;

    By productName = By.cssSelector("quickview-content h2");
    By addToCartButton = By.cssSelector("btn-add-to-cart");
    By cartButton = By.id("show-your-cart");

    public ProductDetailPage(WebDriver driver){
        this.driver = driver;
    }

    public String getProductName(){
        String title = driver.findElement(productName).getText().trim();
        return title;
    }

    public void addToCart(){
        driver.findElement(addToCartButton).click();
    }

    public void showCart(){
        driver.findElement(cartButton).click();
    }

}
