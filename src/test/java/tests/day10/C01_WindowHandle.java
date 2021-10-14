package tests.day10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBase;

import java.util.Set;

// 1' den fazla window acilan durumlarda, ilk sayfadan baslayarak adim adim her sayfanin handle
// degerini alip kaydetmemiz gerekir
// 1. adim ===> Sadece 1 sayfa var iken o sayfanin windowHandle degerini alip String bir
// degiskene kaydediyoruz
// 2. adim ===> Yeni sayfa acildiktan sonra acik olan tum sayfalarin windowHandle degerlerini
// alip bir Set' e atama yapiyoruz
// 3. adim ===> Set' deki elemanlardan 1. sayfa handle' ina esit olmayani 2. sayfanin
// windowHandle degeri olarak bir String' e atama yapiyoruz
// 4. adim ===> Hem 1. sayfanin hem de 2. sayfanin windowHandle degerleri elimizde oldugu icin
// istedigimiz sayfaya gecis yapabiliriz
// driver.switchTo().window("gecmek istedigimiz sayfanin handle degeri")

public class C01_WindowHandle extends TestBase {
    @Test
    public void test(){
        // ● Tests package’inda yeni bir class olusturun: C04_WindowHandle
        //● https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");
        //● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        String actualYazi=driver.findElement(By.tagName("h3")).getText();
        String expectedYazi="Opening a new window";
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(actualYazi,expectedYazi,"yazi istendigi gibi degil");
        //● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String actualTitle=driver.getTitle();
        String expectedTitle="The Internet";
        softAssert.assertEquals(actualTitle,expectedTitle,"title istenen degerden farkli");

        System.out.println("ilk sayfanin Handle değeri : "+driver.getWindowHandle());
        //1-birinci adim window handle ederken ilk adim 1 sayfa acik iken o sayfanin handle degerini string'e atamak

        String ilkSayfaHandle=driver.getWindowHandle();
        //● Click Here butonuna basın.
        //bu satırda 2.window açıldı
        driver.findElement(By.linkText("Click Here")).click();
        //2-ikinci adim iki sayfa acildiginda her iki sayfanin handle degerleri ni koymak icin
        //bir ser olusturup,getWindowHandles methodu ile bu degerkleri elde etmek

        Set<String>tumWindowHandlelari=driver.getWindowHandles();
        System.out.println(tumWindowHandlelari);

        //3.adim-ucuncu adim set icerisinde birinci sayfanin handle degerine esit olmayan handle degerini bulup bir string degiskene atamak

        String ikinciWindowhandle="";
        for (String each:tumWindowHandlelari) {
            if (!each.equals(ilkSayfaHandle)){
                ikinciWindowhandle=each;
            }
        }
        //bu satıra geldigimizde ikinci sayfanin handle degeri olmuş olacak.
        System.out.println("ikinci sayfa handle degeri : "+ikinciWindowhandle);

        //● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        driver.switchTo().window(ikinciWindowhandle);
        //swicthTo ile window degistirilecekse gidecegimiz window'un windowHandle degerine ihtiyacımız var...

        String actualYeniTitle= driver.getTitle();
        String expectedYeniTitle="New Window";
        softAssert.assertEquals(actualYeniTitle,expectedYeniTitle,"yeni sayfanin title'i yanlis");
        //● Sayfadaki textin “New Window” olduğunu doğrulayın.

        WebElement yeniSayfaYaziElementi=driver.findElement(By.tagName("h3"));
        String expectedYaziYeniSayfa="New Window";
        String actualYaziYeniSayfa=yeniSayfaYaziElementi.getText();

        softAssert.assertEquals(actualYaziYeniSayfa,expectedYaziYeniSayfa,"yeni sayfa yazısı ayni degil");

        //● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.
        driver.switchTo().window(ilkSayfaHandle);

         actualTitle=driver.getTitle();
         softAssert.assertEquals(actualTitle,expectedTitle,"title istenen degerden farkli");


        softAssert.assertAll();
    }
}

