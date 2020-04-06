package com.newtours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FindFlightPage extends PageFactory {

    @FindBy(name = "findFlights") private WebElement firstSubmitBtn;
    @FindBy(name = "buyFlights") private WebElement secondSubmitBtn;
    WebDriver driver;
    private WebDriverWait wait = new WebDriverWait(driver, 30);

    public void submitFindFlighPage(){
        wait.until(ExpectedConditions.visibilityOf(firstSubmitBtn));
        this.firstSubmitBtn.click();
    }

    public void goToFlightConfirmationPage(){
        wait.until(ExpectedConditions.visibilityOf(secondSubmitBtn));
        this.secondSubmitBtn.click();
    }
}
