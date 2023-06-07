package Odev.Odev_2023_02_22_CSS;

import Utility.BaseDriver_SikKullanilanlar;
import Utility.MyFunc;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/*
1) Bu siteye gidin. -> https://demo.applitools.com/
2) Username kısmına "ttechno@gmail.com" girin.
3) Password kısmına "techno123." girin.
4) "Sign in" buttonunan tıklayınız.
5) "Your nearest branch closes in: 30m 5s" yazısının göründüğünü doğrulayınız.
*/
public class Odev02 extends BaseDriver_SikKullanilanlar {
    @Test
    public void test2(){

        driver.get("https://demo.applitools.com/");

        WebElement usr=driver.findElement(By.cssSelector("input[type='text']"));
        usr.sendKeys("ttechno@gmail.com");
        MyFunc.Bekle(1);

        WebElement pass=driver.findElement(By.cssSelector("div[class='form-group']+div>:nth-child(2)"));
        pass.sendKeys("techno123.");
        MyFunc.Bekle(1);

        WebElement sbmt=driver.findElement(By.cssSelector("div[class='buttons-w']>:nth-child(1)"));
        sbmt.click();
        MyFunc.Bekle(1);

        WebElement tx=driver.findElement(By.cssSelector("[style='text-align: center;font-size: x-large;color:red']"));
        if (tx.getText().contains("Your nearest branch")){
            System.out.println("Sign success");
        }
        else {
            System.out.println("Fail");
        }
        BekleKapat();
    }
}
