package Odev.Odev_2023_02_22_CSS;

import Utility.BaseDriver_SikKullanilanlar;
import Utility.MyFunc;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/*
  1) Bu siteye gidin. -> http://demoqa.com/text-box
  2) Full Name kısmına "Automation" girin.
  3) Email kısmına "Testing@gmail.com" girin.
  4) Current Address kısmına "Testing Current Address" girin.
  5) Permanent Address kısmına "Testing Permanent Address" girin.
  6) Submit butonuna tıklayınız.
  7) Full Name'in, "Automation"ı içinde bulundurduğunu doğrulayın.
  8) Email'in, "Testing"ı içinde bulundurduğunu doğrulayın.
*/

public class Odev01 extends BaseDriver_SikKullanilanlar {

    @Test
    public void Test1(){
        driver.get("http://demoqa.com/text-box");
        MyFunc.Bekle(1);

        WebElement flnme=driver.findElement(By.cssSelector("input[type='text']"));
        flnme.sendKeys("Automation");
        MyFunc.Bekle(1);

        WebElement mail=driver.findElement(By.cssSelector("input[type='email']"));
        mail.sendKeys("Testing@test.com");
        MyFunc.Bekle(1);

        WebElement crrnt=driver.findElement(By.cssSelector("textarea[placeholder='Current Address']"));
        crrnt.sendKeys("Testing Current Address");
        MyFunc.Bekle(1);

        WebElement prmnt=driver.findElement(By.cssSelector("[id='permanentAddress-wrapper']>:nth-child(2)>:nth-child(1)"));
        prmnt.sendKeys("Testing Permanent Address");
        MyFunc.Bekle(1);

        WebElement sbmt=driver.findElement(By.cssSelector("[class='text-right col-md-2 col-sm-12']>:nth-child(1)"));
        sbmt.click();

        WebElement nme=driver.findElement(By.cssSelector("[class='border col-md-12 col-sm-12']>:nth-child(1)"));
        System.out.println(nme.getText().contains("Automation"));

        WebElement mail2=driver.findElement(By.cssSelector("[class='border col-md-12 col-sm-12']>:nth-child(2)"));
        System.out.println(mail2.getText().contains("Testing@test.com"));

        BekleKapat();
    }
}
