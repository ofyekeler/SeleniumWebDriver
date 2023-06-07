package Gun09;

import Utility.BaseDriver_SikKullanilanlar;
import Utility.MyFunc;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class _07_ActionHoverTest extends BaseDriver_SikKullanilanlar {

    @Test
    public void Test1() {
        driver.get("https://www.hepsiburada.com/");

        WebElement element = driver.findElement(By.xpath("//span[text()='Moda']"));
        MyFunc.Bekle(2);

        Actions aksiyonlar = new Actions(driver);
        Action aksiyon = aksiyonlar.moveToElement(element).build(); // üzerine gelip bekledik. Click kullanmadık.
                                                                    // üzerine gelerek açılır pencerenin açılıp açılmadığını
                                                                    // kontrol etmiş olduk.
        aksiyon.perform();

        BekleKapat();
    }
}
