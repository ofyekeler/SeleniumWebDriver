package Gun09;

import Utility.BaseDriver_SikKullanilanlar;
import Utility.MyFunc;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class _09_DragAndDropBy extends BaseDriver_SikKullanilanlar {
    // Element ten element e değil de, mesafeye dayalı kaydırma yöntemi.

    @Test
    public void Test1() {
        driver.get("http://talkerscode.com/webtricks/demo/demo_price-range-slider-using-jquery-css-and-php.php");
        Actions aksiyonlar = new Actions(driver);

        WebElement solSurgu=driver.findElement(By.xpath("//div[@id='slider-range']/span[1]")); // span olan çocuklarından 1. si
        MyFunc.Bekle(3);

        Action aksiyon=aksiyonlar.dragAndDropBy(solSurgu, 100, 0).build(); // 100 birim ileri (sağa) kaydırdı
                                                                   // sola kaydırmak istersek değeri - (eksi) gireceğiz
        aksiyon.perform();

        BekleKapat();
    }

}
