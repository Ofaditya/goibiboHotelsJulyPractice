package org.example;

import Util.BaseClass;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class App extends BaseClass {

    static HotelsPage hotelpage;


    public static void main(String[] args) throws InterruptedException {

        BaseClass.GetBrowser();

        hotelpage = new HotelsPage();
        driver.navigate().to("https://www.goibibo.com/hotels");

        hotelpage.ClkRadioBtn();
        hotelpage.EnterArea();
        hotelpage.SelCalenderDate();
        hotelpage.SelGuestRoomChildCount();
        hotelpage.ClkDoneBtn();
        hotelpage.ClkSearchBtn();
    }
}
