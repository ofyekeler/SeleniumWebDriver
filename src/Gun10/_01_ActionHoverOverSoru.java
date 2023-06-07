package Gun10;

import Utility.BaseDriver_SikKullanilanlar;
import Utility.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class _01_ActionHoverOverSoru extends BaseDriver_SikKullanilanlar {

    //     https://www.etsy.com/ sayfasına gidiniz.
    //    Jewellery -> Neckless -> Bib Neckless click
    //    tıklatma işleminden sonra URL de
    //    bib-necklaces kelimesinin geçtiğini doğrulayın.

    @Test
    public void test1(){

        driver.get("https://www.etsy.com/");

        // Sayfa açılmadan önce "çerezleri kabul et" sayfası açılmış olsaydı;
//        List<WebElement> cookiesAccept = driver.findElements(By.cssSelector("..."));
//        if (cookiesAccept.size()>0) // varsa
//            cookiesAccept.get(0).click(); // kapat

        WebElement mucevher = driver.findElement(By.id("catnav-primary-link-10855"));
        WebElement kolye    = driver.findElement(By.id("side-nav-category-link-10873"));
        WebElement bibKolye = driver.findElement(By.id("catnav-l3-10881"));

        Actions aksiyonlar = new Actions(driver);

        // Mouse hareketlerinin javanın hızıyla uyumlu gitmemiz için araya "bekle" komutları koyuyoruz.
        // Aksi takdirde hata verir.
        // yarın ki derste tek tek "bekle" demek yerine "görünene kadar bekle" diye sabit bir komut vereceğiz.

        aksiyonlar.moveToElement(mucevher).build().perform();
        MyFunc.Bekle(2);
        aksiyonlar.moveToElement(kolye).build().perform();
        MyFunc.Bekle(2);
        aksiyonlar.moveToElement(bibKolye).click().build().perform();
        MyFunc.Bekle(2);

        System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());

    //    WebElement bibNecklaces= driver.findElement(By.cssSelector("[class='wt-text-heading-01 wt-display-inline wt-mb-xs-2 wt-overflow-hidden']"));

        Assert.assertTrue(driver.getCurrentUrl().contains("bib-necklaces")); // beklentiyi yazıyorum, hata varsa söyle

        BekleKapat();
    }
}
