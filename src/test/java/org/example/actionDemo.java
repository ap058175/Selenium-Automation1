package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.time.Duration;

public class actionDemo {
    public static void main(String[] args){
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.amazon.in/?&tag=googhydrabk1-21&ref=pd_sl_5szpgfto9i_e&adgrpid=155259813593&hvpone=&hvptwo=&hvadid=793178077606&hvpos=&hvnetw=g&hvrand=10705604344000087370&hvqmt=e&hvdev=c&hvdvcmdl=&hvlocint=&hvlocphy=9061988&hvtargid=kwd-64107830&hydadcr=14452_2438220&gad_source=1");
        driver.manage().window().maximize();;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Actions act=new Actions(driver);
        WebElement move=driver.findElement(By.xpath("//span[normalize-space()='Account & Lists']"));
       WebElement search=driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
       act.moveToElement(search).click().keyDown(Keys.SHIFT).sendKeys("hello").doubleClick().build().perform();
       act.moveToElement(move).contextClick().build().perform();


    }
}
