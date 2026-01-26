package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class scope {
    public static void main(String [] args) throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        //1.Give me the count of links on the page
        System.out.println(driver.findElements(By.tagName("a")).size());
        //Limiting the webdriver scope to footer section
        WebElement footerDriver=driver.findElement(By.id("gf-BIG"));
        //2.Give me the count of links in footer section
        System.out.println(footerDriver.findElements(By.tagName("a")).size());
        //3.Links count in first column of footer
        WebElement footerFirstColumn=footerDriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
        System.out.println(footerFirstColumn.findElements(By.tagName("a")).size());
        //4.Click on each link in the column and check if the pages are opening
      for (int i=1;i<footerFirstColumn.findElements(By.tagName("a")).size();i++) {
          String clickOnLinkTab = Keys.chord(Keys.COMMAND, Keys.ENTER);
          footerFirstColumn.findElements(By.tagName("a")).get(i).sendKeys(clickOnLinkTab);
          Thread.sleep(5000);
      }
        Set<String> openWindows = driver.getWindowHandles();
        Iterator<String> it = openWindows.iterator();

          while(it.hasNext()){
              driver.switchTo().window(it.next());
              System.out.println(driver.getTitle());
          }
      }

}
