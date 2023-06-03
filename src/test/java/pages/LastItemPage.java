package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LastItemPage {
    public LastItemPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(css = "#buyButton")
    WebElement addToCartButton;
    @FindBy(xpath = "//button[@class='btn btn-primary']")
    WebElement viewCartButton;

    public void addToCartItem(WebDriver driver){
        addToCartButton.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(viewCartButton));
        viewCartButton.click();
    }
}
