package org.example;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

public class SSLCheck {
    public static void main(String[] args){
        ChromeOptions options=new ChromeOptions();
        Proxy proxy=new Proxy();
        proxy.setHttpProxy("ipaddress:4444");
        options.setCapability("proxy",proxy);
        Map<String,Object> prefs=new HashMap<String,Object>();
        prefs.put("dodwnload.default_directory",System.getProperty("user.dir")+"\\downloads");
        options.setExperimentalOption("prefs",prefs);
        options.setAcceptInsecureCerts(true);

        WebDriver driver=new ChromeDriver(options);
        driver.get("https://expired.badssl.com/");
    }
}
