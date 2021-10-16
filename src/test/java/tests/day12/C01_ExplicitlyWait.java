package tests.day12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBase;

public class C01_ExplicitlyWait extends TestBase {
    //1. Bir class olusturun : C01_WaitTest
    //2. Iki tane metod olusturun : implicitWait() , explicitWait()
    //  Iki metod icin de asagidaki adimlari test edin.





    @Test
    public void implicitWait(){
        //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        //4. Remove butonuna basin.
        driver.findElement(By.xpath("(//button[@onclick='swapCheckbox()'])")).click();
        //5. “It’s gone!” mesajinin goruntulendigini dogrulayin.

        SoftAssert softAssert=new SoftAssert();
        WebElement sonucYazisi=driver.findElement(By.id("message"));
        softAssert.assertTrue(sonucYazisi.isDisplayed());
        softAssert.assertAll();
        //6. Add buttonuna basin
        driver.findElement(By.xpath("(//button[@onclick='swapCheckbox()'])")).click();
        //7. It’s back mesajinin gorundugunu test edin
        SoftAssert softAssert1=new SoftAssert();
        WebElement result=driver.findElement(By.id("message"));
        softAssert.assertTrue(result.isDisplayed());
        softAssert.assertAll();

    }
    @Test
    public void explicitWait(){
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        driver.findElement(By.xpath("(//button[@onclick='swapCheckbox()'])")).click();
        //5. “It’s gone!” mesajinin goruntulendigini dogrulayin.
        WebDriverWait wait=new WebDriverWait(driver,20);
        //ezpilcitly wait'i istersek locate işlemi ile birlikte tek satırda yapabiliriz

        WebElement yaziLocateIleBirlikte=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
        Assert.assertTrue(yaziLocateIleBirlikte.isDisplayed());

        //veya once locate edip uygun method kullanarak beklemeyi birlikte yapabiliriz

//        WebElement sonucYazisi=driver.findElement(By.id("message"));
//        wait.until(ExpectedConditions.visibilityOf(sonucYazisi));
//        Assert.assertTrue(sonucYazisi.isDisplayed());

        //6. Add buttonuna basin
        driver.findElement(By.xpath("(//button[@onclick='swapCheckbox()'])")).click();

        //7. It’s back mesajinin gorundugunu test edin
        WebElement itsBackLocateIle=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
        Assert.assertTrue(itsBackLocateIle.isDisplayed());
    }

}
