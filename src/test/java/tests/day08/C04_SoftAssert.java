package tests.day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.security.Key;
import java.util.concurrent.TimeUnit;

public class C04_SoftAssert {
    WebDriver driver;


    @BeforeClass
    public void setup () {
        //Yeni bir Class Olusturun : D11_SoftAssert1
        //1.“https://www.hepsiburada.com/” Adresine gidin
        //2.Basliginin “Turkiye’nin En Buyuk Alisveris Sitesi" icerdigini dogrulayin






        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    }
    @Test
    public void test () {

        driver.get("http://www.hepsiburada.com/");
            String title=driver.getTitle();
            //Türkiye'nin En Büyük Online Alışveriş Sitesi Hepsiburada.com
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertTrue(driver.getTitle().contains("Türkiye'nin En Büyük Online Alışveriş Sitesi Hepsiburada.com"),"title Türkiye'nin En Büyük Online Alışveriş Sitesi Hepsiburada.com icermiyor");

        //3.search kutusuna araba yazip arattirin
    driver.findElement(By.className("desktopOldAutosuggestTheme-input")).sendKeys("araba"+ Keys.ENTER);

        //4.bulunan sonuc sayisini yazdirin
    System.out.println("bulunan sonuc sayisi : "+driver.findElement(By.className("category-suggestion-title")).getText());

        //5.sonuc yazisinin "araba" icerdigini dogrulayin
        softAssert.assertTrue(driver.findElement(By.className("category-suggestion-title")).getText().contains("araba"),"sonuc yazisi araba icermiyor");
        //6.Sonuc yazisinin “oto” kelimesi icermedigini dogrulayin
        softAssert.assertTrue(driver.findElement(By.className("category-suggestion-title")).getText().contains("oto"),"sonuc yazisi oto icermiyor");

        softAssert.assertAll();
    }

    @AfterClass
    public void tearDown() {

       driver.quit();
    }


}
