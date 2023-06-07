package Gun05;

import Utility.BaseDriver_SikKullanilanlar;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class _03_GetCssValue extends BaseDriver_SikKullanilanlar {
    public static void main(String[] args) {

        driver.get("https://www.snapdeal.com/");

        WebElement inputValEnter= driver.findElement(By.id("inputValEnter"));
        
    // <input autocomplete="off" name="keyword" type="text" class="col-xs-20 searchformInput keyword"
        // id="inputValEnter" onkeypress="clickGo(event, this)" placeholder="Search products &amp; brands"
        // value="" strtindx="" endindx="">

        // elemanın parametrelerine ulaşmak için getAttribute u kullanıyoruz.
        System.out.println("\"class\" = " + inputValEnter.getAttribute("class"));

        // Class ın karşılığı olan CSS-Şekillendirme değerlerini almak için getCssValue kullanılır.
            System.out.println("\"color\" = " + inputValEnter.getCssValue("color"));
        System.out.println("\"font-size\" = " + inputValEnter.getCssValue("font-size"));
       System.out.println("\"background\" = " + inputValEnter.getCssValue("background"));
/*   RUN
     "class" = col-xs-20 searchformInput keyword
     "color" = rgba(51, 51, 51, 1)
 "font-size" = 14px
"background" = rgba(244, 244, 244, 0.6) none repeat scroll 0% 0% / auto padding-box border-box
*/

        BekleKapat();
    }
}
