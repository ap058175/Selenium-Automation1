package org.example;

import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

public class urlCheckFooter {
    public static void main(String[] args) throws URISyntaxException, IOException {
        WebDriver driver=new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

          List<WebElement> links=driver.findElements(By.cssSelector(".gf-li a"));
        SoftAssert soft=new SoftAssert();

          for (WebElement link:links){
              String url=link.getAttribute("href");
              HttpURLConnection con= (HttpURLConnection) new URI(url).toURL().openConnection();
              con.setRequestMethod("HEAD");
              con.connect();
              int responsecode=con.getResponseCode();
              System.out.println(responsecode);
              soft.assertTrue(responsecode<400,"The link with text "+link.getText()+" is broken with code "+responsecode);
          }
            soft.assertAll();




    }
}
