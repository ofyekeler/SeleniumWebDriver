package Utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BaseDriver_SikKullanilanlar {

    public static WebDriver driver;
    public static WebDriverWait wait;

    static {

        // public static void DriverBaslat()  yazmak yerine SADECE "static" yazarsak
        // extend ettiğimiz sayfaya "DriverBaslat" yazmamıza dahi gerek kalmıyor!!!
        // kendisi otomatik kullanıyor. :)

        KalanOncekileriKapat(); // açık olan sayfaları kapatır sonra çalışır

        Logger logger= Logger.getLogger(""); // output a ait bütün logları üreten objeye/servise ulaştım ""
        logger.setLevel(Level.SEVERE); // Sadece errorları göster

        // RUN sonrası gerekmeyen log ları kaldıracağız
        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");

        // yukarıdaki WebDriver ın devamı. driver nesnesini tanımladık.
        // driver = new ChromeDriver();

        // Gün14 sırasında chrome da yaşanan güncelleme sonrası ilgili sayfayı açamadığımızdan
        // aşağıdaki kodları ekledim ve bir üsttreki drive ı pasif e çektim. (içinde OPTIONS nesnesini ekledik)
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);

        driver.manage().window().maximize();  // Ekranı max (tam ekran) yapıyor.

        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        Duration dr = Duration.ofSeconds(30);
        driver.manage().timeouts().pageLoadTimeout(dr);
        // Sadece tüm sayfanın kodlarının bilgisyarınıza inmesi süresiyle ilgili
        // bu eklenmezse Selenium sayfa yüklenene kadar (sonsuza) bekler.
        // 30 sn süresince sayfanın yüklenmesini bekle yüklenmezse hata ver
        // (sayfa yüklerken yavaş kalabiliyor, buna zaman vermek için)
        // eğer 2 sn yüklerse 30 sn. beklemez.

        driver.manage().timeouts().implicitlyWait(dr); // (dolaylı olarak, üstü kapalı)
        // Bütün weblementlerin element bazında, elemente özel işlem yapılmadan önce
        // hazır hale gelmesi verilen mühlet yani süre.
        // eğer 2 sn yüklerse 30 sn. beklemez.

    }

    public static void BekleKapat(){
        MyFunc.Bekle(2);
        driver.quit();
    }

    public static void KalanOncekileriKapat() {

        try {
            Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe /T");
        } catch (Exception ignored) {
        }
        // Çalıştırdığımız sayfayı açmadan önce hafızayı temizler, yani diğer chrome sayfalarını kapatır.

    }
}
