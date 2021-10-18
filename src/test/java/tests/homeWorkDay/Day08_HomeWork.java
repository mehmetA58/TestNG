package tests.homeWorkDay;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Day08_HomeWork {
    /**
     * Navigate to  https://www.saucedemo.com/
     * Enter the user name  as standard_user
     * Enter the password as   secret_sauce
     * Click on login button
     * Choose price low to high
     * Verify item prices are sorted from low to high
     */
    /**

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
        // * https://www.saucedemo.com/ adresine gidin
        //     * Kullanıcı adını standard_user olarak girin
        //     * Şifreyi secret_sauce olarak girin

        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        //Click on login button
        driver.findElement(By.id("login-button")).click();

        //* Choose price low to high
        //     * Verify item prices are sorted from low to high

        WebElement dropDown=driver.findElement(By.className("product_sort_container"));
        Select select=new Select(dropDown);
        select.selectByValue("lohi");
        List<WebElement> fiyatlar=driver.findElements(By.className("inventory_item_price"));
        List<String> fiyatlarString=new ArrayList<>();

        fiyatlar.stream().forEach(t->fiyatlarString.add(t.getText()));

        List<Double> fiyatlarDouble=new ArrayList<>();

        for (int i = 0; i < fiyatlarString.size() ; i++) {
            fiyatlarDouble.add(Double.parseDouble(fiyatlarString.get(i).replace("$","")));
        }

        for (int i = 1; i < fiyatlarDouble.size() ; i++) {
            if (fiyatlarDouble.get(i-1)<=fiyatlarDouble.get(i)){
                System.out.println("Test PASS");
            }else {
                System.out.println("Test FAİLED");
            }
        }
        System.out.println("fiyatlar : "+fiyatlar.toString());
        System.out.println("fiyatlarString"+fiyatlarString);
        System.out.println("fiyatlarDouble"+fiyatlarDouble);

    }
    @AfterClass
    public void tearDown() {

       driver.quit();
    }
}
