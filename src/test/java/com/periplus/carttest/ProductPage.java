package com.periplus.carttest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ProductPage {
    WebDriver driver;

    By product = By.cssSelector(".single-product");
    By addToCartButton = By.cssSelector(".addtocart");

    public ProductPage(WebDriver driver){
        this.driver = driver;
    }

    public void addToCart(){
        WebElement productElement = driver.findElement(product);

        Actions action = new Actions(driver);
        
        action.moveToElement(productElement).perform();

        driver.findElement(addToCartButton).click();
    }
}
