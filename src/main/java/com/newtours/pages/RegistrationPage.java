package com.newtours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage {

    private WebDriver driver;
    private WebDriverWait wait ;

    @FindBy(name = "firstName") private WebElement firstnameText;
    @FindBy(name = "lastName") private WebElement lastnameText;
    @FindBy(name = "email") private WebElement usernameText;
    @FindBy(name = "password") private WebElement password;
    @FindBy(name = "confirmPassword") private WebElement confirmPassword;
    @FindBy(name = "register") private WebElement submitButton;

    public RegistrationPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver,30 );
        PageFactory.initElements(driver,this);
    }

    public void goTo(){
        this.driver.get("http://newtours.demoaut.com/mercuryregister.php?osCsid=87e3c2f57b874010f25a2d930d627306");
        this.wait.until(ExpectedConditions.visibilityOf(this.firstnameText));

    }

    public void enterUserDetails(String firstName, String lastName){
        this.firstnameText.sendKeys(firstName);
        this.lastnameText.sendKeys(lastName);
    }

    public void enterCredentials(String usernameEmail, String password){
        this.usernameText.sendKeys(usernameEmail);
        this.password.sendKeys(password);
        this.confirmPassword.sendKeys(password);
    }

    public void submit(){
        this.submitButton.click();
    }
}
