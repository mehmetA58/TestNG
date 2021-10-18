package tests.homeWorkDay;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Day12_SundayWorkExplicitWaitTest {

    //SAYFA-151

    //Explicit Wait Class Work
//1. Bir class olusturun : ExplicitlyWaitTest
//2. Bir metod olusturun : enableTest()
//3. https://demoqa.com/dynamic-properties adresine gidin.
//4. Will enable 5 seconds’in etkin olmadigini(enabled) test edin
//5. Will enable 5 seconds etkin oluncaya kadar bekleyin ve enabled oldugunu test edin
//6. Bir metod olusturun : visibleTest()
//7. Ayni sayfaya tekrar gidin, Visible After 5 Seconds butonunun gorunmesini bekleyin,
//ve gorunur oldugunu test edin
WebDriver driver;


    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    }

    @Test
    public void enableTest()  {
        //3. https://demoqa.com/dynamic-properties adresine gidin.
        driver.get("https://demoqa.com/dynamic-properties");
        //4. Will enable 5 seconds’in etkin olmadigini(enabled) test edin
        WebElement enable5sn = driver.findElement(By.id("enableAfter"));
        Assert.assertFalse(enable5sn.isEnabled(), "Will enable 5 seconds etkin");//--->for says test we use HardAssert
        //5. Will enable 5 seconds etkin oluncaya kadar bekleyin ve enabled oldugunu test edin
        WebDriverWait wait=new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("enableAfter")));
        Assert.assertTrue(enable5sn.isEnabled(), "Will enable 5 seconds etkin değil");//--->for says test we use HardAssert
         }
    //6. Bir metod olusturun : visibleTest()
    @Test
    public void visibleTest(){
        //7. Ayni sayfaya tekrar gidin, Visible After 5 Seconds butonunun gorunmesini bekleyin,

         driver.get("https://demoqa.com/dynamic-properties");
            WebDriverWait weit=new WebDriverWait(driver,10);
             weit.until(ExpectedConditions.visibilityOfElementLocated(By.id("visibleAfter")));
                WebElement visibleButonAfter5Seconds=driver.findElement(By.id("visibleAfter"));


        //ve gorunur oldugunu test edin
        Assert.assertTrue(visibleButonAfter5Seconds.isDisplayed(),"visible5Seconds görünür degil");
    }
    @AfterClass
    public void tearDown(){

       driver.quit();
    }
}

