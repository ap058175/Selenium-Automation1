package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Assignment5 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        WebElement label=driver.findElement(By.cssSelector("div[id='checkbox-example'] fieldset label:nth-of-type(1)"));
        WebElement checkbox=label.findElement(By.tagName("input"));
        checkbox.click();
        String labelText=label.getText();
        if(checkbox.isSelected()){
            System.out.println("Checkbox is selected");
        }else {
            System.out.println("Checkbox is not selected");
        }
        System.out.println(labelText);
        WebElement dropdown=driver.findElement(By.id("dropdown-class-example"));
        Select selectdropdown=new Select(dropdown);
        selectdropdown.selectByVisibleText(labelText);
        driver.findElement(By.cssSelector("input[id='name']")).sendKeys(labelText);
        driver.findElement(By.cssSelector("input[id='alertbtn']")).click();
        String alertText=driver.switchTo().alert().getText();
        String expectedText=alertText.split(",")[0].split(" ")[1];
        System.out.println(expectedText);
        Thread.sleep(5000);
        driver.switchTo().alert().accept();

    }
}


