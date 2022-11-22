package com.taxdoo.booking.pages;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PricePage extends AbstractPage {

    @FindBy(xpath = NEXT_BUTTON_XPATH)
    private WebElement next;

    public PricePage(@NonNull WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public PricePage chooseAverageRevenue(String averageRevenue){
        By xpath = By.xpath("//*[@id='"+averageRevenue+"']/following-sibling::label/span");
        this.webDriverWait.until(ExpectedConditions.elementToBeClickable(xpath)).click();
        return this;
    }

    public PricePage selectPackage(String option){
        By xpath = By.xpath("//*[text()='"+option+"']/following-sibling::div[text()='Choose']");
        this.webDriverWait.until(ExpectedConditions.elementToBeClickable(xpath)).click();
        return this;
    }

    public PricePage selectAddOn(String addOn){
        By xpath = By.xpath("//label[text()='"+addOn+"']");
        this.webDriverWait.until(ExpectedConditions.elementToBeClickable(xpath)).click();
        return this;
    }

    public void clickNext(){
        this.webDriverWait.until(ExpectedConditions.elementToBeClickable(next)).click();
    }
}
