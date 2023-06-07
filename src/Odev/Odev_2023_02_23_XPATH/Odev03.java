package Odev.Odev_2023_02_23_XPATH;

import Utility.BaseDriver_SikKullanilanlar;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Odev03 extends BaseDriver_SikKullanilanlar {
    /*
    1) Bu siteye gidin. -> https://www.snapdeal.com/
    2) "teddy bear" aratın ve Search butonuna tıklayın.
    3) Bu yazının göründüğünü doğrulayınız. -> (We've got 297 results for 'teddy bear')

    Not: Bu yazıdaki sayı değişiklik gösterebilir. Önemli olan cümle kalıbı.

*/
    @Test
    public void test3(){

        driver.get("https://www.snapdeal.com");
        WebElement searchText = driver.findElement(By.id("inputValEnter"));
        searchText.sendKeys("teddy bear");

        WebElement search = driver.findElement(By.cssSelector("span[class='searchTextSpan']"));
        search.click();

        WebElement text = driver.findElement(By.xpath("//*[contains(text(), 'results for teddy bear')]"));
        Assert.assertTrue("Kayıt oluşturulamadı",text.getText().contains("results for teddy bear"));

        BekleKapat();
    }
}
