package Gun14;

import Utility.BaseDriver_SikKullanilanlar;
import Utility.MyFunc;
import org.junit.Test;
import org.openqa.selenium.Dimension;

import java.awt.*;

public class _02_WindowsSize extends BaseDriver_SikKullanilanlar {
    @Test
    public void test1(){

        driver.get("https://www.youtube.com/");

        // 1. Aşama: ekranı tam ekran yaptım.
        driver.manage().window().maximize();
        MyFunc.Bekle(2);

        // 2. Aşama: ekranı yeniden boyutlandırdım.
        Dimension yeniBoyut = new Dimension(516,600); // Dimension'u selenium seçiyorum, Java değil !!!
        driver.manage().window().setSize(yeniBoyut);

        BekleKapat();
    }
}
