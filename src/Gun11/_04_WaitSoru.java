package Gun11;


/*
Senaryo
1-  https://www.demoblaze.com/index.html  siteyi açınız.
2- Samsung galaxy s6  linkine tıklayınız.
3- Sepete ekleyiniz.
4- Daha Sonra PRODUCT STORE yazısına tıklatarak ana ekrana geri dönününz
 */

import Utility.BaseDriver_SikKullanilanlar;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class _04_WaitSoru extends BaseDriver_SikKullanilanlar {

    @Test
    public void Wait1()
    {
        driver.get("https://www.demoblaze.com/index.html");

        WebElement link=driver.findElement(By.linkText("Samsung galaxy s6"));
        link.click();

        WebElement sepeteEklelinki=driver.findElement(By.linkText("Add to cart"));
        sepeteEklelinki.click();

        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.alertIsPresent());
                            // alert çıkana kadar bekle (explicitWait)

        driver.switchTo().alert().accept(); // WAIT yapmazsak ALERT kutucuğu açılana kadar beklemediği için
                                       // ACCEPT yapamıyor ve hata veriyor. o yüzden BEKLEME oluşturuyoryuz.

        WebElement anaSayfa=driver.findElement(By.id("nava"));
        anaSayfa.click();

        BekleKapat();
    }
}
