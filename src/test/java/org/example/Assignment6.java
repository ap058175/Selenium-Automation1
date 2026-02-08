package org.example;

import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;

import java.time.Duration;
import java.util.List;

public class Assignment6 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("window.scroll(0,650)");
        Thread.sleep(5000);
        List<WebElement> column=driver.findElements(By.cssSelector(".table-display th"));
        int columnCount=column.size();
        System.out.println("Number of columns: "+columnCount);
        List<WebElement> row=driver.findElements(By.cssSelector(".table-display tr"));
        int rowCount=row.size();
        System.out.println("Number of rows: "+rowCount);
        Thread.sleep(5000);
         List<WebElement> secondColValues=driver.findElements(By.cssSelector(".table-display tr:nth-child(3) td"));

        for(int i=0;i<secondColValues.size();i++){
            System.out.println(secondColValues.get(i).getText());
        }
    }
}
