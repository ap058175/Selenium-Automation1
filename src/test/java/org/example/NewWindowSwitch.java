package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class NewWindowSwitch {
    public static void main(String[] args) {
        WebDriver driver=new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/loginpagePractise/");
        driver.findElement(By.cssSelector(".blinkingText")).click();
        Set<String> windows=driver.getWindowHandles();
        Iterator<String> it=windows.iterator();
        String parentID=it.next();
        String childID=it.next();
        driver.switchTo().window(childID);
        System.out.println(driver.findElement(By.cssSelector(".im-para.red")).getText());
        String emailId=driver.findElement(By.cssSelector(".im-para.red")).getText().split("at")[1].trim().split(" ")[0];
        driver.switchTo().window(parentID);
        driver.findElement(By.id("username")).sendKeys(emailId);
    }
}
