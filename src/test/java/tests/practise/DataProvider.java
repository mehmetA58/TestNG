package tests.practise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.security.Key;
import java.sql.Driver;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class DataProvider extends TestBase {


    @Test (dataProvider =  "getData")
    void UserNameTest (String username, String password ) {
        System.out.println("username : " + username + " "  + "password :" + password);
    }
    @org.testng.annotations.DataProvider
    public Object [][] getData(){
        Object [][] data = {
                {"Muhammet", "123"},
                {"Murat", "asd"},
                {"Kubilay", "1q2w"}
        };
        return data;
    }
    @Test (dataProvider =  "getData2")
    void usernameTest (String username) {
        System.out.println("username = " + username);
    }
    @org.testng.annotations.DataProvider
    public Iterator<Object> getData2 (){
        List<Object> data = new ArrayList<>();
        data.add("Merve");
        data.add("Esra");
        data.add("Hakan");
        return data.iterator();
    }
}