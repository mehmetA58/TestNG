package tests.homeWorkDay;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Day10_HomeWork {




  WebDriver driver;



    @BeforeClass
    public void setup () {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);


    }
    @Test
    public void test() {
        //Go to http://demo.guru99.com/test/drag_drop.html url


        driver.get("http://demo.guru99.com/test/drag_drop.html");
        Actions action = new Actions(driver);
        //     Drag and drop the second 5000 button to the Amount section in CREDIT SIDE

        //     Drag and drop the BANK button to the Account section in DEBIT SIDE
        WebElement bankButon=driver.findElement(By.xpath("(//li[@class='block14 ui-draggable'])"));
        WebElement debitSide=driver.findElement(By.id("bank"));
        action.dragAndDrop(bankButon, debitSide).build().perform();
        //     Drag and drop the SALES button to the Account section in CREDIT SIDE
        WebElement salesButon=driver.findElement(By.xpath("(//li[@class='block15 ui-draggable'])"));
        WebElement creditSide=driver.findElement(By.id("loan"));
        action.dragAndDrop(salesButon,creditSide).build().perform();
        //     Drag and drop the 5000 button to the Amount section in DEBIT SIDE
        WebElement besBin=driver.findElement(By.xpath("(//li[@id='fourth'])[1]"));
        WebElement amountDebitSide=driver.findElement(By.id("amt7"));
        action.dragAndDrop(besBin,amountDebitSide).perform();

        //     Drag and drop the second 5000 button to the Amount section in CREDIT SIDE
        WebElement ikinciBesBin=driver.findElement(By.xpath("(//li[@id='fourth'])[2]"));
        WebElement creditSideAmount=driver.findElement(By.id("amt8"));
        action.dragAndDrop(ikinciBesBin,creditSideAmount).perform();
    }
    @AfterClass
    public void tearDown() {

       // driver.quit();
    }
}

