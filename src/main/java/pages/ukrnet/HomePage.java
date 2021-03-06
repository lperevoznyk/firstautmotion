package pages.ukrnet;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;

import java.time.Duration;
import java.util.Date;
import java.util.regex.Pattern;

public class HomePage extends BasePage {

    private By writeLetterButton = By.cssSelector(".primary.compose");

    @FindBy(css = ".primary.compose")
    private WebElement writeLetterButtonElement;

    private By toInput = By.name("toFieldInput");
    private By subjectInput = By.name("subject");
    private By letterBody = By.id("tinymce");
    private By sendButton = By.cssSelector(".screen__head .send.button");
    private By bodyIFrame = By.cssSelector("#mce_0_ifr");
    private By letterIsSend = By.cssSelector(".sendmsg__ads-ready");

    public HomePage(WebDriver driver) {
        super(driver);
        pageUrl = "https://mail.ukr.net/desktop";
    }

    public void clickWriteLetter() {
        webDriverWait
                .until(ExpectedConditions.elementToBeClickable(writeLetterButtonElement))
                .click();
    }

    public void writeLetter(String to, String subject, String body) {
        driver.findElement(toInput).sendKeys(to);
        driver.findElement(subjectInput).sendKeys(subject);
        try {
            driver.switchTo().frame(driver.findElement(bodyIFrame));
            driver.findElement(letterBody).sendKeys(body);
        } finally {
            driver.switchTo().parentFrame();
        }
    }

    public void sendLetter() {
        driver.findElement(sendButton).click();
    }

    public boolean getTextLetterIsSend(String expectedText) {
        return webDriverWait.until(ExpectedConditions.textMatches(letterIsSend,
                Pattern.compile("^" + expectedText + "\n.*")));
    }

    @Override
    public String getPageUrl() {
        return "qwe";
    }

}