package tests.practise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestMentoring {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void test1() throws InterruptedException {
        //go to url : https://en.wikipedia.org/wiki/Dell
        driver.get("https://en.wikipedia.org/wiki/Dell");
        //go to table which name is 'List of companies acquired by Dell Inc.'

        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN)
                .sendKeys(Keys.PAGE_DOWN)
                .sendKeys(Keys.PAGE_DOWN)
                .sendKeys(Keys.PAGE_DOWN)
                .sendKeys(Keys.PAGE_DOWN)
                .perform();
        Thread.sleep(2000);

        WebElement ListOfCompanies = driver.findElement(By.xpath("(//table[@class='wikitable sortable jquery-tablesorter'])"));
        Assert.assertTrue(ListOfCompanies.isDisplayed(), "liste görünmüyor");

        //print row 5 of the table on console

        String xPath = "//table[3]//tbody//tr[5]";
        String istenenData = driver.findElement(By.xpath(xPath)).getText();
        System.out.println(istenenData);

        //also print on console the 2nd and 3rd elements (middle 2 elements) in line 10
        String xPath2 = "//table[3]//tbody//tr[10]//td[1]";
        String xPath3 = "//table[3]//tbody//tr[10]//td[2]";
        String data2 = driver.findElement(By.xpath(xPath2)).getText();
        System.out.println("10. satırdaki 2.öge : " + data2);
        String data3 = driver.findElement(By.xpath(xPath3)).getText();
        System.out.println("10. satırdaki 3.öge : " + data3);

        //( 2nd and 3rd elements : April 2, 2012 A global market-leader for thin client systems)
        Assert.assertTrue(data2.equals("April 2, 2012"));
        Assert.assertTrue(data3.equals("A global market-leader for thin client systems."));

    }
        @AfterMethod
        public void tearDown(){

           driver.quit();
        }

    }