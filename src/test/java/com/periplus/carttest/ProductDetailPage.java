package com.periplus.carttest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductDetailPage {
    WebDriver driver;

    By productName = By.cssSelector(".quickview-content h2");
    By addToCartButton = By.className("btn-add-to-cart");
    By cartButton = By.id("show-your-cart");
    By preloader = By.className("preloader");

    public ProductDetailPage(WebDriver driver){
        this.driver = driver;
    }

    public String getProductName(){
        String title = driver.findElement(productName).getText().trim();
        return title;
    }

    public void addToCart(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        if(driver.findElement(preloader).isDisplayed()){
            wait.until(ExpectedConditions.invisibilityOfElementLocated(preloader));
        }
        driver.findElement(addToCartButton).click();
    }

    public void showCart(){
        driver.findElement(cartButton).click();
    }

}
