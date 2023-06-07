package Gun08;

import Utility.BaseDriver_SikKullanilanlar;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class _02_SelectClassGiris extends BaseDriver_SikKullanilanlar {

    @Test
    public void test1(){

        // mesela bir alışveriş sitesindeki açılan "Tüm Kategoriler" listesinden bir seçim yapalım.
        // 4. sırada "Elektronik" var mesela.

        driver.get("https://www.amazon.com.tr/");

        WebElement webMenu = driver.findElement(By.id("searchDropdownBox"));

        // bu element select tag i ile başlıyorsa, sen bunu SELECT e cast yap ve öyle kullan.

        Select ddMenu=new Select(webMenu); // elementi daha rahat kullanabilir SELECT nesnesi haline dönüştürdü.

        // 3 farklı şekilde seçebiliriz
        ddMenu.selectByIndex(4); // kategorideki sıra numarasıyla
       // ddMenu.selectByValue("search-alias=electronics");  // element de ki değer adıyla
       // ddMenu.selectByVisibleText("Elektronik");  // ekranda görünen şekliyle

        System.out.println("ddMenu.getOptions().size() = " + ddMenu.getOptions().size());

        BekleKapat();
    }
}
