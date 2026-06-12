package com.periplus.carttest;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.*;

public class PeriplusCartTest {
    WebDriver driver;

    @DataProvider(name = "loginData")
    public Object[][] loginData() {
        return new Object[][] {
            {"darrenmansyl05@gmail.com", "Darren_periplus"}
        };
    }

    @BeforeClass
    public void setupBrowser(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.periplus.com/");
    }
    
    @Test(
        dataProvider = "loginData",
        dependsOnMethods = "setupBrowser"
    )
    public void testLogin(String email, String password){
        HomePage homePage = new HomePage(driver);
        homePage.signIn();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.Login(email, password);
    }

    @AfterClass
    public void exitBrowser(){
        driver.quit();
    }
}
