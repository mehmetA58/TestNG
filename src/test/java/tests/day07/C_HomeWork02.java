package tests.day07;

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

import java.util.concurrent.TimeUnit;

public class C_HomeWork02 {
    WebDriver driver;


    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    }

    @Test
    public void Test1() throws InterruptedException {
        driver.get("http://zero.webappsecurity.com/");
        driver.findElement(By.xpath("(//button[@id='signin_button'])")).click();
        driver.findElement(By.id("user_login")).sendKeys("username");
        driver.findElement(By.id("user_password")).sendKeys("password");
        driver.findElement(By.xpath("(//input[@value='Sign in'])")).click();
        driver.findElement(By.id("pay_bills_tab")).click();
        driver.findElement(By.xpath("//*[@id=\"tabs\"]/ul/li[3]/a")).click();
        Thread.sleep(2000);

        //1.adim locate
        WebElement dropDown=driver.findElement((By.xpath("//*[@id='pc_currency']")));
        //2.adim Select class'ından obje olustur
        Select select=new Select(dropDown);
        //3.adim istedigin option'u select objesi kullanarak seç
        select.selectByVisibleText("Eurozone (euro)");
        driver.findElement(By.id("pc_amount")).sendKeys("1000");
        Thread.sleep(2000);

      WebElement checkbox=driver.findElement(By.id("pc_inDollars_true"));
       Assert.assertFalse(checkbox.isSelected(),"checkbox tikli");
       Thread.sleep(2000);
        WebElement buton= driver.findElement(By.id("pc_inDollars_false"));
        Thread.sleep(2000);
        buton.click();
        driver.findElement(By.id("pc_calculate_costs")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("purchase_cash")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("alert_content")).isDisplayed();



    }
    @AfterClass
    public void tearDown(){

        driver.quit();
    }
}
