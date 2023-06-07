package Projeler.Proje01;

import Utility.BaseDriver_SikKullanilanlar;
import Utility.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Proje_001 extends BaseDriver_SikKullanilanlar {

// her test sonrası ad soyad , şifre ve username değişmeli. Yoksa çakışıyor
    @Test
    public void Test1() {
/*
Test Case 1: Kayıt oluşturma
• Siteye Gidin.
• “Sign Up” tıklatınız.
• “Ad new User” altındaki açılan formu eksiksiz doldurunuz.
• Submit butonuna tıklatınız.
• Başarılı bir şekilde kayıt oluşturduğunuzu doğrulayınız.
 */

        driver.get("https://itera-qa.azurewebsites.net/");
        WebElement signUp = driver.findElement(By.xpath("//*[text()='Sign Up']"));
        signUp.click();

        WebElement firsName = driver.findElement(By.cssSelector("[id='FirstName']"));
        firsName.sendKeys("Grup5Name");

        WebElement surName = driver.findElement(By.cssSelector("[id='Surname']"));
        surName.sendKeys("Grup5Surname");

        WebElement mail = driver.findElement(By.cssSelector("[id='E_post']"));
        mail.sendKeys("Grup5mail@gmail.com");

        WebElement mobile = driver.findElement(By.cssSelector("[id='Mobile']"));
        mobile.sendKeys("0555123456789");

        WebElement userName = driver.findElement(By.cssSelector("[id='Username']"));
        userName.sendKeys("Grup5UserName123");

        WebElement password = driver.findElement(By.cssSelector("[id='Password']"));
        password.sendKeys("Grup5Password123123");

        WebElement confirmPassword = driver.findElement(By.cssSelector("[id='ConfirmPassword']"));
        confirmPassword.sendKeys("Grup5Password123123");

        WebElement submit = driver.findElement(By.cssSelector("[id='submit']"));
        submit.click();

        MyFunc.Bekle(2);

        WebElement text = driver.findElement(By.cssSelector("[class='label-success']"));

        Assert.assertTrue("Kayıt oluşturulamadı",text.getText().contains("Registration Successful"));

    }

    @Test
    public void Test2() {
/*
    Test Case 2: Giriş Yapma
• Siteye gidiniz.
• “Login” butonuna tıklatınız.
• Oluşturmuş olduğunuz username ve password’u giriniz.
• Login Butonuna tıklayınız.
• Siteye giriş yaptığınızı doğrulayınız.

 */
        driver.get("https://itera-qa.azurewebsites.net/");

        WebElement login = driver.findElement(By.xpath("//*[text()='Login']"));
        login.click();

        WebElement userNameLogin = driver.findElement(By.cssSelector("[id='Username']"));
        userNameLogin.sendKeys("Grup5UserName123");

        WebElement passwordLogin = driver.findElement(By.cssSelector("[id='Password']"));
        passwordLogin.sendKeys("Grup5Password123123");

        WebElement login2 = driver.findElement(By.cssSelector("[name='login']"));
        login2.click();

        MyFunc.Bekle(2);

        WebElement text = driver.findElement(By.xpath("//* [contains(text(),'Welcome')]"));

        Assert.assertTrue("Giriş Başarılı Değil!", text.getText().contains("Welcome"));

        WebElement logOut = driver.findElement(By.xpath("//*[text()='Log out']"));
        logOut.click();

    }

    @Test
    public void Test3() {
 /*
 Test Case 3: Yeni Müşteri Oluşturma
• Siteye gidin.
• Siteye giriş yapın.
• “CREATE NEW” Butonuna tıklayınız.
• Customer altındaki formu doldurunuz.
• Create Butonuna tıklatınız.
 */
        driver.get("https://itera-qa.azurewebsites.net/");

        WebElement login = driver.findElement(By.xpath("//*[text()='Login']"));
        login.click();

        WebElement userNameLogin = driver.findElement(By.cssSelector("[id='Username']"));
        userNameLogin.sendKeys("Grup5UserName123");

        WebElement passwordLogin = driver.findElement(By.cssSelector("[id='Password']"));
        passwordLogin.sendKeys("Grup5Password123123");

        WebElement login2 = driver.findElement(By.cssSelector("[name='login']"));
        login2.click();

        WebElement create = driver.findElement(By.cssSelector("[class='btn btn-primary']"));
        create.click();

        WebElement name = driver.findElement(By.cssSelector("[id='Name']"));
        name.sendKeys("TechnoStudy");

        WebElement company = driver.findElement(By.xpath("//*[@id='Company']"));
        company.sendKeys("TechnoStudyLTDSTI");

        WebElement address = driver.findElement(By.xpath("//*[@id='Address']"));
        address.sendKeys("Apple Str. NewJersey");

        WebElement city = driver.findElement(By.xpath("//*[@id='City']"));
        city.sendKeys("NewJersey");

        WebElement phone = driver.findElement(By.xpath("//*[@id='Phone']"));
        phone.sendKeys("055556789");

        WebElement mail = driver.findElement(By.xpath("//*[@id='Email']"));
        mail.sendKeys("technostudy@gmail.com");

        WebElement button = driver.findElement(By.xpath("//*[@value='Create']"));
        button.click();

        BekleKapat();

    }

}
