package Projeler.Proje02;

import Utility.BaseDriver_SikKullanilanlar;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Proje_002 extends BaseDriver_SikKullanilanlar {

    @Test
    public void Test1(){

        driver.get("http://demowebshop.tricentis.com/");
        Actions aksiyonlar = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        WebElement register = driver.findElement(By.className("ico-register"));
        aksiyonlar.moveToElement(register).click().build().perform();

        System.out.println(driver.getCurrentUrl());
        Assert.assertTrue("sayfa açılamadı", driver.getCurrentUrl().equals("https://demowebshop.tricentis.com/register"));

        WebElement gender = driver.findElement(By.id("gender-male"));
        aksiyonlar.moveToElement(gender).click().build().perform();

        WebElement firstname = driver.findElement(By.cssSelector("[id='FirstName']"));
        aksiyonlar.moveToElement(firstname).click().keyDown(Keys.SHIFT).sendKeys("b").keyUp(Keys.SHIFT).sendKeys("aris").build().perform();

        WebElement Lastname = driver.findElement(By.cssSelector("[id='LastName']"));
        aksiyonlar.moveToElement(Lastname).click().keyDown(Keys.SHIFT).sendKeys("o").keyUp(Keys.SHIFT).sendKeys("rcan").build().perform();

        WebElement Email = driver.findElement(By.id("Email"));
        aksiyonlar.moveToElement(Email).click().sendKeys("seyda123@gmail.com").build().perform();

        WebElement Password = driver.findElement(By.id("Password"));
        aksiyonlar.moveToElement(Password).click().keyDown(Keys.SHIFT).sendKeys("a").keyUp(Keys.SHIFT).sendKeys("123456").build().perform();

        WebElement ConfirmPassword = driver.findElement(By.id("ConfirmPassword"));
        aksiyonlar.moveToElement(ConfirmPassword).click().keyDown(Keys.SHIFT).sendKeys("a").keyUp(Keys.SHIFT).sendKeys("123456").build().perform();

        WebElement register_button = driver.findElement(By.id("register-button"));
        aksiyonlar.moveToElement(register_button).click().build().perform();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='result']")));

        WebElement text = driver.findElement((By.xpath("//div[@class='result']")));

        Assert.assertEquals("Register başarısız", "Your registration completed", text.getText());

        WebElement logOut = driver.findElement(By.xpath("//*[@class='ico-logout']"));
        aksiyonlar.moveToElement(logOut).click().build().perform();
    }

    @Test
    public void Test2() {

        driver.get("http://demowebshop.tricentis.com/");
        Actions aksiyonlar = new Actions(driver);
        WebElement register = driver.findElement(By.className("ico-register"));
        //aksiyonlar.moveToElement(register).click().build().perform();
        Action aksiyon = aksiyonlar.moveToElement(register).click().build();
        aksiyon.perform();

        System.out.println(driver.getCurrentUrl());
        Assert.assertTrue("sayfa açılamadı", driver.getCurrentUrl().equals("https://demowebshop.tricentis.com/register"));


        WebElement gender = driver.findElement(By.id("gender-male"));
        aksiyonlar.moveToElement(gender).click().build().perform();

        WebElement firstname = driver.findElement(By.cssSelector("[id='FirstName']"));
        aksiyon = aksiyonlar
                .moveToElement(firstname)
                .click()
                .keyDown(Keys.SHIFT)
                .sendKeys("b")
                .keyUp(Keys.SHIFT)
                .sendKeys("aris")
                .build();
        aksiyon.perform();

        WebElement Lastname = driver.findElement(By.cssSelector("[id='LastName']"));
        aksiyon = aksiyonlar
                .moveToElement(Lastname)
                .click()
                .keyDown(Keys.SHIFT)
                .sendKeys("o")
                .keyUp(Keys.SHIFT)
                .sendKeys("rcan")
                .build();
        aksiyon.perform();

        WebElement Email = driver.findElement(By.id("Email"));
        aksiyon = aksiyonlar
                .moveToElement(Email)
                .click()
                .sendKeys("seyda123@gmail.com")
                .build();
        aksiyon.perform();

        WebElement Password = driver.findElement(By.id("Password"));
        aksiyon = aksiyonlar
                .moveToElement(Password)
                .click()
                .keyDown(Keys.SHIFT)
                .sendKeys("a")
                .keyUp(Keys.SHIFT)
                .sendKeys("123456")
                .build();
        aksiyon.perform();

        WebElement ConfirmPassword = driver.findElement(By.id("ConfirmPassword"));
        aksiyon = aksiyonlar
                .moveToElement(ConfirmPassword)
                .click()
                .keyDown(Keys.SHIFT)
                .sendKeys("a")
                .keyUp(Keys.SHIFT)
                .sendKeys("123456")
                .build();
        aksiyon.perform();

        WebElement register_button = driver.findElement(By.id("register-button"));
        aksiyonlar.moveToElement(register_button).click().build().perform();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.textToBe(By.xpath("//*[text()='The specified email already exists']"), "The specified email already exists"));

        WebElement text = driver.findElement((By.xpath("//*[text()='The specified email already exists']")));


        Assert.assertEquals("Register başarısız", "The specified email already exists", text.getText());

//        WebElement logOut = driver.findElement(By.xpath("//*[@class='ico-logout']"));
//        aksiyonlar.moveToElement(logOut).click().build().perform();
    }

    @Test
    public void Test3() {
        driver.get("http://demowebshop.tricentis.com/");
        Actions aksiyonlar = new Actions(driver);
        WebElement login = driver.findElement(By.className("ico-login"));
        //aksiyonlar.moveToElement(register).click().build().perform();
        Action aksiyon = aksiyonlar.moveToElement(login).click().build();
        aksiyon.perform();

        System.out.println(driver.getCurrentUrl());
        Assert.assertTrue("sayfa açılamadı", driver.getCurrentUrl().equals("https://demowebshop.tricentis.com/login"));


        WebElement Email = driver.findElement(By.id("Email"));
        aksiyon = aksiyonlar
                .moveToElement(Email)
                .click()
                .sendKeys("seyda123@gmail.com")
                .build();
        aksiyon.perform();

        WebElement Password = driver.findElement(By.id("Password"));
        aksiyon = aksiyonlar
                .moveToElement(Password)
                .click()
                .keyDown(Keys.SHIFT)
                .sendKeys("a")
                .keyUp(Keys.SHIFT)
                .sendKeys("123456")
                .build();
        aksiyon.perform();

        WebElement login_button = driver.findElement(By.cssSelector("[class='button-1 login-button']"));
        aksiyon = aksiyonlar
                .moveToElement(login_button)
                .click()
                .build();
        aksiyon.perform();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.urlToBe("https://demowebshop.tricentis.com/"));


        WebElement welcome = driver.findElement(By.xpath("//*[@class='topic-html-content-header']"));

        Assert.assertTrue("login başarısız", welcome.getText().equals("Welcome to our store"));

        WebElement logOut = driver.findElement(By.xpath("//*[@class='ico-logout']"));
        aksiyonlar.moveToElement(logOut).click().build().perform();
    }

    @Test
    public void Test4() {
        driver.get("http://demowebshop.tricentis.com/");
        Actions aksiyonlar = new Actions(driver);
        WebElement login = driver.findElement(By.className("ico-login"));
        aksiyonlar.moveToElement(login).click().build().perform();

        System.out.println(driver.getCurrentUrl());
        Assert.assertTrue("sayfa açılamadı", driver.getCurrentUrl().equals("https://demowebshop.tricentis.com/login"));

        WebElement Email = driver.findElement(By.id("Email"));
        aksiyonlar.moveToElement(Email).click().sendKeys("orcanbaris000@gmail.com").build().perform();

        WebElement Password = driver.findElement(By.id("Password"));
        aksiyonlar.moveToElement(Password).click().keyDown(Keys.SHIFT).sendKeys("a").keyUp(Keys.SHIFT).sendKeys("123456").build().perform();

        WebElement login_button = driver.findElement(By.cssSelector("[class='button-1 login-button']"));
        aksiyonlar.moveToElement(login_button).click().build().perform();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.textToBe(By.xpath("//span[text()='Login was unsuccessful. Please correct the errors and try again.']"),
                "Login was unsuccessful. Please correct the errors and try again."));


        WebElement no_login = driver.findElement(By.xpath("//li[text()='No customer account found']"));

        Assert.assertTrue("yanlış email veya password ile giriş yapıldı", no_login.getText().equals("No customer account found"));
    }

    @Test
    public void Test5() {
        driver.get("http://demowebshop.tricentis.com/");

        Actions aksiyonlar = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        WebElement login = driver.findElement(By.className("ico-login"));
        aksiyonlar.moveToElement(login).click().build().perform();

        System.out.println(driver.getCurrentUrl());
        Assert.assertTrue("sayfa açılamadı", driver.getCurrentUrl().equals("https://demowebshop.tricentis.com/login"));

        WebElement Email = driver.findElement(By.id("Email"));
        aksiyonlar.moveToElement(Email).click().sendKeys("orcanbaris61@gmail.com").build().perform();

        WebElement Password = driver.findElement(By.id("Password"));
        aksiyonlar.moveToElement(Password).click().keyDown(Keys.SHIFT).sendKeys("a").keyUp(Keys.SHIFT).sendKeys("123456").build().perform();

        WebElement login_button = driver.findElement(By.cssSelector("[class='button-1 login-button']"));
        aksiyonlar.moveToElement(login_button).click().build().perform();

        wait.until(ExpectedConditions.urlToBe("https://demowebshop.tricentis.com/"));

        WebElement computers = driver.findElement(By.xpath("(//*[@href='/computers'])[1]"));
        aksiyonlar.moveToElement(computers).build().perform();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@href='/notebooks'])[1]")));

        WebElement notebooks = driver.findElement(By.xpath("(//*[@href='/notebooks'])[1]"));
        aksiyonlar.moveToElement(notebooks).click().build().perform();

        wait.until(ExpectedConditions.urlToBe("https://demowebshop.tricentis.com/notebooks"));

        WebElement laptop = driver.findElement(By.xpath("(//*[@class='product-title'])[1]/a"));
        aksiyonlar.moveToElement(laptop).click().build().perform();

        WebElement addtocart = driver.findElement(By.xpath("//*[@id='add-to-cart-button-31']"));
        aksiyonlar.moveToElement(addtocart).click().build().perform();

        WebElement shoppingcart = driver.findElement(By.xpath("(//*[@class='cart-label'])[1]"));
        aksiyonlar.moveToElement(shoppingcart).click().build().perform();

        WebElement check = driver.findElement(By.xpath("(//*[text()='14.1-inch Laptop'])[2]"));
        Assert.assertTrue("ürün sepete eklenemedi", check.isDisplayed());

        WebElement agreebutton = driver.findElement(By.cssSelector("[id='termsofservice']"));
        aksiyonlar.moveToElement(agreebutton).click().build().perform();

        WebElement checkout = driver.findElement(By.cssSelector("[id='checkout']"));
        aksiyonlar.moveToElement(checkout).click().build().perform();

        WebElement countrymenu = driver.findElement(By.cssSelector("[id='BillingNewAddress_CountryId']"));
        Select country = new Select(countrymenu);
        country.selectByVisibleText("Turkey");

        WebElement city = driver.findElement(By.cssSelector("[id='BillingNewAddress_City']"));
        aksiyonlar.moveToElement(city).click().keyDown(Keys.SHIFT).sendKeys("a") .keyUp(Keys.SHIFT).sendKeys("nkara").build().perform();

        WebElement Adress1 = driver.findElement(By.cssSelector("[id='BillingNewAddress_Address1']"));
        aksiyonlar.moveToElement(Adress1).click().sendKeys("Ankara keçiören").build().perform();

        WebElement zipcode = driver.findElement(By.cssSelector("[id='BillingNewAddress_ZipPostalCode']"));
        aksiyonlar.moveToElement(zipcode).click().sendKeys("41987435").build().perform();

        WebElement phonenumber = driver.findElement(By.cssSelector("[id='BillingNewAddress_PhoneNumber']"));
        aksiyonlar.moveToElement(phonenumber).click().sendKeys("0555111333").build().perform();

        WebElement continue1 = driver.findElement(By.xpath("(//*[@class='button-1 new-address-next-step-button'])[1]"));
        aksiyonlar.moveToElement(continue1).click().build().perform();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='button-1 new-address-next-step-button'])[2]")));

        WebElement continue2 = driver.findElement(By.xpath("(//*[@class='button-1 new-address-next-step-button'])[2]"));
        aksiyonlar.moveToElement(continue2).click().build().perform();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='button-1 shipping-method-next-step-button']")));

        WebElement continue3 = driver.findElement(By.xpath("//*[@class='button-1 shipping-method-next-step-button']"));
        aksiyonlar.moveToElement(continue3).click().build().perform();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='button-1 payment-method-next-step-button']")));

        WebElement continue4 = driver.findElement(By.xpath("//*[@class='button-1 payment-method-next-step-button']"));
        aksiyonlar.moveToElement(continue4).click().build().perform();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='button-1 payment-info-next-step-button']")));

        WebElement continue5 = driver.findElement(By.xpath("//*[@class='button-1 payment-info-next-step-button']"));
        aksiyonlar.moveToElement(continue5).click().build().perform();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='button-1 confirm-order-next-step-button']")));

        WebElement confirm = driver.findElement(By.xpath("//*[@class='button-1 confirm-order-next-step-button']"));
        aksiyonlar.moveToElement(confirm).click().build().perform();

        wait.until(ExpectedConditions.urlToBe("https://demowebshop.tricentis.com/checkout/completed/"));

        WebElement thankYou = driver.findElement(By.xpath("//*[text()='Your order has been successfully processed!']"));
        Assert.assertTrue("siparişiniz oluşturulamadı", thankYou.getText().equals("Your order has been successfully processed!"));

        System.out.println("Görev başarıyla tamamlandı (:");

        BekleKapat();
    }
}
