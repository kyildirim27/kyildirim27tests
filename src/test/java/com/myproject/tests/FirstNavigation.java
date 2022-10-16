package com.myproject.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstNavigation {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","./drivers/chromedriver");

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://www.google.com/");

        driver.navigate().to("https://www.ebay.com/");

        driver.quit();

    }
}
