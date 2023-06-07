package Gun13;

import Utility.BaseDriver_SikKullanilanlar;
import Utility.MyFunc;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class _03_ScrollToWebElement extends BaseDriver_SikKullanilanlar {

    @Test
    public void Test1() {
        driver.manage().deleteAllCookies(); // cookies leri sildik. accept her zaman çıksın diye
        driver.get("https://www.copado.com/robotic-testing");

        MyFunc.Bekle(2);
        JavascriptExecutor js= (JavascriptExecutor)driver;

        WebElement element=driver.findElement(By.xpath("//a[text()='Read story']"));
                                                            // READ STORY e gittik
        js.executeScript("arguments[0].scrollIntoView(true);", element);  // elemente kadar kaydır,

        //element.click();  tıklatma özelliğini kaybettiren elemntlerin altında olduğunda tıklanamaz.
                            // accept navbar ı üstte kaldığı için tıklatamamıştım.
        js.executeScript("arguments[0].click();", element); // html içinden elemente ulaşır ve tıklatır

        MyFunc.Bekle(2);
        BekleKapat();
    }

}
