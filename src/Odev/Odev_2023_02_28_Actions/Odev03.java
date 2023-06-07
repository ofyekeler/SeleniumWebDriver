package Odev.Odev_2023_02_28_Actions;

import Utility.BaseDriver_SikKullanilanlar;
import Utility.MyFunc;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class Odev03 extends BaseDriver_SikKullanilanlar {
    /*
    http://dhtmlgoodies.com/scripts/drag-drop-nodes-quiz/drag-drop-nodes-quiz.html
         buradaki bütün şehirleri bütün ülkere doğru şekilde topluca dağıtınız.
    */
    @Test
    public void test3(){

        driver.get("http://dhtmlgoodies.com/scripts/drag-drop-nodes-quiz/drag-drop-nodes-quiz.html");

        Actions actions = new Actions(driver);

        List<WebElement> cities = driver.findElements(By.cssSelector("#allItems > *"));
        List<WebElement> countries = driver.findElements(By.cssSelector("#dhtmlgoodies_mainContainer > div"));

        for (WebElement city : cities) {
            actions.moveToElement(city, -30, 0).perform();
            actions.clickAndHold().perform();
            MyFunc.Bekle(1);
            for (WebElement country : countries) {
                actions.moveToElement(country).perform();

                if (!country.getAttribute("class").equals("mouseover"))
                    continue;

                actions.release().perform();
                MyFunc.Bekle(1);
                if (!city.getAttribute("class").equals("correctAnswer")) {
                    actions.moveToElement(city, -30, 0).perform();
                    actions.clickAndHold().perform();
                    MyFunc.Bekle(1);
                    continue;
                }
                break;
            }
        }
        BekleKapat();
    }
}
