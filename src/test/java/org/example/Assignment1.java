package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class Assignment1 {
    public static void main(String[] args) {
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://rahulshettyacademy.com/angularpractice/");

        driver.findElement(By.xpath("//div[@class='form-group']//input[@name='name']")).sendKeys("Amit");
        driver.findElement(By.xpath("//input[@class='form-control ng-untouched ng-pristine ng-invalid']")).sendKeys("amit@1234");
        driver.findElement(By.xpath("//input[@id='exampleInputPassword1']")).sendKeys("Test@123");
        driver.findElement(By.cssSelector("input[id='exampleCheck1']")).click();
        WebElement staticDropdown=driver.findElement(By.id("exampleFormControlSelect1"));
        Select dropdown=new Select(staticDropdown);
        dropdown.selectByIndex(0);
        driver.findElement(By.cssSelector("input[value='option2']")).click();
        System.out.print(driver.findElement(By.cssSelector("label[for='inlineRadio3']")).isEnabled());
        driver.findElement(By.xpath("//input[@name='bday']")).sendKeys("10-10-2001");
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        System.out.println(driver.findElement(By.cssSelector(".alert.alert-success.alert-dismissible")).getText());

    }
}
