package Gun05;

import Utility.BaseDriver_SikKullanilanlar;
import Utility.MyFunc;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class _02_Navigating extends BaseDriver_SikKullanilanlar {
    public static void main(String[] args) {

        driver.navigate().to("https://testpages.herokuapp.com/styled/index.html");
        // navigate().to   yerine "get" de yazılabilirdi.

        MyFunc.Bekle(2);

        WebElement element= driver.findElement(By.id("alerttest"));
        // WebElement element= driver.findElement(By.linkText("Alerts (JavaScript)"));

        element.click(); // "Alerts (JavaScript)" sayfasına gittik
        MyFunc.Bekle(2);

        System.out.println(driver.getCurrentUrl()); // o anda bulunduğun URL yi verir.

        driver.navigate().back(); // tarayıcı history isinden geri geldim
        MyFunc.Bekle(2);

        System.out.println(driver.getCurrentUrl());

        driver.navigate().forward(); // tarayıcı history isinden ileri gittim.
        MyFunc.Bekle(2);

        System.out.println(driver.getCurrentUrl());

        BekleKapat();
    }
}
