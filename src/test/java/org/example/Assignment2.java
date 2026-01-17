package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Assignment2 {

    public static void main(String[] args) {
        // Your code here

        WebDriver driver = new ChromeDriver();;
        driver.get("https://rahulshettyacademy.com/loginpagePractise/");
        WebDriverWait w=new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.cssSelector("input[name='username']")).sendKeys("rahulshettyacademy");
        driver.findElement(By.cssSelector("input[name='password']")).sendKeys("learning");
        driver.findElement(By.xpath("(//span[@class='checkmark'])[2]")).click();
        w.until(ExpectedConditions.visibilityOfElementLocated(By.id("okayBtn")));
        w.until(ExpectedConditions.elementToBeClickable(By.id("okayBtn"))).click();

        WebElement info=driver.findElement(By.cssSelector("Select[class='form-control']"));
        Select dropdown=new Select(info);
        dropdown.selectByVisibleText("Student");
        driver.findElement(By.cssSelector("input#terms")).click();
        driver.findElement(By.cssSelector("input#signInBtn")).click();

        List<WebElement> products=driver.findElements(By.xpath("//button[@class='btn btn-info']"));

        for(int i=0;i<products.size();i++)
        {
            products.get(i).click();
        }

        driver.findElement(By.xpath("//a[@class='nav-link btn btn-primary']")).click();
        driver.findElement(By.xpath("//button[@class='btn btn-success']")).click();
        driver.findElement(By.cssSelector("input#country")).sendKeys("China");
        List<WebElement> country=driver.findElements(By.xpath("//div[@class='suggestions']/ul/li/a"));
        for (int i=0;i<country.size();i++)
        {
            if(country.get(i).getText().equalsIgnoreCase("China"))
            {
                country.get(i).click();
                break;
            }
        }

        driver.findElement(By.xpath("//input[@id='checkbox2']")).click();
        driver.findElement(By.xpath("//input[@value='Purchase']")).click();
        System.out.println(driver.findElement(By.cssSelector("div[class='alert alert-success alert-dismissible']")).getText());


    }

}
