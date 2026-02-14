package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;
import java.util.stream.Collectors;

public class PaginationSearchValidation {
    public static void main(String[] args){
        WebDriver driver=new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        driver.findElement(By.cssSelector("[type='search']")).sendKeys("Rice");
        List<WebElement> veggies=driver.findElements(By.cssSelector("tr td:nth-child(1)"));
        List<WebElement> veggie=veggies.stream().filter(s->s.getText().contains("Rice")).collect(Collectors.toList());
        Assert.assertEquals(veggies.size(),veggie.size());

    }
}
