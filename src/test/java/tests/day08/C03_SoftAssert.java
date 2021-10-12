package tests.day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class C03_SoftAssert {
    //Yeni bir Class Olusturun : D10_SoftAssertTest
    //1. “http://zero.webappsecurity.com/” Adresine gidin
    WebDriver driver;


        @BeforeClass
        public void setup () {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        }
        @Test
        public void test () {

            driver.get("http://zero.webappsecurity.com/");
            // 2. Sign in butonuna basin
            driver.findElement(By.id("signin_button")).click();

            // 3. Login kutusuna “username” yazin
            driver.findElement(By.id("user_login")).sendKeys("username");
            // 4. Password kutusuna “password.” yazin
            driver.findElement(By.id("user_password")).sendKeys("password");
            // 5. Sign in tusuna basin
            driver.findElement(By.xpath("//*[@id=\"login_form\"]/div[2]/input")).click();
            // 6. Pay Bills sayfasina gidin
            driver.findElement(By.id("pay_bills_tab")).click();
            // 7. “Purchase Foreign Currency” tusuna basin
            driver.findElement(By.xpath("//*[@id=\"tabs\"]/ul/li[3]/a")).click();
            // 8. “Currency” drop down menusunden Eurozone’u secin

            //1.adim locate
            WebElement dropDown=driver.findElement((By.xpath("//*[@id='pc_currency']")));
            //2.adim Select class'ından obje olustur
            Select select=new Select(dropDown);
            //3.adim istedigin option'u select objesi kullanarak seç
            select.selectByVisibleText("Eurozone (euro)");

            // 9. soft assert kullanarak "Eurozone (Euro)" secildigini test edin
            String actualData=select.getFirstSelectedOption().getText();
            String expectedValue="Eurozone (euro)";

            SoftAssert softAssert = new SoftAssert();
            softAssert.assertEquals(actualData,expectedValue,"secilen option Eurozone(euro) degil");
            // 10. soft assert kullanarak DropDown listesinin su secenekleri oldugunu test edin "Select One", "Australia (dollar)", "Canada (dollar)","Switzerland (franc)","China (yuan)","Denmark (krone)","Eurozone (euro)","Great Britain (pound)","Hong Kong (dollar)","Japan (yen)","Mexico (peso)","Norway (krone)","New Zealand (dollar)","Sweden (krona)","Singapore (dollar)","Thailand (baht)"
             List<WebElement> tumOpsiyonlar= select.getOptions();
             List<String>opsiyonlar=new ArrayList<>();
           tumOpsiyonlar.stream().forEach(t->opsiyonlar.add(t.getText()));

           List<String> expectedOPtions= Arrays.asList("Select One", "Australia (dollar)", "Canada (dollar)","Switzerland (franc)","China (yuan)","Denmark (krone)","Eurozone (euro)","Great Britain (pound)","Hong Kong (dollar)","Japan (yen)","Mexico (peso)","Norway (krone)","New Zealand (dollar)","Sweden (krona)","Singapore (dollar)","Thailand (baht)");


           softAssert.assertEquals(opsiyonlar,expectedOPtions,"Liste farklı");

            softAssert.assertAll();


        }
        @AfterClass
        public void tearDown() {

           driver.quit();
        }
    }
