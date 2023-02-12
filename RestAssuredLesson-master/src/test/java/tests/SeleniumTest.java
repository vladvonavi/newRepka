package tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {

    @Test
    void seleniumTest(){
        System.setProperty("webdriver.chrome.driver", "/usr/bin/chromeriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://ya.ru/");
    }
}
