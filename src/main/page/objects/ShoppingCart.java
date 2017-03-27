package page.objects;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import setup.Driver;

import static java.lang.System.out;

public class ShoppingCart extends Page {

    @FindBy(css = "a[href*='newOrderForm']")
    private WebElement proceedToCheckoutButton;

    public ShoppingCart() {
        waitForPageToLoad();
        PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getInstance(), TIME_OUT), this);
        waitForElementsToLoad(proceedToCheckoutButton);
    }

    public SummaryPage clickOnProceedToCheckOut(){
        proceedToCheckoutButton.click();
        out.println("Clicked on proceed to checkout button");
        return new SummaryPage();
    }
}
