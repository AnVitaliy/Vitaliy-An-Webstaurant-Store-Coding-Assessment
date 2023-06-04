package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.BrowserUtils;

import java.time.Duration;

public class CartPage {
    public CartPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(css = ".itemDelete__icon")
    WebElement deleteButton;

    @FindBy(xpath = "//p[contains(text(),'Your cart is empty.')]")
    WebElement message;

    public void validateCartIsEmpty(WebDriver driver, String expectedMessage){
        deleteButton.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(message));
        Assert.assertEquals(expectedMessage, BrowserUtils.getText(message));
    }
}
