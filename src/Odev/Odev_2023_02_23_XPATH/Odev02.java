package Odev.Odev_2023_02_23_XPATH;

import Utility.BaseDriver_SikKullanilanlar;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Odev02 extends BaseDriver_SikKullanilanlar {
    /*
        1) Bu siteye gidin. -> https://demo.applitools.com/
        2) Username kısmına "ttechno@gmail.com" girin.
        3) Password kısmına "techno123." girin.
        4) "Sign in" buttonunan tıklayınız.
        5) "Your nearest branch closes in: 30m 5s" yazısının göründüğünü doğrulayınız.
    */
    @Test
    public void test2(){

        driver.get("https://demo.applitools.com");
        WebElement userName = driver.findElement(By.id("username"));
        userName.sendKeys("ttechno@gmail.com");

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("techno123.");

        WebElement signIn = driver.findElement(By.id("log-in"));
        signIn.click();

        WebElement text = driver.findElement(By.xpath("//*[contains(text(),'Your nearest branch closes in: 30m 5s']"));
        Assert.assertTrue("Kayıt oluşturulamadı",text.getText().contains("Your nearest branch closes in: 30m 5s"));

        BekleKapat();
    }
}
