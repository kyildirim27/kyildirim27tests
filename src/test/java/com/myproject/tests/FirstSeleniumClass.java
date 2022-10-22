package com.myproject;

public class FirstSeleniumClass {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","./drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
    }

    public static class WebDriver {
        public void get(String s) {
        }
    }

    private static class ChromeDriver extends WebDriver {
    }
}
