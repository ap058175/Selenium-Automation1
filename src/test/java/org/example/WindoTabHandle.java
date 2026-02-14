package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.util.Iterator;
import java.util.Set;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;



public class WindoTabHandle {
    public static void main(String[] args) throws Exception{
        WebDriver driver=new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/angularpractice/");
        driver.switchTo().newWindow(WindowType.TAB);
        Set<String> handles=driver.getWindowHandles();
        Iterator<String> it=handles.iterator();
        String parentId=it.next();
        String childId=it.next();
        driver.switchTo().window(childId);
        driver.get("https://rahulshettyacademy.com/");
        String coursename=driver.findElements(By.cssSelector("h3[class*='font-bold']")).get(1).getText();
        driver.switchTo().window(parentId);
        WebElement names=driver.findElement(By.cssSelector("[name='name']"));
        names.sendKeys(coursename);
        File file=names.getScreenshotAs(OutputType.FILE);
        Files.copy(file.toPath(), Paths.get("logo.png"), StandardCopyOption.REPLACE_EXISTING);
        System.out.println(names.getRect().getDimension().getHeight());
        System.out.println(names.getRect().getDimension().getWidth());


    }
}
