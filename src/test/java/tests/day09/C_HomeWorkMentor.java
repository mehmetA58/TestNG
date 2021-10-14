package tests.day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
//go to web site : https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/
//maximize the web site
//click on second emoji
//click all second emoji's element
//go back parent iframe
//fill out the form,(Fill the form with the texts you want)
//click on apply button
// web sitesini büyüt

// tüm ikinci emoji öğelerini tıklayın
// ana iframe'e geri dön
//formu doldurun,(Formu istediğiniz metinlerle doldurun)
// uygula butonuna tıklayın
public class C_HomeWorkMentor {
    WebDriver driver;


    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/");


    }

    @Test
    public void iframeTest() throws InterruptedException {
        // ikinci emojiye tıklayın
        int size = driver.findElements(By.tagName("iframe")).size();
        System.out.println("Total iFrames : " + size);
        WebElement iframe=driver.findElement(By.xpath("(//iframe[@id='emoojis'])"));
        driver.switchTo().frame(iframe);
        driver.findElement(By.xpath("(//span[@class='mdl-tabs__ripple-container mdl-js-ripple-effect'])[2]")).click();

        List<WebElement> emojis=driver.findElements(By.xpath("//*[@id=\"nature\"]/div/img"));
        emojis.stream().forEach(t->t.click());
        driver.switchTo().defaultContent();

        List<WebElement> forum=driver.findElements(By.xpath("(//input[@class='mdl-textfield__input'])"));

        List <String> inputTexts = new ArrayList<>(Arrays.asList("Hello World!", "Merhaba Javacanlar", "Turkey" ,"Kebab", "Java ile Hayat Cok Guzel", "İstanbul", "Adam" ,"58" , "34", "63", "63"));


        for (int i = 0; i <inputTexts.size() ; i++) {
            forum.get(i).sendKeys(inputTexts.get(i));
        }

        driver.findElement(By.id("send")).click();

    }





    @AfterClass
    public void tearDown() {

        driver.quit();
    }
}
