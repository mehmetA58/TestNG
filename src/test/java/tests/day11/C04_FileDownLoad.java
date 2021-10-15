package tests.day11;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

public class C04_FileDownLoad extends TestBase {
    //1. Tests packagenin altina bir class oluşturalim : C04_FileDownload
        //2. Iki tane metod oluşturun : isExist() ve downloadTest()



    @Test
    public void downloadTest() throws InterruptedException {
        //3. downloadTest () metodunun icinde aşağıdaki testi yapalim:
        // - https://the-internet.herokuapp.com/download adresine gidelim.
        // - logo.png dosyasını indirelim

        driver.get("https://the-internet.herokuapp.com/download");
        driver.findElement(By.xpath("(//a[text()='logo.png'])")).click();
        Thread.sleep(6000);

    }
    @Test
    public void isExist(){
        //4. Ardından isExist()  methodunda dosyanın başarıyla indirilip indirilmediğini test edelim
        String dosyaYolu=System.getProperty("user.home")+"\\Downloads\\logo.png";
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));


    }
}
