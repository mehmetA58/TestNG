package tests.day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class C_HomeWork {
    WebDriver driver;


    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://demo.guru99.com/test/guru99home/");


    }

    @Test
    public void iframeTest() throws InterruptedException {


        //  2) sayfadaki iframe sayısını bulunuz.
        int size = driver.findElements(By.tagName("iframe")).size();
        System.out.println("Sayfadaki IFrame sayisi : " + size);

        //  3) ilk iframe'deki (Youtube) play butonuna tıklayınız.
        driver.switchTo().frame(0);
//<iframe width="1280" height="720" src="https://www.youtube.com/embed/3iLlcFk8d7g" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
//<iframe width="1280" height="720" src="https://www.youtube.com/embed/EPXz7700lfY" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
        WebElement element = driver.findElement(By.xpath("//button[@class='ytp-large-play-button ytp-button']"));
        element.click();
        Thread.sleep(6000);

        //  4) ilk iframe'den çıkıp ana sayfaya dönünüz
        driver.switchTo().defaultContent();

        //  5) ikinci iframe'deki (Jmeter Made Easy) linke (https://www.guru99.com/live-selenium- project.html) tıklayınız
        driver.switchTo().frame(1);
        driver.findElement(By.xpath("//img[@src='Jmeter720.png']")).click();
        driver.switchTo().parentFrame();

    }




    @AfterClass
    public void tearDown() {

       driver.quit();
    }
}
