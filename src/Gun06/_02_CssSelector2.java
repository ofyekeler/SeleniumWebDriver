package Gun06;

import Utility.BaseDriver_SikKullanilanlar;
import org.junit.Test;  // @Test yazdığımızda geliyor
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.junit.Assert; // test için kullanılan lib. junit: java birim test kütüphanesi
                         // geliştirilmiş hali: testNG yani new generation. Çünkü junit yetmiyor.

public class _02_CssSelector2 extends BaseDriver_SikKullanilanlar {
    //public static void main(String[] args) // Assert sonrası main i kaldırdık

    @Test
    public void Test1()   // main yerine bunu yazdık ve üstüne @Test yazarak "sen testsin" dedik.
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

        // if (msg.getText().equals(mesajim))
        //     System.out.println("test passed");
        // else
        //     System.out.println("test fail");

        Assert.assertTrue("aranılan mesaj bulunamadı", msg.getText().equals(mesajim)); // verilen değer true mu?
        // Hata yok ise yani içindeki değer TRUE ise hiç bilgi vermez.
/*
java.lang.AssertionError: aranılan mesaj bulunamadı   "eğer mesajım+1" deyip bilerek hatalı gönderirsek...
*/
        BekleKapat();

        // facebook gibi sitelerde her pc de farklı id no görünebiliyor. Bu sorunu çözmek için;
        // Startwith, Endingwith, Containing ile Arama
        // [id^='u_']  ->  id si    "u_" ile başlayan -> startwith
        // [id*='u_']  ->  id sinde "u_" geçen        -> contains
        // [id$='u_']  ->  id si    "u_" ile biten    -> endwith

        /* Locator unu direk bulamayacağımız durumlar olacak. Dolaylı olarak bulacağız.

          <div>     cocukları: span, span, div
                    tumcocukları (cocuk + torun): span, span, div, img, input (yani tüm alt elemanları)

             <span> merhaba 1 </span>  -> çocuğu
             <span> merhaba 2 </span>

             <div>                     -> çocuk
                <img src=logo.png>     -> torunu
                <input type="text">
             </div>
          </div>                       -> Kardeşi
          <label>merhaba</label> -kardeşi
          <h2>merhaba</h2>       -diğer kardeşi
          kardeş    -> bitişik kardeş anlayacağız.
          kardeşler -> tüm kardeşleri anlayacağız.
        */

        /*
        ÖRNEK:
        div[id='user-message'] > label   ->  label den önce ">" işaretiyle "çocuğu" demiş oldum.
        yani; id si user-message olan DIV in çocuklarından label olan, demiş olduk.

        div[id='user-message'] > label + span    ->  span dan önce "+" diyerek label in bitişik kardeşini,
                                                     id nin ise 2. çocuğunu göstermiş oldum.
        yani; çocuklarından "span" olan, demiş olduk.

        div[id='user-message'] label   -> label den önce " " yani BOŞLUK bırakarak ""tüm çocukları (çocuk+torun)
                                          demiş oldum.
                                          torunlarına ulaşmak için bu yöntemi kullanırız.
        yani; id si get-input olan elemanın bütün çocuklarındaki ilk input olan, demiş oldum.

        >      -> çocuklarında
        space  -> çocuk + torun
        +      -> bitişik kardeş
        ~      -> tüm kardeşlerde
        >*     -> tüm çocuklar (içindekilerin hepsini bulur, torunlar YOK !!!)

        bazen üçüncü kardeşe gitmek için;
        [class='nav navbar-nav'] > li+li+li    yazmak uğraştırabiliyor. Bunun yerine;

        >:nth-child(3)       -> diyerek İLK 3. çocuğu bulabiliyorum.   (çocuk sayısı çok olan element lerde daha kolay)
        >:nth-last-child(3)  -> diyerek de SONdan 3. çocuğu bulabiliyorum.
        */
    }
}
