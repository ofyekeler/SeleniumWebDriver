package Odev.Odev_2023_02_22_CSS;

import Utility.BaseDriver_SikKullanilanlar;
import Utility.MyFunc;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/*
    Bu websitesine gidiniz. [https://testpages.herokuapp.com/styled/index.html]
    Calculate'e tıklayınız.
    İlk input'a herhangi bir sayı giriniz.
    İkinci input'a herhangi bir sayı giriniz.
    Calculate button'una tıklayınız.
    Sonucu alınız.
    Sonucu yazdırınız.
*/
public class Odev04 extends BaseDriver_SikKullanilanlar {

    @Test
    public void test4(){

        driver.get("https://testpages.herokuapp.com/styled/index.html");

        WebElement cl=driver.findElement(By.cssSelector("a[href=\"/calculate.php\"]"));
        cl.click();

        WebElement n1=driver.findElement(By.cssSelector("form[action='calculate.php']>:nth-child(1)"));
        n1.sendKeys("20");
        MyFunc.Bekle(2);

        WebElement n2=driver.findElement(By.cssSelector("form[action='calculate.php']>:nth-child(3)"));
        n2.sendKeys("20");
        MyFunc.Bekle(2);

        WebElement sbmt=driver.findElement(By.cssSelector("input[type='submit']"));
        sbmt.click();
        MyFunc.Bekle(2);

        WebElement rslt=driver.findElement(By.cssSelector("[id='answer']"));
        System.out.println("Sonuç = "+rslt.getText());
        BekleKapat();
    }
}
