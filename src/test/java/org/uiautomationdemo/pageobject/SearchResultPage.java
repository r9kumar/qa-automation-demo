package org.uiautomationdemo.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Objects;

public class SearchResultPage {
    private final WebDriver driver;

    public SearchResultPage(final WebDriver driver) {
        Objects.requireNonNull(driver);
        this.driver = driver;
    }
    
    @FindBy(xpath = "//section[contains(@class,'CurrentConditions')]")
    private WebElement searchedCityCondition;

    public boolean isSearchedLocationDisplayed(String locationName) {
        return driver.findElement(By.xpath(String.format("//h1[contains(text(),'%s')]", locationName))).isDisplayed();
    }
}