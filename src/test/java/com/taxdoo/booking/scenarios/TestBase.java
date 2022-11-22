package com.taxdoo.booking.scenarios;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

public class TestBase {

    protected WebDriver driver;
    protected WebDriverWait webDriverWait;

    private final String BOOKING_START_PAGE_URL="https://booking.test.env.taxdoo.com/";

    @BeforeSuite
    public void initDriver(){
        WebDriverManager.chromedriver().setup();
        final ChromeOptions options = new ChromeOptions();
        //options.addArguments("--headless");
        driver = new ChromeDriver(options);

        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @BeforeTest
    public void openTaxDooBookingPage(){
        driver.get(BOOKING_START_PAGE_URL);
        driver.manage().window().maximize();
        closeCookieAlert();
    }

    private void closeCookieAlert(){
        WebElement alert=webDriverWait.until(
                ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class,'osano-cm-close')]")));
        alert.click();
    }

    @AfterTest
    public void closeDriver(){
        driver.close();
    }

    @AfterSuite
    public void cleanUp(){
        driver.quit();
    }
}
