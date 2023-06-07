package Gun12;

/*
   Senaryo :
   https://chercher.tech/practice/frames sitesine gidiniz
   Ekranda gözüken ilk kutucuğa Türkiye yazınız.
   Daha sonra animals dan seçeneklerinden avatar ı seçiniz.
 */

import Utility.BaseDriver_SikKullanilanlar;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class _02_IFramelerGecis extends BaseDriver_SikKullanilanlar {

    @Test
    public void Test1() {
        driver.get("https://chercher.tech/practice/frames");

        driver.switchTo().frame(0); // kod sırasına göre ilk (0.) frame geçtim.

        // //b[@id='topic']/following-sibling::input
        // b[id='topic']~input
        // #topic+input
        WebElement input=driver.findElement(By.cssSelector("#topic+input"));
        input.sendKeys("Türkiye");

        driver.switchTo().defaultContent();  // ana sayfaya geri döndüm
       // driver.switchTo().parentFrame(); // aynı işlemi yapar çünkü 1 kademe içeri girmiştim.

        driver.switchTo().frame(1); // 2.frma geçtim
        WebElement webSelect=driver.findElement(By.id("animals")); // select le başlıyor
        Select nesneSelect=new Select(webSelect);
        nesneSelect.selectByVisibleText("Avatar");

        BekleKapat();
    }
}
