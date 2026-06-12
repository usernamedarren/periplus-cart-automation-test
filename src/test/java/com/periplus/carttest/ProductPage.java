package com.periplus.carttest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage {
    WebDriver driver;

    By product = By.cssSelector(".product-img");
    By preloader = By.className("preloader");

    public ProductPage(WebDriver driver){
        this.driver = driver;
    }

    public void checkProductDetail(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        if(driver.findElement(preloader).isDisplayed()){
            wait.until(ExpectedConditions.invisibilityOfElementLocated(preloader));
        }
        driver.findElement(product).click();
    }
}
