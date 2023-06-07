package Gun09;

import Utility.BaseDriver_SikKullanilanlar;
import Utility.MyFunc;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_EXCLUSIONPeer;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class _02_Soru extends BaseDriver_SikKullanilanlar {

    //   Test Senaryosu
    //   1- https://www.facebook.com/  sayfasına gidiniz
    //   2- CreateNewAccount a tıklatınız.
    //   3- Açılan yeni pencerede isim, soyisim ve emaili giriniz.
    //   4- Doğum tarihinizi Select sınıfı ile seçiniz
    //   5- Email i tekrar girmenizi isteyen bir input daha açıldığını
    //      öncesinde de görünmediğini, sonrasında da göründüğünü
    //      assert ile doğrulayınız.

    @Test
    public void test1(){

        driver.get("https://www.facebook.com/");

        MyFunc.Bekle(1);

        WebElement btnYeniHesap= driver.findElement(By.linkText("Yeni hesap oluştur"));
        btnYeniHesap.click();

        MyFunc.Bekle(1);

        WebElement firstName= driver.findElement(By.name("firstname"));
        firstName.sendKeys("faruk");

        MyFunc.Bekle(1);

        WebElement lastName= driver.findElement(By.name("lastname"));
        lastName.sendKeys("ozturk");

        // ilk maili girmeden 2. mail kutucuğunun görünüp görünmediğini kontrol et.

        WebElement reEmail= driver.findElement(By.name("reg_email_confirmation__"));
        Assert.assertFalse(reEmail.isDisplayed()); // ilk maili henüz girmediğim için "false" yanıtını almayı bekliyorum.
        System.out.println("reEmail.isDisplayed() = " + reEmail.isDisplayed());

        MyFunc.Bekle(1);
        
        WebElement eMail= driver.findElement(By.name("reg_email__"));
        eMail.sendKeys("faruk@ozturk.com");

        WebElement reEmail2= driver.findElement(By.name("reg_email_confirmation__"));
        Assert.assertTrue("ReMail Görünmüyor",reEmail2.isDisplayed());
                                                           // ilk maili girdiğim için "true" yanıtını almayı bekliyorum.
        System.out.println("reEmail2.isDisplayed() = " + reEmail2.isDisplayed());

        MyFunc.Bekle(1);
        
        WebElement email2= driver.findElement(By.name("reg_email_confirmation__"));
        email2.sendKeys("faruk@ozturk.com");

        MyFunc.Bekle(1);

        WebElement password= driver.findElement(By.id("password_step_input"));
        password.sendKeys("1132465798");

        MyFunc.Bekle(1);

        // Gun08  _02_ konusu
        WebElement birthDay= driver.findElement(By.cssSelector("select[id=day]"));
        Select daysMenu=new Select(birthDay);
        daysMenu.selectByIndex(16);

        MyFunc.Bekle(1);

        WebElement birthMonth= driver.findElement(By.cssSelector("select[id=month]"));
        Select monthsMenu=new Select(birthMonth);
        monthsMenu.selectByVisibleText("Kas");

        MyFunc.Bekle(1);

        WebElement birthYear= driver.findElement(By.cssSelector("select[id=year]"));
        Select yearsMenu=new Select(birthYear);
        yearsMenu.selectByValue("1989");

        MyFunc.Bekle(1);

        WebElement gender= driver.findElement(By.cssSelector("[name=sex][value='2']"));
        gender.click();

        BekleKapat();

    }
}
