package tests.day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class C01_Alerts {
    //● Bir class olusturun: C01_Alerts
    //● https://the-internet.herokuapp.com/javascript_alerts adresine gidin.
    //● Bir metod olusturun: acceptAlert
    //        ○ 1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının       “You successfully clicked an alert” oldugunu test edin.
    //● Bir metod olusturun: dismissAlert
    //        ○ 2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının    “successfuly” icermedigini test edin.

    WebDriver driver;


    @BeforeClass
    public void setup () {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

    }
    @Test
    public void acceptAlert (){
        driver.findElement(By.xpath("(//button[@onclick='jsAlert()'])")).click();
        driver.switchTo().alert().accept();
       String Alertresult= driver.findElement(By.id("result")).getText();
       String expectedMessage="You successfully clicked an alert";
        SoftAssert softAssert=new SoftAssert();

        softAssert.assertTrue(expectedMessage.equals(Alertresult),"mesaj eslesmedi");

        softAssert.assertAll();



    }
    @Test
    public void dismissAlert(){
        driver.findElement(By.xpath("(//button[@onclick='jsConfirm()'])")).click();
        driver.switchTo().alert().accept();
        String actualResult=driver.findElement(By.id("result")).getText();
        String expectedResult="successfuly";
        SoftAssert softAssert=new SoftAssert();

        softAssert.assertFalse(actualResult.equals(expectedResult),"successfuly icermiyor");

        softAssert.assertAll();

    }
    @Test
    public void sendKeysAlert() throws InterruptedException {
        //● Bir metod olusturun: sendKeysAlert
        //3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna     tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.

        driver.findElement(By.xpath("(//button[@onclick='jsPrompt()'])")).click();

        String expectedName="MehmetAkbayir";
        driver.switchTo().alert().sendKeys(expectedName);

        driver.switchTo().alert().accept();
        String actualName=driver.findElement(By.id("result")).getText();

        SoftAssert softAssert=new SoftAssert();

        softAssert.assertTrue(actualName.contains(expectedName));

        softAssert.assertAll();
    }







    @AfterClass
    public void tearDown() {

        driver.quit();
    }
}
