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
        driver.get("https://demo.guru99.com/test/guru99home/");

    }

    @Test
    public void iframeTest() {
        List<WebElement> youtubeSize=new ArrayList<>(driver.findElements(By.linkText("iframe")));
        for (int i = 0; i < youtubeSize.size() ; i++) {
            System.out.println(youtubeSize.get(i).getText());
        }
       //WebElement ilkİframe= (WebElement) driver.switchTo().frame("By.xpath(//*[@id=\"rt-showcase\"]/div/div[1]/div/div/div/div/div[2]/div/div/iframe");
       // ilkİframe.click();
        driver.switchTo().defaultContent();
WebElement ikinciFrame= (WebElement) driver.switchTo().frame("a077aa5e");
ikinciFrame.click();



    }

    @AfterClass
    public void tearDown() {

       // driver.quit();
    }
}
