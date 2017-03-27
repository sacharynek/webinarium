package page.objects;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import setup.Driver;

import static java.lang.System.out;

public class AngelFishPage extends Page {

    @FindBy(css = "a[href*='EST-1'][class='Button']")
    private WebElement largeAngelFishCategoryButton;

    public AngelFishPage() {
        waitForPageToLoad();
        PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getInstance(), TIME_OUT), this);
        waitForElementsToLoad(largeAngelFishCategoryButton);
    }

    public ShoppingCart clickOnAddToCardForLargeAngelFish() {
        largeAngelFishCategoryButton.click();
        out.println("Clicked on add to card for large angel fish");
        return new ShoppingCart();
    }
}
