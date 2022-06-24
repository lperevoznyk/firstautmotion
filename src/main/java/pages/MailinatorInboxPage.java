package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

public class MailinatorInboxPage extends BasePage {

    private By lastLetter = By.xpath("//td[contains(text(), 'qwerty')]");
    private By inboxField = By.id("inbox_field");
    private By goButton = By.className("primary-btn");

    public MailinatorInboxPage(WebDriver driver) {
        super(driver);
        pageUrl = "https://www.mailinator.com/v4/public/inboxes.jsp";
    }

    public void clickLastLetter() {
        new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(5))
                .pollingEvery(Duration.ofMillis(200))
                .ignoring(NoSuchElementException.class)
                .until(ExpectedConditions.elementToBeClickable(lastLetter));

        driver.findElement(lastLetter).click();
    }

    public void goToInbox(String inbox) {
        driver.findElement(inboxField).sendKeys(inbox);
        driver.findElement(goButton).click();
    }
}