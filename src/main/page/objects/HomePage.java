package page.objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import setup.Driver;

import static java.lang.System.out;
import static org.junit.Assert.assertTrue;

public class HomePage extends Page {

    @FindBy(css = "div[id='MenuContent'] a[href*='signonForm']")
    private WebElement signInLink;

    @FindBy(css = "div[id='MenuContent'] a[href*='editAccountForm=']")
    private WebElement myAccountLink;

    @FindBy(css = "img[src='../images/fish_icon.gif']")
    private WebElement fishCategoryImage;

    public HomePage() {
        waitForPageToLoad();
        PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getInstance(), TIME_OUT), this);
        waitForElementsToLoad(fishCategoryImage);
    }

    public LoginPage clickOnSignInLink() {
        waitForElementsToLoad(signInLink);
        signInLink.click();
        out.println("Clicked on Sign In link");
        return new LoginPage();
    }

    public HomePage assertThatSignInIsDisplayed() {
        assertTrue("Sign in link was not displayed!", signInLink.isDisplayed());
        out.println("Sign in link was displayed");
        return this;
    }

    public HomePage assertThatMyAccountLinkIsDisplayed() {
        assertTrue("My account link was not displayed!", myAccountLink.isDisplayed());
        out.println("My account link was displayed");
        return this;
    }

    public FishPage clickOnFishCategory() {
        fishCategoryImage.click();
        out.println("Clicked on Fish Category");
        return new FishPage();
    }


}