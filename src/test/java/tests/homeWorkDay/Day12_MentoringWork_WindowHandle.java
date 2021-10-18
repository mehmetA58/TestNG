package tests.homeWorkDay;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Set;
import java.util.concurrent.TimeUnit;
/*
       url'ye gidin: http://demo.guru99.com/popup.php
       ilk pencereyi al
       buraya tıklayın butonuna tıklayın
       setteki tüm pencereyi al
       pencereye geç
       e-posta kimliğini (somepne@gmail.com) girin ve bu girişe bir şey yazın
       Gönder düğmesine tıklayarak
       başlığı beklendiği gibi doğrula
       ilk pencereye geç

      */
public class Day12_MentoringWork_WindowHandle {
    WebDriver driver;


    @BeforeClass
    public void setup () {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }
    @Test
    public void Test() throws InterruptedException {

        //go to url :http://demo.guru99.com/popup.php
        //      get the first window
        //      clicking on click here button
        //      get all the window in the set
        //      switch to window
        //      input email id (somepne@gmail.com) and type something in that input
        driver.get("http://demo.guru99.com/popup.php");
        String ilkPencere=driver.getWindowHandle();
        System.out.println("ilk pencere : "+ilkPencere);

        driver.findElement(By.linkText("Click Here")).click();
        Set<String> pencereler=driver.getWindowHandles();
        System.out.println(pencereler);


        String ikinciWindowhandle="";
        for (String each:pencereler) {
            if (!each.equals(ilkPencere)){
                ikinciWindowhandle=each;
            }
        }
        System.out.println("ikinci pencere"+ikinciWindowhandle);

        driver.switchTo().window(ikinciWindowhandle);
        Thread.sleep(2000);

       // Clicking on the submit button
        driver.findElement(By.xpath("(//input[@name='emailid'])")).sendKeys("somepne@gmail.com");
        driver.findElement(By.xpath("(//input[@name='btnLogin'])")).click();
        // verify title as expected
        SoftAssert softAssert= new SoftAssert();//-->test edin diyorsa hard assertion, verify diyorsa soft assertion
        softAssert.assertEquals(driver.findElement(By.tagName("h3")).getText(),"This access is valid only for 20 days.","Actual text does not equals expected text");
        softAssert.assertAll();
        //      switch to first window
        driver.switchTo().window(ilkPencere);

    }

    @AfterClass
    public void tearDown() {

         driver.quit();
    }
}

