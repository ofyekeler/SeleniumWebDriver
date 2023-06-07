package MentoringDersleri.Mentoring_06;

import Utility.BaseDriver_SikKullanilanlar;
import Utility.MyFunc;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;


public class TC06 extends BaseDriver_SikKullanilanlar {

    @Test
    public void scrollDownUp()
    {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        WebElement user = driver.findElement(By.cssSelector("[name='username']"));
        WebElement pass = driver.findElement(By.cssSelector("[name='password']"));
        WebElement login= driver.findElement(By.cssSelector("[type='submit']"));
        user.sendKeys("Admin");
        pass.sendKeys("admin123");
        login.click();

        WebElement topBar = driver.findElement(By.cssSelector("[class='oxd-topbar']"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(topBar));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        MyFunc.Bekle(3);
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        MyFunc.Bekle(4);
        js.executeScript("window.scrollTo(document.body.scrollHeight,0)");
        MyFunc.Bekle(3);
        BekleKapat();
    }

    @Test
    public void scrollElement()
    {
        driver.get("https://www.lambdatest.com/");
        WebElement ready = driver.findElement(By.xpath("//*[text()='Ready to Get Started?']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();",ready);
        System.out.println(ready.getLocation());
    }
    //(77, 7062)

    @Test
    public void scrollToLoc()
    {
        driver.get("https://www.lambdatest.com/");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scroll(77,7011)");
    }

    @Test
    public void scrollHor()
    {
        driver.get("https://www.album.alexflueras.ro/index.php");
        WebElement kedicik1 = driver.findElement(By.id("a7"));
        WebElement kedicik2 = driver.findElement(By.id("a14"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();",kedicik1);
        MyFunc.Bekle(2);
        js.executeScript("arguments[0].scrollIntoView();",kedicik2);
    }

    @Test
    public void dynamicScroll()
    {
        driver.get("https://the-internet.herokuapp.com/infinite_scroll");
        ArrayList<String> arrayList = new ArrayList<>();
        WebElement texts;
        JavascriptExecutor js = (JavascriptExecutor) driver;

        int i=1;
        while (i<11)
        {
            texts = driver.findElement(By.xpath("(//*[@class='jscroll-added'])["+i+"]"));
            arrayList.add(i-1,texts.getText());
            MyFunc.Bekle(1);
            js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
            i++;
        }

        for (int j = 0; j < arrayList.size(); j++) {
            System.out.println(j+1+".Paragraf : " + arrayList.get(j));
        }
        BekleKapat();
    }
}