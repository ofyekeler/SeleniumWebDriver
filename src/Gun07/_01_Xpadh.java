package Gun07;

import Utility.BaseDriver_SikKullanilanlar;
import org.junit.Test;

public class _01_Xpadh extends BaseDriver_SikKullanilanlar {

    @Test
    public void Test1(){

        /*
        cssSelector da olmayan 2 hareket var

        elementten geri gitme
        ekranda gözüken yazı ile bulma

        By.Id("firstName")
        By.Name("firstName")
        By.cssSelector("firstName")

        By.xpath(" //[@id='firstName'] ")    hem ileri gider hem de geri gider.
                                             text e göre arama yapar.
                                           * kapsamlı çalıştığı için biraz yavaştır !!!
                                             çalıştırırken yapacağımız öncelikler;
                                                    - id
                                                    - cssselector
                                                    - xpath (en son tercih ederiz)
       interviewlarda kaç çeşit xpath vardır şeklinde soru gelebilir.

           ABSOLUTE Xpath deniyor.
           /html/body/div[2]/div/div/div/form/input
           1- / başlıyor.
           2- En baştan HTML den başlyarak bir yol bulur.Araya başka eleman girdiğinde yol kaybolur.
           Bu yüzden kullanışsızdır.

           RELATIVE Xpath denir.
           //*[@id='login-button']
            1- // başlıyor.
            2- Elemanı direk bulur, baştan itibaren diğer elemanlara bağlı kalmaz.

           findEmelent(By.xpath(""));

       CSS                XPATH
       ile başlayan id^   [start-with(@id,'u_')]
       ile biten    id$   [end-with(@id,'_4545')]
       içinde geçen id*   [contains(@id,'u_')]

       CSS                          XPATH
       [id='msg'][value='Good']     //*[@id='msg' and @value='Good']

       CSS                               XPATH
       >     -> çocuklar                 /
       space -> cocuklar + torunlar      //
       +     -> bitişik kardeş           following-sibling::
       ~     -> tüm kardeşler            following::

       XPATH in CSS den üstünlüğü
       /..                              ->  parent e gider
       //*[text()="merhaba dünya"]      ->  Görünen yazısı ile bulma
       //*[contains(text(),'merhaba')]  ->  görünen yazısında merhaba geçen

       */

    }
}
