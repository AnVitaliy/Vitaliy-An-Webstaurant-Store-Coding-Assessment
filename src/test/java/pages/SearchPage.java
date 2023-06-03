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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SearchPage {
    public SearchPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//span[@data-testid='itemDescription']" )
    List<WebElement> listOfProducts;
    
    @FindBy(xpath = "//li[@class='inline-block leading-4 align-top rounded-r-md']")
    WebElement nextButton;

    @FindBy(xpath = "//span//span[3]")
    List<WebElement> numberOfProduct;

    @FindBy(xpath = "//input[@class='btn btn-cart btn-small']")
    List <WebElement> addToCartButtons;

    @FindBy(xpath = "//a[.='View Cart']")
    WebElement viewCartButton;
//    List<String> itemsWithNoTableWord = new ArrayList<>();
    List<String> itemsWithTableWord = new ArrayList<>();
    List<Integer> addToCart = new ArrayList<>();

    HashMap<String,String> mapWithoutTable = new HashMap<>();

    public void validateEachProductName(WebDriver driver, String tableWord) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        for (int k = 0; k<9;k++) {
            for (int i = 0; i < listOfProducts.size(); i++) {
                wait.until(ExpectedConditions.visibilityOf(listOfProducts.get(i)));
                BrowserUtils.scrollWithJS(driver, listOfProducts.get(i));
                if(BrowserUtils.getText(listOfProducts.get(i)).contains(tableWord)){
                    itemsWithTableWord.add(BrowserUtils.getText(listOfProducts.get(i)));
                    addToCart.add(addToCartButtons.indexOf(i));

                } else {
//                    itemsWithNoTableWord.add(BrowserUtils.getText(listOfProducts.get(i)));
                    mapWithoutTable.put(BrowserUtils.getText(listOfProducts.get(i)),BrowserUtils.getText(numberOfProduct.get(i)));
                }
            }
            nextButton.click();
        }

        for (int i = 0; i < itemsWithTableWord.size(); i++) {
            Assert.assertTrue(itemsWithTableWord.get(i).contains(tableWord));
        }
    }
    public void printOutListOfProductsWithNoTable(){
        System.out.println(mapWithoutTable);
        System.out.println(mapWithoutTable.size());
    }
    public void addLastItemToCart() throws InterruptedException {
        String lastItemTitle = itemsWithTableWord.get(itemsWithTableWord.size()-1);
        for (int i = 0; i < listOfProducts.size(); i++) {
            WebElement product = listOfProducts.get(i);
            String productTitle = BrowserUtils.getText(product);
        if (productTitle.contains(lastItemTitle)) {
        product.click();
            break;
            }
        }
    }
    

}
