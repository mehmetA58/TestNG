package tests.day11;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class C_HomeWork02 {
    //    go to url :http://demo.automationtesting.in/Alerts.html
    //    click  "Alert with OK" and click 'click the button to display an alert box:'
    //    accept Alert(I am an alert box!) and print alert on console

    //    click "Alert with OK & Cancel" and click 'click the button to display a confirm box'
    //    cancel Alert  (Press a Button !)
    //    click "Alert with Textbox" and click 'click the button to demonstrate the prompt box'
    //    and then sendKeys 'TechProEducation' (Please enter your name)
    //    finally print on console this mesaaje "Hello TechproEducation How are you today"







    WebDriver driver;
    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }
    @Test
    public void Test() throws InterruptedException {
        //     URL'ye gidin: http: //demo.automationtesting.in/alerts.html
        driver.get("http://demo.automationtesting.in/Alerts.html");
        //     "Tamam ile Uyarı" nı tıklayın ve 'Bir uyarı kutusu görüntülemek için' düğmesini tıklayın: '
        //     Uyarıyı Kabul Et (Ben bir uyarı kutusuyum!) Ve konsoldaki uyarıları yazdır
        WebElement click = driver.findElement(By.xpath("//button[@onclick='alertbox()']"));
        click.click();

        driver.switchTo().alert();
      String uyarıKutusu=driver.switchTo().alert().getText();
        System.out.println("Alert Text : "+uyarıKutusu);
        driver.switchTo().alert().accept();

        //     "Tamam ve İptal ile Uyarı" nı tıklayın ve 'Bir onay kutusunu görüntülemek için' düğmesini tıklayın 'tıklayın.
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[1]/ul/li[2]/a")).click();
        driver.findElement(By.xpath("(//button[@class='btn btn-primary'])")).click();
        //     "Tamam ve İptal ile Uyarı" nı tıklayın ve 'Bir onay kutusunu görüntülemek için' düğmesini tıklayın 'tıklayın.
        //     Uyarıyı iptal et (bir düğmeye basın!)
        driver.switchTo().alert().dismiss();
        ///     "TextBox ile Uyarı" ı tıklayın ve 'İstemi kutusunu göstermek için' düğmesini tıklayın 'tıklayın.
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[1]/ul/li[3]/a")).click();

        driver.findElement(By.xpath("(//button[@class='btn btn-info'])")).click();

        //     ve sonra 'TechProeducation' SendKeys 'TechProeducation' (Lütfen adınızı girin)
        //     Sonunda konsol üzerine yazdır Bu mesaaje "Merhaba TechProeducation Bugün nasılsınız?"
        //Kazanmak
        driver.switchTo().alert().sendKeys("TechProeducation Mehmet");
Thread.sleep(3000);
         driver.switchTo().alert().accept();
        String alertMesaj=driver.findElement(By.id("demo1")).getText();
        Assert.assertTrue(alertMesaj.equals("Hello TechProeducation Mehmet How are you today"),"alert mesal Hello TechProeducation Mehmet How are you today içermiyor");


    }
    @AfterClass
    public void tearDown() {

        driver.quit();
    }
}
