package Gun06;

import Utility.BaseDriver_SikKullanilanlar;
import Utility.MyFunc;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Odev1 extends BaseDriver_SikKullanilanlar {
    // 1- https://formsmarts.com/form/yu?mode=h5 sitesini açın
    // 2- Business i çekleyin.
    // 3- discover XYZ ye tıklatın ve online Advertising i seçin
    // 4- Every day i seçin
    // 5- Good u seçin
    // 6- using XYZ yi tıklatın ve 3.seçeneği seçin
    // css selector

    @Test
    public void Test1(){

        driver.get("https://formsmarts.com/form/yu?mode=h5");
        WebElement business = driver.findElement(By.cssSelector("input[type='radio'][value='Business']"));
        business.click();

        MyFunc.Bekle(2);

        WebElement dropDownDiscover = driver.findElement(By.cssSelector("[id$='_4588']"));
        dropDownDiscover.click();

        MyFunc.Bekle(2);

        WebElement onlineAdvertising = driver.findElement(By.cssSelector("[id$='_4588']>[value='Online Advertising']"));
        onlineAdvertising.click();

        MyFunc.Bekle(2);

        WebElement everyDay = driver.findElement(By.cssSelector("[value='Every Day']"));
        everyDay.click();

        MyFunc.Bekle(2);

        WebElement good = driver.findElement(By.cssSelector("[type='radio'][value='Good']"));
        good.click();

        MyFunc.Bekle(2);

        WebElement howLong = driver.findElement(By.cssSelector("[id$='_4597']"));
        howLong.click();

        MyFunc.Bekle(2);

        WebElement optionUsing3 = driver.findElement(By.cssSelector("[id$='_4597']>:nth-child(4)"));
        optionUsing3.click();

        good.click(); // using listesi açık kalmasın diye ekledim. Opsiyonel. Yazmasam da testi etkilemez.

        BekleKapat();

    }
}
