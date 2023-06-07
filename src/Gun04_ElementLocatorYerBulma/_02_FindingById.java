package Gun04_ElementLocatorYerBulma;

import Utility.MyFunc;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class _02_FindingById {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://form.jotform.com/221934510376353"); // sayfaya gittim
                // ilgili functionality ye sağ click yap -> incele ye click yap
                // id no yu bul

        WebElement name = driver.findElement(By.id("first_8")); // elemanı ID ile bul
        name.sendKeys("faruk"); // kutucuklara yazı gönderme / tuş gönderme

        // inceleme ekranında ctrl-f arama ekranına  #first_8  yazarsak sadece id lerde arama yapar.
        // first_8   yazarsak tamamını arar.   "#" (diez, dz   olarak okunur)
        // ilgili id de birden fazla var mı yok mu kontrolü yaparız. Birden fazla bulursa ilk bulduğunu alır.
        WebElement surName = driver.findElement(By.id("last_8"));
        MyFunc.Bekle(2);
        surName.sendKeys("yekeler");
        MyFunc.Bekle(1);
        // name.clear();   // submitButtot.click() özelliğini kullabilmek için geçici olarak pasif ettik clear ları.
        // MyFunc.Bekle(1);
        // surName.clear();

        //*********************************

        WebElement labelFirstName= driver.findElement(By.id("sublabel_8_first")); // label ları yazdırma işlemleri
        System.out.println("labelFirstName.getText() = " + labelFirstName.getText());
        WebElement labelSurName= driver.findElement(By.id("sublabel_8_last"));
        System.out.println("labelSurName.getText() = " + labelSurName.getText());

/*
labelFirstName.getText() = First Name
  labelSurName.getText() = Last Name
*/
        WebElement submitButton= driver.findElement(By.id("input_2"));
        submitButton.click();

        MyFunc.Bekle(2);
        driver.quit();
    }
}
