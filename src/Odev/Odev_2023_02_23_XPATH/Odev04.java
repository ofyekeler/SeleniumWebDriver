package Odev.Odev_2023_02_23_XPATH;

import Utility.BaseDriver_SikKullanilanlar;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Odev04 extends BaseDriver_SikKullanilanlar {
    /*
    Bu websitesine gidiniz. [https://testpages.herokuapp.com/styled/index.html]
    Calculate'e tıklayınız.
    İlk input'a herhangi bir sayı giriniz.
    İkinci input'a herhangi bir sayı giriniz.
    Calculate button'una tıklayınız.
    Sonucu alınız.
    Sonucu yazdırınız.
    */
    @Test
    public void test4(){

        driver.get("https://testpages.herokuapp.com/styled/index.html");
        WebElement calculator = driver.findElement(By.id("calculatetest"));
        calculator.click();

        WebElement input1 = driver.findElement(By.id("number1"));
        input1.sendKeys("5");

        WebElement input2 = driver.findElement(By.id("number2"));
        input2.sendKeys("8");

        WebElement calculate = driver.findElement(By.id("calculate"));
        calculate.click();

        WebElement text = driver.findElement(By.cssSelector("[id='answer']"));
        Assert.assertTrue("Kayıt oluşturulamadı",text.getText().equals("13"));

        BekleKapat();
    }
}
