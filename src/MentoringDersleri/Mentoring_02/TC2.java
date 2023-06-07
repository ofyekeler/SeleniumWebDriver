package MentoringDersleri.Mentoring_02;

import Utility.BaseDriver_SikKullanilanlar;
import Utility.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TC2 extends BaseDriver_SikKullanilanlar {
/*
Çarşamba:
• http://demo.nopcommerce.com/ sitesine gidin
• Log in’ e tıklayın.
• adminTechno@gmail.com email addresini girin
• Admin123 password olarak girin.
• Login butonuna tiklayin.
• Search kısmına “Beats Pill” Girin.
• Search butonuna tıklayın.
• Sayfada gözüken urunun Baslığının “Beats Pill” yazısını içerdiğini doğrulayın.
• Ürüne Tıklayın.
• ADD TO CART Butonuna tıklayın.
• Urunun başarılı bir şekilde Sepete eklendiğini doğrulayın.
*/
    @Test
    public void test() {
        driver.get("http://demo.nopcommerce.com/ ");

        WebElement login = driver.findElement(By.xpath("//a[contains(@href,'login')]"));
        //(//div[@class='header-links']/ul/li/a)[2]   veya   //a[contains(@class,'login')]
        login.click();

        WebElement email = driver.findElement(By.xpath("(//input[starts-with(@id,Email)])[3]"));
        //label[text()='Email:']/following-sibling::input
        MyFunc.Bekle(2);
        email.sendKeys("test@test.com");

        WebElement password = driver.findElement(By.xpath("//input[@id='Password' and @type='password']"));
        //(//div[@class='inputs'])[2]//input     veya
        password.sendKeys("123456");

        WebElement Login = driver.findElement(By.xpath("//*[@type='submit' and contains(@class,'1 login')]"));
        Login.click();

        WebElement searchBox = driver.findElement(By.xpath("//*[contains(@class,'search')]//form//input"));
        searchBox.sendKeys("Beats Pill");
        MyFunc.Bekle(2);

        WebElement searchButton = driver.findElement(By.xpath("//*[contains(@class,'button') and @type='submit']"));
        searchButton.click();
        MyFunc.Bekle(2);

        WebElement product = driver.findElement(By.xpath("//*[@class='product-title']"));
        Assert.assertTrue(product.getText().toLowerCase().contains("beats pill"));

        WebElement actualPrice = driver.findElement(By.xpath("//*[@class='price actual-price']"));

        String doubleStrPrice = actualPrice.getText().replaceAll("[^\\d+\\.\\d+]", "");
        Double AcPrice = Double.parseDouble(doubleStrPrice);
        System.out.println(AcPrice);

        WebElement addToCard = driver.findElement(By.xpath("//button[text()='Add to cart']"));
        addToCard.click();

        WebElement shoppingCard = driver.findElement(By.xpath("//*[@id='topcartlink']"));
        shoppingCard.click();
        MyFunc.Bekle(3);

        WebElement nameInCard = driver.findElement(By.xpath("//*[@class='product-name']"));

        WebElement priceCard = driver.findElement(By.xpath("//*[@class='product-unit-price']"));
        Double PriceCard = Double.parseDouble(priceCard.getText().replaceAll("[^\\d+\\.\\+]", ""));
        System.out.println(PriceCard);

        Assert.assertTrue(nameInCard.getText().toLowerCase().contains("beats pill")
                && AcPrice.equals(PriceCard));
        BekleKapat();
    }
}

