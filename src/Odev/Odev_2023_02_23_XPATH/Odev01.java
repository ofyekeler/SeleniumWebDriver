package Odev.Odev_2023_02_23_XPATH;

import Utility.BaseDriver_SikKullanilanlar;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Odev01 extends BaseDriver_SikKullanilanlar {

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

    @Test
    public void Test1(){

        driver.get("http://demoqa.com/text-box");
        WebElement fullName = driver.findElement(By.id("userName"));
        fullName.sendKeys("Automation");

        WebElement eMail = driver.findElement(By.id("userEmail"));
        eMail.sendKeys("Testing@gmail.com");

        WebElement currentAddress = driver.findElement(By.id("currentAddress"));
        currentAddress.sendKeys("Testing Current Address");

        WebElement permanentAddress = driver.findElement(By.id("permanentAddress"));
        permanentAddress.sendKeys("Testing Permanent Address");

        WebElement submit = driver.findElement(By.id("submit"));
        submit.click();

        WebElement textName = driver.findElement(By.xpath("//*[@id='name']"));
        Assert.assertTrue("Kayıt oluşturulamadı",textName.getText().contains("Automation"));

        WebElement textMail = driver.findElement(By.xpath("//*[@id='email']"));
        Assert.assertTrue("Kayıt oluşturulamadı",textMail.getText().contains("Testing@gmail.com"));

        BekleKapat();
    }
}
