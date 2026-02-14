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
       //scan the name column with gettext and if it contains beans then print the price of beans
        List<String> price;
        do {
            List<WebElement> orginalList1=driver.findElements(By.cssSelector("tr td:nth-child(1)"));
            price = orginalList1.stream().filter(s -> s.getText().contains("Rice")).map(s -> getPrice(s)).collect(Collectors.toList());
            if(price.size()<1)
            {
                driver.findElement(By.cssSelector("[aria-label='Next']")).click();
            }
            price.forEach(s -> System.out.println(s));
        }while (price.size()<1);


    }

    public static String getPrice(WebElement s){
        String price=s.findElement(By.xpath("following-sibling::td[1]")).getText();
        return price;
    }
}
