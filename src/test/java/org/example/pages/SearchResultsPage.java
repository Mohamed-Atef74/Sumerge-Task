package org.example.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;
import static org.example.tests.Hooks.driver;

public class SearchResultsPage {
    public static String expectedHotelName;

    public List<WebElement> hotels(){
        return driver.findElements(By.cssSelector("[data-testid=\"title\"]"));
    }
    public List<WebElement> seeAvailabilityButton(){
        return driver.findElements(By.linkText("See availability"));
    }

    public String selectHotel(){
        for (int i=0;i<hotels().size();i++){
            if (hotels().get(i).getText().contains("Tolip Hotel Alexandria")) {
                expectedHotelName=hotels().get(i).getText();
                seeAvailabilityButton().get(i).click();
                break;
            }

        }
        return expectedHotelName;
    }
}
