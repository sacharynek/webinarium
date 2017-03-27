package page.objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import setup.Driver;

import static org.junit.Assert.assertTrue;

public class FinalOrderPage extends Page {

    @FindBy(css = "ul[class='messages'] li")
    private WebElement thankYouForOrderMessage;

    public FinalOrderPage() {
        waitForPageToLoad();
        PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getInstance(), TIME_OUT), this);
        waitForElementsToLoad(thankYouForOrderMessage);
    }

    public void assertThatThankYouOrderMessageWasDisplayed() {
        assertTrue("Thank you for order label was not displayed", thankYouForOrderMessage.isDisplayed());
        System.out.println("Thank you for order label was displayed!");
    }

}
