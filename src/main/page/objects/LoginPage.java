package page.objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import setup.Driver;

import static java.lang.System.out;


public class LoginPage extends Page {

    @FindBy(css = "div[id='Catalog'] a[href*='newAccountForm']")
    private WebElement registerNowLink;

    @FindBy(name = "username")
    private WebElement usernameField;

    @FindBy(name = "password")
    private WebElement passwordField;

    @FindBy(name = "signon")
    private WebElement signOnButton;

    public LoginPage() {
        waitForPageToLoad();
        PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getInstance(), TIME_OUT), this);
        waitForElementsToLoad(registerNowLink);
    }

    public UserRegistrationPage clickOnRegisterLink() {
        registerNowLink.click();
        return new UserRegistrationPage();
    }

    public LoginPage typeIntoUsername(String username) {
        this.usernameField.clear();
        this.usernameField.sendKeys(username);
        out.println("Type into username field " + username);
        return this;
    }

    public LoginPage typeIntoPassword(String password) {
        this.passwordField.clear();
        this.passwordField.sendKeys(password);
        out.println("Type into password field " + password);
        return this;
    }

    public HomePage clickOnLogin() {
        signOnButton.click();
        out.println("Clicked on Login button");
        return new HomePage();
    }


}