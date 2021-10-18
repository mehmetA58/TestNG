package tests.homeWorkDay;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
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
        driver.get("http://webdriveruniversity.com/");

        String ilkSayfaHandleNo=driver.getWindowHandle();

        driver.findElement(By.xpath("//*[@id=\"login-portal\"]/div/div[1]/h1")).click();

        Set<String> tumWindowHandleNo=driver.getWindowHandles();
        String ikinciSayfaHandleNo="";
        for (String each:tumWindowHandleNo) {
            if (!each.equals(ilkSayfaHandleNo)){
               ikinciSayfaHandleNo=each;
            }
        }
        driver.switchTo().window(ikinciSayfaHandleNo);
        driver.findElement(By.id("text")).sendKeys("username");
        driver.findElement(By.id("password")).sendKeys("password");
        driver.findElement(By.id("login-button")).click();
        //7.Popup'ta cikan yazinin "validation failed" oldugunu test edin
        String ActualResult=driver.switchTo().alert().getText();
        String ExpectedResult="validation failed";
        //-->test edin dediği için Hard Assert
        Assert.assertEquals(ActualResult, ExpectedResult,"beklenen popup mesajı hatalı");
        //8.Ok diyerek Popup'i kapatin
        driver.switchTo().alert().accept();
        String ikinciSayfaTitle=driver.getTitle();
        //9.Ilk sayfaya geri donun
        driver.switchTo().window(ilkSayfaHandleNo);
        //10.Ilk sayfaya donuldugunu test edin
        String ilkSayfaTitle=driver.getTitle();
        //-->test edin dediği için Hard Assert
        System.out.println("ilk sayfa Title : "+ilkSayfaTitle);
        System.out.println("ikici sayfa Title : "+ikinciSayfaTitle);
        Assert.assertEquals(ilkSayfaTitle,"WebDriverUniversity.com","beklenen title hatalı");



    }




    @AfterClass
    public void tearDown() {

        driver.quit();
    }
}

