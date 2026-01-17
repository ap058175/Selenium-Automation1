package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class GreenKartPractice {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Thread.sleep(5000);

        String[] itemsNeeded = {"Cucumber", "Brocolli", "Beetroot", "Carrot"};

        addItems(driver,itemsNeeded);

    }

     public static void addItems(WebDriver driver,String [] itemsNeeded)
        {
            List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
            int checked=0;
            List itemsNeededList = Arrays.asList(itemsNeeded);
            for (int i=0;i<=products.size();i++)
            {
                String name=products.get(i).getText().split("-")[0].trim();

                if(itemsNeededList.contains(name)){

                    driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
                    checked++;
                    if(checked==itemsNeeded.length)
                    {
                        break;
                    }

                }
            }
        }
    }


