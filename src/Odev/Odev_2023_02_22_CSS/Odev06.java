package Odev.Odev_2023_02_22_CSS;

import Utility.BaseDriver_SikKullanilanlar;
import Utility.MyFunc;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/*
    Bu siteye gidiniz. https://testpages.herokuapp.com/styled/index.html
    Fake Alerts'e tıklayınız.
    Show modal dialog buttonuna tıklayınız.
    Ok'a tıklayınız.
    Alert kapanmalıdır.
*/
public class Odev06 extends BaseDriver_SikKullanilanlar {
    @Test
    public void test6(){

        driver.get("https://testpages.herokuapp.com/styled/index.html");
        WebElement fakeAlert=driver.findElement(By.cssSelector("[href='alerts/fake-alert-test.html']"));
        fakeAlert.click();
        MyFunc.Bekle(2);

        WebElement showModal=driver.findElement(By.cssSelector("[onclick='show_modal()']"));
        showModal.click();
        MyFunc.Bekle(1);

        WebElement ok=driver.findElement(By.cssSelector("div[class='dialog-actions']>:nth-child(1)"));
        ok.click();

        BekleKapat();
    }
}
