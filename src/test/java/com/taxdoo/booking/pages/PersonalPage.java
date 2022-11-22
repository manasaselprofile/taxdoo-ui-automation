package com.taxdoo.booking.pages;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;


public class PersonalPage extends AbstractPage {

    @FindBy(name="company")
    private WebElement companyName;

    @FindBy(name="salutation")
    private WebElement salutation;

    @FindBy(name="name")
    private WebElement firstName;

    @FindBy(name="surname")
    private WebElement lastName;

    @FindBy(name="address")
    private WebElement address;

    @FindBy(name="vatNo")
    private WebElement vatNo;

    @FindBy(name="email")
    private WebElement email;

    @FindBy(name = "tel")
    private WebElement telephone;

    @FindBy(xpath = "//button[@type='submit' and not(disabled)]")
    private WebElement next;

    public PersonalPage(@NonNull WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public PersonalPage companyName(String company){
        webDriverWait.until(ExpectedConditions.visibilityOf(this.companyName)).sendKeys(company);
        return this;
    }

    public PersonalPage salutation(String value){
        Select salutationSelect = new Select(salutation);
        salutationSelect.selectByValue(value);
        return this;
    }

    public PersonalPage entityType(String entityType){
        By xpath = By.xpath("//input[@name='entityType' and @value='"+entityType+"']");
        webDriver.findElement(xpath).click();
        return this;
    }

    public PersonalPage firstName(String firstName){
        this.firstName.sendKeys(firstName);
        return this;
    }

    public PersonalPage lastName(String lastName){
        this.lastName.sendKeys(lastName);
        return this;
    }

    public PersonalPage address(String userAddress){
        this.address.sendKeys(userAddress);
        List<WebElement> elements= webDriverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
                By.xpath("//div[contains(@class, 'autoComplete-dropdown-container')]/div")));
        elements.get(0).click();
        return this;
    }

    public PersonalPage vatNo(String vat){
        this.vatNo.sendKeys(vat);
        this.vatNo.sendKeys(Keys.ENTER);
        this.webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[@name='vatNo']/following-sibling::div/img")));
        return this;
    }

    public PersonalPage email(String email){
        this.email.sendKeys(email);
        return this;
    }

    public PersonalPage telephone(String tel){
        this.telephone.sendKeys(tel);
        return this;
    }

    public void clickNext(){
        this.webDriverWait.until(ExpectedConditions.elementToBeClickable(next)).click();
    }
}
