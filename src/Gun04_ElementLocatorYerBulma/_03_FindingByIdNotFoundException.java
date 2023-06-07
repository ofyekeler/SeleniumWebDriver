package Gun04_ElementLocatorYerBulma;

import Utility.MyFunc;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class _03_FindingByIdNotFoundException {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://form.jotform.com/221934510376353");

        try {
            WebElement laberFirstName = driver.findElement(By.id("hataliLocator"));
        }
        catch (Exception ex)
            {
            System.out.println("WebElement bulunamadı " + ex.getMessage());
            }
        MyFunc.Bekle(2);
        driver.quit();
    }
}
