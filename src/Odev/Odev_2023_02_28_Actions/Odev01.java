package Odev.Odev_2023_02_28_Actions;

import Utility.BaseDriver_SikKullanilanlar;
import Utility.MyFunc;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class Odev01 extends BaseDriver_SikKullanilanlar {
    /*
    http://dhtmlgoodies.com/scripts/drag-drop-quiz/drag-drop-quiz-d2.html
    buradaki ülke ve şehirleri findElements ile topluca bularak bir döngü ile bütün şehirleri doğru ülkere dağıtınız.
    */
    @Test
    public void test1(){
        driver.get("http://dhtmlgoodies.com/scripts/drag-drop-quiz/drag-drop-quiz-d2.html");

        Actions actions = new Actions(driver);
        List<WebElement> cities = driver.findElements(By.cssSelector("#answerDiv > .dragDropSmallBox"));

        for (WebElement city : cities) {
            String num = city.getAttribute("id");
            num = num.substring(1);

            String cssSelector = "#questionDiv > .dragDropSmallBox[id='q" + num + "']";
            WebElement targetBox = driver.findElement(By.cssSelector(cssSelector));

            actions.clickAndHold(city).perform();
            MyFunc.Bekle(1);
            actions.moveToElement(targetBox).release().perform();
        }
        BekleKapat();
    }
}
