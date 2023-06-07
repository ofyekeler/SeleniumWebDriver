package Gun10;

import Utility.BaseDriver_SikKullanilanlar;
import Utility.MyFunc;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/*
      Interview sorusu
      - Alertleri nasıl kullanırsın ?
        driver.switchTo().alert()     -> alerte geçerim
        komutları:
        1- accept : OK, TAMAM botunan basmamızı sağlar.
        2- dismiss : CANCEL, HAYIR, yani olumsuz butonuna basmamızı sağlıyor.
        3- sendKeys : yazı gönderme
        4- getText : uyarı yazısını alma

 */

public class _04_IntroAlert extends BaseDriver_SikKullanilanlar { // Giriş Uyarısı

    @Test
    public void Test1() {
        driver.get("http://demo.seleniumeasy.com/javascript-alert-box-demo.html");

        WebElement clickMe1=driver.findElement(By.xpath("//button[@onclick='myAlertFunction()']"));
        //  (//*[@class='panel panel-primary'][2]/..//button)[1]
        MyFunc.Bekle(2);
        clickMe1.click();

        MyFunc.Bekle(2);
        // alert açılıyor.
        driver.switchTo().alert().accept();  // alert kutusunu OK yine bas, böylece kapandı.


        BekleKapat();

        // Alert; driver a ait, element olmayan bir uyarı kutucuğudur. Sağ click ile inspect yapamayız
        // bu sebepler switchTo().alert() metodlarını kullanırız.
    }
}
