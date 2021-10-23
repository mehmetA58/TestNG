package tests.practise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Test2 {
    // 4 TEST METODU OLUSTURUN
    // https://www.n11.com/ SAYFASINA GiDİN.
    // https://www.gittigidiyor.com/ SAYFASINA GiDiN
    // https://getir.com/ SAYFASINA GiDiN
    // https://www.sahibinden.com/ SAYFASINA GiDiN

    WebDriver driver;
    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
    }
    @Test
    public void test1(){
        driver.get("https://www.n11.com/");
        System.out.println(driver.getTitle());

    }
    @Test
    public void test2(){
        driver.get("https://www.gittigidiyor.com/");
        System.out.println(driver.getTitle());
    }
    @Test
    public void test3(){
        driver.get("https://getir.com/ ");
        System.out.println(driver.getTitle());
    }
    @Test
    public void test4(){
        driver.get("https://www.sahibinden.com/");
        System.out.println(driver.getTitle());
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
