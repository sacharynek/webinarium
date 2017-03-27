package page.objects;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import setup.Driver;

import static java.lang.System.out;


public class LandingPage extends Page {

    @FindBy(css = "a[href]")
    private WebElement enterStoreLink;

    public LandingPage() {
        waitForPageToLoad();
        PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getInstance(), TIME_OUT), this);
        waitForElementsToLoad(enterStoreLink);
    }

    public HomePage clickOnEnterStoreLink() {
        enterStoreLink.click();
        out.println("Clicked on Enter Store Link");
        return new HomePage();
    }
}
