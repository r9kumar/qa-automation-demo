package org.uiautomationdemo.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Objects;

public class HomePage {

    private final WebDriver driver;

    public HomePage(final WebDriver driver) {
        Objects.requireNonNull(driver);
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }
    
    @FindBy(id = "LocationSearch_input")
    private WebElement locationSearchTxtBox;

    public void loadHomePage() {
        driver.get("https://weather.com/");
    }
    
    public void clickLocationSearchBox() {
    	locationSearchTxtBox.click();
    }

    public void search(String searchText) {
        Objects.requireNonNull(searchText);
        searchField.sendKeys(searchText);
        searchField.sendKeys(Keys.ENTER);
    }
    
}
