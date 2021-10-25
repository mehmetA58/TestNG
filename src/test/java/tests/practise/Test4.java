package tests.practise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Set;

public class Test4 {

    WebDriver driver;
    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
    }
    @Test
    public void test1() throws InterruptedException {
        // 1) https://www.ntv.com.tr/ ADRESİNE GİT
        driver.get("https://www.ntv.com.tr/");
        // 2) SAYFANIN TiTLE'NIN "NTV HABER - Haberler, Son Dakika Haberleri" OLDUGUNU DOGRULA
        String ActualTitle=driver.getTitle();
        String ExpcTitle="NTV HABER - Haberler, Son Dakika Haberleri";
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertTrue(ActualTitle.equals(ExpcTitle),"beklenen başlık yanlis");
        softAssert.assertAll();
        // 3) SAYFANIN HANDLE DEGERiNi AL.
       String sayfa1HandleDegeri=driver.getWindowHandle();
        System.out.println(sayfa1HandleDegeri);
        // 4) SPOR SAYFASINA TIKLA
        driver.findElement(By.xpath("(//a[@class='header-category-link spor'])")).click();

        Thread.sleep(3000);
        // 5) URL'iN "https://www.ntvspor.net/" OLDUGUNU DOGRULA
        String ikinciWindowHandles =" ";
        Set<String> tumHandles=driver.getWindowHandles();
        for (String w:tumHandles) {
            if (!w.equals(sayfa1HandleDegeri)){
                ikinciWindowHandles=w;
            }
        }
        driver.switchTo().window(ikinciWindowHandles);
        String ActualURL=driver.getCurrentUrl();
        System.out.println("ActualURL = " + ActualURL);
        String ExpURL="https://www.ntvspor.net/";
        SoftAssert softAssert1=new SoftAssert();
        softAssert1.assertTrue(ActualURL.equals(ExpURL),"url farkli");
        softAssert1.assertAll();
        // 6) ANA SAYFAYA GERi DON
        driver.switchTo().window(sayfa1HandleDegeri);

    }
    @AfterMethod
    public void tearDown(){

        driver.quit();
    }

}

