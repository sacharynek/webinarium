package page.objects;


import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import setup.Driver;

import static java.lang.System.out;

@Slf4j
public class ConfirmOrderPage extends Page {

    @FindBy(css = "a[href*='confirmed']")
    private WebElement confirmOrderButton;

    public ConfirmOrderPage() {
        waitForPageToLoad();
        PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getInstance(), TIME_OUT), this);
        waitForElementsToLoad(confirmOrderButton);
    }

    public FinalOrderPage clickOnOrder() {
        confirmOrderButton.click();
        out.println("Clicked on Order Button");
        return new FinalOrderPage();
    }
}
