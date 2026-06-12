package com.periplus.carttest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    WebDriver driver;

    By signInButton = By.id("nav-signin-text");
    By searchTextbox = By.id("filter_name_desktop");
    By searchButton = By.className("btnn");
    By preloader = By.className("preloader");

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public void signIn(){
        driver.findElement(signInButton).click();
    }

    public void searchItem(String item){
        driver.findElement(searchTextbox).sendKeys(item);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        if(driver.findElement(preloader).isDisplayed()){
            wait.until(ExpectedConditions.invisibilityOfElementLocated(preloader));
        }

        driver.findElement(searchButton).click();
    }

}
