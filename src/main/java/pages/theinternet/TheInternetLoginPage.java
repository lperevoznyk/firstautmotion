package pages.theinternet;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;
import testdata.User;

import java.time.Duration;

public class TheInternetLoginPage extends BasePage {

    @FindBy(how = How.ID, using = "username")
    private SelenideElement loginField;

    @FindBy(how = How.ID, using = "password")
    private SelenideElement passwordField;

    @FindBy(how = How.CSS, using = "[type='submit']")
    private SelenideElement loginButton;

    @FindBy(how = How.CSS, using = "#flash")
    private SelenideElement errorMessage;

    public TheInternetLoginPage(WebDriver driver) {
        super(driver);
        pageUrl = "http://the-internet.herokuapp.com/login";
    }

    public void login(User user) {
        loginField.sendKeys(user.getLogin());
        passwordField.sendKeys(user.getPassword());
        loginButton.click();
    }

    public String getErrorMessage() {
        return waitAndGetText(errorMessage);
    }

}