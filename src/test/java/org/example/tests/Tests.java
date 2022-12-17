package org.example.tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;

import static org.example.pages.SearchResultsPage.expectedHotelName;


public class Tests extends Hooks {
    String expectedCheckInDate;
    String expectedCheckOutDate;

    @Test(priority = 0,dataProvider = "ExcelData")
    public void userSearchesForLocationAndSelectsDate(String location, String checkIn, String checkOut) throws InterruptedException {
        searchElements.searchBox().sendKeys(location);
        Thread.sleep(2000);

        searchElements.selectLocation(location);
        searchElements.checkInDate(checkIn).click();
        searchElements.checkOutDate(checkOut).click();
        expectedCheckInDate=searchElements.checkInDateText().getText();
        expectedCheckOutDate=searchElements.checkOutDateText().getText();
        searchElements.searchButton().click();
    }

    @Test(priority = 1)
    public void userSelectsSpecificHotel() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.
                urlContains("https://www.booking.com/searchresults.html?"));

        searchResultsElements.selectHotel();
    }

    @Test(priority = 2)
    public void userSetsTheReservationDetails() throws InterruptedException {
        Thread.sleep(2000);
        reservationDetailsElements.switchWindow();

        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.
                urlContains("https://www.booking.com/hotel/eg/royal-tulip-alexandria.html?"));

        Assert.assertEquals(reservationDetailsElements.checkInDate().getText(),expectedCheckInDate,"Check in date assertion");
        Assert.assertEquals(reservationDetailsElements.checkOutDate().getText(),expectedCheckOutDate,"Check out date assertion");

        reservationDetailsElements.selectBed().click();
        reservationDetailsElements.rooms().selectByValue("1");
        reservationDetailsElements.reserveButton().click();

    }

    @Test(priority = 3)
    public void userConfirmsTheReservation(){
        /*
        NOTE
        Please note that the website is having some updates and this testcase may fail, so if this happens please comment out the WebDriverWait
        and replace the assertion with:
        Assert.assertEquals(confirmReservationDetails.hotelNameAfterUpdate().getText(),expectedHotelName,"Hotel Name assertion");
         */
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.
                urlContains("https://secure.booking.com/book.html?"));

            Assert.assertEquals(confirmReservationDetails.hotelName().getText(),expectedHotelName,"Hotel Name assertion");
    }
}

