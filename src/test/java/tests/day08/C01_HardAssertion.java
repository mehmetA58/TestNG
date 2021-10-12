package tests.day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class C01_HardAssertion {
    //amazon sayfasina gidin
    //url'nin amazon içerdiğini test edin
    //title amazon içerdiğini test edin
    //java kelimesi aratın ve Listedeki ilk urunun java kelime icerdiğini test edin
    WebDriver driver;


    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    }

    @Test
    public void Test1() {
        driver.get("https://www.amazon.com/");
        String URL = driver.getCurrentUrl();
        Assert.assertTrue(URL.contains("amazon"));
        String Title = driver.getTitle();
        Assert.assertTrue(Title.contains("Amazon"));
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("java" + Keys.ENTER);
        String result1 = driver.findElement(By.xpath("(//span[@class='a-size-base-plus a-color-base a-text-normal'])[1]")).getText();
        Assert.assertTrue(result1.contains("java"));

    }

    @AfterClass
    public void tearDown() {

        driver.quit();
    }
}