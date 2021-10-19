package tests.homeWorkDay;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
//SAYFA--154
//Iframe Home Work
//1. “http://webdriveruniversity.com/IFrame/index.html” sayfasina gidin
//2. “Our Products” butonuna basin
//3. “Cameras product”i tiklayin
//4. Popup mesajini yazdirin
//5. “close” butonuna basin
//6. "WebdriverUniversity.com (IFrame)" linkini tiklayin
//7. "http://webdriveruniversity.com/index.html" adresine gittigini test edin

public class Day12_Sunday_HomeWorkIframe {
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
        //1. “http://webdriveruniversity.com/IFrame/index.html” sayfasina gidin
        driver.get("http://webdriveruniversity.com/IFrame/index.html");

        driver.switchTo().frame(0);

        //2. “Our Products” butonuna basin
        driver.findElement(By.linkText("Our Products")).click();
        //3. “Cameras product”i tiklayin
    driver.findElement(By.id("camera-img")).click();
        //4. Popup mesajini yazdirin
        Thread.sleep(2000);
    String popupMesajı=driver.findElement(By.xpath("(//div[@class='modal-header'])")).getText();
    String popupmesaji2=driver.findElement(By.xpath("(//div[@class='modal-body'])")).getText();
    System.out.println(popupMesajı+popupmesaji2);


        //5. “close” butonuna basin

driver.findElement(By.xpath("(//button[text()='Close'])")).click();
        //6. "WebdriverUniversity.com (IFrame)" linkini tiklayin
        driver.switchTo().defaultContent();
driver.findElement(By.xpath("(//a[@id='nav-title'])[1]")).click();

        //7. "http://webdriveruniversity.com/index.html" adresine gittigini test edin
        String actualURL=driver.getCurrentUrl();
        String expURL="http://webdriveruniversity.com/index.html";

        Assert.assertTrue(actualURL.equals(expURL),"url beklendiği gibi değil");
        //-->test edin dediği için Hard Assert

    }

    @AfterClass
    public void tearDown() {

         driver.quit();
    }
}

