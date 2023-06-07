package Gun09;

import Utility.BaseDriver_SikKullanilanlar;
import Utility.MyFunc;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class _06_ActionRightClickTest extends BaseDriver_SikKullanilanlar {

    @Test
    public void Test1() {
        driver.get("https://demoqa.com/buttons");

        WebElement element = driver.findElement(By.id("rightClickBtn"));
        MyFunc.Bekle(2);

        Actions aksiyonlar = new Actions(driver);
        Action aksiyon=aksiyonlar.moveToElement(element).contextClick().build(); // contextClick=rightClick
        aksiyon.perform();

       // aksiyonlar.moveToElement(element).contextClick().build().perform();
       /* en kısa yazılış hali -> */    // new Actions(driver).contextClick(element).build().perform();

        BekleKapat();
    }
}
