package Gun13;

import Utility.BaseDriver_SikKullanilanlar;
import Utility.MyFunc;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;

public class _02_ScrollToBottomOfThePage extends BaseDriver_SikKullanilanlar {

    @Test
    public void Test1() {
        driver.get("https://p-del.co/");
        MyFunc.Bekle(2);

        JavascriptExecutor js=(JavascriptExecutor)driver;

        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        //sayfanın sonuna kadar kaydırır.
        MyFunc.Bekle(2);

        js.executeScript("window.scrollTo(0, 0);"); // en başa direk gidiyor 0 noktasına git.

        //js.executeScript("window.scrollBy(0, 0);");  // bulunduğu yerden 0 kadar gider. Yani bir yere gitmeyecek.

        BekleKapat();
    }
}
