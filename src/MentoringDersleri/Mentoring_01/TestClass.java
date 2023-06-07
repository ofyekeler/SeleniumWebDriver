package MentoringDersleri.Mentoring_01;

import Utility.BaseDriver_SikKullanilanlar;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.junit.Test;

public class TestClass extends BaseDriver_SikKullanilanlar {

    @Test
    public void test(){
        driver.get("https://demo.nopcommerce.com/");

        // Register’a tıklatınız.

        WebElement register = driver.findElement(By.cssSelector(".header-links a.ico-register"));
        register.click();

        // Gender (cinsiyet) secin.

        WebElement gender = driver.findElement(By.cssSelector(".gender span:nth-child(2)>input"));
        gender.click();

        // First name girin.

        WebElement firstName = driver.findElement(By.cssSelector("[data-val-required^='First name']"));
        firstName.sendKeys("Ayşe");

        // Last name girin.

        WebElement lastName = driver.findElement(By.cssSelector(".form-fields div:nth-child(3)>input"));
        lastName.sendKeys("Yıldız");

        // Date of Birth - Day

        WebElement day = driver.findElement(By.cssSelector("[name='DateOfBirthDay']"));
        day.sendKeys("2");


        WebElement month = driver.findElement(By.cssSelector("[name='DateOfBirthMonth'] :nth-child(12)"));
        month.click();

        WebElement year = driver.findElement(By.cssSelector("div[class='date-picker-wrapper'] [name='DateOfBirthYear']"));
        year.sendKeys("2000");

        // E-Mail Girin

        WebElement email = driver.findElement(By.cssSelector("[data-val-email$='email']"));
        email.sendKeys("AyseYildiz@gmail.com");

        // Company Name girin

        WebElement companyName = driver.findElement(By.cssSelector("[id='Company']"));
        companyName.sendKeys("Techno Study");

        BekleKapat();

    }

}
