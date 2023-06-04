package pages;

import net.bytebuddy.asm.Advice;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    public MainPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//input[@aria-owns='awesomplete_list_1']")
    WebElement searchBar;
    public void searchForProduct(String productName){
       searchBar.clear();
       searchBar.sendKeys(productName, Keys.ENTER);
    }
}
