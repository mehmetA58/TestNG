package tests.practise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.util.List;

public class DaraProvider02 extends TestBase {
    // http://the-internet.herokuapp.com/add_remove_elements/
    // click on the "Add Element" button 100 times
    // write a function that takes a number, and clicks the "Delete" button
    // given number of times, and then validates that given number of
    // buttons was deleted
//static WebDriver driver;
    @Test
    public void test(){
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");
        createButtons(100);
        deleteButtonandValidate(90);
    }
    private void createButtons ( int numberofButtonToAdd) {
        WebElement button = driver.findElement(By.xpath("//button[@onclick='addElement()']"));
        for (int i = 0; i < numberofButtonToAdd; i++) {
            button.click();
        }
    }
    private  void deleteButtonandValidate (int number) {
        List<WebElement> deleteElements = driver.findElements(By.xpath("//button[@onclick='deleteElement()']"));
        int size = deleteElements.size();
        List<WebElement> removeDeleteButtons = driver.findElements(By.xpath("//button[@onclick='deleteElement()']"));
        int count = 0;
        for (WebElement each:removeDeleteButtons) {
            count++;
            if(count>number) {
                break;
            }
            each.click();
        }
        List<WebElement> elementAfter = driver.findElements(By.xpath("//button[@onclick='deleteElement()']"));
        int sizeAfterDeleting = elementAfter.size();
        if ((size- number) == sizeAfterDeleting ) {
            System.out.println("PASS");
        }else
            System.out.println("FAIL");
    }
}