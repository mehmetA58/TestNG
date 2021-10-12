package tests.day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class C02_Softassertion {
    WebDriver driver;


    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    }
    @Test
    public void test(){
        SoftAssert softAssert=new SoftAssert();
        driver.get("https://www.amazon.com/");

        //url'nin amazon içerdiğini test edin
        softAssert.assertTrue(driver.getCurrentUrl().contains("amazon"),"url amazon icermiyor");

        //title amazon içerdiğini test edin
        softAssert.assertTrue(driver.getTitle().contains("amazon"),"title amazon icermiyor");

        //java kelimesi aratın ve Listedeki ilk urunun java kelime icerdiğini test edin
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("java" + Keys.ENTER);
        String result1 = driver.findElement(By.xpath("(//span[@class='a-size-base-plus a-color-base a-text-normal'])[1]")).getText();
        softAssert.assertTrue(result1.contains("java"),"ilk urun java icermiyor");

        softAssert.assertAll();

    }
    @AfterClass
    public void tearDown() {

        driver.quit();
    }
}
