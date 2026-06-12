package com.periplus.carttest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver;

    By signInButton = By.id("nav-signin-text");
    By searchTextbox = By.id("filter_name_desktop");

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public void signIn(){
        driver.findElement(signInButton).click();
    }

    public void searchItem(String item){
        driver.findElement(searchTextbox).sendKeys("item");
    }

}
