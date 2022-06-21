import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class TestNGDemo {

    String baseUr1 = "http://www.leafground.com/pages/checkbox.html";
    private By selectLanguageLocator = By.xpath("//label[text()='Select the languages that you know?']" +
            "/following-sibling::input");
    private By seleniumLocator = By.xpath("//label[text()='Confirm Selenium is checked']/following-sibling::" +
            "input[@type='checkbox']");
    private By deSelectLocator = By.xpath("//*[@id=\"contentblock\"]/section/div[3]/input[2]");
    private By selectAllCheckboxesLocator = By.xpath("//label[text()='Select all below checkboxes ']/" +
            "following-sibling::input");
    private By titlesLocator = By.cssSelector(".wp-categories-title");

    private WebDriver driver;
    private WebElement selectLanguage;
    private WebElement selenium;
    private WebElement deSelect;
    private WebElement selectAllCheckboxes;
    private WebElement titles;


    @BeforeClass
    public void setUp() {
        System.setProperty("selenium.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(baseUr1);

        selectLanguage = driver.findElement(selectLanguageLocator);
        selenium = driver.findElement(seleniumLocator);
        deSelect = driver.findElement(deSelectLocator);
        selectAllCheckboxes = driver.findElement(selectAllCheckboxesLocator);
    }

    @Test
    public void selectLanguageTests() {
        selectLanguage.click();
        Assert.assertTrue(selectLanguage.isSelected());
    }

    @Test
    public void seleniumTests() {
        Assert.assertTrue(selenium.isSelected());
    }

    @Test
    public void deSelectTests() {
        deSelect.click();
        Assert.assertFalse(deSelect.isSelected());
    }

    @Test
    public void selectAllCheckboxesTests() {
        List<WebElement> allchecks = driver.findElements(selectAllCheckboxesLocator);

        allchecks.forEach(WebElement::click);

//        for (WebElement check : allchecks) {
//            check.click();
//        }

//        Assert.assertTrue(allchecks.stream().allMatch(element -> element.isSelected()));
        Assert.assertTrue(allchecks.stream().allMatch(WebElement::isSelected));

//        for (WebElement check : allchecks) {
//            Assert.assertTrue(check.isSelected());
//        }
    }

    @Test
    public void titlesTest() {
        driver.get("http://www.leafground.com/home.html");

        List<WebElement> titles = driver.findElements(titlesLocator);
        List<String> titlesText;

//        titlesText = titles.stream().map(element -> element.getText()).collect(Collectors.toList());
        titlesText = titles.stream()
                .filter(element -> element.getText().toCharArray()[0] == 'A')
                .map(WebElement::getText)
                .collect(Collectors.toList());

//        for (WebElement element : titles) {
//            titlesText.add(element.getText());
//        }

        System.out.println(titlesText);
    }

    @AfterClass
    public void tearDown() {
        driver.close();
    }

}