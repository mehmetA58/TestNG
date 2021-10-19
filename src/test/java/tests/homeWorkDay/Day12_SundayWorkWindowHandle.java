package tests.homeWorkDay;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

//SAYFA-155

//Window Handle Home Work
//1."http://webdriveruniversity.com/" adresine gidin
//2."Login Portal" a kadar asagi inin
//3."Login Portal" a tiklayin
//4.Diger window'a gecin
//5."username" ve "password" kutularina deger yazdirin
//6."login" butonuna basin
//7.Popup'ta cikan yazinin "validation failed" oldugunu test edin
//8.Ok diyerek Popup'i kapatin
//9.Ilk sayfaya geri donun
//10.Ilk sayfaya donuldugunu test edin

public class Day12_SundayWorkWindowHandle {
    WebDriver driver;



    @BeforeClass
    public void setup () {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);


    }
    @Test
    public void test() throws InterruptedException {

        //1."http://webdriveruniversity.com/" adresine gidin
        driver.get("http://webdriveruniversity.com/");
        //2."Login Portal" a kadar asagi inin
        //3."Login Portal" a tiklayin
        String birinciSayfaHandle=driver.getWindowHandle();//birinci sayfanın handle nosunu getirir.
        driver.findElement(By.id("login-portal")).click();
        //4.Diger window'a gecin
        String ikinciWindowHandleNo="";
        Set<String> tumHandllar=driver.getWindowHandles();
        for (String w:tumHandllar) {
            if (!w.equals(birinciSayfaHandle)){
                ikinciWindowHandleNo=w;
            }
        }
        driver.switchTo().window(ikinciWindowHandleNo);
        //5."username" ve "password" kutularina deger yazdirin
        driver.findElement(By.id("text")).sendKeys("mehmet");
        driver.findElement(By.id("password")).sendKeys("2021");
        //6."login" butonuna basin
        driver.findElement(By.id("login-button")).click();

        //7.Popup'ta cikan yazinin "validation failed" oldugunu test edin
       String popupYazisi=driver.switchTo().alert().getText();
        System.out.println(popupYazisi);
        String expectedPopupYazisi="validation failed";

        Assert.assertTrue(popupYazisi.equals(expectedPopupYazisi),"popup yazisi beklendiği gibi değil"); //-->test edin dediği için Hard Assert



        //8.Ok diyerek Popup'i kapatin
        driver.switchTo().alert().accept();

        //9.Ilk sayfaya geri donun
        driver.switchTo().window(birinciSayfaHandle);

        //10.Ilk sayfaya donuldugunu test edin
        String actualURL=driver.getCurrentUrl();
        String expURL="http://webdriveruniversity.com/";

        Assert.assertTrue(actualURL.equals(expURL),"birinci sayfa URL beklendiği gibi değil");
        //-->test edin dediği için Hard Assert




    }




    @AfterClass
    public void tearDown() {

        driver.quit();
    }
}

