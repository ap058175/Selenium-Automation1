package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class RelativeXpath {
    public static void main(String[] args){
        WebDriver driver=new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/angularpractice/");
        WebElement editbox=driver.findElement(By.cssSelector("[name='name']"));
        System.out.println(driver.findElement(with(By.tagName("label")).above(editbox)).getText());
        WebElement dob=driver.findElement(By.xpath("//label[text()='Date of Birth']"));
        driver.findElement(with(By.tagName("input")).below(dob)).click();
        WebElement checkBox=driver.findElement(By.xpath("//label[text()='Check me out if you Love IceCreams!']"));
        driver.findElement(with(By.tagName("input")).toLeftOf(checkBox)).click();
        WebElement radio1=driver.findElement(By.cssSelector("input[id='inlineRadio1']"));
        System.out.println(driver.findElement(with(By.tagName("label")).toRightOf(radio1)).getText());
    }
}
