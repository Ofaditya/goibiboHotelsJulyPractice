package org.example;

import Util.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import javax.xml.xpath.XPath;
import java.util.List;

public class HotelsPage extends BaseClass {
    public HotelsPage(){
        this.driver= driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//h4[contains (text(),'International')]")
    WebElement RadioButtonInt;

    @FindBy(xpath = "//input[@placeholder='e.g. - Area, Landmark or Property Name']")
    WebElement AreaName;

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


}
