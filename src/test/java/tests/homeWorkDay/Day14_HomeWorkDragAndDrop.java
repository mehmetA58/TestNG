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

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Day14_HomeWorkDragAndDrop {
    ///*
    //    go to url : http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html
    //    Fill in capitals by country
    //     */

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
            driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
            WebElement oslo=driver.findElement(By.id("box1"));
            WebElement stockholm=driver.findElement(By.id("box2"));
            WebElement washington=driver.findElement(By.id("box3"));
            WebElement copenhang=driver.findElement(By.id("box4"));
            WebElement seoul=driver.findElement(By.id("box5"));
            WebElement rome=driver.findElement(By.id("box6"));
            WebElement madrid=driver.findElement(By.id("box7"));
            WebElement norway=driver.findElement(By.id("box101"));
            WebElement sweden=driver.findElement(By.id("box102"));
            WebElement unitedStates =driver.findElement(By.id("box103"));
            WebElement denmark=driver.findElement(By.id("box104"));
            WebElement sKorea=driver.findElement(By.id("box105"));
            WebElement ıtaly=driver.findElement(By.id("box106"));
            WebElement spain=driver.findElement(By.id("box107"));

            Actions actions=new Actions(driver);
            actions.dragAndDrop(oslo,norway).perform();
            actions.dragAndDrop(stockholm,sweden).perform();
            actions.dragAndDrop(washington,unitedStates).perform();
            actions.dragAndDrop(copenhang,denmark).perform();
            actions.dragAndDrop(seoul,sKorea).perform();
            actions.dragAndDrop(rome,ıtaly).perform();
            actions.dragAndDrop(madrid,spain).perform();
        }
        @AfterClass
    public void tearDown(){
           // driver.quit();
        }
        }

