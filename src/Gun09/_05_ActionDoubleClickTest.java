package Gun09;

import Utility.BaseDriver_SikKullanilanlar;
import Utility.MyFunc;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class _05_ActionDoubleClickTest extends BaseDriver_SikKullanilanlar {

    @Test
    public void Test1() {
        driver.get("https://demoqa.com/buttons");

        WebElement element=driver.findElement(By.id("doubleClickBtn"));
        MyFunc.Bekle(2);

        Actions aksiyonlar=new Actions(driver);
        Action aksiyon= aksiyonlar.moveToElement(element).doubleClick().build();
        aksiyon.perform();

        // aksiyonlar.doubleClick(element).build().perform();
        // aksiyonlar.moveToElement(element).doubleClick().build().perform();
        BekleKapat();
    }

}
