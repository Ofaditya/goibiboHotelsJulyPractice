package org.example;

import Util.BaseClass;

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
