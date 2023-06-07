package MentoringDersleri.Mentoring_04;

import Utility.BaseDriver_SikKullanilanlar;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Task04 extends BaseDriver_SikKullanilanlar {
/*
Task 1:
     "http://seleniumpractise.blogspot.in/2016/08/how-to-use-explicit-wait-in-selenium.html" sitesine gidiniz.
     Click me to start timer butonun atiklatiniz.
     wait kullanarak Selenium,QTP ve Webdriver yazilari gorulene kadar bekletiniz.
     Webdriver goruluyor mu dogrulugunu kontrol ediniz.
*/
    @Test
    public void test1(){
        driver.get("http://seleniumpractise.blogspot.com/2016/08/how-to-use-explicit-wait-in-selenium.html");

        WebElement button = driver.findElement(By.xpath("//*[text()='Click me to start timer']"));
        button.click();

        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='WebDriver']")));
        Assert.assertTrue(element.getText().contains("WebDriver"));
    }
/*
 Task 2:
        https://qatest.twoplugs.com/ sitesine gidiniz.
        What do I need to sign up?  sorusuna tiklatiniz.
        "You need a facebook account or a valid email address to sign up." texti gorulene kadar bekletiniz.
        Text gorunuyor mu dogrulayiniz.
*/
    @Test
    public void test2(){
        driver.get(" https://qatest.twoplugs.com/");

        WebElement element = driver.findElement(By.xpath("//span[text()='What do I need to sign up?']"));
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
     //   element.click();

        WebElement text = driver.findElement(By.xpath("//p[text()='You need a facebook account or a valid email address to sign up.']"));
        wait.until(ExpectedConditions.visibilityOf(text));

     //   Assert.assertEquals("You need a facebook account or a valid email address to sign up.", text.getText()); // 1.yontem
        Assert.assertTrue(text.isDisplayed());  // 2.yontem
    }
/*
 Task 3:
       https://google.com/  sitesine gidiniz.
       search kismina selenium gonderip Enter'a basiniz.
       Element tiklanabilir olana kadar bekletiniz.
       Sonuclar kismindan ilk sonucun selenium icerdigini kontrol ediniz.
*/
    @Test
    public void test3(){
        driver.get("https://www.google.com/");

        Actions actions = new Actions(driver);
        actions.sendKeys(driver.findElement(By.xpath("//*[@title='Ara']")), "selenium");
        actions.sendKeys(Keys.ENTER);
        actions.perform();

        WebElement text = driver.findElement(By.xpath("//h3[text()='Selenium']"));
        wait.until(ExpectedConditions.elementToBeClickable(text));

        Assert.assertEquals("Selenium", text.getText());
        BekleKapat();
    }
}
