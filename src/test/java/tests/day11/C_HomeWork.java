package tests.day11;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;
/*
    Yeni Class olusturun ActionsClassHomeWork
1- "http://webdriveruniversity.com/Actions" sayfasina gidin
*/

public class C_HomeWork {
    WebDriver driver;
    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }
    @Test
    public void Test() throws InterruptedException {
        driver.get("http://webdriveruniversity.com/Actions");
//2- Hover over Me First" kutusunun ustune gelin
        Actions actions = new Actions(driver);
        WebElement mouseHover = driver.findElement(By.xpath("(//div[@class='dropdown hover'])"));
        actions.moveToElement(mouseHover);
        actions.perform();
        //Thread.sleep(2000);
        //3- Link 1" e tiklayin
        driver.findElement(By.xpath("//*[@id=\"div-hover\"]/div[1]/div/a")).click();
        //4- Popup mesajini yazdirin
        System.out.println( driver.switchTo (). alert (). getText ());
        //5- Popup'i tamam diyerek kapatin
        driver.switchTo (). alert (). accept ();
        //6- “Click and hold" kutusuna basili tutun
        WebElement clickAndHold=driver.findElement(By.id("click-box"));
        Actions action = new Actions(driver);

        action.clickAndHold(clickAndHold).perform();
       // 7-“Click and hold" kutusunda cikan yaziyi yazdirin
        System.out.println(driver.findElement(By.id("click-box")).getText());

        //8- “Double click me" butonunu cift tiklayin
        WebElement doubleClickMe=driver.findElement(By.tagName("h2"));
        action.doubleClick(doubleClickMe).perform();
    }
    @AfterClass
    public void tearDown() {

        driver.quit();
    }
}
