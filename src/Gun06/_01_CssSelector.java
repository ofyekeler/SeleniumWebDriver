package Gun06;

import Utility.BaseDriver_SikKullanilanlar;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class _01_CssSelector extends BaseDriver_SikKullanilanlar {
    // HTML de;
    // [id='... ... ...'] veya [type='... ... ...'] yazarsan direk id ve type i "..." olanları bulur.
    // İhtimalleri düşürmek hatta bire indirebilmek için aynı anda da kullanabilirsin.
    // [id='user-massage'][type='text'] gibi.
    // veya "div[id='user-message']" şeklinde de kullabilirsin. Başında "div" olan id leri bulur.
    // # sadece id lerde . (nokta) ise class larda kullanılır.
    // div[id='user-message'] ı aynı zamanda div#user-massage olarak da aratabilirim.

    public static void main(String[] args)
    {
        // 1-Açılan sayfadaki kutucuğa mesajınızı yazını.
        // 2-Butona tıklatınız
        // 3-Butona basıldığında mesajınızın sayfada göründüğünü test ediniz.

        driver.get("https://demo.seleniumeasy.com/basic-first-form-demo.html");

        String mesajim = "merhaba selenium";
        WebElement txtBox = driver.findElement(By.cssSelector("input[id='user-message']"));
        txtBox.sendKeys(mesajim);

        WebElement btn = driver.findElement(By.cssSelector("[onclick='showInput();']"));
        btn.click();

        WebElement msg = driver.findElement(By.cssSelector("[id='display']"));

        String kutuIcındekiYazi = txtBox.getAttribute("value");  // Bunu 7. gün xpath dersinde ekledik.
        System.out.println(kutuIcındekiYazi);

        if (msg.getText().equals(mesajim))
            System.out.println("test passed");
        else
            System.out.println("test fail");

        BekleKapat();

    }
}
