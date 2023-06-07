package Gun04_ElementLocatorYerBulma;

import Utility.MyFunc;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class _06_FindingByLinkText {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.hepsiburada.com/"); // sayfaya gittim

        //LinkText yoluyla eleman bulma işlemi sadece a (<a htef="... ..."> </a>) tag inde kullanılabilir.
        WebElement siparislerimLinki= driver.findElement(By.linkText("Siparişlerim"));
        // Gözüken text i Siparişlerim olan o tag ı webelement
        System.out.println("siparislerimLinki.getText() = " + siparislerimLinki.getText());

        System.out.println("siparislerimLinki.getAttribute(\"href\") = " + siparislerimLinki.getAttribute("href"));
        System.out.println("siparislerimLinki.getAttribute(\"title\") = " + siparislerimLinki.getAttribute("title"));
        System.out.println("siparislerimLinki.getAttribute(\"rel\") = " + siparislerimLinki.getAttribute("rel"));

/*
siparislerimLinki.getText()             = Siparişlerim
siparislerimLinki.getAttribute("href")  = https://www.hepsiburada.com/siparislerim
siparislerimLinki.getAttribute("title") = Siparişlerim
siparislerimLinki.getAttribute("rel")   = nofollow
*/
        // partialLinkText (görünen link text in bir parçasını alarak bulma)
        WebElement link2=driver.findElement(By.partialLinkText("Süper Fiyat"));
        System.out.println("link2.getText() = " + link2.getText());

/*
link2.getText() = Süper Fiyat, Süper Teklif
*/

        MyFunc.Bekle(2);
        driver.quit();
    }
}
