package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class TestBase {
   protected  WebDriver driver;
   //biz test base class'i sadece extends ile inherit ederek kullanacagiz
    //dolayısıyla olusturdugunuz driver variable'i için protected acces modifier'i seciyoruz
    //


    @BeforeClass
    public void setup () {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);


    }

    @AfterClass
    public void tearDown() {

       // driver.quit();
    }
}
