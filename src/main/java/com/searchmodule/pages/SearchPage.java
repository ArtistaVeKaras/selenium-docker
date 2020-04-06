package com.searchmodule.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SearchPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(name = "q") private WebElement searchField;
    @FindBy(id = "search_button_homepage") private WebElement searchBtn;
    @FindBy(linkText = "Videos") private WebElement videoBtn;
    @FindBy(className ="tile--vid" ) private List<WebElement> allVideos;

    public SearchPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver,this);
    }

    public void goTo(){
          this.driver.get("https://duckduckgo.com/");
    }

    public void doSearch(String keyword){
        this.wait.until(ExpectedConditions.visibilityOf(searchField));
        this.searchField.sendKeys(keyword);
        this.searchBtn.click();
    }

    public void goToVideoLink(){
        this.wait.until(ExpectedConditions.visibilityOf(videoBtn));
        this.videoBtn.click();
    }

    public int getResults(){
        By by = By.className("tile--vid");
        this.wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(by,0));
        System.out.println("Results:" + this.allVideos.size());
        return this.allVideos.size();
    }
}

