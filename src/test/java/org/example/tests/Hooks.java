package org.example.tests;

import org.example.data.ExcelReader;
import org.example.pages.ConfirmReservationPage;
import org.example.pages.ReservationDetailsPage;
import org.example.pages.SearchPage;
import org.example.pages.SearchResultsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import java.io.IOException;
import java.time.Duration;

public class Hooks {

    public static WebDriver driver;
    SearchPage searchElements = new SearchPage();
    SearchResultsPage searchResultsElements = new SearchResultsPage();
    ReservationDetailsPage reservationDetailsElements = new ReservationDetailsPage();
    ConfirmReservationPage confirmReservationDetails = new ConfirmReservationPage();

    @DataProvider(name = "ExcelData")
    public Object[][] searchData() throws IOException {
        ExcelReader er = new ExcelReader();
        return er.getExcelData();
    }

    @BeforeTest
    public static void openBrowser(){
        String driverLocation = System.getProperty("user.dir")+"\\src\\main\\resources\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", driverLocation);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.booking.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterTest
    public static void closeBrowser() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
