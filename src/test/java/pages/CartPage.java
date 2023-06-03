package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

public class CartPage {
    public CartPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(css = ".itemDelete__icon")
    WebElement deleteButton;

    @FindBy(xpath = "//p[contains(text(),'Your cart is empty.')]")
    WebElement message;

    public void validateCartIsEmpty(String expectedMessage){
        deleteButton.click();
        Assert.assertEquals(expectedMessage, BrowserUtils.getText(message));
    }
}
