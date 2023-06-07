package Gun12;

import Utility.BaseDriver_SikKullanilanlar;
import Utility.MyFunc;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Set;

public class _04_WindowsGiris extends BaseDriver_SikKullanilanlar {

    @Test
    public void Test1() {
        driver.get("https://www.selenium.dev/");

        // şu aşamada ana sayfadayım
        // bulunulan windowid yi almak için
        String anasayfaWindowID= driver.getWindowHandle();
        System.out.println("anasayfaWindowID = " + anasayfaWindowID);

        List<WebElement> linkler= driver.findElements(By.cssSelector("a[target='_blank']"));
        // ilgili web sitesindeki tüm liklerde ortak yer alan "a[target='_blank']" elementini kullandım.
        // Mail ler hariç tutarak (Bunu da asağıdaki foreach döngüsüyle sağladım) tamamını sırasıyla açtım.
        // Set foreach döngüsüyle de açılan tüm sayfaların WindowId lerini yazdırdım.

        for(WebElement link: linkler)
            if (!link.getAttribute("href").contains("mail"))
               link.click();
        // şu aşamada bütün sayfalar açıldı

        Set<String> windowsIdler= driver.getWindowHandles(); // Handles'i "Set String" olarak istiyor.
        for(String id: windowsIdler)
            System.out.println("id = " + id);

        // şu anda en son açılan sayfadayım ana sayfaya geçmek için
        driver.switchTo().window(anasayfaWindowID); // ana sayfaya geçtim

        MyFunc.Bekle(10);
        BekleKapat();
    }
}
