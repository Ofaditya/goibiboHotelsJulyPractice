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

        /* 1.Keys class method -*/
        hotelpage.RadioButtonInt.click();
        hotelpage.AreaName.click();
        hotelpage.AreaName.sendKeys("Mumbai");
        Thread.sleep(2000);
        hotelpage.AreaName.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
        /* 2. Action class method -
        Actions act = new Actions(driver);
        WebElement loc = driver.findElement(By.xpath("//p[contains (text(),'Amsterdam')]"));
        act.moveToElement(loc).click().build().perform();*/

        hotelpage.openCheckinCalendar.click();
        setdate(hotelpage.dateStart, "19");
        System.out.println("check in date set");
        setdate(hotelpage.dateStart, "29");
        System.out.println("check out date set");

        hotelpage.GuestsAndRooms.click();
        hotelpage.RoomsDecrement.click();
        Thread.sleep(2000);
        String alertMSG1 = driver.switchTo().alert().getText();
        System.out.println("Alert msg for min Rooms count :-" + alertMSG1);
        driver.switchTo().alert().accept();

        hotelpage.AdultsDecrement.click();
        hotelpage.AdultsDecrement.click();
        Thread.sleep(2000);
        String alertMSG2 = driver.switchTo().alert().getText();
        System.out.println("Alert msg for min Adults count :-" + alertMSG2);
        driver.switchTo().alert().accept();

        hotelpage.ChildDecrement.click();
        Thread.sleep(2000);
        String alertMSG3 = driver.switchTo().alert().getText();
        System.out.println("Alert msg for min Children count :-" + alertMSG3);
        driver.switchTo().alert().accept();

        hotelpage.DoneBtn.click();
        hotelpage.SearchBtn.click();
    }
}
