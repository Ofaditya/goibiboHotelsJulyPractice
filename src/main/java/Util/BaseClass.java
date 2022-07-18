package Util;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;

public class BaseClass {
    public static WebDriver driver;

    public static void GetBrowser(){
        driver = WebDriverManager.chromedriver().avoidShutdownHook().create();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public static void setdate(List<WebElement> dateStart , String date) {
       //dateStart = driver.findElements(By.xpath("//li[@class='date_is_selectable_true']/span"));
        for (int i = 0; i < dateStart.size(); i++) {
            String d = dateStart.get(i).getText();
            if (d.equalsIgnoreCase(date)) {
                dateStart.get(i).click();
                break;
            }
        }
    }


}
