package Gun07;

import Utility.BaseDriver_SikKullanilanlar;
import Utility.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class _02_Ödev extends BaseDriver_SikKullanilanlar {
    /*
    1- https://www.saucedemo.com/
    2- login işlemini yapınız.
    3- Sauce Labs Backpack  a tıklatın ve sepete ekletin.
    4- Sonra geri dönün (Back to products e tıklatın)
    5- Sauce Labs Bolt T-Shirt  a tıklatın ve sepete ekleyin.
    6- sepete tıklatın
    7- CheckOut a tıklatın
    8- kullanıcı bilgilerini doldurup Continue ya tıklatın
    9- Burada her bir eşyanın ücretlerinin toplamının aşağıdaki
       Item total e eşit olup olmadığını Assert ile test ediniz.

       BU SORUDA SADECE XPATH KULLANILACAKTIR.
    */

    @Test
    public void Test1(){

        driver.get("https://www.saucedemo.com");
        WebElement userName = driver.findElement(By.xpath("//input[@id='user-name']"));
        userName.sendKeys("standard_user");

        MyFunc.Bekle(1);

        WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
        password.sendKeys("secret_sauce");

        MyFunc.Bekle(1);

        WebElement loginButton = driver.findElement(By.xpath("//input[@id='login-button']"));
        loginButton.click();

        MyFunc.Bekle(1);

        WebElement sauceBackpack = driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']"));
        sauceBackpack.click();

        MyFunc.Bekle(1);

        WebElement addToCart = driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']"));
        addToCart.click();

        MyFunc.Bekle(1);

        driver.navigate().back();

        MyFunc.Bekle(1);

        WebElement sauceBolt = driver.findElement(By.xpath("//div[text()='Sauce Labs Bolt T-Shirt']"));
        sauceBolt.click();

        MyFunc.Bekle(1);

        WebElement addToCart1 = driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-bolt-t-shirt']"));
        addToCart1.click();

        MyFunc.Bekle(1);

        WebElement sepeteGit = driver.findElement(By.xpath("//span[@class='shopping_cart_badge']"));
        sepeteGit.click();

        MyFunc.Bekle(1);

        WebElement checkOut = driver.findElement(By.xpath("//button[@id='checkout']"));
        checkOut.click();

        MyFunc.Bekle(1);

        WebElement firstName = driver.findElement(By.xpath("//input[@id='first-name']"));
        firstName.sendKeys("faruk");

        MyFunc.Bekle(1);

        WebElement lastName = driver.findElement(By.xpath("//input[@id='last-name']"));
        lastName.sendKeys("ozturk");

        MyFunc.Bekle(1);

        WebElement postCode = driver.findElement(By.xpath("//input[@id='postal-code']"));
        postCode.sendKeys("060156");

        MyFunc.Bekle(1);

        WebElement continuee = driver.findElement(By.xpath("//input[@id='continue']"));
        continuee.click();

        List<WebElement> ucretler = driver.findElements(By.xpath("//div[@class='inventory_item_price']"));

        double toplam=0;
        for (WebElement e : ucretler){
            System.out.println("e.getText() = " + e.getText()); // $29.99 -> 29.99 yapmalıyız. bunu da substring le yapacağız
            // replaceAll ise [^0-9.,]
            toplam=toplam+Double.parseDouble(e.getText().substring(1)); // 1 den itibaren sonuna kadar al
        }
        System.out.println("toplam = " + toplam);

        // altToplam
        WebElement webAltToplam= driver.findElement(By.xpath("//div[@class='summary_subtotal_label']"));
        System.out.println(webAltToplam.getText());
        System.out.println("webAltToplam.getText().replaceAll(\"[^0-9,.]\",\"\") = " +
                                                    webAltToplam.getText().replaceAll("[^0-9,.]",""));

        Double altToplam=Double.parseDouble(webAltToplam.getText().replaceAll("[^0-9,.]",""));

        //if(toplam==altToplam)
        //    System.out.println("testi geçti");
        //else
        //    System.out.println("testi geçemedi");

        // Demek yerine, ASSERT kullanıyoruz. Çünkü bu yöntemle sol alt tarafta testin geçip geçmediğini
            // çentik işaretiyle görmek istiyorum.

        Assert.assertTrue("Değerler Eşit Değil",(toplam==altToplam));

        BekleKapat();
    }
}
