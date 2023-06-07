package Projeler.Proje03;

import Utility.BaseDriver_SikKullanilanlar;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Proje03 extends BaseDriver_SikKullanilanlar {

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

    @Test
    public void Test1() {
/*
Test Case 1:
➢ https://shopdemo.e-junkie.com/ sitesine gidiniz
➢ E-book add to cart butonuna tıklatınız.
➢ Add promo code butonuna tıklatıp veri giriniz.
➢ Apply butonuna tıklayınız.
➢ Invalid promo code yazısının görüldüğünü doğrulayınız
*/
        addcart();

        WebElement addpromoCode = driver.findElement(By.xpath("//*[@class='Apply-Button Show-Promo-Code-Button']"));
        addpromoCode.click();

        WebElement promoCode = driver.findElement(By.xpath("//input[@class='Promo-Code-Value']"));
        promoCode.sendKeys("grup5");

        WebElement apply = driver.findElement(By.xpath("//button[@class='Promo-Apply']"));
        apply.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Invalid promo code']")));
        WebElement validation = driver.findElement(By.xpath("//span[text()='Invalid promo code']"));
        Assert.assertEquals("Invalid promo code", validation.getText());
    }

    @Test
    public void Test2() {
/*
Test Case:2
➢ https://shopdemo.e-junkie.com/ sitesine gidiniz
➢ E-book add to cart butonuna tıklatınız.
➢ Pay using debit card a tıklatınız.
➢ Pay butonuna tıklatınız.
➢ Invalid Email, Invalid Email, invalid billing name mesajlarının görüldüğünü doğrulayınız.
*/
        addcart();

        WebElement payUsingDebit = driver.findElement(By.xpath("//*[@class='Payment-Button CC']"));
        payUsingDebit.click();

        WebElement payBtn = driver.findElement(By.xpath("//*[@class='Pay-Button']"));
        payBtn.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Invalid Email']")));
        WebElement validation = driver.findElement(By.xpath("//span[text()='Invalid Email']"));
        Assert.assertTrue(validation.getText().contains("Invalid Email"));
    }

    @Test
    public void Test3() {
/*
Test Case:3
➢ https://shopdemo.e-junkie.com/ sitesine gidiniz
➢ E-book add to cart butonuna tıklatınız.
➢ Pay using debit card a tıklatınız.
➢ Card numarasına “1111 1111 1111 1111” giriniz
➢ “Your card number is invalid” mesajının görüldüğünü doğrulayınız.
*/
        addcart();

        WebElement payUsingDebit = driver.findElement(By.xpath("//*[@class='Payment-Button CC']"));
        payUsingDebit.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name^='__privateStripeFrame']")));

        WebElement frame2 = driver.findElement(By.cssSelector("[name^='__privateStripeFrame']"));
        driver.switchTo().frame(frame2);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@name='cardnumber']")));
        WebElement cardnumber = driver.findElement(By.xpath("//*[@name='cardnumber']"));
        cardnumber.sendKeys("1111 1111 1111 1111");

        driver.switchTo().parentFrame();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='Close-SnackBar md hydrated']")));
        WebElement validation = driver.findElement(By.xpath("//*[text()='Kart numaranız geçersiz.']"));
        Assert.assertEquals("Kart numaranız geçersiz.", validation.getText());
    }

    @Test
    public void Test4() {
/*
Test Case: 4
➢ https://shopdemo.e-junkie.com/ sitesine gidiniz
➢ E-book add to cart butonuna tıklatınız.
➢ Pay using debit card a tıklatınız.
➢ Email, confirm Email, name, telefon, company, Card number(“4242 4242 4242 4242” ) giriniz,
    expdate, cvc kodu bilgilerini doldurunuz
➢ Pay butonuna tıklayınız
➢ “Your order is confirmed. Thank you!” mesajının görüldüğünü doğrulayınız
*/
        addcart();

        WebElement payUsingDebit = driver.findElement(By.xpath("//*[@class='Payment-Button CC']"));
        payUsingDebit.click();

        WebElement eMail = driver.findElement(By.xpath("(//*[@type='email'])[1]"));
        eMail.sendKeys("grup5@gmail.com");

        WebElement confirmeMail = driver.findElement(By.xpath("(//*[@type='email'])[2]"));
        confirmeMail.sendKeys("grup5@gmail.com");

        WebElement nameOnCard = driver.findElement(By.xpath("//*[@placeholder='Name On Card']"));
        nameOnCard.sendKeys("Grup5 Techno");

        WebElement phone = driver.findElement(By.xpath("(//*[@placeholder='Optional'])[1]"));
        phone.sendKeys("05555555555");

        WebElement company = driver.findElement(By.xpath("(//*[@autocomplete='company'])[1]"));
        company.sendKeys("Techno Study");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name^='__privateStripeFrame']")));

        // frame adedini ve mevcutta hangi frame de olduğumuzu gösterir. Bilal hoca göndermişti. :)
        List<WebElement> iframes = driver.findElements(By.xpath("//iframe"));
        System.out.println("iframes adedi : " + iframes.size());
        int s = 0;
        for (WebElement i : iframes) {
            System.out.println("i.getAttribute(class) = " + s + " : " + i.getAttribute("class"));
            s++;
        }

        WebElement frame2 = driver.findElement(By.cssSelector("[name^='__privateStripeFrame']"));
        driver.switchTo().frame(frame2);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@name='cardnumber']")));
        WebElement cardnumber = driver.findElement(By.xpath("//*[@name='cardnumber']"));
        cardnumber.sendKeys("4242 4242 4242 4242");

        WebElement expDate = driver.findElement(By.xpath("(//*[@class='InputElement is-empty Input Input--empty'])[1]"));
        expDate.sendKeys("1023");


        WebElement cvc = driver.findElement(By.xpath("//*[@name='cvc']"));
        cvc.sendKeys("111");

        driver.switchTo().parentFrame();

        WebElement payBtn = driver.findElement(By.xpath("//*[@class='Pay-Button']"));
        payBtn.click();

        driver.switchTo().defaultContent();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Grup5, your order is confirmed. Thank you!']")));
        WebElement thankYou = driver.findElement(By.xpath("//*[text()='Grup5, your order is confirmed. Thank you!']"));

        Assert.assertTrue(thankYou.getText().contains("Thank you!"));
    }

    @Test
    public void Test5() {
/*
Test Case:5
➢ https://shopdemo.e-junkie.com/ sitesine gidiniz
➢ ContactUs butonuna tıklattınız
➢ Name, Email, Subject ve mesaj kısımlarını doldurun
➢ Send butonuna tıklatın
➢ Alert in görüldüğünü doğrulayın ve alert I kapatın
*/
        driver.get("https://shopdemo.e-junkie.com/");

        WebElement contactUs = driver.findElement(By.xpath("//*[@class='contact']"));
        contactUs.click();

        WebElement name = driver.findElement(By.xpath("//*[@id='sender_name']"));
        name.sendKeys("Grup5");

        WebElement email = driver.findElement(By.xpath("//*[@id='sender_email']"));
        email.sendKeys("grup5@gmail.com");

        WebElement subject = driver.findElement(By.xpath("//*[@id='sender_subject']"));
        subject.sendKeys("product");

        WebElement message = driver.findElement(By.xpath("//*[@id='sender_message']"));
        message.sendKeys("deemo ebook");

        WebElement sendMessage = driver.findElement(By.xpath("//*[@id='send_message_button']"));
        sendMessage.click();

        wait.until(ExpectedConditions.alertIsPresent());

        driver.switchTo().alert().accept();

        BekleKapat();
    }

    void addcart() {

        driver.get("https://shopdemo.e-junkie.com/");

        WebElement addToCart = driver.findElement(By.xpath("(//*[@class='view_product'])[2]"));
        addToCart.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='EJIframeV3 EJOverlayV3']")));

        WebElement frame = driver.findElement(By.xpath("//*[@class='EJIframeV3 EJOverlayV3']"));
        driver.switchTo().frame(frame);
    }
}
