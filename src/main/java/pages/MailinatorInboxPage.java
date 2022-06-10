package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MailinatorInboxPage extends BasePage {

    private By lastLetter = By.xpath("//td[contains(text(), 'qwerty')]");
    private By inboxField = By.id("inbox_field");
    private By goButton = By.className("primary-btn");

    public MailinatorInboxPage(WebDriver driver) {
        super(driver);
        pageUrl = "https://www.mailinator.com/v4/public/inboxes.jsp";
    }

    public void clickLastLetter() {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(lastLetter));
        driver.findElement(lastLetter).click();
    }

    public void goToInbox(String inbox) {
        driver.findElement(inboxField).sendKeys(inbox);
        driver.findElement(goButton).click();
    }

    public void waitUntilLettersIsDisplayed() {
        for (int i = 0; i < 8; i++) {
            System.out.println(i);
            try {
                if (driver.findElement(lastLetter).isDisplayed()) {
                    return;
                }
            } catch (NoSuchElementException e) {
                System.out.println(e.getMessage());
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        }
        throw new TimeoutException();
    }
}