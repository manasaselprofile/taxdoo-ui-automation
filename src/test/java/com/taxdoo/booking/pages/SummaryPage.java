package com.taxdoo.booking.pages;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SummaryPage extends AbstractPage {

    @FindBy(name="accept")
    private WebElement terms;

    @FindBy(xpath = "//button[@type='submit']/span[@class='notranslate']")
    private WebElement completeBooking;

    public SummaryPage(@NonNull WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String getElementValue(String field){
        WebElement element = webDriver.findElement(By.xpath("//div[text()='"+field+"']/following-sibling::div"));
        return element.getText();
    }

    public boolean isElementExists(String field){
        return  webDriver.findElement(By.xpath("//div[contains(text(), '"+field+"')]")).isDisplayed();
    }

    public SummaryPage acceptTerms(){
        this.terms.click();
        return this;
    }

    public void clickCompleteBooking(){
        this.webDriverWait.until(ExpectedConditions.elementToBeClickable(completeBooking)).click();
    }
}
