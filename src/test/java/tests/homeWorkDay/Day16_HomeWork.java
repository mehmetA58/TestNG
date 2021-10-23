package tests.homeWorkDay;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.sql.Driver;
import java.util.concurrent.TimeUnit;
//**
//      * Bölüm 1:
//      * "https://courses.ultimateqa.com/users/sign_up" sayfasını açın
//      * rastgele ve geçerli bir ad, soyad, e-posta ve şifre oluşturun, daha sonra doğrulamak için saklayın
//      * hesap gönderme formunu yukarıdaki verilerle doldurun
//      * Şartlar ve koşulları kabul etmek için id="user[terms]" olan onay kutusunu tıklayın
//      * "Kaydol" düğmesine tıklayın
//      * https://courses.ultimateqa.com/account adresine gidin
//      * daha önce verdiğiniz ad, soyadı ve e-postanın doğru olduğunu doğrulayın
//      *
//      * Bölüm 2 (Opsiyonel)
//      * web sitesinden çıkış yapın
//      * "https://courses.ultimateqa.com/users/sign_in" adresine gidin
//      * kayıtlı e-postanız ve şifrenizle oturum açma formunu doldurun
//      * "Giriş yap" düğmesine tıklayın
//      * "Başarıyla oturum açıldı" mesajını doğrulayın. görüntülenir
//      *
//      * NOT: Bu web sitesinde Captcha kaçınılmazdır,
//      * yani betiğin devam etmesine izin vermek için elle çözmeniz gerekecek
//      **/
public class Day16_HomeWork {
    WebDriver driver;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);


    }

    @Test
    public void test() throws InterruptedException {
        driver.get("https://courses.ultimateqa.com/users/sign_up");
        Faker faker=new Faker();
        String FirstName=faker.name().firstName();
        String LastName=faker.name().lastName();
        String eMail=faker.internet().emailAddress();
        String passWord=faker.internet().password();
        Actions actions=new Actions(driver);

        actions.sendKeys(FirstName)
                .sendKeys(Keys.TAB)
                .sendKeys(LastName)
                .sendKeys(Keys.TAB)
                .sendKeys(eMail)
                .sendKeys(Keys.TAB)
                .sendKeys(passWord)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.SPACE)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)

                .sendKeys(Keys.ENTER)
                .perform();
        Thread.sleep(50000);//---->capta

        driver.navigate().to("https://courses.ultimateqa.com/account");

Thread.sleep(3000);
        Assert.assertTrue(driver.findElement(By.id("user[email]")).getAttribute("value").equals(eMail));
        Assert.assertTrue(driver.findElement(By.id("user[first_name]")).getAttribute("value").equals(FirstName));
        Assert.assertTrue(driver.findElement(By.id("user[last_name]")).getAttribute("value").equals(LastName));

        driver.findElement(By.xpath("//a[@class='dropdown__toggle-button']")).click();
        driver.findElement(By.partialLinkText("Sign Out")).click();

        driver.navigate().to("https://courses.ultimateqa.com/users/sign_in");

        actions.sendKeys(eMail)
                .sendKeys(Keys.TAB)
                .sendKeys(passWord).perform();
        driver.findElement(By.xpath("//input[@value='Sign in']")).click();
        Thread.sleep(10000);
        SoftAssert softAssert=new SoftAssert();
        String expctd="Signed in successfully.";
        WebElement actl=driver.findElement(By.xpath("//*[text()='Signed in successfully.']"));
        Thread.sleep(2000);
        softAssert.assertTrue(actl.equals(expctd),"mesaj beklenen gibi degil");
        softAssert.assertAll();

    }


    @AfterClass
    public void tearDown() {

        //driver.quit();
    }
}