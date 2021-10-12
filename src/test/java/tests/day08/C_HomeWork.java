package tests.day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class C_HomeWork {
    /**
     * Navigate to  https://www.saucedemo.com/
     * Enter the user name  as standard_user
     * Enter the password as   secret_sauce
     * Click on login button
     * Choose price low to high
     * Verify item prices are sorted from low to high
     */
    /**
     * https://www.saucedemo.com/ adresine gidin
     * Kullanıcı adını standard_user olarak girin
     * Şifreyi secret_sauce olarak girin
     * Giriş düğmesine tıklayın
     * Düşükten yükseğe fiyatı seçin
     * Ürün fiyatlarının düşükten yükseğe doğru sıralandığını doğrulayın
     */
    WebDriver driver;


    @BeforeClass
    public void setup () {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    }
    @Test
    public void test () throws InterruptedException {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
      driver.findElement(By.xpath("(//div[@class='inventory_item_price'])"));

        List<WebElement> Sirasizvalues = new ArrayList<>();
        List<WebElement> Sirasizelements =driver.findElements(By.xpath("(//div[@class='inventory_item_price'])"));
        for (int i=0;i<Sirasizelements.size();i++) {
            Sirasizvalues.add(Sirasizelements.get(i));
        }
        for(int i=0;i<Sirasizvalues.size();i++){
            System.out.println(Sirasizvalues.get(i).getText());
        }

        System.out.println("======================================================================================");
Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div[2]/span/select/option[3]")).click();
Thread.sleep(3000);
        List<WebElement> values = new ArrayList<>();
        List<WebElement> elements =driver.findElements(By.xpath("(//div[@class='inventory_item_price'])"));
        for (int i=0;i<elements.size();i++) {
            values.add((elements.get(i)));
        }
        for(int i=0;i<values.size();i++){
            System.out.println(values.get(i).getText());
        }


        if (Sirasizvalues.equals(values)){
            System.out.println("Test FAİLED");
        }else {
            System.out.println("Test PASS");
        }

    }





    @AfterClass
    public void tearDown() {

        driver.quit();
    }
}
