package Gun04_ElementLocatorYerBulma;

import Utility.MyFunc;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class _05_FindingByClass {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://form.jotform.com/221934510376353");

        WebElement adClass = driver.findElement(By.className("form-textbox")); // elemanı CLASS ile bulma
        // html de aralarında boşluk olan birden fazla class vardı. (form-textbox validate[required])
        // Biz bir tanesini aldık.

        // birden fazla aynı locator a sahip eleman bulursa findElement ne yapar ?
        // cevap : ilk element i bulur

        // html de ctrl+f araması yaparken sadece CLASS arması yaparken başına nokta (.) koyuyoruz.
        // Example: ".form-textbox"

        adClass.sendKeys("faruk");

        List<WebElement> labels = driver.findElements(By.className("form-sub-label"));
        System.out.println(labels.size());

        for (WebElement e : labels) {
            System.out.println("e.getText() = " + e.getText());
        }

        // aranılan eleman bulunamazsa : findElement NoSuchElement hatası verir
        // FindElements is size ı 0 olan List verir, yani hata vermez.

        MyFunc.Bekle(2);
        driver.quit();
    }
}
