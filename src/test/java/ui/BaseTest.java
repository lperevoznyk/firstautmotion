package ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void parentSetUp() {
        System.setProperty("selenium.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        System.out.println("Base test before");
    }

    @AfterMethod
    public void parentTearDown() {
        driver.close();
        System.out.println("Base test after");
    }

}
