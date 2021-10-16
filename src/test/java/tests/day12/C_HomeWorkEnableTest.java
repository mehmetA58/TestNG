package tests.day12;

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

public class C_HomeWorkEnableTest {
    WebDriver driver;


    @BeforeClass
    public void setup () {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }
    @Test
    public void iSEnebled() throws InterruptedException {
       driver.get("https://the-internet.herokuapp.com/dynamic_controls");
WebElement textBox=driver.findElement(By.xpath("(//input[@type='text'])"));
        SoftAssert softAssert= new SoftAssert();
        softAssert.assertTrue(textBox.isEnabled(),"TextBox etkin");


       driver.findElement(By.xpath("(//button[@onclick='swapInput()'])")).click();


        WebDriverWait wait=new WebDriverWait(driver,20);
        WebElement enableButon=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[@onclick='swapInput()'])")));
        Assert.assertTrue(enableButon.isDisplayed());

        softAssert.assertTrue(driver.findElement(By.id("message")).isEnabled(),"It's enabled! görünür değil");
        softAssert.assertTrue(driver.findElement(By.xpath("(//input[@type='text'])")).isEnabled(),"TextBox etkin değil");


    }
    @AfterClass
    public void tearDown() {

      //  driver.quit();
    }

    }
