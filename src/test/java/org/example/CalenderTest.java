package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;

public class CalenderTest {
    public static void main(String[] args){
        WebDriver driver=new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
         String month="9";
         String year="2029";
         String date="10";
         String[] expectedList={month,date,year};
         driver.findElement(By.cssSelector(".react-date-picker__calendar-button.react-date-picker__button")).click();
         driver.findElement(By.cssSelector(".react-calendar__navigation__label__labelText.react-calendar__navigation__label__labelText--from")).click();
        driver.findElement(By.cssSelector(".react-calendar__navigation__label__labelText.react-calendar__navigation__label__labelText--from")).click();
         driver.findElement(By.xpath("//button[text()='"+year+"']")).click();
         driver.findElements(By.xpath("//button[@class='react-calendar__tile react-calendar__year-view__months__month']")).get(Integer.parseInt(month)-1).click();
        driver.findElement(By.xpath("//abbr[text()='"+date+"']")).click();

        List<WebElement> allDates=driver.findElements(By.cssSelector(".react-date-picker__inputGroup__input"));

        for(int i=0;i<allDates.size();i++){
          System.out.println(allDates.get(i).getAttribute("value"));
            Assert.assertEquals(allDates.get(i).getAttribute("value"),expectedList[i]);

        }
 driver.close();

    }
}
