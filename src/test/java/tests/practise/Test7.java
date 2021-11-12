package tests.practise;



// 4) 5. URUNUN UZERiNE GELiP Add to chart YAPIN
// 5) CHART a gelin 3 ürün olduğunu doğrulayın
// 6) CHART'A GELiP Chek out TIKLAYIN
// 7) toplam alışveriş miktarının 108.97 olduğunu doğrula

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class Test7 extends TestBase {

    @Test
    public void test() throws InterruptedException {
        // 1) "http://automationpractice.com/" ADRESiNE GiDiN
        driver.get("http://automationpractice.com/");

        // 2) 2. URUNUN UZERiNE GELiP Add to chart YAPIN

        Actions actions = new Actions(driver);

        Thread.sleep(3000);
        WebElement birinciUrun = driver.findElement(By.xpath("//img[@title='Blouse']"));
        actions.moveToElement(birinciUrun).perform();

        driver.findElement(By.xpath("(//*[text()='Add to cart'])[2]")).click();
        driver.findElement(By.xpath("//span[@title='Continue shopping']")).click();

        // 3) 4. URUNUN UZERiNE GELiP Add to chart YAPIN

        Thread.sleep(3000);
        WebElement ikinciUrun = driver.findElement(By.xpath("(//img[@title='Printed Dress'])[2]"));
        actions.moveToElement(ikinciUrun).perform();

        driver.findElement(By.xpath("(//*[text()='Add to cart'])[4]")).click();
        driver.findElement(By.xpath("//span[@title='Continue shopping']")).click();

        // 4) 5. URUNUN UZERiNE GELiP Add to chart YAPIN

        Thread.sleep(3000);
        WebElement ucuncuUrun = driver.findElement(By.xpath("(//img[@title='Printed Summer Dress'])[1]"));
        actions.moveToElement(ucuncuUrun).perform();

        driver.findElement(By.xpath("(//*[text()='Add to cart'])[5]")).click();
        driver.findElement(By.xpath("//span[@title='Continue shopping']")).click();

        // 5) CHART a gelin 3 ürün olduğunu doğrulayın

        String actualUrunSayisi =
                driver.findElement(By.xpath("//span[@class='ajax_cart_quantity unvisible']")).getText();
        String expectedUrunSayisi = "3";
        System.out.println(actualUrunSayisi);

        Assert.assertEquals(actualUrunSayisi, expectedUrunSayisi, "URUN SAYISI HATALI");

        // 6) CHART'A GELiP Chek out TIKLAYIN

        WebElement chart = driver.findElement(By.xpath("//a[@title='View my shopping cart']"));
        actions.moveToElement(chart).perform();

        driver.findElement(By.xpath("//a[@title='Check out']")).click();

        // 7) TOPLAM ALISVERiS MiKTARININ 108.97 OLDUGUNU DOGRULA

        WebElement totalPrice = driver.findElement(By.xpath("//span[@id='total_price']"));
        String actualPrice = totalPrice.getText();
        String expectedPrice = "$108.97";

        System.out.println("ALISVERiS TOPLAMI : " + totalPrice.getText());

        Assert.assertEquals(actualPrice, expectedPrice, "PRiCE HATALI");
    }
}