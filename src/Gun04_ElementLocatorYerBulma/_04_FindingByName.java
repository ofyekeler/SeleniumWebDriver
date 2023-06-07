package Gun04_ElementLocatorYerBulma;

import Utility.MyFunc;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class _04_FindingByName {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://form.jotform.com/221934510376353");

        WebElement ad = driver.findElement(By.name("q8_name[first]")); // elemanı NAME ile bulma
        ad.sendKeys("faruk");

        MyFunc.Bekle(2);
        driver.quit();
    }
}
