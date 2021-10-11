package tests.day07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class C_HomeWork {
    //● Bir class oluşturun: C3_DropDownAmazon
    //● https://www.amazon.com/ adresine gidin.
    //- Test 1
    //Arama kutusunun yanindaki kategori menusundeki kategori
    //sayisinin 45 oldugunu test edin
    //-Test 2
    //1. Kategori menusunden Books secenegini secin
    //2. Arama kutusuna Java yazin ve aratin
    //3. Bulunan sonuc sayisini yazdirin
    //4. Sonucun Java kelimesini icerdigini test edin

    WebDriver driver;


    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    }
    @Test (priority = 1)
    public void Test1(){
        driver.get("https://www.amazon.com/");
        //1.adim locate
        WebElement dropDown=driver.findElement(By.id("searchDropdownBox"));
        //2.adim Select class'ından obje olustur
        Select select=new Select(dropDown);
        //3.adim istedigin option'u select objesi kullanarak seç
        List<WebElement> kategori=select.getOptions();
        System.out.println("kategori menüsünde "+kategori.size()+" tane öge var");
        Assert.assertTrue(kategori.size()==45,"kategori menusundeki kategori sayisinin 45 mi testti?");

    }
    @Test (priority = 2)
    public void Test2() throws InterruptedException {

        //1.adim locate

        WebElement dropDown=driver.findElement(By.id("searchDropdownBox"));

        //2.adim Select class'ından obje olustur
        Select select=new Select(dropDown);
       select.selectByVisibleText("Books");
       Thread.sleep(3000);

    driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java"+ Keys.ENTER);
    WebElement result=driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        System.out.println(result.getText());
        Assert.assertTrue(result.getText().contains("Java"),"sonuc Java kelimesi iceriyor mu?");

    }
    @AfterClass
    public void tearDown(){

      driver.quit();
    }
}

