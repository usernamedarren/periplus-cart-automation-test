package com.periplus.carttest;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.*;

public class PeriplusCartTest {
    WebDriver driver;
    String productName;

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
    
    @Test(dataProvider = "loginData")
    public void testLogin(String email, String password){
        HomePage homePage = new HomePage(driver);
        homePage.signIn();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.Login(email, password);
    }

    @Test(dependsOnMethods = {"testLogin"})
    public void testSearchItem(){
        HomePage homePage = new HomePage(driver);
        homePage.searchItem("Spy School Secret Service");
    }

    @Test(dependsOnMethods = {"testSearchItem"})
    public void testAddToCart(){
        ProductPage productPage = new ProductPage(driver);
        productPage.checkProductDetail();

        ProductDetailPage productDetailPage = new ProductDetailPage(driver);

        this.productName = productDetailPage.getProductName();
        
        productDetailPage.addToCart();
        productDetailPage.showCart();
    }

    @AfterClass
    public void exitBrowser(){
        driver.quit();
    }
}
