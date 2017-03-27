package page.objects;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import setup.Driver;

import static java.lang.System.out;

public class FishPage extends Page {

    @FindBy(css = "a[href*='FI-SW-01']")
    private WebElement angelfishLink;

    public FishPage() {
        waitForPageToLoad();
        PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getInstance(), TIME_OUT), this);
        waitForElementsToLoad(angelfishLink);
    }

    public AngelFishPage clickOnAngelFish() {
        angelfishLink.click();
        out.println("Clicked on Angel Fish link");
        return new AngelFishPage();
    }
}
