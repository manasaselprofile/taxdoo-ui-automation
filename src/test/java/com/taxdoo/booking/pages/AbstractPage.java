package com.taxdoo.booking.pages;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AbstractPage {

    protected static final String NEXT_BUTTON_XPATH="//button[@type='submit']/span[@class='notranslate']";

    protected WebDriver webDriver;
    protected WebDriverWait webDriverWait;

    public AbstractPage(@NonNull WebDriver driver) {
        this.webDriver = driver;
        this.webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

}
