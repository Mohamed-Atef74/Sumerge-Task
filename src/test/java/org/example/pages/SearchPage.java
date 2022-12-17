package org.example.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;

import static org.example.tests.Hooks.driver;

public class SearchPage {
    public WebElement searchBox(){
        return driver.findElement(By.name("ss"));
    }

    public List<WebElement> searchResults(){
        return driver.findElements(By.cssSelector("ul[data-testid=\"autocomplete-results\"] > li"));
    }

    public List<WebElement> searchResultsAfterUpdate(){
        return driver.findElements(By.cssSelector("ul[role=\"listbox\"] > li"));
    }

    public WebElement checkInDate(String checkIn){
        return driver.findElement(By.cssSelector("[data-date="+checkIn+"]"));
    }

    public WebElement checkOutDate(String checkOut){
        return driver.findElement(By.cssSelector("[data-date="+checkOut+"]"));
    }

    public WebElement checkInDateText(){
        return driver.findElement(By.cssSelector("[data-placeholder=\"Check-in\"]"));
    }

    public WebElement checkOutDateText(){
        return driver.findElement(By.cssSelector("[data-placeholder=\"Check-out\"]"));
    }

    public WebElement searchButton(){
        return driver.findElement(By.cssSelector("[class=\"sb-searchbox__button \"]"));
    }

    public void selectLocation(String location){
        List<WebElement> listOptions = searchResultsAfterUpdate();
        for (int i=0;i<listOptions.size();i++){
            String currentOption=listOptions.get(i).getText();
            if (currentOption.contains(location)) {
                listOptions.get(i).click();
                break;
            }
        }
    }
}
