package tests.homeWorkDay;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.collections.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;

/*
    ~ Navigate to http://tutorialsninja.com/demo/index.php?route=common/home
    ~ click on Phones & PDAs
    ~ get the brandName of phones
    ~ click on add to button for all elements
    ~ click on black total added cart button
    ~ get the names of list from the cart
    ~ compare the names from displaying list and cart list

*/
//clickAllElements
//getName
//compareTwoList
public class Day13_HomeWork {
    List<String> markaAdlarıSepet=new ArrayList<>();
    WebDriver driver;
    List<String> AddToCartAdlarıSepet=new ArrayList<>();
    @BeforeClass
    public void setup () {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);


    }

    @Test (priority = 1)
    public void clickAllElements()  {
      //http://tutorialsninja.com/demo/index.php?route=common/home adresine gidin
        driver.get("http://tutorialsninja.com/demo/index.php?route=common/home");
        // ~ Telefonlar ve PDA'lara tıklayın
        driver.findElement(By.linkText("Phones & PDAs")).click();


    }
    @Test (priority = 2)
    public void getName() throws InterruptedException {
        //~ telefonların marka adını alın

        List<WebElement> markaAdları=driver.findElements(By.tagName("h4"));
        for (WebElement w:markaAdları) {
            markaAdlarıSepet.add(w.getText());
        }
        System.out.println(markaAdlarıSepet.size());
        System.out.println(markaAdlarıSepet.get(0));
        System.out.println(markaAdlarıSepet.get(1));
        System.out.println(markaAdlarıSepet.get(2));

        //~ tüm öğeler için ekle düğmesine tıklayın
List<WebElement> AddToCart=driver.findElements(By.xpath("//span[text()='Add to Cart']"));
        for (WebElement w:AddToCart) {
            w.click();
        }
Thread.sleep(2000);
       // AddToCart.stream().forEach(t->t.click());
        //  ~ siyah toplam eklenen sepet düğmesine tıklayın
        driver.findElement(By.xpath("(//span[@id='cart-total'])")).click();


    }

    @Test (priority = 3)
    public void compareTwoList(){

        // ~ listenin isimlerini sepetten alın
List<WebElement> compareList=driver.findElements(By.xpath("(//td[@class='text-left'])"));

        for (WebElement w:compareList) {
        AddToCartAdlarıSepet.add(w.getText());
        }
        System.out.println(AddToCartAdlarıSepet.get(0));
        System.out.println(AddToCartAdlarıSepet.get(1));
        System.out.println(AddToCartAdlarıSepet.get(2));

        //  ~ listeden ve sepet listesinden isimleri karşılaştırın
        Collections.sort(markaAdlarıSepet);
        Collections.sort(AddToCartAdlarıSepet);

        Assert.assertEquals(markaAdlarıSepet,AddToCartAdlarıSepet,"listeler eşit degil");

    }



    @AfterClass
        public void tearDown() {
        driver.quit();

    }

    }
