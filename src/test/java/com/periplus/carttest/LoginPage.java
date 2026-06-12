package com.periplus.carttest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;

    By emailTextbox = By.name("email");
    By passwordTextbox = By.name("password");
    By LoginButton = By.id("button-login");

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public void Login(String email, String password){
        driver.findElement(emailTextbox).sendKeys(email);
        driver.findElement(passwordTextbox).sendKeys(password);
        driver.findElement(LoginButton).click();
    }
    
}
