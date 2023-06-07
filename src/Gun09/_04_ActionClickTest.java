package Gun09;

import Utility.BaseDriver_SikKullanilanlar;
import Utility.MyFunc;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class _04_ActionClickTest extends BaseDriver_SikKullanilanlar {

    @Test
    public void test1(){

        driver.get("https://demoqa.com/buttons");
        WebElement element=driver.findElement(By.xpath("//button[text()='Click Me']"));
        //element.click();  bu şekilde değil de aşağıdaki gibi aksiyonlar üzerinden click yapalım.

/**/    Actions aksiyonlar=new Actions(driver); // driver üzerinden web sayfası aksiyonlara açıldı.

        // aksiyonlar.moveToElement(element).click().build().perform();  diye aşağıdaki işlemi buradaki gibi
                                                                              // tek işleme de düşürebiliriz.
/**/    Action aksiyon= aksiyonlar.moveToElement(element).click().build();
        // elementin üzerin click için git orda bekle. Aksiyonu hazırla.
        System.out.println("Aksiyon hazırlandı");


        MyFunc.Bekle(4);
/**/    aksiyon.perform(); // aksiyonu gerçekleştir. , işleme al, uygula, icra et
        System.out.println("aksiyon gerçekleştir.");

        BekleKapat();

    }
}
