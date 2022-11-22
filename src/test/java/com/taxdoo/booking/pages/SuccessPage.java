package com.taxdoo.booking.pages;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.openqa.selenium.By.xpath;

public class SuccessPage extends AbstractPage {

    private static final By BOOKING_SUCCESS_MSG_XPATH= xpath("//h4[contains(text(),'Booking successful')]");

    public SuccessPage(@NonNull WebDriver driver) {
        super(driver);
    }

    public boolean isBookingCompleted(){
        WebElement successMessage = webDriverWait.until(
                ExpectedConditions.visibilityOfElementLocated(BOOKING_SUCCESS_MSG_XPATH));
        return successMessage.isDisplayed();
    }
}
