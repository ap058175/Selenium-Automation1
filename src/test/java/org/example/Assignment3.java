package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class Assignment3 {
    public static void main(String[] args) {
        WebDriver driver=new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/windows");
        driver.findElement(By.xpath("//a[contains(text(),'Click Here')]")).click();
        Set<String> window=driver.getWindowHandles();
        Iterator<String> it=window.iterator();
        String parentID=it.next();
        String childID=it.next();
        driver.switchTo().window(childID);
        System.out.println(driver.findElement(By.xpath("//h3[contains(text(),'New Window')]")).getText());
        driver.switchTo().window(parentID);
        System.out.println(driver.findElement(By.xpath("//h3[contains(text(),'Opening a new window')]")).getText());
    }
}
