package MentoringDersleri.Mentoring_03;
import Utility.BaseDriver_SikKullanilanlar;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import java.util.List;

public class Task3 extends BaseDriver_SikKullanilanlar {
/*
1. Perform Click Action on the Web Element -->    https://www.browserstack.com/
    Test Scenario:
    Browserstack home page sayfasina gidin ve Get Started Free butonuna tiklayin.
*/
    @Test
    public void senaryo1() {
        driver.get("https://www.browserstack.com/");
        Actions action = new Actions(driver);
        WebElement element = driver.findElement(By.linkText("Get started free"));
        action.moveToElement(element).click().build().perform();
    }
/*
2. Perform Mouse Hover Action on the Web Element
    Test Scenario:
    Mouse ile Live Tab uzerinde Hover yapin ve App Automate 'e  Click yapin.
*/
    @Test
    public void senaryo2() throws InterruptedException {
        driver.get("https://www.browserstack.com/");
        ((JavascriptExecutor) driver).executeScript("scroll(0,300)");
        Actions ac = new Actions(driver);
        WebElement live = driver.findElement(By.cssSelector("div.product-cards-wrapper--click a[title='Live']"));
        ac.moveToElement(live).build().perform();
        Thread.sleep(3000);
        WebElement automate = driver.findElement(By.cssSelector("div.product-cards-wrapper--click a[title='App Automate']"));
        automate.click();

    }
/*
3. Perform Double Click Action on the Web Element
    Test Scenario:
    Free Trial butonunun ustune double click yapin.
*/
    @Test
    public void senaryo3() {
        driver.get("https://www.browserstack.com/");
        Actions actions = new Actions(driver);
        WebElement trialaction = driver.findElement(By.xpath("//a[@id='free-trial-link-anchor']"));
        actions.doubleClick(trialaction).perform();
    }
/*
4.Drag and Drop
     https://www.globalsqa.com/demo-site/draganddrop/ sitesine gidiniz.
     resimleri yandaki alana goturup birakiniz.
*/
    @Test
    public void senaryo4() throws InterruptedException {
        String URL = "https://www.globalsqa.com/demo-site/draganddrop/";
        driver.get(URL);
        WebElement iframe = driver.findElement(By.xpath("//iframe[@class=\"demo-frame lazyloaded\"]"));
        driver.switchTo().frame(iframe);
        List<WebElement> images = driver.findElements(By.xpath("//li[@class=\"ui-widget-content ui-corner-tr ui-draggable ui-draggable-handle\"]"));
        WebElement trash = driver.findElement(By.xpath("//div[@id=\"trash\"]"));
        for (WebElement image : images) {
            Actions builder = new Actions(driver);
            builder.dragAndDrop(image, trash).build().perform();
            Thread.sleep(2000);
        }
        BekleKapat();
    }
}
