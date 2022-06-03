import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.*;

public class TestNGDemo {

    private String baseUrl = "http://www.leafground.com/pages/Edit.html";

    private By emailInputsLocator = By.xpath("//input[@id='email']");
    private By appendInputLocator = By.xpath("//label[text()='Append a text and press " +
            "keyboard tab']/following-sibling::input");
    private By getTextInputLocator = By.xpath("//label[text()='Get default text entered']/following-sibling::input");
    private By clearTextLocator = By.xpath("//label[text()='Clear the text']/following-sibling::input");
    private By disabledInputLocator = By.xpath("//label[text()='Confirm that edit field is disabled']" +
            "/following-sibling::input");
    private WebDriver driver;
    private WebElement emailInput;
    private WebElement appendInput;
    private WebElement getTextInput;
    private WebElement clearTextInput;
    private WebElement disabledInput;

    @BeforeClass
    public void setUp() {
        System.setProperty("selenium.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(baseUrl);
        emailInput = driver.findElement(emailInputsLocator);
        appendInput = driver.findElement(appendInputLocator);
        getTextInput = driver.findElement(getTextInputLocator);
        clearTextInput = driver.findElement(clearTextLocator);
        disabledInput = driver.findElement(disabledInputLocator);
    }

    @Test
    public void emailInputTests() {
        String email = "email.example@domen.com";
        emailInput.sendKeys(email);
        Assert.assertEquals(emailInput.getAttribute("value"), email, "Text is not equal");
    }

    @Test
    public void clearInputTest() {
        clearTextInput.clear();
        Assert.assertTrue(ExpectedConditions.attributeToBe(clearTextInput, "value", "")
                .apply(driver));
    }

    @Test
    public void disabledTest() {
        Assert.assertFalse(disabledInput.isEnabled());
    }

    @AfterClass
    public void tearDown() {
        driver.close();
    }

}