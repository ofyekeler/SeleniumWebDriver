package Gun05;

import Utility.BaseDriver_SikKullanilanlar;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class _01_FindingElements_tag extends BaseDriver_SikKullanilanlar {
    public static void main(String[] args) {

        driver.get("https://www.hepsiburada.com/");

        List<WebElement> linkler = driver.findElements(By.tagName("a")); // a tag iyle başlayan tüm elemanları bulacağız
        // verilen tag lerdeki tüm elemanları aldık

        for (WebElement e : linkler) {
            if (e.getText().isEmpty()) { // ekranda gözükmeyen (işe yaramayan/boş olan) link leri bulmak için
                System.out.print("e.getAttribute(\"href\") = " + e.getAttribute("href"));
                System.out.print("e.getAttribute(\"title\") = " + e.getAttribute("title"));
                System.out.println("e.getAttribute(\"rel\") = " + e.getAttribute("rel"));
            }
        }

        BekleKapat();
    }
}
