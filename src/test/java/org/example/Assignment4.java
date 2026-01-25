package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment4 {
    public static void main(String[] args) {
        WebDriver driver=new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/nested_frames");
        WebElement frametop=driver.findElement(By.name("frame-top"));
        driver.switchTo().frame(frametop);
        WebElement framemiddle=driver.findElement(By.name("frame-middle"));
        driver.switchTo().frame(framemiddle);
        System.out.println(driver.findElement(By.id("content")).getText());
    }
}
