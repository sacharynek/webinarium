package page.objects;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import setup.Driver;

import static java.lang.System.out;

public class SummaryPage extends Page {

    @FindBy(name = "newOrder")
    private WebElement continueButton;

    public SummaryPage() {
        waitForPageToLoad();
        PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getInstance(), TIME_OUT), this);
        waitForElementsToLoad(continueButton);
    }

    public ConfirmOrderPage clickOnContinueButton() {
        continueButton.click();
        out.println("Clicked on Continue button");
        return new ConfirmOrderPage();
    }

}

