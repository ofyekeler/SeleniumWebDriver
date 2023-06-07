package Gun13;

import Utility.BaseDriver_SikKullanilanlar;
import Utility.MyFunc;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

/*
    Selenium da Sayfayı aşağı kaydırılması gereken durumlar vardır:
    Bunlar , sayfa kaydırıldıkça yüklenen elemanlar için

    Bu işlem javascriptexecuter ile yapılır.Bu interface sayesinde
    sayfa kaydırma işlemi ve javascript komutları çalıştırılabilir
    sayfa üzerinde.

                         ("window.scrollTo(0, 3000);")    -> Verilen pixel e kadar gider.
                         ("window.scrollBy(0, 3000);")    -> bulunduğu yerden , Verilen kadar daha ileri gider.
    ("window.scrollTo(0, document.body.scrollHeight);")   -> sayfanın sonuna kadar gider.
    ("arguments[0].scrollIntoView(true);", element)       -> Verilen elemente kadar gider.
                                                   true : element sayfanın üstünde gözükene kadar,
                                                   false: element sayfanın altına gözükene kadar
                                                   default true;

                         element.click() -> normal click
                         action click()  -> action click
   ("arguments[0].click();", element)    -> javascript click()  -> javascript click.
*/

public class _01_Scrollintro extends BaseDriver_SikKullanilanlar {

    @Test
    public void Test1()
    {
        driver.get("https://p-del.co/");
        MyFunc.Bekle(2);

//        Actions aksiyonlar=new Actions(driver);  // driver üzerinden Aksiyon işlemleri için
//        Select webSelect=new Select(element); // bir tane element için

        // JavaScript komutlarını çalıştırmak için önce js değişkeni tanımlandı.
        JavascriptExecutor js= (JavascriptExecutor) driver; // cast yapıldı (Java Scrpit çalıştırıcısı)

        js.executeScript("window.scrollBy(0,3000)"); // yanında birden fazla olunca araya ; koyulur.
        // (0,1500) -> (x,y) Sayfayı sağa x kadar ve aşağı y kaydırır
        // 1500 pixel kadar aşağı kaydıracak.

        MyFunc.Bekle(2);

        js.executeScript("window.scrollBy(0,-3000)");

        BekleKapat();
    }
}
