package org.example.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.example.tests.Hooks.driver;

public class ConfirmReservationPage {
    public WebElement hotelName(){
        return driver.findElement(By.cssSelector("div > h1"));
    }

    public WebElement hotelNameAfterUpdate(){
        return driver.findElement(By.cssSelector("[class=\"bp_hotel_name_title\"]"));
    }
}
