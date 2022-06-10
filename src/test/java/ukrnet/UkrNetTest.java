package ukrnet;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.MailinatorInboxPage;
import pages.MyException;
import testdata.User;

public class UkrNetTest {

    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        System.setProperty("selenium.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void sendEmailToMailinatorTest() {
        User user = new User("lperevoznyk@ukr.net", "Qwerty!2345");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.navigate();
        loginPage.login(user);
        HomePage homePage = new HomePage(driver);
        homePage.waitUntilLoaded();

        homePage.clickWriteLetter();
        homePage.writeLetter("lperevonyktest@mailinator.com", "qwerty", "test body");
        homePage.sendLetter();
        Assert.assertTrue(homePage.getTextLetterIsSend("Ваш лист надіслано"));
        MailinatorInboxPage mailinatorInboxPage = new MailinatorInboxPage(driver);
        mailinatorInboxPage.navigate();
        mailinatorInboxPage.goToInbox("lperevonyktest");
        mailinatorInboxPage.waitUntilJsIsReady();
        mailinatorInboxPage.waitUntilLettersIsDisplayed();
        mailinatorInboxPage.clickLastLetter();
    }

}






















