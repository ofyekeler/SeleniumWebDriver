package Gun08;

import Utility.BaseDriver_SikKullanilanlar;
import Utility.MyFunc;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class _01_ElemaninStatusu extends BaseDriver_SikKullanilanlar {

    @Test
    public void Test1(){

        driver.get("http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwCheckBox");


        WebElement sali= driver.findElement(By.id("gwt-debug-cwCheckBox-Tuesday-input"));

        System.out.println("sali.isDisplayed() = " + sali.isDisplayed());
        System.out.println("sali.isEnabled() = " + sali.isEnabled());
        System.out.println("sali.isSelected() = " + sali.isSelected());

        MyFunc.Bekle(2);
        sali.click();
        MyFunc.Bekle(2);
        System.out.println("sali.isSelected() = " + sali.isSelected());

        WebElement carsamba= driver.findElement(By.id("gwt-debug-cwCheckBox-Wednesday-input"));

        System.out.println("carsamba.isDisplayed() = " + carsamba.isDisplayed());
        System.out.println("carsamba.isEnabled() = " + carsamba.isEnabled());
        System.out.println("carsamba.isSelected() = " + carsamba.isSelected());

        carsamba.click();
        System.out.println("carsamba.isSelected() = " + carsamba.isSelected());


        WebElement cumartesi= driver.findElement(By.id("gwt-debug-cwCheckBox-Saturday-input"));

        System.out.println("cumartesi.isDisplayed() = " + cumartesi.isDisplayed());
        System.out.println("cumartesi.isEnabled() = " + cumartesi.isEnabled());
        System.out.println("cumartesi.isSelected() = " + cumartesi.isSelected());

        carsamba.click();
        System.out.println("cumartesi.isSelected() = " + cumartesi.isSelected());

        // elementlerin özelliklerini almış olduk.

        BekleKapat();
/*
     sali.isDisplayed() = true
       sali.isEnabled() = true
      sali.isSelected() = false
      sali.isSelected() = true

 carsamba.isDisplayed() = true
   carsamba.isEnabled() = true
  carsamba.isSelected() = false
  carsamba.isSelected() = true

cumartesi.isDisplayed() = true
  cumartesi.isEnabled() = false
 cumartesi.isSelected() = false
 cumartesi.isSelected() = false
*/
    }
}
