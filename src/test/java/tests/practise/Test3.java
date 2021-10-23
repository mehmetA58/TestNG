package test.practise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class Test3 {

    // 1) "https://www.facebook.com/" SAYFASINA GiDiN
    // 2) YENi HESAP OLUSTUR BUTONUNA TIKLAYIN
    // 3) DOGUM TARiHi BOLUMUNDEKi GUNLERiN LiSTESiNi ALIN
    // 4) DOGUM TARiHi BOLUMUNDEKi AYLARIN LiSTESiNi ALIN
    // 5) DOGUM TARiHi BOLUMUNDEKi YILLARIN LiSTESiNi ALIN

    WebDriver driver;
    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
    }
    @Test
    public void test1() throws InterruptedException {
        driver.get("https://www.facebook.com/");
        driver.findElement(By.xpath("(//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy'])")).click();
        Thread.sleep(2000);
        WebElement dropdownGun=driver.findElement(By.name("birthday_day"));
        WebElement dropDownAy=driver.findElement(By.name("birthday_month"));
        WebElement dropDownYil=driver.findElement(By.name("birthday_year"));

        Select select=new Select(dropdownGun);



        List<WebElement> gunler=select.getOptions();
        System.out.println("=================gunler====================");
        for (WebElement w:gunler) {
            System.out.println(w.getText());
        }
        select=new Select(dropDownAy);
        List<WebElement> aylar=select.getOptions();
        System.out.println("=====================aylar========================");
        for (WebElement w:aylar) {
            System.out.println(w.getText());
        }
        select=new Select(dropDownYil);
        List<WebElement> yillar=select.getOptions();
        System.out.println("======================yillar================");
        for (WebElement w:yillar) {
            System.out.println(w.getText());
        }


    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
