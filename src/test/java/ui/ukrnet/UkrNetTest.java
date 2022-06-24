package ui.ukrnet;

import exceptions.MyCheckedException;
import exceptions.MyUncheckedException;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.mailinator.MailinatorInboxPage;
import pages.ukrnet.HomePage;
import pages.ukrnet.LoginPage;
import org.testng.annotations.TestInstance;
import pages.*;
import testdata.User;
import ui.BaseTest;

import javax.annotation.Nonnull;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.time.Duration;
import java.util.List;
import java.util.MissingFormatArgumentException;

public class UkrNetTest extends BaseTest {

    @Test(description = "Mailinator test")
    public void sendEmailToMailinatorTest() {
        User user = new User("lperevoznyk@ukr.net", "Qwerty!2345");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.navigate();
        loginPage.login(user);
        HomePage homePage = new HomePage(driver);
        homePage.waitUntilLoaded();

        homePage.clickWriteLetter();
        homePage.writeLetter("lperevonyktest@mailinator.com", "qwerty", "test body ");
        homePage.sendLetter();
        Assert.assertTrue(homePage.getTextLetterIsSend("Ваш лист надіслано"));
        MailinatorInboxPage mailinatorInboxPage = new MailinatorInboxPage(driver);
        mailinatorInboxPage.navigate();
        mailinatorInboxPage.goToInbox("lperevonyktest");
        mailinatorInboxPage.waitUntilJsIsReady();
        mailinatorInboxPage.clickLastLetter();
    }

    @Test(groups = "exclude-me")
    public void stringFormat() {
        String text = "My name is: %s, and my age is: %s";
        String newText = String.format(text, "Leo", 24);
        System.out.println(newText);
    }

}