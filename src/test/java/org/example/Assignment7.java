package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Assignment7 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.findElement(By.cssSelector("input[placeholder='Type to Select Countries']")).sendKeys("ind");
        Thread.sleep(5000);
        List<WebElement> countryDropdown=driver.findElements(By.cssSelector(".ui-menu.ui-widget.ui-widget-content.ui-autocomplete.ui-front li"));
        for(WebElement option:countryDropdown){
            if(option.getText().equals("India")){
                option.click();
                break;
            }
        }
        Thread.sleep(5000);
        String text=driver.findElement(By.cssSelector("input[placeholder='Type to Select Countries']")).getText();

    }
}
