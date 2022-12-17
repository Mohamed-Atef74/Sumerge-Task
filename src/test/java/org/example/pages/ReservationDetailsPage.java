package org.example.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.example.tests.Hooks;
import org.openqa.selenium.support.ui.Select;
import java.util.Set;

import static org.example.tests.Hooks.driver;

public class ReservationDetailsPage {

    public WebElement checkInDate(){
        return driver.findElement(By.cssSelector("[data-date-format=\"short_date_with_weekday_without_year\"]"));
    }

    public WebElement checkOutDate(){
        return driver.findElement(By.cssSelector("[data-placeholder=\"Check-out\"]"));
    }

    public WebElement selectBed(){
        return driver.findElement(By.cssSelector("div [class=\"rt-bed-type-select\"] > input")) ;
    }

    public Select rooms(){
        WebElement DDL = driver.findElement(By.className("hprt-nos-select"));
        Select rooms = new Select(DDL);
        return rooms;
    }

    public WebElement reserveButton(){
        return Hooks.driver.findElement(By.className("txp-bui-main-pp"));
    }

    public void switchWindow(){
        String parentWindow = Hooks.driver.getWindowHandle();
        Set<String> allWindows = Hooks.driver.getWindowHandles();
        for (String currentWindow : allWindows)
            if (!currentWindow.equalsIgnoreCase(parentWindow))
                Hooks.driver.switchTo().window(currentWindow);
    }

}
