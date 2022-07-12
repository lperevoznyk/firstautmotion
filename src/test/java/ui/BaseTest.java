package ui;

import configreader.FrameworkProperties;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest {

    protected WebDriver driver;
    private FrameworkProperties frameworkProperties =
            ConfigFactory.create(FrameworkProperties.class);

    @BeforeMethod
    public void parentSetUp() {
        System.setProperty("selenium.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofMillis(frameworkProperties.getPageTimeout()));
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(frameworkProperties.getImplicitlyTimeout()));
        System.out.println("Base test before");
    }

    @AfterMethod
    public void parentTearDown() {
        driver.close();
        System.out.println("Base test after");
    }

}
