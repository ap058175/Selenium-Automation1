package org.example;

import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.stream.Collectors;

public class Livedemo {
    public static void main(String args[]){
        WebDriver driver=new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        //click on the column header
         driver.findElement(By.cssSelector("tr th:nth-child(1)")).click();
        //fetch the sorted list ofr webelements
         List<WebElement> orginalList=driver.findElements(By.cssSelector("tr td:nth-child(1)"));
        //sort the list of weblement into new list and sort it
        List<String> newOriginalList=orginalList.stream().map(s->s.getText()).collect(Collectors.toList());
         List<String> newSortedList= newOriginalList.stream().sorted().collect(Collectors.toList());

        //compare both the list
        Assert.assertTrue(newOriginalList.equals(newSortedList));

    }
}
