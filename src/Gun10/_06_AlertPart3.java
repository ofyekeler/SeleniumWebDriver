package Gun10;

import Utility.BaseDriver_SikKullanilanlar;
import Utility.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class _06_AlertPart3  extends BaseDriver_SikKullanilanlar {

    @Test
    public void Test1() {
        driver.get("http://demo.seleniumeasy.com/javascript-alert-box-demo.html");

        WebElement clickMe2=driver.findElement(By.xpath("//button[@onclick='myPromptFunction()']"));
        MyFunc.Bekle(2);
        clickMe2.click();

        MyFunc.Bekle(2);
        // alert açılıyor.
        driver.switchTo().alert().sendKeys("ismet");
        driver.switchTo().alert().accept();

        MyFunc.Bekle(2);
        WebElement txtActual=driver.findElement(By.id("prompt-demo"));

        Assert.assertTrue("Beklenen yazi göründü mü", txtActual.getText().contains("ismet"));

        BekleKapat();
    }
}