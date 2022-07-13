package org.example;

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

public class App 
{
    public static void setdate(WebDriver driver, String date){
        List<WebElement> dateStart = driver.findElements(By.xpath("//li[@class='date_is_selectable_true']/span"));
        for (int i=0;i<dateStart.size();i++)
        {
            String d = dateStart.get(i).getText();
            if (d.equalsIgnoreCase(date))
            {
                dateStart.get(i).click();
                break;
            }
        }
    }
    public static void main( String[] args ) throws InterruptedException {
        WebDriver driver = WebDriverManager.chromedriver().avoidShutdownHook().create();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://www.goibibo.com/hotels");

       /* 1.Keys class method -*/
        driver.findElement(By.xpath("//h4[contains (text(),'International')]")).click();
        driver.findElement(By.xpath("//input[@placeholder='e.g. - Area, Landmark or Property Name']")).click();
        driver.findElement(By.xpath("//input[@placeholder='e.g. - Area, Landmark or Property Name']")).sendKeys("Mumbai");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@placeholder='e.g. - Area, Landmark or Property Name']")).sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
        /* 2. Action class method -
        Actions act = new Actions(driver);
        WebElement loc = driver.findElement(By.xpath("//p[contains (text(),'Amsterdam')]"));
        act.moveToElement(loc).click().build().perform();*/

        driver.findElement(By.xpath("//div[@data-testid='openCheckinCalendar']")).click();
        setdate(driver, "19");
        System.out.println("check in date set");
        setdate(driver, "29");
        System.out.println("check out date set");

        driver.findElement(By.xpath("//span[contains (text(), 'Guests & Rooms')]")).click();
        driver.findElement(By.xpath("//span[contains (text(), 'Rooms')]/following-sibling::div/span")).click();
        Thread.sleep(2000);
        String alertMSG1 =driver.switchTo().alert().getText();
        System.out.println("Alert msg for min Rooms count :-"+alertMSG1);
        driver.switchTo().alert().accept();

        driver.findElement(By.xpath("//span[contains (text(), 'Adults')]/following-sibling::div/span")).click();
        driver.findElement(By.xpath("//span[contains (text(), 'Adults')]/following-sibling::div/span")).click();
        Thread.sleep(2000);
        String alertMSG2 =driver.switchTo().alert().getText();
        System.out.println("Alert msg for min Adults count :-"+alertMSG2);
        driver.switchTo().alert().accept();


        driver.findElement(By.xpath("//span[contains (text(), 'Children')]/following-sibling::div/span")).click();
        Thread.sleep(2000);
        String alertMSG3 =driver.switchTo().alert().getText();
        System.out.println("Alert msg for min Children count :-"+alertMSG3);
        driver.switchTo().alert().accept();

        driver.findElement(By.xpath("//button[contains (text(), 'Done')]")).click();
        driver.findElement(By.xpath("//button[contains (text(), 'Search')]")).click();
    }
}
