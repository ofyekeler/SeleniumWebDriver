package Odev.Odev_2023_02_22_CSS;

import Utility.BaseDriver_SikKullanilanlar;
import Utility.MyFunc;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
/*
        1) Bu siteye gidin. -> https://www.snapdeal.com/
        2) "teddy bear" aratın ve Search butonuna tıklayın.
        3) Bu yazının göründüğünü doğrulayınız. -> (We've got 297 results for 'teddy bear')
        Not: Bu yazıdaki sayı değişiklik gösterebilir. Önemli olan cümle kalıbı.
*/
public class Odev03 extends BaseDriver_SikKullanilanlar {
    @Test
    public void test3(){

        driver.get("https://www.snapdeal.com/");
        MyFunc.Bekle(2);

        WebElement pop=driver.findElement(By.cssSelector("#pushAllow"));
        pop.click();
        MyFunc.Bekle(3);

        WebElement src=driver.findElement(By.cssSelector("div[class='col-xs-14 search-box-wrapper']>:nth-child(2)"));
        src.sendKeys("teddy bear");
        MyFunc.Bekle(3);

        WebElement clc=driver.findElement(By.cssSelector("div[class='col-xs-14 search-box-wrapper']>:nth-child(4)"));
        clc.click();
        MyFunc.Bekle(3);

        WebElement srcText=driver.findElement(By.cssSelector("div[class='search-result-txt-section  marT12']>:nth-child(1)"));
        MyFunc.Bekle(3);

        if (srcText.getText().contains("result for")){
            System.out.println("passed");
        }

        BekleKapat();
    }
}
