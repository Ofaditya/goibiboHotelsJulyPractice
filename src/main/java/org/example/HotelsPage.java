package org.example;

import Util.BaseClass;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import javax.xml.xpath.XPath;
import java.util.List;

public class HotelsPage extends BaseClass {
    public HotelsPage(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//h4[contains (text(),'International')]")
    WebElement RadioButtonInt;

    @FindBy(xpath = "//input[@placeholder='e.g. - Area, Landmark or Property Name']")
    WebElement AreaName;

    @FindBy(xpath = "//p[contains (text(),'Amsterdam')]")
    WebElement AreafrmDropdown;

    @FindBy(xpath = "//div[@data-testid='openCheckinCalendar']")
    WebElement openCheckinCalendar;

    @FindBy(xpath = "//li[@class='date_is_selectable_true']/span")
    List <WebElement> dateStart;

    @FindBy(xpath = "//span[contains (text(), 'Guests & Rooms')]")
    WebElement GuestsAndRooms;

    @FindBy(xpath = "//span[contains (text(), 'Rooms')]/following-sibling::div/span")
    WebElement RoomsDecrement;

    @FindBy(xpath = "//span[contains (text(), 'Adults')]/following-sibling::div/span")
    WebElement AdultsDecrement;

    @FindBy(xpath = "//span[contains (text(), 'Children')]/following-sibling::div/span")
    WebElement ChildDecrement;

    @FindBy(xpath = "//button[contains (text(), 'Done')]")
    WebElement DoneBtn;

    @FindBy(xpath = "//button[contains (text(), 'Search')]")
    WebElement SearchBtn;

    public void ClkRadioBtn(){
        RadioButtonInt.click();
    }

    public void EnterArea() throws InterruptedException {
        AreaName.click();

        /* 1.Keys class method -*/
        AreaName.sendKeys("Mumbai");
        Thread.sleep(2000);
        AreaName.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);

        /* 2. Action class method -
        Actions act = new Actions(driver);
        act.moveToElement(AreafrmDropdown).click().build().perform();*/
    }

    public void SelCalenderDate(){
        openCheckinCalendar.click();
        setdate(dateStart, "19");
        System.out.println("check in date set");
        setdate(dateStart, "29");
        System.out.println("check out date set");
    }

    public void SelGuestRoomChildCount() throws InterruptedException {
        GuestsAndRooms.click();
        RoomsDecrement.click();
        Thread.sleep(1000);
        String alertMSG1 = driver.switchTo().alert().getText();
        System.out.println("Alert msg for min Rooms count :-" + alertMSG1);
        driver.switchTo().alert().accept();

        AdultsDecrement.click();
        AdultsDecrement.click();
        Thread.sleep(1000);
        String alertMSG2 = driver.switchTo().alert().getText();
        System.out.println("Alert msg for min Adults count :-" + alertMSG2);
        driver.switchTo().alert().accept();

        ChildDecrement.click();
        Thread.sleep(1000);
        String alertMSG3 = driver.switchTo().alert().getText();
        System.out.println("Alert msg for min Children count :-" + alertMSG3);
        driver.switchTo().alert().accept();
    }

    public void ClkDoneBtn(){
        DoneBtn.click();
    }

    public void ClkSearchBtn(){
        SearchBtn.click();
        System.out.println("Search Comoplated -----------------------------");
    }

}
