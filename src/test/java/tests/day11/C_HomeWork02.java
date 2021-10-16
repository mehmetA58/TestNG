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
driver.findElement(By.xpath("(//button[@onclick='alertbox()'])")).click();
System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();

        //     "Tamam ve İptal ile Uyarı" nı tıklayın ve 'Bir onay kutusunu görüntülemek için' düğmesini tıklayın 'tıklayın.
driver.findElement(By.xpath("//*[text()='Alert with OK & Cancel ']")).click();

        //     "Tamam ve İptal ile Uyarı" nı tıklayın ve 'Bir onay kutusunu görüntülemek için' düğmesini tıklayın 'tıklayın.
        //     Uyarıyı iptal et (bir düğmeye basın!)
    driver.findElement(By.xpath("(//button[@onclick='confirmbox()'])")).click();
        driver.switchTo().alert().dismiss();
        ///     "TextBox ile Uyarı" ı tıklayın ve 'İstemi kutusunu göstermek için' düğmesini tıklayın 'tıklayın.
driver.findElement(By.xpath("(//*[text()='Alert with Textbox '])")).click();
driver.findElement(By.xpath("(//button[@onclick='promptbox()'])")).click();

        //     ve sonra 'TechProeducation' SendKeys 'TechProeducation' (Lütfen adınızı girin)
        //     Sonunda konsol üzerine yazdır Bu mesaaje "Merhaba TechProeducation Bugün nasılsınız?"
        //Kazanmak
driver.switchTo().alert().sendKeys("TechProeducation QA Team-3");
driver.switchTo().alert().accept();

String actualText=driver.findElement(By.id("demo1")).getText();
String expectedText="Hello TechProeducation QA Team-3 How are you today";
Assert.assertEquals(actualText,expectedText,"text aynı değil");
    }

    @AfterClass
    public void tearDown() {

        driver.quit();
    }
}