package Odev.Odev_2023_02_22_CSS;

import Utility.BaseDriver_SikKullanilanlar;
import Utility.MyFunc;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/*
    Bu websitesine gidiniz. [https://testpages.herokuapp.com/styled/index.html]
    Fake Alerts' tıklayınız.
    Show Alert Box'a tıklayınız.
    Ok'a tıklayınız.
    Alert kapanmalıdır.
*/
public class Odev05 extends BaseDriver_SikKullanilanlar {
    @Test
    public void test5(){

        driver.get("https://testpages.herokuapp.com/styled/index.html");
        WebElement fakeAlert=driver.findElement(By.cssSelector("[href='alerts/fake-alert-test.html']"));
        fakeAlert.click();
        MyFunc.Bekle(2);

        WebElement showAlert=driver.findElement(By.cssSelector("[class='centered'] [type='button']"));
        showAlert.click();
        MyFunc.Bekle(2);

        WebElement ok=driver.findElement(By.cssSelector("div[class='dialog-actions']>:nth-child(1)"));
        ok.click();

        BekleKapat();
    }
}
