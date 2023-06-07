package Gun10;

import Utility.BaseDriver_SikKullanilanlar;
import Utility.MyFunc;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class _03_YonTuslariSecim extends BaseDriver_SikKullanilanlar {

    @Test
    public void test1(){

        driver.get("https://demoqa.com/auto-complete");

        WebElement txtBox = driver.findElement(By.id("autoCompleteSingleInput"));

        Actions aksiyonlar = new Actions(driver);
        // element e git, içine tıklat, b tuşuna bas

        Action aksiyon = aksiyonlar.moveToElement(txtBox).click().sendKeys("b").build();
        aksiyon.perform();

        MyFunc.Bekle(2);

        // b tuşuna basınca açılan seçeneklerden bir alttakini seç.
        aksiyon = aksiyonlar.sendKeys(Keys.DOWN).sendKeys(Keys.ENTER).build(); // 2. bir aksiyon açmadan
                                                            // (Action aksiyon2=...) aynı aksiyon üzerinden devam ettim.
        aksiyon.perform();

        BekleKapat();
    }
}
