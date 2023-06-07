package Gun12;


/*
    Senaryo:
    https://www.selenium.dev/ adresindeki ayrı tab da açılan linklere tıklatınız.
    Açılan bütün yeni tablardaki sayfaların title ve url lerini yazdırınız.
    Daha sonra Anasayfa harici diğer tüm sayfaları kapatınız.
 */

import Utility.BaseDriver_SikKullanilanlar;
import Utility.MyFunc;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Set;

public class _05_WindowsSoru extends BaseDriver_SikKullanilanlar {

    @Test
    public void Test1() {
        driver.get("https://www.selenium.dev/");
        MyFunc.Bekle(2);
        String anaSayfaWindowId= driver.getWindowHandle();

        List<WebElement> linkler= driver.findElements(By.cssSelector("a[target='_blank']"));

        // Aşağıdaki şu anda bütün sayfalar açıldı
        for(WebElement link: linkler)
            if (!link.getAttribute("href").contains("mail")) // mail leri hariç tuttuk
                link.click();

// her bir sayfaya geçip url ve title ını yazdırma
        Set<String> windowsIdLer= driver.getWindowHandles();
        for(String id: windowsIdLer)
        {
            MyFunc.Bekle(2);
            driver.switchTo().window(id); // sıradaki tab'daki window a geçmiş oldum.
            System.out.println("title="+ driver.getTitle()+", url="+driver.getCurrentUrl());
        }

// ana sayfa harici kapama
        for(String id: windowsIdLer)
        {
            if (id.equals(anaSayfaWindowId))
                continue;

            driver.switchTo().window(id); // sıradaki tab'daki window a geçmiş oldum.
            driver.close();
        }
        BekleKapat();
    }
/*
title=Selenium, url=https://www.selenium.dev/
title=Selenium Developers - Google Gruplar, url=https://groups.google.com/g/selenium-developers
title=Kiwi IRC - The web IRC client, url=https://kiwiirc.com/nextclient/irc.libera.chat/#selenium
title=GitHub - SeleniumHQ/selenium: A browser automation framework and ecosystem., url=https://github.com/seleniumhq/selenium
title=Create Account | Slack, url=https://seleniumhq.slack.com/join/shared_invite/zt-vv33sc0w-VKKQop3WDV_lfrLXGGHvDw#/shared-invite/error
title=Selenium Users - Google Gruplar, url=https://groups.google.com/g/selenium-users
title=Selenium (WebDriver) | Facebook, url=https://www.facebook.com/Selenium2.WebDriver
title=Selenium Conference - YouTube, url=https://www.youtube.com/channel/UCbDlgX_613xNMrDqCe3QNEw
title=, url=https://twitter.com/SeleniumHQ
title=Register - SeleniumConf, url=https://seleniumconf.com/register/?utm_source=seleniumhq&utm_medium=banner
*/
}
