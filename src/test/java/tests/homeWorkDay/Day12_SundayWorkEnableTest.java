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
import org.testng.asserts.SoftAssert;

import java.time.Instant;
import java.util.concurrent.TimeUnit;
//SAYFA-150
//Explicit Wait Class Work
//1. Bir class olusturun : EnableTest
//2. Bir metod olusturun : isEnabled()
//3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
//4. Textbox’in etkin olmadigini(enabled) dogrulayın
//5. Enable butonuna tıklayın ve textbox etkin oluncaya kadar bekleyin
//6. “It’s enabled!” mesajinin goruntulendigini dogrulayın.
//7. Textbox’in etkin oldugunu(enabled) dogrulayın.
public class Day12_SundayWorkEnableTest {
    WebDriver driver;


    @BeforeClass
    public void setup () {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }
    @Test
    public void isEnabledTest() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        WebElement textBox=driver.findElement(By.xpath("//input[@type='text']"));
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertFalse(textBox.isEnabled(),"TextBox erişilebilir durumda");




        driver.findElement(By.xpath("(//button[@onclick='swapInput()'])")).click();


       WebDriverWait wait=new WebDriverWait(driver,10);
        WebElement enableButon=wait.until(ExpectedConditions.elementToBeClickable(textBox));

    WebElement actText=driver.findElement(By.id("message"));


        softAssert.assertTrue(actText.isDisplayed(),"It's enabled! görünür değil");//görüntülenebiliyor mu?
        softAssert.assertTrue(driver.findElement(By.xpath("(//button[@onclick='swapInput()'])")).isEnabled(),"TextBox etkin değil");

        softAssert.assertAll();
    }
    @AfterClass
    public void tearDown() {

       driver.quit();
    }

    }
